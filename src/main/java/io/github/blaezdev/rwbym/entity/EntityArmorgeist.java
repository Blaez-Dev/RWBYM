package io.github.blaezdev.rwbym.entity;

import io.github.blaezdev.rwbym.Init.RWBYItems;
import io.github.blaezdev.rwbym.ModLootTables;
import io.github.blaezdev.rwbym.RWBYEntities;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityArmorgeist extends EntityMob {
    World world = null;

    private static final DataParameter<Integer> INVULNERABILITY_TIME = EntityDataManager.<Integer>createKey(EntityWither.class, DataSerializers.VARINT);

    public EntityArmorgeist(World var3) {
        super(var3);
        world = var3;
        this.setSize(1.3F, 4.5F);
        this.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(RWBYItems.armasword));

    }

    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityArmorgeist.AIDoNothing());
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityAIAttackMeleeWithRange(this, 1.0D, false, 0.5F));
        this.tasks.addTask(8, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, EntityVindicator.class));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3499999940395355D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(RWBYConfig.attributes.aggrorange);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(400.0D*RWBYConfig.attributes.grimmhealthmult);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D*RWBYConfig.attributes.grimmattackmult);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20D);
    }

    protected boolean canDespawn() {
        return false;
    }

    protected ResourceLocation getLootTable() {
        return ModLootTables.Armagigas;
    }


    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(INVULNERABILITY_TIME, Integer.valueOf(0));
    }


    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("Invul", this.getInvulTime());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.setInvulTime(compound.getInteger("Invul"));
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        if (this.getInvulTime() > 0)
        {
            for (int i1 = 0; i1 < 3; ++i1)
            {
                this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, this.posX + this.rand.nextGaussian(), this.posY + (double)(this.rand.nextFloat() * 3.3F), this.posZ + this.rand.nextGaussian(), 0.699999988079071D, 0.699999988079071D, 0.8999999761581421D);
            }
        }
    }

    @Override
    protected void onDeathUpdate() {
        super.onDeathUpdate();
        if (!world.isRemote) {
        	this.world.spawnEntity(new EntityXPOrb(this.world, this.posX, this.posY + 0.5D, this.posZ, 1));
        }
    }

    protected void updateAITasks()
    {
        if (this.getInvulTime() > 0)
        {
            int j1 = this.getInvulTime() - 1;

            if (j1 <= 0)
            {
                this.world.playBroadcastSound(1023, new BlockPos(this), 0);
            }

            this.setInvulTime(j1);

        }
    }


    public void ignite()
    {
        this.setInvulTime(220);
    }

    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else if (source != DamageSource.DROWN && !(source.getTrueSource() instanceof EntityWither))
        {
            if (this.getInvulTime() > 0 && source != DamageSource.OUT_OF_WORLD)
            {
                return false;
            }
            else
            {

                Entity entity1 = source.getTrueSource();

                if (entity1 != null && !(entity1 instanceof EntityPlayer) && entity1 instanceof EntityLivingBase && ((EntityLivingBase)entity1).getCreatureAttribute() == this.getCreatureAttribute())
                {
                    return false;
                }
                else
                {

                    return super.attackEntityFrom(source, amount);
                }
            }
        }
        else
        {
            return false;
        }
    }


    public int getInvulTime()
    {
        return ((Integer)this.dataManager.get(INVULNERABILITY_TIME)).intValue();
    }

    public void setInvulTime(int time)
    {
        this.dataManager.set(INVULNERABILITY_TIME, Integer.valueOf(time));
    }

    public EnumCreatureAttribute getCreatureAttribute()
    {
        return RWBYEntities.grimm;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_IRONGOLEM_STEP;
    }

    protected SoundEvent getHurtSound() {
        return SoundEvents.ENTITY_IRONGOLEM_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_IRONGOLEM_DEATH;
    }
    @Override
    protected float getSoundVolume() {
        return 1.0F;
    }

    class AIDoNothing extends EntityAIBase
    {
        public AIDoNothing()
        {
            this.setMutexBits(7);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return EntityArmorgeist.this.getInvulTime() > 0;
        }
    }

}