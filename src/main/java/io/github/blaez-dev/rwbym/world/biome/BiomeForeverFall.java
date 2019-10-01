package io.github.blaez-dev.rwbym.world.biome;

import io.github.blaez-dev.rwbym.entity.EntityBeowolf;
import io.github.blaez-dev.rwbym.entity.EntityBoarbatusk;
import io.github.blaez-dev.rwbym.entity.EntityUrsa;
import io.github.blaez-dev.rwbym.utility.RWBYConfig;
import net.minecraft.world.biome.Biome;

public class BiomeForeverFall extends Biome {

    public BiomeForeverFall() {
        super(new BiomeProperties("Forever Fall").setBaseBiome("forest").setRainfall(0.5F).setHeightVariation(0.1F));
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.decorator.treesPerChunk = 7;
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBeowolf.class, RWBYConfig.spawnratebeowolf, 3, 6));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBoarbatusk.class, RWBYConfig.spawnrateboar, 3, 6));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityUrsa.class, RWBYConfig.spawnrateursa, 3, 6));

    }

    @Override
    public int getModdedBiomeGrassColor(int original) {
        return 0xcc0c0c;
    }

    @Override
    public int getModdedBiomeFoliageColor(int original) {
        return 0xcc0c0c;
    }
}
