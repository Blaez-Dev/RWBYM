package io.github.blaezdev.rwbym.Init;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.enchantments.barrelmodifiers.*;
import io.github.blaezdev.rwbym.enchantments.framemodifiers.*;
import io.github.blaezdev.rwbym.enchantments.killmodifiers.EnchantmentAuraSiphon;
import io.github.blaezdev.rwbym.enchantments.killmodifiers.EnchantmentLuckyShot;
import io.github.blaezdev.rwbym.enchantments.killmodifiers.EnchantmentTrickster;
import io.github.blaezdev.rwbym.enchantments.shotmodifiers.EnchantmentDoubleShot;
import io.github.blaezdev.rwbym.enchantments.shotmodifiers.EnchantmentKnockShot;
import io.github.blaezdev.rwbym.enchantments.killmodifiers.EnchantmentScavenger;
import io.github.blaezdev.rwbym.enchantments.shotmodifiers.EnchantmentPoisonShot;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid=RWBYModels.MODID)
public class EnchantInit {
    public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();
    //-Shot Modifiers-//
    public static final Enchantment DOUBLE_SHOT = new EnchantmentDoubleShot();
    public static final Enchantment KNOCK_SHOT = new EnchantmentKnockShot();
    public static final Enchantment POISON_SHOT = new EnchantmentPoisonShot();

    //-Kill Modifiers-//
    public static final Enchantment AURA_SIPHON = new EnchantmentAuraSiphon();
    public static final Enchantment SCAVENGER = new EnchantmentScavenger();
    public static final Enchantment LUCKY_HIT = new EnchantmentLuckyShot();
    public static final Enchantment TRICKSTER = new EnchantmentTrickster();

    //-Frame-//
    public static final Enchantment ATTUNED_FRAME = new EnchantmentAttunedFrame();
    public static final Enchantment HEAVY_WEIGHT_FRAME = new EnchantmentHeavyWeightFrame();
    public static final Enchantment LIGHT_WEIGHT_FRAME = new EnchantmentLightWeightFrame();
    public static final Enchantment PRECISION_FRAME = new EnchantmentPrecisionFrame();
    public static final Enchantment RAPID_FIRE_FRAME = new EnchantmentRapidFireFrame();

    //-Barrels-//
    public static final Enchantment ARROW_BREAK_BARREL = new EnchantmentArrowBrake();
    public static final Enchantment CHAMBERED_COMPENSATOR_BARREL = new EnchantmentChamberedCompensator();
    public static final Enchantment CORKSCREW_RIFLING = new EnchantmentCorkScrewRifling();
    public static final Enchantment EXTENDED_BARREL = new EnchantmentExtendedBarrel();
    public static final Enchantment FLUTED_BARREL = new EnchantmentFluted();
    public static final Enchantment FULL_BORE_BARREL = new EnchantmentFullBore();
    public static final Enchantment HOME_FORGED_RIFILING = new EnchantmentHomeForgedRifling();
    public static final Enchantment POLYGONAL_RIFILING = new EnchantmentPolygonalRifling();
    public static final Enchantment SMALL_BORE_BARREL = new  EnchantmentSmallBore();


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
        shotmodifier.add(EnchantInit.POISON_SHOT);
        Random rand = new Random();
        int index = rand.nextInt(shotmodifier.size());
        Enchantment randenchant = shotmodifier.get(index);
        return randenchant;
    }

    public static Enchantment getKillmodifierEnchant(){
        killmodifier.add(EnchantInit.AURA_SIPHON);
        killmodifier.add(EnchantInit.SCAVENGER);
        killmodifier.add(EnchantInit.LUCKY_HIT);
        killmodifier.add(EnchantInit.TRICKSTER);
        Random rand = new Random();
        int index = rand.nextInt(killmodifier.size());
        Enchantment randenchant = killmodifier.get(index);
        return randenchant;
    }

    public static Enchantment getFramemodifierEnchant(){
        framemodifier.add(EnchantInit.ATTUNED_FRAME);
        framemodifier.add(EnchantInit.PRECISION_FRAME);
        framemodifier.add(EnchantInit.HEAVY_WEIGHT_FRAME);
        framemodifier.add(EnchantInit.LIGHT_WEIGHT_FRAME);
        framemodifier.add(EnchantInit.RAPID_FIRE_FRAME);
        Random rand = new Random();
        int index = rand.nextInt(framemodifier.size());
        Enchantment randenchant = framemodifier.get(index);
        return randenchant;
    }

    public static Enchantment getBarrelmodifierEnchant(){
        barrelmodifier.add(ARROW_BREAK_BARREL);
        barrelmodifier.add(CHAMBERED_COMPENSATOR_BARREL);
        barrelmodifier.add(CORKSCREW_RIFLING);
        barrelmodifier.add(EXTENDED_BARREL);
        barrelmodifier.add(FLUTED_BARREL);
        barrelmodifier.add(FULL_BORE_BARREL);
        barrelmodifier.add(HOME_FORGED_RIFILING);
        barrelmodifier.add(POLYGONAL_RIFILING);
        barrelmodifier.add(SMALL_BORE_BARREL);
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
