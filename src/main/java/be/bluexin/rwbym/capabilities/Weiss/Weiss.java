package be.bluexin.rwbym.capabilities.Weiss;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;

public class Weiss implements IWeiss {
	
	
	// a level greater than 0 will signal that this is the active semblance
	
	private static final int MAX_LEVEL = 4;
	
	private int level = 0;
	
	private int cooldown = 0;

	public boolean onActivate(EntityPlayer player) {
		
		switch(this.level) {
		case 1:
			if (this.cooldown > 0) {
				return false;
			}
			else if (player.onGround && !player.world.isRemote){
				if (!this.useAura(player, 5)) return false;
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
				if(!this.useAura(player, 7)) return false;
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
				if (!this.useAura(player, 9)) return false;
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
				if (!this.useAura(player, 12)) return false;
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

		if (this.cooldown > 0) {
			this.cooldown--;
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
		
		if (level > MAX_LEVEL) {
			return;
		}
		
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

	@Override
	public float[] getColor() {
		float color[] = new float[3];
		color[0] = 1F;
		color[1] = 1F;
		color[2] = 1F;
		return color;
	}
}
