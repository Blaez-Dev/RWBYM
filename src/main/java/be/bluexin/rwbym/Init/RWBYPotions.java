package be.bluexin.rwbym.Init;

import be.bluexin.rwbym.potion.PotionAuraRegen;
import be.bluexin.rwbym.potion.PotionDamage;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RWBYPotions {
	
	public static final Potion INSTANT_DAMAGE = new PotionDamage();

	public void registerPotions() {
		GameRegistry.findRegistry(Potion.class).register(INSTANT_DAMAGE);
	}

}
