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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class MessageSendPlayerData extends MessageBase<MessageSendPlayerData> {

	private NBTTagCompound semblancenbt = new NBTTagCompound();
	
	private NBTTagCompound auranbt = new NBTTagCompound();
	
	private String capability = "";
	
	private String player = "";
	
	private NBTTagCompound cutomData = new NBTTagCompound();

	public MessageSendPlayerData() {}
	
	public MessageSendPlayerData(ISemblance semblance, IAura aura, NBTTagCompound customData, String player) {
		if (semblance != null) {
			semblance.writeToNBT(semblancenbt);
			this.capability = semblance.getCapability().getName();
		}
		if (aura != null) {
			auranbt = (NBTTagCompound) aura.serialize();
		}
		this.cutomData = customData;
		this.player = player;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		semblancenbt = ByteBufUtils.readTag(buf);
		auranbt = ByteBufUtils.readTag(buf);
		cutomData = ByteBufUtils.readTag(buf);
		capability = ByteBufUtils.readUTF8String(buf);
		player = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, semblancenbt);
		ByteBufUtils.writeTag(buf, auranbt);
		ByteBufUtils.writeTag(buf, cutomData);
		ByteBufUtils.writeUTF8String(buf, capability);
		ByteBufUtils.writeUTF8String(buf, player);
	}

	@Override
	public void handleClientSide(MessageSendPlayerData message, EntityPlayer player) {
		EntityPlayer requestedPlayer = player.world.getPlayerEntityByName(message.player);
		if (requestedPlayer == null) {
			//System.out.println("DATA ERROR");
		}
		else {
			ISemblance semblance = CapabilityHandler.getCapabilityByName(requestedPlayer, message.capability);
			CapabilityHandler.setSemblance(requestedPlayer, semblance.getCapability(), semblance.getLevel());
			semblance.readFromNBT(message.semblancenbt);
			if (requestedPlayer.hasCapability(AuraProvider.AURA_CAP, null) && message.auranbt != null) {
				requestedPlayer.getCapability(AuraProvider.AURA_CAP, null).deserialize(message.auranbt);
			}
			requestedPlayer.getEntityData().setTag(RWBYModels.MODID, cutomData);
		}
	}

	@Override
	public void handleServerSide(MessageSendPlayerData message, EntityPlayer player) {
		
	}
}
