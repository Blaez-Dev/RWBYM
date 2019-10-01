package io.github.blaez-dev.rwbym;

import io.github.blaez-dev.rwbym.capabilities.CapabilityHandler;
import io.github.blaez-dev.rwbym.capabilities.ISemblance;
import io.github.blaez-dev.rwbym.utility.network.MessageActivateSemblance;
import io.github.blaez-dev.rwbym.utility.network.MessageCycleLevel;
import io.github.blaez-dev.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
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
