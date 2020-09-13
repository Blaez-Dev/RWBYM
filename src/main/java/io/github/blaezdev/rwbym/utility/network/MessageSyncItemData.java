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
	private String senderUUID;
	private String uuid;
	
	public MessageSyncItemData() {}
	
    public MessageSyncItemData(IItemData iItemData, String uuid, EntityPlayer player) {
    	this.data = getItemTag(iItemData.getData(), uuid);
    	this.senderUUID = player.getUniqueID().toString();
    	this.uuid = uuid;
    }
	
	@Override
	public void fromBytes(ByteBuf buf) {
		data = ByteBufUtils.readTag(buf);
		senderUUID = ByteBufUtils.readUTF8String(buf);
		uuid = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, data);
		ByteBufUtils.writeUTF8String(buf, senderUUID);
		ByteBufUtils.writeUTF8String(buf, uuid);
	}

	@Override
	public void handleClientSide(MessageSyncItemData message, EntityPlayer player) {
		if (!player.getUniqueID().toString().equals(message.senderUUID)) {
			getItemTag(Minecraft.getMinecraft().world.getCapability(ItemDataProvider.ITEMDATA_CAP, null).getData(), message.uuid).merge(message.data);
		}
	}

	@Override
	public void handleServerSide(MessageSyncItemData message, EntityPlayer player) {}
	
	private NBTTagCompound getItemTag(NBTTagCompound baseTag, String key) {
		NBTTagCompound itemTag;
		if (baseTag.hasKey(key, 10)) {
			itemTag = baseTag.getCompoundTag(key);
		}
		else {
			itemTag = new NBTTagCompound();
			baseTag.setTag(key, itemTag);
		}
		return itemTag;
	}

}
