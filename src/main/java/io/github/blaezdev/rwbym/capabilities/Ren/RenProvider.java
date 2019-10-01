package io.github.blaezdev.rwbym.capabilities.Ren;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class RenProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject (IRen.class)
	public static final Capability<IRen> Ren_CAP = null;
	
	private IRen instance = Ren_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == Ren_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == Ren_CAP ? Ren_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return Ren_CAP.getStorage().writeNBT(Ren_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		Ren_CAP.getStorage().readNBT(Ren_CAP, this.instance, null, nbt);
	}
}
