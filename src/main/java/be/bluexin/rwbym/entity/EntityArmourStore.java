package be.bluexin.rwbym.entity;

import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.ModLootTables;
import be.bluexin.rwbym.blocks.RWBYBlock;
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
import net.minecraft.village.Village;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;


public class EntityArmourStore extends EntityCreature implements INpc, IMerchant{
    World world = null;
    private MerchantRecipeList trades;
    private int ticksAlive;
    private EntityPlayer buyingPlayer;
    Village village;
    private static MerchantRecipe[] weapons = new MerchantRecipe[]{

            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.QrowChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.QrowLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.RagoraLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.RagoraChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.RagoraHead, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Juane1Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Juane1Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Weiss1Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Weiss1Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.AdamChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.AdamLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.AtlasChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.AtlasHead, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.AtlasLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Blake1Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Blake1Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Blake2Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Blake2Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Blake3Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Blake3Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.rvnmask, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.whtefng, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien100,4),new ItemStack(RWBYItems.scroll, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien100,4),new ItemStack(RWBYItems.scroll2, 1))};

    private int randomTickDivider;
    private boolean isLookingForHome;

    public EntityArmourStore(World var3) {
        super(var3);
        world = var3;
        this.setSize(1F, 1.5F);
    }

    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityAIAttackMeleeWithRange(this, 1.0D, false, 0.5F));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2499999940395355D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(60.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
    }

    public boolean canBeLeashedTo(EntityPlayer player) {
        return false;
    }

    @Override
    public boolean getCanSpawnHere() {
        return super.getCanSpawnHere();
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

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.ticksAlive ++;
        if(ticksAlive % 18000 == 0) {
            populateTradingList();
        }
    }

    @SideOnly(Side.CLIENT)
    public void setRecipes(@Nullable MerchantRecipeList recipeList) {
    }

    protected void populateTradingList() {

        this.trades = new MerchantRecipeList();

        //Buy


        //Sell

        //Random Weapons

        Random rand = new Random();
        int nextRandom = rand.nextInt(this.weapons.length);
        Set<Integer> validate = new HashSet<>();
        validate.add(nextRandom);
        for (int i = 0; i < 20; i++) {
            while(validate.contains(nextRandom)) {
                nextRandom = rand.nextInt(this.weapons.length);
            }
            validate.add(nextRandom);
        }
        for (int i : validate) {
            this.trades.add(this.weapons[i]);
        }


        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.rwbyblock8,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.remnants,1), new ItemStack(RWBYItems.lien10, 3)));
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

    }

    protected void updateAITasks() {
        if (--this.randomTickDivider <= 0) {
            BlockPos blockpos = new BlockPos(this);
            this.world.getVillageCollection().addToVillagerPositionList(blockpos);
            this.randomTickDivider = 70 + this.rand.nextInt(50);
            this.village = this.world.getVillageCollection().getNearestVillage(blockpos, 32);
            if (this.village == null) {
                this.detachHome();
            } else {
                BlockPos blockpos1 = this.village.getCenter();
                this.setHomePosAndDistance(blockpos1, this.village.getVillageRadius());
                if (this.isLookingForHome) {
                    this.isLookingForHome = false;
                    this.village.setDefaultPlayerReputation(5);
                }
            }
        }


        super.updateAITasks();
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