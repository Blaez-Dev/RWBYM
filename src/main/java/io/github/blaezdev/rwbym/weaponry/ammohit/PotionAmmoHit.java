package io.github.blaezdev.rwbym.weaponry.ammohit;

import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class PotionAmmoHit implements IAmmoHit {
	
	private final List<PotionEffect> effects;
	private final Item type;

	public PotionAmmoHit(Item item, List<PotionEffect> effects) {
		this.effects = effects;
		this.type = item;
	}
	
	@Override
	public void applyBlock(EntityLivingBase shooter, BlockPos pos) {
		if (!shooter.world.isRemote) {
			//EntityPotion potion = new EntityPotion(world, pos.getX(), pos.getY(), pos.getZ(), PotionUtils.appendEffects(new ItemStack(this.type), this.effects));
			//world.spawnEntity(potion);
			EntityAreaEffectCloud areaEffectCloud = new EntityAreaEffectCloud(shooter.world, pos.getX(), pos.getY(), pos.getZ());
			areaEffectCloud.setRadius(2.0F);
			areaEffectCloud.setDuration(100);
			areaEffectCloud.setParticle(EnumParticleTypes.SPELL_INSTANT);
			for (PotionEffect p : this.effects) areaEffectCloud.addEffect(p);
			shooter.world.spawnEntity(areaEffectCloud);
		}
	}

	@Override
	public void applyEntity(EntityLivingBase living, EntityLivingBase shooter) {
		if (!living.world.isRemote) {
			//EntityPotion potion = new EntityPotion(living.world, living.posX, living.posY, living.posZ, PotionUtils.appendEffects(new ItemStack(this.type), this.effects));
			//living.world.spawnEntity(potion);
			EntityAreaEffectCloud areaEffectCloud = new EntityAreaEffectCloud(living.world, living.posX, living.posY, living.posZ);
			areaEffectCloud.setRadius(2.0F);
			areaEffectCloud.setDuration(100);
			areaEffectCloud.setParticle(EnumParticleTypes.SPELL_INSTANT);
			for (PotionEffect p : this.effects) areaEffectCloud.addEffect(p);
			living.world.spawnEntity(areaEffectCloud);

		}
	}

}


