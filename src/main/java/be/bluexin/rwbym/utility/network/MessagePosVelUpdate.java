package be.bluexin.rwbym.utility.network;

import be.bluexin.rwbym.RWBYModels;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class MessagePosVelUpdate extends MessageBase<MessagePosVelUpdate> {

	private double posX, posY, posZ, velX, velY, velZ;
	
	private int id;
	
	public MessagePosVelUpdate() {}
	
	public MessagePosVelUpdate(Entity entity) {
		this.posX = entity.posX;
		this.posY = entity.posY;
		this.posZ = entity.posZ;
		this.velX = entity.motionX;
		this.velY = entity.motionY;
		this.velZ = entity.motionZ;
		this.id = entity.getEntityId();
	}
	
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.posX = buf.readDouble();
		this.posY = buf.readDouble();
		this.posZ = buf.readDouble();
		this.velX = buf.readDouble();
		this.velY = buf.readDouble();
		this.velZ = buf.readDouble();
		this.id = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeDouble(posX);
		buf.writeDouble(posY);
		buf.writeDouble(posZ);
		buf.writeDouble(velX);
		buf.writeDouble(velY);
		buf.writeDouble(velZ);
		buf.writeInt(id);
	}

	@Override
	public void handleClientSide(MessagePosVelUpdate message, EntityPlayer player) {
		Entity entity = player.world.getEntityByID(message.id);
		if (entity != null) {
			RWBYModels.LOGGER.info(message.velY);
			entity.posX = message.posX;
			entity.posY = message.posY;
			entity.posZ = message.posZ;
			entity.motionX = message.velX;
			entity.motionY = message.velY;
			entity.motionZ = message.velZ;
		}
	}

	@Override
	public void handleServerSide(MessagePosVelUpdate message, EntityPlayer player) {

	}

}
