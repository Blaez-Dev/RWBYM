package be.bluexin.rwbym.utility.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class RWBYNetworkHandler {
	
    private static SimpleNetworkWrapper INSTANCE;
    
    private static int i = 0;
    
    public static void init() {
    	
	    INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("rwbym");
	
	    int i = 0;
	    
	    registerMessage(MessageActivateSemblance.class, Side.SERVER);
	    registerMessage(MessageSendPlayerDataToServer.class, Side.SERVER);
	    registerMessage(MessageSendPlayerData.class, Side.CLIENT);
	    registerMessage(MessagePosVelUpdate.class, Side.CLIENT);
	    registerMessage(MessagePlayerMotionUpdate.class, Side.SERVER);
	    registerMessage(MessagePlayerEXP.class, Side.SERVER);
	    registerMessage(MessageCycleLevel.class, Side.SERVER);
	    registerMessage(MessageSendRequest.class, Side.SERVER);
	    registerMessage(MessageConfirmRequest.class, Side.SERVER);
	    registerMessage(MessageDenyRequest.class, Side.SERVER);
	    registerMessage(MessageSendTeams.class, Side.CLIENT);
	    registerMessage(MessageLeaveTeam.class, Side.SERVER);
	    
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
    
    private static <T extends MessageBase> void registerMessage(Class<T> clazz, Side side) {
    	INSTANCE.registerMessage((Class<? extends IMessageHandler<T, T>>)clazz, clazz, i++, side);
    }
}
