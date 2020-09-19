package io.github.blaezdev.rwbym.weaponry.specialweapons;

import java.util.List;
import java.util.function.Supplier;

import io.github.blaezdev.rwbym.KeyInputHandler;
import io.github.blaezdev.rwbym.Init.RWBYCreativeTabs;
import io.github.blaezdev.rwbym.capabilities.itemdata.IItemData;
import io.github.blaezdev.rwbym.capabilities.itemdata.ItemDataProvider;
import io.github.blaezdev.rwbym.utility.Util;
import io.github.blaezdev.rwbym.utility.network.MessageAddToInventory;
import io.github.blaezdev.rwbym.utility.network.MessageUpdateNBT;
import io.github.blaezdev.rwbym.utility.network.RWBYNetworkHandler;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.IAnimationController;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class ItemMag extends Item {
	
	protected int maxAmmo;
	
	protected Supplier<Item> ammo;

	public ItemMag(int maxAmmo, Supplier<Item> ammo) {
		super();
		
		this.maxStackSize = 1;
		this.setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);

		this.maxAmmo = maxAmmo;
		this.ammo = ammo;

		ItemPropertyWrapper bullets = IAnimationController.listCountProperty("bullets", 8, true);
	
		this.addPropertyOverride(bullets.getName(), bullets.getOverride());
	}
	
//	@Override
//	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
//		tooltip.add(new StringTextComponent("ID: " + stack.getOrCreateTag().getString("UUID")));
//	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		//tooltip.add("ID: " + Util.getOrCreateTag(stack).getString("UUID"));
		if (worldIn != null) {
	        NBTTagCompound nbt = worldIn.getCapability(ItemDataProvider.ITEMDATA_CAP, null).getData().getCompoundTag(Util.getOrCreateTag(stack).getString("UUID"));
	        int bullets = nbt.getTagList("bullets", 8).tagCount();
	        tooltip.add("Ammo: " + bullets + "/" + maxAmmo);
		}
	}
	
	public int getMaxAmmo() {
		return maxAmmo;
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (entityIn instanceof EntityPlayer && worldIn.isRemote) {
						
			EntityPlayer player = (EntityPlayer) entityIn;

			IItemData itemData = worldIn.getCapability(ItemDataProvider.ITEMDATA_CAP, null);

				NBTTagCompound nbt;

				if (itemData.getData().hasKey(Util.getOrCreateTag(stack).getString("UUID"))) {
					nbt = itemData.getData().getCompoundTag(stack.getTagCompound().getString("UUID"));
				}
				else {
					nbt = new NBTTagCompound();
					itemData.getData().setTag(stack.getTagCompound().getString("UUID"), nbt);
				}

				NBTTagCompound old = nbt.copy();
				old.removeTag("prev");
				nbt.setTag("prev", old);

				if (!nbt.hasKey("bullets", 9)) {
					nbt.setTag("bullets", new NBTTagList());
				}

				if (player.getHeldItemMainhand().equals(stack)) {

					if (KeyInputHandler.isKeyPressed(KeyInputHandler.KeyPresses.INSERT)) {
						if (nbt.getTagList("bullets", 8).tagCount() < this.maxAmmo) {

							ItemStack ammo = findAmmo(player);

							if (!ammo.isEmpty()) {
								nbt.getTagList("bullets", 8).appendTag(new NBTTagString(ammo.getItem().getRegistryName().toString()));
								RWBYNetworkHandler.sendToServer(new MessageAddToInventory(ammo, -1));
							}
						}
					}

					if (KeyInputHandler.isKeyPressed(KeyInputHandler.KeyPresses.REMOVEBULLET_SLIDE)) {
						if (nbt.getTagList("bullets", 8).tagCount() > 0) {
							nbt.getTagList("bullets", 8).removeTag(nbt.getTagList("bullets", 8).tagCount() - 1);
							RWBYNetworkHandler.sendToServer(new MessageAddToInventory(this.ammo.get(), 1));
						}
					}
					//Main.LOGGER.info("Sending nbt at slot {}", itemSlot);
				}
				RWBYNetworkHandler.sendToServer(new MessageUpdateNBT(stack, itemSlot, nbt, player));
		}
	}
	
	public ItemStack findAmmo(EntityPlayer player) {
		for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
        {
            ItemStack itemstack = player.inventory.getStackInSlot(i);

            if (this.isBullet(itemstack))
            {
                return itemstack;
            }
        }

        return ItemStack.EMPTY;
	}
	
	public boolean isBullet(ItemStack stack) {
        return stack.getItem() == this.ammo.get();
    }
	
	
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        boolean flag = false;

        if (oldStack.getItem() instanceof ItemMag && newStack.getItem() instanceof ItemMag) {
            flag = oldStack.getTagCompound().getString("UUID").equals(newStack.getTagCompound().getString("UUID"));
        }

        return slotChanged || !flag;
    }
}
