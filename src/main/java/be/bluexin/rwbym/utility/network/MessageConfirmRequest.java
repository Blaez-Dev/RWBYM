package be.bluexin.rwbym.utility.network;

import be.bluexin.rwbym.capabilities.team.TeamProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class MessageConfirmRequest extends MessageBase<MessageConfirmRequest> {
	
	private String sender, receiver;
	
	public MessageConfirmRequest() {}
	
	public MessageConfirmRequest(EntityPlayer sender, EntityPlayer receiver) {
		this.sender = sender.getCachedUniqueIdString();
		this.receiver = receiver.getCachedUniqueIdString();
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		sender = ByteBufUtils.readUTF8String(buf);
		receiver = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, sender);
		ByteBufUtils.writeUTF8String(buf, receiver);
	}

	@Override
	public void handleClientSide(MessageConfirmRequest message, EntityPlayer player) {
		// TODO Auto-generated method stub
	}

	@Override
	public void handleServerSide(MessageConfirmRequest message, EntityPlayer player) {
		if (player.world.hasCapability(TeamProvider.TEAM_CAP, null)) {
			player.world.getCapability(TeamProvider.TEAM_CAP, null).confirmRequest(message.sender, message.receiver);
		}
	}

}
