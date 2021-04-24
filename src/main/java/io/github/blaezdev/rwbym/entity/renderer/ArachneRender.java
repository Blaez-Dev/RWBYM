package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityArachne;
import io.github.blaezdev.rwbym.entity.ModelArachne;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class ArachneRender extends RenderLivingBase<EntityArachne> {

    public static Factory FACTORY = new Factory();

    public ArachneRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityArachne entity) {
        return false;
    }

    protected void preRenderCallback(EntityArachne entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(0.2F, 0.2F, 0.2F);
        GlStateManager.translate(0, 0, 0);
        GlStateManager.rotate(0,0,180,0);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityArachne entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/arachne.png");
    }

    public static class Factory implements IRenderFactory<EntityArachne> {

        @Override
        public Render<? super EntityArachne> createRenderFor(RenderManager manager) {
            return new ArachneRender(manager, new ModelArachne(), 0);
        }

    }
}