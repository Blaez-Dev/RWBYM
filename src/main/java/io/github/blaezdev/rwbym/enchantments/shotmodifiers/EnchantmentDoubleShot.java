package io.github.blaezdev.rwbym.enchantments.shotmodifiers;

import io.github.blaezdev.rwbym.Init.EnchantInit;
import io.github.blaezdev.rwbym.RWBYModels;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentMending;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;

public class EnchantmentDoubleShot extends Enchantment {
    public EnchantmentDoubleShot(){
        super(Rarity.VERY_RARE, EnumEnchantmentType.WEAPON,new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND,EntityEquipmentSlot.OFFHAND});
        this.setName("doubleshot");
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID+":doubleshot"));

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
                && ench != EnchantInit.KNOCK_SHOT && ench != EnchantInit.POISON_SHOT;
    }
}
