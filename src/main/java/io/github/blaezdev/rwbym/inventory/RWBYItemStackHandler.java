package io.github.blaezdev.rwbym.inventory;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

import java.util.List;

public class RWBYItemStackHandler extends ItemStackHandler {
	
	private List<String> validItems;
	
	public RWBYItemStackHandler(int slots, List<String> validItems) {
		super(slots);
		this.validItems = validItems;
	}
	
	@Override
	public boolean isItemValid(int slot, ItemStack stack) {
		return validItems.contains(stack.getItem().getRegistryName().toString());
	}

}
