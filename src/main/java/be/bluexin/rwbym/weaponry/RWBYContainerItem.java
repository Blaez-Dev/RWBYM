package be.bluexin.rwbym.weaponry;

import java.util.ArrayList;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.inventory.RWBYItemContainer;
import be.bluexin.rwbym.inventory.RWBYItemInventory;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.IItemHandler;

public class RWBYContainerItem<GUI extends GuiContainer, CONTAINER extends Container> extends Item implements ICustomItem {
			
	private String acceptedItems;
	
	private final int size;
	
	private final Class<GUI> guiClass;
	
	private final Class<CONTAINER> containerClass;

	public RWBYContainerItem(String name, String acceptedItems, int size,int stacksize, Class<GUI> guiClass, Class<CONTAINER> containerClass) {
		this.size = size;
		this.setMaxStackSize(stacksize);
		this.setRegistryName(name);
		this.setUnlocalizedName(this.getRegistryName().toString());
				
		this.acceptedItems = acceptedItems;
		
		this.guiClass = guiClass;
		
		this.containerClass = containerClass;
				
	}
	
	public Class<GUI> getGuiClass() {
		return guiClass;
	}
	
	public Class<CONTAINER> getContainerClass() {
		return containerClass;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		
		if (!world.isRemote) {
			if (hand == EnumHand.MAIN_HAND) {
				player.openGui(RWBYModels.instance, RWBYModels.GuiHandler.GUI.ITEM_CONTAINER.ordinal(), world, (int)player.posX, (int)player.posY, (int)player.posZ);
			}
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}

	@Override
	public String toString() {
		return "RWBYContainerItem{" + this.getRegistryName() + "}";
	}
	
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
		String[] itemnames = acceptedItems.split(",");
		return new RWBYItemInventory(ImmutableList.copyOf(itemnames));
	}
	
}