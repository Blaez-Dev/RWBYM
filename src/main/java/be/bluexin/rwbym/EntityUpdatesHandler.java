package be.bluexin.rwbym;

import java.util.List;

import org.apache.logging.log4j.Level;

import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ISemblance;
import be.bluexin.rwbym.capabilities.Weiss.WeissProvider;
import be.bluexin.rwbym.capabilities.Yang.YangProvider;
import be.bluexin.rwbym.capabilities.ruby.IRuby;
import be.bluexin.rwbym.capabilities.ruby.RubyProvider;
import be.bluexin.rwbym.utility.network.MessageSendPlayerData;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenHellLava;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.Clone;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;

public class EntityUpdatesHandler {
	@SubscribeEvent
	public void onUpdate(LivingUpdateEvent event) {
		EntityLivingBase entityLiving = event.getEntityLiving();
		
		if (entityLiving != null && entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityLiving;
			
			ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);
			if (semblance != null) {
				semblance.onUpdate(player);
				if (!player.world.isRemote) {
					RWBYNetworkHandler.sendToAll(new MessageSendPlayerData(semblance, player.getName()));
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		RWBYModels.LOGGER.log(RWBYModels.debug, "Player Respawn");
		
		EntityPlayer player = event.player;
		
		ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);
		
		if (semblance != null && player.hasCapability(semblance.getCapability(), null)) {
			RWBYModels.LOGGER.log(RWBYModels.debug, "Player has Semblance: " + semblance + ", with Level: " + ((ISemblance)player.getCapability(semblance.getCapability(), null)).getLevel());
		}
	}
	
	@SubscribeEvent
	public void onPlayerClone(Clone event) {
		ISemblance semblance = CapabilityHandler.getCurrentSemblance(event.getOriginal());
		
		int level = semblance.getLevel();
		
		semblance = CapabilityHandler.getCapabilityByName(event.getEntityPlayer(), semblance.getCapability().getName());
		
		semblance.setLevel(level);
	}
	
	@SubscribeEvent
	public void onPlayerLoggedOn(PlayerLoggedInEvent event) {
				
		ISemblance semblance = CapabilityHandler.getCurrentSemblance(event.player);
		
		if (semblance == null) {
			int i = event.player.world.rand.nextInt(2);
			switch(i) {
			case 0:
				semblance = event.player.getCapability(RubyProvider.RUBY_CAP, null);
				break;
			case 1:
				semblance = event.player.getCapability(WeissProvider.WEISS_CAP, null);
				break;
			case 2:
				semblance = event.player.getCapability(YangProvider.YANG_CAP, null);
			}
			if (semblance == null) {
				RWBYModels.LOGGER.error("Could not Get A Semblance for Player {}", event.player.getDisplayNameString());
			}
			else {
				RWBYModels.LOGGER.log(RWBYModels.debug, "Set Semblance for Player {} to {}", event.player.getDisplayNameString(), semblance);
				semblance.setLevel(1);
			}
		}
		
		RWBYModels.LOGGER.log(RWBYModels.debug, "Player {} Logged On With Semblance {}", event.player.getDisplayNameString(), semblance);

	}
	
	@SubscribeEvent
	public void clientConnectedToServer(ClientConnectedToServerEvent event) {
		RWBYModels.LOGGER.log(RWBYModels.debug, "Client Connected");
	}
}
