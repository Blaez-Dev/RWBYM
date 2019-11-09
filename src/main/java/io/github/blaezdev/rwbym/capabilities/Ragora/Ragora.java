package io.github.blaezdev.rwbym.capabilities.Ragora;

import io.github.blaezdev.rwbym.capabilities.Aura.AuraProvider;
import io.github.blaezdev.rwbym.capabilities.Aura.IAura;
import io.github.blaezdev.rwbym.entity.EntityRagora;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.Random;
import java.util.UUID;

public class Ragora implements IRagora {
	
	private Random rand = new Random();
	
	private static final int MAXLEVEL = 4;
	
	private int level;
	
	private int cooldown;
	
	private int summonTime = 0;
	private int summonMaxTime = 100;
	
	private int maxCooldown = 100;
	private int auraUseInitial = RWBYConfig.aura.ragorainitialsummon;
	private float auraUseUpkeep = RWBYConfig.aura.ragoraupkeep;
	
	private EntityRagora entityragora = null;

	private int selectedLevel = -1;

	@Override
	public boolean onActivate(EntityPlayer player) {
		IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);
		if (aura == null) {
			return false;
		}
		if (!player.world.isRemote && this.summonTime <= 0) {
			if (entityragora == null) {
				if (this.cooldown == 0 && this.useAura(player, auraUseInitial)) {
					entityragora = new EntityRagora(player.world, player);
					this.cooldown = this.maxCooldown;
					this.summonTime = this.summonMaxTime;
					return true;
				}
			}
			else {
				return this.stop(player);
			}
		}
		return false;
	}

	@Override
	public boolean deActivate(EntityPlayer player) {
		return false;
	}
	
	public boolean stop(EntityPlayer player) {
		if (entityragora != null) {
			entityragora.setDead();
			entityragora = null;
			return true;
		}
		return false;
	}

	@Override
	public void onUpdate(EntityPlayer player) {
		
		if (entityragora != null && entityragora.isDead) {
			entityragora = null;
		}
		
		if (this.isActive()) {
			if (!this.useAura(player, (float) (auraUseUpkeep / Math.sqrt(level)))) {
				this.stop(player);
			}
		}
		
		if (this.summonTime > 0) {
			if (player.world.isRemote) {
				Random rand = player.getRNG();
				for (int i = 0; i < (1 - summonTime / 100F) * RWBYConfig.aura.ragorasummonparticles; i++) {
					player.world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX + rand.nextGaussian() * player.width / 2, player.posY + player.height + rand.nextGaussian() * player.width / 2 + player.width, player.posZ + rand.nextGaussian() * player.width / 2, rand.nextGaussian() / 100, 1.0 / 50.0, rand.nextGaussian() / 100);
				}
			}
			else {
				if (this.summonTime == 50) {
					player.world.spawnEntity(entityragora);
				}
				if ((this.summonTime % (rand.nextInt(5) + 5)) == 0) {
					player.world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.PLAYERS, 1, 1);
				}
				if (this.summonTime > 50 && player.getRevengeTarget() != null && player.ticksExisted - player.getRevengeTimer() < this.summonMaxTime - this.summonTime) {
					this.entityragora = null;
					this.summonTime = 0;
				}
			}
			summonTime--;
		}
		
		if (cooldown > 0) {
			this.cooldown--;
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("cooldown", this.cooldown);
		nbt.setInteger("level", this.level);
		nbt.setInteger("summontime", summonTime);
		nbt.setString("UUID", entityragora == null ? "" : entityragora.getCachedUniqueIdString());
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.cooldown = nbt.getInteger("cooldown");
		this.level = nbt.getInteger("level");
		this.summonTime = nbt.getInteger("summontime");
		try {
			this.entityragora = (EntityRagora) FMLCommonHandler.instance().getMinecraftServerInstance().getEntityFromUuid(UUID.fromString(nbt.getString("UUID")));
		}
		catch (Exception e) {
			this.entityragora = null;
		}
	}

	@Override
	public float[] getColor() {
		return new float[] {0.5F, 0F, 1F};
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public void setLevel(int level) {
		if (level <= this.MAXLEVEL) {
			this.level = level;
		}
	}

	@Override
	public Capability getCapability() {
		return RagoraProvider.RAGORA_CAP;
	}

	@Override
	public boolean isActive() {
		return entityragora != null;
	}

	@Override
	public boolean isInvisible() {
		return false;
	}
	
	@Override
	public boolean isMovementBlocked() {
		return this.summonTime > 0;
	}
	
	@Override
	public int getSelectedLevel() {
		return selectedLevel ;
	}
	
	@Override
	public void setSelectedLevel(int level) {
		if (level <= this.level) {
			this.selectedLevel = level;
		}
	}
	
	@Override
	public String toString() {
		return "Ragora";
	}

}
