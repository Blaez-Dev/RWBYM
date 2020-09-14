package io.github.blaezdev.rwbym.utility;

import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import com.google.common.base.Predicate;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.capabilities.itemdata.ItemDataProvider;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.AnimationControllerShoot;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.AnimationControllerFireSelect.Modes;
import io.github.blaezdev.rwbym.weaponry.specialweapons.guns.ItemGun;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(Side.CLIENT)
public class RWBYClientEventHandler {
	
	private static final ResourceLocation AIM_CIRCLE = new ResourceLocation(RWBYModels.MODID, "textures/overlay/aim_circle.png");

	public static float PrevFOV;
	public static float FOV;
	private static float accuracy;
	private static float prevAccuracy;

	private static float fovModifierHandPrev;
	private static float fovModifierHand;
	
	private static final NoiseGeneratorPerlin PERLIN_NOISE = new NoiseGeneratorPerlin(new Random(), 1);
	
	private static final Predicate<Entity> PLAYERS = new Predicate<Entity>() {

		@Override
		public boolean apply(Entity input) {
			return input instanceof EntityPlayer;
		}

	};
	
	@SubscribeEvent
	public static void onRenderOvelayPre(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == ElementType.CROSSHAIRS) {
			if (Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof ItemGun) {
				event.setCanceled(true);
			}
		}
	}
	
	@SubscribeEvent
	public static void fovUpdateEvent(FOVUpdateEvent event) {
		ItemStack stack = Minecraft.getMinecraft().player.getHeldItemMainhand();
		if (stack.getItem() instanceof ItemGun) {
			NBTTagCompound nbt = Minecraft.getMinecraft().world.getCapability(ItemDataProvider.ITEMDATA_CAP, null).getData().getCompoundTag(Util.getOrCreateTag(stack).getString("UUID"));
			if (nbt.getBoolean("ads")) {
				event.setNewfov(event.getNewfov() * ((ItemGun) stack.getItem()).getZoomFactor(stack));
				prevAccuracy = accuracy;
				accuracy = AnimationControllerShoot.getEntityAccuracy(Minecraft.getMinecraft().player, nbt);
			}
		}
        fovModifierHandPrev = fovModifierHand;
        fovModifierHand += (event.getNewfov() - fovModifierHand) * 0.5F;
        PrevFOV = FOV;
		FOV = fovModifierHand * Minecraft.getMinecraft().gameSettings.fovSetting;
	}
	
	@SubscribeEvent
	public static void fovEvent(EntityViewRenderEvent.FOVModifier event) {
		//FOV = event.getFOV();
		//System.out.println(FOV);
	}
	
	@SubscribeEvent
	public static void onRenderOvelayPost(RenderGameOverlayEvent.Post event) {
		
		EntityPlayer player = Minecraft.getMinecraft().player;
		if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && 
				event.getType() == ElementType.ALL && player.getHeldItemMainhand().getItem() instanceof ItemGun) {
			NBTTagCompound nbt = player.world.getCapability(ItemDataProvider.ITEMDATA_CAP, null).getData().getCompoundTag(Util.getOrCreateTag(player.getHeldItemMainhand()).getString("UUID"));
			if (nbt.getBoolean("ads") && Modes.values()[nbt.getInteger("mode")] != Modes.SAFETY)
			{
				//Minecraft.getMinecraft().getTextureManager().bindTexture(AIM_CIRCLE);
				Minecraft.getMinecraft().renderEngine.bindTexture(AIM_CIRCLE);
				GlStateManager.color(1, 1, 1, 1);
				GlStateManager.enableBlend();
				GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
				GlStateManager.disableAlpha();
				//GlStateManager.disableDepth();
				
				float f = prevAccuracy + (accuracy - prevAccuracy) * event.getPartialTicks() + ((ItemGun) player.getHeldItemMainhand().getItem()).getAccuracy();
				float fov = PrevFOV + (FOV - PrevFOV) * event.getPartialTicks();
				//System.out.println(FOV);
								
				float scale = (float) (Math.tan(f * Math.PI / 360) / Math.tan(fov * Math.PI / 360) / 0.75);
				
				Minecraft mc = Minecraft.getMinecraft();
				
				ScaledResolution scaled = new ScaledResolution(mc);
				int width = scaled.getScaledWidth();
				int height = scaled.getScaledHeight();
				
				GlStateManager.pushMatrix();
				
				GlStateManager.translate(width/2, height/2, 0);
				GlStateManager.rotate((float) PERLIN_NOISE.getValue(0, (mc.world.getTotalWorldTime() + event.getPartialTicks()) * 0.01) * f * 50, 0, 0, 1);

				drawCenteredTexturedModalRect(0, 0, height * scale, height * scale);
				
				GlStateManager.popMatrix();
				
			}
		}
	}
	
	@SubscribeEvent
	public static void onWorldRender(RenderWorldLastEvent event) {
		EntityPlayer player = Minecraft.getMinecraft().player;
		
		List<Entity> list = player.world.getEntitiesInAABBexcluding(player, player.getEntityBoundingBox().grow(64), PLAYERS);
		
		for (Entity entity : list) {
			
			EntityPlayer otherPlayer = (EntityPlayer) entity;
	
			if (otherPlayer.getHeldItemMainhand().getItem() instanceof ItemGun) {
				NBTTagCompound nbt = otherPlayer.world.getCapability(ItemDataProvider.ITEMDATA_CAP, null).getData().getCompoundTag(Util.getOrCreateTag(otherPlayer.getHeldItemMainhand()).getString("UUID"));
				if (nbt.getBoolean("ads") && Modes.values()[nbt.getInteger("mode")] != Modes.SAFETY)
				{								
					prepareDrawingBulletLines(event.getPartialTicks());
					double doubleX = otherPlayer.prevPosX + event.getPartialTicks() * (otherPlayer.posX - otherPlayer.prevPosX);
					double doubleY = otherPlayer.prevPosY + event.getPartialTicks() * (otherPlayer.posY - otherPlayer.prevPosY);
					double doubleZ = otherPlayer.prevPosZ + event.getPartialTicks() * (otherPlayer.posZ - otherPlayer.prevPosZ);
					Vec3d start = new Vec3d(doubleX, doubleY + otherPlayer.getEyeHeight(), doubleZ);
					float f = prevAccuracy + (accuracy - prevAccuracy) * event.getPartialTicks();
					List<Vec3d> lines = ((ItemGun)otherPlayer.getHeldItemMainhand().getItem()).getPredictorLines(otherPlayer, event.getPartialTicks(), f, (ItemGun)otherPlayer.getHeldItemMainhand().getItem(), nbt);
					
					for (Vec3d end : lines) {
						if (end != null) {
							drawBulletLine(start, end);
						}
					}
					
					//drawBulletLine(start, start.add(player.getLookVec().scale(64)));
					//drawBulletLine(new Vec3d(0, player.getEyeHeight(), 0), player.getLookVec().addVector(0, player.getEyeHeight(), 0));
					finishDrawing();
				}
			}
		
		}
	}
	
	@SubscribeEvent
	public static void onPlayerRender(RenderPlayerEvent.Post event) {
//		
//		EntityPlayer player = event.getEntityPlayer();
//		
//		if (player.getHeldItemMainhand().getItem() instanceof ItemGun) {
//			NBTTagCompound nbt = player.world.getCapability(ItemDataProvider.ITEMDATA_CAP, null).getData().getCompoundTag(Util.getOrCreateTag(player.getHeldItemMainhand()).getString("UUID"));
//			if (nbt.getBoolean("ads") && Modes.values()[nbt.getInteger("mode")] != Modes.SAFETY) {
//				prepareDrawingBulletLines(event.getPartialRenderTick());
//				double doubleX = player.prevPosX + event.getPartialRenderTick() * (player.posX - player.prevPosX);
//				double doubleY = player.prevPosY + event.getPartialRenderTick() * (player.posY - player.prevPosY);
//				double doubleZ = player.prevPosZ + event.getPartialRenderTick() * (player.posZ - player.prevPosZ);
//				Vec3d start = new Vec3d(doubleX, doubleY + player.getEyeHeight(), doubleZ);
//				List<Vec3d> lines = ((ItemGun)player.getHeldItemMainhand().getItem()).getPredictorLines(player, (ItemGun)player.getHeldItemMainhand().getItem(), nbt);
//				
//				for (Vec3d end : lines) {
//					if (end != null) {
//						drawBulletLine(start, end);
//					}
//				}
//				
//				//drawBulletLine(start, start.add(player.getLookVec().scale(64)));
//				//drawBulletLine(new Vec3d(0, player.getEyeHeight(), 0), player.getLookVec().addVector(0, player.getEyeHeight(), 0));
//				finishDrawing();
//			}
//		}
	}
	
    public static void drawCenteredTexturedModalRect(float x, float y, float width, float height)
    {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos((double)(x - width/2), (double)(y + height/2), -100).tex(0, 1).endVertex();
        bufferbuilder.pos((double)(x + width/2), (double)(y + height/2), -100).tex(1, 1).endVertex();
        bufferbuilder.pos((double)(x + width/2), (double)(y - height/2), -100).tex(1, 0).endVertex();
        bufferbuilder.pos((double)(x - width/2), (double)(y - height/2), -100).tex(0, 0).endVertex();
        tessellator.draw();
    }
	
	private static void prepareDrawingBulletLines(float pt) {
		Minecraft mc = Minecraft.getMinecraft();
		
		double doubleX = mc.player.prevPosX + pt * (mc.player.posX - mc.player.prevPosX);
		double doubleY = mc.player.prevPosY + pt * (mc.player.posY - mc.player.prevPosY);
		double doubleZ = mc.player.prevPosZ + pt * (mc.player.posZ - mc.player.prevPosZ);

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_ALPHA_TEST);

		GL11.glTranslated(-doubleX, -doubleY, -doubleZ);
		GL11.glColor4d(1, 0, 0, 0.5);
		
		GL11.glBegin(GL11.GL_QUADS);
	}
	
	private static void drawBulletLine(Vec3d start, Vec3d end) {
		
		double size = 0.05;
		
		Vec3d dir = new Vec3d(start.x - end.x, 0, start.z - end.z).normalize().scale(size);

		GL11.glVertex3d(start.x - dir.z, start.y, start.z + dir.x);
		GL11.glVertex3d(start.x + dir.z, start.y, start.z - dir.x);
		GL11.glVertex3d(end.x + dir.z, end.y, end.z - dir.x);
		GL11.glVertex3d(end.x - dir.z, end.y, end.z + dir.x);
		
		GL11.glVertex3d(start.x, start.y + size, start.z);
		GL11.glVertex3d(start.x, start.y - size, start.z);
		GL11.glVertex3d(end.x, end.y - size, end.z );
		GL11.glVertex3d(end.x, end.y + size, end.z);
	}
	
	private static void finishDrawing() {
		GL11.glEnd();
		GL11.glColor4d(1, 1, 1, 1);
		//GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		//GL11.glEnable(GL11.GL_DEPTH_TEST);
		//GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
	}
	
}
