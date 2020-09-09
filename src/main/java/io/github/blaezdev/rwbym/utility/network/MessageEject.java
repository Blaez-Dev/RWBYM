package io.github.blaezdev.rwbym.utility.network;

import java.util.Random;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class MessageEject extends MessageBase<MessageEject> {
	
	private ItemStack itemstack;

	public MessageEject () {}
	
	public MessageEject (ItemStack itemstack) {
		this.itemstack = itemstack;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.itemstack = ByteBufUtils.readItemStack(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeItemStack(buf, itemstack);
	}

	@Override
	public void handleClientSide(MessageEject message, EntityPlayer player) {
		
	}

	@Override
	public void handleServerSide(MessageEject message, EntityPlayer player) {
		
		Random rand = new Random();
		
        if (message.itemstack.isEmpty())
        {
            return;
        }
        else
        {
            double d0 = player.posY - 0.30000001192092896D + (double)player.getEyeHeight();
            EntityItem entityitem = new EntityItem(player.world, player.posX, d0, player.posZ, message.itemstack);
            entityitem.setPickupDelay(15);

            float f2 = 0.2F;
            entityitem.motionZ = (double)(-MathHelper.sin(player.rotationYaw * 0.017453292F) * f2);
            entityitem.motionX = -(double)(MathHelper.cos(player.rotationYaw * 0.017453292F) * f2);
            entityitem.motionY = (double)(-MathHelper.sin(-45 * 0.017453292F) * f2 + 0.1F);
            float f3 = rand.nextFloat() * ((float)Math.PI * 2F);
            f2 = 0.02F * rand.nextFloat();
            entityitem.motionX += Math.cos((double)f3) * (double)f2;
            entityitem.motionY += (double)((rand.nextFloat() - rand.nextFloat()) * 0.1F);
            entityitem.motionZ += Math.sin((double)f3) * (double)f2;

            ItemStack itemstack = player.dropItemAndGetStack(entityitem);
        }
    }
}
