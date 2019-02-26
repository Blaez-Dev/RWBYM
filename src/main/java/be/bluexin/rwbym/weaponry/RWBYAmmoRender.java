package be.bluexin.rwbym.weaponry;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Part of rwbym by Bluexin.
 *
 * @author Bluexin
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class RWBYAmmoRender extends RenderArrow<RWBYAmmoEntity> {

    public RWBYAmmoRender(RenderManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    protected ResourceLocation getEntityTexture(RWBYAmmoEntity entity) {
        return entity.getRs();
    }
}
