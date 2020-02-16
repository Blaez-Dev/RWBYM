package io.github.blaezdev.rwbym.capabilities.Blank;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class BlankProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject (IBlank.class)
	public static final Capability<IBlank> Blank_CAP = null;
	
	private IBlank instance = Blank_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == Blank_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == Blank_CAP ? Blank_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return Blank_CAP.getStorage().writeNBT(Blank_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		Blank_CAP.getStorage().readNBT(Blank_CAP, this.instance, null, nbt);
	}
}
