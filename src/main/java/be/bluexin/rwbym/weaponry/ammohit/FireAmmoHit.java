package be.bluexin.rwbym.weaponry.ammohit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireAmmoHit implements IAmmoHit {

	private int burntime;
	
	public FireAmmoHit(int burntime) {
		this.burntime = burntime;
	}
	
	@Override
	public void applyBlock(World world, BlockPos pos) {
		
		if (!world.isRemote) {
		
			IBlockState state = world.getBlockState(pos);
			
			if (world.isAirBlock(pos) || state.getMaterial().getCanBurn()) {
				world.setBlockState(pos, Blocks.FIRE.getDefaultState());
			}
		
		}
	}

	@Override
	public void applyEntity(EntityLivingBase living) {
		
		if (!living.world.isRemote) {
			living.setFire(burntime);
		}
	}

}
