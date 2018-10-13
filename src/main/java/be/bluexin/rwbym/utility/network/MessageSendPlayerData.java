package be.bluexin.rwbym.utility.network;

import be.bluexin.rwbym.capabilities.ruby.IRuby;
import be.bluexin.rwbym.capabilities.ruby.RubyProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class MessageSendPlayerData extends MessageBase<MessageSendPlayerData> {
	int ITimer;
	int CTimer;
	double playerY;
	boolean active;
	
	String name;

	public MessageSendPlayerData() {}
	
	public MessageSendPlayerData(IRuby Ruby, String name) {
		this.ITimer = Ruby.getInvisibilityTimer();
		this.CTimer = Ruby.getCooldown();
		this.playerY = Ruby.getPlayerY();
		this.active = Ruby.getActiveStatus();
		this.name = name;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		name = ByteBufUtils.readUTF8String(buf);
		ITimer = buf.readInt();
		CTimer = buf.readInt();
		playerY = buf.readDouble();
		active = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, name);
		buf.writeInt(ITimer);
		buf.writeInt(CTimer);
		buf.writeDouble(playerY);
		buf.writeBoolean(active);
	}

	@Override
	public void handleClientSide(MessageSendPlayerData message, EntityPlayer player) {
		/*EntityPlayer requestedPlayer = player.world.getPlayerEntityByName(message.name);
		if (requestedPlayer == null) {
			System.out.println("DATA ERROR");
		}
		else {
			IRuby Ruby = requestedPlayer.getCapability(RubyProvider.RUBY_CAP, null);
			Ruby.setInvisisbilityTimer(message.ITimer);
			Ruby.setCooldownTimer(message.CTimer);
			Ruby.setPlayerY(message.playerY);
			Ruby.setActiveStatus(message.active);
		}*/
	}

	@Override
	public void handleServerSide(MessageSendPlayerData message, EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}
}
