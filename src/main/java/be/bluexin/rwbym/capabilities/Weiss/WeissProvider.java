package be.bluexin.rwbym.capabilities.Weiss;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class WeissProvider implements ICapabilitySerializable<NBTBase> {
	
	@CapabilityInject (IWeiss.class)
	public static final Capability<IWeiss> WEISS_CAP = null;
	
	private IWeiss instance = WEISS_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == WEISS_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == WEISS_CAP ? WEISS_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return WEISS_CAP.getStorage().writeNBT(WEISS_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		WEISS_CAP.getStorage().readNBT(WEISS_CAP, this.instance, null, nbt);
	}

}
