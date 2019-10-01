package io.github.blaezdev.rwbym.utility.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessagePlayerMotionUpdate extends MessageBase<MessagePlayerMotionUpdate> {

	private double x,y,z;
	
	public MessagePlayerMotionUpdate() {}
	
	public MessagePlayerMotionUpdate(EntityPlayer player) {
		x = player.motionX;
		y = player.motionY;
		z = player.motionZ;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
		x = buf.readDouble();
		y = buf.readDouble();
		z = buf.readDouble();

	}

	@Override
	public void toBytes(ByteBuf buf) {

		buf.writeDouble(x);
		buf.writeDouble(y);
		buf.writeDouble(z);
		
	}

	@Override
	public void handleClientSide(MessagePlayerMotionUpdate message, EntityPlayer player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleServerSide(MessagePlayerMotionUpdate message, EntityPlayer player) {

		player.motionX = message.x;
		player.motionY = message.y;
		player.motionZ = message.z;
		
	}

}
