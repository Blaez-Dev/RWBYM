package be.bluexin.rwbym.weaponry;

import be.bluexin.rwbym.Init.RWBYCreativeTabs;
import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.RWBYSoundHandler;
import be.bluexin.rwbym.entity.EntityLargeFireball;
import be.bluexin.rwbym.entity.EntityNeverMore;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.*;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Part of rwbym
 *
 * @author Bluexin
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class RWBYBow extends ItemBow implements ICustomItem {

    private final String data;
    private final int drawSpeed;
    private final String morph;
    private final String ammo;
    private final float projectileSpeed;
    private final boolean charges; // TODO: use this
    private boolean recoil;
    private boolean recoil2;
    private boolean recoil3;
    private boolean crescentr = false;
    private boolean emberc = false;
    private boolean ember2 = false;
    private boolean gambols = false;
    private boolean magna = false;
    private boolean mytre = false;
    private boolean stormf = false;
    private boolean coco = false;
    private boolean port = false;
    private boolean velvet = false;
    private boolean cinder = false;
    private boolean emerald = false;
    private boolean jnr = false;
    private boolean torch = false;
    boolean compensate;
    float lastDamage;
    private boolean emerald2 = false;


    public RWBYBow(String name, int durability, int drawSpeed, int enchantability, String data, String morph, String ammo, boolean noCharge, float projectileSpeed, boolean usesAmmo, int recoilType, int enchantmentglow, CreativeTabs creativetab) {
        this.setMaxDamage(durability);
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(creativetab);
        this.drawSpeed = drawSpeed;
        this.data = data;
        this.morph = morph;
        this.ammo = ammo;
        this.projectileSpeed = projectileSpeed;
        this.charges = !noCharge;
        if(recoilType == 1) this.recoil = true;
        if(recoilType == 2) this.recoil2 = true;
        if(recoilType == 3) this.recoil3 = true;
        if(enchantmentglow == 1) this.velvet = true;

        if(name.contains("crescent")) crescentr = true;
        if(name.contains("gambol")) gambols = true;
        if(name.contains("ember")) emberc = true;
        if(name.contains("ember2")) ember2 = true;
        if(name.contains("nora")) magna = true;
        if(name.contains("weiss")) mytre = true;
        if(name.contains("stormf")) stormf = true;
        if(name.contains("coco")) coco = true;
        if(name.contains("qrow")) emberc = true;
        if(name.contains("emberv")) emberc = true;
        if(name.contains("weissv")) mytre = true;
        if(name.contains("portgun")) port = true;
        if(name.contains("emeraldgun")) emerald = true;
        if(name.contains("emeraldblade")) emerald = true;
        if(name.contains("emeraldblade")) emerald2 = true;
        if(name.contains("stormf")) emerald2 = true;
        if(name.contains("cinderbow")) cinder = true;
        if(name.contains("jnrrocket")) jnr = true;
        if(name.contains("adamgun")) emberc = true;
        if(name.contains("torchwickgun")) torch = true;

        if (this.ember2) this.addPropertyOverride(new ResourceLocation("offhand"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            @ParametersAreNonnullByDefault
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.getHeldItemOffhand() == stack ? 1.0F : 0.0F;
            }
        });

    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }


    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return this.drawSpeed;
    }

    /*@Override
    public void registerRecipes() {
        if (this.recipes != null) for (RecipeDTO recipe : this.recipes) {
            recipe.register(this);
        }
    }*/

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        if(velvet){return true;}
        else
        return false;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void onUpdate(ItemStack is, World world, Entity entity, int slotIn, boolean inHand) {
        if(!world.isRemote) {
            if (entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entity;
                {    if (emerald2) {
                    if (player.fallDistance > 4 & compensate) {
                        lastDamage = player.fallDistance;
                        player.fallDistance = 0.3F;
                    } else if (!(player.fallDistance > 0)) {
                        if (compensate) {
                            compensate = false;
                        }
                    }
                }
            }}
        }

        /*if(ember2){
            if(entity instanceof EntityPlayer && !world.isRemote) {
                EntityPlayer player = (EntityPlayer) entity;
                float hppct = player.getHealth()/player.getMaxHealth();
                float hpPct = Math.min(player.getHealth() / player.getMaxHealth(), 1f);
                if (hppct > 0.61 && hppct < 0.80){
                PotionEffect potioneffect = new PotionEffect(MobEffects.STRENGTH, 60, 1, false, false);
                player.addPotionEffect(potioneffect);}
                if (hppct > 0.41 && hppct < 0.60){
                    PotionEffect potioneffect = new PotionEffect(MobEffects.STRENGTH, 60, 2, false, false);
                    player.addPotionEffect(potioneffect);}
                if (hppct > 0.21 && hppct < 0.40){
                    PotionEffect potioneffect = new PotionEffect(MobEffects.STRENGTH, 60, 4, false, false);
                    player.addPotionEffect(potioneffect);}
                if (hppct > 0.0 && hppct < 0.20){
                    PotionEffect potioneffect = new PotionEffect(MobEffects.STRENGTH, 60, 8, false, false);
                    player.addPotionEffect(potioneffect);}
            }
        }*/

        if (!world.isRemote && this.data != null) {
            NBTTagCompound atag = is.getTagCompound();
            if (atag == null) atag = new NBTTagCompound();
            if (!atag.hasKey(KEY)) {
                atag.setBoolean(KEY, true);
                try {
                    is.setTagCompound(JsonToNBT.getTagFromJson(this.data));
                    //is.getTagCompound().merge(atag);
                } catch (NBTException nbtexception) {
                    LogManager.getLogger(RWBYModels.MODID).error("Couldn't load data tag for " + this.getRegistryName());
                }
            }
        }
    }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack is = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote && playerIn.isSneaking() && this.morph != null) {
            is = new ItemStack(Item.getByNameOrId(this.morph), is.getCount(), is.getMetadata());
            return new ActionResult<>(EnumActionResult.SUCCESS, is);
        }
        boolean flag = !this.findAmmo(playerIn, false).isEmpty();
        if (!flag) if (playerIn.onGround){
            if (recoil3) {
                Vec3d look = playerIn.getLookVec();
                playerIn.motionX = look.x;
                playerIn.motionZ = look.z;
                playerIn.motionY = look.y /1;
                playerIn.lastTickPosZ = -look.x;
                playerIn.lastTickPosX = -look.z;
            }}
        if (!flag) {if (emerald2)  { if (playerIn.collidedHorizontally){
            //PotionEffect potioneffect = new PotionEffect(MobEffects.JUMP_BOOST, 60, 5, false, false);
            Vec3d look = playerIn.getLookVec();
            playerIn.motionX = look.x/2;
            playerIn.motionZ = look.z/2;
            playerIn.motionY = look.y/2;
            playerIn.lastTickPosZ = -look.x;
            playerIn.lastTickPosX = -look.z;
            compensate = true;
            //playerIn.addPotionEffect(potioneffect);
            playerIn.fallDistance = 0;
        }}}

        ItemStack itemstack = playerIn.getHeldItem(handIn);
        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
        if (ret != null) return ret;

        if (!flag) {
            return new ActionResult<>(EnumActionResult.FAIL, itemstack);
        } else {
            if (charges) {
                playerIn.setActiveHand(handIn);
                return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);

            } else {
                this.onPlayerStoppedUsing(is, worldIn, playerIn, 0);
                return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
            }}
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BLOCK;
    }

    @Nonnull
    private ItemStack findAmmo(EntityPlayer player, boolean force) {
        Item ammo1 = this.ammo == null ? Items.ARROW : Item.getByNameOrId(this.ammo);
        if (force || (ammo1 instanceof ItemArrow && ((ItemArrow) ammo1).isInfinite(null, player.getActiveItemStack(), player))
                || (ammo1 instanceof RWBYAmmoItem && ((RWBYAmmoItem) ammo1).isInfinite(null, player.getActiveItemStack(), player)))
            return new ItemStack(ammo1);


        if (coco){}

        // the rest is a copy from ItemBow#findAmmo(EntityPlayer)
        if (this.isArrow(player.getHeldItem(EnumHand.OFF_HAND))) {
            return player.getHeldItem(EnumHand.OFF_HAND);
        } else if (this.isArrow(player.getHeldItem(EnumHand.MAIN_HAND))) {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        } else {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
                ItemStack itemstack = player.inventory.getStackInSlot(i);

                if (this.isArrow(itemstack)) {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }

    @Override
    //Thanks Bright_Spark//
    protected boolean isArrow(@Nonnull ItemStack stack) {
        String[] itemIds = ammo.split(",");
        for (int i = 0; i < itemIds.length; i++) {
            String item = itemIds[i];
            if (stack.getItem().getRegistryName().toString().equals(item))
                return true;
        }
        return false;
    }

    public int getItemEnchantability()
    {
        return 0;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) { // Mostly copied from ItemBow, with slight edits
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer) entityLiving;
            boolean flagger = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            boolean flag = false;
            ItemStack itemstack = this.findAmmo(entityplayer, flag);

            int i = this.getMaxItemUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, (EntityPlayer) entityLiving, i, itemstack != null);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag) {

                float f = getArrowVelocity(72);

                if ((double) f >= 0.1D) {

                    if (!worldIn.isRemote) {
                        EntityArrow entityarrow = (itemstack.getItem() instanceof RWBYAmmoItem ? ((RWBYAmmoItem) itemstack.getItem()).createArrow(worldIn, itemstack, entityplayer) : ((ItemArrow) Items.ARROW).createArrow(worldIn, itemstack, entityplayer));
                        entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F * (this.projectileSpeed == 0.0F ? 1.0F : this.projectileSpeed), 2.0F);

                        worldIn.spawnEntity(entityarrow);
                        //if (f >= 1.0F) entityarrow.setIsCritical(true);
                        if (jnr) {stack.damageItem(30,entityplayer);}
                        else stack.damageItem(1, entityplayer);
                    }

                    if (crescentr) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Crescent_Rose_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (emberc){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Ember_Celica_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (gambols) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Gambol_Shroud_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (mytre) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Mytrenaster_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (stormf){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.StormFlower_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (magna) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Magnhild_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (coco) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Ember_Celica_Shoot, SoundCategory.MASTER, 1.0F, 0.2F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (port) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Port_Shoot, SoundCategory.MASTER, 1.0F, 0.8F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (emerald) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Gambol_Shroud_Shoot, SoundCategory.MASTER, 1.0F, 0.7F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (jnr) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Junior_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (torch) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Torchwick_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (recoil) {
                    Vec3d look = entityplayer.getLookVec();
                    entityplayer.motionX = -look.x ;
                    entityplayer.motionZ = -look.z ;
                    entityplayer.motionY = -look.y/2 ;
                    entityplayer.lastTickPosZ = -look.x;
                    entityplayer.lastTickPosX = -look.z;
                    entityplayer.fallDistance = 0;}

                    if (recoil2) {
                        Vec3d look = entityplayer.getLookVec();
                        entityplayer.motionX = -look.x ;
                        entityplayer.motionZ = -look.z ;
                        entityplayer.motionY = -look.y/4 ;
                        entityplayer.lastTickPosZ = -look.x;
                        entityplayer.lastTickPosX = -look.z;}
                    if (!flag){if (cinder & !flagger) {itemstack.shrink(1);}}
                    if (!flag){if (mytre || emerald) {itemstack.damageItem(2, entityplayer);} else itemstack.damageItem(1, entityplayer);}
                }
            }
        }
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(1, attacker);
        return true;
    }

    @Override
    public String toString() {
        return "RWBYBow{" + this.getRegistryName() + "}";
    }

    @Override
    public boolean isRepairable() {
        return true;
    }


    /*public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        worldIn.getBlockStateAt(pos).getBlock()
    }*/

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == RWBYItems.scrap || super.getIsRepairable(toRepair, repair);
    }

}
