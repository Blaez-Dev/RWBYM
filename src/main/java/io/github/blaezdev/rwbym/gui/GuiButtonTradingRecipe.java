package io.github.blaezdev.rwbym.gui;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.gui.helper.TradingRecipe;
import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

@SideOnly(Side.CLIENT)
public class GuiButtonTradingRecipe extends GuiButton
{
    private static final ResourceLocation RECIPE_BOOK = new ResourceLocation(RWBYModels.MODID, "textures/gui/container/merchant_book.png");

    private ItemStack input;
    private ItemStack input1;
    private ItemStack output;
    private boolean soldOut;
    private int recipeId;
    private boolean selectedRecipe;
    private boolean hasContents;

    public GuiButtonTradingRecipe(int id, int posX, int posY)
    {
        super(id, posX, posY, 84, 22, "");
        this.input = ItemStack.EMPTY;
        this.input1 = ItemStack.EMPTY;
        this.output = ItemStack.EMPTY;
        this.visible = false;
    }

    public void setContents(int id, TradingRecipe recipe, boolean soldOut)
    {
        this.recipeId = id;
        this.input = recipe.getItemToBuy();
        this.input1 = recipe.getSecondItemToBuy();
        this.output = recipe.getItemToSell();
        this.soldOut = soldOut;
        this.selectedRecipe = recipe.getSelected();
        this.hasContents = recipe.hasRecipeContents();
    }

    public int getRecipeId() {
        return this.recipeId;
    }

    public void setPosition(int posX, int posY)
    {
        this.x = posX;
        this.y = posY;
    }

    /**
     * Draws this button to the screen.
     */
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
    {
        if (this.visible)
        {
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            RenderHelper.enableGUIStandardItemLighting();
            mc.getTextureManager().bindTexture(RECIPE_BOOK);
            GlStateManager.disableLighting();

            int i = 112;
            int j = 0;

            if (this.hovered) {
                j += 22;
            }

            if (!this.hasContents) {
                j += 88;
            }

            if (this.selectedRecipe) {
                j += 44;
            }

            this.drawTexturedModalRect(this.x, this.y, i, j, this.width, this.height);

            mc.getRenderItem().renderItemAndEffectIntoGUI(this.input, this.x + 6, this.y + 2);
            mc.getRenderItem().renderItemOverlays(mc.fontRenderer, this.input, this.x + 6, this.y + 2);
            if (!this.input1.isEmpty()) {
                mc.getRenderItem().renderItemAndEffectIntoGUI(this.input1, this.x + 27, this.y + 2);
                mc.getRenderItem().renderItemOverlays(mc.fontRenderer, this.input1, this.x + 27, this.y + 2);
            }
            mc.getRenderItem().renderItemAndEffectIntoGUI(this.output, this.x + 61, this.y + 2);
            mc.getRenderItem().renderItemOverlays(mc.fontRenderer, this.output, this.x + 61, this.y + 2);

            if (soldOut) {
                mc.getTextureManager().bindTexture(RECIPE_BOOK);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                GlStateManager.disableLighting();
                this.drawTexturedModalRect(this.x + 47, this.y + 3,  this.hasContents ? 0 : 10, 166, 10, 15);
            }

            GlStateManager.enableLighting();
            RenderHelper.disableStandardItemLighting();
        }
    }

    /**
     * Test if the 2D point is in a rectangle (relative to the GUI). Args : rectX, rectY, rectWidth, rectHeight, pointX,
     * pointY
     */
    private boolean isPointInRegion(int rectX, int rectY, int rectWidth, int rectHeight, int pointX, int pointY)
    {
        int i = this.x;
        int j = this.y;
        pointX = pointX - i;
        pointY = pointY - j;
        return pointX >= rectX - 1 && pointX < rectX + rectWidth + 1 && pointY >= rectY - 1 && pointY < rectY + rectHeight + 1;
    }

    public List<String> getToolTipText(GuiScreen screen, int mouseX, int mouseY)
    {
        ItemStack itemstack = this.getItemStackInRegion(mouseX, mouseY);
        List<String> list = Lists.<String>newArrayList();

        if (!itemstack.isEmpty()) {
            list = screen.getItemToolTip(itemstack);
        } else if (this.soldOut && this.isPointInRegion(47, 3, 10, 15, mouseX, mouseY))
        {
            list.add(I18n.format("merchant.deprecated"));
        }

        return list;
    }

    private ItemStack getItemStackInRegion(int mouseX, int mouseY) {

        if (this.isPointInRegion(6, 2, 16, 16, mouseX, mouseY) && !this.input.isEmpty())
        {
            return this.input;
        }
        else if (this.isPointInRegion(27, 2, 16, 16, mouseX, mouseY) && !this.input1.isEmpty())
        {
            return this.input1;
        }
        else if (this.isPointInRegion(61, 2, 16, 16, mouseX, mouseY) && !this.output.isEmpty())
        {
            return this.output;
        }
        else {
            return ItemStack.EMPTY;
        }

    }
}