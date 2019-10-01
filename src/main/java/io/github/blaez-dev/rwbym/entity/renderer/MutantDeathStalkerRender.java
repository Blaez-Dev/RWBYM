package io.github.blaez-dev.rwbym.entity.renderer;

import io.github.blaez-dev.rwbym.RWBYModels;
import io.github.blaez-dev.rwbym.entity.EntityMutantDeathStalker;
import io.github.blaez-dev.rwbym.entity.ModelMutantDeathStalker;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class MutantDeathStalkerRender extends RenderLivingBase<EntityMutantDeathStalker> {

    public static Factory FACTORY = new Factory();

    public MutantDeathStalkerRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityMutantDeathStalker entity) {
        return false;
    }

    protected void preRenderCallback(EntityMutantDeathStalker entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(2.5F, 2.5F, 2.5F);
        GlStateManager.translate(0, -0.2, 0);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMutantDeathStalker entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/deathstalkermutant.png");
    }

    public static class Factory implements IRenderFactory<EntityMutantDeathStalker> {

        @Override
        public Render<? super EntityMutantDeathStalker> createRenderFor(RenderManager manager) {
            return new MutantDeathStalkerRender(manager, new ModelMutantDeathStalker(), 0);
        }

    }
}
