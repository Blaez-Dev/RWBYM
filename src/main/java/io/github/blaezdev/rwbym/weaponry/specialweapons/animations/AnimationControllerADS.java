package io.github.blaezdev.rwbym.weaponry.specialweapons.animations;

import java.util.ArrayList;
import java.util.List;

import io.github.blaezdev.rwbym.KeyInputHandler;
import io.github.blaezdev.rwbym.weaponry.specialweapons.ItemPropertyWrapper;
import io.github.blaezdev.rwbym.weaponry.specialweapons.guns.ItemGun;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class AnimationControllerADS implements IAnimationController {

	@Override
	public List<ItemPropertyWrapper> getProperties() {
		List<ItemPropertyWrapper> list= new ArrayList<>();
		
		list.add(IAnimationController.booleanProperty("ads", false));
		
		return list;
	}

	@Override
	public void update(ItemStack stack, World worldIn, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {
		boolean flag = player.getHeldItemMainhand().equals(stack);
		nbt.setBoolean("ads", flag && KeyInputHandler.isKeyDown(KeyInputHandler.KeyPresses.ADS));
	}

}
