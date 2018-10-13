package be.bluexin.rwbym.entity.renderer;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityBoarbatusk;
import be.bluexin.rwbym.entity.EntityWinterBoarbatusk;
import be.bluexin.rwbym.entity.ModelBoarbatusk;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class WinterBoarbatuskRender extends RenderLivingBase<EntityWinterBoarbatusk> {

    public static Factory FACTORY = new Factory();

    public WinterBoarbatuskRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityWinterBoarbatusk entity) {
        return false;
    }

    protected void preRenderCallback(EntityWinterBoarbatusk entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWinterBoarbatusk entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/winter_boarbatusk.png");
    }

    public static class Factory implements IRenderFactory<EntityWinterBoarbatusk> {

        @Override
        public Render<? super EntityWinterBoarbatusk> createRenderFor(RenderManager manager) {
            return new WinterBoarbatuskRender(manager, new ModelBoarbatusk(), 0);
        }

    }
}
