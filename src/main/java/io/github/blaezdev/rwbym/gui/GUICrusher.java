package io.github.blaezdev.rwbym.gui;
import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.blocks.containers.CrusherContainer;
import io.github.blaezdev.rwbym.blocks.tileentities.TileEntityRWBYCrusher;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GUICrusher extends GuiContainer
{
    private static final ResourceLocation TEXTURES = new ResourceLocation(RWBYModels.MODID + ":textures/gui/crusher.png");
    private final InventoryPlayer player;
    private final TileEntityRWBYCrusher tileentity;

    public GUICrusher(InventoryPlayer player, TileEntityRWBYCrusher tileentity)
    {
        super(new CrusherContainer(player, tileentity));
        this.player = player;
        this.tileentity = tileentity;
    }


    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String tileName = this.tileentity.getDisplayName().getUnformattedText();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(TEXTURES);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        if(TileEntityRWBYCrusher.isBurning(tileentity))
        {
            int k = this.getBurnLeftScaled(13);
            this.drawTexturedModalRect(this.guiLeft + 8, this.guiTop + 54 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.getCookProgressScaled(24);
        this.drawTexturedModalRect(this.guiLeft + 44, this.guiTop + 36, 176, 14, l + 1, 16);
    }

    private int getBurnLeftScaled(int pixels)
    {
        int i = this.tileentity.getField(1);
        if(i == 0) i = 200;
        return this.tileentity.getField(0) * pixels / i;
    }

    private int getCookProgressScaled(int pixels)
    {
        int i = this.tileentity.getField(2);
        int j = this.tileentity.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }
}