package io.github.blaezdev.rwbym.world.biome;

import io.github.blaezdev.rwbym.entity.*;
import net.minecraft.world.biome.Biome;

public class BiomeDomainofLight extends Biome {

    public BiomeDomainofLight() {
        super(new BiomeProperties("Grimm Wastes").setBaseBiome("forest").setRainfall(0.5F).setHeightVariation(0.01F));
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.decorator.treesPerChunk = 0;
        this.decorator.flowersPerChunk = 10;
        this.decorator.sandPatchesPerChunk = 2;
    }

    @Override
    public int getModdedBiomeGrassColor(int original) {
        return 0xF1BB3C;
    }

    @Override
    public int getModdedBiomeFoliageColor(int original) {
        return 0xF1BB3C;
    }

    @Override
    public int getWaterColorMultiplier() {return 0x5C97C5; }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0xB2C3D8;
    }
}