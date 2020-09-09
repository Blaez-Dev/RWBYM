package io.github.blaezdev.rwbym.weaponry.specialweapons.animations;

import java.util.ArrayList;
import java.util.List;

import io.github.blaezdev.rwbym.KeyInputHandler;
import io.github.blaezdev.rwbym.RWBYSoundHandler.Sound;
import io.github.blaezdev.rwbym.utility.network.MessagePlaySound;
import io.github.blaezdev.rwbym.utility.network.RWBYNetworkHandler;
import io.github.blaezdev.rwbym.weaponry.specialweapons.ItemPropertyWrapper;
import io.github.blaezdev.rwbym.weaponry.specialweapons.guns.ItemGun;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AnimationControllerShoot implements IAnimationController {
	
	public final Condition condition;
	public final ItemGun itemGun;
	
	public AnimationControllerShoot(ItemGun itemGun, Condition condition) {
		this.condition = condition;
		this.itemGun = itemGun;
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onHammerDown(AnimationControllerHammer.HammerDownEvent event) {
		if (event.getGun() == this.itemGun) {
			if (!condition.apply(event.getNbt())) {
				event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onHammerHit(AnimationControllerHammer.HammerHitEvent event) {
		if (event.getGun() == this.itemGun) {
			if (condition.apply(event.getNbt())) {
				if (onShootEventPre(event.getStack(), event.getWorld(), event.getPlayer(), event.getItemSlot(), event.isSelected(), event.getNbt(), event.getGun())) {
					boolean flag = this.itemGun.Shoot(event.getNbt(), event.getPlayer(), 10, this.getEntityAccuracy(event), event.getGun().getAccuracy(), 1);
					if (flag) {
						onShootEventPost(event.getStack(), event.getWorld(), event.getPlayer(), event.getItemSlot(), event.isSelected(), event.getNbt(), event.getGun());
//						if (event.getNbt().getInteger("mode") == AnimationControllerFireSelect.Modes.AUTO.ordinal() && !KeyInputHandler.isKeyPressed(KeyInputHandler.KeyPresses.LeftClick)) {
//							FlashHandler.CreateFlash(new BlockPos(event.getPlayer().posX, event.getPlayer().posY + 1, event.getPlayer().posZ), event.getPlayer().dimension.getId(), 1);
//						} else {
//							FlashHandler.CreateFlash(new BlockPos(event.getPlayer().posX, event.getPlayer().posY + 1, event.getPlayer().posZ), event.getPlayer().dimension.getId(), 2);
//						}
						event.getNbt().setBoolean("fired", true);
					} else {
						RWBYNetworkHandler.sendToServer(new MessagePlaySound(Sound.GLOCK_DRY));
					}
				}
			}
			else {
				event.setCanceled(true);
			}
		}
	}

	@Override
	public List<ItemPropertyWrapper> getProperties() {
		List<ItemPropertyWrapper> list = new ArrayList<>();
		
		list.add(IAnimationController.booleanProperty("fired", false));
		
		return list;
	}

	@Override
	public void update(ItemStack stack, World worldIn, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {
//		boolean flag1 = player.getHeldItemMainhand().equals(stack);
		if(nbt.getCompoundTag("prev").getBoolean("fired")) {
			nbt.setBoolean("fired", false);
		}
//		if (KeyInputHandler.isKeyDown(KeyInputHandler.KeyPresses.LeftClick) && nbt.getBoolean("hammer") && condition.apply(nbt) && onShootEvent(stack, worldIn, player, itemSlot, isSelected, nbt, gun)) {
//			//boolean flag = gun.Shoot(nbt, (LivingEntity) entityIn, ModConfig.glockdamage, nbt.getBoolean("ads") ? 0 : 10, 0, 1, condition.apply(nbt));
//			boolean flag = gun.Shoot(nbt, player, 10, nbt.getBoolean("ads") ? 0 : 10, 0, 1);
//			if (flag) {
//				if (nbt.getInt("mode") == AnimationControllerFireSelect.Modes.AUTO.ordinal() && !KeyInputHandler.isKeyPressed(KeyInputHandler.KeyPresses.LeftClick)) {
//					FlashHandler.CreateFlash(new BlockPos(player.posX, player.posY + 1, player.posZ), player.dimension.getId(), 1);
//				}
//				else {
//					FlashHandler.CreateFlash(new BlockPos(player.posX, player.posY + 1, player.posZ), player.dimension.getId(), 10);
//				}
//				nbt.putBoolean("fired", true);
//				nbt.putBoolean("hammer", false);
//			}
//			else if (condition.apply(nbt)){
//				NetworkHandler.sendToServer(new MessagePlaySound(SoundsHandler.ITEM_GLOCK_DRY));
//			}
//			nbt.putBoolean("held", true);
//		}
//		else if (KeyInputHandler.isKeyUnpressed(KeyInputHandler.KeyPresses.LeftClick)) {
//			nbt.putBoolean("held", false);
//		}
	}

	public float getEntityAccuracy(AnimationEvent event) {
		
		double x = event.getPlayer().motionX;
		double y = event.getPlayer().motionY;
		double z = event.getPlayer().motionZ;
		
		x *= 20;
		y *= 20;
		z *= 20;
		
		y += 1.568;
		
		return (float) ((event.getNbt().getBoolean("ads") ? 1.0f : 10.0f) * Math.sqrt(x*x + y*y + z*z));
	}

	public interface Condition {
		boolean apply(NBTTagCompound nbt);
	}

	public static class ShootEvent extends AnimationEvent {

		protected Type type;

		public ShootEvent(ItemStack stack, World world, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {
			super(stack, world, player, itemSlot, isSelected, nbt, gun);
		}

		public Type getType() {
			return type;
		}

		public static class Pre extends ShootEvent {
			public Pre(ItemStack stack, World world, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {
				super(stack, world, player, itemSlot, isSelected, nbt, gun);
				type = Type.Pre;
			}
		}

		public static class Post extends ShootEvent {
			public Post(ItemStack stack, World world, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {
				super(stack, world, player, itemSlot, isSelected, nbt, gun);
				type = Type.Post;
			}

			@Override
			public boolean isCancelable() {
				return false;
			}
		}

		public enum Type {
			Pre,
			Post
		}
	}

	private boolean onShootEventPre(ItemStack stack, World world, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {

		ShootEvent.Pre event = new ShootEvent.Pre(stack, world, player, itemSlot, isSelected, nbt, gun);

		return !MinecraftForge.EVENT_BUS.post(event);

	}

	private void onShootEventPost(ItemStack stack, World world, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {

		ShootEvent.Post event = new ShootEvent.Post(stack, world, player, itemSlot, isSelected, nbt, gun);

		MinecraftForge.EVENT_BUS.post(event);

	}
	
}


