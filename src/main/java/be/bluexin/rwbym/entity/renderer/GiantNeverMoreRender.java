package be.bluexin.rwbym.entity.renderer;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityGiantNeverMore;
import be.bluexin.rwbym.entity.EntityNeverMore;
import be.bluexin.rwbym.entity.ModelNeverMore;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class GiantNeverMoreRender extends RenderLivingBase<EntityGiantNeverMore> {

    public static GiantNeverMoreRender.Factory FACTORY = new GiantNeverMoreRender.Factory();

    public GiantNeverMoreRender(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityGiantNeverMore entity) {
        return false;
    }

    protected void preRenderCallback(EntityGiantNeverMore entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(4F, 4F, 4F);
        GlStateManager.translate(0F, 0.3F, -0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGiantNeverMore entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/nevermore.png");
    }

    public static class Factory implements IRenderFactory<EntityGiantNeverMore> {

        @Override
        public Render<? super EntityGiantNeverMore> createRenderFor(RenderManager manager) {
            return new GiantNeverMoreRender(manager, new ModelNeverMore(), 0);
        }

    }
}