package io.github.blaezdev.rwbym.Init;

import com.google.common.collect.ImmutableList;
import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.RWBYSoundHandler.Sound;
import io.github.blaezdev.rwbym.blocks.*;
import io.github.blaezdev.rwbym.blocks.fence.RWBYBlockFence;
import io.github.blaezdev.rwbym.blocks.fluids.BlockFluidGrimm;
import io.github.blaezdev.rwbym.gui.RWBYItemContainerGui;
import io.github.blaezdev.rwbym.gui.RWBYItemContainerGuiChest;
import io.github.blaezdev.rwbym.inventory.RWBYItemContainer;
import io.github.blaezdev.rwbym.inventory.RWBYItemContainerChest;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import io.github.blaezdev.rwbym.weaponry.*;
import io.github.blaezdev.rwbym.weaponry.ammohit.ExplosionAmmoHit;
import io.github.blaezdev.rwbym.weaponry.ammohit.FireAmmoHit;
import io.github.blaezdev.rwbym.weaponry.ammohit.IAmmoHit;
import io.github.blaezdev.rwbym.weaponry.ammohit.PotionAmmoHit;
import io.github.blaezdev.rwbym.weaponry.specialweapons.ItemMag;
import io.github.blaezdev.rwbym.weaponry.specialweapons.bullets.ItemRayTraceBullet;
//import io.github.blaezdev.rwbym.weaponry.specialweapons.bullets.ItemCasing;
import io.github.blaezdev.rwbym.weaponry.specialweapons.guns.ItemHecate;
import io.github.blaezdev.rwbym.weaponry.specialweapons.guns.ItemP90;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.audio.ElytraSound;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityDragonFireball;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RWBYItems {
    public static final Item icon = new RWBYItem("icon",  false, null);
    
    public static final ItemHecate Hecate = (ItemHecate) new ItemHecate().setRegistryName(RWBYModels.MODID, "hecate2.bbmodel").setUnlocalizedName("hecate2");
    //public static final ItemCasing Hecate50BMGcasing = (ItemCasing) new ItemCasing().setRegistryName(RWBYModels.MODID, "50bmgcasing").setUnlocalizedName("50bmgcasing");
    public static final ItemRayTraceBullet Hecate50BMG = (ItemRayTraceBullet) new ItemRayTraceBullet(() -> Items.AIR, 100, 60, () -> Sound.RIFLE_SHOOT.getSound()).setRegistryName(RWBYModels.MODID, "50bmg").setUnlocalizedName("50bmg");
    public static final ItemMag HecateMag = (ItemMag) new ItemMag(7, () -> Hecate50BMG).setRegistryName(RWBYModels.MODID, "hecate_mag").setUnlocalizedName("hecate_mag");
    
    public static final ItemP90 P90 = (ItemP90) new ItemP90().setRegistryName(RWBYModels.MODID, "p90.bbmodel").setUnlocalizedName("p90").setUnlocalizedName("p90");
    //public static final ItemCasing P90Casing = (ItemCasing) new ItemCasing().setRegistryName(RWBYModels.MODID, "p90casing").setUnlocalizedName("p90casing");
    public static final ItemRayTraceBullet P90Bullet = (ItemRayTraceBullet) new ItemRayTraceBullet(() -> Items.AIR, 64, 8, () -> Sound.GAMBOL_SHROUD_SHOOT.getSound()).setRegistryName(RWBYModels.MODID, "p90bullet").setUnlocalizedName("p90bullet");
    public static final ItemMag P90Mag = (ItemMag) new ItemMag(50, () -> P90Bullet).setRegistryName(RWBYModels.MODID, "p90_mag").setUnlocalizedName("p90_mag");

    public static final Item crescent = new RWBYGun(
            "crescent",
            2500,
            16,
            RWBYGun.SCYTHE,
            "rwbym:crescentgun",
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(5);
    public static final Item hadesgun = new RWBYGun(
            "hadesgun",
            2500,
            14,
            0,
            "rwbym:hadesscy",
            "rwbym:nullest,rwbym:hadesmag",
            false,
            3,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.EMBER_CELICA_SHOOT.getSound(),//7,
            null).setElement("rwbym:hadesgunrecoil").setRecoil(8);
    public static final Item hadesgunrecoil = new RWBYGun(
            "hadesgunrecoil",
            2500,
            14,
            0,
            "rwbym:hadesscy",
            "rwbym:nullest,rwbym:hadesmag",
            false,
            3,
            false,
            false,
            1,
            1,
            0,
            () -> Sound.EMBER_CELICA_SHOOT.getSound(),//7,
            RWBYCreativeTabs.tab_rwbyweapons).setElement("rwbym:hadesgun").setRecoil(20);
    public static final Item hadesscy = new RWBYGun(
            "hadesscy",
            2500,
            22,
            RWBYGun.SCYTHE,
            "rwbym:hadesgunrecoil",
            "rwbym:nullest",
            false,
            3,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.EMBER_CELICA_SHOOT.getSound(),//7,
            null).setRecoil(15);
    public static final Item grimmscy = new RWBYGun(
            "grimmscy",
            2500,
            16,
            RWBYGun.SCYTHE,
            null,
            "rwbym:nuller,rwbym:nulls",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item grimmrapier = new RWBYGun(
            "grimmrapier",
            2500,
            14,
            RWBYGun.RAPIER,
            null,
            "rwbym:nuller,rwbym:nulls",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item grimmwhip = new RWBYGun(
            "grimmwhip",
            2500,
            14,
            RWBYGun.DAGGER,
            null,
            "rwbym:nuller",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item crescentfrost = new RWBYGun(
            "crescentfrost",
            2500,
            16,
            RWBYGun.SCYTHE,
            "rwbym:crescentgunfrost",
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            null).setRecoil(5);
    public static final Item gambol = new RWBYGun(
            "gambol",
            2500,
            14,
            RWBYGun.SWORD,
            "rwbym:gambolgun",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item rvnswd = new RWBYGun(
            "rvnswd",
            2500,
            14,
            RWBYGun.SWORD,
            "rwbym:rvnswdele",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons).setElementMelee("fire");
    public static final Item rvnswdele = new RWBYGun(
            "rvnswdele",
            2500,
            9,
            0,
            "rwbym:rvnswdice",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            null,
            null).setElementMelee("wind");
    public static final Item rvnswdice = new RWBYGun(
            "rvnswdice",
            2500,
            14,
            RWBYGun.SWORD,
            "rwbym:rvnswd",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            null,
            null);
    public static final Item qrow = new RWBYGun(
            "qrow",
            2500,
            18,
            RWBYGun.SCYTHE,
            "rwbym:qrowgun",
            "rwbym:ammmmo,rwbym:ammmmmmo",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            null);
    public static final Item qrowsword = new RWBYGun(
            "qrowsword",
            2500,
            16,
            RWBYGun.SWORD,
            "rwbym:qrow",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item juane = new RWBYGun("juane",
            2500,
            14,
            RWBYGun.SWORD,
            "rwbym:juaneshieldaxe",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item juaneshieldaxe = new RWBYGun("juaneshieldaxe",
            2500,
            16,
            RWBYGun.SWORD,
            "rwbym:juane",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null);
    public static final Item norahammer = new RWBYGun(
            "norahammer",
            2500,
            16,
            RWBYGun.HAMMER,
            "rwbym:noragun",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item pyrrhaspear = new RWBYGun(
            "pyrrhaspear",
            2500,
            14,
            RWBYGun.SCYTHE|RWBYGun.THROWN,
            "rwbym:pyrrharifle",
            "rwbym:pyrrhaspearammo",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item pyrrhasword = new RWBYGun(
            "pyrrhasword",
            2500,
            14,
            RWBYGun.DAGGER,
            "rwbym:pyrrhaspear",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            null,
            null);
    public static final Item velvet = new RWBYGun(
            "velvet",
            1250,
            0,
            0,
            "rwbym:crescentv",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item oobleckthermos = new RWBYGun(
            "oobleckthermos",
            2500,
            0,
            0,
            "rwbym:oobleckflamethrower",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item crescentv = new RWBYGun(
            "crescentv",
            1250,
            16,
            RWBYGun.SCYTHE|RWBYGun.INT_MAG,
            "rwbym:crescentgunv",
            "rwbym:ammov",
            false,
            1,
            false,
            false,
            1,
            1,
            1,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            null).setRecoil(5);
    public static final Item weissv = new RWBYGun(
            "weissv",
            1250,
            10,
            RWBYGun.RAPIER,
            "rwbym:gambolv",
            "rwbym:ammmmo",
            false,
            1,
            false,
            false,
            0,
            1,
            1,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            null);
    public static final Item gambolv = new RWBYGun(
            "gambolv",
            1250,
            14,
            RWBYGun.SWORD,
            "rwbym:gambolgunv",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            false,
            0,
            1,
            1,
            null,
            null);

    public static final Item juanev = new RWBYGun(
            "juanev",
            1250,
            14,
            RWBYGun.SWORD,
            "rwbym:norahammerv",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            1,
            null,
            null);
    public static final Item norahammerv = new RWBYGun(
            "norahammerv",
            1250,
            16,
            RWBYGun.HAMMER,
            "rwbym:noragunv",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            1,
            null,
            null);
    public static final Item pyrrhaspearv = new RWBYGun(
            "pyrrhaspearv",
            1250,
            14,
            RWBYGun.SCYTHE|RWBYGun.THROWN,
            "rwbym:pyrrhaswordv",
            "rwbym:pyrrhaspearvammo",
            false,
            1,
            false,
            false,
            0,
            1,
            1,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            null);
    public static final Item pyrrhaswordv = new RWBYGun(
            "pyrrhaswordv",
            1250,
            14,
            RWBYGun.DAGGER,
            "rwbym:stormflowerv",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            false,
            0,
            1,
            1,
            null,
            null);
    public static final Item yatsuhashi = new RWBYGun(
            "yatsuhashi",
            2500,
            19,
            RWBYGun.SWORD,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item cocobag = new RWBYGun(
            "cocobag",
            1250,
            14,
            0,
            "rwbym:cocogun",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item fox = new RWBYGun(
            "fox",
            2500,
            14,
            RWBYGun.HAMMER,
            null,
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            true,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.STORMFLOWER_SHOOT.getSound(),//5,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(5);
    public static final Item cocobagv = new RWBYGun(
            "cocobagv",
            1250,
            14,
            0,
            "rwbym:cocogunv",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            1,
            null,
            null);
    public static final Item winterswd = new RWBYGun(
            "winterswd",
            2500,
            14,
            RWBYGun.WINTER,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item pennyswd = new RWBYGun(
            "pennyswd",
            2500,
            13,
            RWBYGun.SWORD|RWBYGun.THROWN|RWBYGun.BOOMERANG,
            null,
            "rwbym:pennyswdammo",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item ozpincane = new RWBYGun(
            "ozpincane",
            2500,
            14,
            0,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item port = new RWBYGun(
            "port",
            2500,
            16,
            0,
            "rwbym:portgun",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item kkfire = new RWBYGun(
            "kkfire",
            2500,
            19,
            RWBYGun.SWORD,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null).setElementMelee("fire");
    public static final Item kkice = new RWBYGun(
            "kkice",
            2500,
            14,
            RWBYGun.SWORD,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            null,
            null).setElementMelee("ice");
    public static final Item kkwind = new RWBYGun(
            "kkwind",
            2500,
            14,
            RWBYGun.RAPIER,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            null).setElementMelee("wind");
    public static final Item torchwick = new RWBYGun(
            "torchwick",
            2500,
            15,
            RWBYGun.HAMMER,
            "rwbym:torchwickgun",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            3,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item neoumb_closed = new RWBYGun(
            "neoumb_closed",
            2500,
            13,
            RWBYGun.UMBRELLA,
            "rwbym:neoumb_closed_blade",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item neoumb_closed_blade = new RWBYGun(
            "neoumb_closed_blade",
            2500,
            13,
            RWBYGun.RAPIER|RWBYGun.UMBRELLA,
            "rwbym:neoumb_handle_blade",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null);
    public static final Item neoumb_handle_blade = new RWBYGun(
            "neoumb_handle_blade",
            2500,
            14,
            RWBYGun.RAPIER,
            "rwbym:neoumb_closed",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            null);
    public static final Item jnrbat = new RWBYGun(
            "jnrbat",
            2500,
            15,
            RWBYGun.HAMMER,
            "rwbym:jnrrocket",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item adamswd = new RWBYGun(
            "adamswd",
            2500,
            13,
            RWBYGun.SWORD,
            "rwbym:adamgun",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item cinder = new RWBYGun(
            "cinder",
            2500,
            14,
            RWBYGun.SWORD,
            "rwbym:cinderbow",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);

    public static final Item ozmacane = new RWBYGun(
            "ozmacane",
            2500,
            12,
            RWBYGun.STAFF|RWBYGun.HAMMER,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons
    );
    public static final Item ozmacanefire = new RWBYGun(
            "ozmacanefire",
            2500,
            12,
            RWBYGun.STAFF|RWBYGun.HAMMER,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null
    ).setElementMelee("fire");
    public static final Item ozmacanegravity = new RWBYGun(
            "ozmacanegravity",
            2500,
            12,
            RWBYGun.STAFF|RWBYGun.HAMMER,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null
    ).setElementMelee("grav");    public static final Item ozmacaneice = new RWBYGun(
            "ozmacaneice",
            2500,
            12,
            RWBYGun.STAFF|RWBYGun.HAMMER,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null
    ).setElementMelee("ice");    public static final Item ozmacanelightning = new RWBYGun(
            "ozmacanelightning",
            2500,
            12,
            RWBYGun.STAFF|RWBYGun.HAMMER,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null
    ).setElementMelee("light");    public static final Item ozmacanewater = new RWBYGun(
            "ozmacanewater",
            2500,
            12,
            RWBYGun.STAFF|RWBYGun.HAMMER,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null
    ).setElementMelee("water");    public static final Item ozmacanewind = new RWBYGun(
            "ozmacanewind",
            2500,
            12,
            RWBYGun.STAFF|RWBYGun.HAMMER,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null
    ).setElementMelee("wind");
    public static final Item mariacane = new RWBYGun(
            "mariacane",
            2500,
            14,
            RWBYGun.HAMMER,
            "rwbym:mariascythe",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item mariascythe = new RWBYGun(
            "mariascythe",
            2500,
            16,
            RWBYGun.SCYTHE|RWBYGun.WALLCLIMB,
            "rwbym:mariascythedouble",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            null).setRecoil(5);
    public static final Item angelcane = new RWBYGun(
            "angelcane",
            2500,
            14,
            0,
            "rwbym:angelsword",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item angelsword = new RWBYGun(
            "angelsword",
            2500,
            16,
            RWBYGun.RAPIER,
            "rwbym:angelcane",
            "none",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            null,
            null);
    public static final Item mariascythedouble = new RWBYGun(
            "mariascythedouble",
            2500,
            18,
            RWBYGun.SCYTHE,
            "rwbym:mariacane",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null);
    public static final Item chatareus = new RWBYGun(
            "chatareus",
            2500,
            16,
            0,
            "rwbym:chatareusgun",
            "rwbym:chatmag,rwbym:chatfiremag,rwbym:chatgravmag,rwbym:chatelectricmag",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//12,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(10);
    public static final Item chatareusgun = new RWBYGun(
            "chatareusgun",
            2500,
            16,
            0,
            "rwbym:chatareus",
            "rwbym:chatmag,rwbym:chatfiremag,rwbym:chatgravmag,rwbym:chatelectricmag",
            false,
            3,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//12,
            null).setRecoil(10);

    public static final Item lark = new RWBYGun(
            "lark",
            2500,
            16,
            2,
            null,
            "rwbym:chatmag,rwbym:chatfiremag,rwbym:chatgravmag,rwbym:chatelectricmag",
            false,
            3,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//12,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(10);

    public static final Item armasword = new NPCRWBYSword(
            "armasword",
            2500,
            19,
            0,
            false,
            true,
            0,
            null);

    public static final Item armaswordsummon = new NPCRWBYSword(
            "armaswordsummon",
            2500,
            19,
            0,
            false,
            true,
            0,
            null );
    public static final Item razorbolt = new RWBYGun(
            "razorbolt",
            2500,
            16,
            RWBYGun.FIST|RWBYGun.SWORD|RWBYGun.INT_MAG,
            "rwbym:razorboltknife",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item razorboltknife = new RWBYGun(
            "razorboltknife",
            2500,
            8,
            RWBYGun.DAGGER|RWBYGun.INT_MAG,
            "rwbym:razorbolt",
            "rwbym:rzrbolt",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            null);
    public static final Item reese = new KineticWeapons(
            "reese",
            2500,
            -4,
            0,
            "rwbym:reesegun",
            false,
            false,
            RWBYCreativeTabs.tab_rwbyweapons);

    public static final Item reesegun = new RWBYGun(
            "reesegun",
            2500,
            14,
            0,
            "rwbym:reese",
            "rwbym:spl,rwbym:splfire,rwbym:splgrav,rwbym:splice,rwbym:spllight",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.STORMFLOWER_SHOOT.getSound(),//14,
            null).setRecoil(5);
    public static final Item bolin = new RWBYGun(
            "bolin",
            2500,
            16,
            0,
            "rwbym:bolinblade",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item bolinblade = new RWBYGun(
            "bolinblade",
            2500,
            17,
            0,
            "rwbym:bolin",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null);

    public static final Item dew = new RWBYGun(
            "dew",
            2500,
            17,
            RWBYGun.SCYTHE,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item octavia = new RWBYGun(
            "octavia",
            2500,
            14,
            RWBYGun.DAGGER,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);

    public static final Item lysettesword = new RWBYGun(
            "lysettesword",
            2500,
            14,
            RWBYGun.SWORD,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item flashaceballot = new RWBYGun(
            "flashaceballot",
            2500,
            18,
            RWBYGun.SWORD,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null).setElementMelee("flash");



    //------------------------------------------------//

    public static final Item crescentgun = new RWBYGun(
            "crescentgun",
            2500,
            0,
            0,
            "rwbym:crescent",
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            3,
            false,
            false,
            1,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            null).setRecoil(10);
    public static final Item crescentgunfrost = new RWBYGun(
            "crescentgunfrost",
            2500,
            0,
            0,
            "rwbym:crescentfrost",
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            3,
            false,
            false,
            1,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            null).setRecoil(10);
    public static final Item weiss = new RWBYGun(
            "weiss",
            2500,
            14,
            RWBYGun.RAPIER,
            null,
            "rwbym:gravitydust,rwbym:winddust,rwbym:icedust,rwbym:waterdust,rwbym:firedust,rwbym:lightdust,rwbym:gravitydustcrystal,rwbym:winddustcrystal,rwbym:icedustcrystal,rwbym:waterdustcrystal,rwbym:firedustcrystal,rwbym:lightdustcrystal",
            false,
            1,
            false,
            false,
            3,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(3);
    public static final Item crescentgunv = new RWBYGun(
            "crescentgunv",
            1250,
            0,
            RWBYGun.INT_MAG,
            "rwbym:emberv",
            "rwbym:ammov",
            false,
            3,
            false,
            false,
            1,
            1,
            1,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            null).setRecoil(10);
    public static final Item ember = new RWBYGun(
            "ember",
            2500,
            14,
            RWBYGun.FIST,
            "rwbym:ember2",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            false,
            false,
            0,
            4,
            0,
            () -> Sound.EMBER_CELICA_SHOOT.getSound(),//2,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(7);
    public static final Item ember2 = new RWBYGun(
            "ember2",
            2500,
            14,
            RWBYGun.EMBER_CELICA|RWBYGun.FIST,
            "rwbym:ember",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            false,
            false,
            0,
            4,
            0,
            () -> Sound.EMBER_CELICA_SHOOT.getSound(),//2,
            null).setRecoil(7);
    public static final Item gambolgun = new RWBYGun(
            "gambolgun",
            2500,
            0,
            RWBYGun.OFFHAND,
            "rwbym:gambol",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            null).setRecoil(5);
    public static final Item p90 = new RWBYGun(
            "p90",
            2500,
            0,
            0,
            null,
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            true,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            null).setRecoil(2).setElementMelee("wind");
    public static final Item gambolgunv = new RWBYGun(
            "gambolgunv",
            1250,
            0,
            RWBYGun.OFFHAND|RWBYGun.INT_MAG,
            "rwbym:juanev",
            "rwbym:ammov",
            false,
            1,
            true,
            false,
            0,
            1,
            1,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            null).setRecoil(5);
    public static final Item stormflower = new RWBYGun(
            "stormflower",
            2500,
            14,
            RWBYGun.WALLCLIMB|RWBYGun.DAGGER,
            null,
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            true,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.STORMFLOWER_SHOOT.getSound(),//5,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(3);
    public static final Item noragun = new RWBYGun(
            "noragun",
            2500,
            0,
            0,
            "rwbym:norahammer",
            "rwbym:magnammo,rwbym:magnaampammo",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.MAGNHILD_SHOOT.getSound(),//6,
            null).setRecoil(7);
    public static final Item stormflowerv = new RWBYGun(
            "stormflowerv",
            1250,
            14,
            RWBYGun.INT_MAG|RWBYGun.DAGGER,
            "rwbym:cocobagv",
            "rwbym:ammov",
            true,
            1,
            false,
            false,
            0,
            1,
            1,
            () -> Sound.STORMFLOWER_SHOOT.getSound(),//5,
            null).setRecoil(3);
    public static final Item noragunv = new RWBYGun(
            "noragunv",
            1250,
            0,
            RWBYGun.INT_MAG,
            "rwbym:pyrrhaspearv",
            "rwbym:ammov",
            false,
            1,
            false,
            false,
            0,
            1,
            1,
            () -> Sound.MAGNHILD_SHOOT.getSound(),//6,
            null).setRecoil(7);
    public static final Item emberv = new RWBYGun(
            "emberv",
            1250,
            14,
            RWBYGun.INT_MAG|RWBYGun.FIST,
            "rwbym:weissv",
            "rwbym:ammov",
            false,
            1,
            false,
            false,
            0,
            4,
            1,
            () -> Sound.EMBER_CELICA_SHOOT.getSound(),//2,
            null).setRecoil(7);
    public static final Item qrowgun = new RWBYGun(
            "qrowgun",
            2500,
            0,
            0,
            "rwbym:qrowsword",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            false,
            false,
            0,
            4,
            0,
            () -> Sound.EMBER_CELICA_SHOOT.getSound(),//2,
            null).setRecoil(7);
    public static final Item cocogun = new RWBYGun(
            "cocogun",
            1250,
            0,
            RWBYGun.INT_MAG,
            "rwbym:cocobag",
            "rwbym:ammmo",
            true,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.EMBER_CELICA_SHOOT.getSound(),//7,
            null).setRecoil(1);
    public static final Item cocogunv = new RWBYGun(
            "cocogunv",
            1250,
            0,
            RWBYGun.INT_MAG,
            "rwbym:velvet",
            "rwbym:ammmo",
            true,
            1,
            false,
            false,
            0,
            1,
            1,
            () -> Sound.EMBER_CELICA_SHOOT.getSound(),//7,
            null).setRecoil(1);
    public static final Item infinity = new RWBYGun(
            "infinity",
            0,
            0,
            RWBYGun.INT_MAG,
            null,
            "rwbym:ammmo",
            true,
            1,
            false,
            false,
            0,
            2,
            0,
            () -> Sound.STORMFLOWER_SHOOT.getSound(),//5,
            null).setRecoil(1);
    public static final Item sanrei = new RWBYGun(
            "sanrei",
            0,
            0,
            RWBYGun.SANREI,
            "rwbym:letztstil",
            "rwbym:sanreiammo",
            false,
            1,
            false,
            false,
            0,
            3,
            0,
            () -> SoundEvents.ENTITY_ARROW_SHOOT,
            null);

    public static final Item letztstil = new RWBYGun(
            "letztstil",
            0,
            0,
            RWBYGun.LETZT,
            "rwbym:bangle",
            "rwbym:letztammo",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ARROW_SHOOT,
            null);
    public static final Item bangle = new RWBYGun(
            "bangle",
            0,
            0,
            0,
            "rwbym:sanrei",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            null);

    public static final Item hbangle = new RWBYGun(
            "hbangle",
            0,
            0,
            0,
            "rwbym:hsanrei",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            null);

    public static final Item hsanrei = new RWBYGun(
            "hsanrei",
            0,
            18,
            RWBYGun.SANREI,
            "rwbym:hbangle",
            "rwbym:sanreiammo",
            false,
            1,
            false,
            false,
            0,
            3,
            0,
            () -> SoundEvents.ENTITY_ARROW_SHOOT,
            null);

    public static final Item gwai1 = new RWBYGun(
            "gwai1",
            2500,
            14,
            RWBYGun.SWORD,
            "rwbym:gwai2",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
           RWBYCreativeTabs.tab_rwbyweapons);

    public static final Item gwai2 = new RWBYGun(
            "gwai2",
            2500,
            14,
            RWBYGun.SWORD|RWBYGun.AURAWEAP,
            "rwbym:gwai3",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null).setElementMelee("gwai2");

    public static final Item gwai3 = new RWBYGun(
            "gwai3",
            2500,
            14,
            RWBYGun.SWORD|RWBYGun.AURAWEAP,
            "rwbym:gwai4",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null).setElementMelee("gwai3");

    public static final Item gwai4 = new RWBYGun(
            "gwai4",
            2500,
            14,
            RWBYGun.SWORD|RWBYGun.SANREI,
            "rwbym:gwai5",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null).setElementMelee("gwai4");

    public static final Item gwai5 = new RWBYGun(
            "gwai5",
            2500,
            14,
            RWBYGun.SWORD|RWBYGun.SANREI,
            "rwbym:gwai1",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null).setElementMelee("gwai5");

    public static final Item torchwickgun = new RWBYGun(
            "torchwickgun",
            2500,
            0,
            0,
            "rwbym:torchwick",
            "rwbym:emammmo,rwbym:emflareammo",
            false,
            0.8F,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.TORCHWICK_SHOOT.getSound(),//11,
            null).setRecoil(7);
    public static final Item portgun = new RWBYGun(
            "portgun",
            2500,
            0,
            0,
            "rwbym:port",
            "rwbym:emammo,rwbym:emammmo",
            false,
            0.8F,
            false,
            false,
            0,
            4,
            0,
            () -> Sound.PORT_SHOOT.getSound(),//8,
            null).setRecoil(7);
    public static final Item emeraldgun = new RWBYGun(
            "emeraldgun",
            2500,
            0,
            0,
            "rwbym:emeraldblade",
            "rwbym:spl,rwbym:splfire,rwbym:splgrav,rwbym:splice,rwbym:spllight",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.STORMFLOWER_SHOOT.getSound(),//5,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(5);
    public static final Item emeraldblade = new RWBYGun(
            "emeraldblade",
            2500,
            14,
            RWBYGun.WALLCLIMB|RWBYGun.DAGGER,
            "rwbym:emeraldgun",
            "rwbym:spl,rwbym:splfire,rwbym:splgrav,rwbym:splice,rwbym:spllight",
            false,
            1,
            false,
            false,
            4,
            1,
            0,
            () -> Sound.STORMFLOWER_SHOOT.getSound(),//5,
            null).setRecoil(5);
    public static final Item jnrrocket = new RWBYGun(
            "jnrrocket",
            2500,
            0,
            RWBYGun.JUNIOR,
            "rwbym:jnrbat",
            "rwbym:jnrammo",
            false,
            1,
            false,
            false,
            0,
            4,
            0,
            () -> Sound.JUNIOR_SHOOT.getSound(),//10,
            null).setRecoil(20);
    public static final Item extasis = new RWBYGun(
            "extasis",
            2500,
            0,
            RWBYGun.ROCKET,
            "rwbym:extasislance",
            "rwbym:extasisammo,rwbym:nuller",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.JUNIOR_SHOOT.getSound(),//10,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(20);
    public static final Item extasislance = new RWBYGun(
            "extasislance",
            2500,
            14,
            RWBYGun.RAPIER,
            "rwbym:extasis",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            null);
    public static final Item cinderbow = new RWBYGun(
            "cinderbow",
            2500,
            0,
            RWBYGun.BOW,
            "rwbym:cinder",
            "minecraft:arrow,minecraft:tipped_arrow,rwbym:bolt,rwbym:boltwind,rwbym:boltlight,rwbym:boltice,rwbym:boltgrav,rwbym:boltfire",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ARROW_SHOOT,
            null);
    public static final Item robyncrossbow = new RWBYGun(
            "robyncrossbow",
            2500,
            0,
            RWBYGun.BOW,
            "rwbym:robynshield",
            "minecraft:arrow,minecraft:tipped_arrow,rwbym:bolt,rwbym:boltwind,rwbym:boltlight,rwbym:boltice,rwbym:boltgrav,rwbym:boltfire",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ARROW_SHOOT,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item robynshield = new RWBYGun(
            "robynshield",
            2500,
            14,
            RWBYGun.FIST,
            "rwbym:robyncrossbow",
            "minecraft:arrows32,minecraft:nullest",
            false,
            2,
            true,
            true,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ARROW_SHOOT,
            null);
    public static final Item adamgun = new RWBYGun(
            "adamgun",
            2500,
            0,
            0,
            "rwbym:adamswd",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            false,
            false,
            0,
            3,
            0,
            () -> Sound.EMBER_CELICA_SHOOT.getSound(),//2,
            null).setRecoil(7);
    public  static  final Item sunstaff = new RWBYGun("sunstaff",
            2500,
            16,
            RWBYGun.SCYTHE|RWBYGun.HAMMER,
            "rwbym:sunnunchuck",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null);
    public  static  final  Item sunnunchuck = new RWBYGun(
            "sunnunchuck",
            2500,
            14,
            RWBYGun.HAMMER,
            "rwbym:sunstaff", "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            false,
            false,
            0,
            4,
            0,
            () -> Sound.PORT_SHOOT.getSound(),//8,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(7);
    public static final Item neptunegun = new RWBYGun(
            "neptunegun",
            2500,
            0,
            0,
            "rwbym:neptunespear",
            "rwbym:neptammo,rwbym:magnaampammo",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//13,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(8);
    public  static  final Item neptunespear = new RWBYGun(
            "neptunespear",
            2500,
            15,
            RWBYGun.SCYTHE,
            "rwbym:neptunetrident",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null);
    public  static  final Item neptunetrident = new RWBYGun(
            "neptunetrident",
            2500,
            16,
            RWBYGun.SCYTHE,
            "rwbym:neptunegun",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null);
    public static final Item sage = new RWBYGun(
            "sage",
            2500,
            19,
            RWBYGun.SWORD,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item arslan = new RWBYGun(
            "arslan",
            2500,
            8,
            RWBYGun.DAGGER|RWBYGun.THROWN|RWBYGun.BOOMERANG,
            null,
            "rwbym:arslanammo",
            true,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item scarletsword = new RWBYGun(
            "scarletsword",
            2500,
            14,
            RWBYGun.SCARLET,
            null,
            "rwbym:spl,rwbym:splfire,rwbym:splgrav,rwbym:splice,rwbym:spllight",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.PORT_SHOOT.getSound(),//8,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(8);
    public static final Item nadirgun = new RWBYGun(
            "nadirgun",
            2500,
            0,
            0,
            "rwbym:nadirsword",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            true,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.STORMFLOWER_SHOOT.getSound(),//14,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(5);
    public static final Item nadirsword = new RWBYGun(
            "nadirsword",
            2500,
            14,
            RWBYGun.SWORD,
            "rwbym:nadirgun",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            null);
    public  static  final  Item hexen = new RWBYGun(
            "hexen",
            2500,
            14,
            0,
            "rwbym:hexenaxe",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            true,
            0.7F,
            false,
            false,
            0,
            4,
            0,
            () -> Sound.EMBER_CELICA_SHOOT.getSound(),//2,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(5);
    public  static  final  Item hexenaxe = new RWBYGun(
            "hexenaxe",
            2500,
            18,
            RWBYGun.SCYTHE,
            "rwbym:hexen",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            false,
            false,
            0,
            4,
            0,
            () -> Sound.EMBER_CELICA_SHOOT.getSound(),//2,
            null).setRecoil(2);
    public static final Item magnumgun = new RWBYGun(
            "magnumgun",
            2500,
            12,
            0,
            "rwbym:magnumsword",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            true,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(5);
    public static final Item magnumsword = new RWBYGun(
            "magnumsword",
            2500,
            16,
            RWBYGun.SCYTHE,
            "rwbym:magnumgun",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            1,
            false,
            false,
            2,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            null).setRecoil(5);
    public static final Item pyrrharifle = new RWBYGun(
            "pyrrharifle",
            2500,
            0,
            0,
            "rwbym:pyrrhasword",
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            3,
            true,
            false,
            0,
            1,
            0,
            () -> Sound.PORT_SHOOT.getSound(),//8,
            null).setRecoil(10);
    public static final Item ironwood = new RWBYGun(
            "ironwood",
            2500,
            0,
            0,
            null,
            "rwbym:spl,rwbym:splfire,rwbym:splgrav,rwbym:splice,rwbym:spllight",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(4);
    public static final Item ironwood2 = new RWBYGun(
            "ironwood2",
            2500,
            0,
            0,
            null,
            "rwbym:spl,rwbym:splfire,rwbym:splgrav,rwbym:splice,rwbym:spllight",
            false,
            2,
            false,
            false,
            1,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(4);
    public static final Item goodwitch = new RWBYGun(
            "goodwitch",
            2500,
            16,
            0,
            null,
            "rwbym:firedust,rwbym:lightdust,rwbym:firedustcrystal,rwbym:lightdustcrystal",
            false,
            1,
            false,
            false,
            0,
            2,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(3);
    public static final Item oobleckflamethrower = new RWBYGun(
            "oobleckflamethrower",
            2500,
            13,
            0,
            "rwbym:oobleckthermos",
            "rwbym:firedust,rwbym:firedustcrystal",
            true,
            1,
            false,
            false,
            0,
            3,
            0,
            () -> SoundEvents.ITEM_FIRECHARGE_USE,
            null).setRecoil(3);
    public static final Item cardin = new RWBYGun(
            "cardin",
            2500,
            14,
            RWBYGun.HAMMER,
            null,
            "rwbym:firedust,rwbym:firedustcrystal",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(3).setElementMelee("fire");
    public static final Item nebulabow = new RWBYGun(
            "nebulabow",
            2500,
            0,
            RWBYGun.BOW,
            "rwbym:nebulasword",
            "minecraft:arrow,minecraft:tipped_arrow,rwbym:bolt,rwbym:boltwind,rwbym:boltlight,rwbym:boltice,rwbym:boltgrav,rwbym:boltfire",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ARROW_SHOOT,
            null);

    public static final Item nebulasword = new RWBYGun(
            "nebulasword",
            2500,
            14,
            RWBYGun.SWORD,
            "rwbym:nebulabow",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);

    public static final Item lieutenant = new RWBYGun(
            "lieutenant",
            2500,
            10,
            RWBYGun.AXE,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            0,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item henchmenaxe = new RWBYGun(
            "henchmenaxe",
            2500,
            13,
            RWBYGun.AXE,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            0,
            false,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item fetch = new RWBYGun(
            "fetch",
            2500,
            0,
            0,
            "rwbym:fetchboomerang",
            "rwbym:neptammo,rwbym:magnaampammo",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//13,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(8);
    public static final Item fetchboomerang = new RWBYGun(
            "fetchboomerang",
            2500,
            18,
            RWBYGun.THROWN|RWBYGun.BOOMERANG,
            "rwbym:fetch",
            "rwbym:fetchammo",
            false,
            0,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            null);
    public static final  Item gravitydustcrystalcut = new RWBYCutGem(
            "gravitydustcrystalcut",
            0,
            RWBYCutGem.GRAVITY,
            "rwbym:gravitydustcut",
            true,
            0.3F,
            RWBYCreativeTabs.tab_rwbyitems);
    public static final  Item winddustcrystalcut = new RWBYCutGem(
            "winddustcrystalcut",
            0,
            RWBYCutGem.WIND,
            "rwbym:winddustcut",
            true,
            0.3F,
            RWBYCreativeTabs.tab_rwbyitems);
    public static final  Item waterdustcrystalcut = new RWBYCutGem(
            "waterdustcrystalcut",
            0,
            RWBYCutGem.WATER,
            "rwbym:waterdustcut",
            true,
            0.3F,
            RWBYCreativeTabs.tab_rwbyitems);
    public static final  Item firedustcrystalcut = new RWBYCutGem(
            "firedustcrystalcut",
            0,
            RWBYCutGem.FIRE,
            "rwbym:firedustcut",
            true,
            0.3F,
            RWBYCreativeTabs.tab_rwbyitems);
    public static final  Item dustcrystalcut = new RWBYCutGem(
            "dustcrystalcut",
            0,
            RWBYCutGem.IMPURE,
            "rwbym:dustcut",
            true,
            0.3F,
            RWBYCreativeTabs.tab_rwbyitems);
    public static final  Item lightdustcrystalcut = new RWBYCutGem(
            "lightdustcrystalcut",
            0,
            RWBYCutGem.LIGHTNING,
            "rwbym:lightdustcut",
            true,
            0.3F,
            RWBYCreativeTabs.tab_rwbyitems);
    public static final  Item icedustcrystalcut = new RWBYCutGem(
            "icedustcrystalcut",
            0,
            RWBYCutGem.ICE,
            "rwbym:icedustcut",
            true,
            0.3F,
            RWBYCreativeTabs.tab_rwbyitems);
    public static final Item atlaspistol = new RWBYGun(
            "atlaspistol",
            2500,
            0,
            0,
            null,
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//9,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(3);
    public static final Item atlasrifle = new RWBYGun(
            "atlasrifle",
            2500,
            0,
            0,
            null,
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.PORT_SHOOT.getSound(),//8,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(4);
    public static final Item vernal = new RWBYGun(
            "vernal",
            2500,
            15,
            0,
            null,
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            0.8F,
            true,
            false,
            0,
            2,
            0,
            () -> Sound.PORT_SHOOT.getSound(),//8,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(7);
    public static final Item dove = new RWBYGun(
            "dove",
            2500,
            15,
            RWBYGun.SWORD,
            null,
            "rwbym:spl,rwbym:splfire,rwbym:splgrav,rwbym:splice,rwbym:spllight",
            false,
            2,
            false,
            false,
            0,
            2,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(5);
    public static final Item tyrian = new RWBYGun(
            "tyrian",
            2500,
            15,
            RWBYGun.FIST,
            null,
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            true,
            1,
            false,
            false,
            0,
            2,
            0,
            () -> Sound.STORMFLOWER_SHOOT.getSound(),//5,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(5);
    public static final Item russelnormal = new RWBYGun(
            "russelnormal",
            2500,
            14,
            RWBYGun.DAGGER,
            "rwbym:russelfire",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item russelfire = new RWBYGun(
            "russelfire",
            2500,
            14,
            RWBYGun.DAGGER,
            "rwbym:russelice",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            null).setElementMelee("fire");
    public static final Item russelice = new RWBYGun(
            "russelice",
            2500,
            14,
            RWBYGun.DAGGER,
            "rwbym:russelwind",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            null).setElementMelee("ice");
    public static final Item russelwind = new RWBYGun(
            "russelwind",
            2500,
            14,
            RWBYGun.DAGGER,
            "rwbym:russelnormal",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            null).setElementMelee("wind");
    public static final Item vidiangun = new RWBYGun(
            "vidiangun",
            2500,
            0,
            RWBYGun.INT_MAG,
            "rwbym:vidianhammer",
            "rwbym:ammmo",
            true,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.EMBER_CELICA_SHOOT.getSound(),//7,
            null).setRecoil(3);
    public static final Item vidian = new RWBYGun(
            "vidian",
            2500,
            14,
            0,
            "rwbym:vidiangun",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item vidianhammer = new RWBYGun(
            "vidianhammer",
            2500,
            16,
            RWBYGun.HAMMER,
            "rwbym:vidian",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            null);
    public static final Item cinderbowglass = new RWBYGun(
            "cinderbowglass",
            2500,
            0,
            RWBYGun.BOW,
            "rwbym:cinderglass",
            "minecraft:arrow,minecraft:tipped_arrow,rwbym:bolt,rwbym:boltwind,rwbym:boltlight,rwbym:boltice,rwbym:boltgrav,rwbym:boltfire",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ARROW_SHOOT,
            null);
    public static final Item cinderglass = new RWBYGun(
            "cinderglass",
            2500,
            14,
            RWBYGun.SWORD,
            "rwbym:cinderbowglass",
            "rwbym:nuller,rwbym:nullest",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item henchmen = new RWBYGun(
            "henchmen",
            2500,
            14,
            RWBYGun.SWORD,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item fennec = new RWBYGun(
            "fennec",
            2500,
            8,
            RWBYGun.DAGGER,
            "rwbym:fennecdouble",
            "rwbym:firedust,rwbym:firedustcrystal",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(3);
    public static final Item fennecdouble = new RWBYGun(
            "fennecdouble",
            2500,
            16,
            0, 
            "rwbym:fennec",
            "rwbym:firedust2",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            null).setRecoil(3);
    public static final Item corsac = new RWBYGun(
            "corsac",
            2500,
            8,
            RWBYGun.DAGGER,
            "rwbym:corsacdouble",
            "rwbym:winddust,rwbym:winddustcrystal",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            RWBYCreativeTabs.tab_rwbyweapons).setElementMelee("wind");
    public static final Item corsacdouble = new RWBYGun(
            "corsacdouble",
            2500,
            16,
            0,
            "rwbym:corsac",
            "rwbym:firedust2",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            null).setElementMelee("wind");
    public static final Item aquaealatlbow = new RWBYGun(
            "aquaealatlbow",
            2500,
            0,
            RWBYGun.BOW,
            "rwbym:aquaealatlsword",
            "minecraft:arrow,minecraft:tipped_arrow,rwbym:bolt,rwbym:boltwind,rwbym:boltlight,rwbym:boltice,rwbym:boltgrav,rwbym:boltfire",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ARROW_SHOOT,
            null);
    public static final Item aquaealatlsword = new RWBYGun(
            "aquaealatlsword",
            2500,
            16,
            RWBYGun.SWORD,
            "rwbym:aquaealatlbow",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item brawnz = new RWBYGun(
            "brawnz",
            2500,
            16,
            RWBYGun.FIST,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item mayaxe = new RWBYGun(
            "mayaxe",
            2500,
            16,
            RWBYGun.SCYTHE,
            "rwbym:mayrifle",
            "rwbym:nullest,rwbym:nulls",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            null);
    public static final Item mayrifle = new RWBYGun(
            "mayrifle",
            2500,
            0,
            0,
            "rwbym:mayaxe",
            "rwbym:chatmag,rwbym:chatfiremag,rwbym:chatgravmag,rwbym:chatelectricmag",
            false,
            3,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(10);
    public static final Item whitefangspear = new RWBYGun(
            "whitefangspear",
            2500,
            15,
            RWBYGun.SCYTHE,
            null,
            "rwbym:nullest,rwbym:nuller",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            RWBYCreativeTabs.tab_rwbyweapons);

    public static final Item scarletstormgun = new RWBYGun(
            "scarletstormgun",
            2500,
            0,
            RWBYGun.INT_MAG,
            "rwbym:scarletstormaxe",
            "rwbym:ammmo",
            true,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.EMBER_CELICA_SHOOT.getSound(),//7,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(5);
    public static final Item scarletstormaxe = new RWBYGun(
            "scarletstormaxe",
            2500,
            16,
            RWBYGun.SCYTHE,
            "rwbym:scarletstormgun",
            "rwbym:nullest,rwbym:nuller",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            null);
    public static final Item iliasword = new RWBYGun(
            "iliasword",
            2500,
            12,
            RWBYGun.WHIP,
            null,
            "rwbym:nullest,rwbym:nuller",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item lionheart = new RWBYGun(
            "lionheart",
            2500,
            6,
            RWBYGun.LION_HEART,
            null,
            "rwbym:firedust,rwbym:firedustcrystal",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(3);
    public static final Item heroshield = new RWBYGun(
            "heroshield",
            0,
            12,
            0,
            "rwbym:leafshield",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            true,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            null);
    public static final Item leafshield = new RWBYGun(
            "leafshield",
            0,
            12,
            RWBYGun.AURAWEAP,
            "rwbym:pickaxeshield",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            true,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            null);
    public static final Item pickaxeshield = new RWBYGun(
            "pickaxeshield",
            0,
            12,
            RWBYGun.AURAWEAP|RWBYGun.PICKAXE,
            "rwbym:rageshield",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            true,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            null);
    public static final Item rageshield = new RWBYGun(
            "rageshield",
            0,
            16,
            RWBYGun.AURAWEAP,
            "rwbym:heroshield",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            true,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            null);
    public static final Item nolan = new RWBYGun(
            "nolan",
            2500,
            14,
            RWBYGun.HAMMER,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item royg = new RWBYGun(
            "royg",
            2500,
            0,
            RWBYGun.FIST|RWBYGun.INT_MAG,
            null,
            "rwbym:sawblade",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item wfp = new RWBYGun(
            "wfp",
            2500,
            0,
            0,
            null,
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(6);
    public static final Item gwenknife = new RWBYGun(
            "gwenknife",
            2500,
            8,
            RWBYGun.JUNIOR|RWBYGun.DAGGER,
            null,
            "rwbym:gwen",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item flyingthundergod = new RWBYGun(
            "flyingthundergod",
            2500,
            10,
            RWBYGun.DAGGER,
            null,
            "rwbym:thundergodammo",
            false,
            1,
            false,
            true,
            0,
            3,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            null);
    public static final Item deemace = new RWBYGun(
            "deemace",
            2500,
            18,
            RWBYGun.HAMMER,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item noctustraumnormal = new RWBYGun(
            "noctustraumnormal",
            2500,
            0,
            RWBYGun.INT_MAG,
            "rwbym:noctustraumnormalscy",
            "rwbym:noctu",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            RWBYCreativeTabs.tab_rwbyweapons).setElement("rwbym:noctustraumfire").setRecoil(5);
    public static final Item noctustraumfire = new RWBYGun(
            "noctustraumfire",
            2500,
            0,
            RWBYGun.INT_MAG,
            "rwbym:noctustraumfirescy",
            "rwbym:noctufire",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            null).setElement("rwbym:noctustraumice").setRecoil(5);
    public static final Item noctustraumice = new RWBYGun(
            "noctustraumice",
            2500,
            0,
            RWBYGun.INT_MAG,
            "rwbym:noctustraumicescy",
            "rwbym:noctuice",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            null).setElement("rwbym:noctustraumlight").setRecoil(5);
    public static final Item noctustraumlight = new RWBYGun(
            "noctustraumlight",
            2500,
            0,
            RWBYGun.INT_MAG,
            "rwbym:noctustraumlightscy",
            "rwbym:noctulight",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            null).setElement("rwbym:noctustraumgrav").setRecoil(5);
    public static final Item noctustraumgrav = new RWBYGun(
            "noctustraumgrav",
            2500,
            0,
            RWBYGun.INT_MAG,
            "rwbym:noctustraumgravscy",
            "rwbym:noctugrav",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            null).setElement("rwbym:noctustraumnormal").setRecoil(5);
    public static final Item noctustraumnormalscy = new RWBYGun(
            "noctustraumnormalscy",
            2500,
            16,
            RWBYGun.SCYTHE,
            "rwbym:noctustraumnormal",
            "rwbym:nullest,rwbym:nuller",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            null);
    public static final Item noctustraumfirescy = new RWBYGun(
            "noctustraumfirescy",
            2500,
            16,
            RWBYGun.SCYTHE,
            "rwbym:noctustraumfire",
            "rwbym:nullest,rwbym:nuller",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            null).setElementMelee("fire");
    public static final Item noctustraumicescy = new RWBYGun(
            "noctustraumicescy",
            2500,
            16,
            RWBYGun.SCYTHE,
            "rwbym:noctustraumice",
            "rwbym:nullest,rwbym:nuller",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            null).setElementMelee("ice");
    public static final Item noctustraumgravscy = new RWBYGun(
            "noctustraumgravscy",
            2500,
            16,
            RWBYGun.SCYTHE,
            "rwbym:noctustraumgrav",
            "rwbym:nullest,rwbym:nuller",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            null).setElementMelee("grav");
    public static final Item noctustraumlightscy = new RWBYGun(
            "noctustraumlightscy",
            2500,
            16,
            RWBYGun.SCYTHE,
            "rwbym:noctustraumlight",
            "rwbym:nullest,rwbym:nuller",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            null).setElementMelee("wind");

    public static final Item neonnormal = new RWBYGun(
            "neonnormal",
            2500,
            15,
            RWBYGun.HAMMER, 
            "rwbym:neonfire",
            "rwbym:nullest,rwbym:nuller",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item neonfire = new RWBYGun(
            "neonfire",
            2500,
            15,
            RWBYGun.HAMMER,
            "rwbym:neonice",
            "rwbym:nullest,rwbym:nuller",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            null).setElementMelee("fire");
    public static final Item neonice = new RWBYGun(
            "neonice",
            2500,
            15,
            RWBYGun.HAMMER,
            "rwbym:neonwind",
            "rwbym:nullest,rwbym:nuller",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            null).setElementMelee("ice");
    public static final Item neonwind = new RWBYGun(
            "neonwind",
            2500,
            15,
            RWBYGun.HAMMER, 
            "rwbym:neonnormal",
            "rwbym:nullest,rwbym:nuller",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//1,
            null).setElementMelee("wind");
    public static final Item tocksword = new RWBYGun(
            "tocksword",
            2500,
            14,
            RWBYGun.WINTER,
            null,
            "rwbym:nuller",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            RWBYCreativeTabs.tab_rwbyweapons);

    public static final Item lichtroze_closedfire = new RWBYGun(
            "lichtroze_closedfire",
            2500,
            14,
            RWBYGun.RAPIER|RWBYGun.UMBRELLA,
            "rwbym:lichtroze_closedice",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null).setElementMelee("fire");
    public static final Item lichtroze_closedice = new RWBYGun(
            "lichtroze_closedice",
            2500,
            14,
            RWBYGun.RAPIER|RWBYGun.UMBRELLA,
            "rwbym:lichtroze_closedwind",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons).setElementMelee("ice");
    public static final Item lichtroze_closedwind = new RWBYGun(
            "lichtroze_closedwind",
            2500,
            14,
            RWBYGun.RAPIER|RWBYGun.UMBRELLA,
            "rwbym:lichtroze_closedfire",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null).setElementMelee("wind");
    public static final Item kyoshifire = new RWBYGun(
            "kyoshifire",
            2500,
            14,
            RWBYGun.SWORD,
            "rwbym:kyoshigrav",
            "rwbym:firedust,rwbym:firedustcrystal",
            false,
            2,
            true,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(3).setElementMelee("fire");
    public static final Item kyoshigrav = new RWBYGun(
            "kyoshigrav",
            2500,
            14,
            RWBYGun.SWORD,
            "rwbym:kyoshiice",
            "rwbym:gravitydust,rwbym:gravitydustcrystal",
            false,
            2,
            true,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            null).setRecoil(3).setElementMelee("grav");
    public static final Item kyoshiice = new RWBYGun(
            "kyoshiice",
            2500,
            14,
            RWBYGun.SWORD,
            "rwbym:kyoshiwind",
            "rwbym:icedust,rwbym:icedustcrystal",
            false,
            2,
            true,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            null).setRecoil(3).setElementMelee("ice");
    public static final Item kyoshiwind = new RWBYGun(
            "kyoshiwind",
            2500,
            14,
            RWBYGun.SWORD,
            "rwbym:kyoshifire",
            "rwbym:winddust,rwbym:winddustcrystal",
            false,
            2,
            true,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            null).setRecoil(3).setElementMelee("wind");
    public static final Item whitefangsword = new RWBYGun(
            "whitefangsword",
            2500,
            14,
            RWBYGun.SWORD,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item whitefangrifle = new RWBYGun(
            "whitefangrifle",
            2500,
            0,
            0,
            null,
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.PORT_SHOOT.getSound(),//8,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(6);
    public static final Item amberstafffire = new RWBYGun(
            "amberstafffire",
            2500,
            12,
            RWBYGun.STAFF|RWBYGun.HAMMER,
            "rwbym:amberstaffwind",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons
    ).setElementMelee("fire");
    public static final Item amberstaffwind = new RWBYGun(
            "amberstaffwind",
            2500,
            12,
            RWBYGun.STAFF|RWBYGun.HAMMER,
            "rwbym:amberstafffire",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null
    ).setElementMelee("wind");

    public static final Item amesardentgun = new RWBYGun(
            "amesardentgun",
            2500,
            0,
            0,
            "rwbym:amesardent",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            false,
            false,
            0,
            4,
            0,
            () -> Sound.EMBER_CELICA_SHOOT.getSound(),//2,
            null).setRecoil(7);
    public static final Item amesardent = new RWBYGun(
            "amesardent",
            2500,
            16,
            RWBYGun.SWORD,
            "rwbym:amesardentgun",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item onoyari = new RWBYGun(
            "onoyari",
            2500,
            17,
            RWBYGun.SCYTHE,
            null,
            "rwbym:neptammo,rwbym:magnaampammo",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.CRESCENT_ROSE_SHOOT.getSound(),//13,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(8);
    public static final Item pugzbow = new RWBYGun(
            "pugzbow",
            2500,
            0,
            RWBYGun.BOW,
            "rwbym:pugzsword",
            "minecraft:arrow,minecraft:tipped_arrow,rwbym:bolt,rwbym:boltwind,rwbym:boltlight,rwbym:boltice,rwbym:boltgrav,rwbym:boltfire",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ARROW_SHOOT,
            null);
    public static final Item pugzsword = new RWBYGun("pugzsword",
            2500,
            14,
            RWBYGun.SWORD,
            "rwbym:pugzbow",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item whisperingblossom = new RWBYGun(
            "whisperingblossom",
            2500,
            17,
            RWBYGun.SCYTHE|RWBYGun.INT_MAG|RWBYGun.UMBRELLA,
            null,
            "rwbym:whisperammo",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            RWBYCreativeTabs.tab_rwbyweapons).setElementMelee("grav");
    public static final Item cassandra = new RWBYGun("cassandra",
            2500,
            16,
            RWBYGun.SWORD,
            "rwbym:cassandragun",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item cassandragun = new RWBYGun(
            "cassandragun",
            2500,
            0,
            0, 
            "rwbym:cassandra",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            null).setRecoil(5);
    public static final Item freyr = new RWBYGun(
            "freyr",
            2700,
            16,
            RWBYGun.RAPIER,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item nornir = new RWBYGun(
            "nornir",
            2700,
            0,
            0,
            null,
            "rwbym:spl,rwbym:splfire",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            RWBYCreativeTabs.tab_rwbyweapons).setRecoil(4);
    public static final Item hollowtome = new RWBYGun("hollowtome",
            2500,
            10,
            RWBYGun.TOME,
            "rwbym:hollowtomefire",
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item hollowtomefire = new RWBYGun("hollowtomefire",
            2500,
            10,
            RWBYGun.TOME,
            "rwbym:hollowtomegravity",
            "rwbym:firedust,rwbym:firedustcrystal",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            null).setElementMelee("fire");
    public static final Item hollowtomegravity = new RWBYGun("hollowtomegravity",
            2500,
            10,
            RWBYGun.TOME,
            "rwbym:hollowtomewind",
            "rwbym:gravitydust,rwbym:gravitydustcrystal",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            null).setElementMelee("grav");
    public static final Item hollowtomewind = new RWBYGun("hollowtomewind",
            2500,
            10,
            RWBYGun.TOME,
            "rwbym:hollowtomelightning",
            "rwbym:winddust,rwbym:winddustcrystal",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            null).setElementMelee("wind");
    public static final Item hollowtomelightning = new RWBYGun("hollowtomelightning",
            2500,
            10,
            RWBYGun.TOME,
            "rwbym:hollowtomewater",
            "rwbym:lightdust,rwbym:lightdustcrystal",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            null).setElementMelee("light");
    public static final Item hollowtomewater = new RWBYGun("hollowtomewater",
            2500,
            10,
            RWBYGun.TOME,
            "rwbym:hollowtomeice",
            "rwbym:waterdust,rwbym:waterdustcrystal",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            null).setElementMelee("water");
    public static final Item hollowtomeice = new RWBYGun("hollowtomeice",
            2500,
            10,
            RWBYGun.TOME,
            "rwbym:hollowtome",
            "rwbym:icedust,rwbym:icedustcrystal",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            () -> Sound.MYRTENASTER_SHOOT.getSound(),//4,
            null).setElementMelee("ice");

    public static final Item kingfisher = new RWBYFishing("kingfisher");

    public static final Item chastifol = new RWBYGun(
            "chastifol",
            2500,
            16,
            RWBYGun.SCYTHE|RWBYGun.THROWN|RWBYGun.BOOMERANG,
            "rwbym:chastifolincrease",
            "rwbym:chastifolammo",
            false,
            1F,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            null);

    public static final Item chastifolincrease = new RWBYGun(
            "chastifolincrease",
            2500,
            8,
            RWBYGun.DAGGER|RWBYGun.INT_MAG,
            "rwbym:chastifol",
            "rwbym:chastifolincreaseammo",
            false,
            0.6F,
            false,
            false,
            0,
            8,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            null);

    public static final Item carminesai = new RWBYGun(
            "carminesai",
            2500,
            8,
            RWBYGun.DAGGER|RWBYGun.THROWN,
            "rwbym:carminestaff",
            "rwbym:carminesaiammo",
            true,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            RWBYCreativeTabs.tab_rwbyweapons);

    public static final Item carminestaff = new RWBYGun(
            "carminestaff",
            2500,
            15,
            RWBYGun.SCYTHE|RWBYGun.THROWN,
            "rwbym:carminesai",
            "rwbym:carminestaffammo",
            true,
            1,
            false,
            false,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            null);

    public static final Item moonskimmer = new RWBYGun(
            "moonskimmer",
            2500,
            1,
            RWBYGun.FLIGHT,
            null,
            "rwbym:nuller",
            true,
            1,
            false,
            true,
            0,
            1,
            0,
            () -> SoundEvents.ENTITY_ENDERPEARL_THROW,
            RWBYCreativeTabs.tab_rwbyweapons);

    public static final Item mondragon = new RWBYGun(
            "mondragon",
            2500,
            14,
            RWBYGun.FLIGHT|RWBYGun.SCYTHE,
            null,
            "rwbym:gravitydustcrystal,rwbym:icedustcrystal,rwbym:firedustcrystal,rwbym:lightdustcrystal",
            false,
            2,
            false,
            true,
            0,
            1,
            0,
            () -> Sound.GAMBOL_SHROUD_SHOOT.getSound(),//3,
            null).setRecoil(5);

    //------------------------------------------------//
    public static final Item ammo = new RWBYItem("ammo",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item charm = new RWBYItem("charm",  false, null);
    public static final Item gamammo = new RWBYItem("gamammo",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item magngrenade = new RWBYItem("magngrenade",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item emshell = new RWBYItem("emshell",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item emflareshell = new RWBYItem("emflareshell",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item emfireshell = new RWBYItem("emfireshell",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item dustrock = new RWBYItem("dustrock",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item dustrockhardlight = new RWBYItem("dustrockhardlight",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item dust = new RWBYItem("dust",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item winddustrock = new RWBYItem("winddustrock",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item firedustrock = new RWBYItem("firedustrock",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item gravitydustrock = new RWBYItem("gravitydustrock",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item waterdustrock = new RWBYItem("waterdustrock",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item lightdustrock = new RWBYItem("lightdustrock",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item icedustrock = new RWBYItem("icedustrock",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item roseiron = new RWBYItem("roseiron",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item gildediron = new RWBYItem("gildediron",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item frostediron = new RWBYItem("frostediron",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item shadowiron = new RWBYItem("shadowiron",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item viridianiron = new RWBYItem("viridianiron",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item forestiron = new RWBYItem("forestiron",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cr1 = new RWBYItem("cr1",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cr2 = new RWBYItem("cr2",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cr3 = new RWBYItem("cr3",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cr4 = new RWBYItem("cr4",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cr5 = new RWBYItem("cr5",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cr6 = new RWBYItem("cr6",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item mytre1 = new RWBYItem("mytre1",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item mytre2 = new RWBYItem("mytre2",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item mytre3 = new RWBYItem("mytre3",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item gam1 = new RWBYItem("gam1",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item gam2 = new RWBYItem("gam2",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item gam3 = new RWBYItem("gam3",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item em1 = new RWBYItem("em1",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item em2 = new RWBYItem("em2",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item em3 = new RWBYItem("em3",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cro1 = new RWBYItem("cro1",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cro2 = new RWBYItem("cro2",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cro3 = new RWBYItem("cro3",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item magn1 = new RWBYItem("magn1",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item magn2 = new RWBYItem("magn2",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item magn3 = new RWBYItem("magn3",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item magn4 = new RWBYItem("magn4",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item milo1 = new RWBYItem("milo1",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item milo2 = new RWBYItem("milo2",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item milo3 = new RWBYItem("milo3",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item stor1 = new RWBYItem("stor1",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item stor2 = new RWBYItem("stor2",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item stor3 = new RWBYItem("stor3",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item stor4 = new RWBYItem("stor4",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item stor5 = new RWBYItem("stor5",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item stor6 = new RWBYItem("stor6",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item he1 = new RWBYItem("he1",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item he2 = new RWBYItem("he2",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item he3 = new RWBYItem("he3",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item he4 = new RWBYItem("he4",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item he5 = new RWBYItem("he5",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item he6 = new RWBYItem("he6",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item taintedartefact = new RWBYItem("taintedartefact",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item scrap = new RWBYItem("scrap",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item atlasknight = new RWBYItem("atlasknight",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item remnants = new RWBYItem("remnants",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item armagigas = new RWBYItem("armagigas",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item zwei = new RWBYItem("zwei",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item coinr = new RWBYItem("coinr",  false, RWBYCreativeTabs.tab_rwbyitems).setCoin("ruby");
    public static final Item coinw = new RWBYItem("coinw",  false, RWBYCreativeTabs.tab_rwbyitems).setCoin("weiss");
    public static final Item coinb = new RWBYItem("coinb",  false, RWBYCreativeTabs.tab_rwbyitems).setCoin("blake");
    public static final Item coiny = new RWBYItem("coiny",  false, RWBYCreativeTabs.tab_rwbyitems).setCoin("yang");
    public static final Item coinjaune = new RWBYItem("coinjaune",  false, RWBYCreativeTabs.tab_rwbyitems).setCoin("jaune");
    public static final Item coinnora = new RWBYItem("coinnora",  false, RWBYCreativeTabs.tab_rwbyitems).setCoin("nora");
    public static final Item coin_ren = new RWBYItem("coin_ren",  false, RWBYCreativeTabs.tab_rwbyitems).setCoin("ren");
    public static final Item coin_lysette = new RWBYItem("coin_lysette",  false, RWBYCreativeTabs.tab_rwbyitems).setCoin("lysette");
    public static final Item coinqrow = new RWBYItem("coinqrow",  false, RWBYCreativeTabs.tab_rwbyitems).setCoin("qrow");
    public static final Item coin_raven = new RWBYItem("coin_raven",  false, RWBYCreativeTabs.tab_rwbyitems).setCoin("raven");
    public static final Item coin_ragora = new RWBYItem("coin_ragora",  false, RWBYCreativeTabs.tab_rwbyitems).setCoin("ragora");
    public static final Item coin_clover = new RWBYItem("coin_clover",  false, RWBYCreativeTabs.tab_rwbyitems).setCoin("clover");
    public static final Item coin_harriet = new RWBYItem("coin_harriet",  false, RWBYCreativeTabs.tab_rwbyitems).setCoin("harriet");
    public static final Item coin_pyrrha = new RWBYItem("coin_pyrrha",  false, RWBYCreativeTabs.tab_rwbyitems).setCoin("pyrrha");
    public static final Item coin_valour = new RWBYItem("coin_valour",  false, RWBYCreativeTabs.tab_rwbyitems).setCoin("valour");
    public static final Item coin_penny = new RWBYItem("coin_penny",  false, RWBYCreativeTabs.tab_rwbyitems).setCoin("penny");
    public static final Item chisel = new RWBYItem("chisel",  false, RWBYCreativeTabs.tab_rwbyitems).setHasContainerItem(true).setContainerItemLambda(stack -> (stack.attemptDamageItem(1, new Random(), null) ? ItemStack.EMPTY : stack)).setMaxDamage(255).setMaxStackSize(1);
    public static final Item crush = new RWBYItem("crush",  false, RWBYCreativeTabs.tab_rwbyitems).setHasContainerItem(true).setContainerItemLambda(stack -> (stack.attemptDamageItem(1, new Random(), null) ? ItemStack.EMPTY : stack)).setMaxDamage(255).setMaxStackSize(1);
    public static final Item lien1 = new RWBYItem("lien1",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item lien5 = new RWBYItem("lien5",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item lien10 = new RWBYItem("lien10",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item lien20 = new RWBYItem("lien20",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item lien50 = new RWBYItem("lien50",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item lien100 = new RWBYItem("lien100",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item lien500 = new RWBYItem("lien500",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item signcrow = new RWBYItem("signcrow",  false, null);
    public static final Item signdust = new RWBYItem("signdust",  false, null);
    public static final Item scroll = new RWBYItem("scroll",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item scroll2 = new RWBYItem("scroll2",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item scrollwhite7 = new RWBYItem("7scroll_white",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item scrollblack7 = new RWBYItem("7scroll_black",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item scrollblue7 = new RWBYItem("7scroll_blue",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item scrollgreen7 = new RWBYItem("7scroll_green",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item scrollpink7 = new RWBYItem("7scroll_pink",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item scrollred7 = new RWBYItem("7scroll_red",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item scrollyellow7 = new RWBYItem("7scroll_yellow",  false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item glider = new RWBYGliderItem().setRegistryName(RWBYModels.MODID, "glider").setUnlocalizedName("glider");
    public static final Item gliderdeployed = new RWBYGliderItem().setRegistryName(RWBYModels.MODID, "gliderdeployed").setUnlocalizedName("gliderdeployed");

    //Right Arm
    public static final Item rgrimmarm = new RWBYLimbItem("rgrimmarm", "RightArm");
    public static final Item clearrightarm = new RWBYLimbItem("clearrightarm", "RightArm");

    //Left Arm
    public static final Item lgrimmarm = new RWBYLimbItem("lgrimmarm", "LeftArm");
    public static final Item clearleftarm = new RWBYLimbItem("clearleftarm", "LeftArm");

    //Right Leg
    public static final Item rgrimmleg = new RWBYLimbItem("rgrimmleg", "RightLeg");
    public static final Item clearrightleg = new RWBYLimbItem("clearrightleg", "RightLeg");

    //Left Leg
    public static final Item lgrimmleg = new RWBYLimbItem("lgrimmleg", "LeftLeg");
    public static final Item clearleftleg = new RWBYLimbItem("clearleftleg",  "LeftLeg");

    //Head
    public static final Item grimmhead = new RWBYLimbItem("grimmhead", "Head");
    public static final Item clearhead = new RWBYLimbItem("clearhead", "Head");


    //Body
    public static final Item clearbody = new RWBYLimbItem("clearbody", "Body");
    public static final Item grimmbody = new RWBYLimbItem("grimmbody", "Body");


    //Tail
    public static final Item cattail = new RWBYLimbItem("cattail", "Tail");
    public static final Item cattailblonde = new RWBYLimbItem("cattailblonde", "Tail");
    public static final Item cattailbrown = new RWBYLimbItem("cattailbrown", "Tail");
    public static final Item cattailgrey = new RWBYLimbItem("cattailgrey", "Tail");
    public static final Item cattailorange = new RWBYLimbItem("cattailorange", "Tail");
    public static final Item dorsalfinblack = new RWBYLimbItem("dorsalfinblack", "Tail");
    public static final Item dorsalfingrey = new RWBYLimbItem("dorsalfingrey", "Tail");
    public static final Item dorsalfinpearl = new RWBYLimbItem("dorsalfinpearl", "Tail");
    public static final Item dorsalfinsilver = new RWBYLimbItem("dorsalfinsilver", "Tail");
    public static final Item rabbittailblack = new RWBYLimbItem("rabbittailblack", "Tail");
    public static final Item rabbittailblonde = new RWBYLimbItem("rabbittailblonde", "Tail");
    public static final Item rabbittailbrown = new RWBYLimbItem("rabbittailbrown", "Tail");
    public static final Item rabbittailgrey = new RWBYLimbItem("rabbittailgrey", "Tail");
    public static final Item rabbittailorange = new RWBYLimbItem("rabbittailorange", "Tail");
    public static final Item rabbittailwhite = new RWBYLimbItem("rabbittailwhite", "Tail");
    public static final Item cleartail = new RWBYLimbItem("cleartail", "Tail");
    public static final Item kag = new RWBYLimbItem("kag", "Tail");
    public static final Item kag2 = new RWBYLimbItem("kag2", "Tail");
    public static final Item blackdragontail = new RWBYLimbItem("blackdragontail", "Tail");
    public static final Item blackfoxtail = new RWBYLimbItem("blackfoxtail", "Tail");
    public static final Item blackwolftail = new RWBYLimbItem("blackwolftail", "Tail");
    public static final Item blondefoxtail = new RWBYLimbItem("blondefoxtail", "Tail");
    public static final Item blondewolftail = new RWBYLimbItem("blondewolftail", "Tail");
    public static final Item bluedragontail = new RWBYLimbItem("bluedragontail", "Tail");
    public static final Item brownfoxtail = new RWBYLimbItem("brownfoxtail", "Tail");
    public static final Item brownwolftail = new RWBYLimbItem("brownwolftail", "Tail");
    public static final Item golddragontail = new RWBYLimbItem("golddragontail", "Tail");
    public static final Item grayfoxtail = new RWBYLimbItem("grayfoxtail", "Tail");
    public static final Item graywolftail = new RWBYLimbItem("graywolftail", "Tail");
    public static final Item greendragontail = new RWBYLimbItem("greendragontail", "Tail");
    public static final Item orangefoxtail = new RWBYLimbItem("orangefoxtail", "Tail");
    public static final Item orangewolftail = new RWBYLimbItem("orangewolftail", "Tail");
    public static final Item reddragontail = new RWBYLimbItem("reddragontail", "Tail");
    public static final Item silverdragontail = new RWBYLimbItem("silverdragontail", "Tail");
    public static final Item whitedragontail = new RWBYLimbItem("whitedragontail", "Tail");
    public static final Item whitefoxtail = new RWBYLimbItem("whitefoxtail", "Tail");
    public static final Item whitewolftail = new RWBYLimbItem("whitewolftail", "Tail");

    //Ears
    public static final Item whitefoxear = new RWBYLimbItem("whitefoxear", "Ears");
    public static final Item antlerlarge = new RWBYLimbItem("antlerlarge", "Ears");
    public static final Item antlersmall = new RWBYLimbItem("antlersmall", "Ears");
    public static final Item blackbullhorns = new RWBYLimbItem("blackbullhorns", "Ears");
    public static final Item blackwolfears = new RWBYLimbItem("blackwolfears", "Ears");
    public static final Item blondewolfears = new RWBYLimbItem("blondewolfears", "Ears");
    public static final Item bonebullhorns = new RWBYLimbItem("bonebullhorns", "Ears");
    public static final Item brownwolfears = new RWBYLimbItem("brownwolfears", "Ears");
    public static final Item graywolfears = new RWBYLimbItem("graywolfears", "Ears");
    public static final Item orangewolfears = new RWBYLimbItem("orangewolfears", "Ears");
    public static final Item ramhorns = new RWBYLimbItem("ramhorns", "Ears");
    public static final Item whitewolfears = new RWBYLimbItem("whitewolfears", "Ears");
    public static final Item rabbitearsblack = new RWBYLimbItem("rabbitearsblack", "Ears");
    public static final Item rabbitearsblonde = new RWBYLimbItem("rabbitearsblonde", "Ears");
    public static final Item rabbitearsbrown = new RWBYLimbItem("rabbitearsbrown", "Ears");
    public static final Item rabbitearsgrey = new RWBYLimbItem("rabbitearsgrey", "Ears");
    public static final Item rabbitearsorange = new RWBYLimbItem("rabbitearsorange", "Ears");
    public static final Item rabbitearswhite = new RWBYLimbItem("rabbitearswhite", "Ears");
    public static final Item grimmhorn = new RWBYLimbItem("grimmhorn", "Ears");
    public static final Item clearears = new RWBYLimbItem("clearears", "Ears");
    public static final Item blackcatear = new RWBYLimbItem("blackcatear", "Ears");
    public static final Item blondecatear = new RWBYLimbItem("blondecatear", "Ears");
    public static final Item browncatear = new RWBYLimbItem("browncatear", "Ears");
    public static final Item greycatear = new RWBYLimbItem("greycatear", "Ears");
    public static final Item orangecatear = new RWBYLimbItem("orangecatear", "Ears");
    public static final Item blackfoxear = new RWBYLimbItem("blackfoxear", "Ears");
    public static final Item blondefoxear = new RWBYLimbItem("blondefoxear", "Ears");
    public static final Item brownfoxear = new RWBYLimbItem("brownfoxear", "Ears");
    public static final Item greyfoxear = new RWBYLimbItem("greyfoxear", "Ears");
    public static final Item orangefoxear = new RWBYLimbItem("orangefoxear", "Ears");


    //------------------------------------------------//
    public static final Item wallet = new RWBYContainerItem(
    		"lienwallet",
    		"rwbym:lien1,rwbym:lien5,rwbym:lien10,rwbym:lien20,rwbym:lien50,rwbym:lien100,rwbym:lien500",
    		9,
    		1,
    		FMLCommonHandler.instance().getSide() == Side.CLIENT ? RWBYItemContainerGui.class : null,
    		RWBYItemContainer.class)
    		.setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);
    public static final Item dustpouch = new RWBYContainerItem(
            "dustpouch",
            "rwbym:dustrockhardlight,rwbym:dustcrystalhardlight,rwbym:dustcrystalcut,rwbym:winddustcrystalcut,rwbym:firedustcrystalcut,rwbym:gravitydustcrystalcut,rwbym:waterdustcrystalcut,rwbym:lightdustcrystalcut,rwbym:icedustcrystalcut,rwbym:fireblock,rwbym:gravityblock,rwbym:iceblock,rwbym:impureblock,rwbym:lightblock,rwbym:waterblock,rwbym:windblock,rwbym:dustcrystal,rwbym:winddustcrystal,rwbym:firedustcrystal,rwbym:gravitydustcrystal,rwbym:waterdustcrystal,rwbym:lightdustcrystal,rwbym:icedustcrystal,rwbym:dustrock,rwbym:winddustrock,rwbym:firedustrock,rwbym:gravitydustrock,rwbym:waterdustrock,rwbym:lightdustrock,rwbym:icedustrock,rwbym:dust,rwbym:winddust,rwbym:firedust,rwbym:gravitydust,rwbym:waterdust,rwbym:lightdust,rwbym:icedust",
            9,
            1,
            FMLCommonHandler.instance().getSide() == Side.CLIENT ? RWBYItemContainerGui.class : null,
            RWBYItemContainer.class)
            .setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);
    public static final Item partspouch = new RWBYContainerItem(
            "partspouch",
            "rwbym:cr1,rwbym:cr2,rwbym:cr3,rwbym:cr4,rwbym:cr5,rwbym:cr6,rwbym:mytre1,rwbym:mytre2,rwbym:mytre3,rwbym:gam1,rwbym:gam2,rwbym:gam3,rwbym:em1,rwbym:em2,rwbym:em3,rwbym:cro1,rwbym:cro2,rwbym:cro3,rwbym:magn1,rwbym:magn2,rwbym:magn3,rwbym:magn4,rwbym:milo1,rwbym:milo2,rwbym:milo3,rwbym:stor1,rwbym:stor2,rwbym:stor3,rwbym:stor4,rwbym:stor5,rwbym:stor6,rwbym:scrap,rwbym:roseiron,rwbym:gildediron,rwbym:frostediron,rwbym:shadowiron,rwbym:viridianiron,rwbym:forestiron",
            9,
            1,
            FMLCommonHandler.instance().getSide() == Side.CLIENT ? RWBYItemContainerGui.class : null,
            RWBYItemContainer.class)
            .setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);
    public static final Item container = new RWBYContainerItem(
    		"container",
    		"rwbym:dustrockhardlight,rwbym:dustcrystalhardlight,rwbym:dustcrystalcut,rwbym:winddustcrystalcut,rwbym:firedustcrystalcut,rwbym:gravitydustcrystalcut,rwbym:waterdustcrystalcut,rwbym:lightdustcrystalcut,rwbym:icedustcrystalcut,rwbym:forestironblock,rwbym:frostedironblock,rwbym:gildedironblock,rwbym:roseironblock,rwbym:shadowironblock,rwbym:viridianironblock,rwbym:fireblock,rwbym:gravityblock,rwbym:iceblock,rwbym:impureblock,rwbym:lightblock,rwbym:waterblock,rwbym:windblock,rwbym:dustcrystal,rwbym:winddustcrystal,rwbym:firedustcrystal,rwbym:gravitydustcrystal,rwbym:waterdustcrystal,rwbym:lightdustcrystal,rwbym:icedustcrystal,rwbym:cr1,rwbym:cr2,rwbym:cr3,rwbym:cr4,rwbym:cr5,rwbym:cr6,rwbym:mytre1,rwbym:mytre2,rwbym:mytre3,rwbym:gam1,rwbym:gam2,rwbym:gam3,rwbym:em1,rwbym:em2,rwbym:em3,rwbym:cro1,rwbym:cro2,rwbym:cro3,rwbym:magn1,rwbym:magn2,rwbym:magn3,rwbym:magn4,rwbym:milo1,rwbym:milo2,rwbym:milo3,rwbym:stor1,rwbym:stor2,rwbym:stor3,rwbym:stor4,rwbym:stor5,rwbym:stor6,rwbym:scrap,rwbym:remnants,rwbym:dustrock,rwbym:winddustrock,rwbym:firedustrock,rwbym:gravitydustrock,rwbym:waterdustrock,rwbym:lightdustrock,rwbym:icedustrock,rwbym:dust,rwbym:winddust,rwbym:firedust,rwbym:gravitydust,rwbym:waterdust,rwbym:lightdust,rwbym:icedust,rwbym:lien1,rwbym:lien5,rwbym:lien10,rwbym:lien20,rwbym:lien50,rwbym:lien100,rwbym:lien500,rwbym:roseiron,rwbym:gildediron,rwbym:frostediron,rwbym:shadowiron,rwbym:viridianiron,rwbym:forestiron",
    		54,
    		1,
    		FMLCommonHandler.instance().getSide() == Side.CLIENT ? RWBYItemContainerGuiChest.class : null,
    		RWBYItemContainerChest.class)
    		.setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);

    public static final Item darkrepulser = new RWBYGun("darkrepulser",
            2500,
            14,
            RWBYGun.SWORD,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
           null);

    public static final Item elucidator = new RWBYGun("elucidator",
            2500,
            14,
            RWBYGun.SWORD,
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            false,
            true,
            0,
            1,
            0,
            null,
            null);


    //------------------------------------------------//


    public static final Item hchoc = new RWBYFood("hchoc",null, 1, RWBYCreativeTabs.tab_rwbyitems );
    public static final Item coffee = new RWBYFood("coffee",null, 2, RWBYCreativeTabs.tab_rwbyitems );
    public static final Item sunrise = new RWBYFood("sunrise",null, 3, RWBYCreativeTabs.tab_rwbyitems );
    public static final Item plg = new RWBYFood("plg",null, 4, RWBYCreativeTabs.tab_rwbyitems );
    public static final Item torchquick = new RWBYFood("torchquick",null, 5, RWBYCreativeTabs.tab_rwbyitems );
    public static final Item qrowflask = new RWBYFood("qrowflask",null, 6, RWBYCreativeTabs.tab_rwbyitems );
    public static final Item sake = new RWBYFood("sake",null, 7, RWBYCreativeTabs.tab_rwbyitems );
    public static final Item coconutmilk = new RWBYFood("coconutmilk",null, 8, RWBYCreativeTabs.tab_rwbyitems );
    public static final Item pancakes = new RWBYFood("pancakes",null, 9, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item bourbon = new RWBYFood("bourbon",null, 10, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item brandy = new RWBYFood("brandy",null, 11, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item vodka = new RWBYFood("vodka",null, 12, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item wine = new RWBYFood("wine",null, 13, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item fishramen = new RWBYFood("fishramen",null, 14, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item ramen = new RWBYFood("ramen",null, 15, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item peach = new RWBYFood("peach",null, 16, RWBYCreativeTabs.tab_rwbyitems);

    //-----------------------------------------------//
    public static final Item entitybullet = new RWBYItem("entitybullet",  false, null);
    public static final Item entitythundergod = new RWBYItem("entitythundergod",  false, null);
    public static final Item entityfireshell = new RWBYItem("entityfireshell",  false, null);
    public static final Item entityflareshell = new RWBYItem("entityflareshell",  false, null);
    public static final Item entityshell = new RWBYItem("entityshell",  false, null);
    public static final Item entitysmallbullet = new RWBYItem("entitysmallbullet",  false, null);
    public static final Item entitygrenade = new RWBYItem("entitygrenade",  false, null);
    public static final Item entitybulletv = new RWBYItem("entitybulletv",  false, null);
    public static final Item entityweissfire = new RWBYItem("entityweissfire",  false, null);
    public static final Item entityweissgravity = new RWBYItem("entityweissgravity",  false, null);
    public static final Item entityweissice = new RWBYItem("entityweissice",  false, null);
    public static final Item entityweisslight = new RWBYItem("entityweisslight",  false, null);
    public static final Item entityweisswater = new RWBYItem("entityweisswater",  false, null);
    public static final Item entityweisswind = new RWBYItem("entityweisswind",  false, null);
    public static final Item entityrocket = new RWBYItem("entityrocket",  false, null);
    public static final Item entityextasisammo = new RWBYItem("entityextasisammo",  false, null);
    public static final Item entitybolt = new RWBYItem("entitybolt", false, null);
    public static final Item entityboltice = new RWBYItem("entityboltice", false, null);
    public static final Item entityboltlight = new RWBYItem("entityboltlight", false, null);
    public static final Item entityboltwind = new RWBYItem("entityboltwind", false, null);
    public static final Item entityboltfire = new RWBYItem("entityboltfire", false, null);
    public static final Item entityboltgrav = new RWBYItem("entityboltgrav", false, null);
    public static final Item whisperingblossomammo = new RWBYItem("whisperingblossomammo",  false, null);
    public static final Item saw = new RWBYItem("saw",  false, null);

    //------------------------------------------------//
    public static final Item dustcrystalhardlight = new RWBYAmmoItem(
            "dustcrystalhardlight",
            RWBYItems.entityweisswater,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            RWBYAmmoItem.HARDLIGHT,
            null,
            20,
            0,
            RWBYCreativeTabs.tab_rwbyitems,
            new PotionAmmoHit(Items.SPLASH_POTION, ImmutableList.of(new PotionEffect(Potion.getPotionById(22), 100, 2)))).setDustCrystal(true);
    public static final Item dustcrystal = new RWBYAmmoItem(
            "dustcrystal",
            RWBYItems.entityweisswater,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            RWBYAmmoItem.IMPURE,
            null,
            20,
            0,
            RWBYCreativeTabs.tab_rwbyitems,
            new PotionAmmoHit(Items.SPLASH_POTION, ImmutableList.of(new PotionEffect(Potion.getPotionById(22), 100, 2)))).setDustCrystal(true);
    public static final Item waterdustcrystal = new RWBYAmmoItem(
            "waterdustcrystal",
            RWBYItems.entityweisswater,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            RWBYAmmoItem.WATER,
            null,
            20,
            0,
            RWBYCreativeTabs.tab_rwbyitems,
            new PotionAmmoHit(Items.SPLASH_POTION, ImmutableList.of(new PotionEffect(Potion.getPotionById(22), 100, 2)))).setDustCrystal(true);
    public static final Item winddustcrystal = new RWBYAmmoItem(
            "winddustcrystal",
            RWBYItems.entityweisswind,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            RWBYAmmoItem.WIND,
            ImmutableList.of(new PotionEffect(MobEffects.SPEED, 400, 2)),
            20,
            0,
            RWBYCreativeTabs.tab_rwbyitems,
            null).setDustCrystal(true);
    public static final Item firedustcrystal = new RWBYAmmoItem(
            "firedustcrystal",
            RWBYItems.entityweissfire,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            RWBYAmmoItem.FIRE,
            null,
            20,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            new FireAmmoHit(10)).setDustCrystal(true);
    public static final Item icedustcrystal = new RWBYAmmoItem(
            "icedustcrystal",
            RWBYItems.entityweissice,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            RWBYAmmoItem.ICE,
            ImmutableList.of(new PotionEffect(MobEffects.SLOWNESS, 500, 20)),
            20,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            null).setDustCrystal(true);
    public static final Item lightdustcrystal = new RWBYAmmoItem(
            "lightdustcrystal",
            RWBYItems.entityweisslight,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            RWBYAmmoItem.LIGHTNING,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:slowness"), 400, 2)),
            20,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            new ExplosionAmmoHit(0)).setDustCrystal(true);
    public static final Item gravitydustcrystal = new RWBYAmmoItem(
            "gravitydustcrystal",
            RWBYItems.entityweissgravity,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            RWBYAmmoItem.GRAVITY,
            null,
            20,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            new PotionAmmoHit(Items.LINGERING_POTION, ImmutableList.of(new PotionEffect(Potion.getPotionById(25), 60, 3, false, false)))).setDustCrystal(true);
    public static final Item whisperammo = new RWBYAmmoItem(
            "whisperammo",
            RWBYItems.whisperingblossomammo,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:levitation"), 100, 2)),
            32,
            14,
            null,
            null);
    public static final Item noctu = new RWBYAmmoItem(
            "noctu",
            RWBYItems.entitysmallbullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            32,
            14,
            null,
            null);
    public static final Item noctufire = new RWBYAmmoItem(
            "noctufire",
            RWBYItems.entitysmallbullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            32,
            14,
            null,
            new FireAmmoHit(10));
    public static final Item noctuice = new RWBYAmmoItem(
            "noctuice",
            RWBYItems.entitysmallbullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:slowness"), 100, 5)),
            32,
            14,
            null,
            null);
    public static final Item noctugrav = new RWBYAmmoItem(
            "noctugrav",
            RWBYItems.entitysmallbullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:levitation"), 100, 2)),
            32,
            14,
            null,
            null);
    public static final Item noctulight = new RWBYAmmoItem(
            "noctulight",
            RWBYItems.entitysmallbullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            32,
            14,
            null,
            new ExplosionAmmoHit(0));
    public static final Item spl = new RWBYAmmoItem(
            "spl",
            RWBYItems.entitysmallbullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            32,
            12,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item splfire = new RWBYAmmoItem(
            "splfire",
            RWBYItems.entitysmallbullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            32,
            12,
            RWBYCreativeTabs.tab_rwbyitems,
            new FireAmmoHit(10));
    public static final Item splice = new RWBYAmmoItem(
            "splice",
            RWBYItems.entitysmallbullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:slowness"), 100, 5)),
            32,
            12,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item splgrav = new RWBYAmmoItem(
            "splgrav",
            RWBYItems.entitysmallbullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:levitation"), 100, 2)),
            32,
            12,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item spllight = new RWBYAmmoItem(
            "spllight",
            RWBYItems.entitysmallbullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            32,
            12,
            RWBYCreativeTabs.tab_rwbyitems,
            new ExplosionAmmoHit(0));
    public static final Item gammag = new RWBYAmmoItem(
            "gammag",
            RWBYItems.entitysmallbullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            32,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item gamfiremag = new RWBYAmmoItem(
            "gamfiremag",
            RWBYItems.entitysmallbullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            32,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            new FireAmmoHit(10));
    public static final Item gamicemag = new RWBYAmmoItem(
            "gamicemag",
            RWBYItems.entitysmallbullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:slowness"), 100, 5)),
            32,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item gamgravmag = new RWBYAmmoItem(
            "gamgravmag",
            RWBYItems.entitysmallbullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:levitation"), 100, 2)),
            32,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item emammo = new RWBYAmmoItem(
            "emammo",
            RWBYItems.entitysmallbullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            32,
            5,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item emfireammo = new RWBYAmmoItem(
            "emfireammo",
            RWBYItems.entityweissfire,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            32,
            4,
            RWBYCreativeTabs.tab_rwbyitems,
            new FireAmmoHit(10));
    public static final Item emflareammo = new RWBYAmmoItem(
            "emflareammo",
            RWBYItems.entityweisslight,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            32,
            5,
            RWBYCreativeTabs.tab_rwbyitems,
            new ExplosionAmmoHit(0));
    public static final Item crmag = new RWBYAmmoItem(
            "crmag",
            RWBYItems.entitybullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            32,
            15,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item crgravmag = new RWBYAmmoItem(
            "crgravmag",
            RWBYItems.entitybullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:levitation"), 100, 2)),
            32,
            15,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item crfiremag = new RWBYAmmoItem(
            "crfiremag",
            RWBYItems.entitybullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            32,
            15,
            RWBYCreativeTabs.tab_rwbyitems,
            new FireAmmoHit(10));
    public static final Item crelectricmag = new RWBYAmmoItem(
            "crelectricmag",
            RWBYItems.entitybullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:slowness"), 500, 20)),
            32,
            15,
            RWBYCreativeTabs.tab_rwbyitems,
            new ExplosionAmmoHit(0));
    public static final Item hadesmag = new RWBYAmmoItem(
            "hadesmag",
            RWBYItems.entitybullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            16,
            20,
            RWBYCreativeTabs.tab_rwbyitems,
            new ExplosionAmmoHit(0)).setPierce(true);
    public static final Item fetchammo = new RWBYAmmoItem(
            "fetchammo",
            RWBYItems.fetchboomerang,
            1,
            true,
            RWBYAmmoItem.SurviveOnHit.ENTITY,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            30,
            null,
            null);
    public static final Item arslanammo = new RWBYAmmoItem(
            "arslanammo",
            RWBYItems.arslan,
            1,
            true,
            RWBYAmmoItem.SurviveOnHit.ENTITY,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            18,
            null,
            null);
    public static final Item pennyswdammo = new RWBYAmmoItem(
            "pennyswdammo",
            RWBYItems.pennyswd,
            1,
            true,
            RWBYAmmoItem.SurviveOnHit.ENTITY,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            18,
            null,
            null);
    public static final Item carminesaiammo = new RWBYAmmoItem(
            "carminesaiammo",
            RWBYItems.carminesai,
            1,
            true,
            RWBYAmmoItem.SurviveOnHit.ENTITY,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            15,
            null,
            null);
    public static final Item carminestaffammo = new RWBYAmmoItem(
            "carminestaffammo",
            RWBYItems.carminestaff,
            1,
            true,
            RWBYAmmoItem.SurviveOnHit.ENTITY,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            20,
            null,
            null).setPierce(true);
    public static final Item pyrrhaspearvammo = new RWBYAmmoItem(
            "pyrrhaspearvammo",
            RWBYItems.pyrrhaspearv,
            1,
            true,
            RWBYAmmoItem.SurviveOnHit.ENTITY,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            20,
            null,
            null).setPierce(true);
    public static final Item pyrrhaspearammo = new RWBYAmmoItem(
            "pyrrhaspearammo",
            RWBYItems.pyrrhaspear,
            1,
            true,
            RWBYAmmoItem.SurviveOnHit.ENTITY,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            20,
            null,
            null).setPierce(true);
    public static final Item chastifolammo = new RWBYAmmoItem(
            "chastifolammo",
            RWBYItems.chastifol,
            1,
            true,
            RWBYAmmoItem.SurviveOnHit.ENTITY,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            35,
            null,
            null);
    public static final Item chastifolincreaseammo = new RWBYAmmoItem(
            "chastifolincreaseammo",
            RWBYItems.chastifolincrease,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            3,
            null,
            null);
    public static final Item hardlightmagazines = new RWBYAmmoItem(
            "hardlightmagazines",
            RWBYItems.entitybullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            25,
            15,
            null,
            new ExplosionAmmoHit(0)).setPierce(true);
    public static final Item magnammo = new RWBYAmmoItem(
            "magnammo",
            RWBYItems.entitygrenade,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            12,
            15,
            RWBYCreativeTabs.tab_rwbyitems,
            new ExplosionAmmoHit(3));
    public static final Item waterdust = new RWBYAmmoItem(
            "waterdust",
            RWBYItems.entityweisswater,
            64,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            1,
            0,
            RWBYCreativeTabs.tab_rwbyitems,
            new PotionAmmoHit(Items.SPLASH_POTION, ImmutableList.of(new PotionEffect(Potion.getPotionById(22), 100, 2))));
    public static final Item winddust = new RWBYAmmoItem(
            "winddust",
            RWBYItems.entityweisswind,
            64,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            ImmutableList.of(new PotionEffect(MobEffects.SPEED, 400, 2)),
            1,
            0,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item firedust = new RWBYAmmoItem(
            "firedust",
            RWBYItems.entityweissfire,
            64,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            1,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            new FireAmmoHit(10));
    public static final Item icedust = new RWBYAmmoItem(
            "icedust",
            RWBYItems.entityweissice,
            64,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            ImmutableList.of(new PotionEffect(MobEffects.SLOWNESS, 500, 20)),
            1,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item lightdust = new RWBYAmmoItem(
            "lightdust",
            RWBYItems.entityweisslight,
            64,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:slowness"), 400, 2)),
            1,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            new ExplosionAmmoHit(0));
    public static final Item gravitydust = new RWBYAmmoItem(
            "gravitydust",
            RWBYItems.entityweissgravity,
            64,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            1,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            new PotionAmmoHit(Items.LINGERING_POTION, ImmutableList.of(new PotionEffect(Potion.getPotionById(25), 60, 3, false, false))));
    public static final Item jnrammo = new RWBYAmmoItem(
            "jnrammo",
            RWBYItems.entityrocket,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            6,
            15,
            null,
            new ExplosionAmmoHit(1));
    public static final Item extasisammo = new RWBYAmmoItem(
            "extasisammo",
            RWBYItems.entityextasisammo,
            64,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            1,
            30,
            RWBYCreativeTabs.tab_rwbyitems,
            new ExplosionAmmoHit(4));
    public static final Item ammov = new RWBYAmmoItem(
            "ammov",
            RWBYItems.entitybulletv,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            6,
            null,
            null);
    public static final Item sanreiammo = new RWBYAmmoItem(
            "sanreiammo",
            RWBYItems.entitybulletv,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            25,
            null,
            null);
    public static final Item letztammo = new RWBYAmmoItem(
            "letztammo",
            RWBYItems.entitybulletv,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.ENTITY,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            100,
            null,
            new ExplosionAmmoHit(10));

    public static final Item ammmo = new RWBYAmmoItem(
            "ammmo",
            RWBYItems.entitybullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            10,
            null,
            null);
    public static final Item chatmag = new RWBYAmmoItem(
            "chatmag",
            RWBYItems.entitybullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            32,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item chatgravmag = new RWBYAmmoItem(
            "chatgravmag",
            RWBYItems.entitybullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:levitation"), 100, 2)),
            32,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item chatfiremag = new RWBYAmmoItem(
            "chatfiremag",
            RWBYItems.entitybullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            32,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            new FireAmmoHit(10));
    public static final Item chatelectricmag = new RWBYAmmoItem(
            "chatelectricmag",
            RWBYItems.entitybullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:slowness"), 500, 20)),
            32,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            new ExplosionAmmoHit(0));
    public static final Item neptammo = new RWBYAmmoItem(
            "neptammo",
            RWBYItems.entitybullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            32,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            new ExplosionAmmoHit(1));
    public static final Item rzrbolt = new RWBYAmmoItem(
            "rzrbolt",
            RWBYItems.razorboltknife,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            4,
            null,
            null);
    public static final Item gwen = new RWBYAmmoItem(
            "gwen",
            RWBYItems.gwenknife,
            1,
            false,
            null,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            4,
            null,
            new ExplosionAmmoHit(1));
    public static final Item thundergodammo = new RWBYAmmoItem(
            "thundergodammo",
            RWBYItems.entitythundergod,
            1,
            false,
            null,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            10,
            null,
           null);
    public static final Item sawblade = new RWBYAmmoItem(
            "sawblade",
            RWBYItems.saw,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            1,
            4,
            null,
            null);
    public static final Item gravitydustcut = new RWBYAmmoItem(
            "gravitydustcut",
            RWBYItems.gravitydustcrystalcut,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            6,
            0,
            null,
            new ExplosionAmmoHit(2));
    public static final Item winddustcut = new RWBYAmmoItem(
            "winddustcut",
            RWBYItems.winddustcrystalcut,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            6,
            0,
            null,
            new ExplosionAmmoHit(3));
    public static final Item waterdustcut = new RWBYAmmoItem(
            "waterdustcut",
            RWBYItems.waterdustcrystalcut,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            6,
            0,
            null,
            new ExplosionAmmoHit(3));
    public static final Item firedustcut = new RWBYAmmoItem(
            "firedustcut",
            RWBYItems.firedustcrystalcut,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            6,
            0,
            null,
            new ExplosionAmmoHit(3));
    public static final Item dustcut = new RWBYAmmoItem(
            "dustcut",
            RWBYItems.dustcrystalcut,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            6,
            0,
            null,
            new ExplosionAmmoHit(3));
    public static final Item lightdustcut = new RWBYAmmoItem(
            "lightdustcut",
            RWBYItems.lightdustcrystalcut,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            6,
            0,
            null,
            new ExplosionAmmoHit(3));
    public static final Item icedustcut = new RWBYAmmoItem(
            "icedustcut",
            RWBYItems.dustcrystalcut,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            0,
            null,
            6,
            0,
            null,
            new ExplosionAmmoHit(3));
    public static final Item bolt = new RWBYAmmoItem(
            "bolt",
            RWBYItems.entitybolt,
            64,
            true,
            RWBYAmmoItem.SurviveOnHit.ENTITY,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            1,
            15,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item boltgrav = new RWBYAmmoItem(
            "boltgrav",
            RWBYItems.entityboltgrav,
            64,
            true,
            RWBYAmmoItem.SurviveOnHit.ENTITY,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:levitation"), 100, 2)),
            1,
            15,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item boltfire = new RWBYAmmoItem(
            "boltfire",
            RWBYItems.entityboltfire,
            64,
            true,
            RWBYAmmoItem.SurviveOnHit.ENTITY,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            null,
            1,
            15,
            RWBYCreativeTabs.tab_rwbyitems,
            new FireAmmoHit(10));
    public static final Item boltlight = new RWBYAmmoItem(
            "boltlight",
            RWBYItems.entityboltlight,
            64,
            true,
            RWBYAmmoItem.SurviveOnHit.ENTITY,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:slowness"), 500, 20)),
            1,
            15,
            RWBYCreativeTabs.tab_rwbyitems,
            new ExplosionAmmoHit(0));
    public static final Item boltice = new RWBYAmmoItem(
            "boltice",
            RWBYItems.entityboltice,
            64,
            true,
            RWBYAmmoItem.SurviveOnHit.ENTITY,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:slowness"), 100, 5)),
            1,
            15,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item boltwind = new RWBYAmmoItem(
            "boltwind",
            RWBYItems.entityboltwind,
            64,
            true,
            RWBYAmmoItem.SurviveOnHit.ENTITY,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
            ImmutableList.of(new PotionEffect(MobEffects.SPEED, 400, 2)),
            1,
            15,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
    public static final Item nevermorefeather = new RWBYAmmoItem(
            "nevermorefeather",
            RWBYItems.nevermorefeather,
            64,
            false,
            RWBYAmmoItem.SurviveOnHit.BLOCK,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            0,
           null,
            1,
            20,
            null,
            null);
    public static final Item ragorafireball = new RWBYAmmoItem(
    		"ragorafireball",
    		new EntityDragonFireball(null),
    		0,
    		false,
    		null,
            "textures/entity/projectiles/tipped_arrow.png",
    		false,
    		true,
    		0,
    		null,
    		0,
    		0,
    		null,
    		new IAmmoHit() {
				@Override
				public void applyEntity(EntityLivingBase living, EntityLivingBase shooter) {
					if (!living.world.isRemote) {
						float r = RWBYConfig.aura.shadowballsize;
						float f = RWBYConfig.aura.shadowballresolution;
						living.world.playSound(null, living.getPosition(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 3, 1);
						for (float i = Math.round(-r / f) * f; i <= Math.round(r / f) * f; i += f) {
							float radius = (float) Math.sqrt(r*r - i*i);
							createCloud(shooter, radius, living.posX, living.posY + living.height / 2 + i, living.posZ);
						}
					}
				}
				
				@Override
				public void applyBlock(EntityLivingBase shooter, BlockPos pos) {
					if (!shooter.world.isRemote) {
						float r = RWBYConfig.aura.shadowballsize;
						float f = RWBYConfig.aura.shadowballresolution;
						shooter.world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 3, 1);
						for (float i = Math.round(-r / f) * f; i <= Math.round(r / f) * f; i += f) {
							float radius = (float) Math.sqrt(r*r - i*i);
							createCloud(shooter, radius, pos.getX(), pos.getY() + i, pos.getZ());
						}
					}
				}
				
				private void createCloud(EntityLivingBase owner, float r, double x, double y, double z) {
					EntityAreaEffectCloud areaEffectCloud = new EntityAreaEffectCloud(owner.world, x, y, z);
					areaEffectCloud.setRadius(r);
					areaEffectCloud.setRadiusOnUse(0F);
					areaEffectCloud.setWaitTime(0);
					areaEffectCloud.setDuration(20);
					areaEffectCloud.setRadiusPerTick(0F);
					areaEffectCloud.setParticle(EnumParticleTypes.DRAGON_BREATH);
					areaEffectCloud.addEffect(new PotionEffect(RWBYPotions.INSTANT_DAMAGE, 0, 30));
					areaEffectCloud.setOwner(owner);
					owner.world.spawnEntity(areaEffectCloud);
				}
			});


    //Blocks
    public static final Block rwbyblock1 = new RWBYBlock(
            "gravityore",
            Material.ROCK,
            RWBYCreativeTabs.tab_rwbyitems,
            5F,
            0F,
            "pickaxe",
            1);
    public static final Block rwbyblock2 = new RWBYBlock(
            "fireore",
            Material.ROCK,
            RWBYCreativeTabs.tab_rwbyitems,
            5F,
            0F,
            "pickaxe",
            1);
    public static final Block rwbyblock3 = new RWBYBlock(
            "windore",
            Material.ROCK,
            RWBYCreativeTabs.tab_rwbyitems,
            5F,
            0F,
            "pickaxe",
            1);
    public static final Block rwbyblock4 = new RWBYBlock(
            "impureore",
            Material.ROCK,
            RWBYCreativeTabs.tab_rwbyitems,
            5F,
            0F,
            "pickaxe",
            1);
    public static final Block rwbyblock5 = new RWBYBlock(
            "waterore",
            Material.ROCK,
            RWBYCreativeTabs.tab_rwbyitems,
            5F,
            0F,
            "pickaxe",
            1);
    public static final Block rwbyblock6 = new RWBYBlock(
            "lightore",
            Material.ROCK,
            RWBYCreativeTabs.tab_rwbyitems,
            5F,
            0F,
            "pickaxe",
            1);
    public static final Block rwbyblock7 = new RWBYNotFullBlock(
            "smrgrave",
            Material.ROCK,
            RWBYCreativeTabs.tab_rwbyitems,
            5F,
            15F,
            "pickaxe",
            1);
    public static final Block rwbyblock8 = new RWBYToolkit(
            "toolkit",
            Material.ROCK,
            RWBYCreativeTabs.tab_rwbyitems,
            5F,
            15F,
            "null",
            0);
    public static final Block rwbyblock9 = new RWBYBlock(
            "iceore",
            Material.ROCK,
            RWBYCreativeTabs.tab_rwbyitems,
            5F,
            0F,
            "pickaxe",
            1);
    public static final Block fireblock = new RWBYNotFullBlock(
            "fireblock",
            Material.GLASS,
            RWBYCreativeTabs.tab_rwbyitems,
            0F,
            1F,
            "null",
            1);
    public static final Block gravityblock = new RWBYNotFullBlock(
            "gravityblock",
            Material.GLASS,
            RWBYCreativeTabs.tab_rwbyitems,
            0F,
            1F,
            "null",
            1);
    public static final Block iceblock = new RWBYNotFullBlock(
            "iceblock",
            Material.GLASS,
            RWBYCreativeTabs.tab_rwbyitems,
            0F,
            1F,
            "null",
            1);
    public static final Block impureblock = new RWBYNotFullBlock(
            "impureblock",
            Material.GLASS,
            RWBYCreativeTabs.tab_rwbyitems,
            0F,
            1F,
            "null",
            1);
    public static final Block lightblock = new RWBYNotFullBlock(
            "lightblock",
            Material.GLASS,
            RWBYCreativeTabs.tab_rwbyitems,
            0F,
            1F,
            "null",
            1);
    public static final Block waterblock = new RWBYNotFullBlock(
            "waterblock",
            Material.GLASS,
            RWBYCreativeTabs.tab_rwbyitems,
            0F,
            1F,
            "null",
            1);
    public static final Block windblock = new RWBYNotFullBlock(
            "windblock",
            Material.GLASS,
            RWBYCreativeTabs.tab_rwbyitems,
            0F,
            1F,
            "null",
            1);
    public static final Block forestironblock = new RWBYNotFullBlock(
            "forestironblock",
            Material.GLASS,
            RWBYCreativeTabs.tab_rwbyitems,
            0F,
            1F,
            "null",
            1);
    public static final Block frostedironblock = new RWBYNotFullBlock(
            "frostedironblock",
            Material.GLASS,
            RWBYCreativeTabs.tab_rwbyitems,
            0F,
            1F,
            "null",
            1);
    public static final Block gildedironblock = new RWBYNotFullBlock(
            "gildedironblock",
            Material.GLASS,
            RWBYCreativeTabs.tab_rwbyitems,
            0F,
            1F,
            "null",
            1);
    public static final Block roseironblock = new RWBYNotFullBlock(
            "roseironblock",
            Material.GLASS,
            RWBYCreativeTabs.tab_rwbyitems,
            0F,
            1F,
            "null",
            1);
    public static final Block shadowironblock = new RWBYNotFullBlock(
            "shadowironblock",
            Material.GLASS,
            RWBYCreativeTabs.tab_rwbyitems,
            0F,
            1F,
            "null",
            1);
    public static final Block viridianironblock = new RWBYNotFullBlock(
            "viridianironblock",
            Material.GLASS,
            RWBYCreativeTabs.tab_rwbyitems,
            0F,
            1F,
            "null",
            1);
    public static final Block bait = new BlockGrimmBait(
            "bait",
            Material.GLASS,
            RWBYCreativeTabs.tab_rwbyitems,
            2.5F,
            45.0F,
            "null",
            1);
    public static final Block crusher = new RWBYCrusher(
            "crusher");
    public static final Block hrdltfence = new RWBYBlockFence(Material.GLASS, MapColor.CYAN, 2.5F, 45.0F)
    		.setRegistryName(RWBYModels.MODID, "hrdltfence")
    		.setUnlocalizedName("hrdltfence")
    		.setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);
    public static final Block fluidGrimm = new BlockFluidGrimm(RWBYFluids.GRIMM, Material.WATER)
    		.setQuantaPerBlock(5)
    		.setRegistryName(new ResourceLocation(RWBYModels.MODID, "fluidgrimm")).setUnlocalizedName("fluidgrimm");
    
    //Armour

    public static List<Item> ITEMS = new ArrayList();
    public static final ItemArmor.ArmorMaterial korekosmouOffMat;
    public static final ItemArmor.ArmorMaterial korekosmouFireMat;
    public static final ItemArmor.ArmorMaterial korekosmouWaterMat;
    public static final ItemArmor.ArmorMaterial korekosmouWindMat;
    public static final ItemArmor.ArmorMaterial RagoraMat = EnumHelper.addArmorMaterial("Ragora", "rwbym:ragora", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    
    public static final ItemArmor.ArmorMaterial QrowMat = EnumHelper.addArmorMaterial("Qrow", "rwbym:qrow", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor QrowChest = new ArmourBase(QrowMat, 0, EntityEquipmentSlot.CHEST, "qrow_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED1|ArmourBase.GLADIATOR1);
    public static final ItemArmor QrowLegs = new ArmourBase(QrowMat, 0, EntityEquipmentSlot.LEGS, "qrow_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.GLADIATOR1|ArmourBase.ATTACKBOOST2);

    public static final ItemArmor.ArmorMaterial Juane1Mat = EnumHelper.addArmorMaterial("Juane1", "rwbym:juane1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Juane1Chest = new ArmourBase(Juane1Mat, 0, EntityEquipmentSlot.CHEST, "juane1_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.DEFENSE2|ArmourBase.VITALITY1);
    public static final ItemArmor Juane1Legs = new ArmourBase(Juane1Mat, 0, EntityEquipmentSlot.LEGS, "juane1_legs", null,      true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.AURAREGEN|ArmourBase.GLADIATOR1);

    public static final ItemArmor.ArmorMaterial Weiss1Mat = EnumHelper.addArmorMaterial("Weiss1", "rwbym:weiss1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Weiss1Chest = new ArmourBase(Weiss1Mat, 0, EntityEquipmentSlot.CHEST, "weiss1_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.AURAREGEN);
    public static final ItemArmor Weiss1Legs = new ArmourBase(Weiss1Mat, 0, EntityEquipmentSlot.LEGS, "weiss1_legs", null,      true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED1|ArmourBase.JUMPBOOST1);

    public static final ItemArmor.ArmorMaterial AdamMat = EnumHelper.addArmorMaterial("Adam", "rwbym:adam", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor AdamChest = new ArmourBase(AdamMat, 0, EntityEquipmentSlot.CHEST, "adam_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.ATTACKBOOST2|ArmourBase.GLADIATOR1|ArmourBase.RUSH1);
    public static final ItemArmor AdamLegs = new ArmourBase(AdamMat, 0, EntityEquipmentSlot.LEGS, "adam_legs", null,      true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.FOOTING1|ArmourBase.MOVEMENTSPEED2);

    public static final ItemArmor.ArmorMaterial AtlasMat = EnumHelper.addArmorMaterial("Atlas", "rwbym:atlas", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor AtlasChest = new ArmourBase(AtlasMat, 0, EntityEquipmentSlot.CHEST, "atlas_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.DEFENSE1|ArmourBase.ATTACKBOOST1);
    public static final ItemArmor AtlasLegs = new ArmourBase(AtlasMat, 0, EntityEquipmentSlot.LEGS, "atlas_legs", null,      true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.DEFENSE1|ArmourBase.VITALITY1);
    public static final ItemArmor AtlasHead = new ArmourBase(AtlasMat, 0, EntityEquipmentSlot.HEAD, "atlas_head", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.NIGHTVISION);

    public static final ItemArmor.ArmorMaterial BeaconMat = EnumHelper.addArmorMaterial("Beacon", "rwbym:beacon", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor BeaconChest = new ArmourBase(BeaconMat, 0, EntityEquipmentSlot.CHEST, "beacon_chest",  null, true, RWBYCreativeTabs.tab_rwbyarmour, 0);
    public static final ItemArmor BeaconLegs = new ArmourBase(BeaconMat, 0, EntityEquipmentSlot.LEGS, "beacon_legs",    null, true, RWBYCreativeTabs.tab_rwbyarmour, 0);

    public static final ItemArmor.ArmorMaterial Beacon1Mat = EnumHelper.addArmorMaterial("Beacon1", "rwbym:beacon1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Beacon1Chest = new ArmourBase(Beacon1Mat, 0, EntityEquipmentSlot.CHEST, "beacon1_chest",  null, true, RWBYCreativeTabs.tab_rwbyarmour, 0);
    public static final ItemArmor Beacon1Legs = new ArmourBase(Beacon1Mat, 0, EntityEquipmentSlot.LEGS, "beacon1_legs", null,      true, RWBYCreativeTabs.tab_rwbyarmour, 0);

    public static final ItemArmor.ArmorMaterial CarmineMat = EnumHelper.addArmorMaterial("Carmine", "rwbym:carmine", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor CarmineChest = new ArmourBase(CarmineMat, 0, EntityEquipmentSlot.CHEST, "carmine_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.CRITICALSTRIKE1|ArmourBase.ATTACKBOOST1|ArmourBase.RUSH1);
    public static final ItemArmor CarmineLegs = new ArmourBase(CarmineMat, 0, EntityEquipmentSlot.LEGS, "carmine_legs", null,      true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.RUSH1|ArmourBase.ATTACKBOOST1);
    public static final ItemArmor CarmineHead = new ArmourBase(CarmineMat, 0, EntityEquipmentSlot.HEAD, "carmine_head", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.CRITICALSTRIKE1|ArmourBase.ATTACKBOOST1|ArmourBase.RUSH1);

    public static final ItemArmor.ArmorMaterial Blake1Mat = EnumHelper.addArmorMaterial("Blake1", "rwbym:blake1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Blake1Chest = new ArmourBase(Blake1Mat, 0, EntityEquipmentSlot.CHEST, "blake1_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.GLADIATOR2|ArmourBase.ATTACKBOOST2);
    public static final ItemArmor Blake1Legs = new ArmourBase(Blake1Mat, 0, EntityEquipmentSlot.LEGS, "blake1_legs", null,      true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED1|ArmourBase.JUMPBOOST1);

    public static final ItemArmor.ArmorMaterial Blake2Mat = EnumHelper.addArmorMaterial("Blake2", "rwbym:blake2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Blake2Chest = new ArmourBase(Blake2Mat, 0, EntityEquipmentSlot.CHEST, "blake2_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.GLADIATOR1);
    public static final ItemArmor Blake2Legs = new ArmourBase(Blake2Mat, 0, EntityEquipmentSlot.LEGS, "blake2_legs", null,      true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED1);

    public static final ItemArmor.ArmorMaterial Blake3Mat = EnumHelper.addArmorMaterial("Blake3", "rwbym:blake3", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Blake3Chest = new ArmourBase(Blake3Mat, 0, EntityEquipmentSlot.CHEST, "blake3_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.GLADIATOR1|ArmourBase.ATTACKBOOST1);
    public static final ItemArmor Blake3Legs = new ArmourBase(Blake3Mat, 0, EntityEquipmentSlot.LEGS, "blake3_legs", null,      true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.ATTACKBOOST1|ArmourBase.JUMPBOOST2);

    public static final ItemArmor.ArmorMaterial AmberMat = EnumHelper.addArmorMaterial("Amber", "rwbym:amber", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor AmberChest = new ArmourBase(AmberMat, 0, EntityEquipmentSlot.CHEST, "amber_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.AURAREGEN);
    public static final ItemArmor AmberLegs = new ArmourBase(AmberMat, 0, EntityEquipmentSlot.LEGS, "amber_legs", null,      true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED2);

    public static final ItemArmor.ArmorMaterial Cinder1Mat = EnumHelper.addArmorMaterial("Cinder1", "rwbym:cinder1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Cinder1Chest = new ArmourBase(Cinder1Mat, 0, EntityEquipmentSlot.CHEST, "cinder1_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.FIRESTARTER);
    public static final ItemArmor Cinder1Legs = new ArmourBase(Cinder1Mat, 0, EntityEquipmentSlot.LEGS, "cinder1_legs", null,      true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.ATTACKBOOST1);

    public static final ItemArmor.ArmorMaterial Cinder2Mat = EnumHelper.addArmorMaterial("Cinder2", "rwbym:cinder2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Cinder2Chest = new ArmourBase(Cinder2Mat, 0, EntityEquipmentSlot.CHEST, "cinder2_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.GLADIATOR1|ArmourBase.MOVEMENTSPEED1);
    public static final ItemArmor Cinder2Legs = new ArmourBase(Cinder2Mat, 0, EntityEquipmentSlot.LEGS, "cinder2_legs", null,      true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED2);

    public static final ItemArmor.ArmorMaterial Cinder3Mat = EnumHelper.addArmorMaterial("Cinder3", "rwbym:cinder3", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Cinder3Chest = new ArmourBase(Cinder3Mat, 0, EntityEquipmentSlot.CHEST, "cinder3_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.FIRESTARTER|ArmourBase.AURAREGEN|ArmourBase.VITALITY1);
    public static final ItemArmor Cinder3Legs = new ArmourBase(Cinder3Mat, 0, EntityEquipmentSlot.LEGS, "cinder3_legs", null,      true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.AURAREGEN|ArmourBase.ATTACKBOOST2|ArmourBase.VITALITY1);

    public static final ItemArmor.ArmorMaterial CocoMat = EnumHelper.addArmorMaterial("Coco", "rwbym:coco", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor CocoChest = new ArmourBase(CocoMat, 0, EntityEquipmentSlot.CHEST, "coco_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.ATTACKBOOST1|ArmourBase.VITALITY1);
    public static final ItemArmor CocoLegs = new ArmourBase(CocoMat, 0, EntityEquipmentSlot.LEGS, "coco_legs", null,      true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.ATTACKBOOST1|ArmourBase.RUSH1);
    public static final ItemArmor CocoHead = new ArmourBase(CocoMat, 0, EntityEquipmentSlot.HEAD, "coco_head", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.FOOTING1|ArmourBase.HandofBullets);

    public static final ItemArmor.ArmorMaterial romanMat = EnumHelper.addArmorMaterial("roman", "rwbym:roman", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor romanChest = new ArmourBase(romanMat, 0, EntityEquipmentSlot.CHEST, "roman_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.RUSH1);
    public static final ItemArmor romanLegs = new ArmourBase(romanMat, 0, EntityEquipmentSlot.LEGS, "roman_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED1|ArmourBase.K01);
    public static final ItemArmor romanHead = new ArmourBase(romanMat, 0, EntityEquipmentSlot.HEAD, "roman_head", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED1|ArmourBase.RUSH1);

    public static final ItemArmor.ArmorMaterial Emerald1Mat = EnumHelper.addArmorMaterial("Emerald1", "rwbym:emerald1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Emerald1Chest = new ArmourBase(Emerald1Mat, 0, EntityEquipmentSlot.CHEST, "emerald1_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED1);
    public static final ItemArmor Emerald1Legs = new ArmourBase(Emerald1Mat, 0, EntityEquipmentSlot.LEGS, "emerald1_legs", null,      true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED1|ArmourBase.CRITICALSTRIKE1);

    public static final ItemArmor.ArmorMaterial Emerald2Mat = EnumHelper.addArmorMaterial("Emerald2", "rwbym:emerald2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Emerald2Chest = new ArmourBase(Emerald2Mat, 0, EntityEquipmentSlot.CHEST, "emerald2_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, 0);
    public static final ItemArmor Emerald2Legs = new ArmourBase(Emerald2Mat, 0, EntityEquipmentSlot.LEGS, "emerald2_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, 0);

    public static final ItemArmor.ArmorMaterial pennyMat = EnumHelper.addArmorMaterial("penny", "rwbym:penny", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor pennyChest = new ArmourBase(pennyMat, 0, EntityEquipmentSlot.CHEST, "penny_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.VITALITY2|ArmourBase.DEFENSE1);
    public static final ItemArmor pennyLegs = new ArmourBase(pennyMat, 0, EntityEquipmentSlot.LEGS, "penny_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.AURAREGEN|ArmourBase.DEFENSE2|ArmourBase.GLADIATOR2);

    public static final ItemArmor.ArmorMaterial pyrrhaMat = EnumHelper.addArmorMaterial("pyrrha", "rwbym:pyrrha", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor pyrrhaChest = new ArmourBase(pyrrhaMat, 0, EntityEquipmentSlot.CHEST, "pyrrha_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.ATTACKBOOST1|ArmourBase.DEFENSE1|ArmourBase.REACH1);
    public static final ItemArmor pyrrhaLegs = new ArmourBase(pyrrhaMat, 0, EntityEquipmentSlot.LEGS, "pyrrha_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.GLADIATOR1|ArmourBase.JAVELIN1|ArmourBase.JUMPBOOST1);

    public static final ItemArmor.ArmorMaterial ravenMat = EnumHelper.addArmorMaterial("raven", "rwbym:raven", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ravenChest = new ArmourBase(ravenMat, 0, EntityEquipmentSlot.CHEST, "raven_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.ATTACKBOOST2|ArmourBase.AURAREGEN);
    public static final ItemArmor ravenLegs = new ArmourBase(ravenMat, 0, EntityEquipmentSlot.LEGS, "raven_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.RUSH1|ArmourBase.JUMPBOOST1|ArmourBase.MOVEMENTSPEED1);

    public static final ItemArmor.ArmorMaterial ruby1Mat = EnumHelper.addArmorMaterial("ruby1", "rwbym:ruby1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ruby1Chest = new ArmourBase(ruby1Mat, 0, EntityEquipmentSlot.CHEST, "ruby1_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.VITALITY1);
    public static final ItemArmor ruby1Legs = new ArmourBase(ruby1Mat, 0, EntityEquipmentSlot.LEGS, "ruby1_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED2);

    public static final ItemArmor.ArmorMaterial ruby2Mat = EnumHelper.addArmorMaterial("ruby2", "rwbym:ruby2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ruby2Chest = new ArmourBase(ruby2Mat, 0, EntityEquipmentSlot.CHEST, "ruby2_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED1|ArmourBase.VITALITY1);
    public static final ItemArmor ruby2Legs = new ArmourBase(ruby2Mat, 0, EntityEquipmentSlot.LEGS, "ruby2_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED1|ArmourBase.JUMPBOOST1);
    public static final ItemArmor ruby2Head = new ArmourBase(ruby2Mat, 0, EntityEquipmentSlot.HEAD, "ruby2_head", "rwbym:rubyhood", true, null,ArmourBase.MOVEMENTSPEED1|ArmourBase.VITALITY1);
    
    public static final ItemArmor.ArmorMaterial ruby3Mat = EnumHelper.addArmorMaterial("ruby3", "rwbym:ruby3", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ruby3Chest = new ArmourBase(ruby3Mat, 0, EntityEquipmentSlot.CHEST, "ruby3_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED2|ArmourBase.ATTACKBOOST1);
    public static final ItemArmor ruby3Legs = new ArmourBase(ruby3Mat, 0, EntityEquipmentSlot.LEGS, "ruby3_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.RUSH1|ArmourBase.REACH1);

    public static final ItemArmor.ArmorMaterial salemMat = EnumHelper.addArmorMaterial("salem", "rwbym:salem", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor salemChest = new ArmourBase(salemMat, 0, EntityEquipmentSlot.CHEST, "salem_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.VITALITY1);
    public static final ItemArmor salemLegs = new ArmourBase(salemMat, 0, EntityEquipmentSlot.LEGS, "salem_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.VITALITY2);

    public static final ItemArmor.ArmorMaterial velvetMat = EnumHelper.addArmorMaterial("velvet", "rwbym:velvet", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor velvetChest = new ArmourBase(velvetMat, 0, EntityEquipmentSlot.CHEST, "velvet_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.GLADIATOR1|ArmourBase.REACH1);
    public static final ItemArmor velvetLegs = new ArmourBase(velvetMat, 0, EntityEquipmentSlot.LEGS, "velvet_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.PUNCTURE1|ArmourBase.K01|ArmourBase.CRITICALSTRIKE1);

    public static final ItemArmor.ArmorMaterial weiss2Mat = EnumHelper.addArmorMaterial("weiss2", "rwbym:weiss2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor weiss2Chest = new ArmourBase(weiss2Mat, 0, EntityEquipmentSlot.CHEST, "weiss2_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.PUNCTURE1|ArmourBase.FOOTING1);
    public static final ItemArmor weiss2Legs = new ArmourBase(weiss2Mat, 0, EntityEquipmentSlot.LEGS, "weiss2_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.ATTACKBOOST1);

    public static final ItemArmor.ArmorMaterial weiss3Mat = EnumHelper.addArmorMaterial("weiss3", "rwbym:weiss3", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor weiss3Chest = new ArmourBase(weiss3Mat, 0, EntityEquipmentSlot.CHEST, "weiss3_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.PUNCTURE2|ArmourBase.AURAREGEN|ArmourBase.MOVEMENTSPEED1);
    public static final ItemArmor weiss3Legs = new ArmourBase(weiss3Mat, 0, EntityEquipmentSlot.LEGS, "weiss3_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.ATTACKBOOST2);

    public static final ItemArmor.ArmorMaterial winterMat = EnumHelper.addArmorMaterial("winter", "rwbym:winter", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor winterChest = new ArmourBase(winterMat, 0, EntityEquipmentSlot.CHEST, "winter_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.PUNCTURE1|ArmourBase.ATTACKBOOST2);
    public static final ItemArmor winterLegs = new ArmourBase(winterMat, 0, EntityEquipmentSlot.LEGS, "winter_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.PUNCTURE1|ArmourBase.ATTACKBOOST1);

    public static final ItemArmor.ArmorMaterial yang1Mat = EnumHelper.addArmorMaterial("yang1", "rwbym:yang1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor yang1Chest = new ArmourBase(yang1Mat, 0, EntityEquipmentSlot.CHEST, "yang1_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.RUSH1|ArmourBase.K01);
    public static final ItemArmor yang1Legs = new ArmourBase(yang1Mat, 0, EntityEquipmentSlot.LEGS, "yang1_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.K02|ArmourBase.FOOTING1);

    public static final ItemArmor.ArmorMaterial yang2Mat = EnumHelper.addArmorMaterial("yang2", "rwbym:yang2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor yang2Chest = new ArmourBase(yang2Mat, 0, EntityEquipmentSlot.CHEST, "yang2_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.K01|ArmourBase.VITALITY1);
    public static final ItemArmor yang2Legs = new ArmourBase(yang2Mat, 0, EntityEquipmentSlot.LEGS, "yang2_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.FIRESTARTER|ArmourBase.FOOTING1);

    public static final ItemArmor.ArmorMaterial yang3Mat = EnumHelper.addArmorMaterial("yang3", "rwbym:yang3", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor yang3Chest = new ArmourBase(yang3Mat, 0, EntityEquipmentSlot.CHEST, "yang3_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.K01|ArmourBase.ATTACKBOOST1);
    public static final ItemArmor yang3Legs = new ArmourBase(yang3Mat, 0, EntityEquipmentSlot.LEGS, "yang3_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.K01|ArmourBase.ATTACKBOOST1);

    public static final ItemArmor.ArmorMaterial yang4Mat = EnumHelper.addArmorMaterial("yang4", "rwbym:yang4", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor yang4Chest = new ArmourBase(yang4Mat, 0, EntityEquipmentSlot.CHEST, "yang4_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.RUSH1|ArmourBase.K02|ArmourBase.FOOTING1);
    public static final ItemArmor yang4Legs = new ArmourBase(yang4Mat, 0, EntityEquipmentSlot.LEGS, "yang4_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.RUSH1|ArmourBase.K01);

    public static final ItemArmor.ArmorMaterial ironwood1Mat = EnumHelper.addArmorMaterial("ironwood1", "rwbym:ironwood1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ironwood1Chest = new ArmourBase(ironwood1Mat, 0, EntityEquipmentSlot.CHEST, "ironwood1_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.DEFENSE1|ArmourBase.VITALITY1|ArmourBase.ATTACKBOOST1);
    public static final ItemArmor ironwood1Legs = new ArmourBase(ironwood1Mat, 0, EntityEquipmentSlot.LEGS, "ironwood1_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.DEFENSE1|ArmourBase.ATTACKBOOST1);

    public static final ItemArmor.ArmorMaterial ironwood2Mat = EnumHelper.addArmorMaterial("ironwood2", "rwbym:ironwood2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ironwood2Chest = new ArmourBase(ironwood2Mat, 0, EntityEquipmentSlot.CHEST, "ironwood2_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.DEFENSE1|ArmourBase.MOVEMENTSPEED2);
    public static final ItemArmor ironwood2Legs = new ArmourBase(ironwood2Mat, 0, EntityEquipmentSlot.LEGS, "ironwood2_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.HandofBullets|ArmourBase.FOOTING1);

    public static final ItemArmor.ArmorMaterial mercury1Mat = EnumHelper.addArmorMaterial("mercury1", "rwbym:mercury1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor mercury1Chest = new ArmourBase(mercury1Mat, 0, EntityEquipmentSlot.CHEST, "mercury1_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.ATTACKBOOST2|ArmourBase.MOVEMENTSPEED1|ArmourBase.FOOTING1);
    public static final ItemArmor mercury1Legs = new ArmourBase(mercury1Mat, 0, EntityEquipmentSlot.LEGS, "mercury1_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.RUSH1|ArmourBase.MOVEMENTSPEED1|ArmourBase.K02);

    public static final ItemArmor.ArmorMaterial mercury2Mat = EnumHelper.addArmorMaterial("mercury2", "rwbym:mercury2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor mercury2Chest = new ArmourBase(mercury2Mat, 0, EntityEquipmentSlot.CHEST, "mercury2_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED1);
    public static final ItemArmor mercury2Legs = new ArmourBase(mercury2Mat, 0, EntityEquipmentSlot.LEGS, "mercury2_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.RUSH1);

    public static final ItemArmor.ArmorMaterial ozpinMat = EnumHelper.addArmorMaterial("ozpin", "rwbym:ozpin", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ozpinChest = new ArmourBase(ozpinMat, 0, EntityEquipmentSlot.CHEST, "ozpin_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.VITALITY2);
    public static final ItemArmor ozpinLegs = new ArmourBase(ozpinMat, 0, EntityEquipmentSlot.LEGS, "ozpin_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.VITALITY1);

    public static final ItemArmor.ArmorMaterial summer1Mat = EnumHelper.addArmorMaterial("summer1", "rwbym:summer1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor summer1Chest = new ArmourBase(summer1Mat, 0, EntityEquipmentSlot.CHEST, "summer1_chest", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED2|ArmourBase.ATTACKBOOST1);
    public static final ItemArmor summer1Legs = new ArmourBase(summer1Mat, 0, EntityEquipmentSlot.LEGS, "summer1_legs", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.RUSH1|ArmourBase.REACH1);

    public static final ItemArmor.ArmorMaterial summer2Mat = EnumHelper.addArmorMaterial("summer2", "rwbym:summer2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor summer2Chest = new ArmourBase(summer2Mat, 0, EntityEquipmentSlot.CHEST, "summer2_chest", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.DEFENSE1|ArmourBase.ATTACKBOOST2);
    public static final ItemArmor summer2Legs = new ArmourBase(summer2Mat, 0, EntityEquipmentSlot.LEGS, "summer2_legs", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.REACH1|ArmourBase.MOVEMENTSPEED1);
    public static final ItemArmor summer2Head = new ArmourBase(summer2Mat, 0, EntityEquipmentSlot.HEAD, "summer2_head", "rwbym:summerhood", true, null,ArmourBase.MOVEMENTSPEED1|ArmourBase.ATTACKBOOST1);

    public static final ItemArmor.ArmorMaterial neptuneMat = EnumHelper.addArmorMaterial("neptune", "rwbym:neptune", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor neptuneChest = new ArmourBase(neptuneMat, 0, EntityEquipmentSlot.CHEST, "neptune_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.FOOTING2);
    public static final ItemArmor neptuneLegs = new ArmourBase(neptuneMat, 0, EntityEquipmentSlot.LEGS, "neptune_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.REACH1|ArmourBase.VITALITY1);
    public static final ItemArmor neptuneHead = new ArmourBase(neptuneMat, 0, EntityEquipmentSlot.HEAD, "neptune_head", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.REACH1|ArmourBase.MOVEMENTSPEED1);

    public static final ItemArmor.ArmorMaterial scarletMat = EnumHelper.addArmorMaterial("scarlet", "rwbym:scarlet", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor scarletChest = new ArmourBase(scarletMat, 0, EntityEquipmentSlot.CHEST, "scarlet_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED1|ArmourBase.PUNCTURE1);
    public static final ItemArmor scarletLegs = new ArmourBase(scarletMat, 0, EntityEquipmentSlot.LEGS, "scarlet_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.PUNCTURE1|ArmourBase.RUSH1);

    public static final ItemArmor.ArmorMaterial sunMat = EnumHelper.addArmorMaterial("sun", "rwbym:sun", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor sunChest = new ArmourBase(sunMat, 0, EntityEquipmentSlot.CHEST, "sun_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.JUMPBOOST1|ArmourBase.REACH1);
    public static final ItemArmor sunLegs = new ArmourBase(sunMat, 0, EntityEquipmentSlot.LEGS, "sun_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.JUMPBOOST2|ArmourBase.RUSH2);

    public static final ItemArmor.ArmorMaterial sageMat = EnumHelper.addArmorMaterial("sage", "rwbym:sage", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor sageChest = new ArmourBase(sageMat, 0, EntityEquipmentSlot.CHEST, "sage_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.FOOTING1|ArmourBase.ATTACKBOOST1|ArmourBase.VITALITY1);
    public static final ItemArmor sageLegs = new ArmourBase(sageMat, 0, EntityEquipmentSlot.LEGS, "sage_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.ATTACKBOOST1|ArmourBase.FOOTING1);

    public static final ItemArmor.ArmorMaterial taylorMat = EnumHelper.addArmorMaterial("taylor", "rwbym:taylor", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor taylorChest = new ArmourBase(taylorMat, 0, EntityEquipmentSlot.CHEST, "taylor_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.REACH1|ArmourBase.VITALITY1);
    public static final ItemArmor taylorLegs = new ArmourBase(taylorMat, 0, EntityEquipmentSlot.LEGS, "taylor_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.JUMPBOOST1);
    public static final ItemArmor taylorHead = new ArmourBase(taylorMat, 0, EntityEquipmentSlot.HEAD, "taylor_head", "rwbym:taylorhood", true, null, ArmourBase.REACH1|ArmourBase.DEFENSE1);
    public static final Item taylorhood = new RWBYHood("taylorhood",  true,"rwbym:taylor_head", RWBYCreativeTabs.tab_rwbyarmour,  ArmourBase.REACH1|ArmourBase.DEFENSE1);

    public static final ItemArmor.ArmorMaterial baileyMat = EnumHelper.addArmorMaterial("bailey", "rwbym:bailey", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor baileyChest = new ArmourBase(baileyMat, 0, EntityEquipmentSlot.CHEST, "bailey_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.PUNCTURE2|ArmourBase.ATTACKBOOST1);
    public static final ItemArmor baileyLegs = new ArmourBase(baileyMat, 0, EntityEquipmentSlot.LEGS, "bailey_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.FIRESTARTER|ArmourBase.VITALITY1);

    public static final ItemArmor.ArmorMaterial sashaMat = EnumHelper.addArmorMaterial("sasha", "rwbym:sasha", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor sashaChest = new ArmourBase(sashaMat, 0, EntityEquipmentSlot.CHEST, "sasha_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.CRITICALSTRIKE2|ArmourBase.DEFENSE1);
    public static final ItemArmor sashaLegs = new ArmourBase(sashaMat, 0, EntityEquipmentSlot.LEGS, "sasha_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.VITALITY1|ArmourBase.MOVEMENTSPEED1);

    public static final ItemArmor.ArmorMaterial diannaMat = EnumHelper.addArmorMaterial("dianna", "rwbym:dianna", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor diannaChest = new ArmourBase(diannaMat, 0, EntityEquipmentSlot.CHEST, "dianna_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.RUSH1|ArmourBase.MOVEMENTSPEED1);
    public static final ItemArmor diannaLegs = new ArmourBase(diannaMat, 0, EntityEquipmentSlot.LEGS, "dianna_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.ATTACKBOOST1|ArmourBase.GLADIATOR1);

    public static final ItemArmor.ArmorMaterial mariaMat = EnumHelper.addArmorMaterial("maria", "rwbym:maria", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor mariaChest = new ArmourBase(mariaMat, 0, EntityEquipmentSlot.CHEST, "maria_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.ATTACKBOOST3|ArmourBase.MOVEMENTSPEED1);
    public static final ItemArmor mariaLegs = new ArmourBase(mariaMat, 0, EntityEquipmentSlot.LEGS, "maria_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.REACH2);

    public static final ItemArmor.ArmorMaterial henchmanMat = EnumHelper.addArmorMaterial("henchman", "rwbym:henchman", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor henchmanChest = new ArmourBase(henchmanMat, 0, EntityEquipmentSlot.CHEST, "henchman_chest", null, true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.DEFENSE1|ArmourBase.MOVEMENTSPEED1);
    public static final ItemArmor henchmanLegs = new ArmourBase(henchmanMat, 0, EntityEquipmentSlot.LEGS, "henchman_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.FOOTING1);

    public static final Item rvnmask = new RWBYHood("rvnmask",  true, null, RWBYCreativeTabs.tab_rwbyarmour,ArmourBase.AURAREGEN|ArmourBase.ATTACKBOOST1);
    public static final Item mariaeyes = new RWBYHood("mariaeyes",  true, null, RWBYCreativeTabs.tab_rwbyarmour,ArmourBase.NIGHTVISION);
    public static final Item mariamask = new RWBYHood("mariamask",  true, null, RWBYCreativeTabs.tab_rwbyarmour,ArmourBase.ATTACKBOOST1|ArmourBase.REACH1);
    public static final Item ozpinglasses = new RWBYHood("ozpinglasses",  true, null, RWBYCreativeTabs.tab_rwbyarmour,ArmourBase.VITALITY1);
    public static final Item henchmenhat = new RWBYHood("henchmenhat",  true, null, RWBYCreativeTabs.tab_rwbyarmour,ArmourBase.VITALITY1|ArmourBase.RUSH2);
    public static final Item henchmenhatglasses = new RWBYHood("henchmenhatglasses",  true, null, RWBYCreativeTabs.tab_rwbyarmour,ArmourBase.VITALITY1);
    public static final Item whtefng =  new RWBYHood("whtefng",  true, null, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.MOVEMENTSPEED1);
    public static final Item rubyhood = new RWBYHood("rubyhood",  true,"rwbym:ruby2_head", RWBYCreativeTabs.tab_rwbyarmour,ArmourBase.MOVEMENTSPEED1|ArmourBase.VITALITY1);
    public static final Item summerhood = new RWBYHood("summerhood",  true, "rwbym:summer2_head",RWBYCreativeTabs.tab_rwbyarmour,ArmourBase.MOVEMENTSPEED1|ArmourBase.ATTACKBOOST1);

    public static final ItemArmor.ArmorMaterial adamv6Mat = EnumHelper.addArmorMaterial("adamv6", "rwbym:adamv6", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor adamv6Chest = new ArmourBase(adamv6Mat, 0, EntityEquipmentSlot.CHEST, "adamv6_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.ATTACKBOOST2|ArmourBase.RUSH2|ArmourBase.GLADIATOR2);
    public static final ItemArmor adamv6Legs = new ArmourBase(adamv6Mat, 0, EntityEquipmentSlot.LEGS, "adamv6_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.FOOTING1|ArmourBase.MOVEMENTSPEED2);

    public static final ItemArmor.ArmorMaterial neoMat = EnumHelper.addArmorMaterial("neo", "rwbym:neo", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor neoChest = new ArmourBase(neoMat, 0, EntityEquipmentSlot.CHEST, "neo_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.PUNCTURE2|ArmourBase.ATTACKBOOST1);
    public static final ItemArmor neoLegs = new ArmourBase(neoMat, 0, EntityEquipmentSlot.LEGS, "neo_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.DEFENSE1|ArmourBase.VITALITY2);

    public static final ItemArmor.ArmorMaterial oscarv4Mat = EnumHelper.addArmorMaterial("oscarv4", "rwbym:oscarv4", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor oscarv4Chest = new ArmourBase(oscarv4Mat, 0, EntityEquipmentSlot.CHEST, "oscarv4_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.VITALITY1|ArmourBase.PUNCTURE1);
    public static final ItemArmor oscarv4Legs = new ArmourBase(oscarv4Mat, 0, EntityEquipmentSlot.LEGS, "oscarv4_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.AURAREGEN|ArmourBase.RUSH1);

    public static final ItemArmor.ArmorMaterial oscarv6Mat = EnumHelper.addArmorMaterial("oscarv6", "rwbym:oscarv6", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor oscarv6Chest = new ArmourBase(oscarv6Mat, 0, EntityEquipmentSlot.CHEST, "oscarv6_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.PUNCTURE2|ArmourBase.VITALITY2|ArmourBase.MOVEMENTSPEED1);
    public static final ItemArmor oscarv6Legs = new ArmourBase(oscarv6Mat, 0, EntityEquipmentSlot.LEGS, "oscarv6_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.RUSH1|ArmourBase.ATTACKBOOST1);

    public static final ItemArmor.ArmorMaterial ozma1Mat = EnumHelper.addArmorMaterial("ozma1", "rwbym:ozma1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ozma1Chest = new ArmourBase(ozma1Mat, 0, EntityEquipmentSlot.CHEST, "ozma1_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.K01|ArmourBase.VITALITY1);
    public static final ItemArmor ozma1Legs = new ArmourBase(ozma1Mat, 0, EntityEquipmentSlot.LEGS, "ozma1_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.AURAREGEN);

    public static final ItemArmor.ArmorMaterial ozma2Mat = EnumHelper.addArmorMaterial("ozma2", "rwbym:ozma2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ozma2Chest = new ArmourBase(ozma2Mat, 0, EntityEquipmentSlot.CHEST, "ozma2_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.VITALITY1|ArmourBase.AURAREGEN);
    public static final ItemArmor ozma2Legs = new ArmourBase(ozma2Mat, 0, EntityEquipmentSlot.LEGS, "ozma2_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.K01);

    public static final ItemArmor.ArmorMaterial ozma3Mat = EnumHelper.addArmorMaterial("ozma3", "rwbym:ozma3", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ozma3Chest = new ArmourBase(ozma3Mat, 0, EntityEquipmentSlot.CHEST, "ozma3_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.K02|ArmourBase.VITALITY2);
    public static final ItemArmor ozma3Legs = new ArmourBase(ozma3Mat, 0, EntityEquipmentSlot.LEGS, "ozma3_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.RUSH2|ArmourBase.ATTACKBOOST4);

    public static final ItemArmor.ArmorMaterial pennyv7Mat = EnumHelper.addArmorMaterial("pennyv7", "rwbym:pennyv7", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor pennyv7Chest = new ArmourBase(pennyv7Mat, 0, EntityEquipmentSlot.CHEST, "pennyv7_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.DEFENSE2|ArmourBase.VITALITY1|ArmourBase.ATTACKBOOST1);
    public static final ItemArmor pennyv7Legs = new ArmourBase(pennyv7Mat, 0, EntityEquipmentSlot.LEGS, "pennyv7_legs", null,     true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.DEFENSE1|ArmourBase.GLADIATOR2|ArmourBase.AURAREGEN);
    public static final ItemArmor pennyv7Head = new ArmourBase(pennyv7Mat, 0, EntityEquipmentSlot.HEAD, "pennyv7_head", "rwbym:pennyv7hood", true, RWBYCreativeTabs.tab_rwbyarmour, ArmourBase.JAVELIN1|ArmourBase.VITALITY2);

    
    //Charms
    public static final ItemArmor.ArmorMaterial charmMat = EnumHelper.addArmorMaterial("charm", "rwbym:charm", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor kingsgambit = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "kingsgambit", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.KINGSGAMBIT);
    public static final ItemArmor kingsgambitpawn = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "kingsgambitpawn", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.KINGSPAWN);
    public static final ItemArmor firedancercharm = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "firedancercharm", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.FIRESTARTER);
    public static final ItemArmor criticalcharm = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "criticalcharm", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.CRITICALSTRIKE1);
    public static final ItemArmor auracharm = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "auracharm", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.AURAREGEN);
    public static final ItemArmor healthcharm = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "healthcharm", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.VITALITY2);
    public static final ItemArmor reachcharm = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "reachcharm", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.REACH1);
    public static final ItemArmor puncturecharm = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "puncturecharm", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.PUNCTURE1);
    public static final ItemArmor edgecharm = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "edgecharm", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.GLADIATOR1);
    public static final ItemArmor knockoutcharm = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "knockoutcharm", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.K01);
    public static final ItemArmor tankcharm = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "tankcharm", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.DEFENSE2);
    public static final ItemArmor attackcharm = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "attackcharm", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.ATTACKBOOST2);
    public static final ItemArmor feathercharm = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "feathercharm", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.JUMPBOOST2);
    public static final ItemArmor fleetingcharm = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "fleetingcharm", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.MOVEMENTSPEED1);
    public static final ItemArmor rushcharm = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "rushcharm", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.RUSH1);
    public static final ItemArmor fairykingcharm = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "fairyking", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.JAVELIN2);
    public static final ItemArmor relicofknowledge = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "relicofknowledge", null,     true, RWBYCreativeTabs.tab_rwbycharms, 0).setTooltipinfo("Boosted XP Gain");
    //public static final ItemArmor silvercharm = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "silvercharm", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.SILVERLIGHT);
    //public static final ItemArmor maidencharm = new ArmourBase(charmMat, 0, EntityEquipmentSlot.FEET, "maidencharm", null,     true, RWBYCreativeTabs.tab_rwbycharms, ArmourBase.MAIDEN);

    public static final ItemArmor korekosmouoff;
    public static final ItemArmor korekosmoufire;
    public static final ItemArmor korekosmouwater;
    public static final ItemArmor korekosmouwind;
    public static final ItemArmor RagoraHead = new ArmourBase(RagoraMat, 0, EntityEquipmentSlot.HEAD, "ragora_head", null,  true, RWBYCreativeTabs.tab_rwbyarmour,ArmourBase.AURAREGEN);
    public static final ItemArmor RagoraChest = new ArmourBase(RagoraMat, 0, EntityEquipmentSlot.CHEST, "ragora_chest", null,  true, RWBYCreativeTabs.tab_rwbyarmour,ArmourBase.JUMPBOOST1|ArmourBase.REACH1);
    public static final ItemArmor RagoraLegs = new ArmourBase(RagoraMat, 0, EntityEquipmentSlot.LEGS, "ragora_legs", null,      true, RWBYCreativeTabs.tab_rwbyarmour,ArmourBase.AURAREGEN);

    static {
        korekosmouOffMat = EnumHelper.addArmorMaterial("Kore Kosmou", "rwbym:korekosmou", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
        korekosmouFireMat = EnumHelper.addArmorMaterial("Kore Kosmou Fire", "rwbym:korekosmoufire", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
        korekosmouWaterMat = EnumHelper.addArmorMaterial("Kore Kosmou Water", "rwbym:korekosmouwater", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
        korekosmouWindMat = EnumHelper.addArmorMaterial("Kore Kosmou Wind", "rwbym:korekosmouwind", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
        korekosmouoff = new ArmourBase(korekosmouOffMat, 0, EntityEquipmentSlot.CHEST, "korekosmouoff","rwbym:korekosmoufire",  false, RWBYCreativeTabs.tab_rwbyweapons,0);
        korekosmoufire = new ArmourBase(korekosmouFireMat, 0, EntityEquipmentSlot.CHEST, "korekosmoufire","rwbym:korekosmouice", false, null,0);
        korekosmouwater = new ArmourBase(korekosmouWaterMat, 0, EntityEquipmentSlot.CHEST, "korekosmouice","rwbym:korekosmouwind",  false, null,0);
        korekosmouwind = new ArmourBase(korekosmouWindMat, 0, EntityEquipmentSlot.CHEST, "korekosmouwind","rwbym:korekosmouoff",  false, null,0);
    }

}
