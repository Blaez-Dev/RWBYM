package be.bluexin.rwbym.entity;

import be.bluexin.rwbym.ModLootTables;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class EntityMutantDeathStalker extends EntityMob
{
    protected static final DataParameter<Byte> DATA_SPELL_CASTING_ID = EntityDataManager.<Byte>createKey(EntityMutantDeathStalker.class, DataSerializers.BYTE);
    private static final DataParameter<Boolean> ATTACKING = EntityDataManager.<Boolean>createKey(EntityMutantDeathStalker.class, DataSerializers.BOOLEAN);
    private int spellCastingTickCount;
    private int spellCastId;
    private EntitySheep wololoTarget;
    private int explosionStrength = 0;
    public int getFireballStrength() { return this.explosionStrength; }

    public EntityMutantDeathStalker(World worldIn)
    {
        super(worldIn);
        this.setSize(3.95F, 1.95F);
        this.experienceValue = 300;
    }

    protected void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityMutantDeathStalker.AICastingSpell());
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(3, new EntityMutantDeathStalker.AIFireballAttack(this));
        this.tasks.addTask(4, new EntityMutantDeathStalker.AISummonSpell());
        this.tasks.addTask(8, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] {EntityMutantDeathStalker.class}));
        this.targetTasks.addTask(2, (new EntityAINearestAttackableTarget(this, EntityPlayer.class, true)).setUnseenMemoryTicks(300));
        this.targetTasks.addTask(3, (new EntityAINearestAttackableTarget(this, EntityVillager.class, false)).setUnseenMemoryTicks(300));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, false));
    }



    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(DATA_SPELL_CASTING_ID, Byte.valueOf((byte)0));
        this.dataManager.register(ATTACKING, Boolean.valueOf(false));
    }

    @SideOnly(Side.CLIENT)
    public boolean isAttacking()
    {
        return ((Boolean)this.dataManager.get(ATTACKING)).booleanValue();
    }

    public void setAttacking(boolean attacking)
    {
        this.dataManager.set(ATTACKING, Boolean.valueOf(attacking));
    }


    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3499999940395355D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(60.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        if (super.attackEntityAsMob(entityIn))
        {
            if (entityIn instanceof EntityLivingBase)
            {
                int i = 0;

                if (this.world.getDifficulty() == EnumDifficulty.NORMAL)
                {
                    i = 7;
                }
                else if (this.world.getDifficulty() == EnumDifficulty.HARD)
                {
                    i = 15;
                }

                if (i > 0)
                {
                    ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.WITHER, i * 20, 1));
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.spellCastingTickCount = compound.getInteger("SpellTicks");
        if (compound.hasKey("ExplosionPower", 99))
        {
            this.explosionStrength = compound.getInteger("ExplosionPower");
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("SpellTicks", this.spellCastingTickCount);
        compound.setInteger("ExplosionPower", this.explosionStrength);
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.ILLAGER;
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

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        if (this.world.isRemote && this.isCastingSpell())
        {
            int i = ((Byte)this.dataManager.get(DATA_SPELL_CASTING_ID)).byteValue();
            double d0 = 0.7D;
            double d1 = 0.5D;
            double d2 = 0.2D;

            if (i == 2)
            {
                d0 = 0.4D;
                d1 = 0.3D;
                d2 = 0.35D;
            }
            else if (i == 1)
            {
                d0 = 0.7D;
                d1 = 0.7D;
                d2 = 0.8D;
            }

            float f = this.renderYawOffset * 0.017453292F + MathHelper.cos((float)this.ticksExisted * 0.6662F) * 0.25F;
            float f1 = MathHelper.cos(f);
            float f2 = MathHelper.sin(f);
            this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, this.posX + (double)f1 * 0.6D, this.posY + 1.8D, this.posZ + (double)f2 * 0.6D, d0, d1, d2, new int[0]);
            this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, this.posX - (double)f1 * 0.6D, this.posY + 1.8D, this.posZ - (double)f2 * 0.6D, d0, d1, d2, new int[0]);
        }
    }


    protected ResourceLocation getLootTable() {
        return ModLootTables.Boss;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WITHER_SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound() {
        return SoundEvents.ENTITY_SQUID_DEATH;
    }

    protected net.minecraft.util.SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ELDER_GUARDIAN_DEATH;
    }
    private void setWololoTarget(@Nullable EntitySheep p_190748_1_)
    {
        this.wololoTarget = p_190748_1_;
    }

    @Nullable
    private EntitySheep getWololoTarget()
    {
        return this.wololoTarget;
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
            return EntityMutantDeathStalker.this.getSpellCastingTime() > 0;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            super.startExecuting();
            EntityMutantDeathStalker.this.setIsCastingSpell(EntityMutantDeathStalker.this.spellCastId);
            EntityMutantDeathStalker.this.navigator.clearPath();
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask()
        {
            super.resetTask();
            EntityMutantDeathStalker.this.setIsCastingSpell(0);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            if (EntityMutantDeathStalker.this.getAttackTarget() != null)
            {
                EntityMutantDeathStalker.this.getLookHelper().setLookPositionWithEntity(EntityMutantDeathStalker.this.getAttackTarget(), (float)EntityMutantDeathStalker.this.getHorizontalFaceSpeed(), (float)EntityMutantDeathStalker.this.getVerticalFaceSpeed());
            }
            else if (EntityMutantDeathStalker.this.getWololoTarget() != null)
            {
                EntityMutantDeathStalker.this.getLookHelper().setLookPositionWithEntity(EntityMutantDeathStalker.this.getWololoTarget(), (float)EntityMutantDeathStalker.this.getHorizontalFaceSpeed(), (float)EntityMutantDeathStalker.this.getVerticalFaceSpeed());
            }
        }
    }

    class AISummonSpell extends EntityMutantDeathStalker.AIUseSpell
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
                int i = EntityMutantDeathStalker.this.world.getEntitiesWithinAABB(EntityCreep.class, EntityMutantDeathStalker.this.getEntityBoundingBox().grow(16.0D)).size();
                return EntityMutantDeathStalker.this.rand.nextInt(8) + 1 > i;
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
            for (int i = 0; i < 3; ++i)
            {
                BlockPos blockpos = (new BlockPos(EntityMutantDeathStalker.this)).add(-2 + EntityMutantDeathStalker.this.rand.nextInt(5), 1, -2 + EntityMutantDeathStalker.this.rand.nextInt(5));
                EntityCreep entitycreep = new EntityCreep(EntityMutantDeathStalker.this.world);
                entitycreep.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
                entitycreep.onInitialSpawn(EntityMutantDeathStalker.this.world.getDifficultyForLocation(blockpos), (IEntityLivingData)null);
                entitycreep.setOwner(EntityMutantDeathStalker.this);
                EntityMutantDeathStalker.this.world.spawnEntity(entitycreep);
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
            return EntityMutantDeathStalker.this.getAttackTarget() == null ? false : (EntityMutantDeathStalker.this.isCastingSpell() ? false : EntityMutantDeathStalker.this.ticksExisted >= this.nextCastTime);
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting()
        {
            return EntityMutantDeathStalker.this.getAttackTarget() != null && this.spellWarmup > 0;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            this.spellWarmup = this.getCastWarmupTime();
            EntityMutantDeathStalker.this.spellCastingTickCount = this.getCastingTime();
            this.nextCastTime = EntityMutantDeathStalker.this.ticksExisted + this.getCastingInterval();
            EntityMutantDeathStalker.this.playSound(this.getSpellPrepareSound(), 1.0F, 1.0F);
            EntityMutantDeathStalker.this.spellCastId = this.getSpellId();
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
                EntityMutantDeathStalker.this.playSound(SoundEvents.EVOCATION_ILLAGER_CAST_SPELL, 1.0F, 1.0F);
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

    static class AIFireballAttack extends EntityAIBase
    {
        private final EntityMutantDeathStalker parentEntity;
        public int attackTimer;

        public AIFireballAttack(EntityMutantDeathStalker mutantdeathstalker)
        {
            this.parentEntity = mutantdeathstalker;
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return this.parentEntity.getAttackTarget() != null;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            this.attackTimer = 0;
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask()
        {
            this.parentEntity.setAttacking(false);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();
            
            if (entitylivingbase == null) {
            	resetTask();
            	return;
            }
            
            double d0 = 64.0D;

            if (entitylivingbase.getDistance(this.parentEntity) < 4096.0D && this.parentEntity.canEntityBeSeen(entitylivingbase))
            {
                World world = this.parentEntity.world;
                ++this.attackTimer;


                if (this.attackTimer == 20)
                {
                    double d1 = 4.0D;
                    Vec3d vec3d = this.parentEntity.getLook(1.0F);
                    double d2 = entitylivingbase.posX - (this.parentEntity.posX + vec3d.x * 4.0D);
                    double d3 = entitylivingbase.getEntityBoundingBox().minY + (double)(entitylivingbase.height / 2.0F) - (0.5D + this.parentEntity.posY + (double)(this.parentEntity.height / 2.0F));
                    double d4 = entitylivingbase.posZ - (this.parentEntity.posZ + vec3d.z * 4.0D);
                    world.playEvent((EntityPlayer)null, 1016, new BlockPos(this.parentEntity), 0);
                   EntityLargeFireball entitylargefireball = new EntityLargeFireball(world, this.parentEntity, d2, d3, d4);
                    entitylargefireball.explosionPower = this.parentEntity.getFireballStrength();
                    entitylargefireball.posX = this.parentEntity.posX + vec3d.x * 4.0D;
                    entitylargefireball.posY = this.parentEntity.posY + (double)(this.parentEntity.height / 2.0F) + 0.5D;
                    entitylargefireball.posZ = this.parentEntity.posZ + vec3d.z * 4.0D;
                    world.spawnEntity(entitylargefireball);
                    this.attackTimer = -40;
                }
            }
            else if (this.attackTimer > 0)
            {
                --this.attackTimer;
            }

            this.parentEntity.setAttacking(this.attackTimer > 10);
        }
    }

}