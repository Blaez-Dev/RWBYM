package io.github.blaezdev.rwbym.weaponry;

import io.github.blaezdev.rwbym.Init.RWBYCreativeTabs;
import io.github.blaezdev.rwbym.RWBYModels;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.util.ResourceLocation;

public class RWBYFishing extends ItemFishingRod implements ICustomItem {

    public RWBYFishing(String name) {
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(RWBYCreativeTabs.tab_rwbyweapons);
    }
}
