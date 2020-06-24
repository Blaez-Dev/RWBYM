package io.github.blaezdev.rwbym.utility;

import java.util.HashMap;
import java.util.Map;

import io.github.blaezdev.rwbym.capabilities.team.ITeam;
import io.github.blaezdev.rwbym.capabilities.team.TeamProvider;
import io.github.blaezdev.rwbym.utility.network.MessageSendTeams;
import io.github.blaezdev.rwbym.utility.network.RWBYNetworkHandler;
import io.github.blaezdev.rwbym.weaponry.RWBYGliderItem;
import net.minecraft.client.audio.ElytraSound;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;

@EventBusSubscriber
public class RWBYServerEventHandler {
	
	public static Map<EntityPlayerMP, Boolean> flyingMap = new HashMap();
	
	@SubscribeEvent
	public static void serverTick(ServerTickEvent event) {
				
		if (event.phase == Phase.START) {
			
			FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers().forEach(player -> {
				
				flyingMap.put(player, flyingMap.getOrDefault(player, false) || player.isElytraFlying());
				
				if (flyingMap.get(player)) {
					
					player.setElytraFlying();
					
			        if (!player.world.isRemote) {
	                	player.fallDistance = 1.0F;
			        }
				}
			});
			
			for (World world : FMLCommonHandler.instance().getMinecraftServerInstance().worlds) {
				if (world.hasCapability(TeamProvider.TEAM_CAP, null)) {
					ITeam teams = world.getCapability(TeamProvider.TEAM_CAP, null);
					if (teams.isDirty()) {
						RWBYNetworkHandler.sendToAll(new MessageSendTeams(teams));
					}
				}
			}
			
		}
		
		if (event.phase == Phase.END) {
			flyingMap.keySet().forEach(player -> {
				
				boolean flag = flyingMap.get(player);

		        if (flag && !player.onGround && !player.isRiding())
		        {
		            ItemStack itemstack1 = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
		            ItemStack itemstack2 = player.getActiveItemStack();

		            if (itemstack1.getItem() instanceof ItemElytra && ItemElytra.isUsable(itemstack1))
		            {
		                flag = true;

		                if (!player.world.isRemote && (player.getTicksElytraFlying() + 1) % 20 == 0)
		                {
		                    itemstack1.damageItem(1, player);
		                }
		            }
		            else if(itemstack2.getItem() instanceof RWBYGliderItem && ItemElytra.isUsable(itemstack2)) {
		                flag = true;

		                if (!player.world.isRemote && (player.getTicksElytraFlying() + 1) % 20 == 0)
		                {
		                    itemstack2.damageItem(1, player);
		                }
		            }
		            else
		            {
		                flag = false;
		            }
		        }
		        else
		        {
		            flag = false;
		        }

		        if (!player.world.isRemote)
		        {
		        	if (flag) {
		        		player.setElytraFlying();
		        	}
		        	else {
		        		//player.clearElytraFlying();
		        	}
		        }
		       
                
			});
			
		//if (event.phase == Phase.END) {
			
			flyingMap.clear();

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
