package be.bluexin.rwbym.weaponry.ammohit;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IAmmoHit {
	public void applyBlock(World world, BlockPos pos);
	public void applyEntity(EntityLivingBase living);
}
