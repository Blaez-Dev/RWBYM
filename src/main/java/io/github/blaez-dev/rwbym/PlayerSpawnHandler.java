package io.github.blaez-dev.rwbym;

import com.google.common.eventbus.Subscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

@EventBusSubscriber
public class PlayerSpawnHandler {

	@Subscribe
	public void onPlayerSpawn(PlayerRespawnEvent event) {
		System.out.println("playerRespawn");
	}
	
	@Subscribe
	public void LivingUpdateEvent(LivingUpdateEvent event) {
		System.out.println("test");
	}
	
}
