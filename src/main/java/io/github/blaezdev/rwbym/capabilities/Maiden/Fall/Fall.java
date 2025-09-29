package io.github.blaezdev.rwbym.capabilities.Maiden.Fall;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.capabilities.Aura.AuraProvider;
import io.github.blaezdev.rwbym.capabilities.Aura.IAura;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;

public class Fall implements IFall {

	private boolean active = false;

	private int Timer = 0;

	private static final int MAX_LEVEL = 3;
	
	private int level = 0;

	private float auraUse = 0;

	private int selectedLevel = -1;

	@Override
	public boolean onActivate(EntityPlayer player) {
		BlockPos blockpos = (new BlockPos(player));
		switch(this.level) {
			case 1:
			case 2:

			case 3:
				this.active = true;
				return true;
			default:
				return false;
		}
	}


	@Override
	public boolean deActivate(EntityPlayer player) {
		switch(level) {
			case 1:
				RWBYModels.LOGGER.log(RWBYModels.updtes,"I'm the Fall Maiden");
			case 2:
			case 3:
				this.active = false;
				return true;
		}
		return false;
	}

	@Override
	public void onUpdate(EntityPlayer player) {
		int strength = Math.round(this.level * 90);
		IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);
		BlockPos blockpos = player.getPosition();
		if(this.active  && aura.getPercentage() > 0.01){

		if (!this.useAura(player, auraUse)) return;

		}

		switch(this.level) {
			case 1:
			case 2:
			case 3:
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
		return FallProvider.Fall_CAP;
	}

	@Override
	public boolean isActive() {
		return this.active;
	}
	
	@Override
	public String toString() {
		return "Fall";
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
		color[0] = 0.0F;
		color[1] = 0.0F;
		color[2] = 0.0F;
		return color;
	}
}




//8AA2B4 Colour