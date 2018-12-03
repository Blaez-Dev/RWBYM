package be.bluexin.rwbym.utility.network;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public abstract class MessageBase<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, REQ>{

    @Override
	public REQ onMessage(REQ message, MessageContext ctx) {
		if (ctx.side == Side.SERVER) {
			EntityPlayerMP player = ctx.getServerHandler().player;
			
			if (player == null) {
				return null;
			}
			
			final WorldServer WorldServer = player.getServerWorld();
			
		    WorldServer.addScheduledTask(new Runnable() {
		    	public void run() {
		    		handleServerSide(message, player);
		    	}
		    });

		    return null;
		}
		else {
			
			final Minecraft minecraft = Minecraft.getMinecraft();
			
			minecraft.addScheduledTask(new Runnable() {

				@Override
				public void run() {
					handleClientSide(message, minecraft.player);
				}
				
			});
			return null;
		}
	}

    /**
     * Handle a packet on the client side. Note this occurs after decoding has completed.
     * @param message
     * @param player the player reference
     */
    public abstract void handleClientSide(REQ message, EntityPlayer player);

    /**
     * Handle a packet on the server side. Note this occurs after decoding has completed.
     * @param message
     * @param player the player reference
     */
    public abstract void handleServerSide(REQ message, EntityPlayer player);

}
