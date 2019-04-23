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
    @Config.Comment("Spawn Rate Beowolf")
    public static int spawnratebeowolf= 50;
    @Config.Comment("Spawn Rate Ursa")
    public static int spawnrateursa= 50;
    @Config.Comment("Spawn Rate Boarbatusk")
    public static int spawnrateboar= 50;
    @Config.Comment("Spawn Rate Goliath")
    public static int spawnrategoliath= 5;
    @Config.Comment("Spawn Rate Deathstalker")
    public static int spawnratedeathstalker= 5;
    @Config.Comment("Spawn Rate Mutant Deathstalker")
    public static int spawnratemutantdeathstalker= 5;
    @Config.Comment("Spawn Rate Nevermore")
    public static int spawnratenevermore= 50;
    @Config.Comment("Spawn Rate Giant Nevermore")
    public static int spawnrategiantnevermore= 10;
    @Config.Comment("Spawn Rate Creep")
    public static int spawnratecreep= 50;
    @Config.Comment("Spawn Rate Geist")
    public static int spawnrategeist= 10;
    @Config.Comment("Spawn Rate Lancer")
    public static int spawnratelancer= 75;
    @Config.Comment("Spawn Rate Nuckleeve")
    public static int spawnratenuckleeve= 10;
    @Config.Comment("Spawn Rate Apathy")
    public static int spawnrateapathy= 75;
    @Config.Comment("Spawn Rate Tiny DeathStalker")
    public static int spawnratetinydeathstalker= 50;
    @Config.Comment("Spawn Rate Queen Lancer")
    public static int spawnratequeenlancer= 10;
    @Config.Comment("Global Aggro Range in Blocks")
    public static float aggrorange = 60;
    @Config.Comment("Spawn Chance Dust Shop")
    public static int dustshop = 275;
    @Config.Comment("Spawn Chance Crow Bar")
    public static int bar = 275;
    @Config.Comment("Spawn Chance Well")
    public static int well = 300;
    @Config.Comment("Spawn Chance Gravity DusT")
    public static int gravityore = 15;
    @Config.Comment("Spawn Chance Fire Dust")
    public static int fireore = 15;
    @Config.Comment("Spawn Chance Wind Dust")
    public static int windore = 15;
    @Config.Comment("Spawn Chance Impure Dust")
    public static int impureore = 15;
    @Config.Comment("Spawn Chance Water Dust")
    public static int waterore = 15;
    @Config.Comment("Spawn Chance Lightning Dust")
    public static int lightore = 15;
    @Config.Comment("Spawn Chance Ice Dust")
    public static int iceore = 15;
    @Config.Comment("Semblance Recharge Delay in Ticks")
    public static int delayticks = 250;
    @Config.Comment("Can Aura Block Damage?")
    public static boolean aurablockdamage = true;

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
