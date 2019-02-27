package be.bluexin.rwbym.weaponry.ammohit;

import be.bluexin.rwbym.RWBYModels;
import net.minecraft.block.BlockBush;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireAmmoHit implements IAmmoHit {

	@Override
	public void applyBlock(World world, BlockPos pos) {
		RWBYModels.LOGGER.info("Block Hit");
		if (!world.isRemote) {
            if (world.isAirBlock(pos) || world.getBlockState(pos).getBlock() instanceof BlockBush)
            {
                world.setBlockState(pos, Blocks.FIRE.getDefaultState());
            }
        }
	}

	@Override
	public void applyEntity(EntityLivingBase living) {
		if (!living.world.isRemote) {
			living.setFire(5);
		}
	}

}
