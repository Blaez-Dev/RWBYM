package be.bluexin.rwbym.capabilities.ruby;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class RubyStorage implements IStorage<IRuby> {

	@Override
	public NBTBase writeNBT(Capability<IRuby> capability, IRuby instance, EnumFacing side) {
		NBTTagCompound nbt = new NBTTagCompound();
		instance.writeToNBT(nbt);
		return nbt;
	}

	@Override
	public void readNBT(Capability<IRuby> capability, IRuby instance, EnumFacing side, NBTBase nbtIn) {
		NBTTagCompound nbt = (NBTTagCompound)nbtIn;
		instance.readFromNBT(nbt);
	}

}
