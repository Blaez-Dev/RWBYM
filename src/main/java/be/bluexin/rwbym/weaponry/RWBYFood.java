package be.bluexin.rwbym.weaponry;

import be.bluexin.rwbym.Init.RWBYCreativeTabs;
import be.bluexin.rwbym.Init.RWBYPotions;
import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.capabilities.Blake.Blake;
import be.bluexin.rwbym.capabilities.Blake.BlakeProvider;
import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ISemblance;
import be.bluexin.rwbym.capabilities.Weiss.WeissProvider;
import be.bluexin.rwbym.capabilities.Yang.YangProvider;
import be.bluexin.rwbym.capabilities.Ruby.RubyProvider;
import be.bluexin.rwbym.entity.EntityArmorgeist;
import be.bluexin.rwbym.entity.EntityAtlasKnight;
import be.bluexin.rwbym.entity.EntityBeowolf;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;

import static be.bluexin.rwbym.capabilities.CapabilityHandler.getCapabilityByName;

/**
 * Part of rwbym by Bluexin.
 *
 * @author Bluexin
 */
public class RWBYFood extends Item implements ICustomItem {

    private final String data;
    private boolean alwaysEdible;
    private int food;
    private boolean food6;


    public RWBYFood(String name,String data,int food, CreativeTabs creativetab) {
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);
        this.data = data;
        this.setCreativeTab(creativetab);
        this.alwaysEdible = true;
        this.setMaxDamage(3);
        this.food = food;
        this.maxStackSize = 2;
        if(food == 2||food == 6|| food == 7||food ==9){
            this.food6 = true;
        }
        if(food6){
            maxStackSize = 1;
        }
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void onUpdate(ItemStack is, World world, Entity entity, int slotIn, boolean inHand) {
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

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            //this.onFoodEaten(stack, worldIn, entityplayer);
            if(food == 1){
                //Hot Chocolate
                PotionEffect potioneffect = new PotionEffect(MobEffects.REGENERATION, 1200, 0, false, false);
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.HEALTH_BOOST, 1200, 0, false, false);
                entityplayer.addPotionEffect(potioneffect);
                entityplayer.addPotionEffect(potioneffect1);
            }
            if(food == 2){
                //Coffee
                PotionEffect potioneffect = new PotionEffect(MobEffects.SPEED, 1200, 1, false, false);
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.HASTE, 1200, 1, false, false);
                entityplayer.addPotionEffect(potioneffect);
                entityplayer.addPotionEffect(potioneffect1);
            }
            if(food == 3){
                //Strawberry Sunrise
                PotionEffect potioneffect = new PotionEffect(MobEffects.SPEED, 1200, 1, false, false);
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.RESISTANCE, 1200, 1, false, false);
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.STRENGTH, 1200, 2, false, false);
                entityplayer.addPotionEffect(potioneffect);
                entityplayer.addPotionEffect(potioneffect1);
                entityplayer.addPotionEffect(potioneffect2);
            }
            if(food == 4){
                //Grape Soda
                PotionEffect potioneffect = new PotionEffect(MobEffects.HASTE, 1200, 3, false, false);
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.INSTANT_HEALTH, 20, 0, false, false);
                entityplayer.addPotionEffect(potioneffect);
                entityplayer.addPotionEffect(potioneffect1);
            }
            if(food == 5){
                //TorchQuick
                PotionEffect potioneffect = new PotionEffect(MobEffects.BLINDNESS, 1200, 1, false, false);
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.WEAKNESS, 1200, 1, false, false);
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.POISON, 1200, 2, false, false);
                entityplayer.addPotionEffect(potioneffect);
                entityplayer.addPotionEffect(potioneffect1);
                entityplayer.addPotionEffect(potioneffect2);
            }
            if(food == 6){
                //Qrow's Flask
                PotionEffect potioneffect = new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 0, false, false);
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.NAUSEA, 200, 1, false, false);
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.UNLUCK, 3600, 2, false, false);
                PotionEffect potioneffect3 = new PotionEffect(MobEffects.SATURATION, 5, 0, false, false);
                entityplayer.addPotionEffect(potioneffect);
                entityplayer.addPotionEffect(potioneffect1);
                entityplayer.addPotionEffect(potioneffect2);
                entityplayer.addPotionEffect(potioneffect3);
            }
            if(food == 7){
                //Sake
                PotionEffect potioneffect = new PotionEffect(MobEffects.NAUSEA, 100, 3, false, false);
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.INVISIBILITY, 1200, 2, false, false);
                entityplayer.addPotionEffect(potioneffect);
                entityplayer.addPotionEffect(potioneffect1);
            }
            if(food == 8){
                //Coconut Milk
                PotionEffect potioneffect = new PotionEffect(MobEffects.SPEED, 1200, 2, false, false);
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.JUMP_BOOST, 1200, 2, false, false);
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.WATER_BREATHING, 1200, 3, false, false);
                PotionEffect potioneffect3 = new PotionEffect(MobEffects.NIGHT_VISION, 1200, 2, false, false);
                entityplayer.addPotionEffect(potioneffect);
                entityplayer.addPotionEffect(potioneffect1);
                entityplayer.addPotionEffect(potioneffect2);
                entityplayer.addPotionEffect(potioneffect3);
            }

            if(food == 9){
                //Pancakes
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.SATURATION, 60, 5, false, false);
                entityplayer.addPotionEffect(potioneffect2);;
                PotionEffect potioneffect21 = new PotionEffect(MobEffects.LUCK, 2400, 5, false, false);
                entityplayer.addPotionEffect(potioneffect21);;
            }
        }
        if(food6){
            stack.damageItem(1, entityLiving);
        }
        if(!food6){
        stack.shrink(1);}
        return stack;
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if(!worldIn.isRemote){
            
        }

    }

    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }

    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.EAT;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (playerIn.canEat(this.alwaysEdible)) {
            playerIn.setActiveHand(handIn);
            return new ActionResult(EnumActionResult.SUCCESS, itemstack);
        } else {
            return new ActionResult(EnumActionResult.FAIL, itemstack);
        }
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    public int getItemEnchantability()
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return false;
    }

    @Override
    public String toString() {
        return "RWBYItem{" + this.getRegistryName() + "}";
    }
}
