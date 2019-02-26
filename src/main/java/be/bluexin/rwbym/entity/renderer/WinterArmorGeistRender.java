package be.bluexin.rwbym.entity.renderer;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityArmorgeist;
import be.bluexin.rwbym.entity.EntityWinterArmorgeist;
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
public class WinterArmorGeistRender extends RenderBiped<EntityWinterArmorgeist>
{

    public static WinterArmorGeistRender.Factory FACTORY = new WinterArmorGeistRender.Factory();

    public WinterArmorGeistRender(RenderManager renderManagerIn, ModelBiped modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityWinterArmorgeist entity) {
        return false;
    }

    protected void preRenderCallback(EntityWinterArmorgeist entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWinterArmorgeist entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/winter_armorgeist.png");
    }

    public static class Factory implements IRenderFactory<EntityWinterArmorgeist> {

        @Override
        public Render<? super EntityWinterArmorgeist> createRenderFor(RenderManager manager) {
            return new WinterArmorGeistRender(manager, new ModelBiped(), 0);
        }

    }

}
