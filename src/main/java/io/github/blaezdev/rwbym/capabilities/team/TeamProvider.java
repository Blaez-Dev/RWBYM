package io.github.blaezdev.rwbym.capabilities.team;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class TeamProvider implements ICapabilitySerializable<NBTBase> {
	
	@CapabilityInject (ITeam.class)
	public static final Capability<ITeam> TEAM_CAP = null;
	
	public ITeam instance = TEAM_CAP.getDefaultInstance();
	
	public TeamProvider(World world) {
		instance.setWorld(world);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == TEAM_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return this.hasCapability(capability, facing) ? TEAM_CAP.<T>cast(instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return TEAM_CAP.getStorage().writeNBT(TEAM_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		TEAM_CAP.getStorage().readNBT(TEAM_CAP, this.instance, null, nbt);
	}

}
