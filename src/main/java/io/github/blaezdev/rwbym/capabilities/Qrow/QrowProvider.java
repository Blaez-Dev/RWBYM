package io.github.blaezdev.rwbym.capabilities.Qrow;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class QrowProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject (IQrow.class)
	public static final Capability<IQrow> Qrow_CAP = null;
	
	private IQrow instance = Qrow_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == Qrow_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == Qrow_CAP ? Qrow_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return Qrow_CAP.getStorage().writeNBT(Qrow_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		Qrow_CAP.getStorage().readNBT(Qrow_CAP, this.instance, null, nbt);
	}
}
