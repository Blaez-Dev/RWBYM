package be.bluexin.rwbym.entity.renderer;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityCrowBar;
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
public class CrowBarRender extends RenderBiped<EntityCrowBar>
{

    public static CrowBarRender.Factory FACTORY = new CrowBarRender.Factory();

    public CrowBarRender(RenderManager renderManagerIn, ModelBiped modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityCrowBar entity) {
        return false;
    }

    protected void preRenderCallback(EntityCrowBar entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1F, 1F, 1F);
        this.setModelVisibilities(entitylivingbaseIn);
    }


    public ModelPlayer getMainModel() {
        return (ModelPlayer)super.getMainModel();}

    @Override
    protected ResourceLocation getEntityTexture(EntityCrowBar entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/crowbar.png");
    }

    private void setModelVisibilities(EntityCrowBar entitylivingbaseIn) {
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

    public static class Factory implements IRenderFactory<EntityCrowBar> {

        @Override
        public Render<? super EntityCrowBar> createRenderFor(RenderManager manager) {
            return new CrowBarRender(manager, new ModelPlayer(0.5F, true), 0);
        }

    }

}