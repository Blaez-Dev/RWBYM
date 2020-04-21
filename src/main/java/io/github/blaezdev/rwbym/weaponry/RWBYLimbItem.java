package io.github.blaezdev.rwbym.weaponry;

import io.github.blaezdev.rwbym.Init.RWBYCreativeTabs;
import io.github.blaezdev.rwbym.RWBYModels;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

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
        this.setCreativeTab(RWBYCreativeTabs.tab_rwbylimbs);
        this.maxStackSize = 64;
        this.name = name;
        this.slot = slot;

        if(name.contains("kag")){
            this.setCreativeTab(null);
        }

        this.addPropertyOverride(new ResourceLocation("inv"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return worldIn == null || entityIn != null && entityIn.getHeldItemOffhand() == stack ||  entityIn != null && entityIn.getHeldItemMainhand() == stack ? 1.0F : 0.0F;
            }
        });
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
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
    	if (!worldIn.isRemote) {
	        NBTTagCompound nbt1 = new NBTTagCompound();
	        NBTTagCompound nbt2 = new NBTTagCompound();
	        if(name.contains("clear")){
	            nbt2.setString(slot, "");
                nbt1.setTag("rwbym", nbt2);
                entityLiving.getEntityData().merge(nbt1);
                NBTTagCompound nbt3 = entityLiving.getEntityData();
            }else {
	        nbt2.setString(slot,  this.getRegistryName().toString());
	        nbt1.setTag("rwbym", nbt2);
	        entityLiving.getEntityData().merge(nbt1);
	        NBTTagCompound nbt3 = entityLiving.getEntityData();}
    	}
        stack.shrink(1);
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

