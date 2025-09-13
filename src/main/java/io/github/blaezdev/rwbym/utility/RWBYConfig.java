package io.github.blaezdev.rwbym.utility;

import io.github.blaezdev.rwbym.RWBYModels;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = RWBYModels.MODID)
@Config.LangKey(RWBYModels.MODID + ".config.title")
public class RWBYConfig
{
    @Config.Name("General")
    @Config.Comment("General Config Options")
    public static General general = new General();

    @Config.Name("Mobs - Spawnrate")
    @Config.Comment("Spawnrates for Mobs.")
    public static Configmobspawnrates configmobspawnrates = new Configmobspawnrates();

    @Config.Name("Mobs - Attributes")
    @Config.Comment("Set Mon Attribute Multipliers.")
    public static MobAttributes attributes = new MobAttributes();

    @Config.Name("Player - Aura/Semblance Settings")
    @Config.Comment("Tweak Aura or Semblance Settings")
    public static Aura aura = new Aura();

    @Config.Name("WorldGen/Mining Settings")
    @Config.Comment("Tweak Structure and Ore Spawnchances")
    public static Mining worldgen = new Mining();

    public static class Configmobspawnrates { 
        @Config.Name("Spawn Rate Beowolf(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnratebeowolf= 50;
    @Config.Name("Spawn Rate Ursa(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnrateursa= 50;
    @Config.Name("Spawn Rate Boarbatusk(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnrateboar= 50;
    @Config.Name("Spawn Rate Goliath(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnrategoliath= 1;
    @Config.Name("Spawn Rate Deathstalker(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnratedeathstalker= 1;
    @Config.Name("Spawn Rate Hollow(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnratehollow= 1;
    @Config.Name("Spawn Rate Mutant Deathstalker(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnratemutantdeathstalker= 1;
    @Config.Name("Spawn Rate Nevermore(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnratenevermore= 50;
    @Config.Name("Spawn Rate Giant Nevermore(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnrategiantnevermore= 1;
    @Config.Name("Spawn Rate Creep(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnratecreep= 50;
    @Config.Name("Spawn Rate Geist(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnrategeist= 30;
    @Config.Name("Spawn Rate Lancer(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnratelancer= 50;
    @Config.Name("Spawn Rate Nuckleeve(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnratenuckleeve= 1;
    @Config.Name("Spawn Rate Apathy(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnrateapathy= 50;
    @Config.Name("Spawn Rate Tiny DeathStalker(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnratetinydeathstalker= 50;
    @Config.Name("Spawn Rate Beringle(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnrateberingle= 50;
    @Config.Name("Spawn Rate Queen Lancer(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnratequeenlancer= 1;
    @Config.Name("Spawn Rate Wyvern(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnratewyvern= 1;
    @Config.Name("Spawn Rate Ravager(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnrateravager= 50;
    @Config.Name("Spawn Rate Seer(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnrateseer= 50;
    @Config.Name("Spawn Rate Arachne(turn down numbers for rarer / set to 0 to turn off spawning random spawning will still spawn via grimm raids)")
    public  int spawnratearachne= 50;
    @Config.Name("Lancer Queen Nests")
    @Config.Comment("Enable Lancer Queens to Spawn anywhere dark")
    public  boolean lancernests = false;
    @Config.Name("Enable Random Boss Spawns will Only spawn during Dark Crystal Raids(KEEP TO FALSE FOR YOUR OWN SANITY )")
    public boolean randombossspawns = true;
    }

    public static class MobAttributes{
    @Config.Name("Global Aggro Range in Blocks")
    public  float aggrorange = 50;
    @Config.Name("Grimm Health Multiplier")
    public  float grimmhealthmult = 1.5F;
    @Config.Name("Grimm Attack Damage Multiplier")
    public  float grimmattackmult = 1F;
    @Config.Name("Grimm Fluid Spawn Rate")
    @Config.Comment("One in x chance to spawn a grimm every tick for each block.")
    @Config.RangeInt(min = 0)
    public  int grimmFluidSpawnRate = 50000;
    }


    public static class Aura{
    @Config.Name("Render Aura Bar?")
    public  boolean RenderAurabar = true;
    @Config.Name("Position X")
    public  int aurapositionx = 175;
    @Config.Name("Position Y")
    public  int aurapositiony = 39;
    @Config.Name("Semblance Recharge Delay in Ticks")
    public  int delayticks = 250;
    @Config.Name("Aura Max Level")
    public  int auralvlmax = 500;
    @Config.Name("Aura XP Cost per Level")
    public  int auraperlevel = 40;
    @Config.Name("Can Aura Block Damage?")
    public  boolean aurablockdamage = true;

    @Config.Name("Player Aura Damage Reduction Amount")
    @Config.Comment("percentage reduce damage = player damage reduction reconmendation to keep at default")
    public  float playerdamagetoaurareduction = 0.5F;


    @Config.Comment("percentage reduce damage = mob damage reduction reconmendation to keep at default")
    public  float entitydamagetoaurareduction = 0.5F;

    @Config.Name("Enable Aura Damage Reduction")
    @Config.Comment("enable or disable player damage to aura reduction")
    public  boolean auradamagereduction = true;
    @Config.Name("Blake Drain Rate")
    public float blakedrainrate = 5.0F;
    @Config.Name("Nora Drain Rate")
    public float noradrainrate = 0.5F;
    @Config.Name("Ren Drain Rate")
    public float rendrainrate = 0.3F;
    @Config.Name("Lysette Drain Rate")
    public float lysettedrainrate = 0.05F;
    @Config.Name("Ruby Drain Rate")
    public float rubydrainrate = 0.1F;
    @Config.Name("Valour Drainrate")
    public float valourdrainrate = 0.5F;
    @Config.Name("Weiss Boarbatusk Cost")
    public int weissboarbatusk = 5;
    @Config.Name("Weiss Beowolf Cost")
    public int weissbeowolf = 15;
    @Config.Name("Weiss Ursa Cost")
    public int weissursa = 25;
    @Config.Name("Weiss Armagigas Cost")
    public int weissarmagigas = 60;
    @Config.Name("Yang Drain Rate")
    public float yangdrainrate = 0.3F;
    @Config.Name("Jaune Aura Transfer Rate")
    public float jaunedrainrate = 0.15F;
    @Config.Name("Harriet Drain Rate")
    public float harrietdrainrate = 0.05F;
    @Config.Name("Harriet Speed Multiplier")
    public int harrietspeedmult = 5;
    //@Config.Name("Ragora Initial Summon Cost")
   // public int ragorainitialsummon = 10;
    //@Config.Name("Ragora Initial Summon Cost")
    //public float ragoraupkeep = 0.1F;
    @Config.Name("Ragora Familiar Particles")
    public  boolean ragoraparticles = true;
    @Config.Name("Ragora ShadowBall Resolution")
    public  float shadowballresolution = 1F;
    @Config.Name("Ragora ShadowBall Size")
    public  float shadowballsize = 4.5F;
    @Config.Name("Ragora Summon Particle Count")
    public  int ragorasummonparticles = 100;
        /*@Config.Name("Start With Semblance")
        public  boolean startwithsemblance = false;*/
    }

    public static class Mining{
    //@Config.Name("Spawn Chance Dust Shop")
    //public  int dustshop = 60;
    //@Config.Name("Spawn Chance of Remote Dust shop")
    //public  int dustshop2 = 60;
    //@Config.Name("Spawn Chance Crow Bar")
    //public  int bar = 60;
    //@Config.Name("Spawn Chance Well")
    //public  int well = 10;
    @Config.Name("Rarity of RWBYM Biomes(Higher Numbers are more Common)")
    public  int biomerarity = 20;
    @Config.Name("Spawn Chance Dark Crystal(1 in rate chance where possible)")
    public  int darkcrystalrate = 8;
    @Config.Name("Spawn Chance Gravity Dust(Higher Numbers are more Common)")
    public  int gravityore = 1;
    @Config.Name("Spawn Chance Fire Dust(Higher Numbers are more Common)")
    public  int fireore = 1;
    @Config.Name("Spawn Chance Wind Dust(Higher Numbers are more Common)")
    public  int windore = 1;
    @Config.Name("Spawn Chance Impure Dust(Higher Numbers are more Common)")
    public  int impureore = 2;
    @Config.Name("Spawn Chance Water Dust(Higher Numbers are more Common)")
    public  int waterore = 1;
    @Config.Name("Spawn Chance Lightning Dust(Higher Numbers are more Common)")
    public  int lightore = 1;
    @Config.Name("Spawn Chance Ice Dust(Higher Numbers are more Common)")
    public  int iceore = 1;
    @Config.Name("Dust Ore Explosion Effect Chance")
    public  int dustoreeffect = 20;
    @Config.Name("Enable or Disable Explosive Dust Mining")
    public  boolean unsafemining = true;
    //@Config.Name("Legacy WorldGen")
    //public boolean legacyworldgen = false;
    }


    public static class General {
    @Config.Name("Give Player Scroll on First Spawn?")
    public  boolean enablefirstspawnscroll = true;

    @Config.Name("enable/disable biome fog effects")
    public  boolean enablebiomefogeffects = true;

    @Config.Name("Gun Volume")
    public float gunvolume = 1F;
    @Config.Name("speedlimiter -- lightningdust")
    public boolean lightningdustlimiter = false;
    @Config.Name("Maximum Bullet Predictor Lines")
    public int maxBulletLines = 10;

}


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
