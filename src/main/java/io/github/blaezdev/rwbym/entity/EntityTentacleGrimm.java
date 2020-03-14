package io.github.blaezdev.rwbym.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityTentacleGrimm extends EntityWaterMob implements IMob {

    private static final DataParameter<Boolean> MOVING = EntityDataManager.createKey(EntityTentacleGrimm.class,
            DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> TARGET_ENTITY = EntityDataManager
            .createKey(EntityTentacleGrimm.class, DataSerializers.VARINT);
    private EntityLivingBase targetedEntity;
    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;

    public EntityTentacleGrimm(World worldIn) {
        super(worldIn);
        this.setPathPriority(PathNodeType.WATER, 8.0F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        //FIXME entity attributes need to be added before they can be set
        //this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        //this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        //this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
    }

    @Override
    protected void initEntityAI() {
        //TODO AI Tasks
        //EntityAIMoveTowardsRestriction entityaimovetowardsrestriction = new EntityAIMoveTowardsRestriction(this, 1.0D);
        //this.wander = new EntityAIWander(this, 1.0D, 80);
        //this.tasks.addTask(4, new EntityAIAttackMelee(this, 1, true));
        //this.tasks.addTask(5, entityaimovetowardsrestriction);

        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        //this.targetTasks.addTask(10, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));

        //this.wander.setMutexBits(3);
        //entityaimovetowardsrestriction.setMutexBits(3);
        //this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, true));
    }

    @Override
    protected PathNavigate createNavigator(World worldIn) {
        return new PathNavigateSwimmer(this, worldIn);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(MOVING, Boolean.FALSE);
        this.dataManager.register(TARGET_ENTITY, 0);
    }

    public boolean isMoving() {
        return this.dataManager.get(MOVING);
    }

    private void setMoving(boolean moving) {
        this.dataManager.set(MOVING, moving);
    }

    public boolean hasTargetedEntity() {
        return this.dataManager.get(TARGET_ENTITY) != 0;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (inWater) {
            if (!this.world.isRemote) {
                this.motionX = this.randomMotionVecX * 1.0;
                this.motionY = this.randomMotionVecY * 1.0;
                this.motionZ = this.randomMotionVecZ * 1.0;
            }
        }
    }

    @Nullable
    public EntityLivingBase getTargetedEntity() {
        if (!this.hasTargetedEntity()) {
            return null;
        } else if (this.world.isRemote) {
            if (this.targetedEntity != null) {
                return this.targetedEntity;
            } else {
                Entity entity = this.world.getEntityByID(this.dataManager.get(TARGET_ENTITY));

                if (entity instanceof EntityLivingBase) {
                    this.targetedEntity = (EntityLivingBase) entity;
                    return this.targetedEntity;
                } else {
                    return null;
                }
            }
        } else {
            return this.getAttackTarget();
        }
    }

    private void setTargetedEntity(int entityId) {
        this.dataManager.set(TARGET_ENTITY, entityId);
    }

    @Override
    public void notifyDataManagerChange(DataParameter<?> key) {
        super.notifyDataManagerChange(key);

        if (TARGET_ENTITY.equals(key)) {

            this.targetedEntity = null;
        }
    }

   /* @SideOnly(Side.CLIENT)
    public int getBrightnessForRender() {
        return 15728880;
    }*/

    @Override
    public float getBrightness() {
        return 1.0F;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY > 100 && this.posY < this.world.getSeaLevel() && super.getCanSpawnHere();
    }

    public void setMovementVector(float randomMotionVecXIn, float randomMotionVecYIn, float randomMotionVecZIn) {
        this.randomMotionVecX = randomMotionVecXIn;
        this.randomMotionVecY = randomMotionVecYIn;
        this.randomMotionVecZ = randomMotionVecZIn;
    }

    public boolean hasMovementVector() {
        return this.randomMotionVecX != 0.0F || this.randomMotionVecY != 0.0F || this.randomMotionVecZ != 0.0F;
    }
}

