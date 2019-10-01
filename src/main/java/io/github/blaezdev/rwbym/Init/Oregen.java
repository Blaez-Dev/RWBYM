package io.github.blaezdev.rwbym.Init;

import io.github.blaezdev.rwbym.utility.RWBYConfig;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Oregen implements IWorldGenerator{

    //World Generators
    private WorldGenerator gravity_overworld;
    private WorldGenerator fire_overworld;
    private WorldGenerator wind_overworld;
    private WorldGenerator impure_overworld;
    private WorldGenerator water_overworld;
    private WorldGenerator light_overworld;
    private WorldGenerator ice_overworld;

    public Oregen() {
        gravity_overworld = new WorldGenMinable(RWBYItems.rwbyblock1.getDefaultState(), 16);
        fire_overworld = new WorldGenMinable(RWBYItems.rwbyblock2.getDefaultState(), 16);
        wind_overworld = new WorldGenMinable(RWBYItems.rwbyblock3.getDefaultState(), 16);
        impure_overworld = new WorldGenMinable(RWBYItems.rwbyblock4.getDefaultState(), 16);
        water_overworld = new WorldGenMinable(RWBYItems.rwbyblock5.getDefaultState(), 16);
        light_overworld = new WorldGenMinable(RWBYItems.rwbyblock6.getDefaultState(), 16);
        ice_overworld = new WorldGenMinable(RWBYItems.rwbyblock9.getDefaultState(), 16);
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
        int blockX = chunkX * 16;
        int blockZ = chunkZ * 16;
        switch(world.provider.getDimension()){
            case 0: //Overworld
                this.runGenerator(gravity_overworld, world, random, chunkX, chunkZ, RWBYConfig.gravityore, 0, 256); //BiomeHills.class, BiomeMesa.class, BiomeJungle.class
                this.runGenerator(fire_overworld, world, random, chunkX, chunkZ, RWBYConfig.fireore, 0, 256); //BiomeDesert.class, BiomeSavanna.class, BiomeMesa.class, BiomeSavannaMutated.class
                this.runGenerator(wind_overworld, world, random, chunkX, chunkZ, RWBYConfig.windore, 0, 256); //BiomeHills.class, BiomeMesa.class, BiomeJungle.class, BiomePlains.class
                this.runGenerator(impure_overworld, world, random, chunkX, chunkZ, RWBYConfig.impureore, 0, 256);
                this.runGenerator(water_overworld, world, random, chunkX, chunkZ, RWBYConfig.waterore, 0, 256); //BiomeOcean.class,BiomeBeach.class, BiomeMushroomIsland.class,BiomeSwamp.class
                this.runGenerator(light_overworld, world, random, chunkX, chunkZ, RWBYConfig.lightore, 0, 256);//BiomeHills.class,BiomeMesa.class
                this.runGenerator(ice_overworld, world, random, chunkX, chunkZ, RWBYConfig.iceore, 0, 256);
                generatestructure1(world, random, blockX + 8, blockZ + 8);
                generatestructure2(world, random, blockX + 8, blockZ + 8);
                generatestructure3(world, random, blockX + 8, blockZ + 8);
                generatestructure4(world, random, blockX + 8, blockZ + 8);
                generateraid(world, random, blockX + 8, blockZ + 8);
        }
    }

    private void generatestructure1(World world, Random rand, int blockX, int blockZ)
    {
        if (rand.nextInt(RWBYConfig.dustshop) == 0) {
	        int y = getGroundFromAbove(world, blockX, blockZ);
	        BlockPos pos = new BlockPos(blockX, y, blockZ);
	        WorldGenerator structure = new RWBYStructure().setStructure(":rwbym1").setYoffset(-2).spawnNearVillage(true);
	        structure.generate(world, rand, pos);
        }
    }

    private void generatestructure2(World world, Random rand, int blockX, int blockZ)
    {
        if (rand.nextInt(RWBYConfig.bar) == 0) {
            int y = getGroundFromAbove(world, blockX, blockZ);
            BlockPos pos = new BlockPos(blockX, y, blockZ);
            WorldGenerator structure2 = new RWBYStructure().setStructure(":rwbym2").setYoffset(-2).spawnNearVillage(true);
            structure2.generate(world, rand, pos);
        }
    }

    private void generatestructure4(World world, Random rand, int blockX, int blockZ)
    {
        if (rand.nextInt(RWBYConfig.dustshop2) == 0)
        {
            int y = getGroundFromAbove(world, blockX, blockZ);
            BlockPos pos = new BlockPos(blockX, y, blockZ);
            WorldGenerator structure4 = new RWBYStructure().setStructure(":rwbym4").setYoffset(-2).spawnNearVillage(true);
            structure4.generate(world, rand, pos);
        }
    }


    private void generateraid(World world, Random rand, int blockX, int blockZ)
    {
        if (rand.nextInt(RWBYConfig.darkcrystalrate) == 0)
        {
            int y = getGroundFromAbove(world, blockX, blockZ);
            BlockPos pos = new BlockPos(blockX, y, blockZ);
            WorldGenerator raid = new RaidStructure();
            raid.generate(world, rand, pos);
        }
    }

    private void generatestructure3(World world, Random rand, int blockX, int blockZ)
    {
        if (rand.nextInt(RWBYConfig.well) == 0)
        {
            int y = getGroundFromAbove(world, blockX, blockZ);
            BlockPos pos = new BlockPos(blockX, y, blockZ);
            WorldGenerator structure3 = new RWBYStructure().setStructure(":rwbym3").setYoffset(-9);
            structure3.generate(world, rand, pos);
        }
    }

    public static int getLakeFromAbove(World world, int x, int z)
    {
        int y = 255;
        boolean foundGround = false;
        while(!foundGround && y-- >= 31)
        {
            Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
            foundGround =  blockAt == Blocks.WATER||blockAt == Blocks.FLOWING_WATER;
        }

        return y;
    }

    public static boolean canSpawnHere(Template template, World world, BlockPos posAboveGround)
    {
        int zwidth = template.getSize().getZ();
        int xwidth = template.getSize().getX();

        // check all the corners to see which ones are replaceable
        boolean corner1 = isCornerValid(world, posAboveGround);
        boolean corner2 = isCornerValid(world, posAboveGround.add(xwidth, 0, zwidth));

        // if Y > 20 and all corners pass the test, it's okay to spawn the structure
        return posAboveGround.getY() > 31 && corner1 && corner2;
    }

    public static boolean isCornerValid(World world, BlockPos pos)
    {
        int variation = 3;
        int highestBlock = getGroundFromAbove(world, pos.getX(), pos.getZ());

        if (highestBlock > pos.getY() - variation && highestBlock < pos.getY() + variation)
            return true;

        return false;
    }

    public static int getGroundFromAbove(World world, int x, int z)
    {
        int y = 255;
        boolean foundGround = false;
        while(!foundGround && y-- >= 30)
        {
            Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
            foundGround =  blockAt == Blocks.GRASS || blockAt == Blocks.SAND;
        }

        return y;
    }
}


