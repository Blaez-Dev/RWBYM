package io.github.blaezdev.rwbym.weaponry;

import com.google.common.collect.Multimap;
import io.github.blaezdev.rwbym.Init.RWBYItems;
import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;

/**
 * Part of rwbym
 *
 * @author Bluexin
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class RWBYCutGem extends ItemBow implements ICustomItem {
    private static final UUID MovementSpeed = UUID.fromString("cc4c54bc-46d5-11ea-b77f-2e728ce88125");
    private static final UUID Defence = UUID.fromString("cc4c5714-46d5-11ea-b77f-2e728ce88125");
    private static  final UUID Vitality = UUID.fromString("cc4c591c-46d5-11ea-b77f-2e728ce88125");
    private static final  UUID Attackboost = UUID.fromString("cc4c5b24-46d5-11ea-b77f-2e728ce88125");
    private static final UUID Knockback = UUID.fromString("cc4c5d90-46d5-11ea-b77f-2e728ce88125");
    private static final UUID Attackspeed = UUID.fromString("cc4c5ee4-46d5-11ea-b77f-2e728ce88125");
    private final int drawSpeed;
    private final String ammo;
    private final float projectileSpeed;
    private final boolean charges;
    public int element;


    private float movementspeedmult;
    private float armourbuff;
    private float healthbuff;
    private float attackboost;
    private float knockbackresist;
    private float attackspeed;

    public static final int HARDLIGHT =       0x0001;
    public static final int WATER =           0x0002;
    public static final int IMPURE =          0x0004;
    public static final int WIND =            0x0008;
    public static final int FIRE =            0x0010;
    public static final int GRAVITY =         0x0020;
    public static final int LIGHTNING =       0x0040;
    public static final int ICE =             0x0080;
    public static final int NONE =            0x0100;

    public RWBYCutGem(String name, int drawSpeed, int element, String ammo, boolean noCharge, float projectileSpeed, CreativeTabs creativetab) {
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(creativetab);
        this.drawSpeed = drawSpeed;
        this.ammo = ammo;
        this.projectileSpeed = projectileSpeed;
        this.charges = !noCharge;
        this.maxStackSize = 64;
        this.setMaxDamage(0);
        this.element = element;
        if((element & WATER) != 0) {
            movementspeedmult = 0;
            armourbuff = 0;
            healthbuff = 0;
            attackboost = -0.45F;
            knockbackresist = 0;
            attackspeed = 0;
        }
        else if((element & IMPURE) != 0){
            movementspeedmult = 0;
            armourbuff = 0;
            healthbuff = -0.7F;
            attackboost = 0;
            knockbackresist = 0;
            attackspeed = 0;
        }
        else if ((element & WIND) != 0){
            movementspeedmult = 1.7F;
            armourbuff = 0;
            healthbuff = -0.7F;
            attackboost = 0;
            knockbackresist = 0;
            attackspeed = 0;
        }
        else if((element & FIRE) != 0){
            movementspeedmult = 0;
            armourbuff = 0;
            healthbuff = -0.7F;
            attackboost = 2.3F;
            knockbackresist = 0;
            attackspeed = 0;
        }
        else if((element & GRAVITY) != 0){
            movementspeedmult = 0;
            armourbuff = 0;
            healthbuff = -0.7F;
            attackboost = 0;
            knockbackresist = 0;
            attackspeed = 0;
        }
        else if((element & LIGHTNING) != 0){
            if(RWBYConfig.general.lightningdustlimiter){
            movementspeedmult = 0.75F;
            armourbuff = 0;
            healthbuff = -0.4F;
            attackboost = 0;
            knockbackresist = 0;
            attackspeed = 2.5F;}else{
                movementspeedmult = 0.75F;
                armourbuff = 0;
                healthbuff = -0.4F;
                attackboost = 0;
                knockbackresist = 0;
                attackspeed = 2.5F;
            }
        }else if((element & ICE) != 0){
            movementspeedmult = -0.5F;
            armourbuff = 0;
            healthbuff = 1.5F;
            attackboost = 0;
            knockbackresist = 0;
            attackspeed = 0;
        }else if((element & HARDLIGHT) != 0){
            movementspeedmult = 0.2F;
            armourbuff = 0.2F;
            healthbuff = 0;
            attackboost = -0.2F;
            knockbackresist = 1F;
            attackspeed = 0;
        }else{
            movementspeedmult = 0;
            armourbuff = 0;
            healthbuff = 0;
            attackboost = 0F;
            knockbackresist = 0;
            attackspeed = 0;
        }
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }


    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return this.drawSpeed;
    }


    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
            return false;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void onUpdate(ItemStack is, World world, Entity entity, int slotIn, boolean inHand) {
        if(entity instanceof EntityPlayer){
            final EntityPlayer player = (EntityPlayer)entity;
            player.setHealth(player.getHealth());
            int timer = 0;
            if(player.getHeldItem(EnumHand.OFF_HAND) == is && (element & GRAVITY) != 0){
                if (!player.onGround)
                {
                    player.motionY += 0.05;
                    player.fallDistance = 0;
                    //player.velocityChanged = true;
                }
                if(!player.onGround && player.isSneaking() && timer == 0){
                    PotionEffect potioneffect = new PotionEffect(MobEffects.LEVITATION, 60, 1, false, false);
                    player.addPotionEffect(potioneffect);
                    timer = 20;
                }
                timer ++;
            }
            if(player.getHeldItem(EnumHand.OFF_HAND) == is && (element & WATER) != 0){
                if(player.isInWater()){
                PotionEffect potioneffect = new PotionEffect(MobEffects.WATER_BREATHING, 60, 1, false, false);
                player.addPotionEffect(potioneffect);}
                player.heal(0.02F);
            }
        }
    }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack is = playerIn.getHeldItem(handIn);
        boolean flag = !this.findAmmo(playerIn, false).isEmpty();


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
        if(stack.getItem() == RWBYItems.chatareusgun){
            return EnumAction.BOW;
        }else if(stack.getItem() == RWBYItems.cinderbow){
            return EnumAction.BOW;
        }else return EnumAction.BLOCK;
    }

    @Nonnull
    private ItemStack findAmmo(EntityPlayer player, boolean force) {
        Item ammo1 = this.ammo == null ? Items.ARROW : Item.getByNameOrId(this.ammo);
        if (force || (ammo1 instanceof ItemArrow && ((ItemArrow) ammo1).isInfinite(null, player.getActiveItemStack(), player))
                || (ammo1 instanceof RWBYAmmoItem && ((RWBYAmmoItem) ammo1).isInfinite())) {
            return new ItemStack(ammo1);
        }

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
                        EntityArrow entityarrow = (itemstack.getItem() instanceof RWBYAmmoItem ? ((RWBYAmmoItem) itemstack.getItem()).createArrow(worldIn, itemstack, stack, entityplayer) : ((ItemArrow) Items.ARROW).createArrow(worldIn, itemstack, entityplayer));
                        entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F * (this.projectileSpeed == 0.0F ? 1.0F : this.projectileSpeed), 2.0F);

                        entityarrow.setIsCritical(true);

                        worldIn.spawnEntity(entityarrow);
                        //if (f >= 1.0F) entityarrow.setIsCritical(true);
                        stack.shrink(1);
                    }
                }
            }
        }
    }


    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.OFFHAND)
        {
            multimap.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(Defence, "Armor modifier", (double)this.armourbuff, 2));
            multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(MovementSpeed, "Movement Speed", (double)movementspeedmult, 2));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(Attackspeed, "Attack Speed", (double)attackspeed, 2));
            multimap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(Knockback, "Knockback", (double)knockbackresist, 2));
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(Attackboost, "Attack Boost", (double)attackboost, 2));
            multimap.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(Vitality, "Health", (double)healthbuff, 2));
        }

        return multimap;
    }


    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(1, attacker);
        return true;
    }

    @Override
    public String toString() {
        return "RWBYCutGem{" + this.getRegistryName() + "}";
    }

    @Override
    public boolean isRepairable() {
        return true;
    }


    @Override
    public int getItemBurnTime(ItemStack itemStack) {

            return 1200;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == RWBYItems.scrap || super.getIsRepairable(toRepair, repair);
    }

}
