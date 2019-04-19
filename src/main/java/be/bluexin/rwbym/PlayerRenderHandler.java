package be.bluexin.rwbym;

import java.util.HashMap;
import java.util.Map;

import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ISemblance;
import be.bluexin.rwbym.capabilities.Ruby.IRuby;
import be.bluexin.rwbym.capabilities.Ruby.RubyProvider;
import be.bluexin.rwbym.utility.ExtraInfo;
import be.bluexin.rwbym.utility.network.MessageSendPlayerDataToServer;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerRenderHandler {
	
	public static Map<EntityPlayerSP, ExtraInfo> playerInfo = new HashMap<EntityPlayerSP, ExtraInfo>();
	
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


		if(!event.isCanceled() && renderedPlayer.getHeldItemMainhand().getItem() == RWBYItems.reese && renderedPlayer.getHeldItemMainhand().getOrCreateSubCompound("RWBYM").getInteger("inactive") < 2){
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
				
				ExtraInfo info = playerInfo.get(renderedPlayer);
				
				if (info != null) {
					
					renderedPlayer.prevRenderYawOffset = (float) (info.prevAngle + renderedPlayer.prevRotationYawHead);
					renderedPlayer.renderYawOffset = (float) (info.angle + renderedPlayer.rotationYawHead);
					
					float y1 = renderedPlayer.prevRenderYawOffset;
					float y2 = renderedPlayer.renderYawOffset;
					
					float pt = event.getPartialRenderTick();
					
					float y3 = (1 - pt) * y1 + pt * y2;
					
					GlStateManager.rotate(90 - y3, 0, 1, 0);
					
					float dt = y2 - y1;
					
					double a2 = info.accelR;
					double a1 = info.prevAccelR;
					
					double a = (1 - pt) * a1 + pt * a2;
					
					GlStateManager.rotate((float) (-Math.atan2(a, 0.08) / Math.PI * 180), 1, 0, 0);
					
					double f = 0.08;
					
					a2 = Math.abs(info.motionU) > 0.05 ? info.motionU : 0;
					a1 = Math.abs(info.prevMotionU) > 0.05 ? info.prevMotionU : 0;
					
					double b2 = Math.abs(info.motionF) > 0.05 ? info.motionF : 0;
					double b1 = Math.abs(info.prevMotionF) > 0.05 ? info.prevMotionF : 0;
					
					double ang1 = -Math.atan(a1 / b1) / Math.PI * 180;
					double ang2 = -Math.atan(a2 / b2) / Math.PI * 180;
					
					if (Math.abs(b1) < 0.1) {
						ang1 = 0;
					}
					
					if (Math.abs(b2) < 0.1) {
						ang2 = 0;
					}
					
					ang1 = MathHelper.clamp(ang1, -30, 30);
					ang2 = MathHelper.clamp(ang2, -30, 30);
					
					double ang = (1 - pt) * ang1 + pt * ang2;
										
					GlStateManager.rotate((float) ang, 0, 0, 1);
					
				}
				
				Minecraft.getMinecraft().getItemRenderer().renderItem(renderedPlayer, renderedPlayer.getHeldItemMainhand(), TransformType.HEAD);
			
			GlStateManager.popMatrix();

		}
		
	}

}
