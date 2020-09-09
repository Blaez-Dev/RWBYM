package io.github.blaezdev.rwbym.capabilities.itemdata;

import net.minecraft.nbt.NBTTagCompound;

public interface IItemData {

	public void setData(NBTTagCompound nbt);
	
	public NBTTagCompound getData();
	
}
