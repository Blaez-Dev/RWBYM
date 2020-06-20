package io.github.blaezdev.rwbym.weaponry;

import io.github.blaezdev.rwbym.Init.RWBYItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class RWBYGliderItem extends Item {

	public RWBYGliderItem() {
		super();
		setMaxDamage(500);
		setMaxStackSize(1);
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
			}
		}
	}
	
}
