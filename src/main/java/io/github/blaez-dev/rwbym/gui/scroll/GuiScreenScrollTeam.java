

package io.github.blaez-dev.rwbym.gui.scroll;

import io.github.blaez-dev.rwbym.RWBYModels;
import io.github.blaez-dev.rwbym.capabilities.Aura.AuraProvider;
import io.github.blaez-dev.rwbym.capabilities.Aura.IAura;
import io.github.blaez-dev.rwbym.capabilities.CapabilityHandler;
import io.github.blaez-dev.rwbym.capabilities.ISemblance;
import io.github.blaez-dev.rwbym.capabilities.team.ITeam;
import io.github.blaez-dev.rwbym.capabilities.team.TeamProvider;
import io.github.blaez-dev.rwbym.gui.GuiButtonScroll;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.io.IOException;

public class GuiScreenScrollTeam extends GuiScreen {

	private static final ResourceLocation SCROLL_GUI_TEXTURE = new ResourceLocation(RWBYModels.MODID, "textures/gui/scroll.png");

	private final int texturex = 128;
	private final int texturey = 210;
	
	private int x;
	private int y;

	private final int barx = 81;
	private final int bary = 9;

	private Minecraft mc;

	private EntityPlayer players[] = new EntityPlayer[4];

	private ItemStack heads[] = {ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY};
	
	private GuiButton leaveButton;

	public GuiScreenScrollTeam(EntityPlayer player) {
		
		this.addPlayer(player, 0);
		
		if (Minecraft.getMinecraft().world.hasCapability(TeamProvider.TEAM_CAP, null)) {
			
			ITeam team = Minecraft.getMinecraft().world.getCapability(TeamProvider.TEAM_CAP, null);
			int i = 1;
			for (EntityPlayer member : team.getTeam(player)) {
				this.addPlayer(member, i);
				i++;
			}
			
		}
		
	}

	@Override
	public void initGui() {
		super.initGui();
		
		x = (this.width - texturex) / 2;
		y = (this.height - 21 - texturey) / 2;
		
		this.mc = Minecraft.getMinecraft();

		this.allowUserInput = true;

		this.buttonList.clear();
		this.addButton(new GuiButtonScroll(0, x+2, y+2, 9, 9, 0, 227, 9, 9, 0, ""));
		this.addButton(new GuiButtonScroll(1, x+2 + 8, y+2, 9, 9, 8, 227, 9, 9, 0, ""));
		this.addButton(new GuiButtonScroll(2, x+2 + 16, y+2, 9, 9, 16, 227, 9, 9, 0, ""));
		this.addButton(new GuiButtonScroll(3, x+2 + 24, y+2, 9, 9, 24, 227, 9, 9, 0, ""));
		
		leaveButton = this.addButton(new GuiButtonScroll(4, x + (texturex - 70) / 2, y + 90, 70, 14, texturex, 0, 90, 14, 12, "Leave Team"));
		leaveButton.visible = false;

	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		
		if (button.id == 0) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiScreenScrollTeam(this.players[0]));
		}
		else if (button.id == 2) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiScreenScrollRequests(this.players[0]));
		}
		else if (button.id == 3) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiScreenScrollLevel(this.players[0]));
		}
		else if (button.id == 4) {
			if (Minecraft.getMinecraft().world.hasCapability(TeamProvider.TEAM_CAP, null)) {
				Minecraft.getMinecraft().world.getCapability(TeamProvider.TEAM_CAP, null).leaveTeam(this.players[0]);
			}
		}
		
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
		if (keyCode == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
			this.mc.displayGuiScreen(null);
		}
	}

	@Override
	public void updateScreen() {
		leaveButton.visible = players[1] != null || players[2] != null || players[3] != null;
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

		this.renderBar((sizex - barx) / 2, sizey / 2 - texturey * 9 / 40, players[0]);

		this.renderItemModelIntoGUI(heads[0], sizex / 2, sizey / 2 - texturey * 7 / 20, 4);

		this.renderPlayer(1);
		this.renderPlayer(2);
		this.renderPlayer(3);

		super.drawScreen(mouseX, mouseY, partialTicks);

		GlStateManager.disableBlend();
		GlStateManager.disableAlpha();
	}

	/**
	 * Draws an entity on the screen.
	 */
	public static void drawEntityOnScreen(int posX, int posY, int scale, EntityLivingBase ent)
	{
		GlStateManager.enableColorMaterial();
		GlStateManager.pushMatrix();
		GlStateManager.translate((float)posX, (float)posY, 50.0F);
		GlStateManager.scale((float)(-scale), (float)scale, (float)scale);
		GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
		float f = ent.renderYawOffset;
		float f1 = ent.rotationYaw;
		float f2 = ent.rotationPitch;
		float f3 = ent.prevRotationYawHead;
		float f4 = ent.rotationYawHead;
		GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
		ent.renderYawOffset = 0;
		ent.rotationYaw = 0;
		ent.rotationPitch = 0;
		ent.rotationYawHead = ent.rotationYaw;
		ent.prevRotationYawHead = ent.rotationYaw;
		GlStateManager.translate(0.0F, 0.0F, 0.0F);
		RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
		rendermanager.setPlayerViewY(180.0F);
		rendermanager.setRenderShadow(false);
		rendermanager.renderEntity(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
		rendermanager.setRenderShadow(true);
		ent.renderYawOffset = f;
		ent.rotationYaw = f1;
		ent.rotationPitch = f2;
		ent.prevRotationYawHead = f3;
		ent.rotationYawHead = f4;
		GlStateManager.popMatrix();
		RenderHelper.disableStandardItemLighting();
		GlStateManager.disableRescaleNormal();
		GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GlStateManager.disableTexture2D();
		GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
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

	private void addPlayer(@Nullable EntityPlayer playerIn, int index) {

		this.players[index] = playerIn;

		if (playerIn != null) {
			heads[index] = new ItemStack(Items.SKULL, 1, 3);

			NBTTagCompound nbt = heads[index].getTagCompound();

			if (nbt == null) {
				nbt = new NBTTagCompound();
				heads[index].setTagCompound(nbt);
			}

			nbt.setString("SkullOwner", playerIn.getName());
		}
		else {
			heads[index] = ItemStack.EMPTY;
		}

	}

	private void renderPlayer(int index) {
		int sizex = this.width;
		int sizey = this.height - 21;

		if (players[index] != null) {

			this.renderBar((sizex - barx) / 2 + 10, sizey / 2 - texturey * (1 - 3*index) / 20 - 5, players[index]);

			this.renderItemModelIntoGUI(heads[index], sizex / 2 - 45, sizey / 2 - texturey * (1 - 3*index) / 20, 2);

		}
	}
	
}