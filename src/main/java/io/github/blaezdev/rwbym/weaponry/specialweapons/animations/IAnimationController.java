package io.github.blaezdev.rwbym.weaponry.specialweapons.animations;

import java.util.List;

import io.github.blaezdev.rwbym.capabilities.itemdata.IItemData;
import io.github.blaezdev.rwbym.capabilities.itemdata.ItemDataProvider;
import io.github.blaezdev.rwbym.weaponry.specialweapons.ItemPropertyWrapper;
import io.github.blaezdev.rwbym.weaponry.specialweapons.guns.ItemGun;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Event;

public interface IAnimationController {
	
	List<ItemPropertyWrapper> getProperties();
	
	void update(ItemStack stack, World worldIn, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun);
	
	public class AnimationEvent extends Event {
		
		private final ItemStack stack;
		private final World world;
		private final EntityPlayer player;
		private final int itemSlot;
		private final boolean isSelected;
		private final NBTTagCompound nbt;
		private final ItemGun gun;
		
		public AnimationEvent(ItemStack stack, World world, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {
			this.stack = stack;
			this.world = world;
			this.player = player;
			this.itemSlot = itemSlot;
			this.isSelected = isSelected;
			this.nbt = nbt;
			this.gun = gun;
		}
		
		public ItemStack getStack() {
			return stack;
		}
		
		public World getWorld() {
			return world;
		}
		
		public EntityPlayer getPlayer() {
			return player;
		}
		
		public int getItemSlot() {
			return itemSlot;
		}
		
		public boolean isSelected() {
			return isSelected;
		}
		
		public NBTTagCompound getNbt() {
			return nbt;
		}
		
		public ItemGun getGun() {
			return gun;
		}
		
		@Override
		public boolean isCancelable() {
			return true;
		}
		
	}

	static ItemPropertyWrapper booleanProperty(String name, boolean showInInvenotry) {
		return new ItemPropertyWrapper(name, (stack, worldIn, entity) -> {
			if (worldIn == null) {
				if (showInInvenotry) {
					worldIn = Minecraft.getMinecraft().world;
				}
			}

			if (!stack.hasTagCompound() || worldIn == null) {
				return 0F;
			}

			IItemData iItemData = worldIn.getCapability(ItemDataProvider.ITEMDATA_CAP, null);

			NBTTagCompound nbt = iItemData.getData().getCompoundTag(stack.getTagCompound().getString("UUID"));
			NBTTagCompound oldNBT = nbt.getCompoundTag("prev");

			float pt = Minecraft.getMinecraft().getRenderPartialTicks();// RenderPartialTickHandler.renderPartialTick;

			return (oldNBT.getBoolean(name) ? 1F : 0F) * (1 - pt) + (nbt.getBoolean(name) ? 1F : 0F) * pt;

			
		});
	}

	static ItemPropertyWrapper stringProperty(String name, boolean showInInvenotry) {
		return new ItemPropertyWrapper(name, (stack, worldIn, entity) -> {
			if (worldIn == null) {
				if (showInInvenotry) {
					worldIn = Minecraft.getMinecraft().world;
				}
			}

			if (!stack.hasTagCompound() || worldIn == null) {
				return 0F;
			}

			IItemData iItemData = worldIn.getCapability(ItemDataProvider.ITEMDATA_CAP, null);

			NBTTagCompound nbt = iItemData.getData().getCompoundTag(stack.getTagCompound().getString("UUID"));
			NBTTagCompound oldNBT = nbt.getCompoundTag("prev");

			float pt = Minecraft.getMinecraft().getRenderPartialTicks();//RenderPartialTickHandler.renderPartialTick;

			return (oldNBT.getString(name).isEmpty() ? 0F : 1F) * (1 - pt) + (nbt.getString(name).isEmpty() ? 0F : 1F) * pt;
		});
	}

	static ItemPropertyWrapper floatProperty(String name, boolean showInInvenotry) {
		return new ItemPropertyWrapper(name, (stack, worldIn, entity) -> {
			if (worldIn == null) {
				if (showInInvenotry) {
					worldIn = Minecraft.getMinecraft().world;
				}
			}

			if (!stack.hasTagCompound() || worldIn == null) {
				return 0F;
			}

			IItemData iItemData = worldIn.getCapability(ItemDataProvider.ITEMDATA_CAP, null);

			NBTTagCompound nbt = iItemData.getData().getCompoundTag(stack.getTagCompound().getString("UUID"));
			NBTTagCompound oldNBT = nbt.getCompoundTag("prev");

			float pt = Minecraft.getMinecraft().getRenderPartialTicks();//RenderPartialTickHandler.renderPartialTick;

			return oldNBT.getFloat(name) * (1 - pt) + nbt.getFloat(name) * pt;

		});
	}

	static ItemPropertyWrapper integerProperty(String name, boolean showInInvenotry) {
		return new ItemPropertyWrapper(name, (stack, worldIn, entity) -> {
			if (worldIn == null) {
				if (showInInvenotry) {
					worldIn = Minecraft.getMinecraft().world;
				}
			}

			if (!stack.hasTagCompound() || worldIn == null) {
				return 0F;
			}

			IItemData iItemData = worldIn.getCapability(ItemDataProvider.ITEMDATA_CAP, null);

			NBTTagCompound nbt = iItemData.getData().getCompoundTag(stack.getTagCompound().getString("UUID"));
			NBTTagCompound oldNBT = nbt.getCompoundTag("prev");

			float pt = Minecraft.getMinecraft().getRenderPartialTicks();//RenderPartialTickHandler.renderPartialTick;

			return oldNBT.getInteger(name) * (1 - pt) + nbt.getInteger(name) * pt;

		});
	}
	
	static ItemPropertyWrapper listCountProperty(String name, int type, boolean showInInvenotry) {
		return new ItemPropertyWrapper(name, (stack, worldIn, entity) -> {
			if (worldIn == null) {
				if (showInInvenotry) {
					worldIn = Minecraft.getMinecraft().world;
				}
			}

			if (!stack.hasTagCompound() || worldIn == null) {
				return 0F;
			}

			IItemData iItemData = worldIn.getCapability(ItemDataProvider.ITEMDATA_CAP, null);

			NBTTagCompound nbt = iItemData.getData().getCompoundTag(stack.getTagCompound().getString("UUID"));
			NBTTagCompound oldNBT = nbt.getCompoundTag("prev");

			float pt = Minecraft.getMinecraft().getRenderPartialTicks();//RenderPartialTickHandler.renderPartialTick;

			return oldNBT.getTagList(name, type).tagCount() * (1.0f - pt) + nbt.getTagList(name, type).tagCount() * pt;

		});
	}

}
