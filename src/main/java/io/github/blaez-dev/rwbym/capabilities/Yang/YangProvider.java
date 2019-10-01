package io.github.blaez-dev.rwbym.capabilities.Yang;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class YangProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject (IYang.class)
	public static final Capability<IYang> YANG_CAP = null;
	
	private IYang instance = YANG_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == YANG_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == YANG_CAP ? YANG_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return YANG_CAP.getStorage().writeNBT(YANG_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		YANG_CAP.getStorage().readNBT(YANG_CAP, this.instance, null, nbt);
	}
}
