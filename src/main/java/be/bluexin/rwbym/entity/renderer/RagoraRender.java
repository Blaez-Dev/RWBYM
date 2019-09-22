package be.bluexin.rwbym.entity.renderer;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityRagora;
import be.bluexin.rwbym.entity.ModelRagora;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RagoraRender extends RenderLiving<EntityRagora> {

    public static RagoraRender.Factory FACTORY = new RagoraRender.Factory();

    public RagoraRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityRagora entity) {
        return false;
    }

    protected void preRenderCallback(EntityRagora entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1F, 1F, 1F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityRagora entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/modelragora.png");
    }
    
    @Override
    protected void applyRotations(EntityRagora entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
    }

    public static class Factory implements IRenderFactory<EntityRagora> {

        @Override
        public Render<? super EntityRagora> createRenderFor(RenderManager manager) {
            return new RagoraRender(manager, new ModelRagora(), 0);
        }

    }

}
