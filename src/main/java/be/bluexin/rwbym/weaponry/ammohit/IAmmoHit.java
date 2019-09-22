package be.bluexin.rwbym.weaponry.ammohit;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;

public interface IAmmoHit {
	public void applyBlock(EntityLivingBase shooter, BlockPos pos);
	public void applyEntity(EntityLivingBase living, EntityLivingBase shooter);
}
