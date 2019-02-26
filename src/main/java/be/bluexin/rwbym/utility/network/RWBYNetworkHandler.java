package be.bluexin.rwbym.utility.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class RWBYNetworkHandler {
	
    private static SimpleNetworkWrapper INSTANCE;
    
    public static void init() {
    	
	    INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("rwbym");
	
	    int i = 0;
	    
	    INSTANCE.registerMessage(MessageActivateSemblance.class, MessageActivateSemblance.class, i++, Side.SERVER);
	    INSTANCE.registerMessage(MessageGetPlayerData.class, MessageGetPlayerData.class, i++, Side.SERVER);
	    INSTANCE.registerMessage(MessageSendPlayerData.class, MessageSendPlayerData.class, i++, Side.CLIENT);
	    INSTANCE.registerMessage(MessagePosVelUpdate.class, MessagePosVelUpdate.class, i++, Side.CLIENT);
	    
    }
    
    public static void sendToServer(IMessage message){
        INSTANCE.sendToServer(message);
    }
    
    public static void sendToClient(IMessage message, EntityPlayerMP player) {
    	INSTANCE.sendTo(message, player);
    }
    
    public static void sendToAll(IMessage message) {
    	INSTANCE.sendToAll(message);
    }
}
