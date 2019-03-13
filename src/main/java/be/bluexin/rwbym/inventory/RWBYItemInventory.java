package be.bluexin.rwbym.inventory;

import java.util.List;

import be.bluexin.rwbym.weaponry.RWBYContainerItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class RWBYItemInventory implements ICapabilityProvider, ICapabilitySerializable {

	private ItemStackHandler inventory;
	
	public RWBYItemInventory(List<String> validItems) {
		this.inventory = new RWBYItemStackHandler(9, validItems);
	}
	
	@Override
	public NBTBase serializeNBT() {
		return inventory.serializeNBT();
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		inventory.deserializeNBT((NBTTagCompound) nbt);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return true;
		}
		return false;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		
		if (hasCapability(capability, facing)) {
		
			return (T) inventory;
			
		}
		
		return null;
	}
	
}
