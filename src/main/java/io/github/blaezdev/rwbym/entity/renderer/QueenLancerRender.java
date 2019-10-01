package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityQueenLancer;
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
public class QueenLancerRender extends RenderBiped<EntityQueenLancer>
{

    public static QueenLancerRender.Factory FACTORY = new QueenLancerRender.Factory();

    public QueenLancerRender(RenderManager renderManagerIn, ModelBiped modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityQueenLancer entity) {
        return false;
    }

    protected void preRenderCallback(EntityQueenLancer entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(5F, 3F, 5F);
        GlStateManager.translate(0F, 0.5F, 0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityQueenLancer entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/lancer.png");
    }

    public static class Factory implements IRenderFactory<EntityQueenLancer> {

        @Override
        public Render<? super EntityQueenLancer> createRenderFor(RenderManager manager) {
            return new QueenLancerRender(manager, new ModelLancer(), 0);
        }

    }

}