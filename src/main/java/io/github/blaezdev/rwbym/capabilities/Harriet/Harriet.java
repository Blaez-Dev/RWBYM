package io.github.blaezdev.rwbym.capabilities.Harriet;

import io.github.blaezdev.rwbym.capabilities.Aura.AuraProvider;
import io.github.blaezdev.rwbym.capabilities.Aura.IAura;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.common.capabilities.Capability;

public class Harriet implements IHarriet {

	private boolean active = false;

	private int Timer = 0;

	private static final int MAX_LEVEL = 5;
	
	private int level = 0;

	private float auraUse = RWBYConfig.aura.harrietdrainrate;

	private int selectedLevel = -1;

	@Override
	public boolean onActivate(EntityPlayer player) {
		switch(this.level) {
			case 1:
			case 2:
			case 3:
			case 4:

			case 5:
				this.active = true;
				this.Timer = 120;
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
			case 4:
			case 5:
				return true;
		}
		return false;
	}

	@Override
	public void onUpdate(EntityPlayer player) {
		int strength = Math.round(this.level * 90);
		int speedmult = RWBYConfig.aura.harrietspeedmult;
		IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);
		if(this.active  && aura.getPercentage() > 0.01){

		if (!this.useAura(player, auraUse*this.level)) return;

		
		if (strength > 0) {
			PotionEffect potioneffect = new PotionEffect(MobEffects.SPEED, strength, this.level*speedmult, true, false);
			player.addPotionEffect(potioneffect);
		}
			if (this.level>2) {
				PotionEffect potioneffect = new PotionEffect(MobEffects.SPEED, strength, this.level*speedmult, true, false);
				player.addPotionEffect(potioneffect);
			}
		}

		switch(this.level) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				if (this.Timer > 0) {
					this.Timer--;
					player.world.spawnParticle(EnumParticleTypes.CRIT, player.posX + 1-player.getRNG().nextInt(2), player.posY + 1.0D, player.posZ + 1-player.getRNG().nextInt(2), 3-player.getRNG().nextInt(6), 3-player.getRNG().nextInt(6), 3-player.getRNG().nextInt(6));
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
		return HarrietProvider.Harriet_CAP;
	}

	@Override
	public boolean isActive() {
		return this.active;
	}
	
	@Override
	public String toString() {
		return "Harriet";
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
		color[0] = 0.3F;
		color[1] = 0.2F;
		color[2] = 0.1F;
		return color;
	}
}
