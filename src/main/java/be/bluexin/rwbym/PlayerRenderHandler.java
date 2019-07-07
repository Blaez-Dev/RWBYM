package be.bluexin.rwbym;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.mojang.authlib.GameProfile;

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
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.EnumFacing;
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
				
		//event.getRenderer().addLayer(new LayerAccessories(event.getRenderer().getMainModel().bipedBody));
				 
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
	
	public static void addRenderLayers(Map<String, RenderPlayer> map) {
		for (Entry<String, RenderPlayer> entry : map.entrySet()) {
			ModelPlayer model = entry.getValue().getMainModel();
			entry.getValue().addLayer(new LayerAccessories(model.bipedRightArm));
		}
	}
	
	public static class LayerAccessories implements LayerRenderer<EntityLivingBase> {

		 private final ModelRenderer modelRenderer;

		    public LayerAccessories(ModelRenderer modelRenderer)
		    {
		        this.modelRenderer = modelRenderer;
		    }

		    public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
		    {
		        ItemStack itemstack = new ItemStack(RWBYItems.rgrimmarm);
		        //itemstack = ItemStack.EMPTY;

		        if (!itemstack.isEmpty())
		        {
		            Item item = itemstack.getItem();
		            Minecraft minecraft = Minecraft.getMinecraft();
		            GlStateManager.pushMatrix();

		            if (entitylivingbaseIn.isSneaking())
		            {
		                GlStateManager.translate(0.0F, 0.2F, 0.0F);
		            }

		            boolean flag = entitylivingbaseIn instanceof EntityVillager || entitylivingbaseIn instanceof EntityZombieVillager;

		            if (entitylivingbaseIn.isChild() && !(entitylivingbaseIn instanceof EntityVillager))
		            {
		                float f = 2.0F;
		                float f1 = 1.4F;
		                GlStateManager.translate(0.0F, 0.5F * scale, 0.0F);
		                GlStateManager.scale(0.7F, 0.7F, 0.7F);
		                GlStateManager.translate(0.0F, 16.0F * scale, 0.0F);
		            }
		            this.modelRenderer.isHidden = false;
		            this.modelRenderer.postRender(0.0625F);
		        	this.modelRenderer.isHidden = !itemstack.isEmpty();
		            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

		            if (item == Items.SKULL)
		            {
		                float f2 = 1.1875F;
		                GlStateManager.scale(1.1875F, -1.1875F, -1.1875F);

		                if (flag)
		                {
		                    GlStateManager.translate(0.0F, 0.0625F, 0.0F);
		                }

		                GameProfile gameprofile = null;

		                if (itemstack.hasTagCompound())
		                {
		                    NBTTagCompound nbttagcompound = itemstack.getTagCompound();

		                    if (nbttagcompound.hasKey("SkullOwner", 10))
		                    {
		                        gameprofile = NBTUtil.readGameProfileFromNBT(nbttagcompound.getCompoundTag("SkullOwner"));
		                    }
		                    else if (nbttagcompound.hasKey("SkullOwner", 8))
		                    {
		                        String s = nbttagcompound.getString("SkullOwner");

		                        if (!StringUtils.isBlank(s))
		                        {
		                            gameprofile = TileEntitySkull.updateGameprofile(new GameProfile((UUID)null, s));
		                            nbttagcompound.setTag("SkullOwner", NBTUtil.writeGameProfile(new NBTTagCompound(), gameprofile));
		                        }
		                    }
		                }

		                TileEntitySkullRenderer.instance.renderSkull(-0.5F, 0.0F, -0.5F, EnumFacing.UP, 180.0F, itemstack.getMetadata(), gameprofile, -1, limbSwing);
		            }
		            else if (!(item instanceof ItemArmor) || ((ItemArmor)item).getEquipmentSlot() != EntityEquipmentSlot.HEAD)
		            {
		                float f3 = 0.625F;
		                GlStateManager.translate(0.0F, -0.25F, 0.0F);
		                GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
		                GlStateManager.scale(0.625F, -0.625F, -0.625F);

		                if (flag)
		                {
		                    GlStateManager.translate(0.0F, 0.1875F, 0.0F);
		                }

		                minecraft.getItemRenderer().renderItem(entitylivingbaseIn, itemstack, ItemCameraTransforms.TransformType.HEAD);
		            }

		            GlStateManager.popMatrix();
		        }
		    }

		    public boolean shouldCombineTextures()
		    {
		        return false;
		    }
		
	}
	
	private void renderItem(EntityLivingBase entity, ItemStack stack) {
		Minecraft.getMinecraft().getItemRenderer().renderItem(entity, stack, TransformType.HEAD);
	}
	
	private void renderItemHead(EntityLivingBase entity, ModelPlayer model, ItemStack stack) {
		
		float scale = 0;
		
        Item item = stack.getItem();
        Minecraft minecraft = Minecraft.getMinecraft();
        GlStateManager.pushMatrix();

        if (entity.isSneaking())
        {
            GlStateManager.translate(0.0F, 0.2F, 0.0F);
        }

        boolean flag = entity instanceof EntityVillager || entity instanceof EntityZombieVillager;

        if (entity.isChild() && !(entity instanceof EntityVillager))
        {
            float f = 2.0F;
            float f1 = 1.4F;
            GlStateManager.translate(0.0F, 0.5F * scale, 0.0F);
            GlStateManager.scale(0.7F, 0.7F, 0.7F);
            GlStateManager.translate(0.0F, 16.0F * scale, 0.0F);
        }

        //model.bipedBody.postRender(0.0625F);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        float f3 = 0.625F;
        GlStateManager.translate(0.0F, -0.25F, 0.0F);
        //GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.scale(0.625F, -0.625F, -0.625F);

        if (flag)
        {
            GlStateManager.translate(0.0F, 0.1875F, 0.0F);
        }

        minecraft.getItemRenderer().renderItem(entity, stack, ItemCameraTransforms.TransformType.HEAD);

        GlStateManager.popMatrix();
	}

}
