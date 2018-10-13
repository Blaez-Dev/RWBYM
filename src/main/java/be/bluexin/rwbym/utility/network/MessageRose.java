package be.bluexin.rwbym.utility.network;

import be.bluexin.rwbym.Semblances;
import be.bluexin.rwbym.capabilities.ruby.RubyProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;

public class MessageRose extends MessageBase<MessageRose>{

	boolean status;
	
	public MessageRose() {}
	
	public MessageRose(boolean status) {
		this.status = status;
	}

    @Override
    public void fromBytes(ByteBuf buf){
    	status = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf){
    	buf.writeBoolean(status);
    }

    @Override
    public void handleClientSide(MessageRose message, EntityPlayer player){

    }

   @Override
    public void handleServerSide(MessageRose message, EntityPlayer player){
    	
    	if (message.status) {
    		//player.getCapability(RubyProvider.RUBY_CAP, null).activate(player);
    	}
    	else {
    		//player.getCapability(RubyProvider.RUBY_CAP, null).setActiveStatus(false);
    	}
    }
}
