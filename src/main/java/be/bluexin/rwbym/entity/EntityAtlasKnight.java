package be.bluexin.rwbym.entity;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

 public class EntityAtlasKnight extends EntityMob {
        World world = null;
        private EntityLiving owner;
        private int counter;
        @Nullable

        public EntityAtlasKnight(World var1) {
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
            this.targetTasks.addTask(2, new EntityAtlasKnight.AICopyOwnerTarget(this));
            this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
            this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLiving.class, 10, false, true, new Predicate<EntityLiving>()
                    {
                        public boolean apply(@Nullable EntityLiving p_apply_1_)
                        {
                            return p_apply_1_ != null && IMob.VISIBLE_MOB_SELECTOR.apply(p_apply_1_) && !(p_apply_1_ instanceof EntityCreeper)&& !(p_apply_1_ instanceof EntityAtlasKnight) && !(p_apply_1_ instanceof EntityWinterBeowolf) && !(p_apply_1_ instanceof be.bluexin.rwbym.entity.EntityWinterUrsa) && !(p_apply_1_ instanceof EntityWinterBoarbatusk);
                        }
                    }
                    )

            );
        }

        @Override
        public void onLivingUpdate() {
            super.onLivingUpdate();
        }

        protected void applyEntityAttributes() {
            super.applyEntityAttributes();
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3499999940395355D);
            this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(12.0D);
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
                return EntityAtlasKnight.this.owner != null && EntityAtlasKnight.this.owner.getAttackTarget() != null && this.isSuitableTarget(EntityAtlasKnight.this.owner.getAttackTarget(), false);
            }

            /**
             * Execute a one shot task or start executing a continuous task
             */
            public void startExecuting()
            {
                EntityAtlasKnight.this.setAttackTarget(EntityAtlasKnight.this.owner.getAttackTarget());
                super.startExecuting();
            }
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
