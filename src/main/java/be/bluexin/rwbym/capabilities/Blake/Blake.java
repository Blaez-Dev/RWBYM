package be.bluexin.rwbym.capabilities.Blake;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityBeowolf;
import be.bluexin.rwbym.entity.EntityWinterBeowolf;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.capabilities.Capability;

public class Blake implements IBlake {

	private int level = 0;
	
	private int numShadows = 0;
	
	private int cooldown = 0;
	
	private int cooldowntime = 200;
	
	private int active = 0;
	
	private int airTime = 0;
	
	@Override
	public boolean onActivate(EntityPlayer player) {
		
		cooldowntime = (int) (200 / (Math.pow(level, 0.5)));
		
		if (numShadows > 0) {

			if (!player.world.isRemote) {
				spawnShadow(player);
			}
			active = 10;
			numShadows--;
			return true;
		}
		return false;
		
	}

	@Override
	public boolean deActivate(EntityPlayer player) {
		return false;
	}

	@Override
	public void onUpdate(EntityPlayer player) {
		
		if (!player.onGround) {
			airTime++;
		}
		else {
			airTime = 0;
		}
				
		if (active > 0) {
			if (active > 8) {
				if (player.world.isRemote) {
					Vec3d motion = new Vec3d(player.motionX, player.motionY, player.motionZ);
					if (motion.lengthSquared() > 0.01 && airTime < 8) {
						motion = motion.normalize();
						motion = motion.scale(1.5D);
						player.motionX = motion.x;
						player.motionY = motion.y/4;
						player.motionZ = motion.z;
					}
					else {
						motion = player.getLookVec();
						motion = motion.scale(1.5D);
						player.motionX = motion.x;
						player.motionY = motion.y;
						player.motionZ = motion.z;
					}
				}
			}
			active--;
		}
		
		if (numShadows < level) {
			if (cooldown > 0) {
				cooldown--;
			}
			else {
				cooldown = cooldowntime;
				numShadows++;
			}
		}
		if (numShadows > level) {
			numShadows = level;
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("level", level);
		nbt.setInteger("numShadows", numShadows);
		nbt.setInteger("cooldown", cooldown);
		nbt.setInteger("cooldowntime", cooldowntime);
		nbt.setInteger("active", active);
		nbt.setInteger("airTime", airTime);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		level = nbt.getInteger("level");
		numShadows = nbt.getInteger("numShadows");
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
		this.level = level;
	}

	@Override
	public Capability getCapability() {
		return BlakeProvider.BLAKE_CAP;
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
	public void spawnShadow(EntityPlayer player) {
		// TODO for Blaez to spawn a shadow player (this function is already check to be called on server only)
		
		BlockPos blockpos = (new BlockPos(player));
		EntityBeowolf entitybeowolf = new EntityBeowolf(player.world);
		entitybeowolf.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
		player.world.spawnEntity(entitybeowolf);
	}
	
	@Override
	public String toString() {
		return "Blake";
	}

}
