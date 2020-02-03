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

import static io.github.blaezdev.rwbym.weaponry.ArmourBase.*;

/**
 * Part of rwbym by Bluexin.
 *
 * @author Bluexin
 */
public class RWBYHood extends Item implements ICustomItem {
    private static final UUID ARMOR_MODIFIERS = UUID.fromString("f69106a2-41b5-11ea-b77f-2e728ce88125");
    private static final UUID MovementSpeed = UUID.fromString("9bf90946-4323-11ea-b77f-2e728ce88125");
    private static final UUID Defence = UUID.fromString("e98e5e52-4325-11ea-b77f-2e728ce88125");
    private static  final UUID Vitality = UUID.fromString("0ad15896-4324-11ea-b77f-2e728ce88125");
    private static final  UUID Attackboost = UUID.fromString("308559ac-4324-11ea-b77f-2e728ce88125");
    private static final UUID Knockback = UUID.fromString("501ed202-4324-11ea-b77f-2e728ce88125");
    private static final UUID Attackspeed = UUID.fromString("60115e46-4324-11ea-b77f-2e728ce881");
    private boolean ismask;
    //private final String data;
    private final String morph;
    final int damageReduce;
    final float tough;

    public int armourperks;

    private final float movementspeedmult;
    private final float armourbuff;
    private final float healthbuff;
    private final float attackboost;
    private final float knockbackresist;
    private final float attackspeed;

    public RWBYHood(String name, boolean isMask,String morph,CreativeTabs creativetab, int armourperks) {
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);
        this.ismask = isMask;
        this.morph = morph;
        this.armourperks = armourperks;
        if(isMask){
            if(name.contains("summer")){this.damageReduce = 7;
                this.tough = 0;}else {
                this.damageReduce = 6;
                this.tough = 0;}
        }else {this.tough = 0; this.damageReduce = 0;}
        this.setMaxDamage(2500);
        if(this.ismask){
            maxStackSize = 1;
        }
        this.setCreativeTab(creativetab);

        if((armourperks & MOVEMENTSPEED1) != 0){movementspeedmult =0.05F;}
        else if((armourperks & MOVEMENTSPEED2) != 0){movementspeedmult =0.1F;}
        else{movementspeedmult = 0;}

        if((armourperks & DEFENSE1) != 0){armourbuff = 0.1F;}
        else if((armourperks & DEFENSE2) != 0){armourbuff = 0.2F;}
        else{armourbuff = 0;}

        if((armourperks & VITALITY1) != 0){healthbuff = 0.1F;}
        else if((armourperks & VITALITY2) != 0){healthbuff = 0.2F;}
        else if((armourperks & VITALITY3) != 0){healthbuff = 0.3F;}
        else{healthbuff = 0;}

        if((armourperks & ATTACKBOOST1) != 0){attackboost = 0.025F;}
        else if((armourperks & ATTACKBOOST2) != 0){attackboost = 0.05F;}
        else if((armourperks & ATTACKBOOST3) != 0){attackboost = 0.075F;}
        else if((armourperks & ATTACKBOOST4) != 0){attackboost = 0.1F;}
        else{attackboost = 0;}

        if((armourperks & RUSH1) != 0){attackspeed = 0.05F;}
        else if((armourperks & RUSH2) != 0){attackspeed = 0.1F;}
        else{attackspeed = 0;}

        if((armourperks & FOOTING1) != 0){knockbackresist = 0.25F;}
        else if((armourperks & FOOTING2) != 0){knockbackresist = 0.50F;}
        else{knockbackresist = 0;}
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.HEAD)
        {
            multimap.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(ARMOR_MODIFIERS, "Armor modifier", (double)this.damageReduce, 0));
            multimap.put(SharedMonsterAttributes.ARMOR_TOUGHNESS.getName(), new AttributeModifier(ARMOR_MODIFIERS, "Armor toughness", (double)this.tough, 0));
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