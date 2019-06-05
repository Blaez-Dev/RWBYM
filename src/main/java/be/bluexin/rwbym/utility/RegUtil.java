package be.bluexin.rwbym.utility;

import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.Init.RWBYPotions;
import be.bluexin.rwbym.potion.PotionAuraRegen;
import be.bluexin.rwbym.weaponry.RWBYItem;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;


public class RegUtil {
    public static void registerAll(FMLPreInitializationEvent event){
        //icon
        registerItems(event, RWBYItems.icon);
        registerItems(event, RWBYItems.signcrow);
        registerItems(event, RWBYItems.signdust);
        //entity models
        registerItems(event, RWBYItems.entitybullet);
        registerItems(event, RWBYItems.entityfireshell);
        registerItems(event, RWBYItems.entityflareshell);
        registerItems(event, RWBYItems.entityshell);
        registerItems(event, RWBYItems.entitysmallbullet);
        registerItems(event, RWBYItems.entitygrenade);
        registerItems(event, RWBYItems.entitybulletv);
        registerItems(event, RWBYItems.entityweissfire);
        registerItems(event, RWBYItems.entityweissgravity);
        registerItems(event, RWBYItems.entityweissice);
        registerItems(event, RWBYItems.entityweisslight);
        registerItems(event, RWBYItems.entityweisswater);
        registerItems(event, RWBYItems.entityweisswind);
        registerItems(event, RWBYItems.entityrocket);
        //dust blocks
        registerBlocks(event, RWBYItems.rwbyblock1);
        registerBlocks(event, RWBYItems.rwbyblock2);
        registerBlocks(event, RWBYItems.rwbyblock3);
        registerBlocks(event, RWBYItems.rwbyblock4);
        registerBlocks(event, RWBYItems.rwbyblock5);
        registerBlocks(event, RWBYItems.rwbyblock6);
        registerBlocks(event, RWBYItems.rwbyblock9);
        //weapons
        registerItems(event, RWBYItems.crescent);
        registerItems(event, RWBYItems.crescentfrost);
        registerItems(event, RWBYItems.crescentgunfrost);
        registerItems(event, RWBYItems.weiss);
        registerItems(event, RWBYItems.gambol);
        registerItems(event, RWBYItems.ember);
        registerItems(event, RWBYItems.ember2);
        registerItems(event, RWBYItems.juane);
        registerItems(event, RWBYItems.norahammer);
        registerItems(event, RWBYItems.pyrrhaspear);
        registerItems(event, RWBYItems.pyrrhasword);
        registerItems(event, RWBYItems.pyrrharifle);
        registerItems(event, RWBYItems.stormflower);
        registerItems(event, RWBYItems.rvnswd);
        registerItems(event, RWBYItems.rvnswdele);
        registerItems(event, RWBYItems.rvnswdice);
        registerItems(event, RWBYItems.qrow);
        registerItems(event, RWBYItems.qrowsword);
        registerItems(event, RWBYItems.cocobag);
        registerItems(event, RWBYItems.fox);
        registerItems(event, RWBYItems.velvet);
        registerItems(event, RWBYItems.yatsuhashi);
        registerItems(event, RWBYItems.crescentv);
        registerItems(event, RWBYItems.weissv);
        registerItems(event, RWBYItems.gambolv);
        registerItems(event, RWBYItems.juanev);
        registerItems(event, RWBYItems.norahammerv);
        registerItems(event, RWBYItems.pyrrhaspearv);
        registerItems(event, RWBYItems.pyrrhaswordv);
        registerItems(event, RWBYItems.cocobagv);
        registerItems(event, RWBYItems.crescentgun);
        registerItems(event, RWBYItems.crescentgunv);
        registerItems(event, RWBYItems.gambolgun);
        registerItems(event, RWBYItems.gambolgunv);
        registerItems(event, RWBYItems.noragun);
        registerItems(event, RWBYItems.stormflowerv);
        registerItems(event, RWBYItems.noragunv);
        registerItems(event, RWBYItems.emberv);
        registerItems(event, RWBYItems.qrowgun);
        registerItems(event, RWBYItems.cocogun);
        registerItems(event, RWBYItems.cocogunv);
        registerItems(event, RWBYItems.ozpincane);
        registerItems(event, RWBYItems.port);
        registerItems(event, RWBYItems.portgun);
        registerItems(event, RWBYItems.jnrbat);
        registerItems(event, RWBYItems.jnrrocket);
        registerItems(event, RWBYItems.adamgun);
        registerItems(event, RWBYItems.adamswd);
        registerItems(event, RWBYItems.torchwick);
        registerItems(event, RWBYItems.torchwickgun);
        registerItems(event, RWBYItems.neoumb_closed);
        registerItems(event, RWBYItems.neoumb_closed_blade);
        registerItems(event, RWBYItems.neoumb_handle_blade);
        registerItems(event, RWBYItems.cinder);
        registerItems(event, RWBYItems.cinderbow);
        registerItems(event, RWBYItems.emeraldblade);
        registerItems(event, RWBYItems.emeraldgun);
        registerItems(event, RWBYItems.ironwood);
        registerItems(event, RWBYItems.winterswd);
        registerItems(event, RWBYItems.pennyswd);
        registerItems(event, RWBYItems.kkfire);
        registerItems(event, RWBYItems.kkice);
        registerItems(event, RWBYItems.kkwind);
        registerItems(event, RWBYItems.korekosmouoff);
        registerItems(event, RWBYItems.korekosmoufire);
        registerItems(event, RWBYItems.korekosmouwater);
        registerItems(event, RWBYItems.korekosmouwind);
        registerItems(event, RWBYItems.razorbolt);
        registerItems(event, RWBYItems.razorboltknife);
        registerItems(event, RWBYItems.chatareus);
        registerItems(event, RWBYItems.chatareusgun);
        registerItems(event, RWBYItems.hexen);
        registerItems(event, RWBYItems.hexenaxe);
        registerItems(event, RWBYItems.magnumgun);
        registerItems(event, RWBYItems.magnumsword);
        registerItems(event, RWBYItems.mariacane);
        registerItems(event, RWBYItems.mariascythe);
        registerItems(event, RWBYItems.mariascythedouble);
        registerItems(event, RWBYItems.armasword);
        registerItems(event, RWBYItems.armaswordsummon);
        registerItems(event, RWBYItems.angelcane);
        registerItems(event, RWBYItems.angelsword);
        registerItems(event, RWBYItems.ozmacane);
        registerItems(event, RWBYItems.ozmacanefire);
        registerItems(event, RWBYItems.ozmacanegravity);
        registerItems(event, RWBYItems.ozmacaneice);
        registerItems(event, RWBYItems.ozmacanelightning);
        registerItems(event, RWBYItems.ozmacanewater);
        registerItems(event, RWBYItems.ozmacanewind);
        registerItems(event, RWBYItems.sunnunchuck);
        registerItems(event, RWBYItems.sunstaff);
        registerItems(event, RWBYItems.sage);
        registerItems(event, RWBYItems.scarletsword);
        registerItems(event, RWBYItems.neptunegun);
        registerItems(event, RWBYItems.neptunespear);
        registerItems(event, RWBYItems.neptunetrident);
        registerItems(event, RWBYItems.arslan);
        registerItems(event, RWBYItems.bolin);
        registerItems(event, RWBYItems.bolinblade);
        registerItems(event, RWBYItems.reese);
        registerItems(event, RWBYItems.reesegun);
        registerItems(event, RWBYItems.nadirgun);
        registerItems(event, RWBYItems.nadirsword);
        //dust items
        registerItems(event, RWBYItems.dustcrystal);
        registerItems(event, RWBYItems.firedustcrystal);
        registerItems(event, RWBYItems.winddustcrystal);
        registerItems(event, RWBYItems.waterdustcrystal);
        registerItems(event, RWBYItems.gravitydustcrystal);
        registerItems(event, RWBYItems.lightdustcrystal);
        registerItems(event, RWBYItems.icedustcrystal);
        registerItems(event, RWBYItems.dustrock);
        registerItems(event, RWBYItems.winddustrock);
        registerItems(event, RWBYItems.firedustrock);
        registerItems(event, RWBYItems.gravitydustrock);
        registerItems(event, RWBYItems.waterdustrock);
        registerItems(event, RWBYItems.lightdustrock);
        registerItems(event, RWBYItems.icedustrock);
        registerItems(event, RWBYItems.waterdust);
        registerItems(event, RWBYItems.winddust);
        registerItems(event, RWBYItems.firedust);
        registerItems(event, RWBYItems.icedust);
        registerItems(event, RWBYItems.lightdust);
        registerItems(event, RWBYItems.gravitydust);
        registerItems(event, RWBYItems.dust);
        registerBlocks(event, RWBYItems.waterblock);
        registerBlocks(event, RWBYItems.windblock);
        registerBlocks(event, RWBYItems.fireblock);
        registerBlocks(event, RWBYItems.iceblock);
        registerBlocks(event, RWBYItems.lightblock);
        registerBlocks(event, RWBYItems.gravityblock);
        registerBlocks(event, RWBYItems.impureblock);
        //entity spawning items
        registerItems(event, RWBYItems.atlasknight);
        registerItems(event, RWBYItems.armagigas);
        //colored iron
        registerItems(event, RWBYItems.roseiron);
        registerItems(event, RWBYItems.frostediron);
        registerItems(event, RWBYItems.shadowiron);
        registerItems(event, RWBYItems.gildediron);
        registerItems(event, RWBYItems.viridianiron);
        registerItems(event, RWBYItems.forestiron);
        registerBlocks(event, RWBYItems.roseironblock);
        registerBlocks(event, RWBYItems.frostedironblock);
        registerBlocks(event, RWBYItems.shadowironblock);
        registerBlocks(event, RWBYItems.gildedironblock);
        registerBlocks(event, RWBYItems.viridianironblock);
        registerBlocks(event, RWBYItems.forestironblock);
        //semblance coins
        registerItems(event, RWBYItems.coinr);
        registerItems(event, RWBYItems.coinw);
        registerItems(event, RWBYItems.coinb);
        registerItems(event, RWBYItems.coiny);
        registerItems(event, RWBYItems.coinjaune);
        registerItems(event, RWBYItems.coinnora);
        registerItems(event, RWBYItems.coin_ren);
        registerItems(event, RWBYItems.coin_ragora);
        //registerItems(event, RWBYItems.coinqrow);
        //registerItems(event, RWBYItems.coin_raven);
        registerItems(event, RWBYItems.scroll);
        registerItems(event, RWBYItems.scroll2);
        //lien items
        registerItems(event, RWBYItems.lien1);
        registerItems(event, RWBYItems.lien5);
        registerItems(event, RWBYItems.lien10);
        registerItems(event, RWBYItems.lien20);
        registerItems(event, RWBYItems.lien50);
        registerItems(event, RWBYItems.lien100);
        registerItems(event, RWBYItems.lien500);
        registerItems(event, RWBYItems.wallet);
        registerItems(event, RWBYItems.dustpouch);
        registerItems(event, RWBYItems.partspouch);
        registerItems(event, RWBYItems.container);
        //food
        registerItems(event, RWBYItems.hchoc);
        registerItems(event, RWBYItems.coffee);
        registerItems(event, RWBYItems.sunrise);
        registerItems(event, RWBYItems.plg);
        registerItems(event, RWBYItems.torchquick);
        registerItems(event, RWBYItems.qrowflask);
        registerItems(event, RWBYItems.sake);
        registerItems(event, RWBYItems.coconutmilk);
        registerItems(event, RWBYItems.pancakes);
        registerItems(event, RWBYItems.bourbon);
        registerItems(event, RWBYItems.brandy);
        registerItems(event, RWBYItems.vodka);
        registerItems(event, RWBYItems.wine);
        registerItems(event, RWBYItems.fishramen);
        registerItems(event, RWBYItems.ramen);
        //repair items
        registerBlocks(event, RWBYItems.rwbyblock8);
        registerItems(event, RWBYItems.scrap);
        //ammo
        registerItems(event, RWBYItems.ammo);
        registerItems(event, RWBYItems.gamammo);
        registerItems(event, RWBYItems.emshell);
        registerItems(event, RWBYItems.emfireshell);
        registerItems(event, RWBYItems.emflareshell);
        registerItems(event, RWBYItems.magngrenade);
        registerItems(event, RWBYItems.gammag);
        registerItems(event, RWBYItems.gamfiremag);
        registerItems(event, RWBYItems.gamicemag);
        registerItems(event, RWBYItems.gamgravmag);
        registerItems(event, RWBYItems.emammo);
        registerItems(event, RWBYItems.emfireammo);
        registerItems(event, RWBYItems.emflareammo);
        registerItems(event, RWBYItems.crmag);
        registerItems(event, RWBYItems.crgravmag);
        registerItems(event, RWBYItems.crfiremag);
        registerItems(event, RWBYItems.crelectricmag);
        registerItems(event, RWBYItems.magnammo);
        registerItems(event, RWBYItems.chatmag);
        registerItems(event, RWBYItems.chatelectricmag);
        registerItems(event, RWBYItems.chatfiremag);
        registerItems(event, RWBYItems.chatgravmag);
        registerItems(event, RWBYItems.neptammo);
        registerItems(event, RWBYItems.jnrammo);
        registerItems(event, RWBYItems.ammov);
        registerItems(event, RWBYItems.ammmo);
        registerItems(event, RWBYItems.rzrbolt);
        registerItems(event, RWBYItems.ragorafireball);
        //mob drops
        registerItems(event, RWBYItems.remnants);
        registerItems(event, RWBYItems.cr1);
        registerItems(event, RWBYItems.cr2);
        registerItems(event, RWBYItems.cr3);
        registerItems(event, RWBYItems.cr4);
        registerItems(event, RWBYItems.cr5);
        registerItems(event, RWBYItems.cr6);
        registerItems(event, RWBYItems.mytre1);
        registerItems(event, RWBYItems.mytre2);
        registerItems(event, RWBYItems.mytre3);
        registerItems(event, RWBYItems.gam1);
        registerItems(event, RWBYItems.gam2);
        registerItems(event, RWBYItems.gam3);
        registerItems(event, RWBYItems.em1);
        registerItems(event, RWBYItems.em2);
        registerItems(event, RWBYItems.em3);
        registerItems(event, RWBYItems.cro1);
        registerItems(event, RWBYItems.cro2);
        registerItems(event, RWBYItems.cro3);
        registerItems(event, RWBYItems.magn1);
        registerItems(event, RWBYItems.magn2);
        registerItems(event, RWBYItems.magn3);
        registerItems(event, RWBYItems.magn4);
        registerItems(event, RWBYItems.milo1);
        registerItems(event, RWBYItems.milo2);
        registerItems(event, RWBYItems.milo3);
        registerItems(event, RWBYItems.stor1);
        registerItems(event, RWBYItems.stor2);
        registerItems(event, RWBYItems.stor3);
        registerItems(event, RWBYItems.stor4);
        registerItems(event, RWBYItems.stor5);
        registerItems(event, RWBYItems.stor6);
        registerBlocks(event, RWBYItems.rwbyblock7);
        //armor
        registerItems(event, RWBYItems.whtefng);
        registerItems(event, RWBYItems.RagoraHead);
        registerItems(event, RWBYItems.RagoraChest);
        registerItems(event, RWBYItems.RagoraLegs);
        registerItems(event, RWBYItems.QrowChest);
        registerItems(event, RWBYItems.QrowLegs);
        registerItems(event, RWBYItems.Juane1Chest);
        registerItems(event, RWBYItems.Juane1Legs);
        registerItems(event, RWBYItems.Weiss1Chest);
        registerItems(event, RWBYItems.Weiss1Legs);
        registerItems(event, RWBYItems.AdamChest);
        registerItems(event, RWBYItems.AdamLegs);
        registerItems(event, RWBYItems.AtlasHead);
        registerItems(event, RWBYItems.AtlasChest);
        registerItems(event, RWBYItems.AtlasLegs);
        registerItems(event, RWBYItems.BeaconChest);
        registerItems(event, RWBYItems.BeaconLegs);
        registerItems(event, RWBYItems.Beacon1Chest);
        registerItems(event, RWBYItems.Beacon1Legs);
        registerItems(event, RWBYItems.Blake1Chest);
        registerItems(event, RWBYItems.Blake1Legs);
        registerItems(event, RWBYItems.Blake2Chest);
        registerItems(event, RWBYItems.Blake2Legs);
        registerItems(event, RWBYItems.Blake3Chest);
        registerItems(event, RWBYItems.Blake3Legs);
        registerItems(event, RWBYItems.AmberChest);
        registerItems(event, RWBYItems.AmberLegs);
        registerItems(event, RWBYItems.Cinder1Chest);
        registerItems(event, RWBYItems.Cinder1Legs);
        registerItems(event, RWBYItems.Cinder2Chest);
        registerItems(event, RWBYItems.Cinder2Legs);
        registerItems(event, RWBYItems.Cinder3Chest);
        registerItems(event, RWBYItems.Cinder3Legs);
        registerItems(event, RWBYItems.CocoHead);
        registerItems(event, RWBYItems.CocoChest);
        registerItems(event, RWBYItems.CocoLegs);
        registerItems(event, RWBYItems.Emerald1Chest);
        registerItems(event, RWBYItems.Emerald1Legs);
        registerItems(event, RWBYItems.Emerald2Chest);
        registerItems(event, RWBYItems.Emerald2Legs);
        registerItems(event, RWBYItems.pennyChest);
        registerItems(event, RWBYItems.pennyLegs);
        registerItems(event, RWBYItems.pyrrhaChest);
        registerItems(event, RWBYItems.pyrrhaLegs);
        registerItems(event, RWBYItems.rvnmask);
        registerItems(event, RWBYItems.ravenChest);
        registerItems(event, RWBYItems.ravenLegs);
        registerItems(event, RWBYItems.ruby1Chest);
        registerItems(event, RWBYItems.ruby1Legs);
        registerItems(event, RWBYItems.rubyhood);
        registerItems(event, RWBYItems.ruby2Chest);
        registerItems(event, RWBYItems.ruby2Legs);
        registerItems(event, RWBYItems.ruby3Chest);
        registerItems(event, RWBYItems.ruby3Legs);
        registerItems(event, RWBYItems.salemChest);
        registerItems(event, RWBYItems.salemLegs);
        registerItems(event, RWBYItems.velvetChest);
        registerItems(event, RWBYItems.velvetLegs);
        registerItems(event, RWBYItems.weiss2Chest);
        registerItems(event, RWBYItems.weiss2Legs);
        registerItems(event, RWBYItems.weiss3Chest);
        registerItems(event, RWBYItems.weiss3Legs);
        registerItems(event, RWBYItems.winterChest);
        registerItems(event, RWBYItems.winterLegs);
        registerItems(event, RWBYItems.yang1Chest);
        registerItems(event, RWBYItems.yang1Legs);
        registerItems(event, RWBYItems.yang2Chest);
        registerItems(event, RWBYItems.yang2Legs);
        registerItems(event, RWBYItems.yang3Chest);
        registerItems(event, RWBYItems.yang3Legs);
        registerItems(event, RWBYItems.yang4Chest);
        registerItems(event, RWBYItems.yang4Legs);
        registerItems(event, RWBYItems.ironwood1Chest);
        registerItems(event, RWBYItems.ironwood1Legs);
        registerItems(event, RWBYItems.ironwood2Chest);
        registerItems(event, RWBYItems.ironwood2Legs);
        registerItems(event, RWBYItems.mercury1Chest);
        registerItems(event, RWBYItems.mercury1Legs);
        registerItems(event, RWBYItems.mercury2Chest);
        registerItems(event, RWBYItems.mercury2Legs);
        registerItems(event, RWBYItems.ozpinChest);
        registerItems(event, RWBYItems.ozpinLegs);
    }
    private static void registerBlocks(FMLPreInitializationEvent event, Block...blocks) {
        for (Block block : blocks) {//New instance of a block for every block passed through
            //System.out.println("Registering " + block.getUnlocalizedName().substring(5));
            final ItemBlock itemblock = new ItemBlock(block);
            itemblock.setRegistryName(block.getRegistryName());
            //GameRegistry.register(block);
            //GameRegistry.register(itemblock, block.getRegistryName());
            ForgeRegistries.BLOCKS.register(block);
            ForgeRegistries.ITEMS.register(itemblock);
            if (event.getSide() == Side.CLIENT) {
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),0, new ModelResourceLocation(block.getRegistryName(),"inventory"));
                //System.out.println("Model Registered");
            }
            //System.out.println("Block Registered");
        }
    }
    private static void registerItems(FMLPreInitializationEvent event, Item...items) {
        //System.out.println("Registering Items");
        for(Item item : items){
            //System.out.println("Registering Item " + item.getUnlocalizedName().substring(5));

            if(event.getSide() == Side.CLIENT){
            	if (item == RWBYItems.ragorafireball) {
            		ModelLoader.setCustomModelResourceLocation(item,0, new ModelResourceLocation(Items.FIRE_CHARGE.getRegistryName(), "inventory"));
            	}
            	else {
            		ModelLoader.setCustomModelResourceLocation(item,0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
            	}
                //System.out.println("Item Model Registered");
            }
            ForgeRegistries.ITEMS.register(item);
            //System.out.println("Item Registered");
        }
    }

    public static final Potion AURA_REGEN = new PotionAuraRegen("aura_regen", false, 0);
    public static final PotionType aura_regen = new PotionType("aura_regen", new PotionEffect(RegUtil.AURA_REGEN, 3600, 0)).setRegistryName("aura_regen");
    public static final PotionType aura_regen_strong = new PotionType("aura_regen", new PotionEffect(RegUtil.AURA_REGEN, 1200, 3)).setRegistryName("aura_regen_strong");
    public static final PotionType aura_regen_long = new PotionType("aura_regen", new PotionEffect(RegUtil.AURA_REGEN, 9600, 0)).setRegistryName("aura_regen_long");


    public static void registerGamePotions(){
        registerPotion(aura_regen,aura_regen_long,aura_regen_strong,AURA_REGEN);
        registerPotionMixes();
    }

    private static void registerPotion(PotionType defaultPotion, PotionType longPotion, PotionType strongPotion, Potion effect){
        ForgeRegistries.POTIONS.register(effect);
        ForgeRegistries.POTION_TYPES.register(defaultPotion);
        ForgeRegistries.POTION_TYPES.register(longPotion);
        ForgeRegistries.POTION_TYPES.register(strongPotion);
    }

    private static void registerPotionMixes(){
        PotionHelper.addMix(aura_regen, Items.REDSTONE, aura_regen_long);
        PotionHelper.addMix(aura_regen, Items.GLOWSTONE_DUST, aura_regen_strong);
        PotionHelper.addMix(PotionTypes.AWKWARD, RWBYItems.remnants, aura_regen);
    }

    public static Item getHeadSlot(EntityPlayer player) {
        return player.inventory.armorItemInSlot(3).getItem();
    }

    public static Item getBodySlot(EntityPlayer player) {
        return player.inventory.armorItemInSlot(2).getItem();
    }

    public static Item getLegSlot(EntityPlayer player) {
        return player.inventory.armorItemInSlot(1).getItem();
    }
}

