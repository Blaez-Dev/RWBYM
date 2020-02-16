package io.github.blaezdev.rwbym.entity;

import io.github.blaezdev.rwbym.ModLootTables;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

public class EntityQueenLancer extends EntityGrimm
{
    protected static final DataParameter<Byte> DATA_SPELL_CASTING_ID = EntityDataManager.<Byte>createKey(EntityQueenLancer.class, DataSerializers.BYTE);
    private static final DataParameter<Boolean> ATTACKING = EntityDataManager.<Boolean>createKey(EntityQueenLancer.class, DataSerializers.BOOLEAN);
    private int spellCastingTickCount;
    private int spellCastId;
    private EntitySheep wololoTarget;
    protected static final DataParameter<Byte> VEX_FLAGS = EntityDataManager.<Byte>createKey(io.github.blaezdev.rwbym.entity.EntityQueenLancer.class, DataSerializers.BYTE);
    private EntityLiving owner;
    @Nullable
    private BlockPos boundOrigin;
    public io.github.blaezdev.rwbym.entity.EntityQueenLancer.AttackPhase attackPhase;
    public BlockPos circleCenter;
    public Vec3d targetPos;
    private EntityLookHelper lookHelper;


    public EntityQueenLancer(World worldIn)
    {
        super(worldIn);
        this.setSize(1.5F, 3F);
        this.experienceValue = 3;
        this.targetPos = Vec3d.ZERO;
        this.circleCenter = BlockPos.ORIGIN;
        this.attackPhase = io.github.blaezdev.rwbym.entity.EntityQueenLancer.AttackPhase.CIRCLE;
        this.moveHelper = new io.github.blaezdev.rwbym.entity.EntityQueenLancer.MoveHelper(this);
        this.lookHelper = new io.github.blaezdev.rwbym.entity.EntityQueenLancer.LookHelper(this);
    }

    class LookHelper extends EntityLookHelper {
        public LookHelper(EntityLiving p_i48802_2_) {
            super(p_i48802_2_);
        }

        public void tick() {
        }
    }



        @Override
        public boolean getCanSpawnHere()
        {
            return this.world.canSeeSky(new BlockPos(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ))&& this.world.isDaytime() == false&&this.world.getDifficulty() != EnumDifficulty.PEACEFUL||RWBYConfig.configmobspawnrates.lancernests;
        }

    /**
     * Tries to move the entity towards the specified location.
     */
    public void move(MoverType type, double x, double y, double z)
    {
        super.move(type, x, y, z);
        this.doBlockCollisions();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        //this.noClip = true;
        super.onUpdate();
        //this.noClip = false;
        this.setNoGravity(true);

    }

    protected boolean canDespawn() {
        return true;
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityQueenLancer.AISummonSpell());
        this.tasks.addTask(1, new io.github.blaezdev.rwbym.entity.EntityQueenLancer.AIPickAttack());
        this.tasks.addTask(2, new io.github.blaezdev.rwbym.entity.EntityQueenLancer.AISweepAttack());
        this.tasks.addTask(3, new io.github.blaezdev.rwbym.entity.EntityQueenLancer.AIOrbitPoint());
        this.targetTasks.addTask(1, new io.github.blaezdev.rwbym.entity.EntityQueenLancer.AIAttackPlayer());
        //this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] {EntityQueenLancer.class}));
        //this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        //this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
        //this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(400.0D* RWBYConfig.attributes.grimmhealthmult);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D*RWBYConfig.attributes.grimmattackmult);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5D);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(VEX_FLAGS, Byte.valueOf((byte)0));
    }

    public static void registerFixesVex(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, io.github.blaezdev.rwbym.entity.EntityQueenLancer.class);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);

        if (compound.hasKey("BoundX"))
        {
            this.boundOrigin = new BlockPos(compound.getInteger("BoundX"), compound.getInteger("BoundY"), compound.getInteger("BoundZ"));
        }

        if (compound.hasKey("AX")) {
            this.circleCenter = new BlockPos(compound.getInteger("AX"), compound.getInteger("AY"), compound.getInteger("AZ"));
        }

    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);

        if (this.boundOrigin != null)
        {
            compound.setInteger("BoundX", this.boundOrigin.getX());
            compound.setInteger("BoundY", this.boundOrigin.getY());
            compound.setInteger("BoundZ", this.boundOrigin.getZ());
        }
        compound.setInteger("AX", this.circleCenter.getX());
        compound.setInteger("AY", this.circleCenter.getY());
        compound.setInteger("AZ", this.circleCenter.getZ());
    }

    @Override
    public void onLivingUpdate() {
        this.fallDistance = 0;
        super.onLivingUpdate();
        if (this.world.isRemote) {
            float lvt_1_1_ = MathHelper.cos((float) (this.getEntityId() * 3 + this.ticksExisted) * 0.13F + 3.1415927F);
            float lvt_2_1_ = MathHelper.cos((float) (this.getEntityId() * 3 + this.ticksExisted + 1) * 0.13F + 3.1415927F);
            if (lvt_1_1_ > 0.0F && lvt_2_1_ <= 0.0F) {
            }
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        return super.attackEntityFrom(source, amount);
    }

    @Nullable
    public BlockPos getBoundOrigin()
    {
        return this.boundOrigin;
    }

    public void setBoundOrigin(@Nullable BlockPos boundOriginIn)
    {
        this.boundOrigin = boundOriginIn;
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

    protected ResourceLocation getLootTable() {
        return ModLootTables.Boss;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WITHER_SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound() {
        return SoundEvents.ENTITY_SQUID_DEATH;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ELDER_GUARDIAN_DEATH;
    }

    @Override
    protected void onDeathUpdate() {
        super.onDeathUpdate();
        if (!world.isRemote ) {
        	this.world.spawnEntity(new EntityXPOrb(this.world, this.posX, this.posY + 0.5D, this.posZ, 1));
        }

    }

    class AIAttackPlayer extends EntityAIBase {
        private int attackTime;

        private AIAttackPlayer() {
            this.attackTime = 10;
        }

        public boolean shouldExecute() {
            if (this.attackTime > 0) {
                --this.attackTime;
                return false;
            } else {
                this.attackTime = 20;
                AxisAlignedBB aabb = io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.getEntityBoundingBox().grow(16.0D, 64.0D, 16.0D);
                List<EntityPlayer> playerList = io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.world.getEntitiesWithinAABB(EntityPlayer.class, aabb);
                if (!playerList.isEmpty()) {
                    playerList.sort((player1, player2) -> {
                        return player1.posY > player2.posY ? -1 : 1;
                    });
                    Iterator var3 = playerList.iterator();

                    while(var3.hasNext()) {
                        EntityPlayer entityPlayer = (EntityPlayer)var3.next();
                        if (EntityAITarget.isSuitableTarget(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this, entityPlayer, false, false)) {
                            io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.setAttackTarget(entityPlayer);
                            return true;
                        }
                    }
                }

                return false;
            }
        }

        public boolean shouldContinueExecuting() {
            return EntityAITarget.isSuitableTarget(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this, io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.getAttackTarget(), false, false);
        }
    }

    class AIPickAttack extends EntityAIBase {
        private int phaseTime;

        private AIPickAttack() {
        }

        public boolean shouldExecute() {
            return EntityAITarget.isSuitableTarget(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this, io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.getAttackTarget(), false, false);
        }

        public void startExecuting() {
            this.phaseTime = 10;
            io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.attackPhase = io.github.blaezdev.rwbym.entity.EntityQueenLancer.AttackPhase.CIRCLE;
            this.setCircleCenter();
        }

        public void resetTask() {
            io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.circleCenter = io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.world.getHeight(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.circleCenter).up(10 + io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rand.nextInt(20));
        }

        @Override
        public void updateTask() {
            this.tick();
        }

        public void tick() {
            if (io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.attackPhase == io.github.blaezdev.rwbym.entity.EntityQueenLancer.AttackPhase.CIRCLE) {
                --this.phaseTime;
                if (this.phaseTime <= 0) {
                    io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.attackPhase = io.github.blaezdev.rwbym.entity.EntityQueenLancer.AttackPhase.SWOOP;
                    this.setCircleCenter();
                    this.phaseTime = (8 + io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rand.nextInt(4)) * 20;
                }
            }

        }

        private void setCircleCenter() {
            io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.circleCenter = (new BlockPos(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.getAttackTarget())).up(20 + io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rand.nextInt(20));
            if (io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.circleCenter.getY() < io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.world.getSeaLevel()) {
                io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.circleCenter = new BlockPos(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.circleCenter.getX(), io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.world.getSeaLevel() + 1, io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.circleCenter.getZ());
            }

        }
    }

    class AISweepAttack extends io.github.blaezdev.rwbym.entity.EntityQueenLancer.AIMove {
        private AISweepAttack() {
            super();
        }

        public boolean shouldExecute() {
            return io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.getAttackTarget() != null && io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.attackPhase == io.github.blaezdev.rwbym.entity.EntityQueenLancer.AttackPhase.SWOOP;
        }

        public boolean shouldContinueExecuting() {
            EntityLivingBase target = io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.getAttackTarget();
            if (target == null) {
                return false;
            } else if (target.isDead) {
                return false;
            } else {
                return !(target instanceof EntityPlayer) || !((EntityPlayer)target).isSpectator() && !((EntityPlayer)target).isCreative() ? this.shouldExecute() : false;
            }
        }

        public void startExecuting() {
        }

        public void resetTask() {
            io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.setAttackTarget((EntityLivingBase)null);
            io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.attackPhase = io.github.blaezdev.rwbym.entity.EntityQueenLancer.AttackPhase.CIRCLE;
        }

        @Override
        public void updateTask() {
            this.tick();
        }

        public void tick() {
            EntityLivingBase target = io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.getAttackTarget();
            io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.targetPos = new Vec3d(target.posX, target.posY + (double)target.height * 0.5D, target.posZ);
            if (io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.getEntityBoundingBox().grow(0.20000000298023224D).intersects(target.getEntityBoundingBox())) {
                io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.attackEntityAsMob(target);
                io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.attackPhase = io.github.blaezdev.rwbym.entity.EntityQueenLancer.AttackPhase.CIRCLE;
                io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.world.playEvent(1039, new BlockPos(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this), 0);
            } else if (io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.collided|| io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.hurtTime > 0) {
                io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.attackPhase = AttackPhase.SWOOP;
            }

        }
    }

    class AIOrbitPoint extends io.github.blaezdev.rwbym.entity.EntityQueenLancer.AIMove {
        private float angle;
        private float radius;
        private float yVel;
        private float direction;

        private AIOrbitPoint() {
            super();
        }

        public boolean shouldExecute() {
            return io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.getAttackTarget() == null || io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.attackPhase == io.github.blaezdev.rwbym.entity.EntityQueenLancer.AttackPhase.CIRCLE;
        }

        public void startExecuting() {
            this.radius = 5.0F + io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rand.nextFloat() * 10.0F;
            this.yVel = -4.0F + io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rand.nextFloat() * 9.0F;
            this.direction = io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rand.nextBoolean() ? 1.0F : -1.0F;
            this.setTargetPosition();
        }

        @Override
        public void updateTask() {
            this.tick();
        }

        public void tick() {
            if (io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rand.nextInt(350) == 0) {
                this.yVel = -4.0F + io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rand.nextFloat() * 9.0F;
            }

            if (io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rand.nextInt(250) == 0) {
                ++this.radius;
                if (this.radius > 15.0F) {
                    this.radius = 5.0F;
                    this.direction = -this.direction;
                }
            }

            if (io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rand.nextInt(450) == 0) {
                this.angle = io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rand.nextFloat() * 2.0F * 3.1415927F;
                this.setTargetPosition();
            }

            if (this.isClose()) {
                this.setTargetPosition();
            }

            if (io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.targetPos.y < io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.posY && !io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.world.isAirBlock((new BlockPos(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this)).down(1))) {
                this.yVel = Math.max(1.0F, this.yVel);
                this.setTargetPosition();
            }

            if (io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.targetPos.y > io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.posY && !io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.world.isAirBlock((new BlockPos(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this)).up(1))) {
                this.yVel = Math.min(-1.0F, this.yVel);
                this.setTargetPosition();
            }

        }

        private void setTargetPosition() {
            if (BlockPos.ORIGIN.equals(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.circleCenter)) {
                io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.circleCenter = new BlockPos(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this);
            }

            this.angle += this.direction * 15.0F * 0.017453292F;
            io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.targetPos = (new Vec3d(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.circleCenter)).addVector((double)(this.radius * MathHelper.cos(this.angle)), (double)(0F + this.yVel), (double)(this.radius * MathHelper.sin(this.angle)));
        }
    }

    abstract class AIMove extends EntityAIBase {
        public AIMove() {
            this.setMutexBits(1);
        }

        protected boolean isClose() {
            return io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.targetPos.squareDistanceTo(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.posX, io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.posY, io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.posZ) < 4.0D;
        }
    }


    class BodyHelper extends EntityBodyHelper {
        public BodyHelper(EntityLivingBase entitylivingbase) {
            super(entitylivingbase);
        }

        public void updateRenderAngles() {
            io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rotationYawHead = io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.renderYawOffset;
            io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.renderYawOffset = io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rotationYaw;
        }
    }

    class MoveHelper extends EntityMoveHelper {
        private float velocity = 0.1F;

        private float startingVelocity = 0.1F;

        private float maxStraitVelocity = 1.8F;

        private float maxTurningVelocity = 0.2F;

        private float straitAcceleration = 0.005F;

        private float turningAcceleration = 0.025F;

        private float angularVelocity = 4.0F;

        public MoveHelper(EntityLiving entityliving) {
            super(entityliving);
        }

        @Override
        public void onUpdateMoveHelper() {
            this.tick();
        }

        public void tick() {
            if (io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.collidedHorizontally) {
                io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rotationYaw += 180.0F;
                this.velocity = startingVelocity;
            }

            float dx = (float)(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.targetPos.x - io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.posX);
            float dy = (float)(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.targetPos.y - io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.posY);
            float dz = (float)(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.targetPos.z - io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.posZ);
            double groundDistance = (double)MathHelper.sqrt(dx * dx + dz * dz);
            double modifiedVerticalDistance = 1.0D - (double)MathHelper.abs(dy * 0.7F) / groundDistance;
            dx = (float)((double)dx * modifiedVerticalDistance);
            dz = (float)((double)dz * modifiedVerticalDistance);
            groundDistance = (double)MathHelper.sqrt(dx * dx + dz * dz);
            double distance = (double)MathHelper.sqrt(dx * dx + dz * dz + dy * dy);
            float oldRotationYaw = io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rotationYaw;
            float targetAngleRad = (float)MathHelper.atan2((double)dz, (double)dx);
            float f1 = wrapDegrees(io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rotationYaw + 90.0F);
            float targetAngleDeg = wrapDegrees(targetAngleRad * 57.295776F);
            io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rotationYaw = approachDegrees(f1, targetAngleDeg, angularVelocity) - 90.0F;
            io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.renderYawOffset = io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rotationYaw;
            if (degreesDifferenceAbs(oldRotationYaw, io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rotationYaw) < 3.0F) {
                this.velocity = approach(this.velocity, maxStraitVelocity, straitAcceleration * (maxStraitVelocity / this.velocity));
            } else {
                this.velocity = approach(this.velocity, maxTurningVelocity, turningAcceleration);
            }

            float pitch = (float)(-(MathHelper.atan2((double)(-dy), groundDistance) * 57.2957763671875D));
            io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rotationPitch = pitch;
            float approachYaw = io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.rotationYaw + 90.0F;
            double lvt_16_1_ = (double)(this.velocity * MathHelper.cos(approachYaw * 0.017453292F)) * abs((double)dx / distance);
            double lvt_18_1_ = (double)(this.velocity * MathHelper.sin(approachYaw * 0.017453292F)) * abs((double)dz / distance);
            double lvt_20_1_ = (double)(this.velocity * MathHelper.sin(pitch * 0.017453292F)) * abs((double)dy / distance);
            io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.motionX += (lvt_16_1_ - io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.motionX) * 0.2D;
            io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.motionY += (lvt_20_1_ - io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.motionY) * 0.2D;
            io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.motionZ += (lvt_18_1_ - io.github.blaezdev.rwbym.entity.EntityQueenLancer.this.motionZ) * 0.2D;
        }
    }

    public static float degreesDifferenceAbs(float angle1, float angle2) {
        float difference = wrapDegrees(angle1 - angle2);
        return difference < 180.0F ? abs(difference) : abs(difference - 360.0F);
    }

    public static float approach(float current, float target, float step) {
        step = abs(step);
        return current < target ? clamp(current + step, current, target) : clamp(current - step, target, current);
    }

    public static float approachDegrees(float currentAngle, float targetAngle, float step) {
        float f1 = wrapSubtractDegrees(targetAngle, currentAngle);
        return approach(currentAngle, currentAngle + f1, step);
    }

    public static float wrapSubtractDegrees(float p_203302_0_, float p_203302_1_) {
        float lvt_2_1_ = wrapDegrees(p_203302_0_ - p_203302_1_);
        return lvt_2_1_ < 180.0F ? lvt_2_1_ : lvt_2_1_ - 360.0F;
    }

    enum AttackPhase {
        CIRCLE,
        SWOOP;

        AttackPhase() {
        }
    }

    private static float wrapDegrees(float degrees) {
        return MathHelper.wrapDegrees(degrees);
    }

    private static float clamp(float val, float min, float max) {
        return MathHelper.clamp(val, min, max);
    }

    private static float abs(float val) {
        return Math.abs(val);
    }

    private static double abs(double val) {
        return Math.abs(val);
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
            return EntityQueenLancer.this.getSpellCastingTime() > 0;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            super.startExecuting();
            EntityQueenLancer.this.setIsCastingSpell(EntityQueenLancer.this.spellCastId);
            EntityQueenLancer.this.navigator.clearPath();
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask()
        {
            super.resetTask();
            EntityQueenLancer.this.setIsCastingSpell(0);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            if (EntityQueenLancer.this.getAttackTarget() != null)
            {
                EntityQueenLancer.this.getLookHelper().setLookPositionWithEntity(EntityQueenLancer.this.getAttackTarget(), (float)EntityQueenLancer.this.getHorizontalFaceSpeed(), (float)EntityQueenLancer.this.getVerticalFaceSpeed());
            }
            else if (EntityQueenLancer.this.getWololoTarget() != null)
            {
                EntityQueenLancer.this.getLookHelper().setLookPositionWithEntity(EntityQueenLancer.this.getWololoTarget(), (float)EntityQueenLancer.this.getHorizontalFaceSpeed(), (float)EntityQueenLancer.this.getVerticalFaceSpeed());
            }
        }
    }
    
    class AISummonSpell extends EntityQueenLancer.AIUseSpell
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
                int i = EntityQueenLancer.this.world.getEntitiesWithinAABB(EntityCreep.class, EntityQueenLancer.this.getEntityBoundingBox().grow(16.0D)).size();
                return EntityQueenLancer.this.rand.nextInt(8) + 1 > i;
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
            for (int i = 0; i < 6; ++i)
            {
                BlockPos blockpos = (new BlockPos(EntityQueenLancer.this)).add(-2 + EntityQueenLancer.this.rand.nextInt(5), 1, -2 + EntityQueenLancer.this.rand.nextInt(5));
                EntityLancer entitycreep = new EntityLancer(EntityQueenLancer.this.world);
                entitycreep.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
                entitycreep.onInitialSpawn(EntityQueenLancer.this.world.getDifficultyForLocation(blockpos), (IEntityLivingData)null);
                EntityQueenLancer.this.world.spawnEntity(entitycreep);
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
            return EntityQueenLancer.this.getAttackTarget() == null ? false : (EntityQueenLancer.this.isCastingSpell() ? false : EntityQueenLancer.this.ticksExisted >= this.nextCastTime);
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting()
        {
            return EntityQueenLancer.this.getAttackTarget() != null && this.spellWarmup > 0;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            this.spellWarmup = this.getCastWarmupTime();
            EntityQueenLancer.this.spellCastingTickCount = this.getCastingTime();
            this.nextCastTime = EntityQueenLancer.this.ticksExisted + this.getCastingInterval();
            EntityQueenLancer.this.playSound(this.getSpellPrepareSound(), 1.0F, 1.0F);
            EntityQueenLancer.this.spellCastId = this.getSpellId();
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
                EntityQueenLancer.this.playSound(SoundEvents.EVOCATION_ILLAGER_CAST_SPELL, 1.0F, 1.0F);
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