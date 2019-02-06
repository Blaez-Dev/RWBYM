package be.bluexin.rwbym;

import be.bluexin.rwbym.utility.network.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ISemblance;
import be.bluexin.rwbym.capabilities.ruby.IRuby;
import be.bluexin.rwbym.capabilities.ruby.RubyProvider;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
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

	//this event only fires on client side, so if you need something done serverside you need to send packets,
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onKeyInput(KeyInputEvent event) {
				
		EntityPlayer player = Minecraft.getMinecraft().player;
	
		if (KeybindRegistry.activateSemblance.isPressed()) {
			RWBYModels.LOGGER.log(RWBYModels.debug, "Activating Semblance");
			
			ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);
			
			if (semblance != null) {
				RWBYNetworkHandler.sendToServer(new MessageActivateSemblance(true));
			}
		}
		else {
			ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);
			
			if (semblance != null) {
				RWBYNetworkHandler.sendToServer(new MessageActivateSemblance(false));
			}
		}

		//alternatively you could set a variable for key presses and call that variable in other classes with to check if a key is pressed.
		if (KeybindRegistry.activateSemblance.isKeyDown()) {
			activateSemblance = true;
		}
		else {
			activateSemblance = false;
		}
	}
}
