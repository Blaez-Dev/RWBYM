package io.github.blaezdev.rwbym.utility.network;

import io.github.blaezdev.rwbym.utility.network.messages.MessageOpenWindow;
import io.github.blaezdev.rwbym.utility.network.messages.MessageTradingData;
import io.github.blaezdev.rwbym.utility.network.messages.MessageTradingList;
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
	    registerMessage(MessageOpenWindow.class, Side.CLIENT);
	    registerMessage(MessageTradingList.class, Side.CLIENT);
	    registerMessage(MessageTradingData.class, Side.SERVER);
	    registerMessage(MessageGetTeamData.class, Side.SERVER);
	    registerMessage(MessageUpdateFlying.class, Side.SERVER);
	    registerMessage(MessageEject.class, Side.SERVER);
	    registerMessage(MessageUpdateNBT.class, Side.SERVER);
	    registerMessage(MessageUpdateNBT.class, Side.CLIENT);
	    registerMessage(MessagePlaySound.class, Side.SERVER);
	    registerMessage(MessageShoot.class, Side.SERVER);
	    registerMessage(MessageAddToInventory.class, Side.SERVER);
	    registerMessage(MessageSyncItemData.class, Side.CLIENT);
		registerMessage(MoveMessage.class, Side.CLIENT);
		registerMessage(MessageSyncPredatorCap.class, Side.CLIENT);
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


	public static void sendTo(IMessage message, EntityPlayerMP player){
		INSTANCE.sendTo(message, player);
	}

	public static void sendToAllAround(IMessage message, NetworkRegistry.TargetPoint point){
		INSTANCE.sendToAllAround(message, point);
	}

	public static void sendToDimension(IMessage message, int dimensionId){
		INSTANCE.sendToDimension(message, dimensionId);
	}
}
