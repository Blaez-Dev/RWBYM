package be.bluexin.rwbym.entity.renderer;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityBlake;
import be.bluexin.rwbym.entity.EntityBlake;
import be.bluexin.rwbym.entity.EntityBlake;
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
public class BlakeRender extends RenderBiped<EntityBlake>
{

    public static BlakeRender.Factory FACTORY = new BlakeRender.Factory();

    public BlakeRender(RenderManager renderManagerIn, ModelBiped modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityBlake entity) {
        return false;
    }

    protected void preRenderCallback(EntityBlake entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1F, 1F, 1F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBlake entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/Blake.png");
    }

    public static class Factory implements IRenderFactory<EntityBlake> {

        @Override
        public Render<? super EntityBlake> createRenderFor(RenderManager manager) {
            return new BlakeRender(manager, new ModelBiped(), 0);
        }

    }

}