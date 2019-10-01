package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityJuvenileDeathstalker;
import io.github.blaezdev.rwbym.entity.ModelDeathStalker;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class JuvenileDeathStalkerRender extends RenderLivingBase<EntityJuvenileDeathstalker> {

    public static Factory FACTORY = new Factory();

    public JuvenileDeathStalkerRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityJuvenileDeathstalker entity) {
        return false;
    }

    protected void preRenderCallback(EntityJuvenileDeathstalker entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(0.3F, 0.3F, 0.3F);
        GlStateManager.translate(0, -0.2, 0);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityJuvenileDeathstalker entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/deathstalker.png");
    }

    public static class Factory implements IRenderFactory<EntityJuvenileDeathstalker> {

        @Override
        public Render<? super EntityJuvenileDeathstalker> createRenderFor(RenderManager manager) {
            return new JuvenileDeathStalkerRender(manager, new ModelDeathStalker(), 0);
        }

    }
}