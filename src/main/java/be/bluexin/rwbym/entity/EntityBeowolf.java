package be.bluexin.rwbym.entity;

import be.bluexin.rwbym.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityBeowolf extends EntityMob {
    World world = null;
    private EntityLiving owner;
    @Nullable

    public EntityBeowolf(World var1) {
        super(var1);
        world = var1;
        this.setSize(1.95F, 1.95F);
    }


    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(8, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, EntityVindicator.class));
        this.targetTasks.addTask(2, new EntityBeowolf.AICopyOwnerTarget(this));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3499999940395355D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(60.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }




    public void setOwner(EntityLiving ownerIn)
    {
        this.owner = ownerIn;
    }

    class AICopyOwnerTarget extends EntityAITarget
    {
        public AICopyOwnerTarget(EntityCreature creature)
        {
            super(creature, false);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return EntityBeowolf.this.owner != null && EntityBeowolf.this.owner.getAttackTarget() != null && this.isSuitableTarget(EntityBeowolf.this.owner.getAttackTarget(), false);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            EntityBeowolf.this.setAttackTarget(EntityBeowolf.this.owner.getAttackTarget());
            super.startExecuting();
        }
    }

    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ILLAGER;
    }

    protected ResourceLocation getLootTable() {
        return ModLootTables.BEOWOLF;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WITHER_SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound() {
        return SoundEvents.ENTITY_SQUID_DEATH;
    }

    @Override
    protected net.minecraft.util.SoundEvent getDeathSound() {
        return SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.wolf.death"));
    }

    @Override
    protected float getSoundVolume() {
        return 1.0F;
    }

}
