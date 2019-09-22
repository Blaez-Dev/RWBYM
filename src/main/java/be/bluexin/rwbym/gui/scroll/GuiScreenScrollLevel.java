package be.bluexin.rwbym.gui.scroll;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.capabilities.Aura.AuraProvider;
import be.bluexin.rwbym.capabilities.Aura.IAura;
import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ISemblance;
import be.bluexin.rwbym.gui.GuiButtonScroll;
import be.bluexin.rwbym.utility.network.MessagePlayerEXP;
import be.bluexin.rwbym.utility.network.MessageSendPlayerDataToServer;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.io.IOException;

public class GuiScreenScrollLevel extends GuiScreen {

	private static final ResourceLocation SCROLL_GUI_TEXTURE = new ResourceLocation(RWBYModels.MODID, "textures/gui/scroll.png");

	private final int texturex = 128;
	private final int texturey = 210;
	
	private int x;
	private int y;

	private final int barx = 81;
	private final int bary = 9;

	private Minecraft mc;

	private EntityPlayer player;
	private ItemStack head;

	private GuiButton button1, button2;
	
	public GuiScreenScrollLevel(EntityPlayer playerIn) {
		this.player = playerIn;

		head = new ItemStack(Items.SKULL, 1, 3);

		NBTTagCompound nbt = head.getTagCompound();

		if (nbt == null) {
			nbt = new NBTTagCompound();
			head.setTagCompound(nbt);
		}

		nbt.setString("SkullOwner", playerIn.getName());
	}
	
	@Override
	public void initGui() {
		super.initGui();
		
		x = (this.width - texturex) / 2;
		y = (this.height - 21 - texturey) / 2;
		
		this.mc = Minecraft.getMinecraft();

		this.allowUserInput = true;

		this.button1 = this.addButton(new GuiButtonScroll(0, (this.width - 104) / 2, (this.height - 21) / 2 - texturey * 4 / 40, 90, 14, texturex, 0, 90, 14, 12, "Lvl Aura: "));
		this.button2 = this.addButton(new GuiButtonScroll(1, (this.width + 76) / 2, (this.height - 21) / 2 - texturey * 4 / 40, 14, 14, texturex, 0, 90, 14, 12, "M"));
		this.addButton(new GuiButtonScroll(2, x+2, y+2, 9, 9, 0, 227, 9, 9, 0, ""));
		this.addButton(new GuiButtonScroll(3, x+2 + 8, y+2, 9, 9, 8, 227, 9, 9, 0, ""));
		this.addButton(new GuiButtonScroll(4, x+2 + 16, y+2, 9, 9, 16, 227, 9, 9, 0, ""));
		this.addButton(new GuiButtonScroll(5, x+2 + 24, y+2, 9, 9, 24, 227, 9, 9, 0, ""));
	}
	
	@Override
	public void updateScreen() {
		IAura aura = this.player.getCapability(AuraProvider.AURA_CAP, null);
		if (aura != null) {
			this.button1.enabled = aura != null && !(RWBYModels.getXpTotal(player) < aura.getEXPToLevel());
			this.button1.displayString = "Lvl Aura: " + aura.getEXPToLevel();
		}
		else {
			this.button1.enabled = false;
		}
		this.button2.enabled = this.button1.enabled;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();

		mc.getTextureManager().bindTexture(SCROLL_GUI_TEXTURE);
		int sizex = this.width;
		int sizey = this.height - 21;
		this.drawTexturedModalRect(x, y, 0, 0, texturex, texturey);
		
		this.drawTexturedModalRect(x + 42, y + 11, texturex, 38, 43, 42);

		this.renderBar((sizex - barx) / 2, sizey / 2 - texturey * 9 / 40, player);

		this.renderItemModelIntoGUI(head, sizex / 2, sizey / 2 - texturey * 7 / 20, 4);

		super.drawScreen(mouseX, mouseY, partialTicks);

		GlStateManager.disableBlend();
		GlStateManager.disableAlpha();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		IAura aura = this.player.getCapability(AuraProvider.AURA_CAP, null);
		if (button.id < 2) {
			while(aura != null && !(RWBYModels.getXpTotal(player) < aura.getEXPToLevel())) {
				RWBYModels.addXp(-aura.getEXPToLevel(), player);
				RWBYNetworkHandler.sendToServer(new MessagePlayerEXP(-aura.getEXPToLevel()));
				aura.addToMax(1);
				RWBYNetworkHandler.sendToServer(new MessageSendPlayerDataToServer(this.player));
				if (button.id == 0) break;
			}
		}
		else if (button.id == 2) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiScreenScrollTeam(this.player));
		}
		else if (button.id == 4) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiScreenScrollRequests(this.player));
		}
		else if (button.id == 5) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiScreenScrollLevel(this.player));
		}
		
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
		if (keyCode == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
			this.mc.displayGuiScreen(null);
		}
	}
	
	private void renderBar(int posx, int posy, EntityPlayer player) {

		int width = 0;

		IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);

		if (aura != null) {
			width = (int) (aura.getPercentage() * (barx - 2));
		}

		this.drawTexturedModalRect(posx + 1, posy + 1, 0, texturey + 10, width, bary - 2);

		float color[] = new float[3];

		ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);

		if (semblance != null) {
			color = semblance.getColor();
			GlStateManager.color(color[0], color[1], color[2]);
		}

		this.drawTexturedModalRect(posx, posy, 0, texturey, barx, bary);

		if (aura != null) {

			//this.drawCenteredString(fontRenderer, "0", posx, posy - texturey * 2 / 40, 255<<16|0<<8|0);

			//this.drawCenteredString(fontRenderer, Integer.toString(aura.getMaxAura()), posx + barx, posy - texturey * 2 / 40, 255<<16|255<<8|0);

			//this.drawCenteredString(fontRenderer, Integer.toString((int) (aura.getMaxAura() * aura.getPercentage())), posx + width, posy + texturey * 2 / 40, 255<<16|(int)(255 * aura.getPercentage())<<8|0);

			this.drawCenteredString(fontRenderer, Integer.toString((int)(aura.getMaxAura() * aura.getPercentage())) + " / " + Integer.toString((int)aura.getMaxAura()), posx + barx / 2, posy + texturey * 2 / 40, 255<<16|255<<8|255);
		}
	}
	
	protected void renderItemModelIntoGUI(ItemStack stack, int x, int y, int scale)
	{

		IBakedModel bakedmodel = mc.getRenderItem().getItemModelWithOverrides(stack, (World)null, (EntityLivingBase)null);

		GlStateManager.pushMatrix();
		mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		mc.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
		GlStateManager.enableRescaleNormal();
		GlStateManager.enableAlpha();
		GlStateManager.alphaFunc(516, 0.1F);
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.setupGuiTransform(x, y, bakedmodel.isGui3d());
		GlStateManager.translate(0, 0.25F * scale, 0);
		GlStateManager.scale(scale, scale, scale);
		GlStateManager.disableLighting();
		bakedmodel = net.minecraftforge.client.ForgeHooksClient.handleCameraTransforms(bakedmodel, ItemCameraTransforms.TransformType.HEAD, false);
		mc.getRenderItem().renderItem(stack, bakedmodel);
		GlStateManager.disableAlpha();
		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
		mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		mc.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
		mc.getTextureManager().bindTexture(SCROLL_GUI_TEXTURE);
	}
	
	private void setupGuiTransform(int xPosition, int yPosition, boolean isGui3d)
	{
		GlStateManager.translate((float)xPosition, (float)yPosition, 100.0F + this.zLevel);
		GlStateManager.scale(1.0F, -1.0F, 1.0F);
		GlStateManager.scale(16.0F, 16.0F, 16.0F);

		if (isGui3d)
		{
			GlStateManager.enableLighting();
		}
		else
		{
			GlStateManager.disableLighting();
		}
	}
	
}
