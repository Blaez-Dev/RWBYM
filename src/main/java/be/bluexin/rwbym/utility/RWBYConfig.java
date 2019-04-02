package be.bluexin.rwbym.utility;

import be.bluexin.rwbym.RWBYModels;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = RWBYModels.MODID)
@Config.LangKey(RWBYModels.MODID + ".config.title")
public class RWBYConfig
{
    @Config.Comment("Spawn Rate")
    public static int spawnratebeowolf= 50;
    @Config.Comment("Spawn Rate")
    public static int spawnrateursa= 50;
    @Config.Comment("Spawn Rate")
    public static int spawnrateboar= 50;
    @Config.Comment("Spawn Rate")
    public static int spawnrategoliath= 5;
    @Config.Comment("Spawn Rate")
    public static int spawnratedeathstalker= 5;
    @Config.Comment("Spawn Rate")
    public static int spawnratemutantdeathstalker= 50;
    @Config.Comment("Spawn Rate")
    public static int spawnratenevermore= 50;
    @Config.Comment("Spawn Rate")
    public static int spawnrategiantnevermore= 10;
    @Config.Comment("Spawn Rate")
    public static int spawnratecreep= 50;
    @Config.Comment("Spawn Rate")
    public static int spawnrategeist= 10;
    @Config.Comment("Spawn Rate")
    public static int spawnratelancer= 75;
    @Config.Comment("Spawn Rate")
    public static int spawnratenuckleeve= 10;
    @Config.Comment("Spawn Rate")
    public static int spawnrateapathy= 75;
    @Config.Comment("Spawn Rate")
    public static int spawnratetinydeathstalker= 50;
    @Config.Comment("Spawn Rate")
    public static int spawnratequeenlancer= 10;
    @Config.Comment("Spawn Rate")
    public static int dustshop = 200;
    @Config.Comment("Spawn Rate")
    public static int bar = 200;

    @Config.Comment("Client side configurations")
    public static final Client client = new Client();


    public static class Client
    {

    }


    @Mod.EventBusSubscriber(modid = RWBYModels.MODID)
    private static class Handler
    {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
        {
            if(event.getModID().equals(RWBYModels.MODID))
                ConfigManager.sync(RWBYModels.MODID, Config.Type.INSTANCE);
        }
    }
}
