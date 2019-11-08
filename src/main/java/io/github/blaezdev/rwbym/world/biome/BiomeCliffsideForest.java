package io.github.blaezdev.rwbym.world.biome;

import io.github.blaezdev.rwbym.entity.EntityApathy;
import io.github.blaezdev.rwbym.entity.EntityBeowolf;
import io.github.blaezdev.rwbym.entity.EntityBoarbatusk;
import io.github.blaezdev.rwbym.entity.EntityUrsa;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import net.minecraft.world.biome.Biome;

public class BiomeCliffsideForest extends Biome{
        public BiomeCliffsideForest() {
            super(new BiomeProperties("CliffSideForest").setBaseBiome("forest").setRainfall(1F).setHeightVariation(0.1F).setTemperature(0F));
            this.spawnableCaveCreatureList.clear();
            this.spawnableCreatureList.clear();
            this.spawnableMonsterList.clear();
            this.spawnableWaterCreatureList.clear();
            this.decorator.treesPerChunk = 7;
            this.spawnableCreatureList.add(new SpawnListEntry(EntityBeowolf.class, RWBYConfig.configmobspawnrates.spawnratebeowolf*8, 1, 16));
            this.spawnableCreatureList.add(new SpawnListEntry(EntityBoarbatusk.class, RWBYConfig.configmobspawnrates.spawnrateboar, 0, 3));
            this.spawnableCreatureList.add(new SpawnListEntry(EntityUrsa.class, RWBYConfig.configmobspawnrates.spawnrateursa, 0, 3));
            this.spawnableCreatureList.add(new SpawnListEntry(EntityApathy.class, RWBYConfig.configmobspawnrates.spawnrateapathy, 2, 16));

        }

        @Override
        public int getModdedBiomeGrassColor(int original) {
            return 0xfffbfb;
        }

        @Override
        public int getModdedBiomeFoliageColor(int original) {
            return 0xfffbfb;
        }
    }