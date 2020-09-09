package io.github.blaezdev.rwbym.capabilities.itemdata;

import net.minecraft.nbt.NBTTagCompound;

public class ItemData implements IItemData {
	
	private NBTTagCompound data;

	@Override
	public void setData(NBTTagCompound nbt) {
		data = nbt;
	}
	
	@Override
	public NBTTagCompound getData() {
		if (data == null) {
			data = new NBTTagCompound();
		}
		return data;
	}
	
}
