package io.github.blaez-dev.rwbym.capabilities.Blake;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class BlakeProvider implements ICapabilitySerializable<NBTBase>{
	@CapabilityInject (IBlake.class)
	public static final Capability<IBlake> BLAKE_CAP = null;
		
	private IBlake instance = BLAKE_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == BLAKE_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == BLAKE_CAP ? BLAKE_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return BLAKE_CAP.getStorage().writeNBT(BLAKE_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		BLAKE_CAP.getStorage().readNBT(BLAKE_CAP, this.instance, null, nbt);
	}
}
