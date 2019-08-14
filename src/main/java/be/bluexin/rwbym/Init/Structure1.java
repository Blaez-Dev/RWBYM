package be.bluexin.rwbym.Init;

import be.bluexin.rwbym.ModLootTables;
import be.bluexin.rwbym.RWBYModels;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.world.storage.loot.LootTableList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Structure1 extends WorldGenerator {
	
	private static final List<Class<? extends Biome>> BIOMES = Arrays.asList(RWBYBiomes.GrimmWastes.getClass());

    @Override
    public boolean generate(World world, Random rand, BlockPos position) {
        WorldServer worldserver = (WorldServer) world;
        MinecraftServer minecraftserver = world.getMinecraftServer();
        TemplateManager templatemanager = worldserver.getStructureTemplateManager();
        Template template = templatemanager.getTemplate(minecraftserver, new ResourceLocation(RWBYModels.MODID+":rwbym1"));


        if(template == null)
        {
            System.out.println("NO STRUCTURE");
            return false;
        }
        
        Class<? extends Biome> biome = world.getBiome(position).getClass();

        if(Oregen.canSpawnHere(template, worldserver, position) && !BIOMES.contains(biome)) {
            IBlockState iblockstate = world.getBlockState(position);
            world.notifyBlockUpdate(position, iblockstate, iblockstate, 3);

            PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE)
                    .setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk((ChunkPos) null)
                    .setReplacedBlock((Block) null).setIgnoreStructureBlock(true);

            template.getDataBlocks(position, placementsettings);
            template.addBlocksToWorld(world, position.add(0, -2, 0), placementsettings);


            Map<BlockPos, String> map = template.getDataBlocks(position, placementsettings);

            return true;
        }

        return false;
    }

}
