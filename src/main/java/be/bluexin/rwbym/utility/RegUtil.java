package be.bluexin.rwbym.utility;

import be.bluexin.rwbym.Init.CrusherRecipe;
import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.Init.RWBYPotions;
import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.potion.PotionAuraRegen;
import be.bluexin.rwbym.weaponry.RWBYItem;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
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
        registerBlocks(event, RWBYItems.hrdltfence);
        //weapons
        registerItems(event, RWBYItems.crescent);
        registerItems(event, RWBYItems.crescentfrost);
        registerItems(event, RWBYItems.crescentgunfrost);
        registerItems(event, RWBYItems.weiss);
        registerItems(event, RWBYItems.gambol);
        registerItems(event, RWBYItems.ember);
        registerItems(event, RWBYItems.ember2);
        registerItems(event, RWBYItems.juane);
        registerItems(event, RWBYItems.juaneshieldaxe);
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
        registerItems(event, RWBYItems.vernal);
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
        registerItems(event, RWBYItems.goodwitch);
        registerItems(event, RWBYItems.oobleckthermos);
        registerItems(event, RWBYItems.oobleckflamethrower);
        registerItems(event, RWBYItems.lionheart);
        registerItems(event, RWBYItems.jnrbat);
        registerItems(event, RWBYItems.jnrrocket);
        registerItems(event, RWBYItems.henchmen);
        registerItems(event, RWBYItems.adamgun);
        registerItems(event, RWBYItems.adamswd);
        registerItems(event, RWBYItems.corsac);
        registerItems(event, RWBYItems.fennec);
        registerItems(event, RWBYItems.iliasword);
        registerItems(event, RWBYItems.fennecdouble);
        registerItems(event, RWBYItems.corsacdouble);
        registerItems(event, RWBYItems.torchwick);
        registerItems(event, RWBYItems.torchwickgun);
        registerItems(event, RWBYItems.neoumb_closed);
        registerItems(event, RWBYItems.neoumb_closed_blade);
        registerItems(event, RWBYItems.neoumb_handle_blade);
        registerItems(event, RWBYItems.lieutenant);
        registerItems(event, RWBYItems.whitefangspear);
        registerItems(event, RWBYItems.wfp);
        registerItems(event, RWBYItems.cinder);
        registerItems(event, RWBYItems.cinderbow);
        registerItems(event, RWBYItems.cinderglass);
        registerItems(event, RWBYItems.cinderbowglass);
        registerItems(event, RWBYItems.emeraldblade);
        registerItems(event, RWBYItems.emeraldgun);
        registerItems(event, RWBYItems.tyrian);
        registerItems(event, RWBYItems.ironwood);
        registerItems(event, RWBYItems.winterswd);
        registerItems(event, RWBYItems.pennyswd);
        registerItems(event, RWBYItems.atlaspistol);
        registerItems(event, RWBYItems.atlasrifle);
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
        registerItems(event, RWBYItems.lysettesword);
        registerItems(event, RWBYItems.mariacane);
        registerItems(event, RWBYItems.mariascythe);
        registerItems(event, RWBYItems.mariascythedouble);
        registerItems(event, RWBYItems.tocksword);
        registerItems(event, RWBYItems.armasword);
        registerItems(event, RWBYItems.armaswordsummon);
        registerItems(event, RWBYItems.angelcane);
        registerItems(event, RWBYItems.angelsword);
        registerItems(event, RWBYItems.vidian);
        registerItems(event, RWBYItems.vidiangun);
        registerItems(event, RWBYItems.vidianhammer);
        registerItems(event, RWBYItems.aquaealatlsword);
        registerItems(event, RWBYItems.aquaealatlbow);
        registerItems(event, RWBYItems.scarletstormaxe);
        registerItems(event, RWBYItems.scarletstormgun);
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
        registerItems(event, RWBYItems.cardin);
        registerItems(event, RWBYItems.dove);
        registerItems(event, RWBYItems.russelnormal);
        registerItems(event, RWBYItems.russelfire);
        registerItems(event, RWBYItems.russelice);
        registerItems(event, RWBYItems.russelwind);
        registerItems(event, RWBYItems.lark);
        registerItems(event, RWBYItems.nebulabow);
        registerItems(event, RWBYItems.dew);
        registerItems(event, RWBYItems.gwenknife);
        registerItems(event, RWBYItems.gwen);
        registerItems(event, RWBYItems.octavia);
        registerItems(event, RWBYItems.nebulasword);
        registerItems(event, RWBYItems.brawnz);
        registerItems(event, RWBYItems.royg);
        registerItems(event, RWBYItems.nolan);
        registerItems(event, RWBYItems.mayrifle);
        registerItems(event, RWBYItems.mayaxe);
        registerItems(event, RWBYItems.deemace);
        registerItems(event, RWBYItems.sanrei);
        registerItems(event, RWBYItems.sanreiammo);
        registerItems(event, RWBYItems.letztstil);
        registerItems(event, RWBYItems.letztammo);
        registerItems(event, RWBYItems.bangle);
        registerItems(event, RWBYItems.hbangle);
        registerItems(event, RWBYItems.hsanrei);
        registerItems(event, RWBYItems.grimmrapier);
        registerItems(event, RWBYItems.grimmscy);
        registerItems(event, RWBYItems.grimmwhip);
        registerItems(event, RWBYItems.hadesgun);
        registerItems(event, RWBYItems.hadesgunrecoil);
        registerItems(event, RWBYItems.hadesscy);
        registerItems(event, RWBYItems.kag);
        registerItems(event, RWBYItems.kag2);
        registerItems(event, RWBYItems.grimmbody);
        registerItems(event, RWBYItems.noctustraumfire);
        registerItems(event, RWBYItems.noctustraumgrav);
        registerItems(event, RWBYItems.noctustraumice);
        registerItems(event, RWBYItems.noctustraumlight);
        registerItems(event, RWBYItems.noctustraumnormal);
        registerItems(event, RWBYItems.noctustraumfirescy);
        registerItems(event, RWBYItems.noctustraumgravscy);
        registerItems(event, RWBYItems.noctustraumicescy);
        registerItems(event, RWBYItems.noctustraumlightscy);
        registerItems(event, RWBYItems.noctustraumnormalscy);
        registerItems(event, RWBYItems.neonfire);
        registerItems(event, RWBYItems.neonice);
        registerItems(event, RWBYItems.neonwind);
        registerItems(event, RWBYItems.neonnormal);
        //dust items
        registerBlocks(event, RWBYItems.crusher);
        registerItems(event, RWBYItems.chisel);
        registerItems(event, RWBYItems.crush);
        registerItems(event, RWBYItems.dustcrystal);
        registerItems(event, RWBYItems.firedustcrystal);
        registerItems(event, RWBYItems.winddustcrystal);
        registerItems(event, RWBYItems.waterdustcrystal);
        registerItems(event, RWBYItems.gravitydustcrystal);
        registerItems(event, RWBYItems.lightdustcrystal);
        registerItems(event, RWBYItems.icedustcrystal);
        registerItems(event, RWBYItems.gravitydustcrystalcut);
        registerItems(event, RWBYItems.winddustcrystalcut);
        registerItems(event, RWBYItems.waterdustcrystalcut);
        registerItems(event, RWBYItems.firedustcrystalcut);
        registerItems(event, RWBYItems.dustcrystalcut);
        registerItems(event, RWBYItems.lightdustcrystalcut);
        registerItems(event, RWBYItems.icedustcrystalcut);
        registerItems(event, RWBYItems.dustrock);
        registerItems(event, RWBYItems.dustrockhardlight);
        registerItems(event, RWBYItems.dustcrystalhardlight);
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
        registerItems(event, RWBYItems.rgrimmarm);
        registerItems(event, RWBYItems.lgrimmarm);
        registerItems(event, RWBYItems.rgrimmleg);
        registerItems(event, RWBYItems.lgrimmleg);
        registerItems(event, RWBYItems.blackcatear);
        registerItems(event, RWBYItems.blondecatear);
        registerItems(event, RWBYItems.browncatear);
        registerItems(event, RWBYItems.greycatear);
        registerItems(event, RWBYItems.orangecatear);
        registerItems(event, RWBYItems.blackfoxear);
        registerItems(event, RWBYItems.blondefoxear);
        registerItems(event, RWBYItems.brownfoxear);
        registerItems(event, RWBYItems.greyfoxear);
        registerItems(event, RWBYItems.orangefoxear);
        registerItems(event, RWBYItems.cattail);
        registerItems(event, RWBYItems.cattailblonde);
        registerItems(event, RWBYItems.cattailbrown);
        registerItems(event, RWBYItems.cattailgrey);
        registerItems(event, RWBYItems.cattailorange);
        registerItems(event, RWBYItems.dorsalfinblack);
        registerItems(event, RWBYItems.dorsalfingrey);
        registerItems(event, RWBYItems.dorsalfinpearl);
        registerItems(event, RWBYItems.dorsalfinsilver);
        registerItems(event, RWBYItems.rabbittailblack);
        registerItems(event, RWBYItems.rabbittailblonde);
        registerItems(event, RWBYItems.rabbittailbrown);
        registerItems(event, RWBYItems.rabbittailgrey);
        registerItems(event, RWBYItems.rabbittailorange);
        registerItems(event, RWBYItems.rabbittailwhite);
        registerItems(event, RWBYItems.rabbitearsblack);
        registerItems(event, RWBYItems.rabbitearsblonde);
        registerItems(event, RWBYItems.rabbitearsbrown);
        registerItems(event, RWBYItems.rabbitearsgrey);
        registerItems(event, RWBYItems.rabbitearsorange);
        registerItems(event, RWBYItems.rabbitearswhite);
        registerItems(event, RWBYItems.clearears);
        registerItems(event, RWBYItems.clearhead);
        registerItems(event, RWBYItems.clearleftarm);
        registerItems(event, RWBYItems.clearleftleg);
        registerItems(event, RWBYItems.clearrightarm);
        registerItems(event, RWBYItems.clearrightleg);
        registerItems(event, RWBYItems.cleartail);
        registerItems(event, RWBYItems.clearbody);
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
        registerItems(event, RWBYItems.spl);
        registerItems(event, RWBYItems.splfire);
        registerItems(event, RWBYItems.splgrav);
        registerItems(event, RWBYItems.splice);
        registerItems(event, RWBYItems.spllight);
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
        registerItems(event, RWBYItems.hadesmag);
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
        registerItems(event, RWBYItems.saw);
        registerItems(event, RWBYItems.sawblade);
        registerItems(event, RWBYItems.gravitydustcut);
        registerItems(event, RWBYItems.winddustcut);
        registerItems(event, RWBYItems.waterdustcut);
        registerItems(event, RWBYItems.firedustcut);
        registerItems(event, RWBYItems.dustcut);
        registerItems(event, RWBYItems.lightdustcut);
        registerItems(event, RWBYItems.icedustcut);
        registerItems(event, RWBYItems.ragorafireball);
        registerItems(event, RWBYItems.noctu);
        registerItems(event, RWBYItems.noctufire);
        registerItems(event, RWBYItems.noctugrav);
        registerItems(event, RWBYItems.noctuice);
        registerItems(event, RWBYItems.noctulight);
        //mob drops
        registerItems(event, RWBYItems.remnants);
        registerBlocks(event, RWBYItems.bait);
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
        registerItems(event, RWBYItems.he1);
        registerItems(event, RWBYItems.he2);
        registerItems(event, RWBYItems.he3);
        registerItems(event, RWBYItems.he4);
        registerItems(event, RWBYItems.he5);
        registerItems(event, RWBYItems.he6);
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
        registerItems(event, RWBYItems.summer1Chest);
        registerItems(event, RWBYItems.summer1Legs);
        registerItems(event, RWBYItems.summer2Head);
        registerItems(event, RWBYItems.summerhood);
        registerItems(event, RWBYItems.summer2Chest);
        registerItems(event, RWBYItems.summer2Legs);
        registerItems(event, RWBYItems.ruby2Head);
        registerItems(event, RWBYItems.neptuneHead);
        registerItems(event, RWBYItems.neptuneChest);
        registerItems(event, RWBYItems.neptuneLegs);
        registerItems(event, RWBYItems.romanHead);
        registerItems(event, RWBYItems.romanChest);
        registerItems(event, RWBYItems.romanLegs);
        registerItems(event, RWBYItems.sageChest);
        registerItems(event, RWBYItems.sageLegs);
        registerItems(event, RWBYItems.scarletChest);
        registerItems(event, RWBYItems.scarletLegs);
        registerItems(event, RWBYItems.sunChest);
        registerItems(event, RWBYItems.sunLegs);

    }

    public static void registerAllRecipes(FMLInitializationEvent event){
        //Recipes
        registerRecipes( RWBYItems.whtefng);
        registerRecipes( RWBYItems.RagoraHead);
        registerRecipes( RWBYItems.RagoraChest);
        registerRecipes( RWBYItems.RagoraLegs);
        registerRecipes( RWBYItems.QrowChest);
        registerRecipes( RWBYItems.QrowLegs);
        registerRecipes( RWBYItems.Juane1Chest);
        registerRecipes( RWBYItems.Juane1Legs);
        registerRecipes( RWBYItems.Weiss1Chest);
        registerRecipes( RWBYItems.Weiss1Legs);
        registerRecipes( RWBYItems.AdamChest);
        registerRecipes( RWBYItems.AdamLegs);
        registerRecipes( RWBYItems.AtlasHead);
        registerRecipes( RWBYItems.AtlasChest);
        registerRecipes( RWBYItems.AtlasLegs);
        registerRecipes( RWBYItems.BeaconChest);
        registerRecipes( RWBYItems.BeaconLegs);
        registerRecipes( RWBYItems.Beacon1Chest);
        registerRecipes( RWBYItems.Beacon1Legs);
        registerRecipes( RWBYItems.Blake1Chest);
        registerRecipes( RWBYItems.Blake1Legs);
        registerRecipes( RWBYItems.Blake2Chest);
        registerRecipes( RWBYItems.Blake2Legs);
        registerRecipes( RWBYItems.Blake3Chest);
        registerRecipes( RWBYItems.Blake3Legs);
        registerRecipes( RWBYItems.AmberChest);
        registerRecipes( RWBYItems.AmberLegs);
        registerRecipes( RWBYItems.Cinder1Chest);
        registerRecipes( RWBYItems.Cinder1Legs);
        registerRecipes( RWBYItems.Cinder2Chest);
        registerRecipes( RWBYItems.Cinder2Legs);
        registerRecipes( RWBYItems.Cinder3Chest);
        registerRecipes( RWBYItems.Cinder3Legs);
        registerRecipes( RWBYItems.CocoHead);
        registerRecipes( RWBYItems.CocoChest);
        registerRecipes( RWBYItems.CocoLegs);
        registerRecipes( RWBYItems.Emerald1Chest);
        registerRecipes( RWBYItems.Emerald1Legs);
        registerRecipes( RWBYItems.Emerald2Chest);
        registerRecipes( RWBYItems.Emerald2Legs);
        registerRecipes( RWBYItems.pennyChest);
        registerRecipes( RWBYItems.pennyLegs);
        registerRecipes( RWBYItems.pyrrhaChest);
        registerRecipes( RWBYItems.pyrrhaLegs);
        registerRecipes( RWBYItems.rvnmask);
        registerRecipes( RWBYItems.ravenChest);
        registerRecipes( RWBYItems.ravenLegs);
        registerRecipes( RWBYItems.ruby1Chest);
        registerRecipes( RWBYItems.ruby1Legs);
        registerRecipes( RWBYItems.rubyhood);
        registerRecipes( RWBYItems.ruby2Chest);
        registerRecipes( RWBYItems.ruby2Legs);
        registerRecipes( RWBYItems.ruby3Chest);
        registerRecipes( RWBYItems.ruby3Legs);
        registerRecipes( RWBYItems.salemChest);
        registerRecipes( RWBYItems.salemLegs);
        registerRecipes( RWBYItems.velvetChest);
        registerRecipes( RWBYItems.velvetLegs);
        registerRecipes( RWBYItems.weiss2Chest);
        registerRecipes( RWBYItems.weiss2Legs);
        registerRecipes( RWBYItems.weiss3Chest);
        registerRecipes( RWBYItems.weiss3Legs);
        registerRecipes( RWBYItems.winterChest);
        registerRecipes( RWBYItems.winterLegs);
        registerRecipes( RWBYItems.yang1Chest);
        registerRecipes( RWBYItems.yang1Legs);
        registerRecipes( RWBYItems.yang2Chest);
        registerRecipes( RWBYItems.yang2Legs);
        registerRecipes( RWBYItems.yang3Chest);
        registerRecipes( RWBYItems.yang3Legs);
        registerRecipes( RWBYItems.yang4Chest);
        registerRecipes( RWBYItems.yang4Legs);
        registerRecipes( RWBYItems.ironwood1Chest);
        registerRecipes( RWBYItems.ironwood1Legs);
        registerRecipes( RWBYItems.ironwood2Chest);
        registerRecipes( RWBYItems.ironwood2Legs);
        registerRecipes( RWBYItems.mercury1Chest);
        registerRecipes( RWBYItems.mercury1Legs);
        registerRecipes( RWBYItems.mercury2Chest);
        registerRecipes( RWBYItems.mercury2Legs);
        registerRecipes( RWBYItems.ozpinChest);
        registerRecipes( RWBYItems.ozpinLegs);
        registerRecipes( RWBYItems.summer1Chest);
        registerRecipes( RWBYItems.summer1Legs);
        registerRecipes( RWBYItems.summer2Head);
        registerRecipes( RWBYItems.summerhood);
        registerRecipes( RWBYItems.summer2Chest);
        registerRecipes( RWBYItems.summer2Legs);
        registerRecipes( RWBYItems.ruby2Head);
        registerRecipes( RWBYItems.neptuneHead);
        registerRecipes( RWBYItems.neptuneChest);
        registerRecipes( RWBYItems.neptuneLegs);
        registerRecipes( RWBYItems.crescent);
        registerRecipes( RWBYItems.crescentfrost);
        registerRecipes( RWBYItems.crescentgunfrost);
        registerRecipes( RWBYItems.weiss);
        registerRecipes( RWBYItems.gambol);
        registerRecipes( RWBYItems.ember);
        registerRecipes( RWBYItems.ember2);
        registerRecipes( RWBYItems.juane);
        registerRecipes( RWBYItems.norahammer);
        registerRecipes( RWBYItems.pyrrhaspear);
        registerRecipes( RWBYItems.pyrrhasword);
        registerRecipes( RWBYItems.pyrrharifle);
        registerRecipes( RWBYItems.stormflower);
        registerRecipes( RWBYItems.rvnswd);
        registerRecipes( RWBYItems.rvnswdele);
        registerRecipes( RWBYItems.rvnswdice);
        registerRecipes( RWBYItems.qrow);
        registerRecipes( RWBYItems.qrowsword);
        registerRecipes( RWBYItems.cocobag);
        registerRecipes( RWBYItems.fox);
        registerRecipes( RWBYItems.velvet);
        registerRecipes( RWBYItems.yatsuhashi);
        registerRecipes( RWBYItems.crescentv);
        registerRecipes( RWBYItems.weissv);
        registerRecipes( RWBYItems.gambolv);
        registerRecipes( RWBYItems.juanev);
        registerRecipes( RWBYItems.norahammerv);
        registerRecipes( RWBYItems.pyrrhaspearv);
        registerRecipes( RWBYItems.pyrrhaswordv);
        registerRecipes( RWBYItems.cocobagv);
        registerRecipes( RWBYItems.crescentgun);
        registerRecipes( RWBYItems.crescentgunv);
        registerRecipes( RWBYItems.gambolgun);
        registerRecipes( RWBYItems.gambolgunv);
        registerRecipes( RWBYItems.noragun);
        registerRecipes( RWBYItems.stormflowerv);
        registerRecipes( RWBYItems.noragunv);
        registerRecipes( RWBYItems.emberv);
        registerRecipes( RWBYItems.qrowgun);
        registerRecipes( RWBYItems.cocogun);
        registerRecipes( RWBYItems.cocogunv);
        registerRecipes( RWBYItems.ozpincane);
        registerRecipes( RWBYItems.port);
        registerRecipes( RWBYItems.portgun);
        registerRecipes( RWBYItems.jnrbat);
        registerRecipes( RWBYItems.jnrrocket);
        registerRecipes( RWBYItems.adamgun);
        registerRecipes( RWBYItems.adamswd);
        registerRecipes( RWBYItems.torchwick);
        registerRecipes( RWBYItems.torchwickgun);
        registerRecipes( RWBYItems.neoumb_closed);
        registerRecipes( RWBYItems.neoumb_closed_blade);
        registerRecipes( RWBYItems.neoumb_handle_blade);
        registerRecipes( RWBYItems.cinder);
        registerRecipes( RWBYItems.cinderbow);
        registerRecipes( RWBYItems.emeraldblade);
        registerRecipes( RWBYItems.emeraldgun);
        registerRecipes( RWBYItems.ironwood);
        registerRecipes( RWBYItems.winterswd);
        registerRecipes( RWBYItems.pennyswd);
        registerRecipes( RWBYItems.kkfire);
        registerRecipes( RWBYItems.kkice);
        registerRecipes( RWBYItems.kkwind);
        registerRecipes( RWBYItems.korekosmouoff);
        registerRecipes( RWBYItems.korekosmoufire);
        registerRecipes( RWBYItems.korekosmouwater);
        registerRecipes( RWBYItems.korekosmouwind);
        registerRecipes( RWBYItems.razorbolt);
        registerRecipes( RWBYItems.razorboltknife);
        registerRecipes( RWBYItems.chatareus);
        registerRecipes( RWBYItems.chatareusgun);
        registerRecipes( RWBYItems.hexen);
        registerRecipes( RWBYItems.hexenaxe);
        registerRecipes( RWBYItems.magnumgun);
        registerRecipes( RWBYItems.magnumsword);
        registerRecipes( RWBYItems.mariacane);
        registerRecipes( RWBYItems.mariascythe);
        registerRecipes( RWBYItems.mariascythedouble);
        registerRecipes( RWBYItems.armasword);
        registerRecipes( RWBYItems.armaswordsummon);
        registerRecipes( RWBYItems.angelcane);
        registerRecipes( RWBYItems.angelsword);
        registerRecipes( RWBYItems.ozmacane);
        registerRecipes( RWBYItems.ozmacanefire);
        registerRecipes( RWBYItems.ozmacanegravity);
        registerRecipes( RWBYItems.ozmacaneice);
        registerRecipes( RWBYItems.ozmacanelightning);
        registerRecipes( RWBYItems.ozmacanewater);
        registerRecipes( RWBYItems.ozmacanewind);
        registerRecipes( RWBYItems.sunnunchuck);
        registerRecipes( RWBYItems.sunstaff);
        registerRecipes( RWBYItems.sage);
        registerRecipes( RWBYItems.scarletsword);
        registerRecipes( RWBYItems.neptunegun);
        registerRecipes( RWBYItems.neptunespear);
        registerRecipes( RWBYItems.neptunetrident);
        registerRecipes( RWBYItems.arslan);
        registerRecipes( RWBYItems.bolin);
        registerRecipes( RWBYItems.bolinblade);
        registerRecipes( RWBYItems.reese);
        registerRecipes( RWBYItems.reesegun);
        registerRecipes( RWBYItems.nadirgun);
        registerRecipes( RWBYItems.nadirsword);
        registerRecipes(RWBYItems.lysettesword);
        registerRecipes(RWBYItems.goodwitch);
        registerRecipes(RWBYItems.cardin);
        registerRecipes(RWBYItems.atlasrifle);
        registerRecipes(RWBYItems.atlaspistol);
        registerRecipes(RWBYItems.vernal);
        registerRecipes(RWBYItems.dove);
        registerRecipes(RWBYItems.tyrian);
        registerRecipes(RWBYItems.romanHead);
        registerRecipes(RWBYItems.romanChest);
        registerRecipes(RWBYItems.romanLegs);
        registerRecipes(RWBYItems.russelnormal);
        registerRecipes(RWBYItems.russelwind);
        registerRecipes(RWBYItems.russelice);
        registerRecipes(RWBYItems.russelfire);
        registerRecipes(RWBYItems.nebulabow);
        registerRecipes(RWBYItems.nebulasword);
        registerRecipes(RWBYItems.lieutenant);
        registerRecipes(RWBYItems.dew);
        registerRecipes(RWBYItems.lark);
        registerRecipes(RWBYItems.octavia);
        registerRecipes(RWBYItems.cinderbowglass);
        registerRecipes(RWBYItems.cinderglass);
        registerRecipes(RWBYItems.henchmen);
        registerRecipes(RWBYItems.fennec);
        registerRecipes(RWBYItems.corsac);
        registerRecipes(RWBYItems.corsacdouble);
        registerRecipes(RWBYItems.fennecdouble);
        registerRecipes(RWBYItems.aquaealatlbow);
        registerRecipes(RWBYItems.aquaealatlsword);
        registerRecipes( RWBYItems.sunChest);
        registerRecipes( RWBYItems.sunLegs);
        registerRecipes( RWBYItems.scarletChest);
        registerRecipes( RWBYItems.scarletLegs);
        registerRecipes( RWBYItems.sageChest);
        registerRecipes( RWBYItems.sageLegs);
        registerRecipes(RWBYItems.brawnz);
        registerRecipes(RWBYItems.iliasword);
        registerRecipes(RWBYItems.scarletstormgun);
        registerRecipes(RWBYItems.scarletstormaxe);
        registerRecipes(RWBYItems.mayrifle);
        registerRecipes(RWBYItems.mayaxe);
        registerRecipes(RWBYItems.lionheart);
        registerRecipes(RWBYItems.nolan);
        registerRecipes(RWBYItems.royg);
        registerRecipes(RWBYItems.wfp);
        registerRecipes(RWBYItems.gwen);
        registerRecipes(RWBYItems.noctustraumnormal);
        registerRecipes(RWBYItems.noctustraumlight);
        registerRecipes(RWBYItems.noctustraumice);
        registerRecipes(RWBYItems.noctustraumgrav);
        registerRecipes(RWBYItems.noctustraumfire);
        registerRecipes(RWBYItems.noctustraumnormalscy);
        registerRecipes(RWBYItems.noctustraumfirescy);
        registerRecipes(RWBYItems.noctustraumgravscy);
        registerRecipes(RWBYItems.noctustraumicescy);
        registerRecipes(RWBYItems.noctustraumlightscy);
        registerRecipes(RWBYItems.neonnormal);
        registerRecipes(RWBYItems.neonfire);
        registerRecipes(RWBYItems.neonice);
        registerRecipes(RWBYItems.neonwind);
        registerRecipes(RWBYItems.hadesscy);
        registerRecipes(RWBYItems.hadesgun);
        registerRecipes(RWBYItems.he1);
        registerRecipes(RWBYItems.he2);
        registerRecipes(RWBYItems.he3);
        registerRecipes(RWBYItems.he4);
        registerRecipes(RWBYItems.he5);
        registerRecipes(RWBYItems.he6);
        registerRecipes(RWBYItems.tocksword);
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
            	}else
            	if(item == RWBYItems.gravitydustcut){
            	    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.gravitydustcrystalcut.getRegistryName(), "inventory"));
                }else
                if(item == RWBYItems.winddustcut){
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.winddustcrystalcut.getRegistryName(), "inventory"));
                }else
                if(item == RWBYItems.waterdustcut){
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.waterdustcrystalcut.getRegistryName(), "inventory"));
                }else
                if(item == RWBYItems.firedustcut){
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.firedustcrystalcut.getRegistryName(), "inventory"));
                }else
                if(item == RWBYItems.dustcut){
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.dustcrystalcut.getRegistryName(), "inventory"));
                }else
                if(item == RWBYItems.lightdustcut){
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.lightdustcrystalcut.getRegistryName(), "inventory"));
                }else
                if(item == RWBYItems.icedustcut){
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.icedustcrystalcut.getRegistryName(), "inventory"));
                }else
                if(item == RWBYItems.sanreiammo){
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.sanrei.getRegistryName(), "inventory"));
                }else
                if(item == RWBYItems.letztammo){
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.letztstil.getRegistryName(), "inventory"));
                }else
                if(item == RWBYItems.hbangle){
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.bangle.getRegistryName(), "inventory"));
                }else
                if(item == RWBYItems.sawblade){
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.saw.getRegistryName(), "inventory"));
                }else if(item == RWBYItems.gwenknife){
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.gwen.getRegistryName(), "inventory"));
                }else if(item == RWBYItems.noctu){
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.gwen.getRegistryName(), "inventory"));
                }else if(item == RWBYItems.noctufire){
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.gwen.getRegistryName(), "inventory"));
                }else if(item == RWBYItems.noctuice){
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.gwen.getRegistryName(), "inventory"));
                }else if(item == RWBYItems.noctugrav){
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.gwen.getRegistryName(), "inventory"));
                }else if(item == RWBYItems.noctulight){
                    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RWBYItems.gwen.getRegistryName(), "inventory"));
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

    public static void registerRecipes(Item...items) {
            craftingutil.addShapelessRecipe(new ItemStack(RWBYItems.scrap, 3),Ingredient.fromItems(items));
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



    public static void initRegistries(FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(RWBYModels.instance, new RWBYModels.GuiHandler());
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

