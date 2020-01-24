package io.github.blaezdev.rwbym.capabilities.Pyrrha;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PyrrhaProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject (IPyrrha.class)
	public static final Capability<IPyrrha> Pyrrha_CAP = null;
	
	private IPyrrha instance = Pyrrha_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == Pyrrha_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == Pyrrha_CAP ? Pyrrha_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return Pyrrha_CAP.getStorage().writeNBT(Pyrrha_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		Pyrrha_CAP.getStorage().readNBT(Pyrrha_CAP, this.instance, null, nbt);
	}
}
