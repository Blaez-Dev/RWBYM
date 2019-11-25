package io.github.blaezdev.rwbym.capabilities.Lysette;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class LysetteProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject (ILysette.class)
	public static final Capability<ILysette> Lysette_CAP = null;
	
	private ILysette instance = Lysette_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == Lysette_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == Lysette_CAP ? Lysette_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return Lysette_CAP.getStorage().writeNBT(Lysette_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		Lysette_CAP.getStorage().readNBT(Lysette_CAP, this.instance, null, nbt);
	}
}
