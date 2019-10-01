package io.github.blaezdev.rwbym.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public abstract class SemblanceStorage<T extends ISemblance> implements IStorage<T>{

	@Override
	public NBTBase writeNBT(Capability<T> capability, T instance, EnumFacing side) {
		NBTTagCompound nbt = new NBTTagCompound();
		instance.writeToNBT(nbt);
		return nbt;
	}

	@Override
	public void readNBT(Capability<T> capability, T instance, EnumFacing side, NBTBase nbtBase) {
		NBTTagCompound nbt = (NBTTagCompound) nbtBase;
		instance.readFromNBT(nbt);
	}
}
