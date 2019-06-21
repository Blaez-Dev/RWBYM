package be.bluexin.rwbym.blocks;

import be.bluexin.rwbym.entity.*;
import be.bluexin.rwbym.utility.RWBYConfig;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
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

    protected Random rand;
    public int posX;
    public int posY;
    public int posZ;
    public boolean activated;
    public int baitTimer;

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
    public int tickRate(World par1World)
    {
        return 10;
    }
    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        this.baitTimer = 0;
        worldIn.scheduleBlockUpdate(pos, this, 0, this.tickRate(worldIn));
        this.posX = pos.getX();
        this.posY = pos.getY();
        this.posZ = pos.getZ();
        this.activated = true;
        //super.onBlockClicked(worldIn, pos, playerIn);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        this.baitTimer = 0;
        worldIn.scheduleBlockUpdate(pos, this, 1, this.tickRate(worldIn));
        this.posX = pos.getX();
        this.posY = pos.getY();
        this.posZ = pos.getZ();
        this.activated = true;
        return true;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        ++this.baitTimer;
        if(baitTimer < 860){

            EntityApathy grimm1 = new EntityApathy(worldIn);
            EntityBeowolf grimm2 = new EntityBeowolf(worldIn);
            EntityBoarbatusk grimm3 = new EntityBoarbatusk(worldIn);
            EntityCreep grimm4 = new EntityCreep(worldIn);
            EntityGeist grimm5 = new EntityGeist(worldIn);
            EntityJuvenileDeathstalker grimm6 = new EntityJuvenileDeathstalker(worldIn);
            EntityLancer grimm7 = new EntityLancer(worldIn);
            EntityNeverMore grimm8 = new EntityNeverMore(worldIn);
            EntityUrsa grimm9 = new EntityUrsa(worldIn);

            EntityDeathStalker grimm10 = new EntityDeathStalker(worldIn);
            EntityGiantNeverMore grimm11 = new EntityGiantNeverMore(worldIn);
            EntityGoliath grimm12 = new EntityGoliath(worldIn);
            EntityMutantDeathStalker grimm13 = new EntityMutantDeathStalker(worldIn);
            EntityNuckleeve grimm14 = new EntityNuckleeve(worldIn);
            EntityQueenLancer grimm15 = new EntityQueenLancer(worldIn);

            grimm1.setLocationAndAngles((double)posX+rand.nextInt(100) - rand.nextInt(100), (double)posY+20, (double)posZ+rand.nextInt(100) - rand.nextInt(100), 0.0F, 0.0F);
            grimm2.setLocationAndAngles((double)posX+rand.nextInt(100) - rand.nextInt(100), (double)posY+20, (double)posZ+rand.nextInt(100) - rand.nextInt(100), 0.0F, 0.0F);
            grimm3.setLocationAndAngles((double)posX+rand.nextInt(100) - rand.nextInt(100), (double)posY+20, (double)posZ+rand.nextInt(100) - rand.nextInt(100), 0.0F, 0.0F);
            grimm4.setLocationAndAngles((double)posX+rand.nextInt(100) - rand.nextInt(100), (double)posY+20, (double)posZ+rand.nextInt(100) - rand.nextInt(100), 0.0F, 0.0F);
            grimm5.setLocationAndAngles((double)posX+rand.nextInt(100) - rand.nextInt(100), (double)posY+20, (double)posZ+rand.nextInt(100) - rand.nextInt(100), 0.0F, 0.0F);
            grimm6.setLocationAndAngles((double)posX+rand.nextInt(100) - rand.nextInt(100), (double)posY+20, (double)posZ+rand.nextInt(100) - rand.nextInt(100), 0.0F, 0.0F);
            grimm7.setLocationAndAngles((double)posX+rand.nextInt(100) - rand.nextInt(100), (double)posY+20, (double)posZ+rand.nextInt(100) - rand.nextInt(100), 0.0F, 0.0F);
            grimm8.setLocationAndAngles((double)posX+rand.nextInt(100) - rand.nextInt(100), (double)posY+20, (double)posZ+rand.nextInt(100) - rand.nextInt(100), 0.0F, 0.0F);
            grimm9.setLocationAndAngles((double)posX+rand.nextInt(100) - rand.nextInt(100), (double)posY+20, (double)posZ+rand.nextInt(100) - rand.nextInt(100), 0.0F, 0.0F);
            grimm10.setLocationAndAngles((double)posX+rand.nextInt(100) - rand.nextInt(100), (double)posY+20, (double)posZ+rand.nextInt(100) - rand.nextInt(100), 0.0F, 0.0F);
            grimm11.setLocationAndAngles((double)posX+rand.nextInt(100) - rand.nextInt(100), (double)posY+20, (double)posZ+rand.nextInt(100) - rand.nextInt(100), 0.0F, 0.0F);
            grimm12.setLocationAndAngles((double)posX+rand.nextInt(100) - rand.nextInt(100), (double)posY+20, (double)posZ+rand.nextInt(100) - rand.nextInt(100), 0.0F, 0.0F);
            grimm13.setLocationAndAngles((double)posX+rand.nextInt(100) - rand.nextInt(100), (double)posY+20, (double)posZ+rand.nextInt(100) - rand.nextInt(100), 0.0F, 0.0F);
            grimm14.setLocationAndAngles((double)posX+rand.nextInt(100) - rand.nextInt(100), (double)posY+20, (double)posZ+rand.nextInt(100) - rand.nextInt(100), 0.0F, 0.0F);
            grimm15.setLocationAndAngles((double)posX+rand.nextInt(100) - rand.nextInt(100), (double)posY+20, (double)posZ+rand.nextInt(100) - rand.nextInt(100), 0.0F, 0.0F);

            PotionEffect potioneffect = new PotionEffect(MobEffects.JUMP_BOOST, 120, 30, false, false);
            grimm1.addPotionEffect(potioneffect);
            grimm2.addPotionEffect(potioneffect);
            grimm3.addPotionEffect(potioneffect);
            grimm4.addPotionEffect(potioneffect);
            grimm5.addPotionEffect(potioneffect);
            grimm6.addPotionEffect(potioneffect);
            grimm7.addPotionEffect(potioneffect);
            grimm8.addPotionEffect(potioneffect);
            grimm9.addPotionEffect(potioneffect);
            grimm10.addPotionEffect(potioneffect);
            grimm11.addPotionEffect(potioneffect);
            grimm12.addPotionEffect(potioneffect);
            grimm13.addPotionEffect(potioneffect);
            grimm14.addPotionEffect(potioneffect);
            grimm15.addPotionEffect(potioneffect);

            int randomgrimm = rand.nextInt(RWBYConfig.grimmspawnrate);

            if(randomgrimm == 0){worldIn.spawnEntity(grimm1);}
            if(randomgrimm == 1){worldIn.spawnEntity(grimm2);}
            if(randomgrimm == 2){worldIn.spawnEntity(grimm3);}
            if(randomgrimm == 3){worldIn.spawnEntity(grimm4);}
            if(randomgrimm == 4){worldIn.spawnEntity(grimm5);}
            if(randomgrimm == 5){worldIn.spawnEntity(grimm6);}
            if(randomgrimm == 6){worldIn.spawnEntity(grimm7);}
            if(randomgrimm == 7){worldIn.spawnEntity(grimm8);}
            if(randomgrimm == 8){worldIn.spawnEntity(grimm9);}

            if(this.baitTimer >= 858){
                int randomboss = rand.nextInt(6);
                if(randomboss == 1){worldIn.spawnEntity(grimm10);}
                if(randomboss == 2){worldIn.spawnEntity(grimm11);}
                if(randomboss == 3){worldIn.spawnEntity(grimm12);}
                if(randomboss == 4){worldIn.spawnEntity(grimm13);}
                if(randomboss == 5){worldIn.spawnEntity(grimm14);}
                if(randomboss == 6){worldIn.spawnEntity(grimm15);}
            }
            worldIn.scheduleBlockUpdate(pos, this, 1, this.tickRate(worldIn));
        }

        if (this.baitTimer >= 860)
        {
            worldIn.setBlockToAir(pos);
            this.baitTimer = 0;
            this.activated = false;
        }
    }

    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if(this.activated)
        {
            double d3 = (double)pos.getX() + rand.nextDouble() * 0.10000000149011612D;
            double d8 = (double)pos.getY() + rand.nextDouble();
            double d13 = (double)pos.getZ() + rand.nextDouble();
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d3, d8, d13, 0.0D, 0.0D, 0.0D);
        }
    }


    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
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
