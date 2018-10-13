package be.bluexin.rwbym.entity.renderer;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityCreep;
import be.bluexin.rwbym.entity.ModelCreep;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class CreepRender extends RenderLivingBase<EntityCreep> {

    public static Factory FACTORY = new Factory();

    public CreepRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityCreep entity) {
        return false;
    }

    protected void preRenderCallback(EntityCreep entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
        GlStateManager.translate(0, 0.3, 0);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCreep entity) {
        return new ResourceLocation(RWBYModels.MODID, "textures/entity/creep.png");
    }

    public static class Factory implements IRenderFactory<EntityCreep> {

        @Override
        public Render<? super EntityCreep> createRenderFor(RenderManager manager) {
            return new CreepRender(manager, new ModelCreep(), 0);
        }

    }
}

