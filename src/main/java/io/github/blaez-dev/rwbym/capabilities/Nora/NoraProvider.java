package io.github.blaez-dev.rwbym.capabilities.Nora;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class NoraProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject (INora.class)
	public static final Capability<INora> Nora_CAP = null;
	
	private INora instance = Nora_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == Nora_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == Nora_CAP ? Nora_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return Nora_CAP.getStorage().writeNBT(Nora_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		Nora_CAP.getStorage().readNBT(Nora_CAP, this.instance, null, nbt);
	}
}
