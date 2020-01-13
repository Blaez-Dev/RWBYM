package io.github.blaezdev.rwbym.utility.network;

import io.github.blaezdev.rwbym.capabilities.team.TeamProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class MessageGetTeamData extends MessageBase<MessageGetTeamData> {

	@Override
	public void fromBytes(ByteBuf buf) {
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
	}

	@Override
	public void handleClientSide(MessageGetTeamData message, EntityPlayer player) {
		
	}

	@Override
	public void handleServerSide(MessageGetTeamData message, EntityPlayer player) {
		RWBYNetworkHandler.sendToClient(new MessageSendTeams(player.world.getCapability(TeamProvider.TEAM_CAP, null)), (EntityPlayerMP) player);
	}

}
