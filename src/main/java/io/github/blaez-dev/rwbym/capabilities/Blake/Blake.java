package io.github.blaez-dev.rwbym.capabilities.Blake;

import io.github.blaez-dev.rwbym.Init.RWBYItems;
import io.github.blaez-dev.rwbym.capabilities.Aura.AuraProvider;
import io.github.blaez-dev.rwbym.capabilities.Aura.IAura;
import io.github.blaez-dev.rwbym.entity.EntityBlake;
import io.github.blaez-dev.rwbym.entity.EntityBlakeFire;
import io.github.blaez-dev.rwbym.entity.EntityBlakeIce;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.capabilities.Capability;

public class Blake implements IBlake {
	
	private static final int MAX_LEVEL = 3;

	private int level = 0;
	
	private int selectedLevel = -1;
	
	private int numShadows = 0;
	
	private int cooldown = 0;
	
	private int cooldowntime = 200;
	
	private float auraUse = 5F;
	
	private int active = 0;
	
	private int airTime = 0;
	
	@Override
	public boolean onActivate(EntityPlayer player) {

		cooldowntime = (int) (200 / (Math.pow(level, 0.5)));

		if (numShadows > 0) {
			
			if (!this.useAura(player, auraUse)) return false;
			if (!player.world.isRemote) {
				spawnShadow(player);
			}
			player.fallDistance = 0;
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
		IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);


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
					if (!this.useAura(player, auraUse)) return;

					if (motion.lengthSquared() > 0.01 && airTime < 8) {
						motion = motion.normalize();
						motion = motion.scale(1.5D);
						if (player.onGround){
							motion = motion.scale(3.5D);
						}else{
							motion = motion.scale(1.0D);
						}
						player.motionX = motion.x;
						player.motionY = motion.y/4;
						player.motionZ = motion.z;
					}
					else if (player.onGround) {
						motion = player.getLookVec();
						motion = motion.scale(2D);
						player.motionX = -motion.x;
						player.motionY = -motion.y;
						player.motionZ = -motion.z;
					}
					else {
						motion = player.getLookVec();
						motion = motion.scale(2D);
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
		
		if (level >  MAX_LEVEL) {
			return;
		}
		
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
	public void spawnShadow(EntityPlayer player) {
		ItemStack is = player.getHeldItemOffhand();
		if(is.getItem() == RWBYItems.firedust){
			BlockPos blockpos = (new BlockPos(player));
			EntityBlakeFire entityBlakeFire = new EntityBlakeFire(player.world);
			entityBlakeFire.moveToBlockPosAndAngles(blockpos, player.rotationYaw, player.rotationPitch);
			entityBlakeFire.setOwner(player);
			player.world.spawnEntity(entityBlakeFire);
			if (!player.capabilities.isCreativeMode) {
				is.shrink(1);
			}
		}else if(is.getItem() == RWBYItems.icedust){
			BlockPos blockpos = (new BlockPos(player));
			EntityBlakeIce entityBlakeIce = new EntityBlakeIce(player.world);
			entityBlakeIce.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
			player.world.spawnEntity(entityBlakeIce);
			if (!player.capabilities.isCreativeMode) {
				is.shrink(1);
			}
		}else {
			BlockPos blockpos = (new BlockPos(player));
			EntityBlake entityBlake = new EntityBlake(player.world);
			entityBlake.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
			player.world.spawnEntity(entityBlake);
		}
	}
	
	@Override
	public String toString() {
		return "Blake";
	}

	@Override
	public float[] getColor() {
		float color[] = new float[3];
		color[0] = 0F;
		color[1] = 0F;
		color[2] = 0F;
		return color;
	}

}
