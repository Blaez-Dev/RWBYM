package be.bluexin.rwbym.capabilities.Weiss;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.*;
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

		if(this.level >4){
			this.level = 4;
		}
		
		switch(this.level) {
			case 1:
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
		case 2:
			if (this.cooldown > 0) {
				return false;
			} 
			else if (player.onGround && !player.world.isRemote){
				BlockPos blockpos = (new BlockPos(player));
				EntityWinterBeowolf entitybeowolf = new EntityWinterBeowolf(player.world);
				entitybeowolf.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
				player.world.spawnEntity(entitybeowolf);
				this.cooldown = 300;
				return true;
			}	
			break;
			case 3:
				if (this.cooldown > 0) {
					return false;
				}
				else if (player.onGround && !player.world.isRemote){
					BlockPos blockpos = (new BlockPos(player));
					EntityWinterUrsa entityWinterUrsa = new EntityWinterUrsa(player.world);
					entityWinterUrsa.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
					player.world.spawnEntity(entityWinterUrsa);
					this.cooldown = 500;
					return true;
				}
				break;
			case 4:
				if (this.cooldown > 0) {
					return false;
				}
				else if (player.onGround && !player.world.isRemote){
					BlockPos blockpos = (new BlockPos(player));
					EntityWinterArmorgeist entityWinterArmorgeist = new EntityWinterArmorgeist(player.world);
					entityWinterArmorgeist.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
					player.world.spawnEntity(entityWinterArmorgeist);
					this.cooldown = 1200;
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
			if (this.cooldown > 0) {
				this.cooldown--;
			}
			case 3:
				if (this.cooldown > 0) {
					this.cooldown--;
				}
			case 4:
				if (this.cooldown > 0) {
					this.cooldown--;
				}
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
