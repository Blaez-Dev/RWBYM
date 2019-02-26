package be.bluexin.rwbym.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

class BlockBase extends Block {
    public BlockBase(String name, Material mat, CreativeTabs tab,
                     float hardness, float resistance, String tool, int harvest) {
        this(name, mat, tab, hardness, resistance);
        setHarvestLevel(tool, harvest);
    }
    public BlockBase (String name, Material mat,
                      CreativeTabs tab, float hardness, float resistance, float light) {
        this(name, mat, tab, hardness, resistance);
        setLightLevel(light);
    }

    public BlockBase(String name, Material mat, CreativeTabs tab, float hardness, float resistance) {
        super(mat);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setResistance(resistance);
        setCreativeTab(tab);
    }
}
