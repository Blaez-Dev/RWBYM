package be.bluexin.rwbym.weaponry.ammohit;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireAmmoHit implements IAmmoHit {

	@Override
	public void applyBlock(World world, BlockPos pos) {
		world.setBlockState(pos, Blocks.FIRE.getDefaultState());
	}

	@Override
	public void applyEntity(EntityLivingBase living) {
		living.setFire(10);
	}

}
