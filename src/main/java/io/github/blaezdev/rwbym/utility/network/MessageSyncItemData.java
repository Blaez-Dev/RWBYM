package io.github.blaezdev.rwbym.utility.network;

import io.github.blaezdev.rwbym.capabilities.itemdata.IItemData;
import io.github.blaezdev.rwbym.capabilities.itemdata.ItemData;
import io.github.blaezdev.rwbym.capabilities.itemdata.ItemDataProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class MessageSyncItemData extends MessageBase<MessageSyncItemData> {

	private NBTTagCompound data;
	private String uuid;
	
	public MessageSyncItemData() {}
	
    public MessageSyncItemData(IItemData iItemData, EntityPlayer player) {
    	this.data = iItemData.getData();
    	this.uuid = player.getUniqueID().toString();
    }
	
	@Override
	public void fromBytes(ByteBuf buf) {
		data = ByteBufUtils.readTag(buf);
		uuid = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, data);
		ByteBufUtils.writeUTF8String(buf, uuid);
	}

	@Override
	public void handleClientSide(MessageSyncItemData message, EntityPlayer player) {
		if (!player.getUniqueID().toString().equals(message.uuid)) {
			Minecraft.getMinecraft().world.getCapability(ItemDataProvider.ITEMDATA_CAP, null).setData(message.data);
		}
	}

	@Override
	public void handleServerSide(MessageSyncItemData message, EntityPlayer player) {}

}
