package io.github.blaezdev.rwbym.capabilities.Jaune;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class JauneProvider implements ICapabilitySerializable<NBTBase> {
	
	@CapabilityInject(IJaune.class)
	public static final Capability<IJaune> JAUNE_CAP = null;
	
	private IJaune instance = JAUNE_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == JAUNE_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return hasCapability(capability, facing) ? JAUNE_CAP.<T> cast(instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return JAUNE_CAP.getStorage().writeNBT(JAUNE_CAP, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		JAUNE_CAP.getStorage().readNBT(JAUNE_CAP, instance, null, nbt);
	}

}
