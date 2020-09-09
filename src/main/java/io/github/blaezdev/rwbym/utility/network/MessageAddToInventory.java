package io.github.blaezdev.rwbym.utility.network;

import io.github.blaezdev.rwbym.RWBYModels;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class MessageAddToInventory extends MessageBase<MessageAddToInventory> {
	
	private NBTTagCompound nbt;
	private int amount;
	private int slot;

	public MessageAddToInventory() {}
	
	public MessageAddToInventory(ItemStack stack, int amount) {
		this(stack, amount, -1);
	}
	
	public MessageAddToInventory(Item item, int amount) {
		this(new ItemStack(item), amount);
	}

	public MessageAddToInventory(ItemStack stack, int amount, int slot) {
		this.nbt = stack.serializeNBT();
		this.amount = amount;
		this.slot = slot;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		nbt = ByteBufUtils.readTag(buf);
		amount = buf.readInt();
		slot = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, nbt);
		buf.writeInt(amount);
		buf.writeInt(slot);
	}

	@Override
	public void handleClientSide(MessageAddToInventory message, EntityPlayer player) {
		
	}

	@Override
	public void handleServerSide(MessageAddToInventory message, EntityPlayer player) {
		
		ItemStack stack1 = new ItemStack(message.nbt);
				
		if (message.slot != -1) {
			if (message.amount < 0) {
				ItemStack stack2 = player.inventory.getStackInSlot(message.slot);
				if (stack1.getItem() == stack2.getItem()) {
					stack2.grow(message.amount);
					return;
				}
				System.out.println("Unable to Remove Item From Requested Slot");
			}
			if (message.amount > 0) {
				if (player.inventory.getStackInSlot(message.slot).isEmpty()) {
					player.inventory.setInventorySlotContents(message.slot, stack1);
					return;
				}
				System.out.println("Unable to Add Item To Requested Slot");
			}
		}
		
		for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
			
			ItemStack stack2 = player.inventory.getStackInSlot(i);
			
			if (ItemStack.areItemsEqual(stack1, stack2)) {
				
				if (stack1.getTagCompound() == null && stack2.getTagCompound() == null || stack1.getTagCompound().equals(stack2.getTagCompound())) {
					
					stack2.grow(message.amount);
					
					if (stack2.getCount() > stack2.getMaxStackSize()) {
						
						ItemStack stack3 = stack2.splitStack(stack2.getMaxStackSize());
						player.inventory.addItemStackToInventory(stack3);
						
					}
					return;
				}
			}
		}
		RWBYModels.LOGGER.info("Unable to Find Stack, slot: {}", message.slot);
		stack1.setCount(message.amount);
		if (!player.inventory.addItemStackToInventory(stack1)) {
			RWBYModels.LOGGER.info("dropping Item");
			player.dropItem(stack1, false, true);
		}
	}
}
