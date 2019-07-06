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
import be.bluexin.rwbym.weaponry.ArmourBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
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
		
		renderAccessories(renderedPlayer, event.getRenderer().getMainModel(), event.getPartialRenderTick());
				 
		if (semblance != null) {
			if (semblance.isInvisible()) {
				event.setCanceled(true);
				renderedPlayer.setInvisible(true);
			}
			else if (!renderedPlayer.isPotionActive(Potion.getPotionFromResourceLocation("invisibility"))) {
				renderedPlayer.setInvisible(false);
			}
		}

		if (renderedPlayer.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() instanceof ArmourBase) {
			event.getRenderer().getMainModel().bipedHeadwear.showModel = false;
		}
		else {
			event.getRenderer().getMainModel().bipedHeadwear.showModel = true;
		}
		if (renderedPlayer.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof ArmourBase) {
			event.getRenderer().getMainModel().bipedBodyWear.showModel = false;
			event.getRenderer().getMainModel().bipedLeftArmwear.showModel = false;
			event.getRenderer().getMainModel().bipedRightArmwear.showModel = false;
		}
		else {
			event.getRenderer().getMainModel().bipedBodyWear.showModel = true;
			event.getRenderer().getMainModel().bipedLeftArmwear.showModel = true;
			event.getRenderer().getMainModel().bipedRightArmwear.showModel = true;
		}
		if (renderedPlayer.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof ArmourBase) {
			event.getRenderer().getMainModel().bipedLeftLegwear.showModel = false;
			event.getRenderer().getMainModel().bipedRightLegwear.showModel = false;
		}
		else {
			event.getRenderer().getMainModel().bipedLeftLegwear.showModel = true;
			event.getRenderer().getMainModel().bipedRightLegwear.showModel = true;
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
	
	private void renderAccessories(EntityPlayer player, ModelPlayer model, float partialTicks) {
		
		float entangy = (1 - partialTicks) * player.prevRenderYawOffset + partialTicks * player.renderYawOffset;
		
		GlStateManager.pushMatrix();
		GlStateManager.rotate(entangy, 0, -1, 0);
		
		float larmangx = model.bipedLeftArm.rotateAngleX * 180 / (float)Math.PI;
		float larmangy = model.bipedLeftArm.rotateAngleY * 180 / (float)Math.PI;
		float larmangz = model.bipedLeftArm.rotateAngleZ * 180 / (float)Math.PI;
		
		float rarmangx = model.bipedRightArm.rotateAngleX * 180 / (float)Math.PI;
		float rarmangy = model.bipedRightArm.rotateAngleY * 180 / (float)Math.PI;
		float rarmangz = model.bipedRightArm.rotateAngleZ * 180 / (float)Math.PI;

		GlStateManager.pushMatrix();
		model.bipedLeftArm.isHidden = true;
		
		GlStateManager.scale(0.6, 0.6, 0.6);
		GlStateManager.rotate(180, 0, 1, 0);
		GlStateManager.rotate(135, 1, 0, 0);
		
		GlStateManager.translate(-0.7, -1.2, -1.2);
		if (player.isSneaking()) {
			GlStateManager.translate(0, 0.5, 0.5);
		}
		GlStateManager.pushMatrix();
		GlStateManager.translate(0, -0.4, -0.4);
		GlStateManager.rotate(larmangz, 0, 0, -1);
		GlStateManager.rotate(larmangy, 0, 1, 0);
		GlStateManager.rotate(larmangx, -1, 0, 0);
		GlStateManager.translate(0, 0.4, 0.4);
		renderItem(player, new ItemStack(RWBYItems.emberv));
		GlStateManager.popMatrix();
		GlStateManager.popMatrix();
		GlStateManager.popMatrix();
		
		
	}
	
	private void renderItem(EntityLivingBase entity, ItemStack stack) {
		Minecraft.getMinecraft().getItemRenderer().renderItem(entity, stack, TransformType.HEAD);
	}

}
