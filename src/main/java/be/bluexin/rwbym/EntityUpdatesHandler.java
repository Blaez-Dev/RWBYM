package be.bluexin.rwbym;

import java.util.List;

import be.bluexin.rwbym.utility.RWBYConfig;
import be.bluexin.rwbym.world.biome.BiomeDarkGrimm;
import net.minecraft.client.Minecraft;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Level;

import be.bluexin.rwbym.Init.RWBYBiomes;
import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ISemblance;
import be.bluexin.rwbym.capabilities.Aura.AuraProvider;
import be.bluexin.rwbym.capabilities.Aura.IAura;
import be.bluexin.rwbym.capabilities.Ruby.IRuby;
import be.bluexin.rwbym.capabilities.Ruby.RubyProvider;
import be.bluexin.rwbym.capabilities.Weiss.WeissProvider;
import be.bluexin.rwbym.capabilities.Yang.YangProvider;
import be.bluexin.rwbym.utility.network.MessageSendPlayerData;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenHellLava;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
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
			
			IAura aura = null;
			
			if (!player.world.isRemote && player.hasCapability(AuraProvider.AURA_CAP, null)) {
				aura = player.getCapability(AuraProvider.AURA_CAP, null);
				aura.onUpdate(player);
			}
			
			ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);
			if (semblance != null) {
				semblance.onUpdate(player);
			}
			if (!player.world.isRemote) {
				RWBYNetworkHandler.sendToAll(new MessageSendPlayerData(semblance, aura, player.getEntityData().getCompoundTag(RWBYModels.MODID), player.getName()));
			}
		}
	}
	
	@SubscribeEvent
	public void onEntityDamage(LivingDamageEvent event) {
		if(RWBYConfig.aurablockdamage){
		EntityLivingBase entityliving = event.getEntityLiving();
		if (entityliving instanceof EntityPlayer && !entityliving.world.isRemote) {
			EntityPlayer player = (EntityPlayer) entityliving;
			if (player.hasCapability(AuraProvider.AURA_CAP, null)) {
				IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);
				float overflow = aura.useAura(player, event.getAmount() * 5, true);
				aura.delayRecharge(600);
				event.setAmount(overflow / 5);
			}
		}}
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
		
		IAura oldaura = event.getOriginal().getCapability(AuraProvider.AURA_CAP, null);
		
		IAura newaura = event.getEntityPlayer().getCapability(AuraProvider.AURA_CAP, null);
		
		newaura.deserialize((NBTTagCompound) oldaura.serialize());
	}
	
	@SubscribeEvent
	public void onPlayerLoggedOn(PlayerLoggedInEvent event) {
				
		ISemblance semblance = CapabilityHandler.getCurrentSemblance(event.player);
		
		if (semblance == null) {

			List<ISemblance> semblances = CapabilityHandler.getAllSemblances(event.player);
			
			semblance = semblances.get(event.player.world.rand.nextInt(semblances.size()));
			
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

	@SubscribeEvent
	public void onClientTick(TickEvent.PlayerTickEvent event){
		
		EntityPlayer player = event.player;
		Biome biome = player.world.getBiome(player.getPosition());
		
		if(biome == RWBYBiomes.GrimmWastes && player.isInWater()) {
			PotionEffect potioneffect = new PotionEffect(MobEffects.POISON, 60, 3, false, false);
			PotionEffect potioneffect1 = new PotionEffect(MobEffects.WITHER, 60, 2, false, false);
			player.addPotionEffect(potioneffect);
			player.addPotionEffect(potioneffect1);
		}
	}
}
