package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityUrsa;
import io.github.blaezdev.rwbym.entity.EntityUrsaMajor;
import io.github.blaezdev.rwbym.entity.ModelUrsa;
import io.github.blaezdev.rwbym.entity.ModelUrsaMajor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class UrsaMajorRender extends RenderLivingBase<EntityUrsaMajor> {

    public static Factory FACTORY = new Factory();

    public UrsaMajorRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityUrsaMajor entity) {
        return false;
    }

    protected void preRenderCallback(EntityUrsaMajor entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityUrsaMajor entity) {
        return new ResourceLocation(RWBYModels.MODID, "textures/entity/ursa.png");
    }

    public static class Factory implements IRenderFactory<EntityUrsaMajor> {

        @Override
        public Render<? super EntityUrsaMajor> createRenderFor(RenderManager manager) {
            return new UrsaMajorRender(manager, new ModelUrsaMajor(), 0);
        }

    }
}