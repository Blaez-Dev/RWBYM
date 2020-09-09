package io.github.blaezdev.rwbym;

import io.github.blaezdev.rwbym.capabilities.CapabilityHandler;
import io.github.blaezdev.rwbym.capabilities.ISemblance;
import io.github.blaezdev.rwbym.utility.network.MessageActivateSemblance;
import io.github.blaezdev.rwbym.utility.network.MessageCycleLevel;
import io.github.blaezdev.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

public class KeyInputHandler {

	public boolean activateSemblance;
	public boolean morphWeapon;

	//this event only fires on client side, so if you need something done server side you need to send packets,
	@SubscribeEvent
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
	
	private static final boolean[][] STATES = new boolean[KeyPresses.values().length][2];
//	{
//		for (int i = 0; i < KeyPresses.values().length; i++) {
//			STATES[i][0] = false;
//			STATES[i][1] = false;
//		}
//	}
	
	@SubscribeEvent
	public void onClientTick(ClientTickEvent event) {
		if (event.phase == Phase.START) {
			for (KeyPresses key : KeyPresses.values()) {
				STATES[key.ordinal()][1] = STATES[key.ordinal()][0];
				STATES[key.ordinal()][0] = key.getKeybind().isKeyDown();
			}
		}
	}
	
	public enum KeyPresses {
		ADS(Minecraft.getMinecraft().gameSettings.keyBindUseItem.getKeyCode()),
		SLIDELOCK_BOLT(Keyboard.KEY_T),
		REMOVEBULLET_SLIDE(Keyboard.KEY_R),
		SHOOT(Minecraft.getMinecraft().gameSettings.keyBindAttack.getKeyCode()),
		HAMMER(Keyboard.KEY_V),
		MAGRELEASE(Keyboard.KEY_G),
		INSERT(Keyboard.KEY_Z);
		
		private final int keyCode;
		
		private final KeyBinding keybind;
		
		KeyPresses(int keyCode) {
			this.keyCode = keyCode;
			this.keybind = new KeyBinding(this.toString(), this.getKeyCode(), "key.categories.RWBYM.special");
		}
				
		public int getKeyCode() {
			return keyCode;
		}
		
		public KeyBinding getKeybind() {
			return keybind;
		}
	}
	
	public static boolean isKeyDown(KeyPresses key) {
		return STATES[key.ordinal()][0];
	}
	
	public static boolean isKeyPressed(KeyPresses key) {
		return STATES[key.ordinal()][0] && !STATES[key.ordinal()][1];
	}
	
	public static boolean isKeyUnpressed(KeyPresses key) {
		return !STATES[key.ordinal()][0] && STATES[key.ordinal()][1];
	}
}
