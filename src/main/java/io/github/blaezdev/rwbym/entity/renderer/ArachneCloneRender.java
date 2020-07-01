package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityArachneClone;
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
public class ArachneCloneRender extends RenderBiped<EntityArachneClone>
{

    public static ArachneCloneRender.Factory FACTORY = new ArachneCloneRender.Factory();

    public ArachneCloneRender(RenderManager renderManagerIn, ModelBiped modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityArachneClone entity) {
        return false;
    }

    protected void preRenderCallback(EntityArachneClone entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1F, 1F, 1F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityArachneClone entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/blake.png");
    }

    public static class Factory implements IRenderFactory<EntityArachneClone> {

        @Override
        public Render<? super EntityArachneClone> createRenderFor(RenderManager manager) {
            return new ArachneCloneRender(manager, new ModelBiped(), 0);
        }

    }

}
