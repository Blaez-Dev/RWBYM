package be.bluexin.rwbym;

import be.bluexin.rwbym.utility.network.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import be.bluexin.rwbym.RWBYModels;
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
	//or read variables from this class such as the one above.
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onKeyInput(KeyInputEvent event) {
				
		EntityPlayer player = Minecraft.getMinecraft().player;
	
		/*if (KeybindRegistry.activateSemblance.isKeyDown()) {
			
			IRuby Ruby = player.getCapability(RubyProvider.RUBY_CAP, null);
											
			Ruby.activate(player);
			
			RWBYNetworkHandler.sendToServer(new MessageRose(true));
			
			/*
			//Rose Semblance Level I
			if (player.onGround){
				Vec3d look = player.getLookVec();
				player.motionX = look.x;
				player.motionZ = look.z;
				player.motionY = look.y * 2;
				player.lastTickPosZ = -look.x;
				player.lastTickPosX = -look.z;
				RWBYNetworkHandler.sendToServer(new MessageRose(5));} 
			*/
			/*player.sendMessage(new TextComponentString("I worked Master"));
				/*for (int i = 0; i < 32; ++i) {
					RWBYModels.proxy.generateRosepetals(player);
				}*/

			//Rose Semblance Level  ((this need's something hooked into it instead of using player.onGround)) 
			/*
			if (player.onGround){
				Vec3d look = player.getLookVec();
				player.motionX = look.x;
				player.motionZ = look.z;
				player.motionY = look.y * 2;
				player.lastTickPosZ = -look.x;
				player.lastTickPosX = -look.z;
				RWBYNetworkHandler.sendToServer(new MessageRose(5));
				}
			*/
		}/*
		else {
			IRuby Ruby = player.getCapability(RubyProvider.RUBY_CAP, null);
			
			Ruby.setActiveStatus(false);
			
			RWBYNetworkHandler.sendToServer(new MessageRose(false));
		}

		//alternatively you could set a variable for key presses and call that variable in other classes with to check if a key is pressed.
		if (KeybindRegistry.activateSemblance.isKeyDown()) {
			activateSemblance = true;
		}
		else {
			activateSemblance = false;
		}
	}*/
}
