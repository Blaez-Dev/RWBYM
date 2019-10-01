package io.github.blaez-dev.rwbym.inventory;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerVillager extends Container
{
    /** Instance of Merchant. */
    private final IMerchant merchant;
    private final InventoryMerchant merchantInventory;
    /** Instance of World. */
    private final World world;

    private final EntityPlayer player;
    private int lastIndex = 3;

    public ContainerVillager(InventoryPlayer playerInventory, IMerchant merchant, World worldIn)
    {
        this.merchant = merchant;
        this.world = worldIn;
        this.player = playerInventory.player;
        this.merchantInventory = new InventoryMerchant(player, merchant);
        this.addSlotToContainer(new Slot(this.merchantInventory, 0, 76, 22));
        this.addSlotToContainer(new Slot(this.merchantInventory, 1, 76, 48));
        this.addSlotToContainer(new SlotMerchantResult(player, merchant, this.merchantInventory, 2, 134, 35));

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k)
        {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
    }

    public InventoryMerchant getMerchantInventory()
    {
        return this.merchantInventory;
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory inventoryIn)
    {
        this.merchantInventory.resetRecipeAndSlots();
        super.onCraftMatrixChanged(inventoryIn);
    }

    public void setCurrentRecipeIndex(int currentRecipeIndex)
    {
        this.merchantInventory.setCurrentRecipeIndex(currentRecipeIndex);
    }

    /**
     * Determines whether supplied player can use this container
     */
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.merchant.getCustomer() == playerIn;
    }

    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
     * inventory and the other inventory(s).
     */
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index != 0 && index != 1)
            {
                if (index >= 3 && index < 39)
                {
                    ItemStack tradingstack0 = this.merchantInventory.getStackInSlot(0);
                    ItemStack tradingstack1 = this.merchantInventory.getStackInSlot(1);
                    boolean flag = false;

                    if (!ItemStack.areItemsEqualIgnoreDurability(tradingstack1, itemstack1) || !tradingstack0.isEmpty()) {
                        flag = !this.mergeItemStack(itemstack1, 0, 1, false);
                    }

                    if ((!ItemStack.areItemsEqualIgnoreDurability(tradingstack0, itemstack1) || !tradingstack1.isEmpty())) {
                        flag = !this.mergeItemStack(itemstack1, 1, 2, false);
                    }

                    if (flag) {
                        return ItemStack.EMPTY;
                    }
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }

    @SideOnly(Side.CLIENT)
    public boolean haveTradingSlotsContents() {
        return !this.merchantInventory.getStackInSlot(0).isEmpty() || !this.merchantInventory.getStackInSlot(1).isEmpty();
    }

    /**
     * Move trading slot contents to inventory so that a ghost recipe can properly be displayed
     */
    public void clearTradingSlots() {

        ItemStack itemstack1 = this.merchantInventory.getStackInSlot(0);
        ItemStack itemstack2 = this.merchantInventory.getStackInSlot(1);

        if(!itemstack1.isEmpty()) {
            this.mergeItemStack(itemstack1, 3, 39, true);
        }
        if(!itemstack2.isEmpty()) {
            this.mergeItemStack(itemstack2, 3, 39, true);
        }

    }

    /**
     * Are the buy items switched in the trading slots
     */
    private boolean areSlotsSwitched(ItemStack itemStack1, ItemStack itemStack2, ItemStack itemStack3, ItemStack itemStack4) {
        boolean flag = !itemStack1.isEmpty() && ItemStack.areItemsEqual(itemStack1, itemStack4);
        boolean flag1 = !itemStack2.isEmpty() && ItemStack.areItemsEqual(itemStack2, itemStack3);
        return (flag || flag1) && !(ItemStack.areItemsEqual(itemStack1, itemStack3) || ItemStack.areItemsEqual(itemStack2, itemStack4));
    }

    /**
     * Handle item moving when a recipe button is clicked
     * @param recipeIndex Id of the recipe belonging to the clicked button
     * @param clear Force clearing trading slots
     * @param quickMove Move as many items as possible
     * @param skipMove Move output directly to player inventory
     */
    public void handleClickedButtonItems(int recipeIndex, boolean clear, boolean quickMove, boolean skipMove)
    {
        MerchantRecipeList merchantrecipelist = this.merchant.getRecipes(player);

        if (merchantrecipelist != null && merchantrecipelist.size() > recipeIndex) {

            MerchantRecipe recipe = merchantrecipelist.get(recipeIndex);
            ItemStack itemstack1 = this.merchantInventory.getStackInSlot(0);
            ItemStack itemstack2 = this.merchantInventory.getStackInSlot(1);
            ItemStack itemstack3 = recipe.getItemToBuy();
            ItemStack itemstack4 = recipe.getSecondItemToBuy();
            boolean flag = this.areSlotsSwitched(itemstack1, itemstack2, itemstack3, itemstack4);

            if (!itemstack1.isEmpty() && (clear && !skipMove || !ItemStack.areItemsEqual(itemstack1, itemstack3) && !flag || !ItemStack.areItemsEqual(itemstack1, itemstack4) && flag)) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return;
                }
                this.merchantInventory.setInventorySlotContents(0, itemstack1);
            }

            if (!itemstack2.isEmpty() && (clear && !skipMove || !ItemStack.areItemsEqual(itemstack2, itemstack4) && !flag || !ItemStack.areItemsEqual(itemstack2, itemstack3) && flag)) {
                if (!this.mergeItemStack(itemstack2, 3, 39, true)) {
                    return;
                }
                this.merchantInventory.setInventorySlotContents(1, itemstack2);
            }

            int mainCount;
            int secCount;
            boolean loop = true;

            while (loop) {

                mainCount = flag ? itemstack4.getCount() : itemstack3.getCount();
                secCount = flag ? itemstack3.getCount() : itemstack4.getCount();

                if (skipMove) {
                    mainCount -= this.merchantInventory.getStackInSlot(0).getCount();
                    secCount -= this.merchantInventory.getStackInSlot(1).getCount();
                }

                moveAndTrade(quickMove, skipMove, flag ? itemstack4 : itemstack3, flag ? itemstack3 : itemstack4, mainCount, secCount);

                ItemStack itemstack5 = this.merchantInventory.getStackInSlot(0);
                ItemStack itemstack6 = this.merchantInventory.getStackInSlot(1);
                boolean flag1 = this.checkTrade(itemstack3, itemstack4, flag ? itemstack6 : itemstack5, flag ? itemstack5 : itemstack6);

                if (skipMove && flag1) {
                    this.tradeAutomatically(recipe.getItemToSell());
                }

                loop = quickMove && skipMove && !recipe.isRecipeDisabled() && flag1;

                if (!loop && quickMove && skipMove) {
                    this.mergeItemStack(itemstack5, 3, 39, true);
                    this.mergeItemStack(itemstack6, 3, 39, true);
                }

            }

        }
    }

    private void moveAndTrade(boolean quickMove, boolean skipMove, ItemStack itemstack1, ItemStack itemstack2, int count1, int count2) {
        if (count1 > 0) {
            this.moveItemsToSlot(0, itemstack1, count1, quickMove, skipMove);
        }
        if (count2 > 0) {
            this.moveItemsToSlot(1, itemstack2, count2, quickMove, skipMove);
        }
    }

    /**
     * Move trading recipe ingredients to trading slots
     */
    private void moveItemsToSlot(int targetSlot, ItemStack itemstack, int count, boolean quickMove, boolean skipMove) {

        if (!itemstack.isEmpty()) {
            int leftover = 0;
            for(int i = this.lastIndex; i < 39; ++i) {
                ItemStack inventorystack = this.inventorySlots.get(i).getStack();
                if (!inventorystack.isEmpty() && ItemStack.areItemsEqual(itemstack, inventorystack)) {
                    ItemStack currentitemstack = this.merchantInventory.getStackInSlot(targetSlot);
                    if (!currentitemstack.isEmpty() && !ItemStack.areItemStackTagsEqual(currentitemstack, inventorystack)
                            && !skipMove) { //mainly handles renamed items, !skipMove is a bit hacky as it might rename items involved with the trade
                        continue;
                    }
                    int int_3 = currentitemstack.isEmpty() ? 0 : currentitemstack.getCount();
                    int int_32 = leftover > 0 ? leftover : count;
                    int int_33 = Math.min(inventorystack.getCount(), int_32);
                    leftover = int_32 - int_33;
                    int int_34 = quickMove ? inventorystack.getCount() : int_33;
                    int int_4 = Math.min(itemstack.getMaxStackSize() - int_3, int_34);
                    ItemStack newitemstack = inventorystack.copy();
                    int int_5 = int_3 + int_4;
                    inventorystack.shrink(int_4);
                    newitemstack.setCount(int_5);
                    this.merchantInventory.setInventorySlotContents(targetSlot, newitemstack);
                    int int_6 = quickMove ? itemstack.getMaxStackSize() : Math.min(itemstack.getMaxStackSize(), int_32 + int_3);
                    if (int_5 >= int_6) {
                        this.lastIndex = i;
                        break;
                    }
                }
                if (i == (this.lastIndex - 1 + 33) % 36 + 3) {
                    this.lastIndex = 3;
                    break;
                }
                i = (i - 2) % 36 + 2;
            }
        }

    }

    /**
     * Check if trade can be done (modified from {@link SlotMerchantResult})
     */
    private boolean checkTrade(ItemStack firstRecipeItem, ItemStack secondRecipeItem ,ItemStack firstInvItem, ItemStack secondInvItem)
    {

        if (firstInvItem.getItem() == firstRecipeItem.getItem() && firstInvItem.getCount() >= firstRecipeItem.getCount())
        {
            if (!secondRecipeItem.isEmpty() && !secondInvItem.isEmpty() && secondRecipeItem.getItem() == secondInvItem.getItem() && secondInvItem.getCount() >= secondRecipeItem.getCount())
            {
                return true;
            }

            return secondRecipeItem.isEmpty() && secondInvItem.isEmpty();
        }

        return false;

    }

    /**
     * Trade automatically using {@link SlotMerchantResult#onTake(EntityPlayer, ItemStack)} so that all the triggers apply
     */
    private void tradeAutomatically(ItemStack itemstack) {

        ItemStack itemstack1 =  this.getSlot(2).onTake(this.player, itemstack);
        if (!itemstack1.isEmpty()) {
            ItemStack itemstack2 = itemstack1.copy();
            if (!this.mergeItemStack(itemstack2, 3, 39, true)) {
                this.player.dropItem(itemstack2, false);
            }
        }

    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);
        this.merchant.setCustomer(null);
        this.merchantInventory.removeStackFromSlot(2);

        if (!this.world.isRemote)
        {
            this.clearContainer(playerIn, this.world, this.merchantInventory);
        }
    }
}