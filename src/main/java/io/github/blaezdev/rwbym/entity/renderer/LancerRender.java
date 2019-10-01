package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityLancer;
import io.github.blaezdev.rwbym.entity.ModelLancer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LancerRender extends RenderBiped<EntityLancer>
{

    public static LancerRender.Factory FACTORY = new LancerRender.Factory();

    public LancerRender(RenderManager renderManagerIn, ModelBiped modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityLancer entity) {
        return false;
    }

    protected void preRenderCallback(EntityLancer entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1F, 1F, 1F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLancer entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/lancer.png");
    }

    public static class Factory implements IRenderFactory<EntityLancer> {

        @Override
        public Render<? super EntityLancer> createRenderFor(RenderManager manager) {
            return new LancerRender(manager, new ModelLancer(), 0);
        }

    }

}