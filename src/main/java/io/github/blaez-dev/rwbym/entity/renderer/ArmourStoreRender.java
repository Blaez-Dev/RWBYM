package io.github.blaez-dev.rwbym.entity.renderer;

import io.github.blaez-dev.rwbym.RWBYModels;
import io.github.blaez-dev.rwbym.entity.EntityArmourStore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ArmourStoreRender extends RenderBiped<EntityArmourStore>
{

    public static ArmourStoreRender.Factory FACTORY = new ArmourStoreRender.Factory();

    public ArmourStoreRender(RenderManager renderManagerIn, ModelBiped modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityArmourStore entity) {
        return false;
    }

    protected void preRenderCallback(EntityArmourStore entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1F, 1F, 1F);
        this.setModelVisibilities(entitylivingbaseIn);
    }


    public ModelPlayer getMainModel() {
        return (ModelPlayer)super.getMainModel();}

    @Override
    protected ResourceLocation getEntityTexture(EntityArmourStore entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/armshop.png");
    }

    private void setModelVisibilities(EntityArmourStore entitylivingbaseIn) {
        ModelPlayer modelplayer = this.getMainModel();
        {
            modelplayer.setVisible(true);
            modelplayer.bipedHeadwear.showModel = true;
            modelplayer.bipedBodyWear.showModel = true;
            modelplayer.bipedLeftLegwear.showModel = true;
            modelplayer.bipedRightLegwear.showModel = true;
            modelplayer.bipedLeftArmwear.showModel = true;
            modelplayer.bipedRightArmwear.showModel = true ;
            ModelBiped.ArmPose modelbiped$armpose = ModelBiped.ArmPose.EMPTY;
            ModelBiped.ArmPose modelbiped$armpose1 = ModelBiped.ArmPose.EMPTY;
            {
                modelplayer.rightArmPose = modelbiped$armpose1;
                modelplayer.leftArmPose = modelbiped$armpose;
            }
        }

    }

    public static class Factory implements IRenderFactory<EntityArmourStore> {

        @Override
        public Render<? super EntityArmourStore> createRenderFor(RenderManager manager) {
            return new ArmourStoreRender(manager, new ModelPlayer(0.5F, false), 0);
        }

    }

}