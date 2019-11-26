package io.github.blaezdev.rwbym.capabilities.Clover;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class CloverProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject (IClover.class)
	public static final Capability<IClover> Clover_CAP = null;
	
	private IClover instance = Clover_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == Clover_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == Clover_CAP ? Clover_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return Clover_CAP.getStorage().writeNBT(Clover_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		Clover_CAP.getStorage().readNBT(Clover_CAP, this.instance, null, nbt);
	}
}
