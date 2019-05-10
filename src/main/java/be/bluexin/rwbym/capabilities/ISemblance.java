package be.bluexin.rwbym.capabilities;

import be.bluexin.rwbym.capabilities.Aura.AuraProvider;
import be.bluexin.rwbym.capabilities.Aura.IAura;
import be.bluexin.rwbym.utility.RWBYConfig;
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
			boolean flag = aura.useAura(player, usage, false) == 0;
			if (flag) {
				aura.delayRecharge(RWBYConfig.delayticks);
			}
			return flag;
		}
		return player.isCreative();
	}
}
