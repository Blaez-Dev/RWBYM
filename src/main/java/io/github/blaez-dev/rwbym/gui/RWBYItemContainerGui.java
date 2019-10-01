package io.github.blaez-dev.rwbym.gui;

import io.github.blaez-dev.rwbym.inventory.RWBYItemContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class RWBYItemContainerGui extends GuiContainer implements IRWBYGuiFactory {

	private static final ResourceLocation DISPENSER_GUI_TEXTURES = new ResourceLocation("minecraft", "textures/gui/container/dispenser.png");
    /** The player inventory bound to this GUI. */
    private final InventoryPlayer playerInventory;
    /** The inventory contained within the corresponding Dispenser. */
    public IItemHandler handler;
    private ItemStack itemstack;
    
    public RWBYItemContainerGui(InventoryPlayer playerInv, ItemStack stack)
    {
        super(new RWBYItemContainer(playerInv, stack));
        this.playerInventory = playerInv;
        this.handler = stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        this.itemstack = stack;
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        /*String s = itemstack.getUnlocalizedName();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);*/
    }

    /**
     * Draws the background layer of this container (behind the items).
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(DISPENSER_GUI_TEXTURES);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
    }
}
