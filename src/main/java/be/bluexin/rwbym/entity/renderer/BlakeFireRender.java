package be.bluexin.rwbym.entity.renderer;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityBlakeFire;
import be.bluexin.rwbym.entity.EntityBlakeFire;
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
public class BlakeFireRender extends RenderBiped<EntityBlakeFire>
{

    public static BlakeFireRender.Factory FACTORY = new BlakeFireRender.Factory();

    public BlakeFireRender(RenderManager renderManagerIn, ModelBiped modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityBlakeFire entity) {
        return false;
    }

    protected void preRenderCallback(EntityBlakeFire entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1F, 1F, 1F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBlakeFire entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/blakefire.png");
    }

    public static class Factory implements IRenderFactory<EntityBlakeFire> {

        @Override
        public Render<? super EntityBlakeFire> createRenderFor(RenderManager manager) {
            return new BlakeFireRender(manager, new ModelBiped(), 0);
        }

    }
    
}
