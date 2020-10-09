package io.github.blaezdev.rwbym.capabilities.Valour;

import io.github.blaezdev.rwbym.capabilities.Valour.IValour;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ValourProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject (IValour.class)
	public static final Capability<IValour> Valour_CAP = null;

	private IValour instance = Valour_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == Valour_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == Valour_CAP ? Valour_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return Valour_CAP.getStorage().writeNBT(Valour_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		Valour_CAP.getStorage().readNBT(Valour_CAP, this.instance, null, nbt);
	}

}
