package be.bluexin.rwbym.utility.network;

import be.bluexin.rwbym.capabilities.CapabilityHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageActivateSemblance extends MessageBase<MessageActivateSemblance>{

	boolean activate;
	
	public MessageActivateSemblance() {}
	
	public MessageActivateSemblance(boolean activate) {
		this.activate = activate;
	}

    @Override
    public void fromBytes(ByteBuf buf){
    	activate = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf){
    	buf.writeBoolean(activate);
    }

    @Override
    public void handleClientSide(MessageActivateSemblance message, EntityPlayer player){

    }

   @Override
    public void handleServerSide(MessageActivateSemblance message, EntityPlayer player){
    	
    	if (message.activate) {
    		CapabilityHandler.getCurrentSemblance(player).onActivate(player);
    	}
    	else {
    		CapabilityHandler.getCurrentSemblance(player).deActivate(player);
    	}
    }
}
