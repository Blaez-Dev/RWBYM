package be.bluexin.rwbym.weaponry.ammohit;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ExplosionAmmoHit implements IAmmoHit {
	
	private final int power;

	public ExplosionAmmoHit(int power) {
		this.power = power;
	}
	
	@Override
	public void applyBlock(World world, BlockPos pos) {
		if (!world.isRemote) {
			world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), this.power, world.getGameRules().getBoolean("mobGriefing"));
		}
	}

	@Override
	public void applyEntity(EntityLivingBase living) {
		if (!living.world.isRemote) {
			living.world.createExplosion(null, living.posX, living.posY, living.posZ, this.power, false);
		}
	}

}
