package io.github.blaezdev.rwbym.utility;

import java.util.HashMap;
import java.util.Map;

import io.github.blaezdev.rwbym.capabilities.team.ITeam;
import io.github.blaezdev.rwbym.capabilities.team.TeamProvider;
import io.github.blaezdev.rwbym.utility.network.MessageSendTeams;
import io.github.blaezdev.rwbym.utility.network.RWBYNetworkHandler;
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
			        	
			        	System.out.println(player.motionY);
			        
		                //if (player.motionY > -0.5D)
		                {
		                	player.fallDistance = 1.0F;
		                }
		                
//		                Vec3d vec3d = player.getLookVec();
//		                float f = player.rotationPitch * 0.017453292F;
//		                double d6 = Math.sqrt(vec3d.x * vec3d.x + vec3d.z * vec3d.z);
//		                double d8 = Math.sqrt(player.motionX * player.motionX + player.motionZ * player.motionZ);
//		                double d1 = vec3d.lengthVector();
//		                float f4 = MathHelper.cos(f);
//		                f4 = (float)((double)f4 * (double)f4 * Math.min(1.0D, d1 / 0.4D));
//		                player.motionY += -0.08D + (double)f4 * 0.06D;
//		
//		                if (player.motionY < 0.0D && d6 > 0.0D)
//		                {
//		                    double d2 = player.motionY * -0.1D * (double)f4;
//		                    player.motionY += d2;
//		                    player.motionX += vec3d.x * d2 / d6;
//		                    player.motionZ += vec3d.z * d2 / d6;
//		                }
//		
//		                if (f < 0.0F)
//		                {
//		                    double d10 = d8 * (double)(-MathHelper.sin(f)) * 0.04D;
//		                    player.motionY += d10 * 3.2D;
//		                    player.motionX -= vec3d.x * d10 / d6;
//		                    player.motionZ -= vec3d.z * d10 / d6;
//		                }
//		
//		                if (d6 > 0.0D)
//		                {
//		                    player.motionX += (vec3d.x / d6 * d8 - player.motionX) * 0.1D;
//		                    player.motionZ += (vec3d.z / d6 * d8 - player.motionZ) * 0.1D;
//		                }
//		
//		                player.motionX *= 0.9900000095367432D;
//		                player.motionY *= 0.9800000190734863D;
//		                player.motionZ *= 0.9900000095367432D;
//		                //player.move(MoverType.SELF, player.motionX, player.motionY, player.motionZ);
//		
//		                if (player.collidedHorizontally && !player.world.isRemote)
//		                {
//		                    double d11 = Math.sqrt(player.motionX * player.motionX + player.motionZ * player.motionZ);
//		                    double d3 = d8 - d11;
//		                    float f5 = (float)(d3 * 10.0D - 3.0D);
//		
//		                    if (f5 > 0.0F)
//		                    {
//		                        //player.playSound(player.getFallSound((int)f5), 1.0F, 1.0F);
//		                        player.attackEntityFrom(DamageSource.FLY_INTO_WALL, f5);
//		                    }
//		                }
//		
//		                if (player.onGround && !player.world.isRemote)
//		                {
//		                    player.clearElytraFlying();
//		                }
		                
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
		            ItemStack itemstack = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);

		            if (itemstack.getItem() instanceof ItemElytra && ItemElytra.isUsable(itemstack))
		            {
		                flag = true;

		                if (!player.world.isRemote && (player.getTicksElytraFlying() + 1) % 20 == 0)
		                {
		                    itemstack.damageItem(1, player);
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
		        		player.clearElytraFlying();
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
