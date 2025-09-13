package io.github.blaezdev.rwbym.capabilities.Ren;

import io.github.blaezdev.rwbym.capabilities.Aura.AuraProvider;
import io.github.blaezdev.rwbym.capabilities.Aura.IAura;
import io.github.blaezdev.rwbym.entity.EntityRen;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;

import java.util.List;

public class Ren implements IRen {

	private boolean active = false;

	private int Timer = 0;

	private static final int MAX_LEVEL = 3;
	
	private int level = 0;

	private float auraUse = RWBYConfig.aura.rendrainrate;

	private int selectedLevel = -1;

	@Override
	public boolean onActivate(EntityPlayer player) {
		BlockPos blockpos = (new BlockPos(player));
		switch(this.level) {
			case 1:
			case 2:

			case 3:
				this.active = true;
				this.Timer = 120;
				EntityRen entityren = new EntityRen(player.world);
				entityren.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
				player.world.spawnEntity(entityren);
				return true;
			default:
				return false;
		}
	}


	@Override
	public boolean deActivate(EntityPlayer player) {
		switch(level) {
			case 1:
			case 2:
			case 3:
				return true;
		}
		return false;
	}

	@Override
	public void onUpdate(EntityPlayer player) {

		int strength = Math.round(this.level * 90);
		IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);
		if(this.active  && aura.getPercentage() > 0.01){

		if (!this.useAura(player, auraUse)) return;

		
		if (strength > 0) {
			PotionEffect potioneffect = new PotionEffect(MobEffects.INVISIBILITY, strength, 1, true, false);
			player.addPotionEffect(potioneffect);
			if(this.level > 1){
				AxisAlignedBB axisalignedbb2 = player.getEntityBoundingBox().grow(4,4,4);
				List<EntityPlayer> list2 = player.world.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb2);
				if(list2.contains(player)){list2.remove(player);}
				if (!list2.isEmpty()) {
					EntityPlayer victim = list2.get(player.world.rand.nextInt(list2.size()));
					PotionEffect potioneffect1 = new PotionEffect(MobEffects.INVISIBILITY, strength, 1, true, false);
					victim.addPotionEffect(potioneffect1);
				}
			}
		}
		}

		switch(this.level) {
			case 1:
			case 2:
			case 3:
				if (this.Timer > 0) {
					this.Timer--;
				}
				else {
					this.active = false;
				}
				break;
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("timer", Timer);
		nbt.setInteger("level", level);
		nbt.setBoolean("active", active);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.Timer = nbt.getInteger("timer");
		this.level = nbt.getInteger("level");
		this.active = nbt.getBoolean("active");
	}

	@Override
	public int getLevel() {
		return this.level ;
	}

	@Override
	public void setLevel(int level) {
		
		if (level > MAX_LEVEL) {
			return;
		}
		
		this.level = level;
	}

	@Override
	public Capability getCapability() {
		return RenProvider.Ren_CAP;
	}

	@Override
	public boolean isActive() {
		return this.active;
	}
	
	@Override
	public String toString() {
		return "Ren";
	}
	
	@Override
	public boolean isInvisible() {
		return false;
	}
	
	@Override
	public boolean isMovementBlocked() {
		return false;
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
	public float[] getColor() {
		float color[] = new float[3];
		color[0] = 0F;
		color[1] = 0.3F;
		color[2] = 0F;
		return color;
	}
}
