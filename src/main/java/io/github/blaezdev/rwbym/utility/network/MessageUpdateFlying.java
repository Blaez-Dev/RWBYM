package io.github.blaezdev.rwbym.utility.network;

import io.github.blaezdev.rwbym.utility.RWBYServerEventHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;

public class MessageUpdateFlying extends MessageBase<MessageUpdateFlying> {

	@Override
	public void fromBytes(ByteBuf buf) {}

	@Override
	public void toBytes(ByteBuf buf) {}

	@Override
	public void handleClientSide(MessageUpdateFlying message, EntityPlayer player) {}

	@Override
	public void handleServerSide(MessageUpdateFlying message, EntityPlayer playerIn) {
		
		EntityPlayerMP player = (EntityPlayerMP)playerIn;

        if (!player.onGround && player.motionY < 0.0D && !player.isElytraFlying() && !player.isInWater())
        {
            ItemStack itemstack = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);

            if (itemstack.getItem() != Items.ELYTRA && itemstack.getItem() instanceof ItemElytra && ItemElytra.isUsable(itemstack))
            {
                player.setElytraFlying();
                RWBYServerEventHandler.flyingMap.put(player, true);
            }
        }
        else
        {
            player.clearElytraFlying();
        }
		
	}

}
