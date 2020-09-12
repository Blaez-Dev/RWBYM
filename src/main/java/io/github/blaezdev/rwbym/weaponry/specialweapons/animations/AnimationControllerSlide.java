package io.github.blaezdev.rwbym.weaponry.specialweapons.animations;

import java.util.ArrayList;
import java.util.List;

import io.github.blaezdev.rwbym.KeyInputHandler;
import io.github.blaezdev.rwbym.RWBYSoundHandler.Sound;
import io.github.blaezdev.rwbym.utility.network.MessageEject;
import io.github.blaezdev.rwbym.utility.network.MessagePlaySound;
import io.github.blaezdev.rwbym.utility.network.RWBYNetworkHandler;
import io.github.blaezdev.rwbym.utility.network.MessageEject.Direction;
import io.github.blaezdev.rwbym.weaponry.specialweapons.ItemPropertyWrapper;
import io.github.blaezdev.rwbym.weaponry.specialweapons.guns.ItemGun;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class AnimationControllerSlide implements IAnimationController {

	private final ItemGun itemgun;
	private final boolean slideLock;
	private boolean justfired = false;

	public AnimationControllerSlide(ItemGun itemgun, boolean slideLock) {
		this.itemgun = itemgun;
		this.slideLock = slideLock;
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onShootEvent(AnimationControllerShoot.ShootEvent.Post event) {
		if (event.getGun() == this.itemgun) {
			this.justfired = true;
		}
	}

	@Override
	public List<ItemPropertyWrapper> getProperties() {
		List<ItemPropertyWrapper> list = new ArrayList<>();
		
		list.add(IAnimationController.integerProperty("slide", true));
	    list.add(IAnimationController.integerProperty("check", false));
	    list.add(IAnimationController.integerProperty("charge_handle", true));
		
		return list;
	}

	@Override
	public void update(ItemStack stack, World worldIn, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {

		boolean flag = player.getHeldItemMainhand().equals(stack);

		if (this.justfired) {
			nbt.setInteger("slide", 4);
			nbt.getCompoundTag("prev").setInteger("slide", 0);
		}

		if (slideLock && nbt.getInteger("slide") < 3 && flag && KeyInputHandler.isKeyDown(KeyInputHandler.KeyPresses.SLIDELOCK_BOLT) && KeyInputHandler.isKeyDown(KeyInputHandler.KeyPresses.REMOVEBULLET_SLIDE)) {
			if (nbt.getInteger("check") < 4) {
				nbt.setInteger("check", nbt.getInteger("check") + 1);
			}
		}
		else {
			if (nbt.getInteger("check") > 0) {
				nbt.setInteger("check", 0);
			}
		}

		if (flag && KeyInputHandler.isKeyDown(KeyInputHandler.KeyPresses.REMOVEBULLET_SLIDE)) {
			if (nbt.getInteger("slide") == 0) RWBYNetworkHandler.sendToServer(new MessagePlaySound(Sound.COLT_SLIDE_BACK));
			if (nbt.getInteger("slide") < 4 && nbt.getInteger("check") < 3) {
				nbt.setInteger("slide", nbt.getInteger("slide") + 1);
				nbt.setInteger("charge_handle", nbt.getInteger("slide"));
			}
		}
//		if (KeyInputHandler.isKeyDown(KeyInputHandler.KeyPresses.RemoveBullet)) {
//			if (nbt.getInt("slide") < 2) {
//				nbt.putInt("slide", nbt.getInt("slide") + 1);
//			}
//			else if ((nbt.getInt("slide") == 2 || nbt.getInt("slide") == 5) && KeyInputHandler.isKeyDown(KeyInputHandler.KeyPresses.SlideLock)) {
//				//System.out.println("Half Lock");
//				nbt.putInt("slide", 5);
//				nbt.getCompound("prev").putInt("slide", 5);
//			}
//			else if (nbt.getInt("slide") == 5) {
//				nbt.putInt("slide", 2);
//			}
//			else if (nbt.getInt("slide") < 4) {
//				nbt.putInt("slide", nbt.getInt("slide") + 1);
//			}
//		}
		if (nbt.getInteger("slide") == 4) {
			nbt.setBoolean("hammer", true);
			if (nbt.getCompoundTag("prev").getInteger("slide") < 4) {
				if (!nbt.getString("BulletChambered").isEmpty()) {
					RWBYNetworkHandler.sendToServer(new MessageEject(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(nbt.getString("BulletChambered")))), Direction.DOWN));
					nbt.setString("BulletChambered", "");
				}
			}
			if (slideLock && !nbt.getString("mag").isEmpty() && nbt.getTagList("bullets", 8).tagCount() == 0 && nbt.getString("BulletChambered").isEmpty()) {
				nbt.setBoolean("AutoSlideLock", true);
			}
		}

		if (!KeyInputHandler.isKeyDown(KeyInputHandler.KeyPresses.REMOVEBULLET_SLIDE)) {
			if ((nbt.getInteger("slide") == 4 && KeyInputHandler.isKeyDown(KeyInputHandler.KeyPresses.SLIDELOCK_BOLT)) || nbt.getBoolean("AutoSlideLock")) {
				nbt.setBoolean("AutoSlideLock", true);
			}
			if (flag && KeyInputHandler.isKeyPressed(KeyInputHandler.KeyPresses.SLIDELOCK_BOLT)) {
				nbt.setBoolean("AutoSlideLock", false);
			}
			if (nbt.getInteger("slide") == 4 && nbt.getBoolean("AutoSlideLock")) {
				nbt.setInteger("slide", 4);
				RWBYNetworkHandler.sendToServer(new MessagePlaySound(Sound.COLT_SLIDE_FORWARD));
			}
			if (nbt.getInteger("slide") > 0 && !nbt.getBoolean("AutoSlideLock")) {
				//if (nbt.getCompound("prev").getInt("slide") > 2 && nbt.getCompound("prev").getInt("slide") < 5 && nbt.getList("bullets", 8).size() > 0 && nbt.getString("BulletChambered").isEmpty() && (nbt.getInt("slide") < nbt.getCompound("prev").getInt("slide"))) {
				if (nbt.getInteger("slide") > 2 && nbt.getTagList("bullets", 8).tagCount() > 0 && nbt.getString("BulletChambered").isEmpty()) {
					nbt.setString("BulletChambered", nbt.getTagList("bullets", 8).getStringTagAt(nbt.getTagList("bullets", 8).tagCount() - 1));
					nbt.getTagList("bullets", 8).removeTag(nbt.getTagList("bullets", 8).tagCount() - 1);
				}
				nbt.setInteger("slide", 0);
				nbt.setInteger("charge_handle", 0);
				RWBYNetworkHandler.sendToServer(new MessagePlaySound(Sound.COLT_SLIDE_FORWARD));
			}
		}
//		if (!KeyInputHandler.isKeyDown(KeyInputHandler.KeyPresses.RemoveBullet)) {
//			if (nbt.getInt("slide") == 5) {
//				nbt.putInt("slide", 2);
//			}
//			if (nbt.getInt("slide") == 4) {
//				if (!KeyInputHandler.isKeyDown(KeyInputHandler.KeyPresses.SlideLock) && nbt.getString("BulletChambered").isEmpty() && !nbt.getString("mag").isEmpty() && nbt.getList("Bullets", 8).size() == 0) {
//					nbt.putBoolean("AutoSlideLock", true);
//				}
//				else {
//					nbt.putBoolean("AutoSlideLock", false);
//				}
//				nbt.putInt("slide", 3);
//			}
//			if (nbt.getInt("slide") == 3 && (KeyInputHandler.isKeyDown(KeyInputHandler.KeyPresses.SlideLock) || nbt.getBoolean("AutoSlideLock")) && !KeyInputHandler.isKeyPressed(KeyInputHandler.KeyPresses.SlideLock)) {
//				//System.out.println("Full Lock");
//				nbt.putBoolean("AutoSlideLock", true);
//			}
//			else {
//				nbt.putInt("slide", 0);
//			}
//		}
		if (nbt.getInteger("slide") == 0) {
			nbt.setBoolean("AutoSlideLock", false);
		}

		if (this.justfired) {
			nbt.setInteger("slide", 4);
			nbt.getCompoundTag("prev").setInteger("slide", 0);
		}

		if (this.justfired) {
			this.justfired = false;
		}

		//System.out.println(nbt);
	}

}
