package be.bluexin.rwbym.Init;

import be.bluexin.rwbym.blocks.*;
import be.bluexin.rwbym.weaponry.*;
import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

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
            3,
            true,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static final Item gambol = new RWBYSword(
            "gambol",
            2500,
            5,
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
            1250,
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
            1250,
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
            1250,
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
            1250,
            15,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:571090,UUIDMost:892303,Slot:\"mainhand\"}]}",
            "rwbym:qrowgun",
            "rwbym:ammmmo",
            false,
            2,
            true,
            0,
            null);
    public static final Item qrowsword = new RWBYSword(
            "qrowsword",
            1250,
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
            5,
            0,
            null,
            null,
            true,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static Item norahammer = new RWBYSword(
            "norahammer",
            2500,
            8,
            0,
            "{ench:[{id:19,lvl:2}]}",
            "rwbym:noragun",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static Item pyrrhaspear = new RWBYSword(
            "pyrrhaspear",
            2500,
            6,
            0,
            null,
            "rwbym:pyrrhasword",
            true,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static Item pyrrhasword = new RWBYSword(
            "pyrrhasword",
            2500,
            5,
            0,
            null,
            "rwbym:pyrrhaspear",
            true,
            false,
            false,
            false,
            0,
            null);
    public static Item velvet = new RWBYSword(
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
    public static Item crescentv = new RWBYCRScythe(
            "crescentv",
            1250,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:531774,UUIDMost:709040,Slot:\"mainhand\"},{AttributeName:\"generic.attackSpeed\",Name:\"generic.attackSpeed\",Amount:3,Operation:0,UUIDLeast:811643,UUIDMost:138699}]}",
            "rwbym:crescentgunv",
            "rwbym:ammov",
            false,
            3,
            false,
            1,
            null);
    public static Item weissv = new RWBYBow(
            "weissv",
            1250,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:10,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:gambolv",
            "rwbym:ammmmo",
            false,
            1,
            true,
            3,
            1,
            null);
    public static Item gambolv = new RWBYSword(
            "gambolv",
            1250,
            5,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:gambolgunv",
            false,
            false,
            false,
            false,
            1,
            null);
    public static Item juanev = new RWBYSword(
            "juanev",
            1250,
            5,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:norahammerv",
            false,
            false,
            false,
            false,
            1,
            null);
    public static Item norahammerv = new RWBYSword(
            "norahammerv",
            1250,
            8,
            0,
            "{ench:[{id:19,lvl:2}],HideFlags:3}",
            "rwbym:noragunv",
            false,
            false,
            false,
            false,
            1,
            null);
    public static Item pyrrhaspearv = new RWBYSword(
            "pyrrhaspearv",
            1250,
            6,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:pyrrhaswordv",
            true,
            false,
            false,
            false,
            1,
            null);
    public static Item pyrrhaswordv = new RWBYSword(
            "pyrrhaswordv",
            1250,
            5,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:stormflowerv",
            true,
            false,
            false,
            false,
            1,
            null);
    public static Item yatsuhashi = new RWBYSword(
            "yatsuhashi",
            1250,
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
    public static Item cocobag = new RWBYSword(
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
    public static Item fox = new RWBYSword(
            "fox",
            1250,
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
    public static Item cocobagv = new RWBYSword(
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
    public static Item winterswd = new RWBYSword(
            "winterswd",
            1250,
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
    public static Item pennyswd = new RWBYSword(
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
    public static Item ozpincane = new RWBYSword(
            "ozpincane",
            1250,
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
    public static Item port = new RWBYSword(
            "port",
            1250,
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
    public static Item kkfire = new RWBYSword(
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
    public static Item kkice = new RWBYSword(
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
    public static Item kkwind = new RWBYSword(
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
    public static Item torchwick = new RWBYSword(
            "torchwick",
            2500,
            6,
            0,
            null,
            "rwbym:torchwickgun",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static Item neoumb_closed = new RWBYSword(
            "neoumb_closed",
            2500,
            4,
            0,
            null,
            "rwbym:neoumb_closed_blade",
            false,
            true,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static Item neoumb_closed_blade = new RWBYSword(
            "neoumb_closed_blade",
            2500,
            6,
            0,
            null,
            "rwbym:neoumb_handle_blade",
            false,
            true,
            false,
            false,
            0,
           null);
    public static Item neoumb_handle_blade = new RWBYSword(
            "neoumb_handle_blade",
            2500,
            6,
            0,
            null,
            "rwbym:neoumb_closed",
            false,
            false,
            false,
            false,
            0,
            null);
    public static Item jnrbat = new RWBYSword(
            "jnrbat",
            2500,
            8,
            0,
            null,
            "rwbym:jnrrocket",
            false,
            true,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static Item adamswd = new RWBYSword(
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
    public static Item cinder = new RWBYSword(
            "cinder",
            2500,
            6,
            0,
            null,
            "rwbym:cinderbow",
            false,
            false,
            false,
            false,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);

    public static Item ozmacane = new RWBYStaff(
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
    public static Item ozmacanefire = new RWBYStaff(
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
    public static Item ozmacanegravity = new RWBYStaff(
            "ozmacanegravity",
            2500,
            12,
            0,
            null,
            null,
            false,
            true,
            null
    );    public static Item ozmacaneice = new RWBYStaff(
            "ozmacaneice",
            2500,
            12,
            0,
            null,
            null,
            false,
            true,
           null
    );    public static Item ozmacanelightning = new RWBYStaff(
            "ozmacanelightning",
            2500,
            12,
            0,
            null,
            null,
            false,
            true,
           null
    );    public static Item ozmacanewater = new RWBYStaff(
            "ozmacanewater",
            2500,
            12,
            0,
            null,
            null,
            false,
            true,
            null
    );    public static Item ozmacanewind = new RWBYStaff(
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
    public static Item mariacane = new RWBYSword(
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
    public static Item mariascythe = new RWBYCRScythe(
            "mariascythe",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:16,Operation:0,UUIDLeast:571090,UUIDMost:892303,Slot:\"mainhand\"}]}",
            "rwbym:mariascythedouble",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            8,
            true,
            0,
            null);
    public static Item mariascythedouble = new RWBYSword(
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
    //------------------------------------------------//

    public static Item crescentgun = new RWBYBow(
            "crescentgun",
            2500,
            72,
            0,
            null,
            "rwbym:crescent",
            "rwbym:crmag,rwbym:crfiremag,rwbym:crgravmag,rwbym:crelectricmag",
            false,
            3,
            true,
            1,
            0,
            null);
    public static Item weiss = new RWBYBow(
            "weiss",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:10,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            null,
            "rwbym:gravitydust,rwbym:winddust,rwbym:icedust,rwbym:waterdust,rwbym:firedust,rwbym:lightdust",
            false,
            1,
            true,
            3,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static Item crescentgunv = new RWBYBow(
            "crescentgunv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:emberv",
            "rwbym:ammov",
            false,
            3,
            true,
            1,
            1,
            null);
    public static Item ember = new RWBYBow(
            "ember",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:10,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:ember2",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            2,
            true,
            2,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static Item ember2 = new RWBYBow(
            "ember2",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:14,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:ember",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            2,
            true,
            2,
            0,
            null);
    public static Item gambolgun = new RWBYBow(
            "gambolgun",
            2500,
            72,
            0,
            null,
            "rwbym:gambol",
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            false,
            2,
            true,
            0,
            0,
            null);
    public static Item gambolgunv = new RWBYBow(
            "gambolgunv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:juanev",
            "rwbym:ammov",
            false,
            2,
            true,
            0,
            1,
            null);
    public static Item stormflower = new RWBYBow(
            "stormflower",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:10,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            null,
            "rwbym:gammag,rwbym:gamgravmag,rwbym:gamicemag,rwbym:gamfiremag",
            true,
            2,
            true,
            0,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static Item noragun = new RWBYBow(
            "noragun",
            2500,
            72,
            0,
            null,
            "rwbym:norahammer",
            "rwbym:magnammo,rwbym:magnaampammo",
            false,
            2,
            true,
            0,
            0,
            null);
    public static Item stormflowerv = new RWBYBow(
            "stormflowerv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3,AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:10,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:cocobagv",
            "rwbym:ammov",
            true,
            2,
            true,
            0,
            1,
            null);
    public static Item noragunv = new RWBYBow(
            "noragunv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:pyrrhaspearv",
            "rwbym:ammov",
            false,
            2,
            true,
            0,
            1,
            null);
    public static Item emberv = new RWBYBow(
            "emberv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3,AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:10,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:weissv",
            "rwbym:ammov",
            false,
            2,
            true,
            2,
            1,
            null);
    public static Item qrowgun = new RWBYBow(
            "qrowgun",
            1250,
            72,
            0,
            null,
            "rwbym:qrowsword",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            2,
            true,
            0,
            0,
            null);
    public static Item cocogun = new RWBYBow(
            "cocogun",
            1250,
            72,
            0,
            null,
            "rwbym:cocobag",
            "rwbym:ammmo",
            true,
            2,
            true,
            0,
            0,
            null);
    public static Item cocogunv = new RWBYBow(
            "cocogunv",
            1250,
            72,
            0,
            "{ench:[{id:51,lvl:1}],HideFlags:3}",
            "rwbym:velvet",
            "rwbym:ammmo",
            true,
            2,
            true,
            0,
            1,
            null);

    public static Item torchwickgun = new RWBYBow(
            "torchwickgun",
            2500,
            72,
            0,
            null,
            "rwbym:torchwick",
            "rwbym:emammmo,rwbym:emflareammo",
            false,
            2,
            true,
            0,
            0,
            null);
    public static Item portgun = new RWBYBow(
            "portgun",
            1250,
            72,
            0,
            null,
            "rwbym:port",
            "rwbym:emammo,rwbym:emammmo",
            false,
            2,
            true,
            0,
            0,
            null);
    public static Item emeraldgun = new RWBYBow(
            "emeraldgun",
            2500,
            72,
            0,
            null,
            "rwbym:emeraldblade",
            "rwbym:gamammo,rwbym:emammmo",
            false,
            2,
            true,
            0,
            0,
            RWBYCreativeTabs.tab_rwbyweapons);
    public static Item emeraldblade = new RWBYBow(
            "emeraldblade",
            2500,
            72,
            0,
            "{AttributeModifiers:[{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"mainhand\",Amount:10,Operation:0,UUIDMost:99791,UUIDLeast:128916}]}",
            "rwbym:emeraldgun",
            "rwbym:gamammo,rwbym:emammmo",
            false,
            2,
            true,
            0,
            0,
            null);
    public static Item jnrrocket = new RWBYBow(
            "jnrrocket",
            1250,
            72,
            0,
            null,
            "rwbym:jnrbat",
            "rwbym:jnrammo",
            false,
            2,
            true,
            0,
            0,
            null);
    public static Item cinderbow = new RWBYBow(
            "cinderbow",
            2500,
            72,
            0,
            null,
            "rwbym:cinder",
            "minecraft:arrow,minecraft:tipped_arrow",
            false,
            3,
            true,
            0,
            0,
            null);
    public static Item adamgun = new RWBYBow(
            "adamgun",
            2500,
            72,
            0,
            null,
            "rwbym:adamswd",
            "rwbym:emammo,rwbym:emfireammo,rwbym:emflareammo",
            false,
            2,
            true,
            0,
            0,
            null);

    //------------------------------------------------//
    public static Item ammo = new RWBYItem("ammo", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item magngrenade = new RWBYItem("magngrenade", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item emshell = new RWBYItem("emshell", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item emflareshell = new RWBYItem("emflareshell", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item emfireshell = new RWBYItem("emfireshell", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item dustcrystal = new RWBYItem("dustcrystal", "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.50,Operation:2,UUIDMost:74685,UUIDLeast:155127},{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"offhand\",Amount:10,Operation:0,UUIDMost:32503,UUIDLeast:164819}]}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item winddustcrystal = new RWBYItem("winddustcrystal", "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.50,Operation:2,UUIDMost:74685,UUIDLeast:155127},{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"offhand\",Amount:10,Operation:0,UUIDMost:32503,UUIDLeast:164819},{AttributeName:\"generic.movementSpeed\",Name:\"generic.movementSpeed\",Slot:\"offhand\",Amount:2,Operation:2,UUIDMost:78095,UUIDLeast:122333}]}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item firedustcrystal = new RWBYItem("firedustcrystal", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"offhand\",Amount:10,Operation:0,UUIDMost:32503,UUIDLeast:164819},{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.5,Operation:2,UUIDMost:25912,UUIDLeast:178428},{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Slot:\"offhand\",Amount:3,Operation:2,UUIDMost:87232,UUIDLeast:139412}]}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item gravitydustcrystal = new RWBYItem("gravitydustcrystal", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"offhand\",Amount:10,Operation:0,UUIDMost:32503,UUIDLeast:164819},{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.5,Operation:2,UUIDMost:25912,UUIDLeast:178428}],display:{Lore:[\"Slow Falling and Negate Fall Damage While in offhand.\"]}}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item waterdustcrystal = new RWBYItem("waterdustcrystal", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"offhand\",Amount:10,Operation:0,UUIDMost:32503,UUIDLeast:164819},{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.5,Operation:2,UUIDMost:83653,UUIDLeast:157522}],display:{Lore:[\"Regeneration While in Off-Hand.\"]}}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item lightdustcrystal = new RWBYItem("lightdustcrystal", "{AttributeModifiers:[{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:-0.50,Operation:2,UUIDMost:17934,UUIDLeast:125321},{AttributeName:\"generic.movementSpeed\",Name:\"generic.movementSpeed\",Slot:\"offhand\",Amount:1.6,Operation:2,UUIDMost:13043,UUIDLeast:147969},{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"offhand\",Amount:10,Operation:0,UUIDMost:28194,UUIDLeast:149045},{AttributeName:\"generic.attackSpeed\",Name:\"generic.attackSpeed\",Slot:\"offhand\",Amount:2,Operation:2,UUIDMost:14080,UUIDLeast:163727}]}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item icedustcrystal = new RWBYItem("icedustcrystal", " {AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Slot:\"offhand\",Amount:10,Operation:0,UUIDMost:32503,UUIDLeast:164819},{AttributeName:\"generic.movementSpeed\",Name:\"generic.movementSpeed\",Slot:\"offhand\",Amount:-0.3,Operation:2,UUIDMost:79372,UUIDLeast:112384},{AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\",Slot:\"offhand\",Amount:0.5,Operation:2,UUIDMost:25912,UUIDLeast:178428}]}", false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item dustrock = new RWBYItem("dustrock", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item dust = new RWBYItem("dust", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item winddustrock = new RWBYItem("winddustrock", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item firedustrock = new RWBYItem("firedustrock", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item gravitydustrock = new RWBYItem("gravitydustrock", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item waterdustrock = new RWBYItem("waterdustrock", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item lightdustrock = new RWBYItem("lightdustrock", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item icedustrock = new RWBYItem("icedustrock", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item roseiron = new RWBYItem("roseiron", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item gildediron = new RWBYItem("gildediron", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item frostediron = new RWBYItem("frostediron", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item shadowiron = new RWBYItem("shadowiron", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item cr1 = new RWBYItem("cr1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item cr2 = new RWBYItem("cr2", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item cr3 = new RWBYItem("cr3", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item cr4 = new RWBYItem("cr4", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item cr5 = new RWBYItem("cr5", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item cr6 = new RWBYItem("cr6", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item mytre1 = new RWBYItem("mytre1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item mytre2 = new RWBYItem("mytre2", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item mytre3 = new RWBYItem("mytre3", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item gam1 = new RWBYItem("gam1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item gam2 = new RWBYItem("gam2", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item gam3 = new RWBYItem("gam3", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item em1 = new RWBYItem("em1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item em2 = new RWBYItem("em2", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item em3 = new RWBYItem("em3", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item cro1 = new RWBYItem("cro1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item cro2 = new RWBYItem("cro2", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item cro3 = new RWBYItem("cro3", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item magn1 = new RWBYItem("magn1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item magn2 = new RWBYItem("magn2", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item magn3 = new RWBYItem("magn3", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item magn4 = new RWBYItem("magn4", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item milo1 = new RWBYItem("milo1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item milo2 = new RWBYItem("milo2", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item milo3 = new RWBYItem("milo3", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item stor1 = new RWBYItem("stor1", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item stor2 = new RWBYItem("stor2", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item stor3 = new RWBYItem("stor3", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item stor4 = new RWBYItem("stor4", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item stor5 = new RWBYItem("stor5", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item stor6 = new RWBYItem("stor6", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item scrap = new RWBYItem("scrap", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item atlasknight = new RWBYItem("atlasknight", null, false, RWBYCreativeTabs.tab_rwbyitems);
    public static Item rvnmask = new RWBYItem("rvnmask", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Amount:6,Operation:0,UUIDLeast:822742,UUIDMost:753903,Slot:\"head\"}]}", true, RWBYCreativeTabs.tab_rwbyitems);
    public static Item whtefng =  new RWBYItem("whtefng", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Amount:6,Operation:0,UUIDLeast:822742,UUIDMost:753903,Slot:\"head\"}]}", true, RWBYCreativeTabs.tab_rwbyitems);
    public static Item rubyhood = new RWBYItem("rubyhood", "{AttributeModifiers:[{AttributeName:\"generic.armor\",Name:\"generic.armor\",Amount:6,Operation:0,UUIDLeast:822742,UUIDMost:753903,Slot:\"head\"}]}", true, RWBYCreativeTabs.tab_rwbyitems);
    //------------------------------------------------//
    public static Item gamammo = new RWBYAmmoItem(
            "gamammo",
            64,
            false,
            "textures/entity/projectiles/tipped_arrow.png",
            4,
            true,
            false,
            null,
            null,
            1,
            4,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item gammag = new RWBYAmmoItem(
            "gammag",
            1,
            false,
            "textures/entity/projectiles/tipped_arrow.png",
            4,
            true,
            false,
            null,
            null,
            32,
            4,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item gamfiremag = new RWBYAmmoItem(
            "gamfiremag",
            1,
            false,
            "textures/entity/projectiles/tipped_arrow.png",
            4,
            true,
            false,
            "{Passengers:[{id:\"rwbym:fireball\",ExplosionPower:1}]}",
            null,
            32,
            4,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item gamicemag = new RWBYAmmoItem(
            "gamicemag",
            1,
            false,
            "textures/entity/projectiles/tipped_arrow.png",
            4,
            true,
            false,
            null,
            "minecraft:slowness*5*900",
            32,
            4,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item gamgravmag = new RWBYAmmoItem(
            "gamgravmag",
            1,
            false,
            "textures/entity/projectiles/tipped_arrow.png",
            4,
            true,
            false,
            null,
            "minecraft:levitation*2*100",
            32,
            4,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item emammo = new RWBYAmmoItem(
            "emammo",
            1,
            false,
            "textures/entity/projectiles/tipped_arrow.png",
            8,
            true,
            false,
            null,
            null,
            12,
            8,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item emfireammo = new RWBYAmmoItem(
            "emfireammo",
            1,
            false,
            "textures/entity/projectiles/tipped_arrow.png",
            8,
            true,
            false,
            "{Passengers:[{id:\"rwbym:fireball\",ExplosionPower:1}]}",
            null,
            12,
            8,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item emflareammo = new RWBYAmmoItem(
            "emflareammo",
            1,
            false,
            "textures/entity/projectiles/tipped_arrow.png",
            8,
            true,
            false,
            "{Passengers:[{id:\"rwbym:largefireball\",ExplosionPower:1}]}",
            null,
            12,
            8,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item crmag = new RWBYAmmoItem(
            "crmag",
            1,
            false,
            "textures/entity/projectiles/tipped_arrow.png",
            10,
            true,
            false,
            null,
            null,
            12,
            10,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item crgravmag = new RWBYAmmoItem(
            "crgravmag",
            1,
            false,
            "textures/entity/projectiles/tipped_arrow.png",
            10,
            true,
            false,
            null,
            "minecraft:levitation*2*100",
            12,
            10,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item crfiremag = new RWBYAmmoItem(
            "crfiremag",
            1,
            false,
            "textures/entity/projectiles/tipped_arrow.png",
            10,
            true,
            false,
            "{Passengers:[{id:\"rwbym:fireball\",ExplosionPower:1}]}",
            null,
            12,
            10,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item crelectricmag = new RWBYAmmoItem(
            "crelectricmag",
            1,
            false,
            "textures/entity/projectiles/tipped_arrow.png",
            10,
            true,
            false,
            null,
            "minecraft:slowness*20*900",
            12,
            10,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item magnammo = new RWBYAmmoItem(
            "magnammo",
            1,
            false,
            "textures/entity/projectiles/tipped_arrow.png",
            4,
            true,
            false,
            "{Passengers:[{id:\"rwbym:largefireball\",ExplosionPower:3}]}",
            null,
            6,
            4,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item waterdust = new RWBYAmmoItem(
            "waterdust",
            64,
            false,
            "textures/entity/projectiles/tipped_arrow2.png",
            0,
            true,
            false,
            "{Passengers:[{id:\"potion\",Potion:{id:\"minecraft:splash_potion\",Count:1,tag:{CustomPotionEffects:[{Id:22,Amplifier:2,Duration:100}]}}}]}",
            null,
            1,
            0,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item winddust = new RWBYAmmoItem(
            "winddust",
            64,
            false,
            "textures/entity/projectiles/tipped_arrow2.png",
            0,
            true,
            false,
            "{Passengers:[{id:\"potion\",Potion:{id:\"minecraft:lingering_potion\",Count:1,tag:{CustomPotionEffects:[{Id:1,Amplifier:5,Duration:80},{Id:8,Amplifier:3,Duration:100,ShowParticles:0b}]}}}]}",
            null,
            1,
            0,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item firedust = new RWBYAmmoItem(
            "firedust",
            64,
            false,
            "textures/entity/projectiles/tipped_arrow2.png",
            5,
            true,
            false,
            "{Passengers:[{id:\"rwbym:fireball\",ExplosionPower:1}]}",
            null,
            1,
            5,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item icedust = new RWBYAmmoItem(
            "icedust",
            64,
            false,
            "textures/entity/projectiles/tipped_arrow3.png",
            5,
            true,
            false,
            null,
            "minecraft:slowness*20*900",
            1,
            5,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item lightdust = new RWBYAmmoItem(
            "lightdust",
            64,
            false,
            "textures/entity/projectiles/tipped_arrow4.png",
            5,
            true,
            false,
            null,
            "minecraft:speed*2*400",
            1,
            5,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item gravitydust = new RWBYAmmoItem(
            "gravitydust",
            64,
            false,
            "textures/entity/projectiles/tipped_arrow2.png",
            5,
            true,
            false,
            "{Passengers:[{id:\"potion\",Potion:{id:\"minecraft:lingering_potion\",Count:1,tag:{CustomPotionEffects:[{Id:25,Amplifier:3,Duration:60,ShowParticles:0b}]}}}]}",
            null,
            1,
            5,
            RWBYCreativeTabs.tab_rwbyitems);
    public static Item jnrammo = new RWBYAmmoItem(
            "jnrammo",
            1,
            false,
            "textures/entity/projectiles/tipped_arrow.png",
            4,
            true,
            true,
            "{Passengers:[{id:\"rwbym:largefireball\",ExplosionPower:3}]}",
            null,
            6,
            4,
            null);
    public static Item ammov = new RWBYAmmoItem(
            "ammov",
            1,
            false,
            "textures/entity/projectiles/tipped_arrow1.png",
            2,
            true,
            true,
            null,
            null,
            1,
            2,
            null);
    public static Item ammmo = new RWBYAmmoItem(
            "ammmo",
            1,
            false,
            "textures/entity/projectiles/tipped_arrow.png",
            1,
            true,
            true,
            null,
            null,
            1,
            1,
            null);


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
    public static ItemArmor.ArmorMaterial korekosmouOffMat;
    public static ItemArmor.ArmorMaterial korekosmouFireMat;
    public static ItemArmor.ArmorMaterial korekosmouWaterMat;
    public static ItemArmor.ArmorMaterial korekosmouWindMat;
    public static ItemArmor korekosmouoff;
    public static ItemArmor korekosmoufire;
    public static ItemArmor korekosmouwater;
    public static ItemArmor korekosmouwind;
    //public static ItemArmor starting_Leggings;
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

    public static Item addItem(Item item) {
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
        korekosmouoff = new ArmourBase(korekosmouOffMat, 0, EntityEquipmentSlot.CHEST, "korekosmouoff","rwbym:korekosmoufire", null, RWBYCreativeTabs.tab_rwbyweapons);
        korekosmoufire = new ArmourBase(korekosmouFireMat, 0, EntityEquipmentSlot.CHEST, "korekosmoufire","rwbym:korekosmouice",null, null);
        korekosmouwater = new ArmourBase(korekosmouWaterMat, 0, EntityEquipmentSlot.CHEST, "korekosmouice","rwbym:korekosmouwind", null, null);
        korekosmouwind = new ArmourBase(korekosmouWindMat, 0, EntityEquipmentSlot.CHEST, "korekosmouwind","rwbym:korekosmouoff", null, null);
        //starting_Leggings = new ArmourBase(startingMaterialA, 0, EntityEquipmentSlot.LEGS, "starting_Leggings");
    }

}
