package io.github.blaezdev.rwbym.weaponry;

import io.github.blaezdev.rwbym.Init.RWBYItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class RWBYGliderItem extends Item {

	public RWBYGliderItem() {
		super();
		setMaxDamage(2500);
		setMaxStackSize(1);
		this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
		{
			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
			{
				if (entityIn == null)
				{
					return 0.0F;
				}
				else
				{
					return entityIn.getActiveItemStack().getItem() != RWBYItems.glider ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
				}
			}
		});
		this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
		{
			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
			{
				return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
			}
		});
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 6000;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		
		playerIn.setActiveHand(handIn);
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}


	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (entityIn instanceof EntityLivingBase && stack == ((EntityLivingBase) entityIn).getActiveItemStack()) {
			EntityLivingBase entity = (EntityLivingBase) entityIn;
			ItemStack offhand = entity.getHeldItemOffhand();
			if (entity.isElytraFlying() && offhand.getItem() == RWBYItems.winddustcrystal) {
                Vec3d vec3d = entity.getLookVec();
                double d0 = 0.5D;
                double d1 = 0.1D;
                entity.motionX += vec3d.x * d1 + (vec3d.x * d0 - entity.motionX) * 0.5D;
                entity.motionY += vec3d.y * d1 + (vec3d.y * d0 - entity.motionY) * 0.5D;
                entity.motionZ += vec3d.z * d1 + (vec3d.z * d0 - entity.motionZ) * 0.5D;
				entity.velocityChanged = true;
			}
		}
	}
	
}
