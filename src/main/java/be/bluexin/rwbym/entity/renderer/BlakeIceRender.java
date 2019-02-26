package be.bluexin.rwbym.entity.renderer;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityBlakeIce;
import be.bluexin.rwbym.entity.EntityBlakeIce;
import be.bluexin.rwbym.entity.EntityBlakeIce;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class BlakeIceRender extends RenderBiped<EntityBlakeIce>
{

    public static BlakeIceRender.Factory FACTORY = new BlakeIceRender.Factory();

    public BlakeIceRender(RenderManager renderManagerIn, ModelBiped modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityBlakeIce entity) {
        return false;
    }

    protected void preRenderCallback(EntityBlakeIce entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1F, 1F, 1F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBlakeIce entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/blakeice.png");
    }

    public static class Factory implements IRenderFactory<EntityBlakeIce> {

        @Override
        public Render<? super EntityBlakeIce> createRenderFor(RenderManager manager) {
            return new BlakeIceRender(manager, new ModelBiped(), 0);
        }

    }

}