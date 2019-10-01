package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityBoarbatusk;
import io.github.blaezdev.rwbym.entity.ModelBoarbatusk;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class BoarbatuskRender extends RenderLivingBase<EntityBoarbatusk> {

    public static Factory FACTORY = new Factory();

    public BoarbatuskRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityBoarbatusk entity) {
        return false;
    }

    protected void preRenderCallback(EntityBoarbatusk entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBoarbatusk entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/boarbatusk.png");
    }

    public static class Factory implements IRenderFactory<EntityBoarbatusk> {

        @Override
        public Render<? super EntityBoarbatusk> createRenderFor(RenderManager manager) {
            return new BoarbatuskRender(manager, new ModelBoarbatusk(), 0);
        }

    }
}
