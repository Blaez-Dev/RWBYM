package be.bluexin.rwbym.Init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class RWBYCreativeTabs {

    public static CreativeTabs tab_rwbyitems;
    public static CreativeTabs tab_rwbyweapons;
    public static CreativeTabs tab_rwbyarmour;

    public static void init() {

        tab_rwbyitems = new CreativeTabs("rwby_items") {

            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(RWBYItems.crmag);
            }

        };

        tab_rwbyweapons = new CreativeTabs("rwby_weapons") {

            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(RWBYItems.icon);
            }

        };

        tab_rwbyarmour = new CreativeTabs("rwby_armour") {

            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(RWBYItems.ruby3Chest);
            }

        };


    }


}
