package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityZwei;
import io.github.blaezdev.rwbym.entity.ModelZwei;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class ZweiRender extends RenderLivingBase<EntityZwei> {

    public static Factory FACTORY = new Factory();

    public ZweiRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityZwei entity) {
        return false;
    }

    protected void preRenderCallback(EntityZwei entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1F, 1F, 1F);
        GlStateManager.translate(0F,0.15F,0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityZwei entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/zwei.png");
    }

    public static class Factory implements IRenderFactory<EntityZwei> {

        @Override
        public Render<? super EntityZwei> createRenderFor(RenderManager manager) {
            return new ZweiRender(manager, new ModelZwei(), 0);
        }

    }
}