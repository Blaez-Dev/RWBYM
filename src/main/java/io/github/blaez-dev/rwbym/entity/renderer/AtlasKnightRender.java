package io.github.blaez-dev.rwbym.entity.renderer;

import io.github.blaez-dev.rwbym.RWBYModels;
import io.github.blaez-dev.rwbym.entity.EntityAtlasKnight;
import io.github.blaez-dev.rwbym.entity.ModelAtlasKnight;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class AtlasKnightRender extends RenderLivingBase<EntityAtlasKnight> {

    public static Factory FACTORY = new Factory();

    public AtlasKnightRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityAtlasKnight entity) {
        return false;
    }

    protected void preRenderCallback(EntityAtlasKnight entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1F, 1F, 1F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityAtlasKnight entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/atlasknight.png");
    }

    public static class Factory implements IRenderFactory<EntityAtlasKnight> {

        @Override
        public Render<? super EntityAtlasKnight> createRenderFor(RenderManager manager) {
            return new AtlasKnightRender(manager, new ModelAtlasKnight(), 0);
        }

    }
}
