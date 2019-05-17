package be.bluexin.rwbym;

import be.bluexin.rwbym.utility.network.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ISemblance;
import be.bluexin.rwbym.capabilities.Ragora.IRagora;
import be.bluexin.rwbym.capabilities.Ruby.IRuby;
import be.bluexin.rwbym.capabilities.Ruby.RubyProvider;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KeyInputHandler {

	public boolean activateSemblance;
	public boolean morphWeapon;

	//this event only fires on client side, so if you need something done server side you need to send packets,
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onKeyInput(KeyInputEvent event) {
		
		Minecraft mc = Minecraft.getMinecraft();
				
		EntityPlayer player = mc.player;
		
		ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);
		
		if (semblance != null && semblance.isMovementBlocked()) {
			KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
			KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
			KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
			KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
			KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
			KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
		}
		
		
	
		if (KeybindRegistry.activateSemblance.isPressed()) {
			RWBYModels.LOGGER.log(RWBYModels.debug, "Activating Semblance");
			if (semblance != null) {
				RWBYNetworkHandler.sendToServer(new MessageActivateSemblance(true));
			}
		}
		else {			
			if (semblance != null) {
				RWBYNetworkHandler.sendToServer(new MessageActivateSemblance(false));
			}
		}
		
		if (KeybindRegistry.cycleLevel.isPressed()) {
			RWBYModels.LOGGER.log(RWBYModels.debug, "Cycling Level");
			if (semblance != null) {
				RWBYNetworkHandler.sendToServer(new MessageCycleLevel());
			}
		}
	}
}
