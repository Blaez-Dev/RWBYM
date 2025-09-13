package io.github.blaezdev.rwbym.entity;

import io.github.blaezdev.rwbym.Init.RWBYFluids;
import io.github.blaezdev.rwbym.Init.RWBYItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;


public class EntityBlackStore extends EntityRWBYMMerchant implements INpc, IMerchant{
    World world = null;
    private MerchantRecipeList trades;
    private EntityPlayer buyingPlayer;

    public EntityBlackStore(World var3) {
        super(var3);
        world = var3;

        ItemStack is = new ItemStack(RWBYItems.whtefng, 1);
        this.setSize(1F, 1.5F);
        this.setItemStackToSlot(EntityEquipmentSlot.HEAD, is);
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

        //buy//
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,2),new ItemStack(RWBYItems.rvnmask,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,1),new ItemStack(RWBYItems.whtefng,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,1),new ItemStack(RWBYItems.henchmenhat,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,1),new ItemStack(RWBYItems.henchmenhatglasses,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,1),new ItemStack(RWBYItems.henchmanChest,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,1),new ItemStack(RWBYItems.henchmanLegs,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,1),new ItemStack(RWBYItems.atlasknight,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,1),new ItemStack(RWBYItems.wallet,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,1),new ItemStack(RWBYItems.dustpouch,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,1),new ItemStack(RWBYItems.partspouch,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,25),new ItemStack(RWBYItems.coinr,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,25),new ItemStack(RWBYItems.coinw,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,25),new ItemStack(RWBYItems.coinb,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,25),new ItemStack(RWBYItems.coiny,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,25),new ItemStack(RWBYItems.coinjaune,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,25),new ItemStack(RWBYItems.coin_pyrrha,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,25),new ItemStack(RWBYItems.coinnora,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,25),new ItemStack(RWBYItems.coin_ren,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,25),new ItemStack(RWBYItems.coin_lysette,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,25),new ItemStack(RWBYItems.coin_ragora,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,25),new ItemStack(RWBYItems.coin_clover,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,25),new ItemStack(RWBYItems.coin_harriet,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,25),new ItemStack(RWBYItems.coinqrow,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,25),new ItemStack(RWBYItems.coin_valour,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.rwbyblock7, 1), new ItemStack(RWBYItems.summer1Chest)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.rwbyblock7, 1), new ItemStack(RWBYItems.summer1Legs)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.rwbyblock7, 1), new ItemStack(RWBYItems.summer2Chest)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.rwbyblock7, 1), new ItemStack(RWBYItems.summer2Legs)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.rwbyblock7, 1), new ItemStack(RWBYItems.summerhood)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,2),new ItemStack(RWBYItems.crush,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,2),new ItemStack(RWBYItems.chisel,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,10),new ItemStack(RWBYItems.crusher,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,1),new ItemStack(RWBYItems.scroll,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,1),new ItemStack(RWBYItems.scroll2,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,3),new ItemStack(RWBYItems.scrollred7,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,3),new ItemStack(RWBYItems.scrollwhite7,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,3),new ItemStack(RWBYItems.scrollblack7,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,3),new ItemStack(RWBYItems.scrollyellow7,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,3),new ItemStack(RWBYItems.scrollblue7,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,3),new ItemStack(RWBYItems.scrollgreen7,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,3),new ItemStack(RWBYItems.scrollpink7,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,10),new ItemStack(RWBYItems.container,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.lieutenant,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.whitefangspear,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.whitefangsword,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.whitefangrifle,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.wfp,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.henchmen,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.henchmenaxe,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.remnants, 1), new ItemStack(RWBYItems.lien20, 2)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500, 6), UniversalBucket.getFilledBucket(null, RWBYFluids.GRIMM)));
        //sell//

        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.bait,1), new ItemStack(RWBYItems.lien500, 1)));
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
        // add as many trades as you want
    }

    public void verifySellingItem(ItemStack stack) {
        if (!this.world.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20) {
            this.livingSoundTime = -this.getTalkInterval();
            this.playSound(stack.isEmpty() ? SoundEvents.ENTITY_VILLAGER_NO : SoundEvents.ENTITY_VILLAGER_YES, this.getSoundVolume(), this.getSoundPitch());
        }

    }

    /*
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
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(6, new EntityAIVillagerMate(this));
        this.tasks.addTask(7, new EntityAIFollowGolem(this));
        this.tasks.addTask(9, new EntityAIVillagerInteract(this));
        this.tasks.addTask(9, new EntityAIWanderAvoidWater(this, 0.6D));
    }*/

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        List<Entity> entitylist = world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().grow(60D));
        for (Entity entity : entitylist) {
            if (entity instanceof EntityMob) {
                EntityMob mob = (EntityMob) entity;
                if(mob.getAttackTarget() == this){
                    mob.setAttackTarget(null);}
            }
        }
        this.heal(0.5F);
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