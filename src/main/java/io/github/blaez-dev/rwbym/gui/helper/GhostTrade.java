package io.github.blaez-dev.rwbym.gui.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GhostTrade
{
    private ItemStack[] recipe = {ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY};
    private final int[] posX = {76, 76, 134};
    private final int[] posY = {22, 48, 35};
    private boolean hidden = true;

    public void hide()
    {
        this.hidden = true;
    }

    public void setRecipe(ItemStack itemStack, ItemStack itemStack1, ItemStack itemStack2)
    {
        this.recipe[0] = itemStack;
        this.recipe[1] = itemStack1;
        this.recipe[2] = itemStack2;
        this.hidden = false;
    }

    public void render(Minecraft mc, int left, int top)
    {
        if (!this.hidden) {
            for (int i = 0; i <= 2; i++) {

                int j = posX[i] + left;
                int k = posY[i] + top;
                ItemStack itemstack = this.recipe[i];

                if (!itemstack.isEmpty()) {
                    RenderHelper.enableGUIStandardItemLighting();
                    GlStateManager.disableLighting();
                    if (i == 2) {
                        Gui.drawRect(j - 4, k - 4, j + 20, k + 20, 822018048);
                    } else {
                        Gui.drawRect(j, k, j + 16, k + 16, 822018048);
                    }
                    GlStateManager.disableLighting();
                    mc.getRenderItem().renderItemAndEffectIntoGUI(mc.player, itemstack, j, k);
                    GlStateManager.depthFunc(516);
                    Gui.drawRect(j, k, j + 16, k + 16, 822083583);
                    GlStateManager.depthFunc(515);
                    mc.getRenderItem().renderItemOverlays(mc.fontRenderer, itemstack, j, k);
                    GlStateManager.enableLighting();
                    RenderHelper.disableStandardItemLighting();

                }
            }
        }
    }

    public void renderHoveredTooltip(Minecraft mc, int mouseX, int mouseY, int left, int top)
    {
        if (!this.hidden) {
            ItemStack itemstack = ItemStack.EMPTY;

            for (int i = 0; i <= 2; i++) {
                int j = posX[i] + left;
                int k = posY[i] + top;

                if (mouseX >= j && mouseY >= k && mouseX < j + 16 && mouseY < k + 16) {
                    itemstack = this.recipe[i];
                }
            }

            if (!itemstack.isEmpty() && mc.currentScreen != null) {
                mc.currentScreen.drawHoveringText(mc.currentScreen.getItemToolTip(itemstack), mouseX, mouseY);
            }
        }
    }
}