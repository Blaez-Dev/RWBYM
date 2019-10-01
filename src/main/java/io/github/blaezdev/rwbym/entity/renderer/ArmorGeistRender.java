package io.github.blaezdev.rwbym.entity.renderer;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityArmorgeist;
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
public class ArmorGeistRender extends RenderBiped<EntityArmorgeist>
{

    public static ArmorGeistRender.Factory FACTORY = new ArmorGeistRender.Factory();

    public ArmorGeistRender(RenderManager renderManagerIn, ModelBiped modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityArmorgeist entity) {
        return false;
    }

    protected void preRenderCallback(EntityArmorgeist entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(3F, 3F, 3F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityArmorgeist entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/armorgeist.png");
    }

    public static class Factory implements IRenderFactory<EntityArmorgeist> {

        @Override
        public Render<? super EntityArmorgeist> createRenderFor(RenderManager manager) {
            return new ArmorGeistRender(manager, new ModelBiped(), 0);
        }

    }

}