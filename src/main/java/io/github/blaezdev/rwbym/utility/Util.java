package io.github.blaezdev.rwbym.utility;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Util {
	public static NBTTagCompound getOrCreateTag(ItemStack stack) {
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt == null) {
			nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
		}
		return nbt;
	}
}
