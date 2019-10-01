package io.github.blaez-dev.rwbym.weaponry.ammohit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class FireAmmoHit implements IAmmoHit {

	private int burntime;
	
	public FireAmmoHit(int burntime) {
		this.burntime = burntime;
	}
	
	@Override
	public void applyBlock(EntityLivingBase shooter, BlockPos pos) {
		
		if (!shooter.world.isRemote) {
		
			IBlockState state = shooter.world.getBlockState(pos);
			
			if (shooter.world.isAirBlock(pos) || state.getMaterial().getCanBurn()) {
				shooter.world.setBlockState(pos, Blocks.FIRE.getDefaultState());
			}
		
		}
	}

	@Override
	public void applyEntity(EntityLivingBase living, EntityLivingBase shooter) {
		
		if (!living.world.isRemote) {
			living.setFire(burntime);
		}
	}

}
