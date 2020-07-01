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
        @Config.Name("Spawn Rate Beowolf")
    public  int spawnratebeowolf= 50;
    @Config.Name("Spawn Rate Ursa")
    public  int spawnrateursa= 50;
    @Config.Name("Spawn Rate Boarbatusk")
    public  int spawnrateboar= 50;
    @Config.Name("Spawn Rate Goliath")
    public  int spawnrategoliath= 1;
    @Config.Name("Spawn Rate Deathstalker")
    public  int spawnratedeathstalker= 1;
    @Config.Name("Spawn Rate Mutant Deathstalker")
    public  int spawnratemutantdeathstalker= 1;
    @Config.Name("Spawn Rate Nevermore")
    public  int spawnratenevermore= 50;
    @Config.Name("Spawn Rate Giant Nevermore")
    public  int spawnrategiantnevermore= 1;
    @Config.Name("Spawn Rate Creep")
    public  int spawnratecreep= 50;
    @Config.Name("Spawn Rate Geist")
    public  int spawnrategeist= 30;
    @Config.Name("Spawn Rate Lancer")
    public  int spawnratelancer= 50;
    @Config.Name("Spawn Rate Nuckleeve")
    public  int spawnratenuckleeve= 1;
    @Config.Name("Spawn Rate Apathy")
    public  int spawnrateapathy= 50;
    @Config.Name("Spawn Rate Tiny DeathStalker")
    public  int spawnratetinydeathstalker= 50;
    @Config.Name("Spawn Rate Beringle")
    public  int spawnrateberingle= 50;
    @Config.Name("Spawn Rate Queen Lancer")
    public  int spawnratequeenlancer= 1;
    @Config.Name("Spawn Rate Wyvern")
    public  int spawnratewyvern= 1;
    @Config.Name("Spawn Rate Ravager")
    public  int spawnrateravager= 50;
    @Config.Name("Spawn Rate Seer")
    public  int spawnrateseer= 50;
    @Config.Name("Spawn Rate Arachne")
    public  int spawnratearachne= 50;
    @Config.Name("Lancer Queen Nests")
    @Config.Comment("Enable Lancer Queens to Spawn anywhere dark")
    public  boolean lancernests = false;
    @Config.Name("Disable Random Boss Spawns//Only spawn during Dark Crystal Raids")
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
    @Config.Name("Can Aura Block Damage?")
    public  boolean aurablockdamage = true;
    @Config.Name("Player Aura Damage Reduction Amount")
    @Config.Comment("Current Max Aura/player damage to aura reduction = player damage reduction reconmendation to keep at default")
    public  int playerdamagetoaurareduction = 1000;
    @Config.Name("Enable Player Aura Damage Reduction")
    @Config.Comment("enable or disable player damage to aura reduction")
    public  boolean aurareduction = true;
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
    @Config.Name("Spawn Chance Dust Shop")
    public  int dustshop = 60;
    @Config.Name("Spawn Chance of Remote Dust shop")
    public  int dustshop2 = 60;
    @Config.Name("Spawn Chance Crow Bar")
    public  int bar = 60;
    @Config.Name("Spawn Chance Well")
    public  int well = 10;
    @Config.Name("Rarity of RWBYM Biomes")
    public  int biomerarity = 20;
    @Config.Name("Spawn Chance Dark Crystal")
    public  int darkcrystalrate = 8;
    @Config.Name("Spawn Chance Gravity DusT")
    public  int gravityore = 1;
    @Config.Name("Spawn Chance Fire Dust")
    public  int fireore = 1;
    @Config.Name("Spawn Chance Wind Dust")
    public  int windore = 1;
    @Config.Name("Spawn Chance Impure Dust")
    public  int impureore = 2;
    @Config.Name("Spawn Chance Water Dust")
    public  int waterore = 1;
    @Config.Name("Spawn Chance Lightning Dust")
    public  int lightore = 1;
    @Config.Name("Spawn Chance Ice Dust")
    public  int iceore = 1;
    @Config.Name("Dust Ore Random Effect Chance")
    public  int dustoreeffect = 20;
    @Config.Name("Unsafe Dust Mining")
    public  boolean unsafemining = true;
    @Config.Name("Legacy WorldGen")
    public boolean legacyworldgen = false;
    }


    public static class General {
    @Config.Name("Give Player Scroll on First Spawn?")
    public  boolean enablefirstspawnscroll = false;
    @Config.Name("Gun Volume")
    public float gunvolume = 1F;
    @Config.Name("speedlimiter -- lightningdust")
    public boolean lightningdustlimiter = false;

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
