package be.bluexin.rwbym.capabilities.Ragora;

import be.bluexin.rwbym.capabilities.Aura.AuraProvider;
import be.bluexin.rwbym.capabilities.Aura.IAura;
import be.bluexin.rwbym.entity.EntityRagora;
import be.bluexin.rwbym.entity.EntityWinterBoarbatusk;
import be.bluexin.rwbym.utility.RWBYConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;

public class Ragora implements IRagora {
	
	private static final int MAXLEVEL = 4;
	
	private int level;
	
	private int cooldown;
	
	private int maxCooldown = 100;
	private int auraUseInitial = 10;
	private float auraUseUpkeep = 0.1F;
	
	private EntityRagora entityragora = null;

	@Override
	public boolean onActivate(EntityPlayer player) {
		IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);
		if (aura == null) {
			return false;
		}
		if (!player.world.isRemote){
			if (entityragora == null) {
				if (this.cooldown == 0 && this.useAura(player, auraUseInitial)) {
					entityragora = new EntityRagora(player.world, player);
					player.world.spawnEntity(entityragora);
					this.cooldown = this.maxCooldown;
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
		
		if (this.isActive()) {
			if (!this.useAura(player, (float) (auraUseUpkeep / Math.sqrt(level)))) {
				this.stop(player);
			}
		}
		
		if (cooldown > 0) {
			this.cooldown--;
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("cooldown", this.cooldown);
		nbt.setInteger("level", this.level);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.cooldown = nbt.getInteger("cooldown");
		this.level = nbt.getInteger("level");
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
	public String toString() {
		return "Ragora";
	}

}
