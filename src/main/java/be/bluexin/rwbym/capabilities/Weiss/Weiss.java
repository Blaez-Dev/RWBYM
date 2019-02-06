package be.bluexin.rwbym.capabilities.Weiss;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityBeowolf;
import be.bluexin.rwbym.entity.EntityWinterBeowolf;
import be.bluexin.rwbym.entity.EntityWinterBoarbatusk;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;

public class Weiss implements IWeiss {
	
	
	// a level greater than 0 will signal that this is the active semblance
	private int level = 0;
	
	private int cooldown = 0;

	public boolean onActivate(EntityPlayer player) {
		
		RWBYModels.LOGGER.log(RWBYModels.debug, "Weiss Activated");
		
		switch(this.level) {
		case 1:
			if (this.cooldown > 0) {
				return false;
			} 
			else if (player.onGround && !player.world.isRemote){
				BlockPos blockpos = (new BlockPos(player));
				EntityWinterBeowolf entitybeowolf = new EntityWinterBeowolf(player.world);
				entitybeowolf.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
				player.world.spawnEntity(entitybeowolf);
				this.cooldown = 100;
				return true;
			}	
			break;
		case 2:
			if (this.cooldown > 0) {
				return false;
			}
			else if (player.onGround && !player.world.isRemote){
				BlockPos blockpos = (new BlockPos(player));
				EntityWinterBoarbatusk entityWinterBoarbatusk = new EntityWinterBoarbatusk(player.world);
				entityWinterBoarbatusk.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
				player.world.spawnEntity(entityWinterBoarbatusk);
				this.cooldown = 100;
				return true;
			}
			break;
			
		default:
			return false;
		}
		
		return false;
	}
	
	public boolean deActivate(EntityPlayer player) {
		return false;
	}

	@Override
	public void onUpdate(EntityPlayer player) {
		
		switch(this.level) {
		case 1:
			if (this.cooldown > 0) {
				this.cooldown--;
			}
		case 2:
			break;
		default:
			break;
		}
		
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("level", level);
		nbt.setInteger("cooldown", cooldown);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.level = nbt.getInteger("level");
		this.cooldown = nbt.getInteger("cooldown");
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public Capability getCapability() {
		return WeissProvider.WEISS_CAP;
	}
	
	@Override
	public String toString() {
		return "Weiss";
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public boolean isActive() {
		return false;
	}
	
	@Override
	public boolean isInvisible() {
		return false;
	}
}
