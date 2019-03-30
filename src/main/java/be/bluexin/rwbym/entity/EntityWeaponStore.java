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


public class EntityWeaponStore extends EntityCreature implements INpc, IMerchant{
    World world = null;
    private MerchantRecipeList trades;
    private int ticksAlive;
    private EntityPlayer buyingPlayer;
    Village village;
    private static MerchantRecipe[] weapons = new MerchantRecipe[]{
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.pennyswd,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.neoumb_closed,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.torchwick,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.frostediron,4), new ItemStack(RWBYItems.cinder, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.shadowiron,8), new ItemStack(RWBYItems.jnrbat, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.forestiron,4), new ItemStack(RWBYItems.emeraldgun, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.shadowiron,4), new ItemStack(RWBYItems.adamswd, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.frostediron,8), new ItemStack(RWBYItems.winterswd, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.ozpincane,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.portgun,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,8),new ItemStack(RWBYItems.qrowsword,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,8),new ItemStack(RWBYItems.rvnswd,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500, 7), new ItemStack(RWBYItems.sunstaff, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500, 7), new ItemStack(RWBYItems.sage, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500, 7), new ItemStack(RWBYItems.neptunegun, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,7),new ItemStack(RWBYItems.arslan,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,7),new ItemStack(RWBYItems.bolin,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,7),new ItemStack(RWBYItems.shadowiron, 16),new ItemStack(RWBYItems.reese,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,8),new ItemStack(RWBYItems.roseiron,8), new ItemStack(RWBYItems.crescent, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,8),new ItemStack(RWBYItems.frostediron,8), new ItemStack(RWBYItems.weiss, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,8),new ItemStack(RWBYItems.shadowiron,8), new ItemStack(RWBYItems.gambol, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,8),new ItemStack(RWBYItems.gildediron,8), new ItemStack(RWBYItems.ember, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,8),new ItemStack(RWBYItems.gildediron,8), new ItemStack(RWBYItems.juane, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,8),new ItemStack(RWBYItems.frostediron,8), new ItemStack(RWBYItems.norahammer, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,8),new ItemStack(RWBYItems.roseiron,8), new ItemStack(RWBYItems.pyrrhaspear, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,8),new ItemStack(RWBYItems.forestiron,8), new ItemStack(RWBYItems.stormflower, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,10),new ItemStack(RWBYItems.viridianiron,8), new ItemStack(RWBYItems.korekosmouoff, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,10),new ItemStack(RWBYItems.viridianiron,8), new ItemStack(RWBYItems.chatareusgun, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,10),new ItemStack(RWBYItems.viridianiron,8), new ItemStack(RWBYItems.razorbolt, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.mariacane, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.ozmacane, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.cocobag, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.velvet, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.yatsuhashi, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.fox, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.angelcane, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.rwbyblock8,1))};
    private int randomTickDivider;
    private boolean isLookingForHome;

    public EntityWeaponStore(World var3) {
        super(var3);
        world = var3;
        this.setSize(1F, 1.5F);
    }

    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(8, new EntityAIWander(this, 0.6D));
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
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien20,1),new ItemStack(RWBYItems.scrap,10)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,1),new ItemStack(RWBYItems.roseiron,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,1),new ItemStack(RWBYItems.frostediron,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,1),new ItemStack(RWBYItems.shadowiron,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,1),new ItemStack(RWBYItems.gildediron,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,1),new ItemStack(RWBYItems.viridianiron,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,1),new ItemStack(RWBYItems.forestiron,1)));

        //Sell
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.remnants,1), new ItemStack(RWBYItems.lien10, 3)));

        //Random Weapons

        Random rand = new Random();
        int nextRandom = rand.nextInt(this.weapons.length);
        Set<Integer> validate = new HashSet<>();
        validate.add(nextRandom);
        for (int i = 0; i < 10; i++) {
            while(validate.contains(nextRandom)) {
                nextRandom = rand.nextInt(this.weapons.length);
            }
            validate.add(nextRandom);
        }
        for (int i : validate) {
            this.trades.add(this.weapons[i]);
        }
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
