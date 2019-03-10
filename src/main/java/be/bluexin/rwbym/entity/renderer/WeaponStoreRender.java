package be.bluexin.rwbym.entity.renderer;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityWeaponStore;
import be.bluexin.rwbym.entity.EntityWeaponStore;
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
public class WeaponStoreRender extends RenderBiped<EntityWeaponStore>
{

    public static WeaponStoreRender.Factory FACTORY = new WeaponStoreRender.Factory();

    public WeaponStoreRender(RenderManager renderManagerIn, ModelBiped modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    protected boolean canRenderName(EntityWeaponStore entity) {
        return false;
    }

    protected void preRenderCallback(EntityWeaponStore entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1F, 1F, 1F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWeaponStore entity) {
        return new ResourceLocation(RWBYModels.MODID,"textures/entity/shop.png");
    }

    public static class Factory implements IRenderFactory<EntityWeaponStore> {

        @Override
        public Render<? super EntityWeaponStore> createRenderFor(RenderManager manager) {
            return new WeaponStoreRender(manager, new ModelBiped(), 0);
        }

    }

}