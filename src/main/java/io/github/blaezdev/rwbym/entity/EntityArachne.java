package io.github.blaezdev.rwbym.entity;


import io.github.blaezdev.rwbym.ModLootTables;
import io.github.blaezdev.rwbym.RWBYEntities;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityArachne extends EntityGrimm {
    protected static final DataParameter<Byte> DATA_SPELL_CASTING_ID = EntityDataManager.<Byte>createKey(EntityArachne.class, DataSerializers.BYTE);
    private static final DataParameter<Boolean> ATTACKING = EntityDataManager.<Boolean>createKey(EntityArachne.class, DataSerializers.BOOLEAN);
    private int spellCastingTickCount;
    private int spellCastId;
    private EntitySheep wololoTarget;
    protected static final DataParameter<Byte> VEX_FLAGS = EntityDataManager.<Byte>createKey(io.github.blaezdev.rwbym.entity.EntityArachne.class, DataSerializers.BYTE);
    private EntityLiving owner;
    World world = null;

    public EntityArachne(World var3) {
        super(var3);
        world = var3;
        this.setSize(0.5F, 0.5F);
    }

    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(1, new EntityArachne.AISummonSpell());
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityAIAttackMeleeWithRange(this, 1.0D, false, 0.5F));
        this.tasks.addTask(8, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityZwei.class, 6.0F, 1.0D, 1.2D));
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityLivingBase.class, 6.0F, 1.0D, 1.2D ));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3499999940395355D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(RWBYConfig.attributes.aggrorange);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D*RWBYConfig.attributes.grimmhealthmult);
        //this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D*RWBYConfig.attributes.grimmattackmult);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(3D);
    }


    private boolean getVexFlag(int mask)
    {
        int i = ((Byte)this.dataManager.get(VEX_FLAGS)).byteValue();
        return (i & mask) != 0;
    }

    private void setVexFlag(int mask, boolean value)
    {
        int i = ((Byte)this.dataManager.get(VEX_FLAGS)).byteValue();

        if (value)
        {
            i = i | mask;
        }
        else
        {
            i = i & ~mask;
        }

        this.dataManager.set(VEX_FLAGS, Byte.valueOf((byte)(i & 255)));
    }

    public boolean isCharging()
    {
        return this.getVexFlag(1);
    }

    public void setCharging(boolean charging)
    {
        this.setVexFlag(1, charging);
    }
    
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return RWBYEntities.grimm;
    }

    protected ResourceLocation getLootTable() {
        return ModLootTables.Boarbatusk;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WITHER_SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound() {
        return SoundEvents.ENTITY_SPIDER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SPIDER_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 1.0F;
    }


    @Nullable
    private EntitySheep getWololoTarget()
    {
        return this.wololoTarget;
    }

    public boolean isCastingSpell()
    {
        return this.world.isRemote ? ((Byte)this.dataManager.get(DATA_SPELL_CASTING_ID)).byteValue() > 0 : this.spellCastingTickCount > 0;
    }

    public void setIsCastingSpell(int p_190753_1_)
    {
        this.dataManager.set(DATA_SPELL_CASTING_ID, Byte.valueOf((byte)p_190753_1_));
    }

    private int getSpellCastingTime()
    {
        return this.spellCastingTickCount;
    }

    protected void updateAITasks()
    {
        super.updateAITasks();

        if (this.spellCastingTickCount > 0)
        {
            --this.spellCastingTickCount;
        }
    }

    class AICastingSpell extends EntityAIBase
    {
        public AICastingSpell()
        {
            this.setMutexBits(3);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return EntityArachne.this.getSpellCastingTime() > 0;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            super.startExecuting();
            EntityArachne.this.setIsCastingSpell(EntityArachne.this.spellCastId);
            EntityArachne.this.navigator.clearPath();
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask()
        {
            super.resetTask();
            EntityArachne.this.setIsCastingSpell(0);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            if (EntityArachne.this.getAttackTarget() != null)
            {
                EntityArachne.this.getLookHelper().setLookPositionWithEntity(EntityArachne.this.getAttackTarget(), (float)EntityArachne.this.getHorizontalFaceSpeed(), (float)EntityArachne.this.getVerticalFaceSpeed());
            }
            else if (EntityArachne.this.getWololoTarget() != null)
            {
                EntityArachne.this.getLookHelper().setLookPositionWithEntity(EntityArachne.this.getWololoTarget(), (float)EntityArachne.this.getHorizontalFaceSpeed(), (float)EntityArachne.this.getVerticalFaceSpeed());
            }
        }
    }

    class AISummonSpell extends EntityArachne.AIUseSpell
    {
        private AISummonSpell()
        {
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            if (!super.shouldExecute())
            {
                return false;
            }
            else
            {
                int i = EntityArachne.this.world.getEntitiesWithinAABB(EntityCreep.class, EntityArachne.this.getEntityBoundingBox().grow(16.0D)).size();
                return EntityArachne.this.rand.nextInt(8) + 1 > i;
            }
        }

        protected int getCastingTime()
        {
            return 100;
        }

        protected int getCastingInterval()
        {
            return 340;
        }

        protected void castSpell()
        {
            for (int i = 0; i < 2; ++i)
            {
                BlockPos blockpos = (new BlockPos(EntityArachne.this)).add(-2 + EntityArachne.this.rand.nextInt(5), 1, -2 + EntityArachne.this.rand.nextInt(5));
                EntityArachneClone entitycreep = new EntityArachneClone(EntityArachne.this.world);
                entitycreep.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
                entitycreep.onInitialSpawn(EntityArachne.this.world.getDifficultyForLocation(blockpos), (IEntityLivingData)null);
                EntityArachne.this.world.spawnEntity(entitycreep);
            }
        }

        protected SoundEvent getSpellPrepareSound()
        {
            return SoundEvents.EVOCATION_ILLAGER_PREPARE_SUMMON;
        }

        protected int getSpellId()
        {
            return 1;
        }
    }

    abstract class AIUseSpell extends EntityAIBase
    {
        protected int spellWarmup;
        /** When the evoker is this many ticks old cast the next spell */
        protected int nextCastTime;

        private AIUseSpell()
        {
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return EntityArachne.this.getAttackTarget() == null ? false : (EntityArachne.this.isCastingSpell() ? false : EntityArachne.this.ticksExisted >= this.nextCastTime);
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting()
        {
            return EntityArachne.this.getAttackTarget() != null && this.spellWarmup > 0;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            this.spellWarmup = this.getCastWarmupTime();
            EntityArachne.this.spellCastingTickCount = this.getCastingTime();
            this.nextCastTime = EntityArachne.this.ticksExisted + this.getCastingInterval();
            EntityArachne.this.playSound(this.getSpellPrepareSound(), 1.0F, 1.0F);
            EntityArachne.this.spellCastId = this.getSpellId();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            --this.spellWarmup;

            if (this.spellWarmup == 0)
            {
                this.castSpell();
                EntityArachne.this.playSound(SoundEvents.EVOCATION_ILLAGER_CAST_SPELL, 1.0F, 1.0F);
            }
        }

        protected abstract void castSpell();

        protected int getCastWarmupTime()
        {
            return 20;
        }

        protected abstract int getCastingTime();

        protected abstract int getCastingInterval();

        protected abstract SoundEvent getSpellPrepareSound();

        protected abstract int getSpellId();
    }

}
