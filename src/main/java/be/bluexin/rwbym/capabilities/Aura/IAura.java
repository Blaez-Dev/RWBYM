package be.bluexin.rwbym.capabilities.Aura;

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
	public float useAura(EntityPlayer player, float usage);
	
	public void delayRecharge(int ticks);
	
	public float getPercentage();

	public NBTBase serialize();
	
	public void deserialize(NBTTagCompound nbt);

}
