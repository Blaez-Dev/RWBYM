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
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AnimationControllerHammer implements IAnimationController {
	
	private final boolean doubleAction;
	private final ItemGun itemGun;
	
	public AnimationControllerHammer(ItemGun itemGun, boolean doubleAction) {
		this.doubleAction = doubleAction;
		this.itemGun = itemGun;
		MinecraftForge.EVENT_BUS.register(this);
	}

	private boolean onHammerHit(ItemStack stack, World worldIn, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {
		HammerHitEvent event = new HammerHitEvent(stack, worldIn, player, itemSlot, isSelected, nbt, gun);
		return !MinecraftForge.EVENT_BUS.post(event);
	}

	private boolean onHammerDown(ItemStack stack, World worldIn, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {
		HammerDownEvent event = new HammerDownEvent(stack, worldIn, player, itemSlot, isSelected, nbt, gun);
		return !MinecraftForge.EVENT_BUS.post(event);
	}

	@SubscribeEvent
	public void onShootEvent(AnimationControllerShoot.ShootEvent.Post event) {
		if (event.getGun() == this.itemGun) {
			event.getNbt().setBoolean("held", true);
		}
	}

	@Override
	public List<ItemPropertyWrapper> getProperties() {
		List<ItemPropertyWrapper> list = new ArrayList<>();
		
		list.add(IAnimationController.booleanProperty("hammer", true));

		return list;
	}

	@Override
	public void update(ItemStack stack, World worldIn, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {
		boolean flag = player.getHeldItemMainhand().equals(stack);

		if (flag) {
			if (KeyInputHandler.isKeyPressed(KeyInputHandler.KeyPresses.HAMMER)) {
				nbt.setBoolean("hammer", true);
			}
			if (KeyInputHandler.isKeyUnpressed(KeyInputHandler.KeyPresses.HAMMER) && KeyInputHandler.isKeyDown(KeyInputHandler.KeyPresses.SHOOT) && onHammerDown(stack, worldIn, player, itemSlot, isSelected, nbt, gun)) {
				nbt.setBoolean("hammer", false);
			}
			if (nbt.getBoolean("hammer") && KeyInputHandler.isKeyDown(KeyInputHandler.KeyPresses.SHOOT) && !KeyInputHandler.isKeyDown(KeyInputHandler.KeyPresses.HAMMER) && onHammerDown(stack, worldIn, player, itemSlot, isSelected, nbt, gun) && onHammerHit(stack, worldIn, player, itemSlot, isSelected, nbt, gun)) {
				nbt.setBoolean("hammer", false);
			}
			else if (doubleAction && !nbt.getBoolean("hammer") && KeyInputHandler.isKeyPressed(KeyInputHandler.KeyPresses.SHOOT)) {
				nbt.setBoolean("hammer", true);
			}
			if (KeyInputHandler.isKeyUnpressed(KeyInputHandler.KeyPresses.SHOOT)) {
				nbt.setBoolean("held", false);
			}
		}

	}

	public static class HammerHitEvent extends AnimationEvent {
		public HammerHitEvent(ItemStack stack, World world, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {
			super(stack, world, player, itemSlot, isSelected, nbt, gun);
		}
	}

	public static class HammerDownEvent extends AnimationEvent {
		public HammerDownEvent(ItemStack stack, World world, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {
			super(stack, world, player, itemSlot, isSelected, nbt, gun);
		}
	}

}
