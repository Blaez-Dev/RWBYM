package io.github.blaezdev.rwbym.capabilities.Hazel;

import io.github.blaezdev.rwbym.capabilities.Hazel.IHazel;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class HazelProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject (IHazel.class)
	public static final Capability<IHazel> Hazel_CAP = null;

	private IHazel instance = Hazel_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == Hazel_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == Hazel_CAP ? Hazel_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return Hazel_CAP.getStorage().writeNBT(Hazel_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		Hazel_CAP.getStorage().readNBT(Hazel_CAP, this.instance, null, nbt);
	}

}
