package io.github.blaezdev.rwbym;

import io.github.blaezdev.rwbym.PlayerRenderHandler.LayerAccessories;
import io.github.blaezdev.rwbym.PlayerRenderHandler.Part;
import io.github.blaezdev.rwbym.PlayerRenderHandler.RWBYLayerHeldItem;
import io.github.blaezdev.rwbym.weaponry.RWBYGliderItem;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RWBYRenderPlayer extends RenderPlayer
{
	
    private final boolean smallArms;

	public RWBYRenderPlayer(RenderManager renderManager)
    {
        this(renderManager, false);
    }

    public RWBYRenderPlayer(RenderManager renderManager, boolean useSmallArms)
    {
        super(renderManager, useSmallArms);
        this.smallArms = useSmallArms;
        this.layerRenderers.clear();
        this.addLayer(new LayerElytra(this));
        this.addLayer(new LayerBipedArmor(this));
        this.addLayer(new RWBYLayerHeldItem(this));
        this.addLayer(new LayerArrow(this));
        this.addLayer(new LayerDeadmau5Head(this));
        this.addLayer(new LayerCape(this));
        this.addLayer(new LayerCustomHead(this.getMainModel().bipedHead));
        //this.addLayer(new PlayerRenderHandler.LayerGlider(this));
        this.addLayer(new LayerEntityOnShoulder(renderManager));
        this.addLayer(new LayerAccessories(this.getMainModel().bipedHead, "Head", Part.HEAD, true));
        this.addLayer(new LayerAccessories(this.getMainModel().bipedHead, "Ears", Part.HEAD, false));
        this.addLayer(new LayerAccessories(this.getMainModel().bipedRightArm, "RightArm", Part.RIGHT_ARM, true));
        this.addLayer(new LayerAccessories(this.getMainModel().bipedLeftArm, "LeftArm", Part.LEFT_ARM, true));
        this.addLayer(new LayerAccessories(this.getMainModel().bipedRightLeg, "RightLeg", Part.RIGHT_LEG, true));
        this.addLayer(new LayerAccessories(this.getMainModel().bipedLeftLeg, "LeftLeg", Part.LEFT_LEG, true));
        this.addLayer(new LayerAccessories(this.getMainModel().bipedBody, "Body", Part.BODY, true));
        this.addLayer(new LayerAccessories(this.getMainModel().bipedBody, "Tail", Part.BODY, false));
    }

//    private void setModelVisibilities(AbstractClientPlayer clientPlayer)
//    {
//        ModelPlayer modelplayer = this.getMainModel();
//
//        if (clientPlayer.isSpectator())
//        {
//            modelplayer.setVisible(false);
//            modelplayer.bipedHead.showModel = true;
//            modelplayer.bipedHeadwear.showModel = true;
//        }
//        else
//        {
//            ItemStack itemstack = clientPlayer.getHeldItemMainhand();
//            ItemStack itemstack1 = clientPlayer.getHeldItemOffhand();
//            modelplayer.setVisible(true);
//            modelplayer.bipedHeadwear.showModel = clientPlayer.isWearing(EnumPlayerModelParts.HAT);
//            modelplayer.bipedBodyWear.showModel = clientPlayer.isWearing(EnumPlayerModelParts.JACKET);
//            modelplayer.bipedLeftLegwear.showModel = clientPlayer.isWearing(EnumPlayerModelParts.LEFT_PANTS_LEG);
//            modelplayer.bipedRightLegwear.showModel = clientPlayer.isWearing(EnumPlayerModelParts.RIGHT_PANTS_LEG);
//            modelplayer.bipedLeftArmwear.showModel = clientPlayer.isWearing(EnumPlayerModelParts.LEFT_SLEEVE);
//            modelplayer.bipedRightArmwear.showModel = clientPlayer.isWearing(EnumPlayerModelParts.RIGHT_SLEEVE);
//            modelplayer.isSneak = clientPlayer.isSneaking();
//            ModelBiped.ArmPose modelbiped$armpose = ModelBiped.ArmPose.EMPTY;
//            ModelBiped.ArmPose modelbiped$armpose1 = ModelBiped.ArmPose.EMPTY;
//
//            if (!itemstack.isEmpty())
//            {
//                modelbiped$armpose = ModelBiped.ArmPose.ITEM;
//
//                if (clientPlayer.getItemInUseCount() > 0)
//                {
//                    EnumAction enumaction = itemstack.getItemUseAction();
//
//                    if (enumaction == EnumAction.BLOCK)
//                    {
//                        modelbiped$armpose = ModelBiped.ArmPose.BLOCK;
//                    }
//                    else if (enumaction == EnumAction.BOW)
//                    {
//                        modelbiped$armpose = ModelBiped.ArmPose.BOW_AND_ARROW;
//                    }
//                }
//            }
//
//            if (!itemstack1.isEmpty())
//            {
//                modelbiped$armpose1 = ModelBiped.ArmPose.ITEM;
//
//                if (clientPlayer.getItemInUseCount() > 0)
//                {
//                    EnumAction enumaction1 = itemstack1.getItemUseAction();
//
//                    if (enumaction1 == EnumAction.BLOCK)
//                    {
//                        modelbiped$armpose1 = ModelBiped.ArmPose.BLOCK;
//                    }
//                    // FORGE: fix MC-88356 allow offhand to use bow and arrow animation
//                    else if (enumaction1 == EnumAction.BOW)
//                    {
//                        modelbiped$armpose1 = ModelBiped.ArmPose.BOW_AND_ARROW;
//                    }
//                }
//            }
//
//            if (clientPlayer.getPrimaryHand() == EnumHandSide.RIGHT)
//            {
//                modelplayer.rightArmPose = modelbiped$armpose;
//                modelplayer.leftArmPose = modelbiped$armpose1;
//            }
//            else
//            {
//                modelplayer.rightArmPose = modelbiped$armpose1;
//                modelplayer.leftArmPose = modelbiped$armpose;
//            }
//        }
//    }
//
//    public void renderRightArm(AbstractClientPlayer clientPlayer)
//    {
//        float f = 1.0F;
//        GlStateManager.color(1.0F, 1.0F, 1.0F);
//        float f1 = 0.0625F;
//        ModelPlayer modelplayer = this.getMainModel();
//        this.setModelVisibilities(clientPlayer);
//        GlStateManager.enableBlend();
//        modelplayer.swingProgress = 0.0F;
//        modelplayer.isSneak = false;
//        modelplayer.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, clientPlayer);
//        modelplayer.bipedRightArm.rotateAngleX = 0.0F;
//        modelplayer.bipedRightArm.render(0.0625F);
//        modelplayer.bipedRightArmwear.rotateAngleX = 0.0F;
//        modelplayer.bipedRightArmwear.render(0.0625F);
//        GlStateManager.disableBlend();
//    }
//
//    public void renderLeftArm(AbstractClientPlayer clientPlayer)
//    {
//        float f = 1.0F;
//        GlStateManager.color(1.0F, 1.0F, 1.0F);
//        float f1 = 0.0625F;
//        ModelPlayer modelplayer = this.getMainModel();
//        this.setModelVisibilities(clientPlayer);
//        GlStateManager.enableBlend();
//        modelplayer.isSneak = false;
//        modelplayer.swingProgress = 0.0F;
//        modelplayer.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, clientPlayer);
//        modelplayer.bipedLeftArm.rotateAngleX = 0.0F;
//        modelplayer.bipedLeftArm.render(0.0625F);
//        modelplayer.bipedLeftArmwear.rotateAngleX = 0.0F;
//        modelplayer.bipedLeftArmwear.render(0.0625F);
//        GlStateManager.disableBlend();
//    }
}