package be.bluexin.rwbym.gui.helper;

import com.google.common.collect.Lists;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;

import java.util.List;

public class TradingRecipe {

    /** Item the Villager buys. */
    private ItemStack itemToBuy;
    /** Second Item the Villager buys. */
    private ItemStack secondItemToBuy;
    /** Item the Villager sells. */
    private ItemStack itemToSell;
    /** Is the recipe part of the current search. */
    private boolean active;
    /** Is the recipe selected. */
    private boolean selected;
    /** Amount of ingredients in player inventory. */
    int ingredients;
    /** Amount of secound ingredients in player inventory. */
    int secoundIngredients;

    public TradingRecipe(ItemStack buy1, ItemStack buy2, ItemStack sell)
    {
        this.itemToBuy = ItemStack.EMPTY;
        this.secondItemToBuy = ItemStack.EMPTY;
        this.itemToSell = ItemStack.EMPTY;
        this.itemToBuy = buy1;
        this.secondItemToBuy = buy2;
        this.itemToSell = sell;
        this.active = true;
        this.selected = false;
        this.ingredients = 0;
        this.secoundIngredients = 0;
    }

    /**
     * Gets the itemToBuy.
     */
    public ItemStack getItemToBuy()
    {
        return this.itemToBuy;
    }

    /**
     * Gets secondItemToBuy.
     */
    public ItemStack getSecondItemToBuy()
    {
        return this.secondItemToBuy;
    }

    /**
     * Gets if Villager has secondItemToBuy.
     */
    public boolean hasSecondItemToBuy()
    {
        return !this.secondItemToBuy.isEmpty();
    }

    /**
     * Gets itemToSell.
     */
    public ItemStack getItemToSell()
    {
        return this.itemToSell;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean flag) {
        this.active = flag;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean flag) {
        this.selected = flag;
    }

    /**
     * Returns if the player has enough items for a trade in their inventory
     */
    public boolean hasRecipeContents() {
        boolean flag = !this.hasSecondItemToBuy() || (this.secoundIngredients >= this.secondItemToBuy.getCount());
        return flag && this.ingredients >= this.itemToBuy.getCount();
    }

    /**
     * @param advancedItemTooltips Get this setting from the game controller
     * @return List containing all tooltips of the items involved with this trading recipe
     */
    public List<String> getCombinedTooltip(int mode, boolean advancedItemTooltips) {

        ITooltipFlag tooltipFlag = advancedItemTooltips ? ITooltipFlag.TooltipFlags.ADVANCED : ITooltipFlag.TooltipFlags.NORMAL;
        List<String> list = Lists.newArrayList();
        if (mode < 2) {
            list.addAll(this.itemToBuy.getTooltip(null, tooltipFlag));
            if (this.hasSecondItemToBuy()) {
                list.addAll(this.secondItemToBuy.getTooltip(null, tooltipFlag));
            }
        }
        if (mode != 1) {
            list.addAll(this.itemToSell.getTooltip(null, tooltipFlag));
        }
        return list;

    }
}
