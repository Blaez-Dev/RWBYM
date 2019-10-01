package io.github.blaez-dev.rwbym.entity.renderer;

import io.github.blaez-dev.rwbym.RWBYModels;
import io.github.blaez-dev.rwbym.entity.EntityNuckleeve;
import io.github.blaez-dev.rwbym.entity.ModelNuckleeve;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class NuckleeveRender extends RenderLivingBase<EntityNuckleeve> {

    public static Factory FACTORY = new Factory();

    public NuckleeveRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityNuckleeve entity) {
        return false;
    }

    protected void preRenderCallback(EntityNuckleeve entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityNuckleeve entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/nuckleeve.png");
    }

    public static class Factory implements IRenderFactory<EntityNuckleeve> {

        @Override
        public Render<? super EntityNuckleeve> createRenderFor(RenderManager manager) {
            return new NuckleeveRender(manager, new ModelNuckleeve(), 0);
        }

    }
}
