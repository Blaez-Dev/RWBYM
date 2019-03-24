package be.bluexin.rwbym;

import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ISemblance;
import be.bluexin.rwbym.capabilities.Ruby.IRuby;
import be.bluexin.rwbym.capabilities.Ruby.RubyProvider;
import be.bluexin.rwbym.utility.network.MessageGetPlayerData;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
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
		EntityPlayer renderedPlayer = event.getEntityPlayer();
		
		EntityPlayer renderingPlayer = Minecraft.getMinecraft().player;

		ISemblance semblance = CapabilityHandler.getCurrentSemblance(renderedPlayer);
		 
		if (semblance != null) {
			if (semblance.isInvisible()) {
				event.setCanceled(true);
				renderedPlayer.setInvisible(true);
			}
			else if (!renderedPlayer.isPotionActive(Potion.getPotionFromResourceLocation("invisibility"))) {
				renderedPlayer.setInvisible(false);
			}
		}


		if(renderedPlayer.getActiveItemStack().getItem() == RWBYItems.reese){
			renderedPlayer.limbSwingAmount = 0;
			renderedPlayer.prevLimbSwingAmount = 0;
			GlStateManager.pushMatrix();				
				if (renderedPlayer.isSneaking()) {
					GlStateManager.translate(0, -0.125, 0);
				}
				
				GlStateManager.translate(0, 0.1, 0);
				
				if (Minecraft.getMinecraft().player != renderedPlayer) {
					GlStateManager.translate(renderedPlayer.posX - renderingPlayer.posX, renderedPlayer.posY - renderingPlayer.posY, renderedPlayer.posZ - renderingPlayer.posZ);
				}
				
				float y1 = renderedPlayer.prevRenderYawOffset;
				float y2 = renderedPlayer.renderYawOffset;
				
				float pt = event.getPartialRenderTick();
				
				float y3 = (1 - pt) * y1 + pt * y2;
				
				GlStateManager.rotate(90 - y3, 0, 1, 0);
				
				Minecraft.getMinecraft().getItemRenderer().renderItem(renderedPlayer, renderedPlayer.getActiveItemStack(), TransformType.HEAD);
			
			GlStateManager.popMatrix();

		}
		
	}

	@SubscribeEvent
	public void PlayerRenderEvent2(RenderPlayerEvent.Post event) {

		if(popped){
			GlStateManager.popMatrix();
			popped = false;
		}

	}
}
