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
	public void applyBlock(EntityLivingBase shooter, BlockPos pos) {
		if (!shooter.world.isRemote) {
			shooter.world.createExplosion(shooter, pos.getX(), pos.getY(), pos.getZ(), this.power, shooter.world.getGameRules().getBoolean("mobGriefing"));
		}
	}

	@Override
	public void applyEntity(EntityLivingBase living, EntityLivingBase shooter) {
		if (!living.world.isRemote) {
			living.world.createExplosion(shooter, living.posX, living.posY, living.posZ, this.power, false);
		}
	}

}
