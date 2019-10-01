package io.github.blaez-dev.rwbym.capabilities.Ragora;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class RagoraProvider implements ICapabilitySerializable<NBTBase>{
	@CapabilityInject (IRagora.class)
	public static final Capability<IRagora> RAGORA_CAP = null;
		
	private IRagora instance = RAGORA_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == RAGORA_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == RAGORA_CAP ? RAGORA_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return RAGORA_CAP.getStorage().writeNBT(RAGORA_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		RAGORA_CAP.getStorage().readNBT(RAGORA_CAP, this.instance, null, nbt);
	}
}
