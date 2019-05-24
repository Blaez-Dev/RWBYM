package be.bluexin.rwbym.weaponry.ammohit;

import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ISemblance;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
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

			if(living instanceof EntityPlayer){
			ISemblance semblance = CapabilityHandler.getCurrentSemblance((EntityPlayer) living);
			if (semblance.toString().equals("Nora")){
				PotionEffect potioneffect = new PotionEffect(MobEffects.STRENGTH, 360, 16, false, false);
				living.addPotionEffect(potioneffect);
				PotionEffect potioneffect2 = new PotionEffect(MobEffects.SPEED, 360, 9, false, false);
				living.addPotionEffect(potioneffect2);
			}
			}

		}
	}

}
