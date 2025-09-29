package io.github.blaezdev.rwbym.capabilities;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.capabilities.Aura.Aura;
import io.github.blaezdev.rwbym.capabilities.Aura.AuraProvider;
import io.github.blaezdev.rwbym.capabilities.Aura.AuraStorage;
import io.github.blaezdev.rwbym.capabilities.Aura.IAura;
import io.github.blaezdev.rwbym.capabilities.Blake.Blake;
import io.github.blaezdev.rwbym.capabilities.Blake.BlakeProvider;
import io.github.blaezdev.rwbym.capabilities.Blake.BlakeStorage;
import io.github.blaezdev.rwbym.capabilities.Blake.IBlake;
import io.github.blaezdev.rwbym.capabilities.Blank.Blank;
import io.github.blaezdev.rwbym.capabilities.Blank.BlankProvider;
import io.github.blaezdev.rwbym.capabilities.Blank.BlankStorage;
import io.github.blaezdev.rwbym.capabilities.Blank.IBlank;
import io.github.blaezdev.rwbym.capabilities.Clover.Clover;
import io.github.blaezdev.rwbym.capabilities.Clover.CloverProvider;
import io.github.blaezdev.rwbym.capabilities.Clover.CloverStorage;
import io.github.blaezdev.rwbym.capabilities.Clover.IClover;
import io.github.blaezdev.rwbym.capabilities.Harriet.Harriet;
import io.github.blaezdev.rwbym.capabilities.Harriet.HarrietProvider;
import io.github.blaezdev.rwbym.capabilities.Harriet.HarrietStorage;
import io.github.blaezdev.rwbym.capabilities.Harriet.IHarriet;
import io.github.blaezdev.rwbym.capabilities.Hazel.Hazel;
import io.github.blaezdev.rwbym.capabilities.Hazel.HazelProvider;
import io.github.blaezdev.rwbym.capabilities.Hazel.HazelStorage;
import io.github.blaezdev.rwbym.capabilities.Hazel.IHazel;
import io.github.blaezdev.rwbym.capabilities.Jaune.IJaune;
import io.github.blaezdev.rwbym.capabilities.Jaune.Jaune;
import io.github.blaezdev.rwbym.capabilities.Jaune.JauneProvider;
import io.github.blaezdev.rwbym.capabilities.Jaune.JauneStorage;
import io.github.blaezdev.rwbym.capabilities.Lysette.ILysette;
import io.github.blaezdev.rwbym.capabilities.Lysette.Lysette;
import io.github.blaezdev.rwbym.capabilities.Lysette.LysetteProvider;
import io.github.blaezdev.rwbym.capabilities.Lysette.LysetteStorage;
import io.github.blaezdev.rwbym.capabilities.Maiden.Fall.Fall;
import io.github.blaezdev.rwbym.capabilities.Maiden.Fall.FallProvider;
import io.github.blaezdev.rwbym.capabilities.Maiden.Fall.FallStorage;
import io.github.blaezdev.rwbym.capabilities.Maiden.Fall.IFall;
import io.github.blaezdev.rwbym.capabilities.Nora.INora;
import io.github.blaezdev.rwbym.capabilities.Nora.Nora;
import io.github.blaezdev.rwbym.capabilities.Nora.NoraProvider;
import io.github.blaezdev.rwbym.capabilities.Nora.NoraStorage;
import io.github.blaezdev.rwbym.capabilities.Predator.IPredator;
import io.github.blaezdev.rwbym.capabilities.Predator.Predator;
import io.github.blaezdev.rwbym.capabilities.Pyrrha.IPyrrha;
import io.github.blaezdev.rwbym.capabilities.Pyrrha.Pyrrha;
import io.github.blaezdev.rwbym.capabilities.Pyrrha.PyrrhaProvider;
import io.github.blaezdev.rwbym.capabilities.Pyrrha.PyrrhaStorage;
import io.github.blaezdev.rwbym.capabilities.Qrow.IQrow;
import io.github.blaezdev.rwbym.capabilities.Qrow.Qrow;
import io.github.blaezdev.rwbym.capabilities.Qrow.QrowProvider;
import io.github.blaezdev.rwbym.capabilities.Qrow.QrowStorage;
import io.github.blaezdev.rwbym.capabilities.Ragora.IRagora;
import io.github.blaezdev.rwbym.capabilities.Ragora.Ragora;
import io.github.blaezdev.rwbym.capabilities.Ragora.RagoraProvider;
import io.github.blaezdev.rwbym.capabilities.Ragora.RagoraStorage;
import io.github.blaezdev.rwbym.capabilities.Ren.IRen;
import io.github.blaezdev.rwbym.capabilities.Ren.Ren;
import io.github.blaezdev.rwbym.capabilities.Ren.RenProvider;
import io.github.blaezdev.rwbym.capabilities.Ren.RenStorage;
import io.github.blaezdev.rwbym.capabilities.Ruby.IRuby;
import io.github.blaezdev.rwbym.capabilities.Ruby.Ruby;
import io.github.blaezdev.rwbym.capabilities.Ruby.RubyProvider;
import io.github.blaezdev.rwbym.capabilities.Ruby.RubyStorage;
import io.github.blaezdev.rwbym.capabilities.Valour.IValour;
import io.github.blaezdev.rwbym.capabilities.Valour.Valour;
import io.github.blaezdev.rwbym.capabilities.Valour.ValourProvider;
import io.github.blaezdev.rwbym.capabilities.Valour.ValourStorage;
import io.github.blaezdev.rwbym.capabilities.Weiss.IWeiss;
import io.github.blaezdev.rwbym.capabilities.Weiss.Weiss;
import io.github.blaezdev.rwbym.capabilities.Weiss.WeissProvider;
import io.github.blaezdev.rwbym.capabilities.Weiss.WeissStorage;
import io.github.blaezdev.rwbym.capabilities.Yang.IYang;
import io.github.blaezdev.rwbym.capabilities.Yang.Yang;
import io.github.blaezdev.rwbym.capabilities.Yang.YangProvider;
import io.github.blaezdev.rwbym.capabilities.Yang.YangStorage;
import io.github.blaezdev.rwbym.capabilities.itemdata.IItemData;
import io.github.blaezdev.rwbym.capabilities.itemdata.ItemData;
import io.github.blaezdev.rwbym.capabilities.itemdata.ItemDataProvider;
import io.github.blaezdev.rwbym.capabilities.itemdata.ItemDataStorage;
import io.github.blaezdev.rwbym.capabilities.team.ITeam;
import io.github.blaezdev.rwbym.capabilities.team.Team;
import io.github.blaezdev.rwbym.capabilities.team.TeamProvider;
import io.github.blaezdev.rwbym.capabilities.team.TeamStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class CapabilityHandler {
	
	private static Random rand = new Random();
		
	public static final ResourceLocation RUBY_KEY = new ResourceLocation(RWBYModels.MODID, "ruby");
	public static final ResourceLocation WEISS_KEY = new ResourceLocation(RWBYModels.MODID, "weiss");
	public static final ResourceLocation YANG_KEY = new ResourceLocation(RWBYModels.MODID, "yang");
	public static final ResourceLocation BLAKE_KEY = new ResourceLocation(RWBYModels.MODID, "blake");
	public static final ResourceLocation Ren_KEY = new ResourceLocation(RWBYModels.MODID, "ren");
	public static final ResourceLocation RAGORA_KEY = new ResourceLocation(RWBYModels.MODID, "ragora");
	public static final ResourceLocation JAUNE_KEY = new ResourceLocation(RWBYModels.MODID, "jaune");
	public static final ResourceLocation Nora_KEY = new ResourceLocation(RWBYModels.MODID, "nora");
	public static final ResourceLocation Qrow_KEY = new ResourceLocation(RWBYModels.MODID, "qrow");
	public static final ResourceLocation Lysette_KEY = new ResourceLocation(RWBYModels.MODID, "lysette");
	public static final ResourceLocation Clover_KEY = new ResourceLocation(RWBYModels.MODID, "clover");
	public static final ResourceLocation Harriet_Key = new ResourceLocation(RWBYModels.MODID, "harriet");
	public static final ResourceLocation Pyrrha_Key = new ResourceLocation(RWBYModels.MODID, "pyrrha");
	public static final ResourceLocation Blank_Key = new ResourceLocation(RWBYModels.MODID, "blank");

	public static final ResourceLocation Fall_Key = new ResourceLocation(RWBYModels.MODID, "fall");
	public static final ResourceLocation Valour_Key = new ResourceLocation(RWBYModels.MODID, "valour");
	public static final ResourceLocation Hazel_Key = new ResourceLocation(RWBYModels.MODID, "hazel");
	
	public static final ResourceLocation AURA_KEY = new ResourceLocation(RWBYModels.MODID, "aura");
	public static final ResourceLocation TEAM_KEY = new ResourceLocation(RWBYModels.MODID, "team");

	public static final ResourceLocation ITEMDATA_KEY = new ResourceLocation(RWBYModels.MODID, "itemdata");

	public static final ResourceLocation PREDATOR_KEY = new ResourceLocation(RWBYModels.MODID, "predator");

	private static List<Capability> capabilities = new ArrayList<Capability>();

	private static List<Capability> maiden = new ArrayList<Capability>();

	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent event) {
		
		if (event.getObject() instanceof EntityPlayer) {
			event.addCapability(RUBY_KEY, new RubyProvider());
			event.addCapability(WEISS_KEY, new WeissProvider());
			event.addCapability(YANG_KEY, new YangProvider());
			event.addCapability(BLAKE_KEY, new BlakeProvider());
			event.addCapability(Ren_KEY, new RenProvider());
			event.addCapability(RAGORA_KEY, new RagoraProvider());
			event.addCapability(AURA_KEY, new AuraProvider());
			event.addCapability(JAUNE_KEY, new JauneProvider());
			event.addCapability(Nora_KEY, new NoraProvider());
			event.addCapability(Qrow_KEY, new QrowProvider());
			event.addCapability(Lysette_KEY, new LysetteProvider());
			event.addCapability(Clover_KEY, new CloverProvider());
			event.addCapability(Harriet_Key, new HarrietProvider());
			event.addCapability(Pyrrha_Key, new PyrrhaProvider());
			event.addCapability(Blank_Key, new BlankProvider());
			event.addCapability(Valour_Key, new ValourProvider());
			event.addCapability(Hazel_Key, new HazelProvider());
			event.addCapability(Fall_Key, new FallProvider());
			event.addCapability(PREDATOR_KEY, new Predator.PredatorProvider());
		}
		
		if (event.getObject() instanceof World) {
			event.addCapability(TEAM_KEY, new TeamProvider((World) event.getObject()));
			event.addCapability(ITEMDATA_KEY, new ItemDataProvider());
		}
		
	}
	
	public static void registerAll() {

        register(IRuby.class, new RubyStorage(), Ruby::new);
        register(IWeiss.class, new WeissStorage(), Weiss::new);
        register(IYang.class, new YangStorage(), Yang::new);
        register(IBlake.class, new BlakeStorage(), Blake::new);
        register(IRen.class, new RenStorage(), Ren::new);
        register(IRagora.class, new RagoraStorage(), Ragora::new);
        register(IJaune.class, new JauneStorage(), Jaune::new);
		register(INora.class, new NoraStorage(), Nora::new);
		register(IQrow.class, new QrowStorage(), Qrow::new);
		register(ILysette.class, new LysetteStorage(), Lysette::new);
		register(IClover.class, new CloverStorage(), Clover::new);
		register(IHarriet.class, new HarrietStorage(), Harriet::new);
		register(IPyrrha.class, new PyrrhaStorage(), Pyrrha::new);
		register(IValour.class, new ValourStorage(), Valour::new);
		register(IHazel.class, new HazelStorage(), Hazel::new);
		register(IBlank.class, new BlankStorage(), Blank::new);
		register(IFall.class, new FallStorage(), Fall::new);


		CapabilityManager.INSTANCE.register(IAura.class, new AuraStorage(), Aura::new);
		CapabilityManager.INSTANCE.register(ITeam.class, new TeamStorage(), Team::new);
		CapabilityManager.INSTANCE.register(IItemData.class, new ItemDataStorage(), ItemData::new);
		CapabilityManager.INSTANCE.register(IPredator.class, new Predator.PredatorStorage(), Predator::new);
	}
	
	public static <T extends ISemblance> void register(Class<T> type, Capability.IStorage<T> storage, Callable<? extends T> factory) {
		CapabilityManager.INSTANCE.register(type, storage, factory);
		try {
			capabilities.add(factory.call().getCapability());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static <T extends ISemblance> void registermaiden(Class<T> type, Capability.IStorage<T> storage, Callable<? extends T> factory) {
		CapabilityManager.INSTANCE.register(type, storage, factory);
		try {
			maiden.add(factory.call().getCapability());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ISemblance getCurrentmaiden(EntityPlayer player) {

		RWBYModels.LOGGER.log(RWBYModels.updtes, "Getting Active Maiden for Player: {}", player.getDisplayNameString());

		List<ISemblance> semblances = new ArrayList<ISemblance>();

		for (Capability<ISemblance> capability : maiden) {
			if (player.hasCapability(capability, null)) {
				ISemblance semblance = player.getCapability(capability, null);
				RWBYModels.LOGGER.log(RWBYModels.updtes, "Found Maiden: " + semblance);
				if (semblance.getLevel() > 0) {
					RWBYModels.LOGGER.log(RWBYModels.updtes, "Adding Maiden: " + semblance);
					semblances.add(semblance);
				}
			}
		}


		if (semblances.size() > 1) {
			//RWBYModels.LOGGER.warn("Player Has Multiple Active Semblances");
		}


		if (semblances.isEmpty()) {
			RWBYModels.LOGGER.info("Not Currently a Maiden");
			return null;
		}
		return semblances.get(rand.nextInt(semblances.size()));
	}
	
	public static ISemblance getCurrentSemblance(EntityPlayer player) {
		
//		RWBYModels.LOGGER.log(RWBYModels.updtes, "Getting Active Semblance for Player: {}", player.getDisplayNameString());
				
		List<ISemblance> semblances = new ArrayList<ISemblance>();

		for (Capability<ISemblance> capability : capabilities) {
			if (player.hasCapability(capability, null)) {
				ISemblance semblance = player.getCapability(capability, null);
//				RWBYModels.LOGGER.log(RWBYModels.updtes, "Found Semblance: " + semblance);
				if (semblance.getLevel() > 0) {
//					RWBYModels.LOGGER.log(RWBYModels.updtes, "Adding Semblance: " + semblance);
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
		
//		RWBYModels.LOGGER.log(RWBYModels.updtes, "Getting Semblance {} for Player: {}", name, player.getDisplayNameString());
		
		name = name.toLowerCase();

		for (Capability<ISemblance> capability : capabilities) {
			if (capability.getName().toLowerCase().contains(name)) {
				return player.getCapability(capability, null);
			}
		}
		
		//RWBYModels.LOGGER.error("Unable to Get Requested Sembalnce: {}", name);
		
		return null;
	}

	public static ISemblance getMaidenByName(EntityPlayer player, String name) {

//		RWBYModels.LOGGER.log(RWBYModels.updtes, "Getting Semblance {} for Player: {}", name, player.getDisplayNameString());

		name = name.toLowerCase();

		for (Capability<ISemblance> capability : maiden) {
			if (capability.getName().toLowerCase().contains(name)) {
				return player.getCapability(capability, null);
			}
		}

		//RWBYModels.LOGGER.error("Unable to Get Requested Sembalnce: {}", name);

		return null;
	}

	public static List<ISemblance> getAllSemblances(EntityPlayer player) {
		
		List<ISemblance> semblances = new ArrayList<ISemblance>();
		
		for (Capability<ISemblance> capability : capabilities) {
			if (player.hasCapability(capability, null)) {
				ISemblance semblance = player.getCapability(capability, null);
//				RWBYModels.LOGGER.log(RWBYModels.updtes, "Found Semblance: " + semblance);
				semblances.add(semblance);
			}
		}
		
		return semblances;
	}


	public static List<ISemblance> getAllMaidens(EntityPlayer player) {

		List<ISemblance> semblances = new ArrayList<ISemblance>();

		for (Capability<ISemblance> capability : maiden) {
			if (player.hasCapability(capability, null)) {
				ISemblance semblance = player.getCapability(capability, null);
//				RWBYModels.LOGGER.log(RWBYModels.updtes, "Found Semblance: " + semblance);
				semblances.add(semblance);
			}
		}

		return semblances;
	}

	public static <T extends ISemblance> void setSemblance(EntityPlayer player, Capability<T> capability, int level) {
		for (ISemblance semblance : getAllSemblances(player)) {
			semblance.setLevel(0);
			if (semblance.getSelectedLevel() != -1) {
				semblance.setSelectedLevel(0);
			}
		}
		
		if (player.hasCapability(capability, null)) {
			ISemblance semblance = player.getCapability(capability, null);
			semblance.setLevel(level);
		}
	}

	public static <T extends ISemblance> void setMaiden(EntityPlayer player, Capability<T> capability, int level) {
		for (ISemblance semblance : getAllMaidens(player)) {
			semblance.setLevel(0);
			if (semblance.getSelectedLevel() != -1) {
				semblance.setSelectedLevel(0);
			}
		}

		if (player.hasCapability(capability, null)) {
			ISemblance semblance = player.getCapability(capability, null);
			semblance.setLevel(level);
		}
	}
}
