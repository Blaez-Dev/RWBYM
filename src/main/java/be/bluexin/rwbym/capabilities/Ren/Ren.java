package be.bluexin.rwbym.capabilities.Ren;

import be.bluexin.rwbym.capabilities.Aura.IAura;
import be.bluexin.rwbym.entity.EntityRen;
import be.bluexin.rwbym.entity.EntityWinterBoarbatusk;
import be.bluexin.rwbym.utility.RWBYConfig;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.Level;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.capabilities.Aura.AuraProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.capabilities.Capability;

public class Ren implements IRen {

	private boolean active = false;

	private int Timer = 0;

	private static final int MAX_LEVEL = 3;
	
	private int level = 0;

	private float auraUse = 0.3F;


	@Override
	public boolean onActivate(EntityPlayer player) {
		BlockPos blockpos = (new BlockPos(player));
		switch(this.level) {
			case 1:
			case 2:
			case 3:
				this.active = true;
				this.Timer = 120;
				EntityRen entityren = new EntityRen(player.world);
				entityren.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
				player.world.spawnEntity(entityren);
				return true;
			default:
				return false;
		}
	}


	@Override
	public boolean deActivate(EntityPlayer player) {
		switch(level) {
			case 1:
			case 2:
			case 3:
				return true;
		}
		return false;
	}

	@Override
	public void onUpdate(EntityPlayer player) {
		IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);
		if(this.active  && aura.getPercentage() > 0.01){

			if (!this.useAura(player, auraUse)) return;

			if(aura.getPercentage() == 0){
				this.active = false;
			}

			if (aura != null) {
				aura.delayRecharge(RWBYConfig.delayticks);
			}

		
		int strength = Math.round(this.level * 90);
		
		if (strength > 0) {
			PotionEffect potioneffect = new PotionEffect(MobEffects.INVISIBILITY, strength, 1, true, true);
			player.addPotionEffect(potioneffect);
		}}



		if(aura.getPercentage() < 0.01){
			this.active = false;
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
		return RenProvider.Ren_CAP;
	}

	@Override
	public boolean isActive() {
		return this.active;
	}
	
	@Override
	public String toString() {
		return "Ren";
	}
	
	@Override
	public boolean isInvisible() {
		return false;
	}

	@Override
	public float[] getColor() {
		float color[] = new float[3];
		color[0] = 0F;
		color[1] = 0.3F;
		color[2] = 0F;
		return color;
	}
}
