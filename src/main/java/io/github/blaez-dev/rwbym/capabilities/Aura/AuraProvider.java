package io.github.blaez-dev.rwbym.capabilities.Aura;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class AuraProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject(IAura.class)
	public static final Capability<IAura> AURA_CAP = null;
	
	private IAura instance = AURA_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == AURA_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return hasCapability(capability, facing) ? AURA_CAP.<T> cast(instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return instance.serialize();
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		instance.deserialize((NBTTagCompound)nbt);
	}

}
