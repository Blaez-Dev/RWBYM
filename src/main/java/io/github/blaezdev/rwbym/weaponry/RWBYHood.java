package io.github.blaezdev.rwbym.weaponry;

import com.google.common.collect.Multimap;
import io.github.blaezdev.rwbym.Init.RWBYCreativeTabs;
import io.github.blaezdev.rwbym.Init.RWBYItems;
import io.github.blaezdev.rwbym.RWBYModels;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;

import java.util.UUID;

/**
 * Part of rwbym by Bluexin.
 *
 * @author Bluexin
 */
public class RWBYHood extends Item implements ICustomItem {
    private static final UUID ARMOR_MODIFIERS = UUID.fromString("f69106a2-41b5-11ea-b77f-2e728ce88125");
    private static final UUID MovementSpeed = UUID.fromString("9bf90946-4323-11ea-b77f-2e728ce88125");
    private static  final UUID Vitality = UUID.fromString("0ad15896-4324-11ea-b77f-2e728ce88125");
    private static final  UUID Attackboost = UUID.fromString("308559ac-4324-11ea-b77f-2e728ce88125");
    private static final UUID Knockback = UUID.fromString("501ed202-4324-11ea-b77f-2e728ce88125");
    private static final UUID Attackspeed = UUID.fromString("60115e46-4324-11ea-b77f-2e728ce88125");
    private boolean ismask;
    //private final String data;
    private final String morph;
    final int damageReduce;
    final float tough;

    public int armourperks;

    public RWBYHood setArmourperks(int armourperks) {
        this.armourperks = armourperks;
        return this;
    }


    public RWBYHood(String name, boolean isMask,String morph,  CreativeTabs creativetab) {
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);
        this.ismask = isMask;
        this.morph = morph;
        if(isMask){
            if(name.contains("summer")){this.damageReduce = 10;
                this.tough = 0;}else {
                this.damageReduce = 6;
                this.tough = 0;}
        }else {this.tough = 0; this.damageReduce = 0;}
        this.setMaxDamage(2500);
        if(name.contains("summer")){

        }
        if(this.ismask){
            maxStackSize = 1;
        }
        this.setCreativeTab(creativetab);

    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.HEAD)
        {
            multimap.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(ARMOR_MODIFIERS, "Armor modifier", (double)this.damageReduce, 0));
            multimap.put(SharedMonsterAttributes.ARMOR_TOUGHNESS.getName(), new AttributeModifier(ARMOR_MODIFIERS, "Armor toughness", (double)this.tough, 0));
        }

        return multimap;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, net.minecraft.enchantment.Enchantment enchantment)
    {
        return enchantment.type.canEnchantItem(Items.DIAMOND_HELMET);
    }

    @Override
    public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
        if (ismask){if(armorType == EntityEquipmentSlot.HEAD) {
            return true;
        }else {
            return false;
        }}else {
            return false;}
    }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        ItemStack is = playerIn.getHeldItem(handIn);
        EntityEquipmentSlot entityequipmentslot = EntityEquipmentSlot.HEAD;
        ItemStack itemstack1 = playerIn.getItemStackFromSlot(entityequipmentslot);

        if (!worldIn.isRemote && playerIn.isSneaking() && this.morph != null&& playerIn.getHeldItemMainhand() == is) {
            is = new ItemStack(Item.getByNameOrId(this.morph), is.getCount(), is.getMetadata());
            return new ActionResult<>(EnumActionResult.SUCCESS, is);
        } else if (itemstack1.isEmpty() && ismask &&  !playerIn.isSneaking())
        {
            playerIn.setItemStackToSlot(entityequipmentslot, itemstack.copy());
            itemstack.setCount(0);
            return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
        }
        else
        {
            return new ActionResult<>(EnumActionResult.FAIL, itemstack);
        }
    }



    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return true;
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

    @Override
    public boolean isRepairable() {
        return true;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == RWBYItems.scrap || super.getIsRepairable(toRepair, repair);
    }
}