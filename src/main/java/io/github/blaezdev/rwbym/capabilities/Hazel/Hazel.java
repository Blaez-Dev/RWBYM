package io.github.blaezdev.rwbym.capabilities.Hazel;

import io.github.blaezdev.rwbym.capabilities.Hazel.IHazel;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.Capability;

public class Hazel implements IHazel {
	
	private static final int MAX_LEVEL = 3;

	private int level = 0;
	
	private int selectedLevel = -1;
	
	private int numShadows = 0;
	
	private int cooldown = 0;
	
	private int cooldowntime = 200;
	
	private float auraUse = RWBYConfig.aura.valourdrainrate;
	
	private int active = 0;
	
	private int airTime = 0;


	
	@Override
	public boolean onActivate(EntityPlayer player) {return false;}

	@Override
	public boolean deActivate(EntityPlayer player) {
		return false;
	}

	@Override
	public void onUpdate(EntityPlayer player) {

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("level", level);
		nbt.setInteger("cooldown", cooldown);
		nbt.setInteger("cooldowntime", cooldowntime);
		nbt.setInteger("active", active);
		nbt.setInteger("airTime", airTime);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		level = nbt.getInteger("level");;
		cooldown = nbt.getInteger("cooldown");
		cooldowntime = nbt.getInteger("cooldowntime");
		active = nbt.getInteger("active");
		airTime = nbt.getInteger("airTime");
	}





	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public void setLevel(int level) {
		
		if (level >  MAX_LEVEL) {
			return;
		}
		
		this.level = level;
	}

	@Override
	public Capability getCapability() {
		return HazelProvider.Hazel_CAP;
	}

	@Override
	public boolean isActive() {
		return false;
	}

	@Override
	public boolean isInvisible() {
		return active > 0;
	}
	
	@Override
	public boolean isMovementBlocked() {
		return false;
	}
	
	@Override
	public int getSelectedLevel() {
		return selectedLevel;
	}
	
	@Override
	public void setSelectedLevel(int level) {
		if (level <= this.level) {
			this.selectedLevel = level;
		}
	}


	
	@Override
	public String toString() {
		return "hazel";
	}

	@Override
	public float[] getColor() {
		float color[] = new float[3];
		color[0] = 0F;
		color[1] = 0.5F;
		color[2] = 0.25F;
		return color;
	}

}
