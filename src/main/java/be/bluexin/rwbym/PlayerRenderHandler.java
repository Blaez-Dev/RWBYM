package be.bluexin.rwbym;

import be.bluexin.rwbym.capabilities.ruby.IRuby;
import be.bluexin.rwbym.capabilities.ruby.RubyProvider;
import be.bluexin.rwbym.utility.network.MessageGetPlayerData;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PlayerRenderHandler {
	
	@SubscribeEvent
	public void PlayerRenderEvent(RenderPlayerEvent.Pre event) {
		EntityPlayer entityPlayer = event.getEntityPlayer();
		
		String name = entityPlayer.getName();
		
		//RWBYNetworkHandler.sendToServer(new MessageGetPlayerData(name));
		
		if (entityPlayer.hasCapability(RubyProvider.RUBY_CAP, null)) {
			IRuby Ruby = entityPlayer.getCapability(RubyProvider.RUBY_CAP, null);
		
			if (Ruby.getInvisibility()) {
				entityPlayer.setInvisible(true);
				event.setCanceled(true);
			}
			else {
				entityPlayer.setInvisible(false);
			}
		}
	}
}
