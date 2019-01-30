package be.bluexin.rwbym.capabilities.Weiss;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class WeissStorage implements IStorage<IWeiss> {

	@Override
	public NBTBase writeNBT(Capability<IWeiss> capability, IWeiss instance, EnumFacing side) {
		NBTTagCompound nbt = new NBTTagCompound();
		instance.writeToNBT(nbt);
		return nbt;
	}

	@Override
	public void readNBT(Capability<IWeiss> capability, IWeiss instance, EnumFacing side, NBTBase nbtBase) {
		NBTTagCompound nbt = (NBTTagCompound) nbtBase;
		instance.readFromNBT(nbt);
	}

}
