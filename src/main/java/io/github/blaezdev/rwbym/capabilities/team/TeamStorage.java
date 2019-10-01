package io.github.blaezdev.rwbym.capabilities.team;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class TeamStorage implements IStorage<ITeam> {

	@Override
	public NBTBase writeNBT(Capability<ITeam> capability, ITeam instance, EnumFacing side) {
		return instance.serialize();
	}

	@Override
	public void readNBT(Capability<ITeam> capability, ITeam instance, EnumFacing side, NBTBase nbt) {
		instance.deserialize((NBTTagCompound) nbt);
	}

}
