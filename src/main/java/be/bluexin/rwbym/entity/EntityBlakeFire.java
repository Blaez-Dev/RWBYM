package be.bluexin.rwbym.entity;

import be.bluexin.rwbym.Init.RWBYItems;
import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

import javax.annotation.Nullable;

public class EntityBlakeFire extends EntityGolem {
    World world = null;
    private int counter;
    
    private Entity owner;
    
    @Nullable
    public EntityBlakeFire(World var1) {
        super(var1);
        world = var1;
        this.setSize(1.5F, 1.5F);
    }


    protected void initEntityAI() {
        super.initEntityAI();
        //this.tasks.addTask(0, new EntityAISwimming(this));
        //this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
        //this.tasks.addTask(8, new EntityAIWander(this, 0.6D));
        //this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
        //this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        //this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, EntityVindicator.class));
        //this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
        //this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLiving.class, 10, true, false, IMob.MOB_SELECTOR));
    }

    @Override
    public void onLivingUpdate() {
    	List<Entity> entitylist = world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().grow(20D));
    	for (Entity entity : entitylist) {
    		if (entity instanceof EntityMob) {
    			EntityMob mob = (EntityMob) entity;
    			mob.setAttackTarget(this);
    		}
    	}

        super.onLivingUpdate();
        counter += 1;
        if(counter >= 1200){
            this.setDead();
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3499999940395355D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(12.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        this.world.setEntityState(this, (byte)4);
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(15)));

        if (flag)
        {
            entityIn.motionY += 0.4000000059604645D;
            this.applyEnchantments(this, entityIn);
        }

        this.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_WEAK, 1.0F, 1.0F);
        return flag;
    }

    @Override
    public void onDeath(DamageSource cause) {
    	List<Entity> entitylist = world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().grow(20D));
    	for (Entity entity : entitylist) {
    		if (entity instanceof EntityMob) {
    			EntityMob mob = (EntityMob) entity;
    			Entity target = mob.getAttackTarget();
    			if (target == this) {
    				mob.setAttackTarget(null);
    			}
    		}
    	}
    	super.onDeath(cause);
        if (!this.world.isRemote)
        {
            boolean flag = false;
            this.dead = true;
            //this.world.createExplosion(this, this.posX, this.posY, this.posZ, 3, flag);
            this.Explode(20D, 3);
            this.setDead();
        }
    }
    
    private void Explode(Double damage, int radius) {
        float f3 = radius * 2.0F;
        int k1 = MathHelper.floor(this.posX - (double)f3 - 1.0D);
        int l1 = MathHelper.floor(this.posX + (double)f3 + 1.0D);
        int i2 = MathHelper.floor(this.posY - (double)f3 - 1.0D);
        int i1 = MathHelper.floor(this.posY + (double)f3 + 1.0D);
        int j2 = MathHelper.floor(this.posZ - (double)f3 - 1.0D);
        int j1 = MathHelper.floor(this.posZ + (double)f3 + 1.0D);
        List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this.owner, new AxisAlignedBB((double)k1, (double)i2, (double)j2, (double)l1, (double)i1, (double)j1));
        //net.minecraftforge.event.ForgeEventFactory.onExplosionDetonate(this.world, this, list, f3);
        Vec3d vec3d = new Vec3d(this.posX, this.posY, this.posZ);

        for (int k2 = 0; k2 < list.size(); ++k2)
        {
            Entity entity = list.get(k2);

            if (!entity.isImmuneToExplosions())
            {
                double d12 = entity.getDistance(this.posX, this.posY, this.posZ) / (double)f3;

                if (d12 <= 1.0D)
                {
                    double d5 = entity.posX - this.posX;
                    double d7 = entity.posY + (double)entity.getEyeHeight() - this.posY;
                    double d9 = entity.posZ - this.posZ;
                    double d13 = (double)MathHelper.sqrt(d5 * d5 + d7 * d7 + d9 * d9);

                    if (d13 != 0.0D)
                    {
                        d5 = d5 / d13;
                        d7 = d7 / d13;
                        d9 = d9 / d13;
                        double d14 = (double)this.world.getBlockDensity(vec3d, entity.getEntityBoundingBox());
                        double d10 = (1.0D - d12) * d14;
                        entity.attackEntityFrom(DamageSource.causeExplosionDamage(this), (float)((int)((d10 * d10 + d10) / 2.0D * 7.0D * (double)damage + 1.0D)));
                        double d11 = d10;

                        if (entity instanceof EntityLivingBase)
                        {
                            d11 = EnchantmentProtection.getBlastDamageReduction((EntityLivingBase)entity, d10);
                        }

                        entity.motionX += d5 * d11;
                        entity.motionY += d7 * d11;
                        entity.motionZ += d9 * d11;

                        if (entity instanceof EntityPlayer)
                        {
                            EntityPlayer entityplayer = (EntityPlayer)entity;

                            if (!entityplayer.isSpectator() && (!entityplayer.isCreative() || !entityplayer.capabilities.isFlying))
                            {
                                //this.playerKnockbackMap.put(entityplayer, new Vec3d(d5 * d10, d7 * d10, d9 * d10));
                            }
                        }
                    }
                }
            }
        }
        
        this.world.playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 4.0F, (1.0F + (this.world.rand.nextFloat() - this.world.rand.nextFloat()) * 0.2F) * 0.7F);

        if (radius >= 2.0F)
        {
            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
        }
        else
        {
            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
        }

        /*
        if (this.damagesTerrain)
        {
            for (BlockPos blockpos : this.affectedBlockPositions)
            {
                IBlockState iblockstate = this.world.getBlockState(blockpos);
                Block block = iblockstate.getBlock();

                if (spawnParticles)
                {
                    double d0 = (double)((float)blockpos.getX() + this.world.rand.nextFloat());
                    double d1 = (double)((float)blockpos.getY() + this.world.rand.nextFloat());
                    double d2 = (double)((float)blockpos.getZ() + this.world.rand.nextFloat());
                    double d3 = d0 - this.posX;
                    double d4 = d1 - this.posY;
                    double d5 = d2 - this.posZ;
                    double d6 = (double)MathHelper.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
                    d3 = d3 / d6;
                    d4 = d4 / d6;
                    d5 = d5 / d6;
                    double d7 = 0.5D / (d6 / radius + 0.1D);
                    d7 = d7 * (double)(this.world.rand.nextFloat() * this.world.rand.nextFloat() + 0.3F);
                    d3 = d3 * d7;
                    d4 = d4 * d7;
                    d5 = d5 * d7;
                    this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, (d0 + this.posX) / 2.0D, (d1 + this.posY) / 2.0D, (d2 + this.posZ) / 2.0D, d3, d4, d5);
                    this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, d3, d4, d5);
                }
            }
        }

        /*
        if (causesFire)
        {
            for (BlockPos blockpos1 : this.affectedBlockPositions)
            {
                if (this.world.getBlockState(blockpos1).getMaterial() == Material.AIR && this.world.getBlockState(blockpos1.down()).isFullBlock() && this.random.nextInt(3) == 0)
                {
                    this.world.setBlockState(blockpos1, Blocks.FIRE.getDefaultState());
                }
            }
        }
        //*/
        
        
    }

    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ILLAGER;
    }

    protected SoundEvent getAmbientSound() {
        return null;
    }

    protected SoundEvent getHurtSound() {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 1.0F;
    }


	public void setOwner(Entity entity) {
		this.owner = entity;
	}
}