package io.github.blaezdev.rwbym.blocks;

import io.github.blaezdev.rwbym.Init.RWBYItems;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class RWBYBlock extends BlockBase {
        public RWBYBlock(String name, Material mat, CreativeTabs tab, float hardness, float resistance, String tool, int harvest) {
                super(name, mat, tab, hardness, resistance, tool, harvest);
                this.setTickRandomly(true);
        }

        public Item getItemDropped(IBlockState state, Random rand, int fortune)
        {
                if (this == RWBYItems.rwbyblock1)
                {
                        return RWBYItems.gravitydustrock;
                }
                else if (this == RWBYItems.rwbyblock2)
                {
                        return RWBYItems.firedustrock;
                }else if (this == RWBYItems.rwbyblock3)
                {
                        return RWBYItems.winddustrock;
                }else if (this == RWBYItems.rwbyblock4)
                {
                        return RWBYItems.dustrock;
                }else if (this == RWBYItems.rwbyblock5)
                {
                        return RWBYItems.waterdustrock;
                }else if (this == RWBYItems.rwbyblock6)
                {
                        return RWBYItems.lightdustrock;
                }else if (this == RWBYItems.rwbyblock9)
                {
                        return RWBYItems.icedustrock;
                }
                else
                {
                        return this == Blocks.QUARTZ_ORE ? Items.QUARTZ : Item.getItemFromBlock(this);
                }
        }

        public int quantityDropped(Random random)
        {
                return 4 + random.nextInt(5);
        }

        public int quantityDroppedWithBonus(int fortune, Random random)
        {
                if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
                {
                        int i = random.nextInt(fortune + 2) - 1;

                        if (i < 0)
                        {
                                i = 0;
                        }

                        return this.quantityDropped(random) * (i + 1);
                }
                else
                {
                        return this.quantityDropped(random);
                }
        }

        @Override
        public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
        {
                if (worldIn.isBlockPowered(pos))
                {
                        this.onBlockDestroyedByPlayer(worldIn, pos, state);
                        worldIn.setBlockToAir(pos);
                }
        }



        @Override
        public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state){
                if(RWBYConfig.worldgen.unsafemining){
                if(!worldIn.isRemote){
                if ((int) (Math.random() *  RWBYConfig.worldgen.dustoreeffect) == 0) { worldIn.createExplosion((Entity)null, pos.getX(), pos.getY(), pos.getZ(), 4.0F, true); }}}
        }


}