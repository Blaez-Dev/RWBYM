package io.github.blaezdev.rwbym.capabilities.Maiden.Fall;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class FallProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject (IFall.class)
	public static final Capability<IFall> Fall_CAP = null;
	
	private IFall instance = Fall_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == Fall_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == Fall_CAP ? Fall_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return Fall_CAP.getStorage().writeNBT(Fall_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		Fall_CAP.getStorage().readNBT(Fall_CAP, this.instance, null, nbt);
	}
}
