package io.github.blaezdev.rwbym.capabilities.Ruby;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class RubyProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject (IRuby.class)
	public static final Capability<IRuby> RUBY_CAP = null;
		
	private IRuby instance = RUBY_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == RUBY_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == RUBY_CAP ? RUBY_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return RUBY_CAP.getStorage().writeNBT(RUBY_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		RUBY_CAP.getStorage().readNBT(RUBY_CAP, this.instance, null, nbt);
	}

}