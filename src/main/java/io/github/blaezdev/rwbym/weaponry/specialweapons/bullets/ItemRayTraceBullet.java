package io.github.blaezdev.rwbym.weaponry.specialweapons.bullets;

import java.util.List;
import java.util.function.Supplier;

import javax.annotation.Nullable;
import javax.vecmath.Matrix4f;
import javax.vecmath.Vector3f;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import io.github.blaezdev.rwbym.RWBYSoundHandler.Sound;
import io.github.blaezdev.rwbym.client.renderer.model.TransformationBuilder;
import io.github.blaezdev.rwbym.entity.EntityBullet;
import io.github.blaezdev.rwbym.weaponry.ArmourBase;
import io.github.blaezdev.rwbym.weaponry.RWBYAmmoItem;
import io.github.blaezdev.rwbym.weaponry.RWBYGun;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.model.TRSRTransformation;

public class ItemRayTraceBullet extends ItemBullet {
	
    private static final Predicate<Entity> ARROW_TARGETS = Predicates.and(EntitySelectors.NOT_SPECTATING, EntitySelectors.IS_ALIVE, new Predicate<Entity>()
    {
        public boolean apply(@Nullable Entity p_apply_1_)
        {
            return p_apply_1_.canBeCollidedWith();
        }
    });

	private final float distance;
	private final int damage;
	private final Supplier<SoundEvent> soundSupplier;
	
	public ItemRayTraceBullet(Supplier<Item> casing, float distance, int damage, Supplier<SoundEvent> soundSupplier) {
		super(casing);
		this.distance = distance;
		this.damage = damage;
		this.soundSupplier = soundSupplier;
	}

	@Override
	public void fire(World world, EntityPlayer player, float entityAccuracy, float gunAccuracy, int life) {
    	if (!world.isRemote) {
    		
    		Vec3d start = new Vec3d(player.posX, player.posY + player.eyeHeight, player.posZ);
    		Vec3d end = start.add(getRandomDirection(player, entityAccuracy, gunAccuracy));
    		
    		RayTraceResult raytraceresult = getRayTrace(start, end, player);

            if (raytraceresult != null) // && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult))
            {
                this.onHit(raytraceresult, player);
            }
    		
    		//world.spawnEntity(bullet);
            
            world.playSound(null, player.posX, player.posY, player.posZ, soundSupplier.get(), SoundCategory.PLAYERS, 1, 1);
            
            nextRandA = rand.nextDouble();
            nextRandB = rand.nextDouble();
            
    	}
	}
	
	private Vec3d getRandomDirection(EntityPlayer player, float entityAccuracy, float gunAccuracy) {
		double a = nextRandA * (gunAccuracy + entityAccuracy) / 360 * Math.PI;
		double b = nextRandB * Math.PI * 2;
		
		float z = (float) (distance * Math.cos(a));
		float y = (float) (distance * Math.sin(a) * Math.sin(b));
		float x = (float) (distance * Math.sin(a) * Math.cos(b));
		
		TransformationBuilder transform = new TransformationBuilder().add(null, new Vector3f(player.rotationPitch, player.rotationYaw, 0), null, null, 0);
		
		Matrix4f m1 = TRSRTransformation.blockCornerToCenter(transform.build()).getMatrix();
		Matrix4f m2 = new Matrix4f();
		m2.setColumn(0, x, y, z, 1);
		m1.mul(m2);
		float[] floats = new float[4];
		m1.getColumn(0, floats);
		
		return new Vec3d(floats[0], floats[1], floats[2]);
	}
	
	private RayTraceResult getRayTrace(Vec3d start, Vec3d end, EntityPlayer player) {
		RayTraceResult raytraceresult = player.world.rayTraceBlocks(start, end, false, true, false);
		
        if (raytraceresult != null)
        {
            end = new Vec3d(raytraceresult.hitVec.x, raytraceresult.hitVec.y, raytraceresult.hitVec.z);
        }

        Entity entity = this.findEntityOnPath(start, end, player);

        if (entity != null)
        {
            raytraceresult = new RayTraceResult(entity);
        }

        if (raytraceresult != null && raytraceresult.entityHit instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)raytraceresult.entityHit;

            if (player instanceof EntityPlayer && !((EntityPlayer)player).canAttackPlayer(entityplayer))
            {
                raytraceresult = null;
            }
        }
        
        return raytraceresult;
	}
	
    @Nullable
    protected Entity findEntityOnPath(Vec3d start, Vec3d end, EntityPlayer player)
    {
        Entity entity = null;
        List<Entity> list = player.world.getEntitiesInAABBexcluding(player, new AxisAlignedBB(start, end).grow(1.0D), ARROW_TARGETS);
        double d0 = 0.0D;

        for (int i = 0; i < list.size(); ++i)
        {
            Entity entity1 = list.get(i);

            if (entity1 != player)
            {
                AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().grow(0.3D);
                RayTraceResult raytraceresult = axisalignedbb.calculateIntercept(start, end);

                if (raytraceresult != null)
                {
                    double d1 = start.squareDistanceTo(raytraceresult.hitVec);

                    if (d1 < d0 || d0 == 0.0D)
                    {
                        entity = entity1;
                        d0 = d1;
                    }
                }
            }
        }

        return entity;
    }
	
    protected void onHit(RayTraceResult raytraceResultIn, EntityPlayer player) {

        Entity entity = raytraceResultIn.entityHit;

        //RWBYAmmoItem item = this.getItem();

        if (entity != null)
        {
            int i = damage;

            //if(this.getShootingItemStack().getItem() instanceof RWBYGun){
	        //    if((((RWBYGun) this.getShootingItemStack().getItem()).weapontype & RWBYGun.THROWN) !=0){
		    //        if(this.shootingEntity instanceof EntityPlayer){
		    //            EntityPlayer player = (EntityPlayer) this.shootingEntity;
		                if(EntityBullet.validperk(player, ArmourBase.JAVELIN2)){
		                    i = i*3;
		                }
		                else if(EntityBullet.validperk(player, ArmourBase.JAVELIN1)){
		                    i = i*2;
		                }
		    //        }
	        //    }
            //}

            //if(this.getShootingItemStack().getItem() instanceof RWBYAmmoItem){
            //    if(this.shootingEntity instanceof EntityPlayer){
            //        EntityPlayer player = (EntityPlayer) this.shootingEntity;
                    if(EntityBullet.validperk(player, ArmourBase.HandofBullets)){
                        i = i*2;
                    }
            //    }
            //}

            DamageSource damagesource;

//            if (this.shootingEntity == null)
//            {
//                damagesource = new EntityDamageSourceIndirect("rwby projectile", this, this).setProjectile();
//            }
//            else
//            {
                damagesource = new EntityDamageSource("rwby projectile", (Entity) player).setProjectile();
//            }

//            if (this.isBurning() && !(entity instanceof EntityEnderman))
//            {
//                entity.setFire(5);
//            }

            entity.hurtResistantTime = 0;

            if (entity.attackEntityFrom(damagesource, (float)i))
            {
                if (entity instanceof EntityLivingBase)
                {
                    EntityLivingBase entitylivingbase = (EntityLivingBase)entity;
                    
//                    if (this.shootingEntity instanceof EntityLivingBase) {
                    	((EntityLivingBase) player).setLastAttackedEntity(entitylivingbase);
//                    }

//                    if (this.knockbackStrength > 0)
//                    {
//                        float f1 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
//
//                        if (f1 > 0.0F)
//                        {
//                            entitylivingbase.addVelocity(this.motionX * (double)this.knockbackStrength * 0.6000000238418579D / (double)f1, 0.1D, this.motionZ * (double)this.knockbackStrength * 0.6000000238418579D / (double)f1);
//                        }
//                    }

//                    if (!(entitylivingbase instanceof EntityEnderman))
//                    {
//                        this.arrowHit(entitylivingbase);
//                    }

                    if (player != null && entitylivingbase != player && entitylivingbase instanceof EntityPlayer && player instanceof EntityPlayerMP)
                    {
                        ((EntityPlayerMP) player).connection.sendPacket(new SPacketChangeGameState(6, 0.0F));
                    }
                }

            }
//            else
//            {
//                this.motionX *= -0.10000000149011612D;
//                this.motionY *= -0.10000000149011612D;
//                this.motionZ *= -0.10000000149011612D;
//                this.rotationYaw += 180.0F;
//                this.prevRotationYaw += 180.0F;
//                this.ticksInAir = 0;
//
//                if (!this.world.isRemote && this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ < 0.0010000000474974513D)
//                {
//                    if (this.pickupStatus == EntityArrow.PickupStatus.ALLOWED)
//                    {
//                        this.entityDropItem(this.getArrowStack(), 0.1F);
//                    }
//
//                    this.setDead();
//                }
//            }
        }
//        else
//        {
//            BlockPos blockpos = raytraceResultIn.getBlockPos();
//            this.xTile = blockpos.getX();
//            this.yTile = blockpos.getY();
//            this.zTile = blockpos.getZ();
//            IBlockState iblockstate = this.world.getBlockState(blockpos);
//            this.inTile = iblockstate.getBlock();
//            this.inData = this.inTile.getMetaFromState(iblockstate);
//            this.motionX = (double)((float)(raytraceResultIn.hitVec.x - this.posX));
//            this.motionY = (double)((float)(raytraceResultIn.hitVec.y - this.posY));
//            this.motionZ = (double)((float)(raytraceResultIn.hitVec.z - this.posZ));
//            float f2 = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
//            this.posX -= this.motionX / (double)f2 * 0.05000000074505806D;
//            this.posY -= this.motionY / (double)f2 * 0.05000000074505806D;
//            this.posZ -= this.motionZ / (double)f2 * 0.05000000074505806D;
//            this.inGround = true;
//            this.arrowShake = 0;
//            this.setIsCritical(false);
//
//            if (iblockstate.getMaterial() != Material.AIR)
//            {
//                this.arrowHitBlock(this.world, blockpos, raytraceResultIn.sideHit);
//                this.inTile.onEntityCollidedWithBlock(this.world, blockpos, iblockstate, this);
//            }
//        }
    }

	@Override
	public Vec3d getPredictorLine(EntityPlayer player, float entityAccuracy, float gunAccuracy) {
		
		Vec3d start = new Vec3d(player.posX, player.posY + player.eyeHeight, player.posZ);
		Vec3d end = start.add(getRandomDirection(player, entityAccuracy, gunAccuracy));
		
		RayTraceResult raytraceresult = getRayTrace(start, end, player);
		
		if (raytraceresult == null) {
			return end;
		}
		
		return raytraceresult.hitVec;
	}
    
    

}
