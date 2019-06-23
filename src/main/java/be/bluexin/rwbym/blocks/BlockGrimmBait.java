package be.bluexin.rwbym.blocks;

import be.bluexin.rwbym.blocks.tileentities.TileEntityRWBYGrimmBait;
import be.bluexin.rwbym.entity.*;
import be.bluexin.rwbym.utility.RWBYConfig;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockGrimmBait extends BlockBase {
	
    public boolean activated;

    public BlockGrimmBait(String name,
                            Material mat,
                            CreativeTabs tab,
                            float hardness,
                            float resistance,
                            String tool, int harvest) {
        super(name, mat, tab, hardness, resistance, tool, harvest);
        this.setTickRandomly(true);
    }
    
    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
    	//((TileEntityRWBYGrimmBait)worldIn.getTileEntity(pos)).activate();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	((TileEntityRWBYGrimmBait)worldIn.getTileEntity(pos)).activate(playerIn);
        return true;
    }

    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if(((TileEntityRWBYGrimmBait)worldIn.getTileEntity(pos)).isActive())
        {
            double d3 = (double)pos.getX() + rand.nextDouble() * 0.10000000149011612D;
            double d8 = (double)pos.getY() + rand.nextDouble();
            double d13 = (double)pos.getZ() + rand.nextDouble();
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d3, d8, d13, 0.0D, 0.0D, 0.0D);
        }
    }

    
    @Override
    public boolean hasTileEntity(IBlockState state) {
    	return true;
    }
    
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
    	return new TileEntityRWBYGrimmBait();
    }

    @Override
    public int quantityDropped(Random par1Random)
    {
        return 0;
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
