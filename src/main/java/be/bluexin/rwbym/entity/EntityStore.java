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


public class EntityStore extends EntityMob implements INpc, IMerchant{
    World world = null;
    private MerchantRecipeList trades;
    private EntityPlayer buyingPlayer;

    public EntityStore(World var3) {
        super(var3);
        world = var3;
        this.setSize(1.5F, 1.5F);
    }

    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(8, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2499999940395355D);
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


    @SideOnly(Side.CLIENT)
    public void setRecipes(@Nullable MerchantRecipeList recipeList) {
    }

    protected void populateTradingList() {

        this.trades = new MerchantRecipeList();

        this.trades.add(new MerchantRecipe(new ItemStack(Items.EMERALD,2),new ItemStack(RWBYItems.firedust,10)));
        this.trades.add(new MerchantRecipe(new ItemStack(Items.EMERALD,2),new ItemStack(RWBYItems.dust,10)));
        this.trades.add(new MerchantRecipe(new ItemStack(Items.EMERALD,2),new ItemStack(RWBYItems.gravitydust,10)));
        this.trades.add(new MerchantRecipe(new ItemStack(Items.EMERALD,2),new ItemStack(RWBYItems.icedust,10)));
        this.trades.add(new MerchantRecipe(new ItemStack(Items.EMERALD,2),new ItemStack(RWBYItems.lightdust,10)));
        this.trades.add(new MerchantRecipe(new ItemStack(Items.EMERALD,2),new ItemStack(RWBYItems.waterdust,10)));
        this.trades.add(new MerchantRecipe(new ItemStack(Items.EMERALD,2),new ItemStack(RWBYItems.winddust,10)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.firedust,10), new ItemStack(Items.EMERALD,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.dust,10), new ItemStack(Items.EMERALD,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.gravitydust,10), new ItemStack(Items.EMERALD,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.icedust,10), new ItemStack(Items.EMERALD,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lightdust,10), new ItemStack(Items.EMERALD,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.waterdust,10), new ItemStack(Items.EMERALD,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.winddust,10),new ItemStack(Items.EMERALD,1)));

        // add as many trades as you want

    }

    public void verifySellingItem(ItemStack stack) {
        if (!this.world.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20) {
            this.livingSoundTime = -this.getTalkInterval();
            this.playSound(stack.isEmpty() ? SoundEvents.ENTITY_VILLAGER_NO : SoundEvents.ENTITY_VILLAGER_YES, this.getSoundVolume(), this.getSoundPitch());
        }

    }

    public World getWorld() {
        return this.world;
    }

    public void useRecipe(MerchantRecipe recipe) {
        this.livingSoundTime = -this.getTalkInterval();
        this.playSound(SoundEvents.ENTITY_VILLAGER_YES, this.getSoundVolume(), this.getSoundPitch());
        int i = 3 + this.rand.nextInt(4);
        //this.populateTradingList();
        if (recipe.getRewardsExp()) {
            this.world.spawnEntity(new EntityXPOrb(this.world, this.posX, this.posY + 0.5D, this.posZ, i));
        }

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