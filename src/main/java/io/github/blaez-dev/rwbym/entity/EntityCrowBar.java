package io.github.blaez-dev.rwbym.entity;

import io.github.blaez-dev.rwbym.Init.RWBYItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;


public class EntityCrowBar extends EntityRWBYMMerchant implements INpc, IMerchant {
    World world = null;
    private MerchantRecipeList trades;
    private EntityPlayer buyingPlayer;

    public EntityCrowBar(World var3) {
        super(var3);
        world = var3;
        this.setSize(1F, 1.5F);
    }


    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityEvoker.class, 12.0F, 0.8D, 0.8D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityVindicator.class, 8.0F, 0.8D, 0.8D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityVex.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(1, new EntityAITradePlayer(this));
        this.tasks.addTask(1, new EntityAILookAtTradePlayer(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(6, new EntityAIVillagerMate(this));
        this.tasks.addTask(7, new EntityAIFollowGolem(this));
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(9, new EntityAIVillagerInteract(this));
        this.tasks.addTask(9, new EntityAIWanderAvoidWater(this, 0.6D));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(60.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
    }


    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        boolean flag = itemstack.getItem() == Items.NAME_TAG;
        if (flag) {
            itemstack.interactWithEntity(player, this, hand);
            return true;
        } else if(!flag){
            if (this.trades == null) {
                this.populateTradingList();
            }

            if (!this.world.isRemote && !this.trades.isEmpty()) {
                this.setCustomer(player);
                player.displayVillagerTradeGui(this);
            } else if (this.trades.isEmpty()) {
                return super.processInteract(player, hand);
            }

            return true;
        } else {
            return super.processInteract(player, hand);
        }
    }

    @Override

    public MerchantRecipeList getRecipes(EntityPlayer player) {

        if (trades == null || trades.isEmpty()) {

            populateTradingList();

        }

        return trades;

    }

    public boolean canBeLeashedTo(EntityPlayer player) {
        return false;
    }



    @SideOnly(Side.CLIENT)
    public void setRecipes(@Nullable MerchantRecipeList recipeList) {
    }

    protected void populateTradingList() {

        this.trades = new MerchantRecipeList();

        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien20, 1), new ItemStack(RWBYItems.torchquick)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50, 1), new ItemStack(RWBYItems.hchoc)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50, 1), new ItemStack(RWBYItems.plg)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien20, 3), new ItemStack(RWBYItems.sunrise)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien20, 3), new ItemStack(RWBYItems.coconutmilk)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien20, 4), new ItemStack(RWBYItems.qrowflask)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien20, 4), new ItemStack(RWBYItems.coffee)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien20, 4), new ItemStack(RWBYItems.sake)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50, 3), new ItemStack(RWBYItems.pancakes)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50, 2), new ItemStack(RWBYItems.fishramen)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50, 2), new ItemStack(RWBYItems.ramen)));

        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien1,5),new ItemStack(RWBYItems.lien5, 1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien5,2),new ItemStack(RWBYItems.lien10, 1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,2),new ItemStack(RWBYItems.lien20, 1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien20,2),new ItemStack(RWBYItems.lien10, 1),new ItemStack(RWBYItems.lien50)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,5),new ItemStack(RWBYItems.lien50, 1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,2),new ItemStack(RWBYItems.lien100, 1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien100,5),new ItemStack(RWBYItems.lien500, 1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,1),new ItemStack(RWBYItems.lien100, 5)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien100,1),new ItemStack(RWBYItems.lien50, 2)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,1),new ItemStack(RWBYItems.lien10, 5)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien20,1),new ItemStack(RWBYItems.lien10, 2)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,1),new ItemStack(RWBYItems.lien5, 2)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien5,1),new ItemStack(RWBYItems.lien1, 5)));


    }

    public void verifySellingItem(ItemStack stack) {
        if (!this.world.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20) {
            this.livingSoundTime = -this.getTalkInterval();
            this.playSound(stack.isEmpty() ? SoundEvents.ENTITY_VILLAGER_NO : SoundEvents.ENTITY_VILLAGER_YES, this.getSoundVolume(), this.getSoundPitch());
        }

    }

    @Override
    public void onLivingUpdate() {
        //super.onLivingUpdate();
        List<Entity> entitylist = world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().grow(20D));
        for (Entity entity : entitylist) {
            if (entity instanceof EntityMob) {
                EntityMob mob = (EntityMob) entity;
                if(mob.getAttackTarget() == this){
                    mob.setAttackTarget(null);}
            }
        }


        super.onLivingUpdate();
    }

    public World getWorld() {
        return this.world;
    }

    public void useRecipe(MerchantRecipe recipe) {
        this.livingSoundTime = -this.getTalkInterval();
        this.playSound(SoundEvents.ENTITY_VILLAGER_YES, this.getSoundVolume(), this.getSoundPitch());
    }

    protected boolean canDespawn() {
        return false;
    }

    public BlockPos getPos() {
        return new BlockPos(this);
    }

    public void setCustomer(@Nullable EntityPlayer player) {
        this.buyingPlayer = player;
    }

    @Nullable
    public EntityPlayer getCustomer() {
        return this.buyingPlayer;
    }

    protected ResourceLocation getLootTable() {
        return null;
    }

    protected SoundEvent getAmbientSound() { return null; }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_VILLAGER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_VILLAGER_DEATH;
    }
    @Override
    protected float getSoundVolume() {
        return 1.0F;
    }

}