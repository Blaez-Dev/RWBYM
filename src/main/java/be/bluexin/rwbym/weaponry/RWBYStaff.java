package be.bluexin.rwbym.weaponry;

import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.RWBYModels;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
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
public class RWBYStaff extends ItemSword implements ICustomItem {
    public final boolean isShield;
    public final boolean canBlock;
    private final String data;
    //private final RecipeDTO[] recipes;
    private final String morph;
    private boolean fire;
    private boolean ice;
    private boolean gravity;
    private boolean water;
    private boolean lightning;
    private boolean wind;

    public RWBYStaff(String name, int durability, float damage, int enchantability, String data, String morph, boolean shield, boolean canBlock, CreativeTabs creativetab) {
        super(EnumHelper.addToolMaterial(RWBYModels.MODID + ":" + name, 0, durability, 1.0F, damage, enchantability));
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(creativetab);
        this.data = data;
        if(name.contains("ozmacanefire")) fire = true;
        if(name.contains("ozmacaneice")) ice = true;
        if(name.contains("ozmacanegravity")) gravity = true;
        if(name.contains("ozmacanewater")) water = true;
        if(name.contains("ozmacanelightning")) lightning = true;
        if(name.contains("ozmacanewind")) wind = true;

        this.morph = morph;
        this.canBlock = canBlock;
        this.isShield = shield;

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
        PotionEffect potioneffect = new PotionEffect(MobEffects.SLOWNESS, 200, 5, false, false);
        PotionEffect potioneffect2 = new PotionEffect(MobEffects.LEVITATION, 100, 5, false, false);
       if (fire){target.setFire(10);}
       if (ice){
           target.addPotionEffect(potioneffect);
       }
       if(gravity){
           target.addPotionEffect(potioneffect2);
       }
        stack.damageItem(1, attacker);
        return true;
    }



    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
            return false;
    }

    @SuppressWarnings("Duplicates")
    public void onUpdate(ItemStack is, World world, Entity entity, int slotIn, boolean inHand) {
        if(entity instanceof EntityPlayerMP){
            final EntityPlayerMP player = (EntityPlayerMP)entity;
            if(player.getHeldItem(EnumHand.MAIN_HAND) == is && gravity){
                if (!player.onGround)
                {
                    player.motionY *= 0.8;
                    player.fallDistance = 0;
                    player.velocityChanged = true;
                }
            }
            if(player.getHeldItem(EnumHand.MAIN_HAND) == is && water){

            }
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
        PotionEffect potioneffect1 = new PotionEffect(MobEffects.STRENGTH, 100, 5, false, false);
        PotionEffect potioneffect2 = new PotionEffect(MobEffects.LEVITATION, 100, 5, false, false);
        PotionEffect potionEffect3 = new PotionEffect(MobEffects.FIRE_RESISTANCE, 100, 5, false, false);
        PotionEffect potioneffect4 = new PotionEffect(MobEffects.REGENERATION, 100, 3, false, false);
        PotionEffect potioneffect5 = new PotionEffect(MobEffects.HASTE, 100, 5, false, false);
        PotionEffect potionEffect6 = new PotionEffect(MobEffects.SPEED, 100, 5, false, false);
        PotionEffect potionEffect7 = new PotionEffect(MobEffects.SPEED, 200, 7, false, false);
        if(hand == EnumHand.MAIN_HAND && playerIn.isSneaking()){
        if(gravity)
        {
         playerIn.addPotionEffect(potioneffect2);
        }
        if(fire)
        {
            playerIn.addPotionEffect(potioneffect1);
            playerIn.addPotionEffect(potionEffect3);
        }
        if(water){
            playerIn.addPotionEffect(potioneffect4);
        }
        if(lightning){
            playerIn.addPotionEffect(potioneffect5);
            playerIn.addPotionEffect(potionEffect6);
        }
        if(wind){
            playerIn.addPotionEffect(potionEffect7);
        }
        }
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
    public boolean isRepairable() {
        return true;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
      return repair.getItem() == RWBYItems.scrap || super.getIsRepairable(toRepair, repair);
    }

}
