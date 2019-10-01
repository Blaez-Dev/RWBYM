package io.github.blaezdev.rwbym.blocks.fence;

import net.minecraft.block.BlockFence;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class RWBYBlockFence extends BlockFence {
	
	public static final IProperty<Boolean> TOP = PropertyBool.create("top");
	public static final IProperty<Boolean> ON = PropertyBool.create("on");
	public static final IProperty<Boolean> POST = PropertyBool.create("post");

	public RWBYBlockFence(Material blockMaterialIn, MapColor blockMapColorIn, float hardness, float resistence) {
		super(blockMaterialIn, blockMapColorIn);
		setHardness(hardness);
		setResistance(resistence);
		this.setDefaultState(this.getDefaultState().withProperty(TOP, false).withProperty(ON, false).withProperty(POST, true));
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{
		if(entityIn instanceof EntityMob){
		entityIn.attackEntityFrom(DamageSource.CACTUS, 5.0F);}
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, NORTH, EAST, WEST, SOUTH, TOP, ON, POST);
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && worldIn.getBlockState(pos.up()).getBlock().isReplaceable(worldIn, pos.up());
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		if (!state.getValue(TOP) && state.getValue(POST)) {
			worldIn.setBlockState(pos.up(), state.withProperty(TOP, true), 2);
			for (EnumFacing facing : EnumFacing.HORIZONTALS) {
				IBlockState state2 = worldIn.getBlockState(pos.offset(facing, 2));
				if (state2.getBlock() == this && state2.getValue(POST)) {
					if (worldIn.getBlockState(pos.offset(facing)).getBlock().isReplaceable(worldIn, pos.offset(facing)) || (worldIn.getBlockState(pos.offset(facing)).getBlock() == this && !worldIn.getBlockState(pos.offset(facing)).getValue(POST))) {
						worldIn.setBlockState(pos.offset(facing), this.getDefaultState().withProperty(POST, false).withProperty(TOP, false));
						worldIn.updateObservingBlocksAt(pos.offset(facing).up(), this);
					}
					if (worldIn.getBlockState(pos.offset(facing).up()).getBlock().isReplaceable(worldIn, pos.offset(facing).up()) || (worldIn.getBlockState(pos.offset(facing).up()).getBlock() == this && !worldIn.getBlockState(pos.offset(facing).up()).getValue(POST))) {
						worldIn.setBlockState(pos.offset(facing).up(), this.getDefaultState().withProperty(POST, false).withProperty(TOP, true));
						worldIn.updateObservingBlocksAt(pos.offset(facing).up(), this);
					}
				}
			}
		}
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return this.getDefaultState();
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		
		if (state.getValue(POST)) {
		
			EnumFacing facing = state.getValue(TOP) ? EnumFacing.DOWN : EnumFacing.UP;
			
			if (worldIn.getBlockState(pos.offset(facing)).getBlock() == this) {
				worldIn.setBlockToAir(pos.offset(facing));
			}
			
			for (EnumFacing facing2 : EnumFacing.HORIZONTALS) {
				if (worldIn.getBlockState(pos.offset(facing2)).getBlock() == this && (worldIn.getBlockState(pos.offset(facing2).offset(facing2.rotateY())).getBlock() != this || worldIn.getBlockState(pos.offset(facing2).offset(facing2.rotateYCCW())).getBlock() != this)) {
					if (!worldIn.getBlockState(pos.offset(facing2)).getValue(POST)) {
						worldIn.setBlockToAir(pos.offset(facing2));
					}
				}
				if (worldIn.getBlockState(pos.offset(facing2)).getBlock() == this) {
					worldIn.updateObservingBlocksAt(pos.offset(facing2), this);
				}
			}
			
		}
		
	}
	
	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		return blockState.getValue(POST) ? super.getBlockHardness(blockState, worldIn, pos) : -1F;
	}

	
	@Override
	public int getMetaFromState(IBlockState state) {
		
		int meta = 0;
		
		meta |= state.getValue(TOP) ? 0x1 : 0x0;
		meta |= state.getValue(ON) ? 0x2 : 0x0;
		meta |= state.getValue(POST) ? 0x4 : 0x0;
		
		return meta;
		
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
				
		boolean top = (meta & 0x1) == 0x1;
		boolean on = (meta & 0x2) == 0x2;
		boolean post = (meta & 0x4) == 0x4;
				
		return this.getDefaultState().withProperty(TOP, top).withProperty(ON, on).withProperty(POST, post);
		
	}
	
	@Override
    public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos, EnumFacing facing) {
		
		facing = facing.getOpposite();
		
		pos = pos.offset(facing.getOpposite());
		
		boolean flag = worldIn.getBlockState(pos).getBlock() == this && worldIn.getBlockState(pos).getValue(POST);
		
		boolean flag1 = worldIn.getBlockState(pos.offset(facing)).getBlock() == this && worldIn.getBlockState(pos.offset(facing)).getValue(POST);
		
		boolean flag2 = worldIn.getBlockState(pos.offset(facing, 2)).getBlock() == this && worldIn.getBlockState(pos.offset(facing, 2)).getValue(POST);
		
		boolean flag3 = worldIn.getBlockState(pos.offset(facing.getOpposite())).getBlock() == this && worldIn.getBlockState(pos.offset(facing.getOpposite())).getValue(POST);
		
		boolean flag4 = worldIn.getBlockState(pos.offset(facing)).getBlock() == this && !worldIn.getBlockState(pos.offset(facing)).getValue(POST);
		
        return flag ? (flag1 || (flag2 && flag4)) : (flag1 && flag3);
        
    }
	
	@Override
	public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing) {
		return false;
	}

}
