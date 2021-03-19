package io.github.blaezdev.rwbym.enchantments.barrelmodifiers;

import io.github.blaezdev.rwbym.Init.EnchantInit;
import io.github.blaezdev.rwbym.RWBYModels;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentMending;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;

public class EnchantmentChamberedCompensator extends Enchantment {
    public EnchantmentChamberedCompensator(){
        super(Rarity.VERY_RARE, EnumEnchantmentType.WEAPON,new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND,EntityEquipmentSlot.OFFHAND});
        this.setName("chamberedcompensator");
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID+":chamberedcompensator"));

        EnchantInit.ENCHANTMENTS.add(this);
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 20*enchantmentLevel;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return this.getMinEnchantability(enchantmentLevel)+10;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    protected boolean canApplyTogether(Enchantment ench) {
        return super.canApplyTogether(ench)
                && ench != EnchantInit.ARROW_BREAK_BARREL && ench != EnchantInit.CORKSCREW_RIFLING && ench != EnchantInit.EXTENDED_BARREL && ench != EnchantInit.FLUTED_BARREL
                && ench != EnchantInit.FULL_BORE_BARREL && ench != EnchantInit.HOME_FORGED_RIFILING && ench != EnchantInit.POLYGONAL_RIFILING && ench != EnchantInit.SMALL_BORE_BARREL;
    }
}