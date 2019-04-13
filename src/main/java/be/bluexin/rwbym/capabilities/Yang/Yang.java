package be.bluexin.rwbym.capabilities.Yang;

import org.apache.logging.log4j.Level;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.capabilities.Aura.AuraProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.capabilities.Capability;

public class Yang implements IYang {

	private static final int MAX_LEVEL = 3;
	
	private int level = 0;
	
	private int strengthMultiplyer = 6;

	@Override
	public boolean onActivate(EntityPlayer player) {
		return false;
	}

	@Override
	public boolean deActivate(EntityPlayer player) {
		return false;
	}

	@Override
	public void onUpdate(EntityPlayer player) {
		
		float percentage;
		
		if (player.hasCapability(AuraProvider.AURA_CAP, null)) {
			percentage = player.getCapability(AuraProvider.AURA_CAP, null).getPercentage();
		}
		else {
			percentage = Math.min(player.getHealth()/player.getMaxHealth(), 1f);
		}
		
		int strength = Math.round((1f - percentage) * strengthMultiplyer * this.level);
		
		if (strength > 0) {
			
			PotionEffect potioneffect = new PotionEffect(MobEffects.STRENGTH, 60, strength, false, false);
			player.addPotionEffect(potioneffect);
			
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("level", this.level);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.level = nbt.getInteger("level");
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
		return true;
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
	public float[] getColor() {
		float color[] = new float[3];
		color[0] = 0.7F;
		color[1] = 0.6F;
		color[2] = 0F;
		return color;
	}

}
