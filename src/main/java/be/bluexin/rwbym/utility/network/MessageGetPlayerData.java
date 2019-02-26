package be.bluexin.rwbym.utility.network;

import be.bluexin.rwbym.capabilities.Ruby.IRuby;
import be.bluexin.rwbym.capabilities.Ruby.RubyProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class MessageGetPlayerData extends MessageBase<MessageGetPlayerData> {
	
	private String name;
	
	public MessageGetPlayerData() {}
	
	public MessageGetPlayerData(String name) {
		this.name = name;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		name = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, name);
	}

	@Override
	public void handleClientSide(MessageGetPlayerData message, EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleServerSide(MessageGetPlayerData message, EntityPlayer player) {
		EntityPlayer requestedPlayer = player.world.getPlayerEntityByName(message.name);
		if (requestedPlayer == null) {
			System.out.println("Player Not Found");
		}
		else {
			IRuby Ruby = requestedPlayer.getCapability(RubyProvider.RUBY_CAP, null);
			RWBYNetworkHandler.sendToClient(new MessageSendPlayerData(Ruby, message.name), (EntityPlayerMP) player);
		}
	}

}
