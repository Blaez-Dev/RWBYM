package be.bluexin.rwbym.potion;

import be.bluexin.rwbym.entity.EntityRagora;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

public class PotionDamage extends Potion {

	public PotionDamage() {
		super(true, 0);
	}
	
	@Override
	public boolean isInstant() {
		return true;
	}
	
	@Override
	public void affectEntity(Entity source, Entity indirectSource, EntityLivingBase entityLivingBaseIn, int amplifier, double health) {
		
		if (entityLivingBaseIn != indirectSource && (!(indirectSource instanceof EntityRagora) || entityLivingBaseIn != ((EntityRagora) indirectSource).getOwner())) {
			entityLivingBaseIn.attackEntityFrom(new DamageSource("magic"), amplifier);
		}
	}

}
