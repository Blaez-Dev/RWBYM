package be.bluexin.rwbym.capabilities.ruby;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.client.particle.RosePetal;
import be.bluexin.rwbym.entity.EntityBeowolf;
import be.bluexin.rwbym.entity.EntityMutantDeathStalker;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class Ruby implements IRuby {

	private int invisiblityTimer = 0;
	
	private int cooldown = 0;
	
	private double playerY = -1;
	
	private boolean active = false;
	
	private int level = 0;
	
	/**activates the semblance*/
	@Override
	public boolean activate(EntityPlayer player) {
		
		switch(this.level) {
			case 1:
				if (this.cooldown > 0) {
					return false;
				}
				else {
					if (player.onGround){
						this.setInvisisbility(50);
						this.active = true;
					}
					return true;
				}
			case 2:
				if (this.cooldown <= 0) {
					this.active = false;
					return false;
				}
				if (this.cooldown >= 30) {
					this.active = true;
					return true;
				}
				return false;
			case 3:
				if (this.cooldown > 0) {
					return false;
				} 
				else if (player.onGround && !player.world.isRemote){
					BlockPos blockpos = (new BlockPos(player));
					EntityBeowolf entitybeowolf = new EntityBeowolf(player.world);
					entitybeowolf.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
					player.world.spawnEntity(entitybeowolf);
					this.setInvisisbility(50);
					return true;
				}
			default:
				return false;
		}
	}

	/**sets the invisibility and the cooldown for level one*/
	@Override
	public void setInvisisbility(int time) {
		this.invisiblityTimer = time;
		this.cooldown = time * 3;
	}
	
	@Override
	public void setInvisisbilityTimer(int time) {
		this.invisiblityTimer = time;
	}

	@Override
	public void setCooldownTimer(int time) {
		this.cooldown = time;
	}
	
	/**can cancel the semblance by passing false, but not for level one*/
	@Override
	public void setActiveStatus(boolean status) {
		if (this.level > 1) {
			this.active = status;
		}
	}

	/**currently not used*/
	@Override
	public void setPlayerY(double Y) {
		this.playerY = Y;
	}
	
	/**updates the main logic of the semblance*/
	@Override
	public void updateInvisisbility(EntityPlayer player) {

		//System.out.println(cooldown);
		
		if (this.active) {
			if (player.world.isRemote) {
				if (player.onGround || this.level > 1) {
					//System.out.println(this.cooldown);
					Vec3d look = player.getLookVec();
					player.motionX = look.x;
					player.motionZ = look.z;
					player.motionY = look.y * 2;
					player.fallDistance = 0;
					for (int i = 0; i < (this.level > 1 ? 32 : 2); i++) {
						RWBYModels.proxy.generateRosepetals(player);
					}
				}
			}
		}

		switch(this.level) {
			case 1:
				if (this.invisiblityTimer > 0) {
					this.invisiblityTimer--;
				}
				if (this.invisiblityTimer < 1) {
					this.active = false;
				}
				if (this.cooldown > 0) {
					this.cooldown--;
				}
				break;
			case 2:
				if (!this.active && this.cooldown < 360) {
					this.cooldown++;
				}
				if (this.active) {
					this.cooldown -= 3;
				}
				if (this.cooldown < 1) {
					this.active = false;
				}
				break;
			case 3:
				if (this.invisiblityTimer != 0) {
					this.invisiblityTimer = 0;
				}
				
				if (this.cooldown > 0) {
					cooldown--;
				}
		}
	}
	
	@Override
	public int getInvisibilityTimer() {
		return this.invisiblityTimer;
	}
	
	@Override
	public int getCooldown() {
		return this.cooldown;
	}

	@Override
	public boolean getInvisibility() {
		switch(this.level) {
		case 1: 
			return false;
		case 2:
			return this.active ? true : false;
		default:
			return false;
		}
	}
	
	@Override
	public boolean getActiveStatus() {
		return this.active;
	}

	@Override
	public double getPlayerY() {
		return this.playerY;
	}

}
