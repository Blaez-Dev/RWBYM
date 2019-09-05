package be.bluexin.rwbym.utility.network;

import be.bluexin.rwbym.capabilities.team.TeamProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class MessageLeaveTeam extends MessageBase<MessageLeaveTeam> {
	
	private String member;
	
	public MessageLeaveTeam() {}
	
	public MessageLeaveTeam(EntityPlayer player) {
		this.member = player.getCachedUniqueIdString();
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		member = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, member);
	}

	@Override
	public void handleClientSide(MessageLeaveTeam message, EntityPlayer player) {
		// TODO Auto-generated method stub
	}

	@Override
	public void handleServerSide(MessageLeaveTeam message, EntityPlayer player) {
		if (player.world.hasCapability(TeamProvider.TEAM_CAP, null)) {
			player.world.getCapability(TeamProvider.TEAM_CAP, null).leaveTeam(message.member);
		}
	}

}
