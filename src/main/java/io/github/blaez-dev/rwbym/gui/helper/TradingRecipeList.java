package io.github.blaez-dev.rwbym.gui.helper;

import io.github.blaez-dev.rwbym.inventory.ContainerVillager;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Collectors;

public class TradingRecipeList extends ArrayList<TradingRecipe> {

    public TradingRecipeList(MerchantRecipeList list)
    {
        for (MerchantRecipe recipe : list) {
            if (this.isValidRecipe(recipe)) {
                this.add(new TradingRecipe(recipe.getItemToBuy(), recipe.getSecondItemToBuy(), recipe.getItemToSell()));
            }
        }
    }

    private boolean isValidRecipe(MerchantRecipe recipe)
    {
        return !recipe.getItemToBuy().isEmpty() && !recipe.getItemToSell().isEmpty();
    }

    public int activeRecipeSize() {
        return Math.toIntExact(this.stream().filter(TradingRecipe::getActive).count());
    }

    /**
     * Searches trading recipes for a string, hides the ones not containing it
     * @param s String to be searched for
     * @param advancedItemTooltips Get this setting from the game controller
     */
    public void searchQuery(String s, boolean advancedItemTooltips) {

        String s1 = s.trim();
        int i = 0;
        if (!s1.isEmpty()) {
            if (s1.startsWith("\u003C")) { //less than
                s1 = s1.substring(1);
                i = 1;
            } else if (s1.startsWith("\u003E")) { //greater than
                s1 = s1.substring(1);
                i = 2;
            }
        }

        String s2 = s1.trim();
        for (TradingRecipe recipe : this) {
            if (!s.isEmpty()) {
                recipe.setActive(recipe.getCombinedTooltip(i, advancedItemTooltips).stream()
                        .map(it -> it.toLowerCase(Locale.ROOT)).anyMatch(it -> it.contains(s2)));
            } else {
                recipe.setActive(true);
            }
        }

    }

    /**
     * Scans the inventory each time it changes to see if it contains enough items to perform each trade
     * @param container Current ContainerVillager
     */
    public void countRecipeContents(ContainerVillager container) {

        for (TradingRecipe recipe : this) {
            recipe.ingredients = 0;
            recipe.secoundIngredients = 0;
        }

        int i = 0;
        for (ItemStack itemstack : container.inventorySlots.stream().map(Slot::getStack).collect(Collectors.toList())) {
            if (i != 2) { //don't count output slot
                for (TradingRecipe recipe : this) {
                    if (ItemStack.areItemsEqual(itemstack, recipe.getItemToBuy())) {
                        recipe.ingredients += itemstack.getCount();
                    }
                    if (recipe.hasSecondItemToBuy() && ItemStack.areItemsEqual(itemstack, recipe.getSecondItemToBuy())) {
                        recipe.secoundIngredients += itemstack.getCount();
                    }
                }
            }
            i++;
        }
    }

}
