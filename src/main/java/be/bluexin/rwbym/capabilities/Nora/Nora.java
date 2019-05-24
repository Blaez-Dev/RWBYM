package be.bluexin.rwbym.capabilities.Nora;

import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.capabilities.Aura.IAura;
import be.bluexin.rwbym.utility.RWBYConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import org.apache.logging.log4j.Level;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.capabilities.Aura.AuraProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.capabilities.Capability;

public class Nora implements INora {

	private boolean active = false;

	private int Timer = 0;

	private static final int MAX_LEVEL = 3;
	
	private int level = 0;

	private float auraUse = 0.5F;
	

	private int selectedLevel = -1;

	@Override
	public boolean onActivate(EntityPlayer player) {
		switch(this.level) {
			case 1:
			case 2:
			case 3:
				this.active = true;
				this.Timer = 120;
				return true;
			default:
				return false;
		}
	}


	@Override
	public boolean deActivate(EntityPlayer player) {
		return false;
	}

	@Override
	public void onUpdate(EntityPlayer player) {
		IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);
		ItemStack is = player.getHeldItemOffhand();
		if(this.active & is.getItem() == RWBYItems.lightdustcrystal){

			if (!this.useAura(player, auraUse)) return;
				PotionEffect potioneffect = new PotionEffect(MobEffects.STRENGTH, 60, 8, false, false);
				player.addPotionEffect(potioneffect);
				PotionEffect potioneffect2 = new PotionEffect(MobEffects.SPEED, 60, 6, false, false);
				player.addPotionEffect(potioneffect2);


		}
		
		switch(this.level) {
			case 1:
			case 2:
			case 3:
				if (this.Timer > 0) {
					this.Timer--;
				}
				else {
					this.active = false;
				}
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
		return NoraProvider.Nora_CAP;
	}

	@Override
	public boolean isActive() {
		return this.active;
	}
	
	@Override
	public String toString() {
		return "Nora";
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
		color[0] = 0.7F;
		color[1] = 0.6F;
		color[2] = 0F;
		return color;
	}

}
