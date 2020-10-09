package io.github.blaezdev.rwbym.capabilities.Valour;

import io.github.blaezdev.rwbym.Init.RWBYItems;
import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.capabilities.Aura.AuraProvider;
import io.github.blaezdev.rwbym.capabilities.Aura.IAura;
import io.github.blaezdev.rwbym.capabilities.Valour.IValour;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import io.github.blaezdev.rwbym.utility.network.MoveMessage;
import io.github.blaezdev.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.capabilities.Capability;

public class Valour implements IValour {
	
	private static final int MAX_LEVEL = 3;

	private int level = 0;
	
	private int selectedLevel = -1;
	
	private int numShadows = 0;
	
	private int cooldown = 0;
	
	private int cooldowntime = 200;
	
	private float auraUse = RWBYConfig.aura.valourdrainrate;
	
	private int active = 0;
	
	private int airTime = 0;

	private boolean checkValidFlash(EntityPlayer player)
	{
		for(int j = -1; j<=1; ++j)
		{
			for(int k = -1; k <= 1; ++k)
			{
				if(player.world.getBlockState(new BlockPos((int)(player.posX), (int)(player.posY + j), (int)(player.posZ + k))) != Blocks.AIR)// && !this.getValidFlash())
				{
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean onActivate(EntityPlayer player) {


		if(player.onGround)
		{
			if(this.checkValidFlash(player))
			{
				int distance = 6*level;	//(LEVEL * amplifier) + 2?? Whatever you want really.
				IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);
				if(aura.getAmount() > 25F){
					aura.useAura(player,auraUse,false);
					if(player instanceof EntityPlayerMP)
					{
						RWBYNetworkHandler.sendTo(new MoveMessage(distance), (EntityPlayerMP)player);
					}
					//CONSUME ENERGY
					player.world.playSound(null, new BlockPos(player.posX,  player.posY, player.posZ), SoundEvents.WEATHER_RAIN, SoundCategory.PLAYERS, 0.4F, 1.0F);
				}
			}
		}

		return false;
		
	}

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
		return ValourProvider.Valour_CAP;
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
		return "valour";
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
