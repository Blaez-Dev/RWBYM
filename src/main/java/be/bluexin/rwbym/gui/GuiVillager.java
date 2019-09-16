package be.bluexin.rwbym.gui;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.gui.helper.GhostTrade;
import be.bluexin.rwbym.inventory.ContainerVillager;
import be.bluexin.rwbym.utility.IPrivateAccessor;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import be.bluexin.rwbym.utility.network.messages.MessageTradingData;
import io.netty.buffer.Unpooled;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;

@SideOnly(Side.CLIENT)
public class GuiVillager extends GuiContainer implements IPrivateAccessor
{
    /** The GUI texture for the villager merchant GUI. */
    private static final ResourceLocation MERCHANT_GUI_TEXTURE = new ResourceLocation(RWBYModels.MODID, "textures/gui/container/merchant.png");
    /** The current IMerchant instance in use for this specific merchant. */
    private final IMerchant merchant;
    private final EntityVillager entityVillager;
    /** The integer value corresponding to the currently selected merchant recipe. */
    private int selectedMerchantRecipe;
    /** The chat component utilized by this GuiVillager instance. */
    private final ITextComponent chatComponent;

    private final GuiTradingBook tradingBookGui = new GuiTradingBook();
    private final GhostTrade ghostTrade = new GhostTrade();

    public GuiVillager(InventoryPlayer p_i45500_1_, IMerchant p_i45500_2_, EntityVillager entityVillager, World worldIn)
    {
        super(new ContainerVillager(p_i45500_1_, p_i45500_2_, worldIn));
        this.merchant = p_i45500_2_;
        this.entityVillager = entityVillager;
        this.chatComponent = p_i45500_2_.getDisplayName();
        this.selectedMerchantRecipe = this.getWealth(entityVillager);
        this.sendSelectedRecipe(false);
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui()
    {
        super.initGui();
        this.guiLeft = (this.width - this.xSize) / 2 + 57;
        this.tradingBookGui.initGui(this.mc, this.width, this.height);
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    public void onGuiClosed()
    {
        this.tradingBookGui.removed();
        PacketBuffer packetbuffer = new PacketBuffer(Unpooled.buffer());
        packetbuffer.writeByte(this.selectedMerchantRecipe);
        packetbuffer.writeInt(this.entityVillager.getEntityId());
        RWBYNetworkHandler.sendToServer(new MessageTradingData(1, packetbuffer));
        this.setWealth(this.entityVillager, this.selectedMerchantRecipe);
        super.onGuiClosed();
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        //String s = this.chatComponent.getUnformattedText();
        //this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2 + 23, 6, 4210752);
        //this.fontRenderer.drawString(I18n.format("container.inventory"), 62, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        super.updateScreen();
        MerchantRecipeList merchantrecipelist = this.merchant.getRecipes(this.mc.player);

        if (merchantrecipelist != null)
        {
            this.tradingBookGui.update(merchantrecipelist, (ContainerVillager)this.inventorySlots);
        }

        Slot hoveredSlot = this.getSlotUnderMouse();
        this.tradingBookGui.hoveredSlot = hoveredSlot != null ? hoveredSlot.getHasStack() ? 2 : 1 : 0;

        if (((ContainerVillager)this.inventorySlots).haveTradingSlotsContents()) {
            this.ghostTrade.hide();
        }
    }

    protected boolean hasClickedOutside(int mouseX, int mouseY, int guiLeft, int guiTop)
    {
        boolean flag = mouseX < guiLeft || mouseY < guiTop || mouseX >= guiLeft + this.xSize || mouseY >= guiTop + this.ySize;
        return this.tradingBookGui.hasClickedOutside(mouseX, mouseY, this.guiLeft, this.guiTop, this.xSize, this.ySize) && flag;
    }

    /**
     * Draws the background layer of this container (behind the items).
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(MERCHANT_GUI_TEXTURE);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
        MerchantRecipeList merchantrecipelist = this.merchant.getRecipes(this.mc.player);

        if (merchantrecipelist != null)
        {
            int k = this.selectedMerchantRecipe;
            MerchantRecipe merchantrecipe = merchantrecipelist.get(k);

            if (merchantrecipe.isRecipeDisabled())
            {  merchantrecipe.increaseMaxTradeUses(9900000);
            }
        }

        GuiInventory.drawEntityOnScreen(i + 33, j + 75, 30, i + 33 - mouseX,
                j + 75 - 50 - mouseY, this.entityVillager);
    }

    /**
     * Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton
     */
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        int i = this.tradingBookGui.mouseClicked(mouseX, mouseY, mouseButton);

        switch (i) {
            case -2:
                return;
            case -1:
                super.mouseClicked(mouseX, mouseY, mouseButton);
                break;
            default:
                MerchantRecipeList merchantrecipelist = this.merchant.getRecipes(this.mc.player);
                if (merchantrecipelist != null) {
                    MerchantRecipe recipe = merchantrecipelist.get(i);
                    boolean flag = this.selectedMerchantRecipe != i;
                    boolean flag1 = this.tradingBookGui.hasRecipeContents(i);
                    boolean flag2 = recipe.isRecipeDisabled();
                    if (flag) {
                        this.selectedMerchantRecipe = i;
                        this.sendSelectedRecipe(!flag1 || flag2);
                    }
                    if (flag1) {
                        this.ghostTrade.hide();
                        if (!flag2) {
                            this.moveRecipeIngredients(flag, GuiScreen.isShiftKeyDown(), mouseButton == 1);
                        }
                    } else {
                        this.ghostTrade.setRecipe(recipe.getItemToBuy(), recipe.getSecondItemToBuy(), recipe.getItemToSell());
                        if (((ContainerVillager) this.inventorySlots).haveTradingSlotsContents()) {
                            this.sendSelectedRecipe(true);
                        }
                    }
                }

        }
    }

    private void sendSelectedRecipe(boolean clear) {
        ((ContainerVillager)this.inventorySlots).setCurrentRecipeIndex(this.selectedMerchantRecipe);
        if (clear) {
            ((ContainerVillager)this.inventorySlots).clearTradingSlots();
        }
        this.tradingBookGui.setSelectedTradingRecipe(this.selectedMerchantRecipe);
        PacketBuffer packetbuffer = new PacketBuffer(Unpooled.buffer());
        packetbuffer.writeByte(this.selectedMerchantRecipe);
        packetbuffer.writeBoolean(clear);
        RWBYNetworkHandler.sendToServer(new MessageTradingData(0, packetbuffer));
    }

    private void moveRecipeIngredients(boolean clear, boolean quickMove, boolean skipMove) {
        ((ContainerVillager)this.inventorySlots).handleClickedButtonItems(this.selectedMerchantRecipe, clear, quickMove, skipMove);
        PacketBuffer packetbuffer = new PacketBuffer(Unpooled.buffer());
        packetbuffer.writeByte(this.selectedMerchantRecipe);
        packetbuffer.writeBoolean(clear);
        packetbuffer.writeBoolean(quickMove);
        packetbuffer.writeBoolean(skipMove);
        RWBYNetworkHandler.sendToServer(new MessageTradingData(2, packetbuffer));
    }

    /**
     * Called when the mouse is clicked over a slot or outside the gui.
     */
    protected void handleMouseClick(Slot slotIn, int slotId, int mouseButton, ClickType type)
    {
        super.handleMouseClick(slotIn, slotId, mouseButton, type);
        this.tradingBookGui.countContents((ContainerVillager)this.inventorySlots);
        if (slotIn != null && slotId <= 2)
        {
            MerchantRecipeList merchantrecipelist = this.merchant.getRecipes(this.mc.player);
            if (merchantrecipelist != null && merchantrecipelist.size() > this.selectedMerchantRecipe) {
                if (!merchantrecipelist.get(this.selectedMerchantRecipe).hasSecondItemToBuy() && slotId == 1) {
                    return;
                }
                this.ghostTrade.hide();
            }
        }
    }

    /**
     * Called when a mouse button is released.
     */
    protected void mouseReleased(int mouseX, int mouseY, int state)
    {
        this.tradingBookGui.mouseReleased(mouseX, mouseY, state);
        super.mouseReleased(mouseX, mouseY, state);
    }

    /**
     * Handles mouse input.
     */
    public void handleMouseInput() throws IOException {
        this.tradingBookGui.handleMouseInput();
        super.handleMouseInput();
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        this.tradingBookGui.render(mouseX, mouseY, partialTicks);
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.ghostTrade.render(mc, this.guiLeft, this.guiTop);

        MerchantRecipeList merchantrecipelist = this.merchant.getRecipes(this.mc.player);

        if (merchantrecipelist != null)
        {
            int k = this.selectedMerchantRecipe;
            MerchantRecipe merchantrecipe = merchantrecipelist.get(k);
            GlStateManager.pushMatrix();
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.disableLighting();
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableColorMaterial();


            if (merchantrecipe.isRecipeDisabled() && this.isPointInRegion(97, 32, 28, 21, mouseX, mouseY))
            {
                this.drawHoveringText(I18n.format("merchant.deprecated"), mouseX, mouseY);
            }

            GlStateManager.popMatrix();
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
            RenderHelper.enableStandardItemLighting();
        }

        this.renderHoveredToolTip(mouseX, mouseY);
        this.tradingBookGui.renderHoveredTooltip(mouseX, mouseY);
        this.ghostTrade.renderHoveredTooltip(mc, mouseX, mouseY, this.guiLeft, this.guiTop);
    }

    /**
     * Fired when a key is typed (except F11 which toggles full screen). This is the equivalent of
     * KeyListener.keyTyped(KeyEvent e). Args : character (character on the key), keyCode (lwjgl Keyboard key code)
     */
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        if (!this.tradingBookGui.keyPressed(typedChar, keyCode))
        {
            super.keyTyped(typedChar, keyCode);
        }
    }

    public IMerchant getMerchant()
    {
        return this.merchant;
    }
}