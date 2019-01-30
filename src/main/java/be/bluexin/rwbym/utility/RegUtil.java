package be.bluexin.rwbym.utility;

import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.weaponry.RWBYItem;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;


public class RegUtil {
    public static void registerAll(FMLPreInitializationEvent event){
        //Icon
        registerItems(event, RWBYItems.icon);
        //Blocks
        registerBlocks(event, RWBYItems.rwbyblock1);
        registerBlocks(event, RWBYItems.rwbyblock2);
        registerBlocks(event, RWBYItems.rwbyblock3);
        registerBlocks(event, RWBYItems.rwbyblock4);
        registerBlocks(event, RWBYItems.rwbyblock5);
        registerBlocks(event, RWBYItems.rwbyblock6);
        registerBlocks(event, RWBYItems.rwbyblock9);
        registerBlocks(event, RWBYItems.rwbyblock7);


        //Weapons
        registerItems(event, RWBYItems.crescent);
        registerItems(event, RWBYItems.weiss);
        registerItems(event, RWBYItems.gambol);
        registerItems(event, RWBYItems.ember);
        registerItems(event, RWBYItems.ember2);
        registerItems(event, RWBYItems.juane);
        registerItems(event, RWBYItems.norahammer);
        registerItems(event, RWBYItems.pyrrhaspear);
        registerItems(event, RWBYItems.pyrrhasword);
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
        registerItems(event, RWBYItems.winterswd);
        registerItems(event, RWBYItems.pennyswd);
        registerItems(event, RWBYItems.kkfire);
        registerItems(event, RWBYItems.kkice);
        registerItems(event, RWBYItems.kkwind);
        registerItems(event, RWBYItems.mariacane);
        registerItems(event, RWBYItems.mariascythe);
        registerItems(event, RWBYItems.mariascythedouble);
        //Staffs
        registerItems(event, RWBYItems.ozmacane);
        registerItems(event, RWBYItems.ozmacanefire);
        registerItems(event, RWBYItems.ozmacanegravity);
        registerItems(event, RWBYItems.ozmacaneice);
        registerItems(event, RWBYItems.ozmacanelightning);
        registerItems(event, RWBYItems.ozmacanewater);
        registerItems(event, RWBYItems.ozmacanewind);

        //Items
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
        registerItems(event, RWBYItems.roseiron);
        registerItems(event, RWBYItems.frostediron);
        registerItems(event, RWBYItems.shadowiron);
        registerItems(event, RWBYItems.gildediron);
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
        registerItems(event, RWBYItems.scrap);
        registerItems(event, RWBYItems.atlasknight);
        //Armour
        registerItems(event, RWBYItems.korekosmouoff);
        registerItems(event, RWBYItems.korekosmoufire);
        registerItems(event, RWBYItems.korekosmouwater);
        registerItems(event, RWBYItems.korekosmouwind);

        //mask & 3D Helmets
        registerItems(event, RWBYItems.rvnmask);
        registerItems(event, RWBYItems.whtefng);
        //registerItems(event, RWBYItems.rubyhood);

        //Ammo Related Items
        registerBlocks(event, RWBYItems.rwbyblock8);
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
        registerItems(event, RWBYItems.waterdust);
        registerItems(event, RWBYItems.winddust);
        registerItems(event, RWBYItems.firedust);
        registerItems(event, RWBYItems.icedust);
        registerItems(event, RWBYItems.lightdust);
        registerItems(event, RWBYItems.gravitydust);
        registerItems(event, RWBYItems.dust);
        registerItems(event, RWBYItems.jnrammo);
        registerItems(event, RWBYItems.ammov);
        registerItems(event, RWBYItems.ammmo);



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
                ModelLoader.setCustomModelResourceLocation(item,0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
                //System.out.println("Item Model Registered");
            }
            ForgeRegistries.ITEMS.register(item);
            //System.out.println("Item Registered");
        }
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

