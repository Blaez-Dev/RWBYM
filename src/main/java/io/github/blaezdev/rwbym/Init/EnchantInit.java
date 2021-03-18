package io.github.blaezdev.rwbym.Init;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.enchantments.killmodifiers.EnchantmentAuraSiphon;
import io.github.blaezdev.rwbym.enchantments.shotmodifiers.EnchantmentDoubleShot;
import io.github.blaezdev.rwbym.enchantments.shotmodifiers.EnchantmentKnockShot;
import io.github.blaezdev.rwbym.enchantments.killmodifiers.EnchantmentScavenger;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.common.Mod;

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

    public static ArrayList<Enchantment> framemodifier = new ArrayList<Enchantment>(){
    };

    public static ArrayList<Enchantment> barrelmodifier = new ArrayList<Enchantment>(){
    };

    public static ArrayList<Enchantment> enemymodifier = new ArrayList<Enchantment>(){
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

    public static Enchantment getFramemodifierEnchant(){
        Random rand = new Random();
        int index = rand.nextInt(framemodifier.size());
        Enchantment randenchant = framemodifier.get(index);
        return randenchant;
    }

    public static Enchantment getBarrelmodifierEnchant(){
        Random rand = new Random();
        int index = rand.nextInt(barrelmodifier.size());
        Enchantment randenchant = barrelmodifier.get(index);
        return randenchant;
    }

    public static Enchantment getEnemymodifierEnchant(){
        Random rand = new Random();
        int index = rand.nextInt(enemymodifier.size());
        Enchantment randenchant = enemymodifier.get(index);
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
