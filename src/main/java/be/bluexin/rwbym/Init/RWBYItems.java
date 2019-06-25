package be.bluexin.rwbym.Init;

import be.bluexin.rwbym.blocks.*;
import be.bluexin.rwbym.gui.RWBYItemContainerGui;
import be.bluexin.rwbym.gui.RWBYItemContainerGuiChest;
import be.bluexin.rwbym.inventory.RWBYItemContainer;
import be.bluexin.rwbym.inventory.RWBYItemContainerChest;
import be.bluexin.rwbym.utility.RWBYConfig;
import be.bluexin.rwbym.weaponry.*;
import be.bluexin.rwbym.weaponry.ammohit.ExplosionAmmoHit;
import be.bluexin.rwbym.weaponry.ammohit.FireAmmoHit;
import be.bluexin.rwbym.weaponry.ammohit.IAmmoHit;
import be.bluexin.rwbym.weaponry.ammohit.PotionAmmoHit;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityDragonFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemSplashPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import scala.tools.nsc.doc.model.Public;

public class RWBYItems {
    public static final Item icon = new RWBYSword(
            "icon",
            0,
            0,
            0,
            null,
            null,
            false,
            false,
            false,
            false,
            0,
            null);
    public static final Item crescent = new RWBYGun(
            "crescent",
            2500,
            72,
            2,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:571090,UUIDMost:892303,Slot:\"mainhand\"}]}",
            "rwbym:crescentgun",
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            1,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item crescentfrost = new RWBYGun(
            "crescentfrost",
            2500,
            72,
            2,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:571090,UUIDMost:892303,Slot:\"mainhand\"}]}",
            "rwbym:crescentgunfrost",
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            1,
           null);
    public static final Item gambol = new RWBYSword(
            "gambol",
            2500,
            10,
            0,
            null,
            "rwbym:gambolgun",
            true,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item rvnswd = new RWBYSword(
            "rvnswd",
            2500,
            10,
            0,
            null,
            "rwbym:rvnswdele",
            true,
            false,
            true,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item rvnswdele = new RWBYSword(
            "rvnswdele",
            2500,
            10,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.movementSpeed\",Name:\"generic.movementSpeed\",Amount:0.2,Operation:0,UUIDLeast:763623,UUIDMost:811709,Slot:\"mainhand\"},{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:9,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:rvnswdice",
            true,
            false,
            false,
            false,
            0,
            null);
    public static final Item rvnswdice = new RWBYSword(
            "rvnswdice",
            2500,
            10,
            0,
            null,
            "rwbym:rvnswd",
            true,
            false,
            false,
            true,
            0,
            null);
    public static final Item qrow = new RWBYGun(
            "qrow",
            2500,
            15,
            2,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:571090,UUIDMost:892303,Slot:\"mainhand\"}]}",
            "rwbym:qrowgun",
            "rwbym:ammmmo,rwbym:ammmmmmo",
            false,
            1,
            false,
            false,
            0,
            0,
            0,
            0,
            null);
    public static final Item qrowsword = new RWBYSword(
            "qrowsword",
            2500,
            10,
            0,
            null,
            "rwbym:qrow",
            false,
            true,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item juane = new RWBYSword("juane",
            2500,
            10,
            0,
            null,
            "rwbym:juaneshieldaxe",
            true,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item juaneshieldaxe = new RWBYSword("juaneshieldaxe",
            2500,
            10,
            0,
            null,
            "rwbym:juane",
            false,
            true,
            false,
            false,
            0,
            null);
    public static final Item norahammer = new RWBYSword(
            "norahammer",
            2500,
            12,
            0,
            "{ench:[{id:19,lvl:2}]}",
            "rwbym:noragun",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item pyrrhaspear = new RWBYSword(
            "pyrrhaspear",
            2500,
            10,
            0,
            null,
            "rwbym:pyrrharifle",
            true,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item pyrrhasword = new RWBYSword(
            "pyrrhasword",
            2500,
            10,
            0,
            null,
            "rwbym:pyrrhaspear",
            true,
            false,
            false,
            false,
            0,
            null);
    public static final Item velvet = new RWBYSword(
            "velvet",
            1250,
            -4,
            0,
            null,
            "rwbym:crescentv",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item oobleckthermos = new RWBYSword(
            "oobleckthermos",
            2500,
            -4,
            0,
            null,
            "rwbym:oobleckflamethrower",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item crescentv = new RWBYGun(
            "crescentv",
            1250,
            72,
            2,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:531774,UUIDMost:709040,Slot:\"mainhand\"},{AttributeName:\"generic.attackSpeed\",Name:\"generic.attackSpeed\",Amount:3,Operation:0,UUIDLeast:811643,UUIDMost:138699}]}",
            "rwbym:crescentgunv",
            "rwbym:ammov",
            false,
            1,
            false,
            false,
            1,
            1,
            1,
            1,
            null);
    public static final Item weissv = new RWBYGun(
            "weissv",
            1250,
            72,
            1,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:10,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:gambolv",
            "rwbym:ammmmo",
            false,
            1,
            false,
            false,
            0,
            1,
            1,
            4,
            null);
    public static final Item gambolv = new RWBYSword(
            "gambolv",
            1250,
            10,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:gambolgunv",
            true,
            false,
            false,
            false,
            1,
            null);
    public static final Item juanev = new RWBYSword(
            "juanev",
            1250,
            10,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:norahammerv",
            false,
            false,
            false,
            false,
            1,
            null);
    public static final Item norahammerv = new RWBYSword(
            "norahammerv",
            1250,
            12,
            0,
            "{ench:[{id:19,lvl:2}],HideFlags:3}",
            "rwbym:noragunv",
            false,
            false,
            false,
            false,
            1,
            null);
    public static final Item pyrrhaspearv = new RWBYSword(
            "pyrrhaspearv",
            1250,
            10,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:pyrrhaswordv",
            true,
            false,
            false,
            false,
            1,
            null);
    public static final Item pyrrhaswordv = new RWBYSword(
            "pyrrhaswordv",
            1250,
            10,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:stormflowerv",
            true,
            false,
            false,
            false,
            1,
            null);
    public static final Item yatsuhashi = new RWBYSword(
            "yatsuhashi",
            2500,
            15,
            15,
            null,
            null,
            false,
            true,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item cocobag = new RWBYSword(
            "cocobag",
            1250,
            10,
            15,
            null,
            "rwbym:cocogun",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item fox = new RWBYGun(
            "fox",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            null,
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            true,
            1,
            false,
            false,
            0,
            1,
            0,
            5,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item cocobagv = new RWBYSword(
            "cocobagv",
            1250,
            10,
            15,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:cocogunv",
            false,
            false,
            false,
            false,
            1,
            null);
    public static final Item winterswd = new RWBYGun(
            "winterswd",
            2500,
            7200000,
            7,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            null,
            "rwbym:nuller,rwbym:nullest",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item pennyswd = new RWBYSword(
            "pennyswd",
            2500,
            9,
            0,
            null,
            null,
            false,
            true,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item ozpincane = new RWBYSword(
            "ozpincane",
            2500,
            10,
            0,
            null,
            null,
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item port = new RWBYSword(
            "port",
            2500,
            12,
            0,
            null,
            "rwbym:portgun",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item kkfire = new RWBYSword(
            "kkfire",
            640,
            15,
            0,
            null,
            null,
            false,
            true,
            true,
            false,
            0,
            null);
    public static final Item kkice = new RWBYSword(
            "kkice",
            640,
            10,
            0,
            null,
            null,
            true,
            false,
            false,
            true,
            0,
            null);
    public static final Item kkwind = new RWBYSword(
            "kkwind",
            640,
            8,
            0,
            "{ench:[{id:19,lvl:4}]}",
            null,
            false,
            false,
            false,
            false,
            0,
            null);
    public static final Item torchwick = new RWBYSword(
            "torchwick",
            2500,
            10,
            0,
            null,
            "rwbym:torchwickgun",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item neoumb_closed = new RWBYSword(
            "neoumb_closed",
            2500,
            9,
            0,
            null,
            "rwbym:neoumb_closed_blade",
            false,
            true,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item neoumb_closed_blade = new RWBYSword(
            "neoumb_closed_blade",
            2500,
            9,
            0,
            null,
            "rwbym:neoumb_handle_blade",
            false,
            true,
            false,
            false,
            0,
           null);
    public static final Item neoumb_handle_blade = new RWBYSword(
            "neoumb_handle_blade",
            2500,
            10,
            0,
            null,
            "rwbym:neoumb_closed",
            false,
            false,
            false,
            false,
            0,
            null);
    public static final Item jnrbat = new RWBYSword(
            "jnrbat",
            2500,
            11,
            0,
            null,
            "rwbym:jnrrocket",
            false,
            true,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item adamswd = new RWBYSword(
            "adamswd",
            2500,
            9,
            0,
            null,
            "rwbym:adamgun",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item cinder = new RWBYSword(
            "cinder",
            2500,
            10,
            0,
            null,
            "rwbym:cinderbow",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);

    public static final Item ozmacane = new RWBYStaff(
            "ozmacane",
            2500,
            12,
            0,
            null,
            null,
            false,
            true,
            RWBYCreativeTabs.tab_rwbyweapons
    );
    public static final Item ozmacanefire = new RWBYStaff(
            "ozmacanefire",
            2500,
            12,
            0,
            null,
            null,
            false,
            true,
          null
    );
    public static final Item ozmacanegravity = new RWBYStaff(
            "ozmacanegravity",
            2500,
            12,
            0,
            null,
            null,
            false,
            true,
            null
    );    public static final Item ozmacaneice = new RWBYStaff(
            "ozmacaneice",
            2500,
            12,
            0,
            null,
            null,
            false,
            true,
           null
    );    public static final Item ozmacanelightning = new RWBYStaff(
            "ozmacanelightning",
            2500,
            12,
            0,
            null,
            null,
            false,
            true,
           null
    );    public static final Item ozmacanewater = new RWBYStaff(
            "ozmacanewater",
            2500,
            12,
            0,
            null,
            null,
            false,
            true,
            null
    );    public static final Item ozmacanewind = new RWBYStaff(
            "ozmacanewind",
            2500,
            12,
            0,
            null,
            null,
            false,
            true,
            null
    );
    public static final Item mariacane = new RWBYSword(
            "mariacane",
            2500,
            12,
            0,
            null,
            "rwbym:mariascythe",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item mariascythe = new RWBYGun(
            "mariascythe",
            2500,
            72,
            2,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:571090,UUIDMost:892303,Slot:\"mainhand\"}]}",
            "rwbym:mariascythedouble",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            1,
            false,
            false,
            4,
            1,
            0,
            3,
            null);
    public static final Item angelcane = new RWBYSword(
            "angelcane",
            2500,
            10,
            0,
            null,
            "rwbym:angelsword",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item angelsword = new RWBYGun(
            "angelsword",
            2500,
            72,
            1,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:571090,UUIDMost:892303,Slot:\"mainhand\"}]}",
            "rwbym:angelcane",
            "none",
            false,
            1,
            true,
            false,
            0,
            0,
            0,
            0,
            null);
    public static final Item mariascythedouble = new RWBYSword(
            "mariascythedouble",
            2500,
            14,
            0,
            null,
            "rwbym:mariacane",
            false,
            true,
            false,
            false,
            0,
            null);
    public static final Item chatareus = new RWBYGun(
            "chatareus",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:571090,UUIDMost:892303,Slot:\"mainhand\"}]}",
            "rwbym:chatareusgun",
            "rwbym:chatmag,rwbym:chatfiremag,rwbym:chatgravmag,rwbym:chatelectricmag",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            12,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item chatareusgun = new RWBYGun(
            "chatareusgun",
            2500,
            7200,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:571090,UUIDMost:892303,Slot:\"mainhand\"}]}",
            "rwbym:chatareus",
            "rwbym:chatmag,rwbym:chatfiremag,rwbym:chatgravmag,rwbym:chatelectricmag",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            12,
            null);

    public static final Item armasword = new RWBYSword(
            "armasword",
            2500,
            15,
            15,
            null,
            null,
            false,
            true,
            false,
            false,
            0,
            null);

    public static final Item armaswordsummon = new RWBYSword(
            "armaswordsummon",
            2500,
            15,
            15,
            null,
            null,
            false,
            true,
            false,
            false,
            0,
            null);
    public static final Item razorbolt = new RWBYSword(
            "razorbolt",
            2500,
            12,
            0,
            null,
            "rwbym:razorboltknife",
            true,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item razorboltknife = new RWBYGun(
            "razorboltknife",
            2500,
            72,
            0,
            null,
            "rwbym:razorbolt",
            "rwbym:rzrbolt",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            17,
            null);
    public static final Item reese = new KineticWeapons(
            "reese",
            2500,
            -4,
            0,
            null,
            "rwbym:reesegun",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);

    public static final Item reesegun = new RWBYGun(
            "reesegun",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:reese",
            "rwbym:spl,rwbym:splfire,rwbym:splgrav,rwbym:splice,rwbym:spllight",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            14,
            null);
    public static final Item bolin = new RWBYSword(
            "bolin",
            2500,
            12,
            0,
            null,
            "rwbym:bolinblade",
            false,
            true,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item bolinblade = new RWBYSword(
            "bolinblade",
            2500,
            13,
            0,
            null,
            "rwbym:bolin",
            false,
            true,
            false,
            false,
            0,
            null);

    public static final Item lysettesword = new RWBYSword(
            "lysettesword",
            2500,
            0,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            null,
            true,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);



    //------------------------------------------------//

    public static final Item crescentgun = new RWBYGun(
            "crescentgun",
            2500,
            72,
            0,
            null,
            "rwbym:crescent",
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            1,
            false,
            false,
            1,
            1,
            0,
            1,
            null);
    public static final Item crescentgunfrost = new RWBYGun(
            "crescentgunfrost",
            2500,
            72,
            0,
            null,
            "rwbym:crescentfrost",
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            1,
            false,
            false,
            1,
            1,
            0,
            1,
            null);
    public static final Item weiss = new RWBYGun(
            "weiss",
            2500,
            72,
            1,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            null,
            "rwbym:gravitydust,rwbym:winddust,rwbym:icedust,rwbym:waterdust,rwbym:firedust,rwbym:lightdust",
            false,
            1,
            false,
            false,
            3,
            1,
            0,
            4,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item crescentgunv = new RWBYGun(
            "crescentgunv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:emberv",
            "rwbym:ammov",
            false,
            1,
            false,
            false,
            1,
            1,
            1,
            1,
            null);
    public static final Item ember = new RWBYGun(
            "ember",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:ember2",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            false,
            false,
            0,
            4,
            0,
            2,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item ember2 = new RWBYGun(
            "ember2",
            2500,
            72,
            6,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:ember",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            false,
            false,
            0,
            4,
            0,
            2,
            null);
    public static final Item gambolgun = new RWBYGun(
            "gambolgun",
            2500,
            72,
            3,
            null,
            "rwbym:gambol",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            3,
            null);
    public static final Item gambolgunv = new RWBYGun(
            "gambolgunv",
            1250,
            72,
            3,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:juanev",
            "rwbym:ammov",
            false,
            1,
            true,
            false,
            0,
            1,
            1,
            3,
            null);
    public static final Item stormflower = new RWBYGun(
            "stormflower",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            null,
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            true,
            1,
            false,
            false,
            4,
            1,
            0,
            5,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item noragun = new RWBYGun(
            "noragun",
            2500,
            72,
            0,
            null,
            "rwbym:norahammer",
            "rwbym:magnammo,rwbym:magnaampammo",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            6,
            null);
    public static final Item stormflowerv = new RWBYGun(
            "stormflowerv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3,AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:cocobagv",
            "rwbym:ammov",
            true,
            1,
            false,
            false,
            4,
            1,
            1,
            5,
            null);
    public static final Item noragunv = new RWBYGun(
            "noragunv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:pyrrhaspearv",
            "rwbym:ammov",
            false,
            1,
            false,
            false,
            0,
            1,
            1,
            6,
            null);
    public static final Item emberv = new RWBYGun(
            "emberv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3,AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:10,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:weissv",
            "rwbym:ammov",
            false,
            1,
            false,
            false,
            0,
            4,
            1,
            2,
            null);
    public static final Item qrowgun = new RWBYGun(
            "qrowgun",
            2500,
            72,
            0,
            null,
            "rwbym:qrowsword",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            false,
            false,
            0,
            4,
            0,
            2,
            null);
    public static final Item cocogun = new RWBYGun(
            "cocogun",
            1250,
            72,
            0,
            null,
            "rwbym:cocobag",
            "rwbym:ammmo",
            true,
            1,
            false,
            false,
            0,
            1,
            0,
            7,
            null);
    public static final Item cocogunv = new RWBYGun(
            "cocogunv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:velvet",
            "rwbym:ammmo",
            true,
            1,
            false,
            false,
            0,
            1,
            1,
            7,
            null);

    public static final Item torchwickgun = new RWBYGun(
            "torchwickgun",
            2500,
            72,
            0,
            null,
            "rwbym:torchwick",
            "rwbym:emammmo,rwbym:emflareammo",
            false,
            0.8F,
            false,
            false,
            0,
            1,
            0,
            11,
            null);
    public static final Item portgun = new RWBYGun(
            "portgun",
            2500,
            72,
            0,
            null,
            "rwbym:port",
            "rwbym:emammo,rwbym:emammmo",
            false,
            0.8F,
            false,
            false,
            0,
            4,
            0,
            8,
            null);
    public static final Item emeraldgun = new RWBYGun(
            "emeraldgun",
            2500,
            72,
            0,
            null,
            "rwbym:emeraldblade",
            "rwbym:spl,rwbym:splfire,rwbym:splgrav,rwbym:splice,rwbym:spllight",
            false,
            1,
            false,
            false,
            4,
            1,
            0,
            5,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item emeraldblade = new RWBYGun(
            "emeraldblade",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:emeraldgun",
            "rwbym:spl,rwbym:splfire,rwbym:splgrav,rwbym:splice,rwbym:spllight",
            false,
            1,
            false,
            false,
            4,
            1,
            0,
            5,
            null);
    public static final Item jnrrocket = new RWBYGun(
            "jnrrocket",
            2500,
            72,
            5,
            null,
            "rwbym:jnrbat",
            "rwbym:jnrammo",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            10,
            null);
    public static final Item cinderbow = new RWBYGun(
            "cinderbow",
            2500,
            72,
            0,
            null,
            "rwbym:cinder",
            "minecraft:arrow,minecraft:tipped_arrow",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            16,
            null);
    public static final Item adamgun = new RWBYGun(
            "adamgun",
            2500,
            72,
            0,
            null,
            "rwbym:adamswd",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            false,
            false,
            0,
            3,
            0,
            2,
            null);
    public  static  final Item sunstaff = new RWBYSword("sunstaff",
            2500,
            12.0F,
            0,
            null,
            "rwbym:sunnunchuck",
            false,
            true,
            false,
            false,
            0,
            null);
    public  static  final  Item sunnunchuck = new RWBYGun(
            "sunnunchuck",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:sunstaff", "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            false,
            false,
            0,
            4,
            0,
            8,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item neptunegun = new RWBYGun(
            "neptunegun",
            2500,
            72,
            0,
            null,
            "rwbym:neptunespear",
            "rwbym:neptammo,rwbym:magnaampammo",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            13,
            RWBYCreativeTabs.tab_rwbyweapons);
    public  static  final Item neptunespear = new RWBYSword(
            "neptunespear",
            2500,
            11.0F,
            0,
            null,
            "rwbym:neptunetrident",
            false,
            true,
            false,
            true,
            0,
            null);
    public  static  final Item neptunetrident = new RWBYSword(
            "neptunetrident",
            2500,
            12.0F,
            0,
            null,
            "rwbym:neptunegun",
            false,
            true,
            false,
            false,
            0,
            null);
    public static final Item sage = new RWBYSword(
            "sage",
            2500,
            15,
            15,
            null,
            null,
            false,
            true,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item arslan = new RWBYSword(
            "arslan",
            2500,
            9,
            15,
            "{AttributeModifiers:[{AttributeName:\"generic.attackSpeed\",Name:\"generic.attackSpeed\",Slot:\"mainhand\",Amount:2,Operation:2,UUIDMost:32938,UUIDLeast:158913},{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:13,Operation:0,UUIDMost:89852,UUIDLeast:169112}]}",
            null,
            false,
            true,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item scarletsword = new RWBYGun(
            "scarletsword",
            2500,
            72,
            4,
            null,
            null,
            "rwbym:spl,rwbym:splfire,rwbym:splgrav,rwbym:splice,rwbym:spllight",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            8,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item nadirgun = new RWBYGun(
            "nadirgun",
            2500,
            72,
            0,
            null,
            "rwbym:nadirsword",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            true,
            1,
            false,
            false,
            0,
            1,
            0,
            14,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item nadirsword = new RWBYSword(
            "nadirsword",
            2500,
            10,
            0,
            null,
            "rwbym:nadirgun",
            false,
            false,
            false,
            false,
            0,
           null);
    public  static  final  Item hexen = new RWBYGun(
            "hexen",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:hexenaxe",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            true,
            0.8F,
            false,
            false,
            0,
            4,
            0,
            2,
            RWBYCreativeTabs.tab_rwbyweapons);
    public  static  final  Item hexenaxe = new RWBYGun(
            "hexenaxe",
            2500,
            72,
            2,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:18,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:hexen",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            false,
            false,
            0,
            4,
            0,
            2,
            null);
    public static final Item magnumgun = new RWBYGun(
            "magnumgun",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:12,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:magnumsword",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            true,
            1,
            false,
            false,
            0,
            1,
            0,
            3,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item magnumsword = new RWBYGun(
            "magnumsword",
            2500,
            72,
            2,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:16,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:magnumgun",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            1,
            false,
            false,
            2,
            1,
            0,
            3,
            null);
    public static final Item pyrrharifle = new RWBYGun(
            "pyrrharifle",
            2500,
            72,
            0,
            null,
            "rwbym:pyrrhasword",
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            1,
            true,
            false,
            0,
            1,
            0,
            8,
            null);
    public static final Item ironwood = new RWBYGun(
            "ironwood",
            2500,
            72,
            0,
            null,
            null,
            "rwbym:spl,rwbym:splfire,rwbym:splgrav,rwbym:splice,rwbym:spllight",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            3,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item goodwitch = new RWBYGun(
            "goodwitch",
            2500,
            72,
            0,
            "{ench:[{id:19,lvl:5}],AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:16,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            null,
            "rwbym:firedust,rwbym:lightdust",
            false,
            1,
            false,
            false,
            0,
            2,
            0,
            4,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item oobleckflamethrower = new RWBYGun(
            "oobleckflamethrower",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:13,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:oobleckthermos",
            "rwbym:firedust,rwbym:firedust2",
            true,
            1,
            false,
            false,
            0,
            3,
            0,
            15,
            null);
    public static final Item cardin = new RWBYGun(
            "cardin",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            null,
            "rwbym:firedust,rwbym:firedust2",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            4,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item nebulabow = new RWBYGun(
            "nebulabow",
            2500,
            72,
            0,
            null,
            "rwbym:nebulasword",
            "minecraft:arrow,minecraft:tipped_arrow",
            false,
            2,
            false,
            false,
            0,
            1,
            0,
            16,
            null);
    public static final Item nebulasword = new RWBYSword(
            "nebulasword",
            2500,
            10,
            0,
            null,
            "rwbym:nebulabow",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);

    public static final Item lieutenant = new RWBYTool(
            "lieutenant",
            2500,
            10,
            0,
            null,
            null,
            false,
            true,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);

    public static final  Item gravitydustcrystalcut = new RWBYCutGem(
            "gravitydustcrystalcut",
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.7,Operation:2,UUIDMost:25912,UUIDLeast:178428}],display:{Lore:[\"Slow Falling and Negate Fall Damage While in offhand and Float Upwards while sneaking in mid-air.\"]}}",
            "rwbym:gravitydustcut",
            true,
            0.3F,
            RWBYCreativeTabs.tab_rwbyitems);
    public static final  Item winddustcrystalcut = new RWBYCutGem(
            "winddustcrystalcut",
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.7,Operation:2,UUIDMost:29285,UUIDLeast:106582},{AttributeName:\"generic.movementSpeed\",Name:\"generic.movementSpeed\",Slot:\"offhand\",Amount:2,Operation:2.5,UUIDMost:72089,UUIDLeast:146615}]}",
            "rwbym:winddustcut",
            true,
            0.3F,
            RWBYCreativeTabs.tab_rwbyitems);
    public static final  Item waterdustcrystalcut = new RWBYCutGem(
            "waterdustcrystalcut",
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"offhand\",Amount:-0.45,Operation:2,UUIDMost:81281,UUIDLeast:160467}],display:{Lore:[\"Provides Faster Health Regeneration while in Offhand and Water Breathing While Underwater.\"]}}",
            "rwbym:waterdustcut",
            true,
            0.3F,
            RWBYCreativeTabs.tab_rwbyitems);
    public static final  Item firedustcrystalcut = new RWBYCutGem(
            "firedustcrystalcut",
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.7,Operation:2,UUIDMost:25912,UUIDLeast:178428},{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"offhand\",Amount:3.5,Operation:2,UUIDMost:87232,UUIDLeast:139412}]}",
            "rwbym:firedustcut",
            true,
            0.3F,
            RWBYCreativeTabs.tab_rwbyitems);
    public static final  Item dustcrystalcut = new RWBYCutGem(
            "dustcrystalcut",
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.70,Operation:2,UUIDMost:74685,UUIDLeast:155127}]}",
            "rwbym:dustcut",
            true,
            0.3F,
            RWBYCreativeTabs.tab_rwbyitems);
    public static final  Item lightdustcrystalcut = new RWBYCutGem(
            "lightdustcrystalcut",
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.70,Operation:2,UUIDMost:17934,UUIDLeast:125321},{AttributeName:\"generic.movementSpeed\",Name:\"generic.movementSpeed\",Slot:\"offhand\",Amount:1.5,Operation:2,UUIDMost:13043,UUIDLeast:147969},{AttributeName:\"generic.attackSpeed\",Name:\"generic.attackSpeed\",Slot:\"offhand\",Amount:3,Operation:2,UUIDMost:14080,UUIDLeast:163727}]}",
            "rwbym:lightdustcut",
            true,
            0.3F,
            RWBYCreativeTabs.tab_rwbyitems);
    public static final  Item icedustcrystalcut = new RWBYCutGem(
            "icedustcrystalcut",
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.movementSpeed\",Name:\"generic.movementSpeed\",Slot:\"offhand\",Amount:-0.5,Operation:2,UUIDMost:79372,UUIDLeast:112384},{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:1.5,Operation:2,UUIDMost:25912,UUIDLeast:178428}]}",
            "rwbym:icedustcut",
            true,
            0.3F,
            RWBYCreativeTabs.tab_rwbyitems);

    public static final Item atlaspistol = new RWBYGun(
            "atlaspistol",
            2500,
            72,
            0,
            null,
            null,
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            9,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item atlasrifle = new RWBYGun(
            "atlasrifle",
            2500,
            72,
            0,
            null,
            null,
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            1,
            false,
            false,
            0,
            1,
            0,
            8,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item vernal = new RWBYGun(
            "vernal",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:15,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            null,
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            0.8F,
            true,
            false,
            0,
            2,
            0,
            8,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item dove = new RWBYGun(
            "dove",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:15,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            null,
            "rwbym:spl,rwbym:splfire,rwbym:splgrav,rwbym:splice,rwbym:spllight",
            false,
            2,
            false,
            false,
            0,
            2,
            0,
            3,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item tyrian = new RWBYGun(
            "tyrian",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:15,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            null,
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            true,
            1,
            false,
            false,
            0,
            2,
            0,
            5,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item russelnormal = new RWBYSword(
            "russelnormal",
            2500,
            10,
            0,
            null,
            "rwbym:russelfire",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item russelfire = new RWBYSword(
            "russelfire",
            2500,
            10,
            0,
            null,
            "rwbym:russelice",
            false,
            false,
            false,
            false,
            0,
            null);
    public static final Item russelice = new RWBYSword(
            "russelice",
            2500,
            10,
            0,
            null,
            "rwbym:russelwind",
            false,
            false,
            false,
            false,
            0,
            null);
    public static final Item russelwind = new RWBYSword(
            "russelwind",
            2500,
            10,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.movementSpeed\",Name:\"generic.movementSpeed\",Amount:0.5,Operation:0,UUIDLeast:763623,UUIDMost:811709,Slot:\"mainhand\"},{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:russelnormal",
            false,
            false,
            false,
            false,
            0,
            null);
    public static final Item vidiangun = new RWBYGun(
            "vidiangun",
            2500,
            72,
            0,
            null,
            "rwbym:vidianhammer",
            "rwbym:ammmo",
            true,
            1,
            false,
            false,
            0,
            1,
            0,
            7,
            null);
    public static final Item vidian = new RWBYSword(
            "vidian",
            2500,
            10,
            15,
            null,
            "rwbym:vidiangun",
            false,
            true,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item vidianhammer = new RWBYSword(
            "vidianhammer",
            2500,
            12,
            0,
            "{ench:[{id:19,lvl:2}]}",
            "rwbym:vidian",
            false,
            false,
            false,
            false,
            0,
            null);


    //------------------------------------------------//
    public static final Item ammo = new RWBYItem("ammo", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item gamammo = new RWBYItem("gamammo", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item magngrenade = new RWBYItem("magngrenade", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item emshell = new RWBYItem("emshell", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item emflareshell = new RWBYItem("emflareshell", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item emfireshell = new RWBYItem("emfireshell", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item dustcrystal = new RWBYItem("dustcrystal", "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.50,Operation:2,UUIDMost:74685,UUIDLeast:155127}]}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item winddustcrystal = new RWBYItem("winddustcrystal", "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.50,Operation:2,UUIDMost:74685,UUIDLeast:155127},{AttributeName:\"generic.movementSpeed\",Name:\"generic.movementSpeed\",Slot:\"offhand\",Amount:1.5,Operation:2,UUIDMost:78095,UUIDLeast:122333}]}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item firedustcrystal = new RWBYItem("firedustcrystal", "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.5,Operation:2,UUIDMost:25912,UUIDLeast:178428},{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"offhand\",Amount:2,Operation:2,UUIDMost:87232,UUIDLeast:139412}]}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item gravitydustcrystal = new RWBYItem("gravitydustcrystal", "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.5,Operation:2,UUIDMost:25912,UUIDLeast:178428}],display:{Lore:[\"Slow Falling and Negate Fall Damage While in offhand.\"]}}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item waterdustcrystal = new RWBYItem("waterdustcrystal",  "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"offhand\",Amount:-0.25,Operation:2,UUIDMost:81281,UUIDLeast:160467}],display:{Lore:[\"Provides Slow Health Regeneration while in Offhand.\"]}}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item lightdustcrystal = new RWBYItem("lightdustcrystal", "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.50,Operation:2,UUIDMost:17934,UUIDLeast:125321},{AttributeName:\"generic.movementSpeed\",Name:\"generic.movementSpeed\",Slot:\"offhand\",Amount:1.2,Operation:2,UUIDMost:13043,UUIDLeast:147969},{AttributeName:\"generic.attackSpeed\",Name:\"generic.attackSpeed\",Slot:\"offhand\",Amount:2,Operation:2,UUIDMost:14080,UUIDLeast:163727}]}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item icedustcrystal = new RWBYItem("icedustcrystal", " {AttributeModifiers:[{AttributeName:\"generic.movementSpeed\",Name:\"generic.movementSpeed\",Slot:\"offhand\",Amount:-0.3,Operation:2,UUIDMost:79372,UUIDLeast:112384},{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:0.5,Operation:2,UUIDMost:25912,UUIDLeast:178428}]}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item dustrock = new RWBYItem("dustrock", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item dust = new RWBYItem("dust", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item winddustrock = new RWBYItem("winddustrock", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item firedustrock = new RWBYItem("firedustrock", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item gravitydustrock = new RWBYItem("gravitydustrock", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item waterdustrock = new RWBYItem("waterdustrock", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item lightdustrock = new RWBYItem("lightdustrock", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item icedustrock = new RWBYItem("icedustrock", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item roseiron = new RWBYItem("roseiron", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item gildediron = new RWBYItem("gildediron", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item frostediron = new RWBYItem("frostediron", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item shadowiron = new RWBYItem("shadowiron", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item viridianiron = new RWBYItem("viridianiron", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item forestiron = new RWBYItem("forestiron", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cr1 = new RWBYItem("cr1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cr2 = new RWBYItem("cr2", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cr3 = new RWBYItem("cr3", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cr4 = new RWBYItem("cr4", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cr5 = new RWBYItem("cr5", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cr6 = new RWBYItem("cr6", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item mytre1 = new RWBYItem("mytre1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item mytre2 = new RWBYItem("mytre2", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item mytre3 = new RWBYItem("mytre3", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item gam1 = new RWBYItem("gam1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item gam2 = new RWBYItem("gam2", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item gam3 = new RWBYItem("gam3", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item em1 = new RWBYItem("em1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item em2 = new RWBYItem("em2", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item em3 = new RWBYItem("em3", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cro1 = new RWBYItem("cro1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cro2 = new RWBYItem("cro2", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item cro3 = new RWBYItem("cro3", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item magn1 = new RWBYItem("magn1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item magn2 = new RWBYItem("magn2", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item magn3 = new RWBYItem("magn3", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item magn4 = new RWBYItem("magn4", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item milo1 = new RWBYItem("milo1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item milo2 = new RWBYItem("milo2", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item milo3 = new RWBYItem("milo3", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item stor1 = new RWBYItem("stor1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item stor2 = new RWBYItem("stor2", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item stor3 = new RWBYItem("stor3", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item stor4 = new RWBYItem("stor4", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item stor5 = new RWBYItem("stor5", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item stor6 = new RWBYItem("stor6", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item scrap = new RWBYItem("scrap", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item atlasknight = new RWBYItem("atlasknight", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item remnants = new RWBYItem("remnants", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item armagigas = new RWBYItem("armagigas", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item coinr = new RWBYItem("coinr", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item coinw = new RWBYItem("coinw", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item coinb = new RWBYItem("coinb", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item coiny = new RWBYItem("coiny", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item coinjaune = new RWBYItem("coinjaune", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item coinnora = new RWBYItem("coinnora", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item coin_ren = new RWBYItem("coin_ren", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item coinqrow = new RWBYItem("coinqrow", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item coin_raven = new RWBYItem("coin_raven", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item coin_ragora = new RWBYItem("coin_ragora", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item chisel = new RWBYItem("chisel", null, false, RWBYCreativeTabs.tab_rwbyitems).setHasContainerItem(true).setContainerItemLambda(stack -> (stack.attemptDamageItem(1, new Random(), null) ? ItemStack.EMPTY : stack)).setMaxDamage(255).setMaxStackSize(1);
    public static final Item crush = new RWBYItem("crush", null, false, RWBYCreativeTabs.tab_rwbyitems).setHasContainerItem(true).setContainerItemLambda(stack -> (stack.attemptDamageItem(1, new Random(), null) ? ItemStack.EMPTY : stack)).setMaxDamage(255).setMaxStackSize(1);
    public static final Item rvnmask = new RWBYHood("rvnmask", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Amount:6,Operation:0,UUIDLeast:822742,UUIDMost:753903,Slot:\"head\"}]}", true, null, RWBYCreativeTabs.tab_rwbyarmour);
    public static final Item whtefng =  new RWBYHood("whtefng", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Amount:6,Operation:0,UUIDLeast:822742,UUIDMost:753903,Slot:\"head\"}]}", true, null, RWBYCreativeTabs.tab_rwbyarmour);
    public static final Item rubyhood = new RWBYHood("rubyhood", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Amount:6,Operation:0,UUIDLeast:822742,UUIDMost:753903,Slot:\"head\"}]}", true,"rwbym:ruby2_head", RWBYCreativeTabs.tab_rwbyarmour);
    public static final Item summerhood = new RWBYHood("summerhood", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Amount:10,Operation:0,UUIDLeast:822742,UUIDMost:753903,Slot:\"head\"}]}", true, "rwbym:summer2_head",RWBYCreativeTabs.tab_rwbyarmour);
    public static final Item lien1 = new RWBYItem("lien1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item lien5 = new RWBYItem("lien5", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item lien10 = new RWBYItem("lien10", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item lien20 = new RWBYItem("lien20", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item lien50 = new RWBYItem("lien50", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item lien100 = new RWBYItem("lien100", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item lien500 = new RWBYItem("lien500", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item signcrow = new RWBYItem("signcrow", null, false, null);
    public static final Item signdust = new RWBYItem("signdust", null, false, null);
    public static final Item scroll = new RWBYItem("scroll", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item scroll2 = new RWBYItem("scroll2", null, false, RWBYCreativeTabs.tab_rwbyitems);

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
            "rwbym:dustcrystalcut,rwbym:winddustcrystalcut,rwbym:firedustcrystalcut,rwbym:gravitydustcrystalcut,rwbym:waterdustcrystalcut,rwbym:lightdustcrystalcut,rwbym:icedustcrystalcut,rwbym:fireblock,rwbym:gravityblock,rwbym:iceblock,rwbym:impureblock,rwbym:lightblock,rwbym:waterblock,rwbym:windblock,rwbym:dustcrystal,rwbym:winddustcrystal,rwbym:firedustcrystal,rwbym:gravitydustcrystal,rwbym:waterdustcrystal,rwbym:lightdustcrystal,rwbym:icedustcrystal,rwbym:dustrock,rwbym:winddustrock,rwbym:firedustrock,rwbym:gravitydustrock,rwbym:waterdustrock,rwbym:lightdustrock,rwbym:icedustrock,rwbym:dust,rwbym:winddust,rwbym:firedust,rwbym:gravitydust,rwbym:waterdust,rwbym:lightdust,rwbym:icedust",
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
    		"rwbym:dustcrystalcut,rwbym:winddustcrystalcut,rwbym:firedustcrystalcut,rwbym:gravitydustcrystalcut,rwbym:waterdustcrystalcut,rwbym:lightdustcrystalcut,rwbym:icedustcrystalcut,rwbym:forestironblock,rwbym:frostedironblock,rwbym:gildedironblock,rwbym:roseironblock,rwbym:shadowironblock,rwbym:viridianironblock,rwbym:fireblock,rwbym:gravityblock,rwbym:iceblock,rwbym:impureblock,rwbym:lightblock,rwbym:waterblock,rwbym:windblock,rwbym:dustcrystal,rwbym:winddustcrystal,rwbym:firedustcrystal,rwbym:gravitydustcrystal,rwbym:waterdustcrystal,rwbym:lightdustcrystal,rwbym:icedustcrystal,rwbym:cr1,rwbym:cr2,rwbym:cr3,rwbym:cr4,rwbym:cr5,rwbym:cr6,rwbym:mytre1,rwbym:mytre2,rwbym:mytre3,rwbym:gam1,rwbym:gam2,rwbym:gam3,rwbym:em1,rwbym:em2,rwbym:em3,rwbym:cro1,rwbym:cro2,rwbym:cro3,rwbym:magn1,rwbym:magn2,rwbym:magn3,rwbym:magn4,rwbym:milo1,rwbym:milo2,rwbym:milo3,rwbym:stor1,rwbym:stor2,rwbym:stor3,rwbym:stor4,rwbym:stor5,rwbym:stor6,rwbym:scrap,rwbym:remnants,rwbym:dustrock,rwbym:winddustrock,rwbym:firedustrock,rwbym:gravitydustrock,rwbym:waterdustrock,rwbym:lightdustrock,rwbym:icedustrock,rwbym:dust,rwbym:winddust,rwbym:firedust,rwbym:gravitydust,rwbym:waterdust,rwbym:lightdust,rwbym:icedust,rwbym:lien1,rwbym:lien5,rwbym:lien10,rwbym:lien20,rwbym:lien50,rwbym:lien100,rwbym:lien500,rwbym:roseiron,rwbym:gildediron,rwbym:frostediron,rwbym:shadowiron,rwbym:viridianiron,rwbym:forestiron",
    		54,
    		1,
    		FMLCommonHandler.instance().getSide() == Side.CLIENT ? RWBYItemContainerGuiChest.class : null,
    		RWBYItemContainerChest.class)
    		.setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);
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

    //-----------------------------------------------//
    public static final Item entitybullet = new RWBYItem("entitybullet", null, false, null);
    public static final Item entityfireshell = new RWBYItem("entityfireshell", null, false, null);
    public static final Item entityflareshell = new RWBYItem("entityflareshell", null, false, null);
    public static final Item entityshell = new RWBYItem("entityshell", null, false, null);
    public static final Item entitysmallbullet = new RWBYItem("entitysmallbullet", null, false, null);
    public static final Item entitygrenade = new RWBYItem("entitygrenade", null, false, null);
    public static final Item entitybulletv = new RWBYItem("entitybulletv", null, false, null);
    public static final Item entityweissfire = new RWBYItem("entityweissfire", null, false, null);
    public static final Item entityweissgravity = new RWBYItem("entityweissgravity", null, false, null);
    public static final Item entityweissice = new RWBYItem("entityweissice", null, false, null);
    public static final Item entityweisslight = new RWBYItem("entityweisslight", null, false, null);
    public static final Item entityweisswater = new RWBYItem("entityweisswater", null, false, null);
    public static final Item entityweisswind = new RWBYItem("entityweisswind", null, false, null);
    public static final Item entityrocket = new RWBYItem("entityrocket", null, false, null);

            //------------------------------------------------//
    public static final Item spl = new RWBYAmmoItem(
            "spl",
            RWBYItems.entitysmallbullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            null,
            null,
            32,
            8,
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
            "",
            null,
            32,
            8,
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
            null,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:slowness"), 100, 5)),
            32,
            8,
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
            null,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:levitation"), 100, 2)),
            32,
            8,
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
            "",
            null,
            32,
            8,
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
            null,
            null,
            32,
            8,
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
            "",
            null,
            32,
            8,
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
            null,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:slowness"), 100, 5)),
            32,
            8,
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
            null,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:levitation"), 100, 2)),
            32,
            8,
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
            null,
            null,
            32,
            3,
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
            "",
            null,
            32,
            3,
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
            "",
            null,
            32,
            3,
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
            null,
            null,
            32,
            10,
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
            null,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:levitation"), 100, 2)),
            32,
            10,
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
            "",
            null,
            32,
            10,
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
            null,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:slowness"), 500, 20)),
            32,
            10,
            RWBYCreativeTabs.tab_rwbyitems,
            new ExplosionAmmoHit(0));
    public static final Item magnammo = new RWBYAmmoItem(
            "magnammo",
            RWBYItems.entitygrenade,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            "",
            null,
            12,
            10,
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
            "",
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
            "",
            null,
            1,
            0,
            RWBYCreativeTabs.tab_rwbyitems,
            new PotionAmmoHit(Items.LINGERING_POTION, ImmutableList.of(new PotionEffect(Potion.getPotionById(1), 80, 5), new PotionEffect(Potion.getPotionById(8), 100, 3, false, false))));
    public static final Item firedust = new RWBYAmmoItem(
            "firedust",
            RWBYItems.entityweissfire,
            64,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            "",
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
            null,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:slowness"), 500, 20)),
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
            null,
            ImmutableList.of(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:speed"), 400, 2)),
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
            "",
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
            "",
            null,
            6,
            10,
            null,
            new ExplosionAmmoHit(3));
    public static final Item ammov = new RWBYAmmoItem(
            "ammov",
            RWBYItems.entitybulletv,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            null,
            null,
            1,
            10,
            null,
            null);
    public static final Item ammmo = new RWBYAmmoItem(
            "ammmo",
            RWBYItems.entitybullet,
            1,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            null,
            null,
            1,
            4,
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
            null,
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
            null,
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
            "",
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
            null,
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
            "",
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
            RWBYAmmoItem.SurviveOnHit.ENTITY,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            true,
            null,
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
            "",
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
            "",
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
            "",
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
            "",
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
            "",
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
            "",
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
            "",
            null,
            6,
            0,
            null,
            new ExplosionAmmoHit(3));
    public static final Item ragorafireball = new RWBYAmmoItem(
    		"ragorafireball",
    		new EntityDragonFireball(null),
    		0,
    		false,
    		null,
            "textures/entity/projectiles/tipped_arrow.png",
    		false,
    		true,
    		null,
    		null,
    		0,
    		0,
    		null,
    		new IAmmoHit() {
				@Override
				public void applyEntity(EntityLivingBase living, EntityLivingBase shooter) {
					if (!living.world.isRemote) {
						float r = RWBYConfig.shadowballsize;
						float f = RWBYConfig.shadowballresolution;
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
						float r = RWBYConfig.shadowballsize;
						float f = RWBYConfig.shadowballresolution;
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
    public static final Block rwbyblock8 = new RWBYNotFullBlock(
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
            0F,
            1F,
            "null",
            1);
    public static final Block crusher = new RWBYCrusher(
            "crusher");

    //Armour

    public static List<Item> ITEMS = new ArrayList();
    public static final ItemArmor.ArmorMaterial korekosmouOffMat;
    public static final ItemArmor.ArmorMaterial korekosmouFireMat;
    public static final ItemArmor.ArmorMaterial korekosmouWaterMat;
    public static final ItemArmor.ArmorMaterial korekosmouWindMat;
    public static final ItemArmor.ArmorMaterial RagoraMat = EnumHelper.addArmorMaterial("Ragora", "rwbym:ragora", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);

    public static final ItemArmor.ArmorMaterial QrowMat = EnumHelper.addArmorMaterial("Qrow", "rwbym:qrow", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor QrowChest = new ArmourBase(QrowMat, 0, EntityEquipmentSlot.CHEST, "qrow_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor QrowLegs = new ArmourBase(QrowMat, 0, EntityEquipmentSlot.LEGS, "qrow_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial Juane1Mat = EnumHelper.addArmorMaterial("Juane1", "rwbym:juane1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Juane1Chest = new ArmourBase(Juane1Mat, 0, EntityEquipmentSlot.CHEST, "juane1_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor Juane1Legs = new ArmourBase(Juane1Mat, 0, EntityEquipmentSlot.LEGS, "juane1_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial Weiss1Mat = EnumHelper.addArmorMaterial("Weiss1", "rwbym:weiss1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Weiss1Chest = new ArmourBase(Weiss1Mat, 0, EntityEquipmentSlot.CHEST, "weiss1_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor Weiss1Legs = new ArmourBase(Weiss1Mat, 0, EntityEquipmentSlot.LEGS, "weiss1_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial AdamMat = EnumHelper.addArmorMaterial("Adam", "rwbym:adam", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor AdamChest = new ArmourBase(AdamMat, 0, EntityEquipmentSlot.CHEST, "adam_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor AdamLegs = new ArmourBase(AdamMat, 0, EntityEquipmentSlot.LEGS, "adam_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial AtlasMat = EnumHelper.addArmorMaterial("Atlas", "rwbym:atlas", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor AtlasChest = new ArmourBase(AtlasMat, 0, EntityEquipmentSlot.CHEST, "atlas_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor AtlasLegs = new ArmourBase(AtlasMat, 0, EntityEquipmentSlot.LEGS, "atlas_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor AtlasHead = new ArmourBase(AtlasMat, 0, EntityEquipmentSlot.HEAD, "atlas_head", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"head\",Amount:6,Operation:0,UUIDMost:69171,UUIDLeast:104277}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial BeaconMat = EnumHelper.addArmorMaterial("Beacon", "rwbym:beacon", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor BeaconChest = new ArmourBase(BeaconMat, 0, EntityEquipmentSlot.CHEST, "beacon_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor BeaconLegs = new ArmourBase(BeaconMat, 0, EntityEquipmentSlot.LEGS, "beacon_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);


    public static final ItemArmor.ArmorMaterial Beacon1Mat = EnumHelper.addArmorMaterial("Beacon1", "rwbym:beacon1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Beacon1Chest = new ArmourBase(Beacon1Mat, 0, EntityEquipmentSlot.CHEST, "beacon1_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor Beacon1Legs = new ArmourBase(Beacon1Mat, 0, EntityEquipmentSlot.LEGS, "beacon1_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);



    public static final ItemArmor.ArmorMaterial Blake1Mat = EnumHelper.addArmorMaterial("Blake1", "rwbym:blake1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Blake1Chest = new ArmourBase(Blake1Mat, 0, EntityEquipmentSlot.CHEST, "blake1_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor Blake1Legs = new ArmourBase(Blake1Mat, 0, EntityEquipmentSlot.LEGS, "blake1_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial Blake2Mat = EnumHelper.addArmorMaterial("Blake2", "rwbym:blake2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Blake2Chest = new ArmourBase(Blake2Mat, 0, EntityEquipmentSlot.CHEST, "blake2_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor Blake2Legs = new ArmourBase(Blake2Mat, 0, EntityEquipmentSlot.LEGS, "blake2_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial Blake3Mat = EnumHelper.addArmorMaterial("Blake3", "rwbym:blake3", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Blake3Chest = new ArmourBase(Blake3Mat, 0, EntityEquipmentSlot.CHEST, "blake3_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor Blake3Legs = new ArmourBase(Blake3Mat, 0, EntityEquipmentSlot.LEGS, "blake3_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial AmberMat = EnumHelper.addArmorMaterial("Amber", "rwbym:amber", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor AmberChest = new ArmourBase(AmberMat, 0, EntityEquipmentSlot.CHEST, "amber_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor AmberLegs = new ArmourBase(AmberMat, 0, EntityEquipmentSlot.LEGS, "amber_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial Cinder1Mat = EnumHelper.addArmorMaterial("Cinder1", "rwbym:cinder1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Cinder1Chest = new ArmourBase(Cinder1Mat, 0, EntityEquipmentSlot.CHEST, "cinder1_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor Cinder1Legs = new ArmourBase(Cinder1Mat, 0, EntityEquipmentSlot.LEGS, "cinder1_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial Cinder2Mat = EnumHelper.addArmorMaterial("Cinder2", "rwbym:cinder2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Cinder2Chest = new ArmourBase(Cinder2Mat, 0, EntityEquipmentSlot.CHEST, "cinder2_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor Cinder2Legs = new ArmourBase(Cinder2Mat, 0, EntityEquipmentSlot.LEGS, "cinder2_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    
    public static final ItemArmor.ArmorMaterial Cinder3Mat = EnumHelper.addArmorMaterial("Cinder3", "rwbym:cinder3", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Cinder3Chest = new ArmourBase(Cinder3Mat, 0, EntityEquipmentSlot.CHEST, "cinder3_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor Cinder3Legs = new ArmourBase(Cinder3Mat, 0, EntityEquipmentSlot.LEGS, "cinder3_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial CocoMat = EnumHelper.addArmorMaterial("Coco", "rwbym:coco", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor CocoChest = new ArmourBase(CocoMat, 0, EntityEquipmentSlot.CHEST, "coco_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor CocoLegs = new ArmourBase(CocoMat, 0, EntityEquipmentSlot.LEGS, "coco_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor CocoHead = new ArmourBase(CocoMat, 0, EntityEquipmentSlot.HEAD, "coco_head", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"head\",Amount:6,Operation:0,UUIDMost:69171,UUIDLeast:104277}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial romanMat = EnumHelper.addArmorMaterial("roman", "rwbym:roman", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor romanChest = new ArmourBase(romanMat, 0, EntityEquipmentSlot.CHEST, "roman_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor romanLegs = new ArmourBase(romanMat, 0, EntityEquipmentSlot.LEGS, "roman_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor romanHead = new ArmourBase(romanMat, 0, EntityEquipmentSlot.HEAD, "roman_head", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"head\",Amount:6,Operation:0,UUIDMost:69171,UUIDLeast:104277}]}", true, RWBYCreativeTabs.tab_rwbyarmour);


    public static final ItemArmor.ArmorMaterial Emerald1Mat = EnumHelper.addArmorMaterial("Emerald1", "rwbym:emerald1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Emerald1Chest = new ArmourBase(Emerald1Mat, 0, EntityEquipmentSlot.CHEST, "emerald1_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor Emerald1Legs = new ArmourBase(Emerald1Mat, 0, EntityEquipmentSlot.LEGS, "emerald1_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial Emerald2Mat = EnumHelper.addArmorMaterial("Emerald2", "rwbym:emerald2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor Emerald2Chest = new ArmourBase(Emerald2Mat, 0, EntityEquipmentSlot.CHEST, "emerald2_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor Emerald2Legs = new ArmourBase(Emerald2Mat, 0, EntityEquipmentSlot.LEGS, "emerald2_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    
    
    
    
    public static final ItemArmor.ArmorMaterial pennyMat = EnumHelper.addArmorMaterial("penny", "rwbym:penny", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor pennyChest = new ArmourBase(pennyMat, 0, EntityEquipmentSlot.CHEST, "penny_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor pennyLegs = new ArmourBase(pennyMat, 0, EntityEquipmentSlot.LEGS, "penny_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial pyrrhaMat = EnumHelper.addArmorMaterial("pyrrha", "rwbym:pyrrha", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor pyrrhaChest = new ArmourBase(pyrrhaMat, 0, EntityEquipmentSlot.CHEST, "pyrrha_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor pyrrhaLegs = new ArmourBase(pyrrhaMat, 0, EntityEquipmentSlot.LEGS, "pyrrha_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial ravenMat = EnumHelper.addArmorMaterial("raven", "rwbym:raven", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ravenChest = new ArmourBase(ravenMat, 0, EntityEquipmentSlot.CHEST, "raven_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor ravenLegs = new ArmourBase(ravenMat, 0, EntityEquipmentSlot.LEGS, "raven_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial ruby1Mat = EnumHelper.addArmorMaterial("ruby1", "rwbym:ruby1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ruby1Chest = new ArmourBase(ruby1Mat, 0, EntityEquipmentSlot.CHEST, "ruby1_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor ruby1Legs = new ArmourBase(ruby1Mat, 0, EntityEquipmentSlot.LEGS, "ruby1_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial ruby2Mat = EnumHelper.addArmorMaterial("ruby2", "rwbym:ruby2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ruby2Chest = new ArmourBase(ruby2Mat, 0, EntityEquipmentSlot.CHEST, "ruby2_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor ruby2Legs = new ArmourBase(ruby2Mat, 0, EntityEquipmentSlot.LEGS, "ruby2_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor ruby2Head = new ArmourBase(ruby2Mat, 0, EntityEquipmentSlot.HEAD, "ruby2_head", "rwbym:rubyhood", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"head\",Amount:6,Operation:0,UUIDMost:69171,UUIDLeast:104277}]}", true, null);
    
    public static final ItemArmor.ArmorMaterial ruby3Mat = EnumHelper.addArmorMaterial("ruby3", "rwbym:ruby3", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ruby3Chest = new ArmourBase(ruby3Mat, 0, EntityEquipmentSlot.CHEST, "ruby3_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor ruby3Legs = new ArmourBase(ruby3Mat, 0, EntityEquipmentSlot.LEGS, "ruby3_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial salemMat = EnumHelper.addArmorMaterial("salem", "rwbym:salem", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor salemChest = new ArmourBase(salemMat, 0, EntityEquipmentSlot.CHEST, "salem_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor salemLegs = new ArmourBase(salemMat, 0, EntityEquipmentSlot.LEGS, "salem_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial velvetMat = EnumHelper.addArmorMaterial("velvet", "rwbym:velvet", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor velvetChest = new ArmourBase(velvetMat, 0, EntityEquipmentSlot.CHEST, "velvet_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor velvetLegs = new ArmourBase(velvetMat, 0, EntityEquipmentSlot.LEGS, "velvet_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial weiss2Mat = EnumHelper.addArmorMaterial("weiss2", "rwbym:weiss2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor weiss2Chest = new ArmourBase(weiss2Mat, 0, EntityEquipmentSlot.CHEST, "weiss2_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor weiss2Legs = new ArmourBase(weiss2Mat, 0, EntityEquipmentSlot.LEGS, "weiss2_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial weiss3Mat = EnumHelper.addArmorMaterial("weiss3", "rwbym:weiss3", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor weiss3Chest = new ArmourBase(weiss3Mat, 0, EntityEquipmentSlot.CHEST, "weiss3_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor weiss3Legs = new ArmourBase(weiss3Mat, 0, EntityEquipmentSlot.LEGS, "weiss3_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial winterMat = EnumHelper.addArmorMaterial("winter", "rwbym:winter", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor winterChest = new ArmourBase(winterMat, 0, EntityEquipmentSlot.CHEST, "winter_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor winterLegs = new ArmourBase(winterMat, 0, EntityEquipmentSlot.LEGS, "winter_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial yang1Mat = EnumHelper.addArmorMaterial("yang1", "rwbym:yang1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor yang1Chest = new ArmourBase(yang1Mat, 0, EntityEquipmentSlot.CHEST, "yang1_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor yang1Legs = new ArmourBase(yang1Mat, 0, EntityEquipmentSlot.LEGS, "yang1_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial yang2Mat = EnumHelper.addArmorMaterial("yang2", "rwbym:yang2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor yang2Chest = new ArmourBase(yang2Mat, 0, EntityEquipmentSlot.CHEST, "yang2_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor yang2Legs = new ArmourBase(yang2Mat, 0, EntityEquipmentSlot.LEGS, "yang2_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial yang3Mat = EnumHelper.addArmorMaterial("yang3", "rwbym:yang3", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor yang3Chest = new ArmourBase(yang3Mat, 0, EntityEquipmentSlot.CHEST, "yang3_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor yang3Legs = new ArmourBase(yang3Mat, 0, EntityEquipmentSlot.LEGS, "yang3_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial yang4Mat = EnumHelper.addArmorMaterial("yang4", "rwbym:yang4", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor yang4Chest = new ArmourBase(yang4Mat, 0, EntityEquipmentSlot.CHEST, "yang4_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor yang4Legs = new ArmourBase(yang4Mat, 0, EntityEquipmentSlot.LEGS, "yang4_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial ironwood1Mat = EnumHelper.addArmorMaterial("ironwood1", "rwbym:ironwood1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ironwood1Chest = new ArmourBase(ironwood1Mat, 0, EntityEquipmentSlot.CHEST, "ironwood1_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor ironwood1Legs = new ArmourBase(ironwood1Mat, 0, EntityEquipmentSlot.LEGS, "ironwood1_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial ironwood2Mat = EnumHelper.addArmorMaterial("ironwood2", "rwbym:ironwood2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ironwood2Chest = new ArmourBase(ironwood2Mat, 0, EntityEquipmentSlot.CHEST, "ironwood2_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor ironwood2Legs = new ArmourBase(ironwood2Mat, 0, EntityEquipmentSlot.LEGS, "ironwood2_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial mercury1Mat = EnumHelper.addArmorMaterial("mercury1", "rwbym:mercury1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor mercury1Chest = new ArmourBase(mercury1Mat, 0, EntityEquipmentSlot.CHEST, "mercury1_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor mercury1Legs = new ArmourBase(mercury1Mat, 0, EntityEquipmentSlot.LEGS, "mercury1_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial mercury2Mat = EnumHelper.addArmorMaterial("mercury2", "rwbym:mercury2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor mercury2Chest = new ArmourBase(mercury2Mat, 0, EntityEquipmentSlot.CHEST, "mercury2_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor mercury2Legs = new ArmourBase(mercury2Mat, 0, EntityEquipmentSlot.LEGS, "mercury2_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial ozpinMat = EnumHelper.addArmorMaterial("ozpin", "rwbym:ozpin", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor ozpinChest = new ArmourBase(ozpinMat, 0, EntityEquipmentSlot.CHEST, "ozpin_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor ozpinLegs = new ArmourBase(ozpinMat, 0, EntityEquipmentSlot.LEGS, "ozpin_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial summer1Mat = EnumHelper.addArmorMaterial("summer1", "rwbym:summer1", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor summer1Chest = new ArmourBase(summer1Mat, 0, EntityEquipmentSlot.CHEST, "summer1_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:14,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor summer1Legs = new ArmourBase(summer1Mat, 0, EntityEquipmentSlot.LEGS, "summer1_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:14,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);

    public static final ItemArmor.ArmorMaterial summer2Mat = EnumHelper.addArmorMaterial("summer2", "rwbym:summer2", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor summer2Chest = new ArmourBase(summer2Mat, 0, EntityEquipmentSlot.CHEST, "summer2_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:14,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor summer2Legs = new ArmourBase(summer2Mat, 0, EntityEquipmentSlot.LEGS, "summer2_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:14,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor summer2Head = new ArmourBase(summer2Mat, 0, EntityEquipmentSlot.HEAD, "summer2_head", "rwbym:summerhood", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"head\",Amount:10,Operation:0,UUIDMost:69171,UUIDLeast:104277}]}", true, null);


    public static final ItemArmor.ArmorMaterial neptuneMat = EnumHelper.addArmorMaterial("neptune", "rwbym:neptune", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final ItemArmor neptuneChest = new ArmourBase(neptuneMat, 0, EntityEquipmentSlot.CHEST, "neptune_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor neptuneLegs = new ArmourBase(neptuneMat, 0, EntityEquipmentSlot.LEGS, "neptune_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor neptuneHead = new ArmourBase(neptuneMat, 0, EntityEquipmentSlot.HEAD, "neptune_head", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"head\",Amount:6,Operation:0,UUIDMost:69171,UUIDLeast:104277}]}", true, RWBYCreativeTabs.tab_rwbyarmour);


    public static final ItemArmor korekosmouoff;
    public static final ItemArmor korekosmoufire;
    public static final ItemArmor korekosmouwater;
    public static final ItemArmor korekosmouwind;
    public static final ItemArmor RagoraHead = new ArmourBase(RagoraMat, 0, EntityEquipmentSlot.HEAD, "ragora_head", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"head\",Amount:6,Operation:0,UUIDMost:69171,UUIDLeast:104277}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor RagoraChest = new ArmourBase(RagoraMat, 0, EntityEquipmentSlot.CHEST, "ragora_chest", null, "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    public static final ItemArmor RagoraLegs = new ArmourBase(RagoraMat, 0, EntityEquipmentSlot.LEGS, "ragora_legs", null, " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"legs\",Amount:10,Operation:0,UUIDMost:96062,UUIDLeast:166413},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"legs\",Amount:5,Operation:0,UUIDMost:42612,UUIDLeast:167904}]}", true, RWBYCreativeTabs.tab_rwbyarmour);
    //public static final ItemArmor starting_Leggings;
/*
    public static void init() {
        Utils.addItem(korekosmouoff);
        Utils.addItem(korekosmouwater);
        Utils.addItem(korekosmoufire);
        Utils.addItem(korekosmouwind);
        //Utils.addItem(starting_Leggings);
    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Item> e) {
        init();
        e.getRegistry().registerAll((ITEMS.toArray(new Item[ITEMS.size()])));
    }

    public static final Item addItem(Item item) {
        ITEMS.add(item);
        if (RWBYModels.side.isClient()) {
            Utils.registerItemRenderer(item);
        }

        return item;
    }
*/

    static {
        korekosmouOffMat = EnumHelper.addArmorMaterial("Kore Kosmou", "rwbym:korekosmou", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
        korekosmouFireMat = EnumHelper.addArmorMaterial("Kore Kosmou Fire", "rwbym:korekosmoufire", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
        korekosmouWaterMat = EnumHelper.addArmorMaterial("Kore Kosmou Water", "rwbym:korekosmouwater", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
        korekosmouWindMat = EnumHelper.addArmorMaterial("Kore Kosmou Wind", "rwbym:korekosmouwind", 40, new int[]{0, 0, 0, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
        korekosmouoff = new ArmourBase(korekosmouOffMat, 0, EntityEquipmentSlot.CHEST, "korekosmouoff","rwbym:korekosmoufire", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", false, RWBYCreativeTabs.tab_rwbyweapons);
        korekosmoufire = new ArmourBase(korekosmouFireMat, 0, EntityEquipmentSlot.CHEST, "korekosmoufire","rwbym:korekosmouice","{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", false, null);
        korekosmouwater = new ArmourBase(korekosmouWaterMat, 0, EntityEquipmentSlot.CHEST, "korekosmouice","rwbym:korekosmouwind", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", false, null);
        korekosmouwind = new ArmourBase(korekosmouWindMat, 0, EntityEquipmentSlot.CHEST, "korekosmouwind","rwbym:korekosmouoff", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"chest\",Amount:10,Operation:0,UUIDMost:11326,UUIDLeast:127298},{AttributeName:\"generic.armorToughness\",Name:\"generic.armorToughness\",Slot:\"chest\",Amount:5,Operation:0,UUIDMost:68780,UUIDLeast:119491}]}", false, null);
        //starting_Leggings = new ArmourBase(startingMaterialA, 0, EntityEquipmentSlot.LEGS, "starting_Leggings");
    }

}
