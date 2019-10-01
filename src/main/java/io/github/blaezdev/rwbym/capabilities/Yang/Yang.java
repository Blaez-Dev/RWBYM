package io.github.blaezdev.rwbym.capabilities.Yang;

import io.github.blaezdev.rwbym.capabilities.Aura.AuraProvider;
import io.github.blaezdev.rwbym.capabilities.Aura.IAura;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.capabilities.Capability;

public class Yang implements IYang {

	private boolean active = false;

	private int Timer = 0;

	private static final int MAX_LEVEL = 3;
	
	private int level = 0;

	private float auraUse = 0.3F;
	
	private int strengthMultiplyer = 6;

	private int selectedLevel = -1;

	@Override
	public boolean onActivate(EntityPlayer player) {
		switch(this.level) {
			case 1:
			case 2:
			case 3:
				this.active = true;
				this.Timer = 120;
				return true;
			default:
				return false;
		}
	}


	@Override
	public boolean deActivate(EntityPlayer player) {
		return false;
	}

	@Override
	public void onUpdate(EntityPlayer player) {
		IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);
		if(this.active){

			if (!this.useAura(player, auraUse)) return;

			float percentage;
			
			if (player.hasCapability(AuraProvider.AURA_CAP, null)) {
				percentage = player.getCapability(AuraProvider.AURA_CAP, null).getPercentage();
			}
			else {
				percentage = Math.min(player.getHealth()/player.getMaxHealth(), 1f);
			}
			
			int strength = Math.round((1f - percentage) * strengthMultiplyer * 2 * this.level);
			
			if (strength > 0) {
				
				PotionEffect potioneffect = new PotionEffect(MobEffects.STRENGTH, 60, strength, false, false);
				player.addPotionEffect(potioneffect);
				
			}


		}else 	
			
		if(!this.active){

			float percentage;

			if (player.hasCapability(AuraProvider.AURA_CAP, null)) {
				percentage = player.getCapability(AuraProvider.AURA_CAP, null).getPercentage();
			}
			else {
				percentage = Math.min(player.getHealth()/player.getMaxHealth(), 1f);
			}

			int strength = Math.round((1f - percentage) * strengthMultiplyer / 2  * this.level);

			if (strength > 0) {

				PotionEffect potioneffect = new PotionEffect(MobEffects.STRENGTH, 60, strength, false, false);
				player.addPotionEffect(potioneffect);

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
		return YangProvider.YANG_CAP;
	}

	@Override
	public boolean isActive() {
		return this.active;
	}
	
	@Override
	public String toString() {
		return "Yang";
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
		color[0] = 0.7F;
		color[1] = 0.6F;
		color[2] = 0F;
		return color;
	}

}
