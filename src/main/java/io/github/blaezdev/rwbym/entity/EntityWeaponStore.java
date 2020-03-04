package io.github.blaezdev.rwbym.entity;

import io.github.blaezdev.rwbym.Init.RWBYItems;
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
import net.minecraft.village.Village;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class EntityWeaponStore extends EntityRWBYMMerchant implements INpc, IMerchant{
    World world = null;
    private MerchantRecipeList trades;
    private int ticksAlive;
    private EntityPlayer buyingPlayer;
    Village village;
    private static MerchantRecipe[] weapons = new MerchantRecipe[]{
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.pennyswd,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.henchmen,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.henchmenaxe,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.fennec,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.corsac,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.neoumb_closed,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.torchwick,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.lieutenant,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.whitefangspear,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.whitefangsword,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.whitefangrifle,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.wfp,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.iliasword,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.deemace,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.cardin,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.dove,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.russelnormal,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.lark,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.nebulabow,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.dew,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.gwenknife,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.octavia,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.atlaspistol,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.atlasrifle,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.frostediron,4), new ItemStack(RWBYItems.cinder, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.shadowiron,4), new ItemStack(RWBYItems.cinderglass, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.shadowiron,8), new ItemStack(RWBYItems.jnrbat, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.forestiron,4), new ItemStack(RWBYItems.emeraldgun, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.shadowiron,4), new ItemStack(RWBYItems.adamswd, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,5),new ItemStack(RWBYItems.shadowiron,2), new ItemStack(RWBYItems.tyrian, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.frostediron,8), new ItemStack(RWBYItems.winterswd, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.brawnz,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.royg,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.nolan,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.mayrifle,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.ozpincane,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.portgun,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.ironwood,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.ironwood2,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.kingfisher,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.fetch,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.goodwitch,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.oobleckthermos,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,6),new ItemStack(RWBYItems.lionheart,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,8),new ItemStack(RWBYItems.qrowsword,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,8),new ItemStack(RWBYItems.rvnswd,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500, 7), new ItemStack(RWBYItems.vernal, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500, 7), new ItemStack(RWBYItems.sunstaff, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500, 7), new ItemStack(RWBYItems.sage, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500, 7), new ItemStack(RWBYItems.scarletsword, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500, 7), new ItemStack(RWBYItems.neptunegun, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,7),new ItemStack(RWBYItems.arslan,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,7),new ItemStack(RWBYItems.bolin,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,7),new ItemStack(RWBYItems.shadowiron, 16),new ItemStack(RWBYItems.reese,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,7),new ItemStack(RWBYItems.nadirgun,1)),
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
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,10),new ItemStack(RWBYItems.viridianiron,8), new ItemStack(RWBYItems.hexen, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,10),new ItemStack(RWBYItems.viridianiron,8), new ItemStack(RWBYItems.magnumgun, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,10),new ItemStack(RWBYItems.viridianiron,8), new ItemStack(RWBYItems.lysettesword, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.vidian,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.aquaealatlsword,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.scarletstormgun,1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.mariacane, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.tocksword, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.ozmacane, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.amberstafffire, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.cocobag, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.velvet, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.yatsuhashi, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.fox, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.angelcane, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.pugzsword, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.onoyari, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.whisperingblossom, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,12),new ItemStack(RWBYItems.cassandra, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,14),new ItemStack(RWBYItems.noctustraumnormal, 1)),
            new MerchantRecipe(new ItemStack(RWBYItems.lien500,14),new ItemStack(RWBYItems.carminesai, 1))

    };
    private int randomTickDivider;
    private boolean isLookingForHome;

    public EntityWeaponStore(World var3) {
        super(var3);
        world = var3;
        this.setSize(1F, 1.5F);
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
        List<Entity> entitylist = world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().grow(60D));
        for (Entity entity : entitylist) {
            if (entity instanceof EntityMob) {
                EntityMob mob = (EntityMob) entity;
                if(mob.getAttackTarget() == this){
                    mob.setAttackTarget(null);}
            }
        }
        //super.onLivingUpdate();

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
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,1),new ItemStack(RWBYItems.roseiron,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,1),new ItemStack(RWBYItems.frostediron,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,1),new ItemStack(RWBYItems.shadowiron,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,1),new ItemStack(RWBYItems.gildediron,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,1),new ItemStack(RWBYItems.viridianiron,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien50,1),new ItemStack(RWBYItems.forestiron,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien20,1),new ItemStack(RWBYItems.scrap,10)));

        //Sell

        //Random Weapons

        Random rand = new Random();
        int nextRandom = rand.nextInt(this.weapons.length);
        Set<Integer> validate = new HashSet<>();
        validate.add(nextRandom);
        for (int i = 0; i < 15; i++) {
            while(validate.contains(nextRandom)) {
                nextRandom = rand.nextInt(this.weapons.length);
            }
            validate.add(nextRandom);
        }
        for (int i : validate) {
            this.trades.add(this.weapons[i]);
        }
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien500,4),new ItemStack(RWBYItems.rwbyblock8,1)));
        this.trades.add(new MerchantRecipe(new ItemStack(RWBYItems.lien100,2), new ItemStack(RWBYItems.extasisammo, 3)));
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
