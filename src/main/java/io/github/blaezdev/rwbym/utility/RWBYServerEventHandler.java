package io.github.blaezdev.rwbym.utility;

import io.github.blaezdev.rwbym.capabilities.team.ITeam;
import io.github.blaezdev.rwbym.capabilities.team.TeamProvider;
import io.github.blaezdev.rwbym.utility.network.MessageSendTeams;
import io.github.blaezdev.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;

@EventBusSubscriber
public class RWBYServerEventHandler {
	
	@SubscribeEvent
	public static void serverTick(ServerTickEvent event) {
		
		if (event.phase == Phase.START) {
			for (World world : FMLCommonHandler.instance().getMinecraftServerInstance().worlds) {
				if (world.hasCapability(TeamProvider.TEAM_CAP, null)) {
					ITeam teams = world.getCapability(TeamProvider.TEAM_CAP, null);
					if (teams.isDirty()) {
						RWBYNetworkHandler.sendToAll(new MessageSendTeams(teams));
					}
				}
			}
		}
		
	}
	
	@SubscribeEvent
	public static void ClientJoined(EntityJoinWorldEvent event) {
		
		if (event.getEntity() instanceof EntityPlayer && !event.getWorld().isRemote) {
			if (event.getWorld().hasCapability(TeamProvider.TEAM_CAP, null)) {
				event.getWorld().getCapability(TeamProvider.TEAM_CAP, null).markDirty();
			}
		}
		
	}

}
