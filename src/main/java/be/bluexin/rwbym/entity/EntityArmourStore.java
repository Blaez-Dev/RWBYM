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
import java.util.*;


public class EntityArmourStore extends EntityRWBYMMerchant implements INpc, IMerchant{
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
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Beacon1Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Beacon1Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.BeaconChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.BeaconLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Blake1Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Blake1Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Blake2Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Blake2Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Blake3Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Blake3Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.AmberChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.AmberLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Cinder1Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Cinder1Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Cinder2Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Cinder2Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Cinder3Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Cinder3Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.CocoChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.CocoHead, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.CocoLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Emerald1Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Emerald1Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Emerald2Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.Emerald2Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.pennyChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.pennyLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.pyrrhaChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.pyrrhaLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.ravenChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.ravenLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.rubyhood, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.ruby1Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.ruby1Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.ruby2Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.ruby2Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.ruby3Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.ruby3Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.salemChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.salemLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.velvetChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.velvetLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.weiss2Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.weiss2Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.weiss3Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.weiss3Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.winterChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.winterLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.yang1Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.yang1Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.yang2Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.yang2Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.yang3Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.yang3Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.yang4Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3),new ItemStack(RWBYItems.yang4Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.neptuneHead, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.neptuneChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.neptuneLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.romanHead, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.romanChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.romanLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.ironwood1Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.ironwood1Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.ironwood2Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.ironwood2Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.mercury1Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.mercury1Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.mercury2Chest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.mercury2Legs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.ozpinChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.ozpinLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.sageChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.sageLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.sunChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.sunLegs, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.scarletChest, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien50,3), new ItemStack(RWBYItems.scarletLegs, 1)),
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

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2222D);
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
        List<Entity> entitylist = world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().grow(20D));
        for (Entity entity : entitylist) {
            if (entity instanceof EntityMob) {
                EntityMob mob = (EntityMob) entity;
                if(mob.getAttackTarget() == this){
                mob.setAttackTarget(null);}
            }
        }

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
        for (int i = 0; i < 25; i++) {
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

    public World getWorld() {
        return this.world;
    }

    public void useRecipe(MerchantRecipe recipe) {
        this.livingSoundTime = -this.getTalkInterval();
        this.playSound(SoundEvents.ENTITY_VILLAGER_YES, this.getSoundVolume(), this.getSoundPitch());

    }

    @Override
    protected void updateAITasks() {


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