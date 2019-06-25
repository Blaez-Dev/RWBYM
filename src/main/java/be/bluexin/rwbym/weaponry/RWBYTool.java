package be.bluexin.rwbym.weaponry;

import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.RWBYModels;
import com.google.common.collect.Sets;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.settings.KeyBindingMap;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Set;

/**
 * Part of rwbym
 *
 * @author Bluexin
 */
@MethodsReturnNonnullByDefault
public class RWBYTool extends ItemSword implements ICustomItem {
    public final boolean canBlock;
    private final String data;
    private boolean velvet = false;



    public RWBYTool(String name, int durability, float damage, int enchantability, String data, String morph, boolean shield, boolean canBlock, boolean fire, boolean ice, int enchantmentglow, CreativeTabs creativetab) {
        super(EnumHelper.addToolMaterial(RWBYModels.MODID + ":" + name, 2, durability, 0.5F, damage, enchantability));
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(creativetab);
        this.data = data;
        this.canBlock = canBlock;
        if(enchantmentglow == 1) this.velvet = true;
    }

    @Override
    public boolean canHarvestBlock(IBlockState blockIn)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        if(velvet){return true;}
        else
            return false;
    }

    @SuppressWarnings("Duplicates")
    public void onUpdate(ItemStack is, World world, Entity entity, int slotIn, boolean inHand) {

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
         if (canBlock && hand == EnumHand.MAIN_HAND) {
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
    public String toString() {
        return "RWBYTool{" + this.getRegistryName() + "}";
    }


    @Override
    public boolean isRepairable() {
    return true;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
         return repair.getItem() == RWBYItems.scrap || super.getIsRepairable(toRepair, repair);
    }
    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return  this.canBlock ? 72000: 0;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return this.canBlock ? EnumAction.BLOCK  : EnumAction.NONE;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        return 5F;
    }
}

