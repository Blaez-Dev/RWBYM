package io.github.blaezdev.rwbym.weaponry;

import io.github.blaezdev.rwbym.entity.EntityBullet;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

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
        entity.doRender( entity, x, y, z, entityYaw, partialTicks);
	}
}
