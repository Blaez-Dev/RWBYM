package io.github.blaezdev.rwbym.capabilities.Ruby;

import io.github.blaezdev.rwbym.Init.RWBYItems;
import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.capabilities.Aura.AuraProvider;
import io.github.blaezdev.rwbym.capabilities.Aura.IAura;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.capabilities.Capability;

import java.util.List;

public class Ruby implements IRuby {

	private static final int MAX_LEVEL = 3;

	private int invisiblityTimer = 0;
			
	private boolean active = false;
	
	private int level1Time = 50;
	
	private int maxUseTime = 360;
	
	private float auraUse = RWBYConfig.aura.rubydrainrate;
	
	// a level greater than 0 will signal that this is the active semblance
	private int level = 0;

	private int selectedLevel = 0;
	
	/**activates the semblance*/
	@Override
	public boolean onActivate(EntityPlayer player) {
		
		//System.out.println("" + this.level);

		switch(this.selectedLevel) {
		case 1:
			if (player.onGround){
				this.active = true;
				return true;
			}
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
		
		switch(selectedLevel) {
		case 1:
		case 2:
		case 3:
			this.active = false;
			return true;
		}
		return false;
	}

	/**sets the invisibility for level one*/
	@Override
	public void setInvisisbility(int time) {
		this.invisiblityTimer = time;
	}
	
	@Override
	public void setInvisisbilityTimer(int time) {
		this.invisiblityTimer = time;
	}

	@Override
	public void setCooldownTimer(int time) {

	}

	/**currently not used*/
	@Override
	public void setPlayerY(double Y) {

	}
	
	/**updates the main logic of the semblance*/
	@Override
	public void onUpdate(EntityPlayer player) {

		IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);

		//System.out.println(cooldown);
		
		if (this.active) {
			
			if (!this.useAura(player, auraUse)) return;
						
			if (player.onGround || this.selectedLevel > 1) {
				//System.out.println(this.cooldown);
				
				player.fallDistance = 0;
				
				boolean flag = player.isElytraFlying();
				
				Vec3d look = player.getLookVec();
				
				//how much speed to keep
				double drag = 0.1D;
				//comment out this line to go back to normal
				player.motionX /= flag ? 0.99 : 0.91;
				player.motionY /= 0.98;
				player.motionZ /= flag ? 0.99 : 0.91;
				if (!flag) player.motionY += 0.08;
				Vec3d motion = look.scale(Math.sqrt(player.motionX * player.motionX + player.motionY * player.motionY + player.motionZ * player.motionZ));
				player.motionX = Math.abs(motion.x) < Math.abs(look.x) ? look.x : player.motionX + (look.x - player.motionX) * drag;
				player.motionY = Math.abs(motion.y) < Math.abs(look.y) ? look.y : player.motionY + (look.y - player.motionY) * drag;
				player.motionZ = Math.abs(motion.z) < Math.abs(look.z) ? look.z : player.motionZ + (look.z - player.motionZ) * drag;
				player.fallDistance = 0;

				if(this.selectedLevel > 2){
					AxisAlignedBB axisalignedbb = player.getEntityBoundingBox().grow(2,2,2);
	
	
					List<Entity> list1 = player.world.getEntitiesWithinAABBExcludingEntity(player, axisalignedbb);
	
					if (!list1.isEmpty())
					{
						double y = Math.pow(player.motionY, 2);
						double x = Math.pow(player.motionX, 2);
						double z = Math.pow(player.motionZ, 2);
	
						double d3 = Math.sqrt(x+y+z);
						float f = (float)d3;
	
						for (Entity entity : list1)
						{
							if (entity instanceof EntityLivingBase) {
								EntityLivingBase entitylivingbase = (EntityLivingBase)entity;
								entitylivingbase.attackEntityFrom(new EntityDamageSource("rose petal", player), f*10);
							}
						}
					}
				}

				for (int i = 0; i < (this.selectedLevel > 1 ? 32 : 2); i++) {
					ItemStack is = player.getHeldItemMainhand();
					ItemStack is2 = player.getHeldItemOffhand();
					ItemStack is3 = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
					ItemStack is4 = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
					ItemStack is5 = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
					boolean flag1 = false;
					if(is.getItem() == RWBYItems.crescentfrost){
						flag1 = true;
					}else if(is.getItem() == RWBYItems.crescentgunfrost){
						flag1 = true;
					}else if(is4.getItem() == RWBYItems.summer1Chest && is5.getItem() == RWBYItems.summer1Legs ||  is4.getItem() == RWBYItems.summer2Chest && is5.getItem() == RWBYItems.summer2Legs && is3.getItem() == RWBYItems.summer2Head || is4.getItem() == RWBYItems.summer1Chest && is5.getItem() == RWBYItems.summer1Legs ||  is4.getItem() == RWBYItems.summer2Chest && is5.getItem() == RWBYItems.summer2Legs && is3.getItem() == RWBYItems.summerhood){
						flag1 = true;
					}else if(is2.getItem() == RWBYItems.crescentfrost){
						flag1 = true;
					}else if(is2.getItem() == RWBYItems.crescentgunfrost){
						flag1 = true;
					}
					RWBYModels.proxy.generateRosepetals(player, flag1);
				}
			}
		}

		switch(this.selectedLevel) {
		case 1:
		case 2:
		case 3:
			break;
		}
	}
	
	@Override
	public int getInvisibilityTimer() {
		return this.invisiblityTimer;
	}
	
	@Override
	public int getCooldown() {
		return 0;
	}

	@Override
	public boolean getInvisibility() {
		switch(this.selectedLevel) {
		case 1:
		case 2:
		case 3:
			return this.active;
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
		return 0;
	}
	
	@Override
	public int getLevel() {
		return this.level;
	}
	
	@Override
	public void setLevel(int level) {
		if (level > MAX_LEVEL) {
			return;
		}
		this.level = level;
		this.selectedLevel = level;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("Itimer", invisiblityTimer);
		nbt.setInteger("level", level);
		nbt.setBoolean("active", active);
		nbt.setInteger("selectedLevel", this.selectedLevel);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.invisiblityTimer = nbt.getInteger("Itimer");
		this.level = nbt.getInteger("level");
		this.active = nbt.getBoolean("active");
		this.selectedLevel = nbt.getInteger("selectedLevel");
	}

	@Override
	public Capability getCapability() {
		return RubyProvider.RUBY_CAP;
	}
	
	@Override
	public String toString() {
		return "Ruby";
	}

	@Override
	public boolean isActive() {
		return this.active;
	}

	@Override
	public boolean isInvisible() {
		switch(this.selectedLevel) {
		case 1: 
			return false;
		case 2:
		case 3:
			return this.active;
		default:
			return false;
		}
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
	public float[] getColor() {
		float color[] = new float[3];
		color[0] = 0.6F;
		color[1] = 0.1F;
		color[2] = 0.1F;
		return color;
	}
	
}
