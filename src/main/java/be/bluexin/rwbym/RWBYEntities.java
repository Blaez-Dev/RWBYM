package be.bluexin.rwbym;

import be.bluexin.rwbym.entity.*;
import be.bluexin.rwbym.utility.Config;
import be.bluexin.rwbym.weaponry.RWBYAmmoEntity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static be.bluexin.rwbym.RWBYModels.MODID;

@SuppressWarnings("unchecked")
public class RWBYEntities {

    public static Object instance;
    public int mobid = 0;

    public static Biome[] clean(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
        Iterator<Biome> itr = in.iterator();
        ArrayList<Biome> ls = new ArrayList<Biome>();
        while (itr.hasNext()) {
            ls.add(itr.next());
        }
        return ls.toArray(new Biome[ls.size()]);
    }

    public void preInit(FMLPreInitializationEvent event) {
        int entityID = 0;
        mobid = entityID;

        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:beowolf"), EntityBeowolf.class, "beowolf", entityID, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:projectiles"), EntityBullet.class, "rwbyprojectile", entityID + 1, instance, 64, Integer.MAX_VALUE, false);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:ursa"), EntityUrsa.class, "ursa", entityID + 2, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:boarbatusk"), EntityBoarbatusk.class, "boarbatusk", entityID + 3, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:fireball"), EntitySmallFireball.class, "fireball", entityID + 4, instance, 64, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:largefireball"), EntityLargeFireball.class, "largeFireball", entityID + 5, instance, 64, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:goliath"), EntityGoliath.class, "goliath", entityID + 6, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:deathstalker"), EntityDeathStalker.class, "deathstalker", entityID + 7, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:mutantdeathstalker"), EntityMutantDeathStalker.class, "mutantdeathstalker", entityID + 8, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:creep"), EntityCreep.class, "creep", entityID + 9, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:nevermore"), EntityNeverMore.class, "nevermore", entityID + 10, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:giantnevermore"), EntityGiantNeverMore.class, "giantnevermore", entityID + 11, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:winter_beowolf"), EntityWinterBeowolf.class, "winter_beowolf", entityID + 12, instance, 64, 1, true, (153 << 16) + (153 << 8) + 153, (0 << 16) + (0 << 8) + 0);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:winter_ursa"), EntityWinterUrsa.class, "winter_ursa", entityID + 13, instance, 64, 1, true, (153 << 16) + (153 << 8) + 153, (0 << 16) + (0 << 8) + 0);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:winter_boarbatusk"), EntityWinterBoarbatusk.class, "winter_boarbatusk", entityID + 14, instance, 64, 1, true, (153 << 16) + (153 << 8) + 153, (0 << 16) + (0 << 8) + 0);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:atlasknight"), EntityAtlasKnight.class, "atlasknight", entityID + 15, instance, 64, 1, true, (153 << 16) + (153 << 8) + 153, (0 << 16) + (0 << 8) + 0);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:blakefire"), EntityBlakeFire.class, "blakefire", entityID + 16, instance, 64, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:blakeice"), EntityBlakeIce.class, "blakeice", entityID + 17, instance, 64, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:blake"), EntityBlake.class, "blake", entityID + 18, instance, 64, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:armorgeist"), EntityArmorgeist.class, "armorgeist", entityID + 19, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:winterarmorgeist"), EntityWinterArmorgeist.class, "winterarmorgeist", entityID + 20, instance, 64, 1, true, (153 << 16) + (153 << 8) + 153, (0 << 16) + (0 << 8) + 0);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:geist"), EntityGeist.class, "geist", entityID + 21, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:apathy"), EntityApathy.class, "apathy", entityID + 22, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:nuckleeve"), EntityNuckleeve.class, "nuckleeve", entityID + 23, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:store"), EntityStore.class, "store", entityID + 25, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:lancer"), EntityLancer.class, "lancer", entityID + 24, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:tinyeathstalker"), EntityJuvenileDeathstalker.class, "tinydeathstalker", entityID + 26, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:queenlancer"), EntityQueenLancer.class, "queenlancer", entityID + 27, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:weaponstore"), EntityWeaponStore.class, "weaponstore", entityID + 28, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:blackstore"), EntityBlackStore.class, "blackstore", entityID + 29, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:crowbar"), EntityCrowBar.class, "crowbar", entityID + 30, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        Biome[] biomes = getBiomeList(EntityCreeper.class, EnumCreatureType.MONSTER);
        Biome[] biomes1 = getBiomeList(EntityStray.class, EnumCreatureType.MONSTER);



        //EntityRegistry.addSpawn(EntityBeowolf.class, Config.spawnrate1, 3, 10, EnumCreatureType.MONSTER, biomes);
        EntityRegistry.addSpawn(EntityBeowolf.class, 50, 3, 10, EnumCreatureType.MONSTER, biomes);
        EntityRegistry.addSpawn(EntityUrsa.class, 50, 3, 10, EnumCreatureType.MONSTER, biomes);
        EntityRegistry.addSpawn(EntityBoarbatusk.class, 50, 3, 10, EnumCreatureType.MONSTER, biomes);
        EntityRegistry.addSpawn(EntityGoliath.class, 5, 3, 1, EnumCreatureType.MONSTER, biomes);
        EntityRegistry.addSpawn(EntityDeathStalker.class, 5, 3, 1, EnumCreatureType.MONSTER, biomes);
        EntityRegistry.addSpawn(EntityMutantDeathStalker.class, 5, 3, 1, EnumCreatureType.MONSTER, biomes);
        EntityRegistry.addSpawn(EntityNeverMore.class, 50, 4, 10, EnumCreatureType.MONSTER, biomes);
        EntityRegistry.addSpawn(EntityGiantNeverMore.class, 10, 4, 10, EnumCreatureType.MONSTER, biomes);
        EntityRegistry.addSpawn(EntityCreep.class, 50, 3, 10, EnumCreatureType.MONSTER, biomes);
        EntityRegistry.addSpawn(EntityGeist.class, 10, 1, 5, EnumCreatureType.MONSTER, biomes);
        EntityRegistry.addSpawn(EntityApathy.class, 75, 7, 10, EnumCreatureType.MONSTER, biomes1);
        EntityRegistry.addSpawn(EntityNuckleeve.class, 10, 3, 1, EnumCreatureType.MONSTER, biomes);
        EntityRegistry.addSpawn(EntityLancer.class, 75, 3, 10, EnumCreatureType.MONSTER, biomes);
        EntityRegistry.addSpawn(EntityJuvenileDeathstalker.class, 50, 3, 10, EnumCreatureType.MONSTER, biomes);
        EntityRegistry.addSpawn(EntityQueenLancer.class, 10, 3, 1, EnumCreatureType.MONSTER, biomes);


        //DungeonHooks.addDungeonMob(new ResourceLocation("rwbym:beowolf"), 180);
        //DungeonHooks.addDungeonMob(new ResourceLocation("rwbym:ursa"), 180);
        //DungeonHooks.addDungeonMob(new ResourceLocation("rwbym:boarbatusk"), 180);

    }

    /**
     * Helper method to return an array of biomes in which an already existing instance of EntityLiving can spawn.
     */
    private static final Biome[] getBiomeList(final Class<? extends EntityLiving> classToCopy, final EnumCreatureType creatureTypeToCopy)
    {
        final List<Biome> biomes = new ArrayList<Biome>();

        for (final Biome biome : ForgeRegistries.BIOMES)
        {
            biome.getSpawnableList(creatureTypeToCopy).stream().filter(new Predicate<Biome.SpawnListEntry>()
            {
                @Override
                public boolean test(Biome.SpawnListEntry entry)
                {
                    return entry.entityClass == classToCopy;
                }
            })
                    .findFirst()
                    .ifPresent(new Consumer<Biome.SpawnListEntry>()
                    {
                        @Override
                        public void accept(Biome.SpawnListEntry spawnListEntry)
                        {
                            biomes.add(biome);
                        }
                    });
        }

        return biomes.toArray(new Biome[biomes.size()]);
    }

}
