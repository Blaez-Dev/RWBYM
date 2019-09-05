package be.bluexin.rwbym.utility;

import be.bluexin.rwbym.capabilities.team.ITeam;
import be.bluexin.rwbym.capabilities.team.TeamProvider;
import be.bluexin.rwbym.utility.network.MessageSendTeams;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ServerConnectionFromClientEvent;

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
