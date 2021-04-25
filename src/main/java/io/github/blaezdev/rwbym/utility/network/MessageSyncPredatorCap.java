package io.github.blaezdev.rwbym.utility.network;

import io.github.blaezdev.rwbym.capabilities.Predator.IPredator;
import io.github.blaezdev.rwbym.capabilities.Predator.Predator;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageSyncPredatorCap extends MessageBase<MessageSyncPredatorCap> {

	private int kills;

	public MessageSyncPredatorCap()
	{

	}
	
	public MessageSyncPredatorCap(int kills)
	{
		this.kills = kills;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		kills = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(kills);
	}

	@Override
	public void handleClientSide(MessageSyncPredatorCap message, EntityPlayer player)
	{
		IPredator cap = Predator.getCap(player);
		if (cap != null)
			cap.setKills(player, message.kills);
	}

	@Override
	public void handleServerSide(MessageSyncPredatorCap message, EntityPlayer player)
	{

	}
}
