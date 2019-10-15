package io.github.blaezdev.rwbym.blocks.fluids;

import java.util.Random;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.blocks.tileentities.TileEntityRWBYGrimmBait;
import io.github.blaezdev.rwbym.entity.EntityApathy;
import io.github.blaezdev.rwbym.entity.EntityBeowolf;
import io.github.blaezdev.rwbym.entity.EntityBoarbatusk;
import io.github.blaezdev.rwbym.entity.EntityCreep;
import io.github.blaezdev.rwbym.entity.EntityDeathStalker;
import io.github.blaezdev.rwbym.entity.EntityGeist;
import io.github.blaezdev.rwbym.entity.EntityGiantNeverMore;
import io.github.blaezdev.rwbym.entity.EntityGoliath;
import io.github.blaezdev.rwbym.entity.EntityGrimm;
import io.github.blaezdev.rwbym.entity.EntityJuvenileDeathstalker;
import io.github.blaezdev.rwbym.entity.EntityLancer;
import io.github.blaezdev.rwbym.entity.EntityMutantDeathStalker;
import io.github.blaezdev.rwbym.entity.EntityNeverMore;
import io.github.blaezdev.rwbym.entity.EntityNuckleeve;
import io.github.blaezdev.rwbym.entity.EntityQueenLancer;
import io.github.blaezdev.rwbym.entity.EntityUrsa;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidGrimm extends BlockFluidClassic {

	public BlockFluidGrimm(Fluid fluid, Material material) {
		super(fluid, material);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if (entityIn instanceof EntityLivingBase && !(entityIn instanceof EntityGrimm)) {
			EntityLivingBase entityliving = (EntityLivingBase) entityIn;
			PotionEffect potioneffect = new PotionEffect(MobEffects.POISON, 60, 3, false, false);
			PotionEffect potioneffect1 = new PotionEffect(MobEffects.WITHER, 60, 2, false, false);
			entityliving.addPotionEffect(potioneffect);
			entityliving.addPotionEffect(potioneffect1);
		}
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(world, pos, state, rand);
		if (!world.isRemote && rand.nextInt(10000) == 0) {
			EntityMob grimm = getGrimm(rand.nextInt(16), world);
			grimm.setPositionAndRotation(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
			world.spawnEntity(grimm);
		}
		world.scheduleUpdate(pos, this, 1);
	}

	private EntityMob getGrimm(int i, World world) {
		switch(i) {
		case 1:
			return new EntityBoarbatusk(world);
		case 2:
			return new EntityBeowolf(world);
		case 3:
			return new EntityUrsa(world);
		case 4:
			return new EntityLancer(world);
		case 5:
			return new EntityGeist(world);
		case 6:
			return new EntityApathy(world);
		case 7:
			return new EntityCreep(world);
		case 8:
			return new EntityJuvenileDeathstalker(world);
		case 9:
			return new EntityNeverMore(world);
		case 10:
			return new EntityDeathStalker(world);
		case 11:
			return new EntityGiantNeverMore(world);
		case 12:
			return new EntityMutantDeathStalker(world);
		case 13:
			return new EntityQueenLancer(world);
		case 14:
			return new EntityNuckleeve(world);
		case 15:
			return new EntityGoliath(world);
		default:
			return null;
	}
	}
	
}
