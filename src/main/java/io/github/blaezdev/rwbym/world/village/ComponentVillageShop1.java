package io.github.blaezdev.rwbym.world.village;

import io.github.blaezdev.rwbym.RWBYModels;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ComponentVillageShop1 extends StructureVillagePieces.Village {
    private static final ResourceLocation shop = new ResourceLocation("rwbym:rwbym2");

    public ComponentVillageShop1() {
    }

    public ComponentVillageShop1(StructureVillagePieces.Start start, int type, StructureBoundingBox boundingBox, EnumFacing facing) {
        super(start, type);
        this.boundingBox = boundingBox;
        setCoordBaseMode(facing);
    }

    @Override
    public boolean addComponentParts(World world, Random random, StructureBoundingBox boundingBox) {
        if (averageGroundLvl < 0) {
            averageGroundLvl = getAverageGroundLevel(world, boundingBox);
            if (averageGroundLvl < 0) {
                return true;
            }

            this.boundingBox.offset(20, averageGroundLvl - this.boundingBox.minY-2, 20);
        }
        BlockPos pos = new BlockPos(this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ);
        TemplateManager templateManager = world.getSaveHandler().getStructureTemplateManager();
        PlacementSettings settings = (new PlacementSettings()).setReplacedBlock(Blocks.STRUCTURE_VOID).setBoundingBox(boundingBox);
        Template template = templateManager.getTemplate(world.getMinecraftServer(), shop);
        template.addBlocksToWorldChunk(world, pos, settings);
        Map<BlockPos, String> dataBlocks = template.getDataBlocks(pos, settings);
        return true;
    }

    @Nullable
    public static StructureVillagePieces.Village buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List<StructureComponent> pieces, Random random, int x, int y, int z, EnumFacing facing, int type) {
        StructureBoundingBox boundingBox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 7, 6, 7, facing);
        if (canVillageGoDeeper(boundingBox) && findIntersecting(pieces, boundingBox) == null) {
            return new ComponentVillageShop1(startPiece, type, boundingBox, facing);
        }

        return null;
    }
}