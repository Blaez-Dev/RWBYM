package be.bluexin.rwbym.weaponry;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityBullet;

/**
 * Part of rwbym by Bluexin.
 *
 * @author Bluexin
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class RWBYAmmoRender extends RenderArrow<EntityBullet> {

    public RWBYAmmoRender(RenderManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBullet entity) {
        return entity.getTexture();
    }
    
    @Override
	public void doRender(EntityBullet entity, double x, double y, double z, float entityYaw, float partialTicks) {
    	
    	ItemStack stack = entity.getStackForRender();
    	
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.pushMatrix();
        //GlStateManager.disableLighting();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
        
        Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.HEAD);
		GlStateManager.popMatrix();
	}
}
