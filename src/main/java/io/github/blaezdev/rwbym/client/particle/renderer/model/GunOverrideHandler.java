package io.github.blaezdev.rwbym.client.particle.renderer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;

import io.github.blaezdev.rwbym.client.particle.renderer.model.animator.Animator;
import io.github.blaezdev.rwbym.weaponry.specialweapons.guns.ItemGun;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.model.PerspectiveMapWrapper;
import net.minecraftforge.common.model.TRSRTransformation;

public class GunOverrideHandler extends ItemOverrideList {

    private Animator animator;

    public GunOverrideHandler(Animator animator) {
    	super(new ArrayList<>());
        this.animator = animator;
    }
    
    @Nullable
    @Override
    public IBakedModel handleItemState(@Nonnull IBakedModel model, @Nonnull ItemStack stack, @Nullable World worldIn, EntityLivingBase entityIn) {

        if (model instanceof BakedGunModel) {

            BakedGunModel gunModel = (BakedGunModel) model;
            gunModel.setSubTransforms(animator.getSubTransforms(stack, worldIn, entityIn));

            Map<ItemCameraTransforms.TransformType, TRSRTransformation> baseTransforms = animator.getBaseTransforms(stack, worldIn, entityIn);
            PerspectiveMapWrapper.getTransforms(gunModel.getItemCameraTransforms()).forEach((type, transform) -> baseTransforms.put(type, transform.compose(baseTransforms.get(type))));
            gunModel.setCameraTransforms(ImmutableMap.copyOf(baseTransforms));

//            if (stack.getItem() instanceof ItemGun) {
//                gunModel.addAccessories(((ItemGun) stack.getItem()).getAccesories(stack));
//            }

        }

        return model;
    }
}
