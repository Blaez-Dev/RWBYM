package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityRavager;
import io.github.blaezdev.rwbym.entity.ModelRavager;
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
public class RavagerRender extends RenderLivingBase<EntityRavager>
{

    public static RavagerRender.Factory FACTORY = new RavagerRender.Factory();

    public RavagerRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityRavager entity) {
        return false;
    }

    protected void preRenderCallback(EntityRavager entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(0.5F, 0.5F, 0.55F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityRavager entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/wyvern.png");
    }

    public static class Factory implements IRenderFactory<EntityRavager> {

        @Override
        public Render<? super EntityRavager> createRenderFor(RenderManager manager) {
            return new RavagerRender(manager, new ModelRavager(), 0);
        }

    }

}
