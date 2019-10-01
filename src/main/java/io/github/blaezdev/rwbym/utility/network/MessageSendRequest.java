package io.github.blaezdev.rwbym.utility.network;

import io.github.blaezdev.rwbym.capabilities.team.TeamProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class MessageSendRequest extends MessageBase<MessageSendRequest> {
	
	private String sender, receiver;
	
	public MessageSendRequest() {}
	
	public MessageSendRequest(EntityPlayer sender, EntityPlayer receiver) {
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
	public void handleClientSide(MessageSendRequest message, EntityPlayer player) {
		// TODO Auto-generated method stub
	}

	@Override
	public void handleServerSide(MessageSendRequest message, EntityPlayer player) {
		if (player.world.hasCapability(TeamProvider.TEAM_CAP, null)) {
			player.world.getCapability(TeamProvider.TEAM_CAP, null).sendRequest(message.sender, message.receiver);
		}
	}

}
