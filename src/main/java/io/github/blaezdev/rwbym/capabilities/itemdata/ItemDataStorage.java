package io.github.blaezdev.rwbym.capabilities.itemdata;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ItemDataStorage implements IStorage<IItemData> {

	@Override
	public NBTBase writeNBT(Capability<IItemData> capability, IItemData instance, EnumFacing side) {
		return null;
	}

	@Override
	public void readNBT(Capability<IItemData> capability, IItemData instance, EnumFacing side, NBTBase nbt) {
		// TODO Auto-generated method stub
		
	}

}
