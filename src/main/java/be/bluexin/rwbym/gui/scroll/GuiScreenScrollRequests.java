package be.bluexin.rwbym.gui.scroll;

import java.io.IOException;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ISemblance;
import be.bluexin.rwbym.capabilities.Aura.AuraProvider;
import be.bluexin.rwbym.capabilities.Aura.IAura;
import be.bluexin.rwbym.capabilities.team.ITeam;
import be.bluexin.rwbym.capabilities.team.Team;
import be.bluexin.rwbym.capabilities.team.TeamProvider;
import be.bluexin.rwbym.gui.GuiButtonScroll;
import be.bluexin.rwbym.gui.GuiButtonScrollSmall;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
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
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class GuiScreenScrollRequests extends GuiScreen {

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

	private EntityPlayer out[] = new EntityPlayer[4];
	private ItemStack outHeads[] = {ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY};
	
	private EntityPlayer in[] = new EntityPlayer[4];
	private ItemStack inHeads[] = {ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY};
	
	private GuiButton[][] actions = new GuiButton[3][4];
	private static final int ACCEPT = 0;
	private static final int DECLINE = 1;
	private static final int REMOVE = 2;
	
	private GuiTextField textbox;
	
	public GuiScreenScrollRequests(EntityPlayer playerIn) {
		this.player = playerIn;

		head = new ItemStack(Items.SKULL, 1, 3);

		NBTTagCompound nbt = head.getTagCompound();

		if (nbt == null) {
			nbt = new NBTTagCompound();
			head.setTagCompound(nbt);
		}

		nbt.setString("SkullOwner", playerIn.getName());
		
		if (playerIn.world.hasCapability(TeamProvider.TEAM_CAP, null)) {
			ITeam teams = playerIn.world.getCapability(TeamProvider.TEAM_CAP, null);
			
			for (int i = 0; i < teams.getReceivedRequests(player).size(); i++) {
				this.addPlayer(teams.getReceivedRequests(player).get(i).getSender(), in, inHeads, i);
			}
			
			for (int i = 0; i < teams.getSentRequests(player).size() && i < 4; i++) {
				this.addPlayer(teams.getSentRequests(player).get(i).getReceiver(), out, outHeads, i);
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

		this.addButton(new GuiButtonScroll(0, x+2, y+2, 9, 9, 0, 227, 9, 9, 0, ""));
		this.addButton(new GuiButtonScroll(1, x+2 + 8, y+2, 9, 9, 8, 227, 9, 9, 0, ""));
		this.addButton(new GuiButtonScroll(2, x+2 + 16, y+2, 9, 9, 16, 227, 9, 9, 0, ""));
		this.addButton(new GuiButtonScroll(3, x+2 + 24, y+2, 9, 9, 24, 227, 9, 9, 0, ""));
		
		textbox = new GuiTextField(4, fontRenderer, x + texturex / 2 - 39, y + 26, 78, 13);
		this.addButton(new GuiButtonScroll(4, x + texturex/2 - 40, y + 40, 80, 14, texturex, 0, 90, 14, 12, "Send Request"));
				
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				actions[i][j] = this.addButton(new GuiButtonScrollSmall((i+1) << 4 | j, x + 40 + (i == REMOVE ? 50 : 0), y + 85 + 32 * j + (i == DECLINE ? 14 : i == REMOVE ? 4 : 0), 40, 14, texturex, 0, 90, 14, 12, i == ACCEPT ? "Accept" : i == DECLINE ? "Decline" : "Remove"));
			}
		}
	}
	
	@Override
	public void updateScreen() {
		
		for (int i = 0; i < 4; i++) {
			
			boolean flag1 = in[i] != null;
			actions[ACCEPT][i].visible = flag1;
			actions[DECLINE][i].visible = flag1;
			
			boolean flag2 = out[i] != null;
			actions[REMOVE][i].visible = flag2;
			
		}
		
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();

		mc.getTextureManager().bindTexture(SCROLL_GUI_TEXTURE);

		this.drawTexturedModalRect(x, y, 0, 0, texturex, texturey);
		
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		this.drawCenteredString(fontRenderer, "Sent", x + 90, y + 70, 0xffffff);
		this.drawCenteredString(fontRenderer, "Received", x + 37, y + 70, 0xffffff);
		
		this.renderPlayers();
		
		GlStateManager.color(1,  1,  1,  1);
		textbox.drawTextBox();

		GlStateManager.disableBlend();
		GlStateManager.disableAlpha();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		
		if (button.id == 0) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiScreenScrollTeam(this.player));
		}
		else if (button.id == 2) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiScreenScrollRequests(this.player));
		}
		else if (button.id == 3) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiScreenScrollLevel(this.player));
		}
		else if (button.id == 4) {
			System.out.println("Request");
			EntityPlayer otherPlayer = mc.world.getPlayerEntityByName(textbox.getText());
			if (otherPlayer != null) {
				mc.world.getCapability(TeamProvider.TEAM_CAP, null).sendRequest(player, otherPlayer);
			}
			else {
				mc.player.sendMessage(new TextComponentString("Player Not Found"));
			}
		}
		else {
			
			if (mc.world.hasCapability(TeamProvider.TEAM_CAP, null)) {
			
				ITeam teams = mc.world.getCapability(TeamProvider.TEAM_CAP, null);
				
				int i = (button.id >> 4) - 1;
				int j = button.id & 0x0F;
				
				if (i == ACCEPT) {
					teams.confirmRequest(in[j], player);
				}
				else if (i == DECLINE) {
					teams.denyRequest(in[j], player);
				}
				else if (i == REMOVE) {
					teams.denyRequest(player, out[j]);
				}
				
			}
						
		}
		
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		textbox.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
		textbox.textboxKeyTyped(typedChar, keyCode);
		if (textbox.isFocused()) {
			if (keyCode == Keyboard.KEY_RETURN) {
				GuiButton button = null;
				for (GuiButton b : this.buttonList) {
					if (b.id == 4) {
						button = b;
					}
				}
				if (button != null) {
					this.actionPerformed(button);
				}
			}
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
	
	private void addPlayer(@Nullable EntityPlayer playerIn, EntityPlayer[] playerList, ItemStack[] headList, int index) {

		playerList[index] = playerIn;

		if (playerIn != null) {
			headList[index] = new ItemStack(Items.SKULL, 1, 3);

			NBTTagCompound nbt = headList[index].getTagCompound();

			if (nbt == null) {
				nbt = new NBTTagCompound();
				headList[index].setTagCompound(nbt);
			}

			nbt.setString("SkullOwner", playerIn.getName());
		}
		else {
			headList[index] = ItemStack.EMPTY;
		}

	}

	private void renderPlayers() {
		int sizex = this.width;
		int sizey = this.height - 21;

		for (int i = 0; i < 4; i++) {
		
			if (in[i] != null) {
				this.renderItemModelIntoGUI(inHeads[i], x + 20, y + 92 + 32 * i, 2);
				GlStateManager.pushMatrix();
				GlStateManager.scale(0.5, 0.5, 0.5);
				this.drawCenteredString(fontRenderer, in[i].getName(), (x + 20) * 2, (y + 92 + 32 * i + 10) * 2, 0xffffff);
				GlStateManager.popMatrix();
			}
			
			if (out[i] != null) {
				this.renderItemModelIntoGUI(outHeads[i], x + 80, y + 92 + 32 * i, 2);
				GlStateManager.pushMatrix();
				GlStateManager.scale(0.5, 0.5, 0.5);
				this.drawCenteredString(fontRenderer, out[i].getName(), (x + 80) * 2, (y + 92 + 32 * i + 10) * 2, 0xffffff);
				GlStateManager.popMatrix();
			}
		
		}
	}
	
}
