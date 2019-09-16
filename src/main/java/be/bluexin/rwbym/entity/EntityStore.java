package be.bluexin.rwbym.entity;

import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.ModLootTables;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;


public class EntityStore extends EntityRWBYMMerchant implements INpc, IMerchant{
    World world = null;
    private MerchantRecipeList trades;
    private EntityPlayer buyingPlayer;

    public EntityStore(World var3) {
        super(var3);
        world = var3;
        this.setSize(1F, 1.5F);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.222D);
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

    @Override
    protected void updateAITasks() {


        super.updateAITasks();
    }

    @SideOnly(Side.CLIENT)
    public void setRecipes(@Nullable MerchantRecipeList recipeList) {
    }

    protected void populateTradingList() {

        this.trades = new MerchantRecipeList();

        //buy//
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,1),new ItemStack(RWBYItems.firedust,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,1),new ItemStack(RWBYItems.dust,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,1),new ItemStack(RWBYItems.gravitydust,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,1),new ItemStack(RWBYItems.icedust,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,1),new ItemStack(RWBYItems.lightdust,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,1),new ItemStack(RWBYItems.waterdust,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,1),new ItemStack(RWBYItems.winddust,1)));

        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,1),new ItemStack(RWBYItems.dustcrystal,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,1),new ItemStack(RWBYItems.firedustcrystal,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,1),new ItemStack(RWBYItems.gravitydustcrystal,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,1),new ItemStack(RWBYItems.icedustcrystal,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,1),new ItemStack(RWBYItems.lightdustcrystal,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,1),new ItemStack(RWBYItems.waterdustcrystal,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien10,1),new ItemStack(RWBYItems.winddustcrystal,1)));

        //sell//
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.firedust,1), new ItemStack(RWBYItems.lien5,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.dust,1), new ItemStack(RWBYItems.lien5,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.gravitydust,1), new ItemStack(RWBYItems.lien5,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.icedust,1), new ItemStack(RWBYItems.lien5,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lightdust,1), new ItemStack(RWBYItems.lien5,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.waterdust,1), new ItemStack(RWBYItems.lien5,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.winddust,1),new ItemStack(RWBYItems.lien5,1)));

        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.dustcrystal,1),new ItemStack(RWBYItems.lien5,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.firedustcrystal,1),new ItemStack(RWBYItems.lien5,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.gravitydustcrystal,1),new ItemStack(RWBYItems.lien5,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.icedustcrystal,1),new ItemStack(RWBYItems.lien5,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lightdustcrystal,1),new ItemStack(RWBYItems.lien5,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.waterdustcrystal,1),new ItemStack(RWBYItems.lien5,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.winddustcrystal,1),new ItemStack(RWBYItems.lien5,1)));

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

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
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