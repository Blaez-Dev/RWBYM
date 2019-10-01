package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityApathy;
import io.github.blaezdev.rwbym.entity.ModelApathy;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class ApathyRender extends RenderLivingBase<EntityApathy> {

    public static Factory FACTORY = new Factory();

    public ApathyRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityApathy entity) {
        return false;
    }

    protected void preRenderCallback(EntityApathy entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(0.425F, 0.425F, 0.425F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityApathy entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/apathy.png");
    }

    public static class Factory implements IRenderFactory<EntityApathy> {

        @Override
        public Render<? super EntityApathy> createRenderFor(RenderManager manager) {
            return new ApathyRender(manager, new ModelApathy(), 0);
        }

    }
}