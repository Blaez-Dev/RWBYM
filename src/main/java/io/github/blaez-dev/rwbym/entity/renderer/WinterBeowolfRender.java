package io.github.blaez-dev.rwbym.entity.renderer;

import io.github.blaez-dev.rwbym.RWBYModels;
import io.github.blaez-dev.rwbym.entity.EntityBeowolf;
import io.github.blaez-dev.rwbym.entity.EntityWinterBeowolf;
import io.github.blaez-dev.rwbym.entity.ModelWinterbeowolf;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class WinterBeowolfRender extends RenderLivingBase<EntityWinterBeowolf> {

    public static Factory FACTORY = new Factory();

    public WinterBeowolfRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityWinterBeowolf entity) {
        return false;
    }

    protected void preRenderCallback(EntityBeowolf entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1F, 1F, 1F);
        GlStateManager.translate(0, 0, 0);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWinterBeowolf entity) {
        return new ResourceLocation(RWBYModels.MODID, "textures/entity/winter_beowolf.png");
    }

    public static class Factory implements IRenderFactory<EntityWinterBeowolf> {

        @Override
        public Render<? super EntityWinterBeowolf> createRenderFor(RenderManager manager) {
            return new WinterBeowolfRender(manager, new ModelWinterbeowolf(), 0);
        }

    }
}
