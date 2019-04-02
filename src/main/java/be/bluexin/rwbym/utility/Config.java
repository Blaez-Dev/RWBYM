package be.bluexin.rwbym.utility;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static be.bluexin.rwbym.RWBYModels.MODID;

public class Config {
    private static Configuration config = null;

    public static final String CATEGORY_GENERAL = "GENERAL";

    public static int spawnrate1;

    public static void preInit(){
    File configFile = new File(Loader.instance().getConfigDir(), "rwbym.cfg");
    config = new Configuration(configFile);
    syncFromFiles();
    }

    public static Configuration getConfig(){
        return config;
    }
    

    public static void syncFromFiles(){
        syncConfig(true,true);
    }

    public static void syncFromgui(){
        syncConfig(false,true);
    }



    private static void syncConfig(boolean loadFromConfigFile,boolean readFieldFromConfig){
        if(loadFromConfigFile) config.load();
        Property spawnrate = config.get(CATEGORY_GENERAL,"spawnrate", 100);
        spawnrate.setLanguageKey("gui.config.spawnrate");
        spawnrate.setMinValue(0);
        spawnrate.setMaxValue(500);

        List<String> propertOrderspawnrate = new ArrayList<String>();
        propertOrderspawnrate.add(spawnrate.getName());
        config.setCategoryPropertyOrder(CATEGORY_GENERAL, propertOrderspawnrate);
        if(readFieldFromConfig){
            spawnrate1 = spawnrate.getInt();
        }

        spawnrate.set(spawnrate1);
        if(config.hasChanged()) config.save();
    }

}