package io.github.blaez-dev.rwbym.utility.network;

import io.github.blaez-dev.rwbym.RWBYModels;
import io.github.blaez-dev.rwbym.capabilities.Aura.AuraProvider;
import io.github.blaez-dev.rwbym.capabilities.Aura.IAura;
import io.github.blaez-dev.rwbym.capabilities.Ruby.IRuby;
import io.github.blaez-dev.rwbym.capabilities.Ruby.RubyProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
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
			IAura aura = requestedPlayer.getCapability(AuraProvider.AURA_CAP, null);
			RWBYNetworkHandler.sendToClient(new MessageSendPlayerData(Ruby, aura, requestedPlayer.getEntityData().getCompoundTag(RWBYModels.MODID), message.name), (EntityPlayerMP) player);
		}
	}

}
