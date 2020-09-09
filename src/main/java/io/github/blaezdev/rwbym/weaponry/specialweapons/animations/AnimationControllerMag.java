package io.github.blaezdev.rwbym.weaponry.specialweapons.animations;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.apache.commons.lang3.tuple.Pair;

import io.github.blaezdev.rwbym.KeyInputHandler;
import io.github.blaezdev.rwbym.RWBYSoundHandler.Sound;
import io.github.blaezdev.rwbym.capabilities.itemdata.ItemDataProvider;
import io.github.blaezdev.rwbym.utility.Util;
import io.github.blaezdev.rwbym.utility.network.MessageAddToInventory;
import io.github.blaezdev.rwbym.utility.network.MessagePlaySound;
import io.github.blaezdev.rwbym.utility.network.RWBYNetworkHandler;
import io.github.blaezdev.rwbym.weaponry.specialweapons.ItemPropertyWrapper;
import io.github.blaezdev.rwbym.weaponry.specialweapons.guns.ItemGun;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class AnimationControllerMag implements IAnimationController {
	
	public static class MagAddEvent extends AnimationEvent {

		public MagAddEvent(ItemStack stack, World world, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {
			super(stack, world, player, itemSlot, isSelected, nbt, gun);
		}
		
	}
	
	public static class MagRemoveEvent extends AnimationEvent {

		public MagRemoveEvent(ItemStack stack, World world, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {
			super(stack, world, player, itemSlot, isSelected, nbt, gun);
		}
		
	}
	
	private boolean onMagAdd(ItemStack stack, World world, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {

		MagAddEvent event = new MagAddEvent(stack, world, player, itemSlot, isSelected, nbt, gun);

		return !MinecraftForge.EVENT_BUS.post(event);

	}
	
	private boolean onMagRemoved(ItemStack stack, World world, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {

		MagRemoveEvent event = new MagRemoveEvent(stack, world, player, itemSlot, isSelected, nbt, gun);

		return !MinecraftForge.EVENT_BUS.post(event);

	}
	
	@Override
	public List<ItemPropertyWrapper> getProperties() {
		List<ItemPropertyWrapper> list = new ArrayList<>();
		
		list.add(IAnimationController.stringProperty("mag", true));
		list.add(IAnimationController.listCountProperty("bullets", 8, true));
		
		return list;
	}

	@Override
	public void update(ItemStack stack, World worldIn, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {

		boolean flag = player.getHeldItemMainhand().equals(stack);

		NBTTagCompound baseTag = worldIn.getCapability(ItemDataProvider.ITEMDATA_CAP, null).getData();

		if (flag && KeyInputHandler.isKeyPressed(KeyInputHandler.KeyPresses.INSERT) && nbt.getString("mag").isEmpty()) {
			System.out.println("Add Mag Pressed");

			int magslot = gun.findFullestMag(player, baseTag);

			if (magslot != -1 && onMagAdd(stack, worldIn, player, itemSlot, isSelected, nbt, gun)) {
				ItemStack mag = player.inventory.getStackInSlot(magslot);
				//System.out.println("Mag Found: " + mag + mag.getTagCompound());
				RWBYNetworkHandler.sendToServer(new MessageAddToInventory(mag, -1, magslot));
				NBTTagCompound magTag = baseTag.getCompoundTag(mag.getTagCompound().getString("UUID"));
				nbt.setTag("bullets", magTag.getTagList("bullets", 8));
				nbt.setString("mag", magTag.getString("UUID"));
				RWBYNetworkHandler.sendToServer(new MessagePlaySound(Sound.GLOCK_MAG_IN));
			}
		}
		if (flag && KeyInputHandler.isKeyPressed(KeyInputHandler.KeyPresses.MAGRELEASE)) {

			if (!nbt.getString("mag").isEmpty()) {
				if (onMagRemoved(stack, worldIn, player, itemSlot, isSelected, nbt, gun)) {
					NBTTagCompound magNBT = new NBTTagCompound();
	
					magNBT.setTag("bullets", nbt.getTagList("bullets", 8));
					magNBT.setString("UUID", nbt.getString("mag"));
					nbt.setInteger("bullets", 0);
					nbt.setString("mag", "");
	
					ItemStack mag = new ItemStack(gun.mag.get());
	
					Util.getOrCreateTag(mag).setString("UUID", magNBT.getString("UUID"));
					baseTag.setTag(magNBT.getString("UUID"), magNBT);
	
					RWBYNetworkHandler.sendToServer(new MessageAddToInventory(mag, 1, player.inventory.getSizeInventory() - 1));
	
					RWBYNetworkHandler.sendToServer(new MessagePlaySound(Sound.GLOCK_MAG_OUT));
				}
			} else if (gun.isMag(player.getHeldItemOffhand())) {
				TreeMap<Integer, Pair<ItemStack, Integer>> mags = new TreeMap<>();
				for (int i = 0; i < player.inventory.getSizeInventory() - 1; i++) {
					ItemStack itemstack = player.inventory.getStackInSlot(i);
					if (gun.isMag(itemstack)) {
						mags.put(baseTag.getCompoundTag(itemstack.getTagCompound().getString("UUID")).getTagList("bullets", 8).tagCount(), Pair.of(itemstack, i));
					}
				}
				if (!mags.isEmpty()) {
					int slot = mags.lastEntry().getValue().getRight();
					ItemStack oldstack = player.getHeldItemOffhand();
					ItemStack newstack = mags.lastEntry().getValue().getLeft();
					RWBYNetworkHandler.sendToServer(new MessageAddToInventory(newstack, -1, slot));
					RWBYNetworkHandler.sendToServer(new MessageAddToInventory(oldstack, -1, player.inventory.getSizeInventory() - 1));
					RWBYNetworkHandler.sendToServer(new MessageAddToInventory(oldstack, 1, slot));
					RWBYNetworkHandler.sendToServer(new MessageAddToInventory(newstack, 1, player.inventory.getSizeInventory() - 1));
				}
			}
		}
	}
}
