package io.github.blaezdev.rwbym.capabilities.Aura;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class AuraStorage implements IStorage<IAura>{

	@Override
	public NBTBase writeNBT(Capability<IAura> capability, IAura instance, EnumFacing side) {
		return instance.serialize();
	}

	@Override
	public void readNBT(Capability<IAura> capability, IAura instance, EnumFacing side, NBTBase nbt) {
		instance.deserialize((NBTTagCompound)nbt);
	}

}
