package io.github.blaezdev.rwbym.utility.network;

import io.github.blaezdev.rwbym.capabilities.CapabilityHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageActivateMaiden extends MessageBase<MessageActivateSemblance>{

    boolean activate;

    public MessageActivateMaiden() {}

    public MessageActivateMaiden(boolean activate) {
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
            CapabilityHandler.getCurrentmaiden(player).onActivate(player);
        }
        else {
            CapabilityHandler.getCurrentmaiden(player).deActivate(player);
        }
    }
}
