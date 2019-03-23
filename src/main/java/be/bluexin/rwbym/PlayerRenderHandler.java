package be.bluexin.rwbym;

import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ISemblance;
import be.bluexin.rwbym.capabilities.Ruby.IRuby;
import be.bluexin.rwbym.capabilities.Ruby.RubyProvider;
import be.bluexin.rwbym.utility.network.MessageGetPlayerData;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumHand;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerRenderHandler {
	boolean popped;
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


		if(player.getActiveItemStack().getItem() == RWBYItems.reese){
		GlStateManager.pushMatrix();
		GlStateManager.translate(0, 0.4, 0);
		popped = true;}
		
	}

	@SubscribeEvent
	public void PlayerRenderEvent2(RenderPlayerEvent.Post event) {

		EntityPlayer player = event.getEntityPlayer();
		if(popped){
		GlStateManager.popMatrix();
		popped = false;
		}

	}
}
