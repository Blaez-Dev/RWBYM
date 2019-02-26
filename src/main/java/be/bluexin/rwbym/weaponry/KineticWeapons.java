package be.bluexin.rwbym.weaponry;

import be.bluexin.rwbym.Init.RWBYCreativeTabs;
import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.RWBYSoundHandler;
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
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Iterator;
import java.util.List;

/**
 * Part of rwbym
 *
 * @author Bluexin
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class KineticWeapons extends ItemBow implements ICustomItem {

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
    private boolean gambols = false;
    private boolean magna = false;
    private boolean mytre = false;
    private boolean stormf = false;
    private boolean coco = false;
    private boolean velvet = false;
    private boolean maria = false;


    public KineticWeapons(String name, int durability, int drawSpeed, int enchantability, String data, String morph, String ammo, boolean noCharge, float projectileSpeed, boolean usesAmmo, int enchantmentglow, CreativeTabs creativetab) {
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
        if(enchantmentglow == 1) this.velvet = true;

        if(name.contains("mariascythe")) maria = true;

        if(name.contains("crescent")) crescentr = true;
        if(name.contains("gambol")) gambols = true;
        if(name.contains("ember")) emberc = true;
        if(name.contains("nora")) magna = true;
        if(name.contains("weiss")) mytre = true;
        if(name.contains("stormf")) stormf = true;
        if(name.contains("coco")) coco = true;
        if(name.contains("qrow")) emberc = true;
        if(name.contains("emberv")) emberc = true;


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


        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack iss = player.getHeldItemMainhand();
        if(iss.getItem() == RWBYItems.chatareusgun){
        AxisAlignedBB axisalignedbb = player.getEntityBoundingBox().grow(1,1,1);


        List<?> list1 = player.world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

        if (!list1.isEmpty())
        {
            Iterator<?> iterator = list1.iterator();

            double y = Math.pow(player.motionY, 2);
            double x = Math.pow(player.motionX, 2);
            double z = Math.pow(player.motionZ, 2);

            double d3 = Math.sqrt(x+y+z);
            float f = (float)d3;

            while (iterator.hasNext())
            {
                EntityLivingBase entitylivingbase = (EntityLivingBase)iterator.next();
                entitylivingbase.attackEntityFrom(DamageSource.FLY_INTO_WALL, f*100);
            }
        }}}


        if (!world.isRemote && this.data != null) {
            NBTTagCompound atag = is.getTagCompound();
            if (atag == null) atag = new NBTTagCompound();
            if (!atag.hasKey(KEY)) {
                atag.setBoolean(KEY, true);
                try {
                    is.setTagCompound(JsonToNBT.getTagFromJson(this.data));
                    is.getTagCompound().merge(atag);
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
        ItemStack itemstack = playerIn.getHeldItem(handIn);
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

        if (!flag) {if (maria)  { if (playerIn.collidedHorizontally){
            Vec3d look = playerIn.getLookVec();
            playerIn.motionX = look.x/2;
            playerIn.motionZ = look.z/2;
            playerIn.motionY = look.y/2;
            playerIn.lastTickPosZ = -look.x;
            playerIn.lastTickPosX = -look.z;
            playerIn.fallDistance = 0;
        }}}

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
            }
        }
    }



    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.NONE;
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
            boolean flag = false;
            ItemStack itemstack = this.findAmmo(entityplayer, flag);

            int i = this.getMaxItemUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, (EntityPlayer) entityLiving, i, itemstack != null);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag) {

                float f = getArrowVelocity(72);

                if ((double) f >= 0.1D) {

                    if (!worldIn.isRemote) {
                        EntityArrow entityarrow = (itemstack.getItem() instanceof ItemArrow ? ((ItemArrow) itemstack.getItem()).createArrow(worldIn, itemstack, entityplayer) : itemstack.getItem() instanceof RWBYAmmoItem ? ((RWBYAmmoItem) itemstack.getItem()).createArrow(worldIn, itemstack, entityplayer) : ((ItemArrow) Items.ARROW).createArrow(worldIn, itemstack, entityplayer));
                        entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F * (this.projectileSpeed == 0.0F ? 1.0F : this.projectileSpeed), 0.0F);

                        //if (f >= 1.0F) entityarrow.setIsCritical(true);


                        stack.damageItem(1, entityplayer);


                        worldIn.spawnEntity(entityarrow);
                    }

                    if (crescentr) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Crescent_Rose_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (maria) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Mytrenaster_Shoot, SoundCategory.MASTER, 1.0F, 0.5F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if(maria && !entityplayer.onGround){
                        Vec3d look = entityplayer.getLookVec();
                        entityplayer.motionX = look.x;
                        entityplayer.motionZ = look.z;
                        entityplayer.motionY = look.y *2;
                        entityplayer.lastTickPosZ = -look.x;
                        entityplayer.lastTickPosX = -look.z;
                        entityplayer.fallDistance = 0;
                    }

                    if (!flag){if (mytre) {itemstack.damageItem(2, entityplayer);} else itemstack.damageItem(1, entityplayer);}
                }
            }
        }
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {

        for (EntityLivingBase entitylivingbase : attacker.world.getEntitiesWithinAABB(EntityLivingBase.class, target.getEntityBoundingBox().grow(3.0D, 0.25D, 3.0D))) {
            if (entitylivingbase != attacker && entitylivingbase != target && !attacker.isOnSameTeam(entitylivingbase) && attacker.getDistanceSq(entitylivingbase) < 9.0D) {
                entitylivingbase.knockBack(attacker, 0.4F, (double) MathHelper.sin(attacker.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(attacker.rotationYaw * 0.017453292F)));
                entitylivingbase.attackEntityFrom(DamageSource.GENERIC, 8);
            }
        }

        attacker.world.playSound((EntityPlayer) null, attacker.posX, attacker.posY, attacker.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, attacker.getSoundCategory(), 1.0F, 1.0F);

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


    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == RWBYItems.scrap || super.getIsRepairable(toRepair, repair);
    }

}