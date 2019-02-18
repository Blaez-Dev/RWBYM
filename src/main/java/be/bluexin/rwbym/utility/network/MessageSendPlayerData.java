package be.bluexin.rwbym.utility.network;

import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ISemblance;
import be.bluexin.rwbym.capabilities.Ruby.IRuby;
import be.bluexin.rwbym.capabilities.Ruby.RubyProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class MessageSendPlayerData extends MessageBase<MessageSendPlayerData> {

	NBTTagCompound nbt = new NBTTagCompound();
	
	String capability;
	
	String player;

	public MessageSendPlayerData() {}
	
	public MessageSendPlayerData(ISemblance semblance, String player) {
		semblance.writeToNBT(nbt);
		this.capability = semblance.getCapability().getName();
		this.player = player;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		nbt = ByteBufUtils.readTag(buf);
		capability = ByteBufUtils.readUTF8String(buf);
		player = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, nbt);
		ByteBufUtils.writeUTF8String(buf, capability);
		ByteBufUtils.writeUTF8String(buf, player);
	}

	@Override
	public void handleClientSide(MessageSendPlayerData message, EntityPlayer player) {
		EntityPlayer requestedPlayer = player.world.getPlayerEntityByName(message.player);
		if (requestedPlayer == null) {
			System.out.println("DATA ERROR");
		}
		else {
			ISemblance semblance = CapabilityHandler.getCapabilityByName(requestedPlayer, message.capability);
			semblance.readFromNBT(message.nbt);
		}
	}

	@Override
	public void handleServerSide(MessageSendPlayerData message, EntityPlayer player) {
		
	}
}
