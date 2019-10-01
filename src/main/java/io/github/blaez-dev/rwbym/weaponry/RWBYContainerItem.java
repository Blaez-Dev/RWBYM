package io.github.blaez-dev.rwbym.weaponry;

import io.github.blaez-dev.rwbym.RWBYModels;
import io.github.blaez-dev.rwbym.inventory.RWBYItemInventory;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class RWBYContainerItem<GUI extends GuiContainer, CONTAINER extends Container> extends Item implements ICustomItem {
			
	private String acceptedItems;
	
	public final int size;
	
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
				player.openGui(RWBYModels.instance, RWBYModels.GuiHandler.GUI.ITEM_CONTAINER_MAINHAND.ordinal(), world, (int)player.posX, (int)player.posY, (int)player.posZ);
			}
			else {
				player.openGui(RWBYModels.instance, RWBYModels.GuiHandler.GUI.ITEM_CONTAINER_OFFHAND.ordinal(), world, (int)player.posX, (int)player.posY, (int)player.posZ);
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
		return new RWBYItemInventory(size, ImmutableList.copyOf(itemnames));
	}
	
}