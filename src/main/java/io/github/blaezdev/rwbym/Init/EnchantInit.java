package io.github.blaezdev.rwbym.Init;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.enchantments.EnchantmentAuraSiphon;
import io.github.blaezdev.rwbym.enchantments.EnchantmentDoubleShot;
import io.github.blaezdev.rwbym.enchantments.EnchantmentKnockShot;
import io.github.blaezdev.rwbym.enchantments.EnchantmentScavenger;
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
import java.util.Random;

@Mod.EventBusSubscriber(modid=RWBYModels.MODID)
public class EnchantInit {
    public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();
    public static final Enchantment DOUBLE_SHOT = new EnchantmentDoubleShot(); //Shot Based Disallow Multiple Shot Modifiers
    public static final Enchantment KNOCK_SHOT = new EnchantmentKnockShot();  //Shot Based Disallow Multiple Shot Modifiers
    public static final Enchantment AURA_SIPHON = new EnchantmentAuraSiphon();  //Kill Based Disallow Multiple Kill Modifiers
    public static final Enchantment SCAVENGER = new EnchantmentScavenger(); //Kill Based Disallow Multiple Kill Modifiers


    public static ArrayList<Enchantment> shotmodifier = new ArrayList<Enchantment>(){
    };

    public static ArrayList<Enchantment> killmodifier = new ArrayList<Enchantment>(){
    };

    public static Enchantment getShotmodifierEnchant(){
        shotmodifier.add(EnchantInit.DOUBLE_SHOT);
        shotmodifier.add(EnchantInit.KNOCK_SHOT);
        Random rand = new Random();
        int index = rand.nextInt(shotmodifier.size());
        Enchantment randenchant = shotmodifier.get(index);
        return randenchant;
    }

    public static Enchantment getKillmodifierEnchant(){
        killmodifier.add(EnchantInit.AURA_SIPHON);
        killmodifier.add(EnchantInit.SCAVENGER);
        Random rand = new Random();
        int index = rand.nextInt(killmodifier.size());
        Enchantment randenchant = killmodifier.get(index);
        return randenchant;
    }

    /*
    @SubscribeEvent
    public static void DoubleShotFunction(LivingEvent.LivingUpdateEvent event){
        EntityLivingBase living = event.getEntityLiving();
        int lvl = EnchantmentHelper.getMaxEnchantmentLevel(DOUBLE_SHOT,living);
        BlockPos pos = living.getPosition();
        World world = event.getEntity().world;
    }*/
}
