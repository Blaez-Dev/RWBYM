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
    public static int spawnrategoliath= 1;
    @Config.Comment("Spawn Rate Deathstalker")
    public static int spawnratedeathstalker= 1;
    @Config.Comment("Spawn Rate Mutant Deathstalker")
    public static int spawnratemutantdeathstalker= 1;
    @Config.Comment("Spawn Rate Nevermore")
    public static int spawnratenevermore= 50;
    @Config.Comment("Spawn Rate Giant Nevermore")
    public static int spawnrategiantnevermore= 1;
    @Config.Comment("Spawn Rate Creep")
    public static int spawnratecreep= 50;
    @Config.Comment("Spawn Rate Geist")
    public static int spawnrategeist= 30;
    @Config.Comment("Spawn Rate Lancer")
    public static int spawnratelancer= 50;
    @Config.Comment("Spawn Rate Nuckleeve")
    public static int spawnratenuckleeve= 1;
    @Config.Comment("Spawn Rate Apathy")
    public static int spawnrateapathy= 50;
    @Config.Comment("Spawn Rate Tiny DeathStalker")
    public static int spawnratetinydeathstalker= 50;
    @Config.Comment("Spawn Rate Queen Lancer")
    public static int spawnratequeenlancer= 1;
    @Config.Comment("Global Aggro Range in Blocks")
    public static float aggrorange = 60;
    @Config.Comment("Spawn Chance Dust Shop")
    public static int dustshop = 60;
    @Config.Comment("Spawn Chance of Remote Dust shop")
    public static int dustshop2 = 60;
    @Config.Comment("Spawn Chance Crow Bar")
    public static int bar = 60;
    @Config.Comment("Spawn Chance Well")
    public static int well = 10;
    @Config.Comment("Spawn Chance Gravity DusT")
    public static int gravityore = 1;
    @Config.Comment("Spawn Chance Fire Dust")
    public static int fireore = 1;
    @Config.Comment("Spawn Chance Wind Dust")
    public static int windore = 1;
    @Config.Comment("Spawn Chance Impure Dust")
    public static int impureore = 2;
    @Config.Comment("Spawn Chance Water Dust")
    public static int waterore = 1;
    @Config.Comment("Spawn Chance Lightning Dust")
    public static int lightore = 1;
    @Config.Comment("Spawn Chance Ice Dust")
    public static int iceore = 1;
    @Config.Comment("Semblance Recharge Delay in Ticks")
    public static int delayticks = 250;
    @Config.Comment("Can Aura Block Damage?")
    public static boolean aurablockdamage = true;
    @Config.Comment("Ragora Familiar Particles")
    public static boolean ragoraparticles = true;
    @Config.Comment("Ragora ShadowBall Resolution")
    public static float shadowballresolution = 1F;
    @Config.Comment("Ragora ShadowBall Size")
    public static float shadowballsize = 4.5F;
    @Config.Comment("Ragora Summon Particle Count")
    public static int ragorasummonparticles = 100;
    @Config.Comment("Dust Ore Random Effect Chance")
    public static int dustoreeffect = 20;
    @Config.Comment("Unsafe Dust Mining")
    public static boolean unsafemining = true;
    @Config.Comment("Dark Crystal Spawnrate")
    public static int darkcrystalrate = 20;
    @Config.Comment("Rarity of RWBYM Biomes")
    public static int biomerarity = 20;
    @Config.Comment("Render Aura Bar?")
    public static boolean RenderAurabar = true;
    @Config.Comment("Position X")
    public static int aurapositionx = 175;
    @Config.Comment("Position Y")
    public static int aurapositiony = 39;
    @Config.Comment("Grimm Health Multiplier")
    public static float grimmhealthmult = 1.0F;
    @Config.Comment("Grimm Attack Damage Multiplier")
    public static float grimmattackmult = 1.0F;



   // @Config.Comment("Aura per Level")
    //public static int auraperlevel = 1;

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
