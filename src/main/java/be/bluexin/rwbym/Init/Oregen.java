package be.bluexin.rwbym.Init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import net.minecraft.util.math.BlockPos;
import  net.minecraft.world.World;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class Oregen implements IWorldGenerator{

    //World Generators
    private WorldGenerator gravity_overworld;
    private WorldGenerator fire_overworld;
    private WorldGenerator wind_overworld;
    private WorldGenerator impure_overworld;
    private WorldGenerator water_overworld;
    private WorldGenerator light_overworld;

    public Oregen() {
        gravity_overworld = new WorldGenMinable(RWBYItems.rwbyblock1.getDefaultState(), 8);
        fire_overworld = new WorldGenMinable(RWBYItems.rwbyblock2.getDefaultState(), 8);
        wind_overworld = new WorldGenMinable(RWBYItems.rwbyblock3.getDefaultState(), 8);
        impure_overworld = new WorldGenMinable(RWBYItems.rwbyblock4.getDefaultState(), 8);
        water_overworld = new WorldGenMinable(RWBYItems.rwbyblock5.getDefaultState(), 8);
        light_overworld = new WorldGenMinable(RWBYItems.rwbyblock6.getDefaultState(), 8);
    }


    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight, Class<?>... classes) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        ArrayList<Class<?>> classeslist = new ArrayList<Class<?>>(Arrays.asList(classes));
        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i ++) {
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + rand.nextInt(16);
            BlockPos pos = new BlockPos(x,y,z);
            Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
            if (classeslist.contains(biome) || classes.length ==0) generator.generate(world,rand, pos);
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
                         IChunkProvider ChunkProvider) {
        switch(world.provider.getDimension()){
            case 0: //Overworld
                this.runGenerator(gravity_overworld, world, random, chunkX, chunkZ, 15, 0, 256); //BiomeHills.class, BiomeMesa.class, BiomeJungle.class
                this.runGenerator(fire_overworld, world, random, chunkX, chunkZ, 15, 0, 256); //BiomeDesert.class, BiomeSavanna.class, BiomeMesa.class, BiomeSavannaMutated.class
                this.runGenerator(wind_overworld, world, random, chunkX, chunkZ, 15, 0, 256); //BiomeHills.class, BiomeMesa.class, BiomeJungle.class, BiomePlains.class
                this.runGenerator(impure_overworld, world, random, chunkX, chunkZ, 15, 0, 256);
                this.runGenerator(water_overworld, world, random, chunkX, chunkZ, 15, 0, 64); //BiomeOcean.class,BiomeBeach.class, BiomeMushroomIsland.class,BiomeSwamp.class
                this.runGenerator(light_overworld, world, random, chunkX, chunkZ, 15, 0, 256);//BiomeHills.class,BiomeMesa.class
        }
    }
}
