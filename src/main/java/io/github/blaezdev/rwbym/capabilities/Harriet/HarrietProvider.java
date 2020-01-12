package io.github.blaezdev.rwbym.capabilities.Harriet;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class HarrietProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject (IHarriet.class)
	public static final Capability<IHarriet> Harriet_CAP = null;
	
	private IHarriet instance = Harriet_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == Harriet_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == Harriet_CAP ? Harriet_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return Harriet_CAP.getStorage().writeNBT(Harriet_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		Harriet_CAP.getStorage().readNBT(Harriet_CAP, this.instance, null, nbt);
	}
}
