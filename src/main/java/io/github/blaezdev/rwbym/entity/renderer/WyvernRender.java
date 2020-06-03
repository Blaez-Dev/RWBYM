package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityWyvern;
import io.github.blaezdev.rwbym.entity.ModelWyvern;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class WyvernRender extends RenderLivingBase<EntityWyvern> {

    public static Factory FACTORY = new Factory();

    public WyvernRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityWyvern entity) {
        return false;
    }

    protected void preRenderCallback(EntityWyvern entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(3.5F, 3.5F, 3.5F);
        GlStateManager.translate(0, 1F, 0);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWyvern entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/wyvern.png");
    }

    public static class Factory implements IRenderFactory<EntityWyvern> {

        @Override
        public Render<? super EntityWyvern> createRenderFor(RenderManager manager) {
            return new WyvernRender(manager, new ModelWyvern(), 0);
        }

    }
}