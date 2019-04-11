package be.bluexin.rwbym.capabilities;

import be.bluexin.rwbym.capabilities.Aura.AuraProvider;
import be.bluexin.rwbym.capabilities.Aura.IAura;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.Capability;

public interface ISemblance {
	
	public boolean onActivate(EntityPlayer player);
	
	public boolean deActivate(EntityPlayer player);
	
	public void onUpdate(EntityPlayer player);
	
	public void writeToNBT(NBTTagCompound nbt);
	
	public void readFromNBT(NBTTagCompound nbt);
	
	public float[] getColor();

	public int getLevel();
	
	public void setLevel(int level);

	public Capability getCapability();

	public boolean isActive();
	
	public boolean isInvisible();
	
	@Override
	public String toString();
	
	public default boolean useAura(EntityPlayer player, float usage) {
		if(!player.isCreative() && player.hasCapability(AuraProvider.AURA_CAP, null)) {
			IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);
			return aura.useAura(player, usage) == 0;
		}
		return player.isCreative();
	}
}
