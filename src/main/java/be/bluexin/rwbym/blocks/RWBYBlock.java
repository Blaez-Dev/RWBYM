package be.bluexin.rwbym.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RWBYBlock extends BlockBase {
        public RWBYBlock(String name,
                         Material mat,
                         CreativeTabs tab,
                         float hardness,
                         float resistance,
                         String tool, int harvest) {
                super(name, mat, tab, hardness, resistance, tool, harvest);
                this.setTickRandomly(true);
        }



}