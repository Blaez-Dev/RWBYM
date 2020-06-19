package io.github.blaezdev.rwbym.weaponry;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;

public class RWBYGliderItem extends ItemElytra {

	public RWBYGliderItem() {
		super();
	}
	
	@Override
	public EntityEquipmentSlot getEquipmentSlot(ItemStack stack) {
		if (stack.getItem() instanceof ItemElytra) {
			return EntityEquipmentSlot.CHEST;
		}
		else return null;
	}
	
}
