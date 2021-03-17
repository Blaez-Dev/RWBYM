package io.github.blaezdev.rwbym.entity;

import io.github.blaezdev.rwbym.Init.RWBYItems;
import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.capabilities.Aura.AuraProvider;
import io.github.blaezdev.rwbym.capabilities.CapabilityHandler;
import io.github.blaezdev.rwbym.capabilities.ISemblance;
import io.github.blaezdev.rwbym.capabilities.Pyrrha.IPyrrha;
import io.github.blaezdev.rwbym.utility.network.MessagePosVelUpdate;
import io.github.blaezdev.rwbym.utility.network.RWBYNetworkHandler;
import io.github.blaezdev.rwbym.weaponry.ArmourBase;
import io.github.blaezdev.rwbym.weaponry.RWBYAmmoItem;
import io.github.blaezdev.rwbym.weaponry.RWBYGun;
import io.github.blaezdev.rwbym.weaponry.RWBYHood;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEndGateway;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IThrowableEntity;

public class EntityBullet extends EntityArrow implements IThrowableEntity{

    public static boolean validperk(EntityLivingBase playerIn,long armorperk){
        for (ItemStack stack:playerIn.getArmorInventoryList()){
            if(stack.getItem() instanceof ArmourBase){
                if((((ArmourBase) stack.getItem()).armourperks & armorperk) !=0){
                    //System.out.println("armor works");
                    return true;
                }}
            if(stack.getItem() instanceof RWBYHood){
                if((((RWBYHood) stack.getItem()).armourperks & armorperk) !=0) {
                    //System.out.println("hood works");
                    return true;
                }}
        }
        return false;
    }

    private static final DataParameter<ItemStack> ITEM = EntityDataManager.createKey(EntityBullet.class, DataSerializers.ITEM_STACK);
    private static final DataParameter<ItemStack> SHOOTING_STACK = EntityDataManager.createKey(EntityBullet.class, DataSerializers.ITEM_STACK);
    private static final DataParameter<Integer> PARTICLE = EntityDataManager.createKey(EntityBullet.class, DataSerializers.VARINT);

    private int knockbackStrength;
    private int teleport;
    private int ticksInAir;
    private int xTile;
    private int yTile;
    private int zTile;
    private Block inTile;
    private int inData;
    private short ticksInGround;
    private EntityLivingBase shooter;

    public EntityBullet(World worldIn)
    {
        super(worldIn);
        this.setIsCritical(true);
    }

    public EntityBullet(World worldIn, double x, double y, double z)
    {
        this(worldIn);
        this.setPosition(x, y, z);
    }

    public EntityBullet(World worldIn, EntityLivingBase shooter)
    {
        this(worldIn, shooter.posX, shooter.posY + (double)shooter.getEyeHeight() - 0.1D, shooter.posZ);
        this.shootingEntity = shooter;
        this.shooter = shooter;

        if (shooter instanceof EntityPlayer)
        {
            this.pickupStatus = PickupStatus.CREATIVE_ONLY;
        }
    }

    public EntityBullet(World worldIn, EntityLivingBase shooter, ItemStack stack, ItemStack shootingStack) {
        this(worldIn, shooter);
        if(shootingStack.getItem() == RWBYItems.flyingthundergod){teleport = 1;}
        if(shootingStack.getItem() instanceof RWBYGun && (((RWBYGun) shootingStack.getItem()).weapontype & RWBYGun.THROWN) != 0) {
    		this.setShootingItemStack(shootingStack.copy());
    	}
        else {
            ItemStack iss = new ItemStack(stack.getItem());
        	this.setShootingItemStack(iss);
        }
        this.setItem(stack);
        RWBYAmmoItem from = this.getItem();
        if (shooter instanceof EntityPlayer && from.canPickup()) {
            this.pickupStatus = PickupStatus.ALLOWED;
        }
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        dataManager.register(ITEM, ItemStack.EMPTY);
        dataManager.register(SHOOTING_STACK, ItemStack.EMPTY);
        dataManager.register(PARTICLE, EnumParticleTypes.CRIT.ordinal());
    }

    public ResourceLocation getTexture() {
        RWBYAmmoItem item = getItem();
        return item == null ? null : new ResourceLocation(RWBYModels.MODID, item.getTexture());
    }

    public ItemStack getStackForRender() {
        return this.getItem().getRenderStack();
    }
    
    public void doRender(EntityBullet entity, double x, double y, double z, float entityYaw, float partialTicks) {
    	this.getItem().doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    public EnumParticleTypes getParticle() {
    	return EnumParticleTypes.getParticleFromId(dataManager.get(PARTICLE));
    }
    
    public void setParticle(EnumParticleTypes type) {
    	dataManager.set(PARTICLE, type.ordinal());
    }



    @Override
    protected void onHit(RayTraceResult raytraceResultIn) {

        Entity entity = raytraceResultIn.entityHit;

        RWBYAmmoItem item = this.getItem();

        if (entity != null)
        {
            int i = (int) item.getBaseDamage();

            if(this.getShootingItemStack().getItem() instanceof RWBYGun){
	            if((((RWBYGun) this.getShootingItemStack().getItem()).weapontype & RWBYGun.THROWN) !=0){
		            if(this.shootingEntity instanceof EntityPlayer){
		                EntityPlayer player = (EntityPlayer) this.shootingEntity;
		                if(this.validperk(player, ArmourBase.JAVELIN2)){
		                    i = i*3;
		                }
		                else if(this.validperk(player, ArmourBase.JAVELIN1)){
		                    i = i*2;
		                }
		            }
	            }
            }

            if(this.getShootingItemStack().getItem() instanceof RWBYAmmoItem){
                if(this.shootingEntity instanceof EntityPlayer){
                    EntityPlayer player = (EntityPlayer) this.shootingEntity;
                    if(this.validperk(player, ArmourBase.HandofBullets)){
                        i = i*2;
                    }
                }
            }

            DamageSource damagesource;

            if (this.shootingEntity == null)
            {
                damagesource = new EntityDamageSourceIndirect("rwby projectile", this, this).setProjectile();
            }
            else
            {
                damagesource = new EntityDamageSourceIndirect("rwby projectile", this, this.shootingEntity).setProjectile();
            }

            if (this.isBurning() && !(entity instanceof EntityEnderman))
            {
                entity.setFire(5);
            }

            entity.hurtResistantTime = 0;

            if (entity.attackEntityFrom(damagesource, (float)i))
            {
                if (entity instanceof EntityLivingBase)
                {
                    EntityLivingBase entitylivingbase = (EntityLivingBase)entity;
                    
                    if (this.shootingEntity instanceof EntityLivingBase) {
                    	((EntityLivingBase)this.shootingEntity).setLastAttackedEntity(entitylivingbase);
                    }

                    if (this.knockbackStrength > 0)
                    {
                        float f1 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

                        if (f1 > 0.0F)
                        {
                            entitylivingbase.addVelocity(this.motionX * (double)this.knockbackStrength * 0.6000000238418579D / (double)f1, 0.1D, this.motionZ * (double)this.knockbackStrength * 0.6000000238418579D / (double)f1);
                        }
                    }

                    if (!(entitylivingbase instanceof EntityEnderman))
                    {
                        this.arrowHit(entitylivingbase);
                    }

                    if (this.shootingEntity != null && entitylivingbase != this.shootingEntity && entitylivingbase instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP)
                    {
                        ((EntityPlayerMP)this.shootingEntity).connection.sendPacket(new SPacketChangeGameState(6, 0.0F));
                    }
                }

            }
            else
            {
                this.motionX *= -0.10000000149011612D;
                this.motionY *= -0.10000000149011612D;
                this.motionZ *= -0.10000000149011612D;
                this.rotationYaw += 180.0F;
                this.prevRotationYaw += 180.0F;
                this.ticksInAir = 0;

                if (!this.world.isRemote && this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ < 0.0010000000474974513D)
                {
                    if (this.pickupStatus == EntityArrow.PickupStatus.ALLOWED)
                    {
                        this.entityDropItem(this.getArrowStack(), 0.1F);
                    }

                    this.setDead();
                }
            }
        }
        else
        {
            BlockPos blockpos = raytraceResultIn.getBlockPos();
            this.xTile = blockpos.getX();
            this.yTile = blockpos.getY();
            this.zTile = blockpos.getZ();
            IBlockState iblockstate = this.world.getBlockState(blockpos);
            this.inTile = iblockstate.getBlock();
            this.inData = this.inTile.getMetaFromState(iblockstate);
            this.motionX = (double)((float)(raytraceResultIn.hitVec.x - this.posX));
            this.motionY = (double)((float)(raytraceResultIn.hitVec.y - this.posY));
            this.motionZ = (double)((float)(raytraceResultIn.hitVec.z - this.posZ));
            float f2 = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
            this.posX -= this.motionX / (double)f2 * 0.05000000074505806D;
            this.posY -= this.motionY / (double)f2 * 0.05000000074505806D;
            this.posZ -= this.motionZ / (double)f2 * 0.05000000074505806D;
            this.inGround = true;
            this.arrowShake = 0;
            this.setIsCritical(false);

            if (iblockstate.getMaterial() != Material.AIR)
            {
                this.arrowHitBlock(this.world, blockpos, raytraceResultIn.sideHit);
                this.inTile.onEntityCollidedWithBlock(this.world, blockpos, iblockstate, this);
            }
        }
    }

    @Override
    public void onUpdate() {
        if ((this.firstUpdate || this.ticksExisted % 5 == 0) && !world.isRemote) {
            RWBYNetworkHandler.sendToAll(new MessagePosVelUpdate(this));
        }
        if (!this.world.isRemote)
        {
            this.setFlag(6, this.isGlowing());
        }

        this.onEntityUpdate();

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float f = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * (180D / Math.PI));
            this.rotationPitch = (float)(MathHelper.atan2(this.motionY, (double)f) * (180D / Math.PI));
            this.prevRotationYaw = this.rotationYaw;
            this.prevRotationPitch = this.rotationPitch;
        }

        BlockPos blockpos = new BlockPos(this.xTile, this.yTile, this.zTile);
        IBlockState iblockstate = this.world.getBlockState(blockpos);
        Block block = iblockstate.getBlock();

        if (iblockstate.getMaterial() != Material.AIR)
        {
            AxisAlignedBB axisalignedbb = iblockstate.getCollisionBoundingBox(this.world, blockpos);

            if (axisalignedbb != Block.NULL_AABB && axisalignedbb.offset(blockpos).contains(new Vec3d(this.posX, this.posY, this.posZ)))
            {
                this.inGround = true;
            }
        }

        if (this.arrowShake > 0)
        {
            --this.arrowShake;
        }

        if (this.inGround)
        {
            int j = block.getMetaFromState(iblockstate);

            if ((block != this.inTile || j != this.inData) && !this.world.collidesWithAnyBlock(this.getEntityBoundingBox().grow(0.05D)))
            {
                this.inGround = false;
                this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
                this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
                this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
            else
            {
                ++this.ticksInGround;


                if (this.ticksInGround >= 1200)
                {
                    this.setDead();
                }
            }


            if(shootingEntity != null && shootingEntity instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) shootingEntity;
            ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);

            if(getShootingItemStack().getItem() instanceof RWBYGun){
                if((((RWBYGun) getShootingItemStack().getItem()).weapontype & RWBYGun.BOOMERANG) !=0){
                    if(shootingEntity !=null &&!player.isSpectator() && !player.isDead && ticksInGround > 100 - 20) {
                        this.noClip = true;
                        if(this.ticksInGround >= (100 - (1 * 20))){
                            double d0 = 1f;
                            Vec3d vec3d = new Vec3d(shootingEntity.posX - this.posX, shootingEntity.posY
                                    + (double) shootingEntity.getEyeHeight() - this.posY, shootingEntity.posZ - this.posZ);
                            this.motionX += vec3d.x * d0 - this.motionX * 0.05D;
                            this.motionY += vec3d.y * d0 - this.motionY * 0.05D;
                            this.motionZ += vec3d.z * d0 - this.motionZ * 0.05D;
                            this.move(MoverType.SELF, this.motionX * 0.05D, this.motionY * 0.05D, this.motionZ * 0.05D);
                        }
                    }}}

            if (semblance instanceof IPyrrha) {
            if(shootingEntity !=null &&!player.isSpectator() && !player.isDead && ticksInGround > 100 - (semblance.getLevel() * 20)) {
                this.noClip = true;
                if(this.ticksInGround >= (100 - (1 * 20))){
                    double d0 = 0.1f; /*1D * (double) 1;*/
                    if(semblance.getLevel() == 1){d0 = 0.25F;}
                    if(semblance.getLevel() == 2){d0 = 0.5F;}
                    if(semblance.getLevel() == 3){d0 = 1F;}
                    Vec3d vec3d = new Vec3d(shootingEntity.posX - this.posX, shootingEntity.posY
                            + (double) shootingEntity.getEyeHeight() - this.posY, shootingEntity.posZ - this.posZ);
                    this.motionX += vec3d.x * d0 - this.motionX * 0.05D;
                    this.motionY += vec3d.y * d0 - this.motionY * 0.05D;
                    this.motionZ += vec3d.z * d0 - this.motionZ * 0.05D;
                    player.getCapability(AuraProvider.AURA_CAP, null).useAura(player, 1F, false);
                    this.move(MoverType.SELF, this.motionX * 0.05D, this.motionY * 0.05D, this.motionZ * 0.05D);
                }
            }}}

            ++this.timeInGround;
        }
        else
        {
            this.timeInGround = 0;
            ++this.ticksInAir;
            if (this.ticksInAir > 20 * 15) {
                this.setDead();
            }
            Vec3d vec3d1 = new Vec3d(this.posX, this.posY, this.posZ);
            Vec3d vec3d = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            RayTraceResult raytraceresult = this.world.rayTraceBlocks(vec3d1, vec3d, false, true, false);
            vec3d1 = new Vec3d(this.posX, this.posY, this.posZ);
            vec3d = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

            if (raytraceresult != null)
            {
                vec3d = new Vec3d(raytraceresult.hitVec.x, raytraceresult.hitVec.y, raytraceresult.hitVec.z);
            }

            Entity entity = this.findEntityOnPath(vec3d1, vec3d);

            if (entity != null)
            {
                raytraceresult = new RayTraceResult(entity);
            }

            if (raytraceresult != null && raytraceresult.entityHit instanceof EntityPlayer)
            {
                EntityPlayer entityplayer = (EntityPlayer)raytraceresult.entityHit;

                if (this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer))
                {
                    raytraceresult = null;
                }
            }

            if (raytraceresult != null && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult))
            {
                this.onHit(raytraceresult);

                if(teleport > 0){
                    if(this.shootingEntity instanceof EntityPlayer){
                        EntityPlayer player =(EntityPlayer) this.shootingEntity;
                    if(player.getCapability(AuraProvider.AURA_CAP, null).getPercentage() > 0.06){
                        player.getCapability(AuraProvider.AURA_CAP, null).useAura(player, 2F,false);
                        //player.getCapability(AuraProvider.AURA_CAP, null).delayRecharge(20);
                this.onImpact(raytraceresult); }}
                }
            }

            if (this.getIsCritical() && this.world.isRemote)
            {
                for (int k = 0; k < 5; ++k)
                {
                    this.world.spawnParticle(this.getParticle(), this.posX + this.motionX * (double)k / 32D, this.posY + this.motionY * (double)k / 32D, this.posZ + this.motionZ * (double)k / 32D, this.rand.nextGaussian() / 10, this.rand.nextGaussian() / 10, this.rand.nextGaussian() / 10);
                }
            }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            float f4 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * (180D / Math.PI));

            for (this.rotationPitch = (float)(MathHelper.atan2(this.motionY, (double)f4) * (180D / Math.PI)); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
            {
                ;
            }

            while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
            {
                this.prevRotationPitch += 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw < -180.0F)
            {
                this.prevRotationYaw -= 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
            {
                this.prevRotationYaw += 360.0F;
            }

            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
            float f1 = 0.99F;
            float f2 = 0.05F;

            if (this.isInWater())
            {
                for (int i = 0; i < 4; ++i)
                {
                    float f3 = 0.25F;
                    this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * 0.25D, this.posY - this.motionY * 0.25D, this.posZ - this.motionZ * 0.25D, this.motionX, this.motionY, this.motionZ);
                }

                f1 = 0.6F;
            }

            if (this.isWet())
            {
                this.extinguish();
            }

            this.motionX *= (double)f1;
            this.motionY *= (double)f1;
            this.motionZ *= (double)f1;

            if (!this.hasNoGravity())
            {
                this.motionY -= 0.05000000074505806D;
            }

            this.setPosition(this.posX, this.posY, this.posZ);
            this.doBlockCollisions();
        }
    }

    @Override
    public void setVelocity(double x, double y, double z) {}

    @Override
    protected void arrowHit(EntityLivingBase living) {

        RWBYAmmoItem item = this.getItem();

        item.onEntityHit(living, (EntityLivingBase) this.shootingEntity);

        float damage = (float)item.getBaseDamage();

        living.hurtResistantTime = 0;

        if(!item.pierce){
        if (item.canSurviveEntityHit()) {
        	this.motionX *= -0.01;
        	this.motionZ *= -0.01;
        	this.motionY *= 0.1;
        }

        if (!item.canSurviveEntityHit() && !(living instanceof EntityEnderman)) {
            this.setDead();
        }}

        if (item.getPotions() != null) {
            for (PotionEffect potion : item.getPotions()) {
                PotionEffect effect = new PotionEffect(potion);
                living.addPotionEffect(effect);
            }
        }
    }

    private void arrowHitBlock(World world, BlockPos pos, EnumFacing facing) {

        RWBYAmmoItem item = this.getItem();

        if (!item.canSurviveBlockHit()) {
            this.setDead();
        }

        if(!world.isRemote){
            item.onBlockHit((EntityLivingBase) this.shootingEntity, pos.offset(facing));}
        //this.setDead();
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        compound.setInteger("xTile", this.xTile);
        compound.setInteger("yTile", this.yTile);
        compound.setInteger("zTile", this.zTile);
        compound.setShort("life", (short)this.ticksInGround);
        ResourceLocation resourcelocation = Block.REGISTRY.getNameForObject(this.inTile);
        compound.setString("inTile", resourcelocation == null ? "" : resourcelocation.toString());
        compound.setByte("inData", (byte)this.inData);
        compound.setByte("shake", (byte)this.arrowShake);
        compound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
        compound.setByte("pickup", (byte)this.pickupStatus.ordinal());
        compound.setBoolean("crit", this.getIsCritical());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        this.xTile = compound.getInteger("xTile");
        this.yTile = compound.getInteger("yTile");
        this.zTile = compound.getInteger("zTile");
        this.ticksInGround = compound.getShort("life");

        if (compound.hasKey("inTile", 8))
        {
            this.inTile = Block.getBlockFromName(compound.getString("inTile"));
        }
        else
        {
            this.inTile = Block.getBlockById(compound.getByte("inTile") & 255);
        }

        this.inData = compound.getByte("inData") & 255;
        this.arrowShake = compound.getByte("shake") & 255;
        this.inGround = compound.getByte("inGround") == 1;

        if (compound.hasKey("pickup", 99))
        {
            this.pickupStatus = EntityArrow.PickupStatus.getByOrdinal(compound.getByte("pickup"));
        }
        else if (compound.hasKey("player", 99))
        {
            this.pickupStatus = compound.getBoolean("player") ? EntityArrow.PickupStatus.ALLOWED : EntityArrow.PickupStatus.DISALLOWED;
        }

        this.setIsCritical(compound.getBoolean("crit"));
    }

    public RWBYAmmoItem getItem() {
        ItemStack stack = dataManager.get(ITEM);
        if (stack.getItem() instanceof RWBYAmmoItem) {
            return (RWBYAmmoItem) dataManager.get(ITEM).getItem();
        }
        else {
            return (RWBYAmmoItem) RWBYItems.ammmo;
        }
    }

    protected void onImpact(RayTraceResult result)
    {
        EntityLivingBase entitylivingbase = this.shooter;

        if (result.entityHit != null)
        {
            if (result.entityHit == this.shooter)
            {
                return;
            }

            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, entitylivingbase), 0.0F);
        }

        if (result.typeOfHit == RayTraceResult.Type.BLOCK)
        {
            BlockPos blockpos = result.getBlockPos();
            TileEntity tileentity = this.world.getTileEntity(blockpos);

            if (tileentity instanceof TileEntityEndGateway)
            {
                TileEntityEndGateway tileentityendgateway = (TileEntityEndGateway)tileentity;

                if (entitylivingbase != null)
                {
                    if (entitylivingbase instanceof EntityPlayerMP)
                    {
                        CriteriaTriggers.ENTER_BLOCK.trigger((EntityPlayerMP)entitylivingbase, this.world.getBlockState(blockpos));
                    }

                    tileentityendgateway.teleportEntity(entitylivingbase);
                    this.setDead();
                    return;
                }

                tileentityendgateway.teleportEntity(this);
                return;
            }
        }

        for (int i = 0; i < 32; ++i)
        {
            this.world.spawnParticle(EnumParticleTypes.PORTAL, this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
        }

        if (!this.world.isRemote)
        {
            if (entitylivingbase instanceof EntityPlayerMP)
            {
                EntityPlayerMP entityplayermp = (EntityPlayerMP)entitylivingbase;

                if (entityplayermp.connection.getNetworkManager().isChannelOpen() && entityplayermp.world == this.world && !entityplayermp.isPlayerSleeping())
                {
                    net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(entityplayermp, this.posX, this.posY, this.posZ, 5.0F);
                    if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
                    { // Don't indent to lower patch size

                        if (entitylivingbase.isRiding())
                        {
                            entitylivingbase.dismountRidingEntity();
                        }

                        entitylivingbase.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                        entitylivingbase.fallDistance = 0.0F;
                        //entitylivingbase.attackEntityFrom(DamageSource.FALL, event.getAttackDamage());
                    }
                }
            }
            else if (entitylivingbase != null)
            {
                entitylivingbase.setPositionAndUpdate(this.posX, this.posY, this.posZ);
                entitylivingbase.fallDistance = 0.0F;
            }

            this.setDead();
        }
    }

    public void setKnockbackStrength(int knockbackStrengthIn)
    {
        this.knockbackStrength = knockbackStrengthIn;
    }

    public void setItem(ItemStack stack) {
    	dataManager.set(ITEM, stack);
    }
    
    public void setItem(RWBYAmmoItem item) {
    	dataManager.set(ITEM, new ItemStack(item));
    }
    
    public ItemStack getShootingItemStack() {
    	return dataManager.get(SHOOTING_STACK);
    }

    public void setShootingItemStack(ItemStack stack) {
        dataManager.set(SHOOTING_STACK, stack);
    }

    @Override
    protected ItemStack getArrowStack() {
        ItemStack item = this.getShootingItemStack();
        return item.copy();
    }

    @Override
    public Entity getThrower() {
        return this.shootingEntity;
    }

    @Override
    public void setThrower(Entity entity) {
        this.shootingEntity = entity;
    }

}