package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntitySabyr;
import io.github.blaezdev.rwbym.entity.ModelSabyr;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class SabyrRender extends RenderLivingBase<EntitySabyr> {

    public static Factory FACTORY = new Factory();

    public SabyrRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntitySabyr entity) {
        return false;
    }

    protected void preRenderCallback(EntitySabyr entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySabyr entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/sabyr.png");
    }

    public static class Factory implements IRenderFactory<EntitySabyr> {

        @Override
        public Render<? super EntitySabyr> createRenderFor(RenderManager manager) {
            return new SabyrRender(manager, new ModelSabyr(), 0);
        }

    }
}
