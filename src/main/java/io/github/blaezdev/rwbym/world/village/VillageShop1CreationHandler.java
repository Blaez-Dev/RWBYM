package io.github.blaezdev.rwbym.world.village;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

import static net.minecraft.world.gen.structure.StructureComponent.findIntersecting;

public class VillageShop1CreationHandler implements VillagerRegistry.IVillageCreationHandler {

    @Override
    public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int size) {
        if (random.nextFloat() > 1F) {
        return new StructureVillagePieces.PieceWeight(ComponentVillageShop1.class, 0, 0);}
        return new StructureVillagePieces.PieceWeight(ComponentVillageShop1.class, 3, 1);
    }

    @Override
    public Class<? extends StructureVillagePieces.Village> getComponentClass() {
        return ComponentVillageShop1.class;
    }

    @Override
    @Nullable
    public StructureVillagePieces.Village buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List<StructureComponent> pieces, Random random, int x, int y, int z, EnumFacing facing, int type) {
        return ComponentVillageShop1.buildComponent(villagePiece, startPiece, pieces, random, x, y, z, facing, type);
    }
}
