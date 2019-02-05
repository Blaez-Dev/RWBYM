package be.bluexin.rwbym;

import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ISemblance;
import be.bluexin.rwbym.capabilities.ruby.IRuby;
import be.bluexin.rwbym.capabilities.ruby.RubyProvider;
import be.bluexin.rwbym.utility.network.MessageGetPlayerData;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerRenderHandler {
	
	@SubscribeEvent
	public void PlayerRenderEvent(RenderPlayerEvent.Pre event) {
		EntityPlayer player = event.getEntityPlayer();

		ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);
		 
		if (semblance != null) {
			if (semblance.isInvisible()) {
				event.setCanceled(true);
				player.setInvisible(true);
			}
			else if (!player.isPotionActive(Potion.getPotionFromResourceLocation("invisibility"))) {
				player.setInvisible(false);
			}
		}
		
	}
}
