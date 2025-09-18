package io.github.blaezdev.rwbym.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class RWBYLantern extends BlockBase {

    public RWBYLantern(String name,
                       Material mat,
                       CreativeTabs tab,
                       float hardness,
                       float resistance,
                       String tool, int harvest) {
        super(name, mat, tab, hardness, resistance, tool, harvest);
        this.setLightLevel(1.0F);
    }

    @Override
    public Block setLightLevel(float value) {
        return super.setLightLevel(value);
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        this.setLightLevel(1.0f);
        super.onBlockClicked(worldIn, pos, playerIn);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        this.setLightLevel(1.0F);
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public boolean isFullCube(IBlockState p_isFullCube_1_) {
        return false;
    }
    @Override
    public boolean doesSideBlockRendering(IBlockState p_doesSideBlockRendering_1_, IBlockAccess p_doesSideBlockRendering_2_, BlockPos p_doesSideBlockRendering_3_, EnumFacing p_doesSideBlockRendering_4_) {
        return false;
    }
    @Override
    public boolean isTranslucent(IBlockState state)
    {
        return true;
    }



    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}