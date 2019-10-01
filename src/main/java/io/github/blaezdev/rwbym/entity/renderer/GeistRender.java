package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityGeist;
import io.github.blaezdev.rwbym.entity.ModelGeist;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GeistRender extends RenderLivingBase<EntityGeist>
{

    public static GeistRender.Factory FACTORY = new GeistRender.Factory();

    public GeistRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityGeist entity) {
        return false;
    }

    protected void preRenderCallback(EntityGeist entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(0.75F, 0.75F, 0.75F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGeist entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/geist.png");
    }

    public static class Factory implements IRenderFactory<EntityGeist> {

        @Override
        public Render<? super EntityGeist> createRenderFor(RenderManager manager) {
            return new GeistRender(manager, new ModelGeist(), 0);
        }

    }

}
