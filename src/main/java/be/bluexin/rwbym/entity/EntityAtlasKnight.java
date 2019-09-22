package be.bluexin.rwbym.entity;

import be.bluexin.rwbym.utility.RWBYConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

 public class EntityAtlasKnight extends EntityGolem {
        World world = null;
        @Nullable
        public EntityAtlasKnight(World var1) {
            super(var1);
            world = var1;
            this.setSize(1.95F, 1.95F);
        }


        protected void initEntityAI() {
            super.initEntityAI();
            this.tasks.addTask(0, new EntityAISwimming(this));
            this.tasks.addTask(4, new EntityAIAttackMeleeWithRange(this, 1.0D, false, 0.5F));
            this.tasks.addTask(8, new EntityAIWander(this, 0.6D));
            this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
            this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
            this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, EntityVindicator.class));
            this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
            this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLiving.class, 10, true, false, IMob.MOB_SELECTOR));
        }

     protected boolean canDespawn() {
         return false;
     }

        @Override
        public void onLivingUpdate() {
            super.onLivingUpdate();
        }

        protected void applyEntityAttributes() {
            super.applyEntityAttributes();
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3499999940395355D);
            this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(12.0D);
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D*RWBYConfig.grimmhealthmult);
            this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20D);
        }

     public boolean attackEntityAsMob(Entity entityIn)
     {
         this.world.setEntityState(this, (byte)4);
         boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(15)* RWBYConfig.grimmattackmult));

         if (flag)
         {
             entityIn.motionY += 0.4000000059604645D;
             this.applyEnchantments(this, entityIn);
         }

         this.playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0F, 1.0F);
         return flag;
     }

        public EnumCreatureAttribute getCreatureAttribute() {
            return EnumCreatureAttribute.ILLAGER;
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
}
