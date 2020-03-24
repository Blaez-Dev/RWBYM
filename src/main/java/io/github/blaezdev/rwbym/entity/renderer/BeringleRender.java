package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityUrsa;
import io.github.blaezdev.rwbym.entity.EntityBeringle;
import io.github.blaezdev.rwbym.entity.ModelUrsa;
import io.github.blaezdev.rwbym.entity.ModelBeringle;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class BeringleRender extends RenderLivingBase<EntityBeringle> {

    public static Factory FACTORY = new Factory();

    public BeringleRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityBeringle entity) {
        return false;
    }

    protected void preRenderCallback(EntityBeringle entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBeringle entity) {
        return new ResourceLocation(RWBYModels.MODID, "textures/entity/beringle.png");
    }

    public static class Factory implements IRenderFactory<EntityBeringle> {

        @Override
        public Render<? super EntityBeringle> createRenderFor(RenderManager manager) {
            return new BeringleRender(manager, new ModelBeringle(), 0);
        }

    }
}
