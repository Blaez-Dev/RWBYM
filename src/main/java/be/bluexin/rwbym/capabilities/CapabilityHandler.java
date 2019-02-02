package be.bluexin.rwbym.capabilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.Level;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.capabilities.Weiss.WeissProvider;
import be.bluexin.rwbym.capabilities.Yang.YangProvider;
import be.bluexin.rwbym.capabilities.ruby.IRuby;
import be.bluexin.rwbym.capabilities.ruby.RubyProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
	
	private static Random rand = new Random();
		
	public static final ResourceLocation RUBY_KEY = new ResourceLocation(RWBYModels.MODID, "ruby");
	public static final ResourceLocation WEISS_KEY = new ResourceLocation(RWBYModels.MODID, "weiss");
	public static final ResourceLocation YANG_KEY = new ResourceLocation(RWBYModels.MODID, "yang");
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent event) {
		
		if (event.getObject() instanceof EntityPlayer) {
			event.addCapability(RUBY_KEY, new RubyProvider());
			event.addCapability(WEISS_KEY, new WeissProvider());
			event.addCapability(YANG_KEY, new YangProvider());
		}
		
	}
	
	public static ISemblance getCurrentSemblance(EntityPlayer player) {
		
		RWBYModels.LOGGER.log(RWBYModels.updtes, "Getting Active Semblance for Player: {}", player.getDisplayNameString());
				
		List<ISemblance> semblances = new ArrayList<ISemblance>();
		
		if (player.hasCapability(RubyProvider.RUBY_CAP, null)) {
			ISemblance semblance = player.getCapability(RubyProvider.RUBY_CAP, null);
			RWBYModels.LOGGER.log(RWBYModels.updtes, "Found Semblance: " + semblance);
			if (semblance.getLevel() > 0) {
				RWBYModels.LOGGER.log(RWBYModels.updtes, "Adding Semblance: " + semblance);
				semblances.add(semblance);
			}
		}
		if (player.hasCapability(WeissProvider.WEISS_CAP, null)) {
			ISemblance semblance = player.getCapability(WeissProvider.WEISS_CAP, null);
			RWBYModels.LOGGER.log(RWBYModels.updtes, "Found Semblance: " + semblance);
			if (semblance.getLevel() > 0) {
				RWBYModels.LOGGER.log(RWBYModels.updtes, "Adding Semblance: " + semblance);
				semblances.add(semblance);
			}			
		}
		if (player.hasCapability(YangProvider.YANG_CAP, null)) {
			ISemblance semblance = player.getCapability(YangProvider.YANG_CAP, null);
			RWBYModels.LOGGER.log(RWBYModels.updtes, "Found Semblance: {}", semblance);
			if (semblance.getLevel() > 0) {
				RWBYModels.LOGGER.log(RWBYModels.updtes, "Adding Semblance: {}", semblance);
				semblances.add(semblance);
			}
		}
		
		if (semblances.size() > 1) {
			RWBYModels.LOGGER.warn("Player Has Multiple Active Semblances");
		}
		
		if (semblances.isEmpty()) {
			RWBYModels.LOGGER.info("No Current Semblance");
			return null;
		}
		
		return semblances.get(rand.nextInt(semblances.size()));
	}
	
	public static ISemblance getCapabilityByName(EntityPlayer player, String name) {
		
		RWBYModels.LOGGER.log(RWBYModels.updtes, "Getting Semblance {} for Player: {}", name, player.getDisplayNameString());
		
		name = name.toLowerCase();

		if (RubyProvider.RUBY_CAP.getName().toLowerCase().contains(name)) {
			return player.getCapability(RubyProvider.RUBY_CAP, null);
		}
		if (WeissProvider.WEISS_CAP.getName().toLowerCase().contains(name)) {
			return player.getCapability(WeissProvider.WEISS_CAP, null);
		}
		if (YangProvider.YANG_CAP.getName().toLowerCase().contains(name)) {
			return player.getCapability(YangProvider.YANG_CAP, null);
		}
		
		RWBYModels.LOGGER.error("Unable to Get Requested Sembalnce: {}", name);
		
		return null;
	}

	public static List<ISemblance> getAllSemblances(EntityPlayer player) {
		
		List<ISemblance> semblances = new ArrayList<ISemblance>();
		
		if (player.hasCapability(RubyProvider.RUBY_CAP, null)) {
			ISemblance semblance = player.getCapability(RubyProvider.RUBY_CAP, null);
			RWBYModels.LOGGER.log(RWBYModels.updtes, "Found Semblance: " + semblance);
			semblances.add(semblance);
		}
		if (player.hasCapability(WeissProvider.WEISS_CAP, null)) {
			ISemblance semblance = player.getCapability(WeissProvider.WEISS_CAP, null);
			RWBYModels.LOGGER.log(RWBYModels.updtes, "Found Semblance: " + semblance);
			semblances.add(semblance);
		}
		if (player.hasCapability(YangProvider.YANG_CAP, null)) {
			ISemblance semblance = player.getCapability(YangProvider.YANG_CAP, null);
			RWBYModels.LOGGER.log(RWBYModels.updtes, "FoundSemblance: {}", semblance);
			semblances.add(semblance);
		}
		
		return semblances;
	}
	
	public static void setSemblance(EntityPlayer player, Capability<ISemblance> capability, int level) {
		for (ISemblance semblance : getAllSemblances(player)) {
			semblance.setLevel(0);
		}
		
		if (player.hasCapability(capability, null)) {
			ISemblance semblance = player.getCapability(capability, null);
			semblance.setLevel(level);
		}
	}
}
