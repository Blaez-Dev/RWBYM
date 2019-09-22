package be.bluexin.rwbym.entity.renderer;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityDeathStalker;
import be.bluexin.rwbym.entity.ModelDeathStalker;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class DeathStalkerRender extends RenderLivingBase<EntityDeathStalker> {

    public static Factory FACTORY = new Factory();

    public DeathStalkerRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityDeathStalker entity) {
        return false;
    }

    protected void preRenderCallback(EntityDeathStalker entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(2.5F, 2.5F, 2.5F);
        GlStateManager.translate(0, -0.2, 0);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDeathStalker entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/deathstalker.png");
    }

    public static class Factory implements IRenderFactory<EntityDeathStalker> {

        @Override
        public Render<? super EntityDeathStalker> createRenderFor(RenderManager manager) {
            return new DeathStalkerRender(manager, new ModelDeathStalker(), 0);
        }

    }
}
