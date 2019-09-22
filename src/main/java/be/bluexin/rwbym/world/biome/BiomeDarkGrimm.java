package be.bluexin.rwbym.world.biome;

import be.bluexin.rwbym.entity.*;
import net.minecraft.world.biome.Biome;

public class BiomeDarkGrimm extends Biome {

    public BiomeDarkGrimm() {
        super(new BiomeProperties("Grimm Wastes").setBaseBiome("forest").setRainfall(0.5F).setHeightVariation(0.01F));
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.decorator.treesPerChunk = 0;
        this.decorator.flowersPerChunk = -50;
        this.decorator.deadBushPerChunk = 4;
        this.decorator.sandPatchesPerChunk = 2;
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBeowolf.class, 20, 1, 20));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityUrsa.class, 20, 1, 20));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBoarbatusk.class, 20, 1, 20));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGoliath.class, 1, 1, 20));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityDeathStalker.class, 1, 1, 20));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityMutantDeathStalker.class, 1, 1, 20));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityNeverMore.class, 20, 1, 20));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGiantNeverMore.class, 1, 1, 20));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCreep.class, 20, 1, 20));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGeist.class, 20, 1, 20));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityApathy.class, 20, 1, 20));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityNuckleeve.class, 1, 1, 20));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityLancer.class, 20, 1, 20));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityJuvenileDeathstalker.class, 20, 1, 20));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityQueenLancer.class, 1, 1, 20));

    }

    @Override
    public int getModdedBiomeGrassColor(int original) {
        return 0x212121;
    }

    @Override
    public int getModdedBiomeFoliageColor(int original) {
        return 0x212121;
    }

    @Override
    public int getWaterColorMultiplier() {return 0x000000; }
    
    @Override
    public int getSkyColorByTemp(float currentTemperature) {
    	return 0x000000;
    }
}