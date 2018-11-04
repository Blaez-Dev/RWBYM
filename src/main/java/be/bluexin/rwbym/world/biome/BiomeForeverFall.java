package be.bluexin.rwbym.world.biome;

import be.bluexin.rwbym.entity.EntityBeowolf;
import be.bluexin.rwbym.entity.EntityBoarbatusk;
import be.bluexin.rwbym.entity.EntityUrsa;
import net.minecraft.world.biome.Biome;

public class BiomeForeverFall extends Biome {

    public BiomeForeverFall() {
        super(new BiomeProperties("Forever Fall").setBaseBiome("forest").setRainfall(0.5F).setHeightVariation(0.1F));
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.decorator.treesPerChunk = 7;
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBeowolf.class, 20, 3, 6));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBoarbatusk.class, 20, 3, 6));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityUrsa.class, 20, 3, 6));

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
