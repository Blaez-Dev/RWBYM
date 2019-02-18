package be.bluexin.rwbym.capabilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

import org.apache.logging.log4j.Level;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.capabilities.Blake.Blake;
import be.bluexin.rwbym.capabilities.Blake.BlakeProvider;
import be.bluexin.rwbym.capabilities.Blake.BlakeStorage;
import be.bluexin.rwbym.capabilities.Blake.IBlake;
import be.bluexin.rwbym.capabilities.Weiss.IWeiss;
import be.bluexin.rwbym.capabilities.Weiss.Weiss;
import be.bluexin.rwbym.capabilities.Weiss.WeissProvider;
import be.bluexin.rwbym.capabilities.Weiss.WeissStorage;
import be.bluexin.rwbym.capabilities.Yang.IYang;
import be.bluexin.rwbym.capabilities.Yang.Yang;
import be.bluexin.rwbym.capabilities.Yang.YangProvider;
import be.bluexin.rwbym.capabilities.Yang.YangStorage;
import be.bluexin.rwbym.capabilities.ruby.IRuby;
import be.bluexin.rwbym.capabilities.ruby.Ruby;
import be.bluexin.rwbym.capabilities.ruby.RubyProvider;
import be.bluexin.rwbym.capabilities.ruby.RubyStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
	
	private static Random rand = new Random();
		
	public static final ResourceLocation RUBY_KEY = new ResourceLocation(RWBYModels.MODID, "ruby");
	public static final ResourceLocation WEISS_KEY = new ResourceLocation(RWBYModels.MODID, "weiss");
	public static final ResourceLocation YANG_KEY = new ResourceLocation(RWBYModels.MODID, "yang");
	public static final ResourceLocation BLAKE_KEY = new ResourceLocation(RWBYModels.MODID, "blake");
	
	private static List<Capability> capabilities = new ArrayList<Capability>();
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent event) {
		
		if (event.getObject() instanceof EntityPlayer) {
			event.addCapability(RUBY_KEY, new RubyProvider());
			event.addCapability(WEISS_KEY, new WeissProvider());
			event.addCapability(YANG_KEY, new YangProvider());
			event.addCapability(BLAKE_KEY, new BlakeProvider());
		}
		
	}
	
	public static void registerAll() {

        register(IRuby.class, new RubyStorage(), Ruby::new);
        register(IWeiss.class, new WeissStorage(), Weiss::new);
        register(IYang.class, new YangStorage(), Yang::new);
        register(IBlake.class, new BlakeStorage(), Blake::new);
        
	}
	
	public static <T extends ISemblance> void register(Class<T> type, Capability.IStorage<T> storage, Callable<? extends T> factory) {
		CapabilityManager.INSTANCE.register(type, storage, factory);
		try {
			capabilities.add(factory.call().getCapability());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ISemblance getCurrentSemblance(EntityPlayer player) {
		
		RWBYModels.LOGGER.log(RWBYModels.updtes, "Getting Active Semblance for Player: {}", player.getDisplayNameString());
				
		List<ISemblance> semblances = new ArrayList<ISemblance>();
		
		for (Capability<ISemblance> capability : capabilities) {
			if (player.hasCapability(capability, null)) {
				ISemblance semblance = player.getCapability(capability, null);
				RWBYModels.LOGGER.log(RWBYModels.updtes, "Found Semblance: " + semblance);
				if (semblance.getLevel() > 0) {
					RWBYModels.LOGGER.log(RWBYModels.updtes, "Adding Semblance: " + semblance);
					semblances.add(semblance);
				}
			}
		}
		
		if (semblances.size() > 1) {
			//RWBYModels.LOGGER.warn("Player Has Multiple Active Semblances");
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

		for (Capability<ISemblance> capability : capabilities) {
			if (capability.getName().toLowerCase().contains(name)) {
				return player.getCapability(capability, null);
			}
		}
		
		RWBYModels.LOGGER.error("Unable to Get Requested Sembalnce: {}", name);
		
		return null;
	}

	public static List<ISemblance> getAllSemblances(EntityPlayer player) {
		
		List<ISemblance> semblances = new ArrayList<ISemblance>();
		
		for (Capability<ISemblance> capability : capabilities) {
			if (player.hasCapability(capability, null)) {
				ISemblance semblance = player.getCapability(capability, null);
				RWBYModels.LOGGER.log(RWBYModels.updtes, "Found Semblance: " + semblance);
				semblances.add(semblance);
			}
		}
		
		return semblances;
	}

	public static <T extends ISemblance> void setSemblance(EntityPlayer player, Capability<T> capability, int level) {
		for (ISemblance semblance : getAllSemblances(player)) {
			semblance.setLevel(0);
		}
		
		if (player.hasCapability(capability, null)) {
			ISemblance semblance = player.getCapability(capability, null);
			semblance.setLevel(level);
		}
	}
}
