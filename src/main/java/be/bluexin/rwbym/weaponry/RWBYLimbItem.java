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
import be.bluexin.rwbym.utility.RegUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
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
public class RWBYLimbItem extends Item implements ICustomItem {

    private String name;
    private String slot;


    public RWBYLimbItem(String name, String slot) {
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);
        this.maxStackSize = 1;
        this.name = name;
        this.slot = slot;
    }


    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }

    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (playerIn.getHeldItemMainhand() == itemstack) {
            playerIn.setActiveHand(handIn);
            return new ActionResult(EnumActionResult.SUCCESS, itemstack);
        } else {
            return new ActionResult(EnumActionResult.FAIL, itemstack);
        }
    }


    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        NBTTagCompound nbt1 = new NBTTagCompound();
        NBTTagCompound nbt2 = new NBTTagCompound();
        nbt2.setString(slot,  this.getRegistryName().toString());
        nbt1.setTag("rwbym", nbt2);
        player.getEntityData().merge(nbt1);
        
        NBTTagCompound nbt3 = player.getEntityData();
        
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
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

