package io.github.blaez-dev.rwbym.capabilities.Aura;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public interface IAura {
	
	public void onUpdate(EntityPlayer player);
	
	/**
	 * reduces aura by usage amount to a min of 0
	 * 
	 * @param player player reference
	 * @param usage amount of aura to use
	 * @return overflow usage is greater than current aura
	 */
	public float useAura(EntityPlayer player, float usage, boolean overflow);
	
	public void delayRecharge(int ticks);
	
	public float getModifier(EntityPlayer player);
	
	public float getPercentage();
	
	public void addToMax(int amount);
	
	public int getEXPToLevel();
	
	public float getMaxAura();
	
	public void setMaxAura(int amount);
	
	public float getAmount();

	public int getDelay();
	
	public void setAmount(float amount);
	
	public void addAmount(float amount);

	public NBTBase serialize();
	
	public void deserialize(NBTTagCompound nbt);

}
