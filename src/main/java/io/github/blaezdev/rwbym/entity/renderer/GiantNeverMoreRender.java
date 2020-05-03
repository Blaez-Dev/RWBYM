package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityGiantNeverMore;
import io.github.blaezdev.rwbym.entity.ModelNeverMore;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class GiantNeverMoreRender extends RenderLivingBase<EntityGiantNeverMore> {

    public static GiantNeverMoreRender.Factory FACTORY = new GiantNeverMoreRender.Factory();

    public GiantNeverMoreRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityGiantNeverMore entity) {
        return false;
    }

    protected void preRenderCallback(EntityGiantNeverMore entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(2F, 2F, 2F);
        GlStateManager.translate(0F,2F,0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGiantNeverMore entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/nevermore.png");
    }

    public static class Factory implements IRenderFactory<EntityGiantNeverMore> {

        @Override
        public Render<? super EntityGiantNeverMore> createRenderFor(RenderManager manager) {
            return new GiantNeverMoreRender(manager, new ModelNeverMore(), 0);
        }

    }
}