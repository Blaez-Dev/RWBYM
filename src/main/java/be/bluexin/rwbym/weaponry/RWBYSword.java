package be.bluexin.rwbym.weaponry;

import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.RWBYModels;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Part of rwbym
 *
 * @author Bluexin
 */
@MethodsReturnNonnullByDefault
public class RWBYSword extends ItemSword implements ICustomItem {
    public final boolean isShield;
    public boolean neo = false;
    public final boolean canBlock;
    private final String data;
    //private final RecipeDTO[] recipes;
    private final String morph;
    private boolean fire;
    private boolean ice;
    private boolean velvet = false;
    private boolean crescentr = false;
    private boolean kkfire = false;
    private boolean kkice = false;
    private boolean kkwind = false;
    public static boolean runhideevent = false;
    private int timer;
    private boolean magna = false;


    public RWBYSword(String name, int durability, float damage, int enchantability, String data, String morph, boolean shield, boolean canBlock, boolean fire, boolean ice, int enchantmentglow, CreativeTabs creativetab) {
        super(EnumHelper.addToolMaterial(RWBYModels.MODID + ":" + name, 0, durability, 1.0F, damage, enchantability));
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(creativetab);
        this.data = data;
        if(name.contains("nora")) magna = true;
        if(name.contains("kkfire")) kkfire = true;
        if(name.contains("kkice")) kkice = true;
        if(name.contains("kkwind")) kkwind = true;
        //this.recipes = from.getRecipes();
        if(name.contains("crescent")) crescentr = true;
        if(name.contains("neoumb_closed")) neo = true;
        if(name.contains("neoumb_closed_blade")) neo = true;
        if(name.contains("neoumb_handle_blade")) neo = true;

        this.morph = morph;
        this.fire = fire;
        this.ice = ice;
        this.canBlock = canBlock;
        this.isShield = shield;
        if(enchantmentglow == 1) this.velvet = true;

        if (this.neo) this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });

        if (this.isShield) this.addPropertyOverride(new ResourceLocation("offhand"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            @ParametersAreNonnullByDefault
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.getHeldItemOffhand() == stack ? 1.0F : 0.0F;
            }
        });
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        PotionEffect potioneffect = new PotionEffect(MobEffects.SLOWNESS, 200, 5, true, true);
       if (fire){target.setFire(10);}
       if (ice){
           target.addPotionEffect(potioneffect);
       }
        /*if (crescentr && !attacker.onGround){
            for (EntityLivingBase entitylivingbase : attacker.world.getEntitiesWithinAABB(EntityLivingBase.class, target.getEntityBoundingBox().grow(3.0D, 0.25D, 3.0D))) {
                if (entitylivingbase != attacker && entitylivingbase != target && !attacker.isOnSameTeam(entitylivingbase) && attacker.getDistanceSq(entitylivingbase) < 9.0D) {
                    entitylivingbase.knockBack(attacker, 0.4F, (double) MathHelper.sin(attacker.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(attacker.rotationYaw * 0.017453292F)));
                    entitylivingbase.attackEntityFrom(DamageSource.GENERIC, getAttackDamage());
                }
            }

            attacker.world.playSound((EntityPlayer) null, attacker.posX, attacker.posY, attacker.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, attacker.getSoundCategory(), 1.0F, 1.0F);
        }*/
        stack.damageItem(1, attacker);
        return true;
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
    public void onUpdate(ItemStack is, World world, Entity entity, int slotIn, boolean inHand) {

        if(entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (kkfire){if(player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == RWBYItems.korekosmoufire){
                ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
                    is.setItemDamage(chest.getItemDamage());
                    chest.setItemDamage(is.getItemDamage());}
                else{is.damageItem(365, player);
            }}
        }
        if(entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (kkice){if(player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == RWBYItems.korekosmouwater){
                ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
                is.setItemDamage(chest.getItemDamage());
                chest.setItemDamage(is.getItemDamage());}
            else{is.damageItem(365, player);
            }}
        }
        if(entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (kkwind){if(player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == RWBYItems.korekosmouwind){
                ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
                is.setItemDamage(chest.getItemDamage());
                chest.setItemDamage(is.getItemDamage());}
            else{is.damageItem(365, player);
            }}
        }
        if (!world.isRemote && this.data != null) {
            NBTTagCompound atag = is.getTagCompound();
            if (atag == null) atag = new NBTTagCompound();
            if (!atag.hasKey(KEY)) {
                atag.setBoolean(KEY, true);
                is.setTagCompound(atag);

                try {
                    is.setTagCompound(JsonToNBT.getTagFromJson(this.data));
                    is.getTagCompound().setBoolean(KEY, true);
                } catch (NBTException nbtexception) {
                    LogManager.getLogger(RWBYModels.MODID).error("Couldn't load data tag for " + this.getRegistryName());
                }
            }

        }
    }


    @ParametersAreNonnullByDefault
    @Override
    public ActionResult<ItemStack> onItemRightClick( World worldIn, EntityPlayer playerIn, EnumHand hand) {
        ItemStack is = playerIn.getHeldItem(hand);
        if (!worldIn.isRemote && playerIn.isSneaking() && this.morph != null) {
            is = new ItemStack(Item.getByNameOrId(this.morph), is.getCount(), is.getMetadata());
            return new ActionResult<>(EnumActionResult.SUCCESS, is);
        } else if (this.isShield && hand == EnumHand.OFF_HAND) {
            playerIn.setActiveHand(EnumHand.OFF_HAND);
            return new ActionResult<>(EnumActionResult.SUCCESS, is);
        }else if (canBlock && hand == EnumHand.MAIN_HAND) {
            playerIn.setActiveHand(EnumHand.MAIN_HAND);
            return new ActionResult<>(EnumActionResult.SUCCESS, is);
        }else return ActionResult.newResult(EnumActionResult.FAIL, is);}

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    public int getItemEnchantability()
    {
        return 0;
    }


    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return this.isShield ? 72000 : this.canBlock ? 72000 : 0;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return this.isShield ? EnumAction.BLOCK : this.canBlock ? EnumAction.BLOCK :EnumAction.NONE;
    }


    @Override
    public String toString() {
        return "RWBYSword{" + this.getRegistryName() + "}";
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (kkfire || kkwind || kkice){
            ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
            chest.damageItem(1, player);
    }
        return super.onLeftClickEntity(stack, player, entity);
    }


    @Override
    public boolean isRepairable() {
        if (kkice || kkfire || kkwind){return false;}
        else return true;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        if (kkice || kkfire || kkwind){return false;}
        else return repair.getItem() == RWBYItems.scrap || super.getIsRepairable(toRepair, repair);
    }

}
