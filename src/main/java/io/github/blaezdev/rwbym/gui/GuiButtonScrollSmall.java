package io.github.blaezdev.rwbym.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class GuiButtonScrollSmall extends GuiButtonScroll {

	public GuiButtonScrollSmall(int buttonId, int x, int y, int widthIn, int heightIn, int texturex, int texturey, int texturedx, int texturedy, int deltay, String buttonText) {
		super(buttonId, x, y, widthIn, heightIn, texturex, texturey, texturedx, texturedy, deltay, buttonText);
	}
	
	@Override
	public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
        return this.enabled && this.visible && mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width/2 && mouseY < this.y + this.height/2;
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {

		GlStateManager.pushMatrix();
		GlStateManager.translate(x/2, y/2, 0);
		GlStateManager.scale(0.5, 0.5, 0.5);
        if (this.visible) {
            FontRenderer fontrenderer = mc.fontRenderer;
            mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width/2 && mouseY < this.y + this.height/2;
            int i = this.getHoverState(this.hovered);
            int offsetx = texturedx - this.width / 2;
            int offsety = texturedy - this.height / 2;
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            
            int w1 = this.width / 2;
            int w2 = Math.round(this.width / 2F + 0.01F);
            
            int h1 = this.height / 2;
            int h2 = Math.round(this.height / 2F + 0.01F);
            
            this.drawTexturedModalRect(this.x, this.y, texturex, texturey + i * deltay, w1, h1);
            this.drawTexturedModalRect(this.x + w1, this.y, texturex + texturedx - w2, texturey + i * deltay, w2, h1);
            this.drawTexturedModalRect(this.x, this.y + h1, texturex, texturey + texturedy - h2 + i * deltay, w1, h2);
            this.drawTexturedModalRect(this.x + w1, this.y + h1, texturex + texturedx - w2, texturey + texturedy- h2 + i * deltay, w2, h2);
            this.mouseDragged(mc, mouseX, mouseY);
            int j = 14737632;

            if (packedFGColour != 0)
            {
                j = packedFGColour;
            }
            else
            if (!this.enabled)
            {
                j = 10526880;
            }
            else if (this.hovered)
            {
                j = 16777120;
            }

            this.drawCenteredString(fontrenderer, this.displayString, this.x + this.width / 2, this.y + (this.height - 8) / 2, j);
        }		
        GlStateManager.popMatrix();
	}

}
