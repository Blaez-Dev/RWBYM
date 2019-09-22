package be.bluexin.rwbym.entity.renderer;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityStore;
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
public class StoreRender extends RenderBiped<EntityStore>
{

    public static StoreRender.Factory FACTORY = new StoreRender.Factory();

    public StoreRender(RenderManager renderManagerIn, ModelBiped modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityStore entity) {
        return false;
    }

    protected void preRenderCallback(EntityStore entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1F, 1F, 1F);
        this.setModelVisibilities(entitylivingbaseIn);
    }


    public ModelPlayer getMainModel() {
        return (ModelPlayer)super.getMainModel();}

    @Override
    protected ResourceLocation getEntityTexture(EntityStore entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/shop.png");
    }

    private void setModelVisibilities(EntityStore entitylivingbaseIn) {
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

    public static class Factory implements IRenderFactory<EntityStore> {

        @Override
        public Render<? super EntityStore> createRenderFor(RenderManager manager) {
            return new StoreRender(manager, new ModelPlayer(0.5F, false), 0);
        }

    }

}