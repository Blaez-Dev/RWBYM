package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityNeverMore;
import io.github.blaezdev.rwbym.entity.ModelNeverMore;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class NeverMoreRender  extends RenderLivingBase<EntityNeverMore> {

    public static NeverMoreRender.Factory FACTORY = new NeverMoreRender.Factory();

    public NeverMoreRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityNeverMore entity) {
        return false;
    }

    protected void preRenderCallback(EntityNeverMore entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(0.2F, 0.2F, 0.2F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityNeverMore entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/nevermore.png");
    }

    public static class Factory implements IRenderFactory<EntityNeverMore> {

        @Override
        public Render<? super EntityNeverMore> createRenderFor(RenderManager manager) {
            return new NeverMoreRender(manager, new ModelNeverMore(), 0);
        }

    }
}
