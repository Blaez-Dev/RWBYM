package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityHollow;
import io.github.blaezdev.rwbym.entity.ModelHollow;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class HollowRender extends RenderLivingBase<EntityHollow> {

    public static Factory FACTORY = new Factory();

    public HollowRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityHollow entity) {
        return false;
    }

    protected void preRenderCallback(EntityHollow entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(0.325F, 0.325F, 0.325F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityHollow entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/hollow.png");
    }

    public static class Factory implements IRenderFactory<EntityHollow> {

        @Override
        public Render<? super EntityHollow> createRenderFor(RenderManager manager) {
            return new HollowRender(manager, new ModelHollow(), 0);
        }

    }
}