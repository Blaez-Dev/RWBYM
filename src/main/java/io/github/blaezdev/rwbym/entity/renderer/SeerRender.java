package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntitySeer;
import io.github.blaezdev.rwbym.entity.ModelSeer;
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
public class SeerRender extends RenderLivingBase<EntitySeer>
{

    public static SeerRender.Factory FACTORY = new SeerRender.Factory();

    public SeerRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntitySeer entity) {
        return false;
    }

    protected void preRenderCallback(EntitySeer entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(0.1F, 0.1F, 0.1F);
        GlStateManager.translate(0F, -0.3F, 0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySeer entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/seer.png");
    }

    public static class Factory implements IRenderFactory<EntitySeer> {

        @Override
        public Render<? super EntitySeer> createRenderFor(RenderManager manager) {
            return new SeerRender(manager, new ModelSeer(), 0);
        }

    }

}