
package be.bluexin.rwbym;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class RWBYSoundHandler {

    private static List<SoundEvent> SOUNDS = new ArrayList<>();

    private static int size = 0;

    public static SoundEvent Crescent_Rose_Shoot;
    public static SoundEvent Gambol_Shroud_Shoot;
    public static SoundEvent Ember_Celica_Shoot;
    public static SoundEvent Mytrenaster_Shoot;
    public static SoundEvent StormFlower_Shoot;
    public static SoundEvent Magnhild_Shoot;
    public static SoundEvent Port_Shoot;
    public static SoundEvent Junior_Shoot;
    public static SoundEvent Torchwick_Shoot;

    public static void init() {
        size = SoundEvent.REGISTRY.getKeys().size();

        Crescent_Rose_Shoot = registerSound("weapon.crescent_rose.shoot");
        Gambol_Shroud_Shoot = registerSound("weapon.gambol_shroud.shoot");
        Ember_Celica_Shoot = registerSound("weapon.ember_celica.shoot");
        Mytrenaster_Shoot = registerSound("weapon.mytrenaster.shoot");
        StormFlower_Shoot = registerSound("weapon.storm_flower.shoot");
        Magnhild_Shoot = registerSound("weapon.magnhild.shoot");
        Port_Shoot = registerSound("weapon.port.shoot");
        Junior_Shoot = registerSound("weapon.junior.shoot");
        Torchwick_Shoot = registerSound("weapon.torchwick.shoot");
    }

    @SubscribeEvent
    public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> e) {
        SoundEvent[] sounds = SOUNDS.toArray(new SoundEvent[SOUNDS.size()]);
        e.getRegistry().registerAll(sounds);
    }
    //Avvii Thanks for the Sound Fix!
    private static SoundEvent registerSound(String name) {
        ResourceLocation location = new ResourceLocation(RWBYModels.MODID, name);
        SoundEvent e = new SoundEvent(location);
        e.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(e);
        return e;
    }

    /*public static SoundEvent register(String name) {
        ResourceLocation location = new ResourceLocation(RWBYModels.MODID, name);
        SoundEvent rl = new SoundEvent(location);
        SoundEvent.REGISTRY.register(size, location, rl);
        size++;
        System.out.println("Registered Sound " + name);
        return rl;
    }*/

}
