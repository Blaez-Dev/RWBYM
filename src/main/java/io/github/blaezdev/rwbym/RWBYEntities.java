package io.github.blaezdev.rwbym;

import io.github.blaezdev.rwbym.Init.RWBYBiomes;
import io.github.blaezdev.rwbym.entity.*;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import io.github.blaezdev.rwbym.weaponry.RWBYItem;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@SuppressWarnings("unchecked")
public class RWBYEntities {

    public static Object instance;

    public static final EnumCreatureAttribute grimm = EnumHelper.addCreatureAttribute("grimm");

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

        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:beowolf"), EntityBeowolf.class, "beowolf", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:projectiles"), EntityBullet.class, "rwbyprojectile", entityID++, instance, 64, Integer.MAX_VALUE, false);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:ursa"), EntityUrsa.class, "ursa", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:boarbatusk"), EntityBoarbatusk.class, "boarbatusk", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:fireball"), EntitySmallFireball.class, "fireball", entityID++, instance, 64, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:largefireball"), EntityLargeFireball.class, "largeFireball", entityID++, instance, 64, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:goliath"), EntityGoliath.class, "goliath", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:deathstalker"), EntityDeathStalker.class, "deathstalker", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:mutantdeathstalker"), EntityMutantDeathStalker.class, "mutantdeathstalker", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:creep"), EntityCreep.class, "creep", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:nevermore"), EntityNeverMore.class, "nevermore", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:giantnevermore"), EntityGiantNeverMore.class, "giantnevermore", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:winter_beowolf"), EntityWinterBeowolf.class, "winter_beowolf", entityID++, instance, 64, 1, true, (153 << 16) + (153 << 8) + 153, (0 << 16) + (0 << 8) + 0);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:winter_ursa"), EntityWinterUrsa.class, "winter_ursa", entityID++, instance, 64, 1, true, (153 << 16) + (153 << 8) + 153, (0 << 16) + (0 << 8) + 0);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:winter_boarbatusk"), EntityWinterBoarbatusk.class, "winter_boarbatusk", entityID++, instance, 64, 1, true, (153 << 16) + (153 << 8) + 153, (0 << 16) + (0 << 8) + 0);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:atlasknight"), EntityAtlasKnight.class, "atlasknight", entityID++, instance, 64, 1, true, (153 << 16) + (153 << 8) + 153, (0 << 16) + (0 << 8) + 0);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:blakefire"), EntityBlakeFire.class, "blakefire", entityID++, instance, 64, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:blakeice"), EntityBlakeIce.class, "blakeice", entityID++, instance, 64, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:blake"), EntityBlake.class, "blake", entityID++, instance, 64, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:armorgeist"), EntityArmorgeist.class, "armorgeist", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:winterarmorgeist"), EntityWinterArmorgeist.class, "winterarmorgeist", entityID++, instance, 64, 1, true, (153 << 16) + (153 << 8) + 153, (0 << 16) + (0 << 8) + 0);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:geist"), EntityGeist.class, "geist", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:apathy"), EntityApathy.class, "apathy", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:nuckleeve"), EntityNuckleeve.class, "nuckleeve", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:store"), EntityStore.class, "store", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:lancer"), EntityLancer.class, "lancer", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:tinyeathstalker"), EntityJuvenileDeathstalker.class, "tinydeathstalker", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:queenlancer"), EntityQueenLancer.class, "queenlancer", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:weaponstore"), EntityWeaponStore.class, "weaponstore", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:blackstore"), EntityBlackStore.class, "blackstore", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:crowbar"), EntityCrowBar.class, "crowbar", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:ren"), EntityRen.class, "ren", entityID++, instance, 64, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:ragora"), EntityRagora.class, "ragora", entityID++, instance, 65, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:armorstore"), EntityArmourStore.class, "aegis", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:zwei"), EntityZwei.class, "Zwei", entityID++, instance, 64, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:ursamajor"), EntityUrsaMajor.class, "ursamajor", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:beringle"), EntityBeringle.class, "beringle", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:sabyr"), EntitySabyr.class, "sabyr", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:wyvern"), EntityWyvern.class, "wyvern", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:ravager"), EntityRavager.class, "ravager", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:seer"), EntitySeer.class, "seer", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:arachne"), EntityArachne.class, "arachne", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:arachneclone"), EntityArachneClone.class, "arachneclone", entityID++, instance, 64, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("rwbym:hollow"), EntityHollow.class, "hollow", entityID++, instance, 64, 1, true, (0 << 16) + (0 << 8) + 0, (153 << 16) + (153 << 8) + 153);

        Biome[] biomes = getBiomeList(EntityCreeper.class, EnumCreatureType.MONSTER);
        Biome[] biomes1 = getBiomeList(EntityStray.class, EnumCreatureType.MONSTER);




        if(RWBYConfig.configmobspawnrates.randombossspawns){
            if(RWBYConfig.configmobspawnrates.spawnrategoliath > 0){
        EntityRegistry.addSpawn(EntityGoliath.class, RWBYConfig.configmobspawnrates.spawnrategoliath, 0, 1, EnumCreatureType.MONSTER, biomes);}

            if(RWBYConfig.configmobspawnrates.spawnratemutantdeathstalker > 0){
        EntityRegistry.addSpawn(EntityMutantDeathStalker.class, RWBYConfig.configmobspawnrates.spawnratemutantdeathstalker, 0, 1, EnumCreatureType.MONSTER, biomes);}

            if(RWBYConfig.configmobspawnrates.spawnratequeenlancer > 0){
        EntityRegistry.addSpawn(EntityQueenLancer.class, RWBYConfig.configmobspawnrates.spawnratequeenlancer, 0, 1, EnumCreatureType.MONSTER, biomes);}

            if(RWBYConfig.configmobspawnrates.spawnrategiantnevermore > 0){
        EntityRegistry.addSpawn(EntityGiantNeverMore.class, RWBYConfig.configmobspawnrates.spawnrategiantnevermore, 0, 1, EnumCreatureType.MONSTER, biomes);}

            if(RWBYConfig.configmobspawnrates.spawnratewyvern > 0){
        EntityRegistry.addSpawn(EntityWyvern.class, RWBYConfig.configmobspawnrates.spawnratewyvern, 0, 1, EnumCreatureType.MONSTER, biomes);}

        }

        if(RWBYConfig.configmobspawnrates.spawnratehollow > 0){
        EntityRegistry.addSpawn(EntityHollow.class, RWBYConfig.configmobspawnrates.spawnratehollow, 0, 1, EnumCreatureType.MONSTER, biomes);}

        if(RWBYConfig.configmobspawnrates.spawnratedeathstalker > 0){
        EntityRegistry.addSpawn(EntityDeathStalker.class, RWBYConfig.configmobspawnrates.spawnratedeathstalker, 0, 1, EnumCreatureType.MONSTER, biomes);}

        if(RWBYConfig.configmobspawnrates.spawnratenevermore > 0){
        EntityRegistry.addSpawn(EntityNeverMore.class, RWBYConfig.configmobspawnrates.spawnratenevermore, 0, 3, EnumCreatureType.MONSTER, biomes);}

        if(RWBYConfig.configmobspawnrates.spawnratenuckleeve > 0){
            EntityRegistry.addSpawn(EntityNuckleeve.class, RWBYConfig.configmobspawnrates.spawnratenuckleeve, 0, 1, EnumCreatureType.MONSTER, biomes); }

        if(RWBYConfig.configmobspawnrates.spawnratebeowolf > 0){
            EntityRegistry.addSpawn(EntityBeowolf.class, RWBYConfig.configmobspawnrates.spawnratebeowolf, 0, 3, EnumCreatureType.MONSTER, biomes); }


        if(RWBYConfig.configmobspawnrates.spawnrateursa > 0){
            EntityRegistry.addSpawn(EntityUrsa.class, RWBYConfig.configmobspawnrates.spawnrateursa, 0, 3, EnumCreatureType.MONSTER, biomes); }


        if(RWBYConfig.configmobspawnrates.spawnrateursa > 0){
            EntityRegistry.addSpawn(EntityUrsaMajor.class, RWBYConfig.configmobspawnrates.spawnrateursa, 0, 3, EnumCreatureType.MONSTER, biomes); }

        if(RWBYConfig.configmobspawnrates.spawnrateboar > 0) {
            EntityRegistry.addSpawn(EntityBoarbatusk.class, RWBYConfig.configmobspawnrates.spawnrateboar, 0, 3, EnumCreatureType.MONSTER, biomes); }

        if(RWBYConfig.configmobspawnrates.spawnratecreep > 0) {
            EntityRegistry.addSpawn(EntityCreep.class, RWBYConfig.configmobspawnrates.spawnratecreep, 0, 3, EnumCreatureType.MONSTER, biomes); }

        if(RWBYConfig.configmobspawnrates.spawnrategeist > 0){
        EntityRegistry.addSpawn(EntityGeist.class, RWBYConfig.configmobspawnrates.spawnrategeist, 0, 3, EnumCreatureType.MONSTER, biomes);}

        if(RWBYConfig.configmobspawnrates.spawnrateapathy > 0) {
            EntityRegistry.addSpawn(EntityApathy.class, RWBYConfig.configmobspawnrates.spawnrateapathy, 0, 3, EnumCreatureType.MONSTER, biomes); }

        if(RWBYConfig.configmobspawnrates.spawnratelancer > 0) {
            EntityRegistry.addSpawn(EntityLancer.class, RWBYConfig.configmobspawnrates.spawnratelancer, 0, 3, EnumCreatureType.MONSTER, biomes); }

        if(RWBYConfig.configmobspawnrates.spawnratedeathstalker > 0){
        EntityRegistry.addSpawn(EntityJuvenileDeathstalker.class, RWBYConfig.configmobspawnrates.spawnratetinydeathstalker, 0, 3, EnumCreatureType.MONSTER, biomes);}

        if(RWBYConfig.configmobspawnrates.spawnrateberingle > 0){
        EntityRegistry.addSpawn(EntityBeringle.class, RWBYConfig.configmobspawnrates.spawnrateberingle, 0, 3, EnumCreatureType.MONSTER, biomes);}

        if(RWBYConfig.configmobspawnrates.spawnrateravager > 0){
        EntityRegistry.addSpawn(EntityRavager.class, RWBYConfig.configmobspawnrates.spawnrateravager, 0, 5, EnumCreatureType.MONSTER, biomes);}

        if(RWBYConfig.configmobspawnrates.spawnrateseer > 0){
        EntityRegistry.addSpawn(EntitySeer.class, RWBYConfig.configmobspawnrates.spawnrateseer, 0, 5, EnumCreatureType.MONSTER, biomes);}

        if(RWBYConfig.configmobspawnrates.spawnratearachne > 0){
        EntityRegistry.addSpawn(EntityArachne.class, RWBYConfig.configmobspawnrates.spawnratearachne, 0, 5, EnumCreatureType.MONSTER, biomes);}



        ///Grimm Wastes Spawning//
        if(RWBYConfig.configmobspawnrates.spawnratebeowolf > 0){
        EntityRegistry.addSpawn(EntityBeowolf.class, 10, 2, 3, EnumCreatureType.CREATURE, RWBYBiomes.GrimmWastes);}

        if(RWBYConfig.configmobspawnrates.spawnrateursa > 0){
        EntityRegistry.addSpawn(EntityUrsa.class, 10, 2, 3, EnumCreatureType.CREATURE, RWBYBiomes.GrimmWastes);}

        if(RWBYConfig.configmobspawnrates.spawnrateursa > 0){
        EntityRegistry.addSpawn(EntityUrsaMajor.class, 10, 2, 3, EnumCreatureType.CREATURE, RWBYBiomes.GrimmWastes);}

        if(RWBYConfig.configmobspawnrates.spawnrateboar > 0){
        EntityRegistry.addSpawn(EntityBoarbatusk.class, 10, 2, 3, EnumCreatureType.CREATURE, RWBYBiomes.GrimmWastes);}

        if(RWBYConfig.configmobspawnrates.spawnrategoliath > 0){
        EntityRegistry.addSpawn(EntityGoliath.class, RWBYConfig.configmobspawnrates.spawnrategoliath, 0, 1, EnumCreatureType.CREATURE, RWBYBiomes.GrimmWastes);}

        if(RWBYConfig.configmobspawnrates.spawnratedeathstalker > 0){
        EntityRegistry.addSpawn(EntityDeathStalker.class, RWBYConfig.configmobspawnrates.spawnratedeathstalker, 0, 1, EnumCreatureType.CREATURE, RWBYBiomes.GrimmWastes);}

        if(RWBYConfig.configmobspawnrates.spawnratemutantdeathstalker > 0){
        EntityRegistry.addSpawn(EntityMutantDeathStalker.class, RWBYConfig.configmobspawnrates.spawnratemutantdeathstalker, 0, 1, EnumCreatureType.CREATURE, RWBYBiomes.GrimmWastes);}

        if(RWBYConfig.configmobspawnrates.spawnratenevermore > 0){
        EntityRegistry.addSpawn(EntityNeverMore.class, 10, 2, 3, EnumCreatureType.CREATURE, RWBYBiomes.GrimmWastes);}

        if(RWBYConfig.configmobspawnrates.spawnrategiantnevermore > 0){
        EntityRegistry.addSpawn(EntityGiantNeverMore.class, RWBYConfig.configmobspawnrates.spawnrategiantnevermore, 0, 1, EnumCreatureType.CREATURE, RWBYBiomes.GrimmWastes);}

        if(RWBYConfig.configmobspawnrates.spawnratecreep > 0){
        EntityRegistry.addSpawn(EntityCreep.class, 10, 2, 3, EnumCreatureType.CREATURE, RWBYBiomes.GrimmWastes);}

        if(RWBYConfig.configmobspawnrates.spawnrategeist > 0){
        EntityRegistry.addSpawn(EntityGeist.class, RWBYConfig.configmobspawnrates.spawnrategeist, 2, 3, EnumCreatureType.CREATURE, RWBYBiomes.GrimmWastes);}

        if(RWBYConfig.configmobspawnrates.spawnrateapathy > 0){
        EntityRegistry.addSpawn(EntityApathy.class, RWBYConfig.configmobspawnrates.spawnrateapathy, 2, 3, EnumCreatureType.CREATURE, RWBYBiomes.GrimmWastes);}

        if(RWBYConfig.configmobspawnrates.spawnratenuckleeve > 0){
        EntityRegistry.addSpawn(EntityNuckleeve.class, RWBYConfig.configmobspawnrates.spawnratenuckleeve, 0, 1, EnumCreatureType.CREATURE, RWBYBiomes.GrimmWastes);}

        if(RWBYConfig.configmobspawnrates.spawnratelancer > 0){
        EntityRegistry.addSpawn(EntityLancer.class, 10, 2, 3, EnumCreatureType.CREATURE, RWBYBiomes.GrimmWastes);}

        if(RWBYConfig.configmobspawnrates.spawnratetinydeathstalker > 0){
        EntityRegistry.addSpawn(EntityJuvenileDeathstalker.class, 10, 2, 3, EnumCreatureType.CREATURE, RWBYBiomes.GrimmWastes);}

        if(RWBYConfig.configmobspawnrates.spawnratequeenlancer > 0){
        EntityRegistry.addSpawn(EntityQueenLancer.class, RWBYConfig.configmobspawnrates.spawnratequeenlancer, 0, 1, EnumCreatureType.CREATURE, RWBYBiomes.GrimmWastes);}


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
