package be.bluexin.rwbym.utility.network;

import be.bluexin.rwbym.Semblances;
import be.bluexin.rwbym.capabilities.Aura.Aura;
import be.bluexin.rwbym.capabilities.Aura.AuraProvider;
import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.Ruby.RubyProvider;
import be.bluexin.rwbym.utility.RWBYConfig;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;

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
				player.getCapability(AuraProvider.AURA_CAP, null).delayRecharge(RWBYConfig.delayticks);
    	}
    	else {
    		CapabilityHandler.getCurrentSemblance(player).deActivate(player);
    	}
    }
}
