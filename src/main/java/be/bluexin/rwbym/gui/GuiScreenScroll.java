package be.bluexin.rwbym.gui;

import java.io.IOException;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ISemblance;
import be.bluexin.rwbym.capabilities.Aura.AuraProvider;
import be.bluexin.rwbym.capabilities.Aura.IAura;
import be.bluexin.rwbym.utility.network.MessageSendPlayerDataToServer;
import be.bluexin.rwbym.utility.network.MessagePlayerEXP;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiScreenScroll extends GuiScreen {
	
	private static final ResourceLocation SCROLL_GUI_TEXTURE = new ResourceLocation(RWBYModels.MODID, "textures/gui/scroll.png");
	
	private final int texturex = 128;
	private final int texturey = 210;
	
	private final int barx = 81;
	private final int bary = 9;
	
	private Minecraft mc;
	
	private EntityPlayer players[] = new EntityPlayer[4];
	
	private ItemStack heads[] = {ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY};
	
	private GuiButton button1, button2, button3, button4;

	public GuiScreenScroll(EntityPlayer player) {
		this.addPlayer(player, 0);
		
		//this.addPlayer(player, 1);
		//this.addPlayer(player, 2);
		//this.addPlayer(player, 3);
	}
	
	@Override
	public void initGui() {
		super.initGui();
		this.mc = Minecraft.getMinecraft();
		
		this.allowUserInput = true;
		
        this.buttonList.clear();
        this.button1 = this.addButton(new GuiButtonScroll(0, (this.width - 104) / 2, (this.height - 21) / 2 - texturey * 4 / 40, 90, 14, texturex, 0, 90, 14, 12, "Lvl Aura: "));
        this.button2 = this.addButton(new GuiButtonScroll(1, (this.width + 76) / 2, (this.height - 21) / 2 - texturey * 4 / 40, 14, 14, texturex, 0, 90, 14, 12, "M"));
        
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		IAura aura = this.players[0].getCapability(AuraProvider.AURA_CAP, null);
		while(aura != null && !(this.players[0].experienceTotal < aura.getEXPToLevel())) {
			RWBYNetworkHandler.sendToServer(new MessagePlayerEXP(-aura.getEXPToLevel()));
			this.players[0].experienceTotal -= aura.getEXPToLevel();
			aura.addToMax(1);
			RWBYNetworkHandler.sendToServer(new MessageSendPlayerDataToServer(this.players[0]));
			if (button.id == 0) break;
		}
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if (keyCode == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
			this.mc.displayGuiScreen(null);
		}
	}
	
	@Override
	public void updateScreen() {
		IAura aura = this.players[0].getCapability(AuraProvider.AURA_CAP, null);
		if (aura != null) {
			this.button1.enabled = aura != null && !(this.players[0].experienceTotal < aura.getEXPToLevel());
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
		this.drawTexturedModalRect((sizex - texturex) / 2, (sizey - texturey) / 2, 0, 0, texturex, texturey);
		
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
		
			this.drawCenteredString(fontRenderer, Integer.toString((int)(aura.getMaxAura() * aura.getPercentage())) + " / " + Integer.toString(aura.getMaxAura()), posx + barx / 2, posy + texturey * 2 / 40, 255<<16|255<<8|255);
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
