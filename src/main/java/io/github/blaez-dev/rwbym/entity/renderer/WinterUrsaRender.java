package io.github.blaez-dev.rwbym.entity.renderer;

import io.github.blaez-dev.rwbym.RWBYModels;
import io.github.blaez-dev.rwbym.entity.EntityWinterUrsa;
import io.github.blaez-dev.rwbym.entity.ModelUrsa;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class WinterUrsaRender extends RenderLivingBase<EntityWinterUrsa> {

    public static Factory FACTORY = new Factory();

    public WinterUrsaRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityWinterUrsa entity) {
        return false;
    }

    protected void preRenderCallback(EntityWinterUrsa entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWinterUrsa entity) {
        return new ResourceLocation(RWBYModels.MODID, "textures/entity/winter_ursa.png");
    }

    public static class Factory implements IRenderFactory<EntityWinterUrsa> {

        @Override
        public Render<? super EntityWinterUrsa> createRenderFor(RenderManager manager) {
            return new WinterUrsaRender(manager, new ModelUrsa(), 0);
        }

    }
}
