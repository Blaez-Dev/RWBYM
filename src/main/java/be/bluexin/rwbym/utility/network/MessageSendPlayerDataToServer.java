package be.bluexin.rwbym.utility.network;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ISemblance;
import be.bluexin.rwbym.capabilities.Aura.AuraProvider;
import be.bluexin.rwbym.capabilities.Aura.IAura;
import be.bluexin.rwbym.capabilities.Ruby.IRuby;
import be.bluexin.rwbym.capabilities.Ruby.RubyProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class MessageSendPlayerDataToServer extends MessageBase<MessageSendPlayerDataToServer> {
	
	private String name;
	
	private String semblanceName;
	
	private NBTTagCompound semblanceNBT = new NBTTagCompound(), auraNBT = new NBTTagCompound();
	
	public MessageSendPlayerDataToServer() {}
	
	public MessageSendPlayerDataToServer(EntityPlayer player) {
		this.name = player.getName();
		
		ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);
		IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);
		
		this.semblanceName = semblance.toString();
		semblance.writeToNBT(this.semblanceNBT);
		this.auraNBT = (NBTTagCompound) aura.serialize();
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.name = ByteBufUtils.readUTF8String(buf);
		this.semblanceName = ByteBufUtils.readUTF8String(buf);
		this.semblanceNBT = ByteBufUtils.readTag(buf);
		this.auraNBT = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, name);
		ByteBufUtils.writeUTF8String(buf, semblanceName);
		ByteBufUtils.writeTag(buf, semblanceNBT);
		ByteBufUtils.writeTag(buf, auraNBT);
	}

	@Override
	public void handleClientSide(MessageSendPlayerDataToServer message, EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleServerSide(MessageSendPlayerDataToServer message, EntityPlayer player) {
		EntityPlayer requestedPlayer = player.world.getPlayerEntityByName(message.name);
		if (requestedPlayer == null) {
			System.out.println("Player Not Found");
		}
		else {
			ISemblance semblance = CapabilityHandler.getCurrentSemblance(requestedPlayer);
			IAura aura = requestedPlayer.getCapability(AuraProvider.AURA_CAP, null);
			semblance.readFromNBT(message.semblanceNBT);
			aura.deserialize(message.auraNBT);
			RWBYNetworkHandler.sendToAll(new MessageSendPlayerData(semblance, aura, requestedPlayer.getEntityData().getCompoundTag(RWBYModels.MODID), message.name));
		}
	}

}
