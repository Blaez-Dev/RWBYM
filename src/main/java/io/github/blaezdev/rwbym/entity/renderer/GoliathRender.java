package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityGoliath;
import io.github.blaezdev.rwbym.entity.ModelGoliath;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class GoliathRender extends RenderLivingBase<EntityGoliath> {

    public static Factory FACTORY = new Factory();

    public GoliathRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityGoliath entity) {
        return false;
    }

    protected void preRenderCallback(EntityGoliath entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(4.5F, 4.5F, 4.5F);
        GlStateManager.translate(0, 0, 0);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGoliath entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/goliath.png");
    }

    public static class Factory implements IRenderFactory<EntityGoliath> {

        @Override
        public Render<? super EntityGoliath> createRenderFor(RenderManager manager) {
            return new GoliathRender(manager, new ModelGoliath(), 0);
        }

    }
}
