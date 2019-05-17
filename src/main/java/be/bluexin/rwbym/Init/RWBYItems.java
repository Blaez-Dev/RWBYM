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
    public static final Item crescent = new RWBYCRScythe(
            "crescent",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:571090,UUIDMost:892303,Slot:\"mainhand\"}]}",
            "rwbym:crescentgun",
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            1,
            true,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item crescentfrost = new RWBYCRScythe(
            "crescentfrost",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:571090,UUIDMost:892303,Slot:\"mainhand\"}]}",
            "rwbym:crescentgunfrost",
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            1,
            true,
            0,
           null);
    public static final Item gambol = new RWBYSword(
            "gambol",
            2500,
            10,
            0,
            null,
            "rwbym:gambolgun",
            false,
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
            false,
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
            false,
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
            false,
            false,
            false,
            true,
            0,
            null);
    public static final Item qrow = new RWBYCRScythe(
            "qrow",
            2500,
            15,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:571090,UUIDMost:892303,Slot:\"mainhand\"}]}",
            "rwbym:qrowgun",
            "rwbym:ammmmo",
            false,
            1,
            true,
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
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item juane = new RWBYSword("juane",
            2500,
            10,
            0,
            null,
            null,
            true,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
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
            "rwbym:pyrrhasword",
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
    public static final Item crescentv = new RWBYCRScythe(
            "crescentv",
            1250,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:531774,UUIDMost:709040,Slot:\"mainhand\"},{AttributeName:\"generic.attackSpeed\",Name:\"generic.attackSpeed\",Amount:3,Operation:0,UUIDLeast:811643,UUIDMost:138699}]}",
            "rwbym:crescentgunv",
            "rwbym:ammov",
            false,
            1,
            false,
            1,
            null);
    public static final Item weissv = new RWBYRapier(
            "weissv",
            1250,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:10,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:gambolv",
            "rwbym:ammmmo",
            false,
            1,
            false,
            2,
            1,
            null);
    public static final Item gambolv = new RWBYSword(
            "gambolv",
            1250,
            10,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:gambolgunv",
            false,
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
    public static final Item fox = new RWBYSword(
            "fox",
            2500,
            10,
            15,
            null,
            null,
            false,
            false,
            false,
            false,
            0,
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
    public static final Item winterswd = new RWBYSword(
            "winterswd",
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
    public static final Item mariascythe = new RWBYCRScythe(
            "mariascythe",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:571090,UUIDMost:892303,Slot:\"mainhand\"}]}",
            "rwbym:mariascythedouble",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            1,
            true,
            0,
            null);
    public static final Item angelcane = new RWBYSword(
            "angelcane",
            2500,
            12,
            0,
            null,
            "rwbym:angelsword",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item angelsword = new RWBYRapier(
            "angelsword",
            2500,
            72,
            0,
            null,
            "rwbym:angelcane",
            "none",
            false,
            1,
            true,
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
    public static final Item chatareus = new RWBYBow(
            "chatareus",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:571090,UUIDMost:892303,Slot:\"mainhand\"}]}",
            "rwbym:chatareusgun",
            "rwbym:chatmag,rwbym:chatfiremag,rwbym:chatgravmag,rwbym:chatelectricmag",
            false,
            1,
            true,
            0,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item chatareusgun = new RWBYBow(
            "chatareusgun",
            2500,
            7200,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:571090,UUIDMost:892303,Slot:\"mainhand\"}]}",
            "rwbym:chatareus",
            "rwbym:chatmag,rwbym:chatfiremag,rwbym:chatgravmag,rwbym:chatelectricmag",
            false,
            1,
            true,
            0,
            0,
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
    public static final Item razorboltknife = new RWBYBow(
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
            0,
            0,
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

    public static final Item reesegun = new RWBYBow(
            "reesegun",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:reese",
            "rwbym:gamammo,rwbym:emammmo",
            false,
            1,
            true,
            0,
            0,
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



    //------------------------------------------------//

    public static final Item crescentgun = new RWBYBow(
            "crescentgun",
            2500,
            72,
            0,
            null,
            "rwbym:crescent",
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            1,
            true,
            1,
            0,
            null);
    public static final Item crescentgunfrost = new RWBYBow(
            "crescentgunfrost",
            2500,
            72,
            0,
            null,
            "rwbym:crescentfrost",
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            1,
            true,
            1,
            0,
            null);
    public static final Item weiss = new RWBYRapier(
            "weiss",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            null,
            "rwbym:gravitydust,rwbym:winddust,rwbym:icedust,rwbym:waterdust,rwbym:firedust,rwbym:lightdust",
            false,
            1,
            false,
            3,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item crescentgunv = new RWBYBow(
            "crescentgunv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:emberv",
            "rwbym:ammov",
            false,
            1,
            true,
            1,
            1,
            null);
    public static final Item ember = new RWBYShotgun(
            "ember",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:ember2",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            true,
            4,
            2,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item ember2 = new RWBYShotgun(
            "ember2",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:ember",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            true,
            4,
            2,
            0,
            null);
    public static final Item gambolgun = new RWBYBow(
            "gambolgun",
            2500,
            72,
            0,
            null,
            "rwbym:gambol",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            1,
            true,
            0,
            0,
            null);
    public static final Item gambolgunv = new RWBYBow(
            "gambolgunv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:juanev",
            "rwbym:ammov",
            false,
            1,
            true,
            0,
            1,
            null);
    public static final Item stormflower = new RWBYBow(
            "stormflower",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            null,
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            true,
            1,
            true,
            0,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item noragun = new RWBYBow(
            "noragun",
            2500,
            72,
            0,
            null,
            "rwbym:norahammer",
            "rwbym:magnammo,rwbym:magnaampammo",
            false,
            1,
            true,
            0,
            0,
            null);
    public static final Item stormflowerv = new RWBYBow(
            "stormflowerv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3,AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:cocobagv",
            "rwbym:ammov",
            true,
            1,
            true,
            0,
            1,
            null);
    public static final Item noragunv = new RWBYBow(
            "noragunv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:pyrrhaspearv",
            "rwbym:ammov",
            false,
            1,
            true,
            0,
            1,
            null);
    public static final Item emberv = new RWBYShotgun(
            "emberv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3,AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:10,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:weissv",
            "rwbym:ammov",
            false,
            1,
            true,
            4,
            2,
            1,
            null);
    public static final Item qrowgun = new RWBYShotgun(
            "qrowgun",
            2500,
            72,
            0,
            null,
            "rwbym:qrowsword",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            true,
            4,
            0,
            0,
            null);
    public static final Item cocogun = new RWBYBow(
            "cocogun",
            1250,
            72,
            0,
            null,
            "rwbym:cocobag",
            "rwbym:ammmo",
            true,
            1,
            true,
            0,
            0,
            null);
    public static final Item cocogunv = new RWBYBow(
            "cocogunv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:velvet",
            "rwbym:ammmo",
            true,
            1,
            true,
            0,
            1,
            null);

    public static final Item torchwickgun = new RWBYShotgun(
            "torchwickgun",
            2500,
            72,
            0,
            null,
            "rwbym:torchwick",
            "rwbym:emammmo,rwbym:emflareammo",
            false,
            0.8F,
            true,
            1,
            0,
            0,
            null);
    public static final Item portgun = new RWBYShotgun(
            "portgun",
            2500,
            72,
            0,
            null,
            "rwbym:port",
            "rwbym:emammo,rwbym:emammmo",
            false,
            0.8F,
            true,
            4,
            0,
            0,
            null);
    public static final Item emeraldgun = new RWBYBow(
            "emeraldgun",
            2500,
            72,
            0,
            null,
            "rwbym:emeraldblade",
            "rwbym:gamammo,rwbym:emammmo",
            false,
            1,
            true,
            0,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item emeraldblade = new RWBYBow(
            "emeraldblade",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:emeraldgun",
            "rwbym:gamammo,rwbym:emammmo",
            false,
            1,
            true,
            0,
            0,
            null);
    public static final Item jnrrocket = new RWBYBow(
            "jnrrocket",
            2500,
            72,
            0,
            null,
            "rwbym:jnrbat",
            "rwbym:jnrammo",
            false,
            1,
            true,
            0,
            0,
            null);
    public static final Item cinderbow = new RWBYBow(
            "cinderbow",
            2500,
            72,
            0,
            null,
            "rwbym:cinder",
            "minecraft:arrow,minecraft:tipped_arrow",
            false,
            1,
            true,
            0,
            0,
            null);
    public static final Item adamgun = new RWBYShotgun(
            "adamgun",
            2500,
            72,
            0,
            null,
            "rwbym:adamswd",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            true,
            3,
            0,
            0,
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
    public  static  final  Item sunnunchuck = new RWBYShotgun(
            "sunnunchuck",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:sunstaff", "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            true,
            2,
            0,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item neptunegun = new RWBYBow(
            "neptunegun",
            2500,
            72,
            0,
            null,
            "rwbym:neptunespear",
            "rwbym:neptammo,rwbym:magnaampammo",
            false,
            2,
            true,
            0,
            0,
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
    public static final Item scarletsword = new RWBYRapier(
            "scarletsword",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            null,
            "rwbym:gamammo,rwbym:emammmo",
            false,
            1,
            false,
            0,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item nadirgun = new RWBYBow(
            "nadirgun",
            2500,
            72,
            0,
            null,
            "rwbym:nadirsword",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            true,
            1,
            true,
            0,
            0,
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
    public  static  final  Item hexen = new RWBYShotgun(
            "hexen",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:hexenaxe",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            true,
            0.8F,
            true,
            4,
            0,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public  static  final  Item hexenaxe = new RWBYShotgun(
            "hexenaxe",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:18,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:hexen",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            0.8F,
            true,
            4,
            0,
            0,
            null);
    public static final Item magnumgun = new RWBYBow(
            "magnumgun",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:12,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:magnumsword",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            true,
            1,
            true,
            1,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item magnumsword = new RWBYCRScythe(
            "magnumsword",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:16,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:magnumsword",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            1,
            true,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);

    //------------------------------------------------//
    public static final Item ammo = new RWBYItem("ammo", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item magngrenade = new RWBYItem("magngrenade", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item emshell = new RWBYItem("emshell", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item emflareshell = new RWBYItem("emflareshell", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item emfireshell = new RWBYItem("emfireshell", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item dustcrystal = new RWBYItem("dustcrystal", "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.50,Operation:2,UUIDMost:74685,UUIDLeast:155127}]}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item winddustcrystal = new RWBYItem("winddustcrystal", "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.50,Operation:2,UUIDMost:74685,UUIDLeast:155127},{AttributeName:\"generic.movementSpeed\",Name:\"generic.movementSpeed\",Slot:\"offhand\",Amount:2,Operation:2,UUIDMost:78095,UUIDLeast:122333}]}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item firedustcrystal = new RWBYItem("firedustcrystal", "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.5,Operation:2,UUIDMost:25912,UUIDLeast:178428},{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"offhand\",Amount:3,Operation:2,UUIDMost:87232,UUIDLeast:139412}]}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item gravitydustcrystal = new RWBYItem("gravitydustcrystal", "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.5,Operation:2,UUIDMost:25912,UUIDLeast:178428}],display:{Lore:[\"Slow Falling and Negate Fall Damage While in offhand.\"]}}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item waterdustcrystal = new RWBYItem("waterdustcrystal",  "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"offhand\",Amount:-0.25,Operation:2,UUIDMost:81281,UUIDLeast:160467}],display:{Lore:[\"Provides Slow Health Regeneration while in Offhand.\"]}}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item lightdustcrystal = new RWBYItem("lightdustcrystal", "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.50,Operation:2,UUIDMost:17934,UUIDLeast:125321},{AttributeName:\"generic.movementSpeed\",Name:\"generic.movementSpeed\",Slot:\"offhand\",Amount:1.6,Operation:2,UUIDMost:13043,UUIDLeast:147969},{AttributeName:\"generic.attackSpeed\",Name:\"generic.attackSpeed\",Slot:\"offhand\",Amount:2,Operation:2,UUIDMost:14080,UUIDLeast:163727}]}", false, RWBYCreativeTabs.tab_rwbyitems);
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
    public static final Item coinjuane = new RWBYItem("coinjuane", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item coinnora = new RWBYItem("coinnora", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item coin_ren = new RWBYItem("coin_ren", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item coinqrow = new RWBYItem("coinqrow", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item coin_raven = new RWBYItem("coin_raven", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item coin_ragora = new RWBYItem("coin_ragora", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item rvnmask = new RWBYItem("rvnmask", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Amount:6,Operation:0,UUIDLeast:822742,UUIDMost:753903,Slot:\"head\"}]}", true, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item whtefng =  new RWBYItem("whtefng", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Amount:6,Operation:0,UUIDLeast:822742,UUIDMost:753903,Slot:\"head\"}]}", true, RWBYCreativeTabs.tab_rwbyitems);
    public static final Item rubyhood = new RWBYItem("rubyhood", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Amount:6,Operation:0,UUIDLeast:822742,UUIDMost:753903,Slot:\"head\"}]}", true, RWBYCreativeTabs.tab_rwbyitems);
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
            "rwbym:dustcrystal,rwbym:winddustcrystal,rwbym:firedustcrystal,rwbym:gravitydustcrystal,rwbym:waterdustcrystal,rwbym:lightdustcrystal,rwbym:icedustcrystal,rwbym:dustrock,rwbym:winddustrock,rwbym:firedustrock,rwbym:gravitydustrock,rwbym:waterdustrock,rwbym:lightdustrock,rwbym:icedustrock,rwbym:dust,rwbym:winddust,rwbym:firedust,rwbym:gravitydust,rwbym:waterdust,rwbym:lightdust,rwbym:icedust",
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
    		"rwbym:dustcrystal,rwbym:winddustcrystal,rwbym:firedustcrystal,rwbym:gravitydustcrystal,rwbym:waterdustcrystal,rwbym:lightdustcrystal,rwbym:icedustcrystal,rwbym:cr1,rwbym:cr2,rwbym:cr3,rwbym:cr4,rwbym:cr5,rwbym:cr6,rwbym:mytre1,rwbym:mytre2,rwbym:mytre3,rwbym:gam1,rwbym:gam2,rwbym:gam3,rwbym:em1,rwbym:em2,rwbym:em3,rwbym:cro1,rwbym:cro2,rwbym:cro3,rwbym:magn1,rwbym:magn2,rwbym:magn3,rwbym:magn4,rwbym:milo1,rwbym:milo2,rwbym:milo3,rwbym:stor1,rwbym:stor2,rwbym:stor3,rwbym:stor4,rwbym:stor5,rwbym:stor6,rwbym:scrap,rwbym:remnants,rwbym:dustrock,rwbym:winddustrock,rwbym:firedustrock,rwbym:gravitydustrock,rwbym:waterdustrock,rwbym:lightdustrock,rwbym:icedustrock,rwbym:dust,rwbym:winddust,rwbym:firedust,rwbym:gravitydust,rwbym:waterdust,rwbym:lightdust,rwbym:icedust,rwbym:lien1,rwbym:lien5,rwbym:lien10,rwbym:lien20,rwbym:lien50,rwbym:lien100,rwbym:lien500,rwbym:roseiron,rwbym:gildediron,rwbym:frostediron,rwbym:shadowiron,rwbym:viridianiron,rwbym:forestiron",
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
    public static final Item gamammo = new RWBYAmmoItem(
            "gamammo",
            RWBYItems.entitysmallbullet,
            64,
            false,
            RWBYAmmoItem.SurviveOnHit.NONE,
            "textures/entity/projectiles/tipped_arrow.png",
            true,
            false,
            null,
            null,
            1,
            4,
            RWBYCreativeTabs.tab_rwbyitems,
            null);
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
            4,
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
            4,
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
            4,
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
            4,
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
            null);
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
            null);
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
            null);
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
            15F,
            "pickaxe",
            1);
    public static final Block rwbyblock2 = new RWBYBlock(
            "fireore",
            Material.ROCK,
            RWBYCreativeTabs.tab_rwbyitems,
            5F,
            15F,
            "pickaxe",
            1);
    public static final Block rwbyblock3 = new RWBYBlock(
            "windore",
            Material.ROCK,
            RWBYCreativeTabs.tab_rwbyitems,
            5F,
            15F,
            "pickaxe",
            1);
    public static final Block rwbyblock4 = new RWBYBlock(
            "impureore",
            Material.ROCK,
            RWBYCreativeTabs.tab_rwbyitems,
            5F,
            15F,
            "pickaxe",
            1);
    public static final Block rwbyblock5 = new RWBYBlock(
            "waterore",
            Material.ROCK,
            RWBYCreativeTabs.tab_rwbyitems,
            5F,
            15F,
            "pickaxe",
            1);
    public static final Block rwbyblock6 = new RWBYBlock(
            "lightore",
            Material.ROCK,
            RWBYCreativeTabs.tab_rwbyitems,
            5F,
            15F,
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
            15F,
            "pickaxe",
            1);



    //Armour

    public static List<Item> ITEMS = new ArrayList();
    public static final ItemArmor.ArmorMaterial korekosmouOffMat;
    public static final ItemArmor.ArmorMaterial korekosmouFireMat;
    public static final ItemArmor.ArmorMaterial korekosmouWaterMat;
    public static final ItemArmor.ArmorMaterial korekosmouWindMat;
    public static final ItemArmor.ArmorMaterial RagoraMat = EnumHelper.addArmorMaterial("Ragora", "rwbym:ragora", 40, new int[]{0, 4, 4, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);

    public static final ItemArmor.ArmorMaterial QrowMat = EnumHelper.addArmorMaterial("Qrow", "rwbym:qrow", 40, new int[]{0, 4, 4, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);
    public static final ItemArmor QrowChest = new ArmourBase(QrowMat, 0, EntityEquipmentSlot.CHEST, "qrow_chest", null, null, true, RWBYCreativeTabs.tab_rwbyitems);
    public static final ItemArmor QrowLegs = new ArmourBase(QrowMat, 0, EntityEquipmentSlot.LEGS, "qrow_legs", null, null, true, RWBYCreativeTabs.tab_rwbyitems);

    public static final ItemArmor korekosmouoff;
    public static final ItemArmor korekosmoufire;
    public static final ItemArmor korekosmouwater;
    public static final ItemArmor korekosmouwind;
    public static final ItemArmor RagoraHead = new ArmourBase(RagoraMat, 0, EntityEquipmentSlot.HEAD, "ragora_head", null, null, true, RWBYCreativeTabs.tab_rwbyitems);
    public static final ItemArmor RagoraChest = new ArmourBase(RagoraMat, 0, EntityEquipmentSlot.CHEST, "ragora_chest", null, null, true, RWBYCreativeTabs.tab_rwbyitems);
    public static final ItemArmor RagoraLegs = new ArmourBase(RagoraMat, 0, EntityEquipmentSlot.LEGS, "ragora_legs", null, null, true, RWBYCreativeTabs.tab_rwbyitems);
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
        korekosmouOffMat = EnumHelper.addArmorMaterial("Kore Kosmou", "rwbym:korekosmou", 40, new int[]{0, 4, 4, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);
        korekosmouFireMat = EnumHelper.addArmorMaterial("Kore Kosmou Fire", "rwbym:korekosmoufire", 40, new int[]{0, 4, 4, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);
        korekosmouWaterMat = EnumHelper.addArmorMaterial("Kore Kosmou Water", "rwbym:korekosmouwater", 40, new int[]{0, 4, 4, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);
        korekosmouWindMat = EnumHelper.addArmorMaterial("Kore Kosmou Wind", "rwbym:korekosmouwind", 40, new int[]{0, 4, 4, 0}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);
        korekosmouoff = new ArmourBase(korekosmouOffMat, 0, EntityEquipmentSlot.CHEST, "korekosmouoff","rwbym:korekosmoufire", null, false, RWBYCreativeTabs.tab_rwbyweapons);
        korekosmoufire = new ArmourBase(korekosmouFireMat, 0, EntityEquipmentSlot.CHEST, "korekosmoufire","rwbym:korekosmouice",null, false, null);
        korekosmouwater = new ArmourBase(korekosmouWaterMat, 0, EntityEquipmentSlot.CHEST, "korekosmouice","rwbym:korekosmouwind", null, false, null);
        korekosmouwind = new ArmourBase(korekosmouWindMat, 0, EntityEquipmentSlot.CHEST, "korekosmouwind","rwbym:korekosmouoff", null, false, null);
        //starting_Leggings = new ArmourBase(startingMaterialA, 0, EntityEquipmentSlot.LEGS, "starting_Leggings");
    }

}
