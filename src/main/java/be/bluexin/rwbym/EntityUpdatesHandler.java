package be.bluexin.rwbym;

import be.bluexin.rwbym.capabilities.ruby.IRuby;
import be.bluexin.rwbym.capabilities.ruby.RubyProvider;
import be.bluexin.rwbym.utility.network.MessageSendPlayerData;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityUpdatesHandler {

	@SubscribeEvent
	public void onUpdate(LivingUpdateEvent event) {
		EntityLivingBase entityLiving = event.getEntityLiving();
		
		if (entityLiving != null && entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityLiving;
			
			IRuby Ruby = player.getCapability(RubyProvider.RUBY_CAP, null);
			if (Ruby != null) {
				Ruby.updateInvisisbility(player);
				
				if (Ruby.getActiveStatus()) {
					player.fallDistance = 0;
				}
				if (!player.world.isRemote) {
					//RWBYNetworkHandler.sendToAll(new MessageSendPlayerData(Ruby, player.getName()));
				}
			}
		}
	}
	
	
	//currently unused by the mod
	@SubscribeEvent
	public void onLanding(LivingFallEvent event) {
		EntityLivingBase entityLiving = event.getEntityLiving();
		
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entityLiving;
			
		}
	}
}
