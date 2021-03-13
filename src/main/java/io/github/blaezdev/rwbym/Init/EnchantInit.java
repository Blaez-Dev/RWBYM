package io.github.blaezdev.rwbym.Init;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.enchantments.EnchantmentDoubleShot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid=RWBYModels.MODID)
public class EnchantInit {
    public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();
    public static final Enchantment DOUBLE_SHOT = new EnchantmentDoubleShot();

    @SubscribeEvent
    public static void DoubleShotFunction(LivingEvent.LivingUpdateEvent event){
        EntityLivingBase living = event.getEntityLiving();
        int lvl = EnchantmentHelper.getMaxEnchantmentLevel(DOUBLE_SHOT,living);
        BlockPos pos = living.getPosition();
        World world = event.getEntity().world;
    }
}
