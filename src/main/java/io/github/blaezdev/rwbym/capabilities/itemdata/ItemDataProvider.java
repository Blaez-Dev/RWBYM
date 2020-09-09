package io.github.blaezdev.rwbym.capabilities.itemdata;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ItemDataProvider implements ICapabilitySerializable<NBTBase> {
	
	@CapabilityInject(IItemData.class)
	public static final Capability<IItemData> ITEMDATA_CAP = null;
	
	private IItemData instance = ITEMDATA_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == ITEMDATA_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return hasCapability(capability, facing) ? ITEMDATA_CAP.cast(instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return instance.getData();
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		instance.setData((NBTTagCompound) nbt);
	}

}
