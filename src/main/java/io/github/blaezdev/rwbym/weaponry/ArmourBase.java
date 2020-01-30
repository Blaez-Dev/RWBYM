package io.github.blaezdev.rwbym.weaponry;

import com.google.common.collect.Multimap;
import io.github.blaezdev.rwbym.Init.RWBYItems;
import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.ModelArmor;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;

import javax.annotation.ParametersAreNonnullByDefault;

import java.util.UUID;

import static io.github.blaezdev.rwbym.weaponry.ICustomItem.KEY;

public class ArmourBase extends ItemArmor {
    private static final UUID ARMOR_MODIFIERS = UUID.fromString("f69106a2-41b5-11ea-b77f-2e728ce88125");
    private static final UUID MovementSpeed = UUID.fromString("9bf90946-4323-11ea-b77f-2e728ce88125");
    private static final UUID Defence = UUID.fromString("e98e5e52-4325-11ea-b77f-2e728ce88125");
    private static  final UUID Vitality = UUID.fromString("0ad15896-4324-11ea-b77f-2e728ce88125");
    private static final  UUID Attackboost = UUID.fromString("308559ac-4324-11ea-b77f-2e728ce88125");
    private static final UUID Knockback = UUID.fromString("501ed202-4324-11ea-b77f-2e728ce88125");
    private static final UUID Attackspeed = UUID.fromString("60115e46-4324-11ea-b77f-2e728ce881");
    private boolean fire = false;
    private boolean ice = false;
    private boolean wind = false;
    private boolean isPlayerModel;
    private final String morph;
    final int damageReduce;
    final float tough;
    public int armourperks;

    private float movementspeedmult;
    private float armourbuff;
    private float healthbuff;
    private float attackboost;
    private float knockbackresist;
    private float attackspeed;


    public static final int MOVEMENTSPEED1 =        0x0001; //( 2tiers)  5%,10%  of increased movement speed
    public static final int MOVEMENTSPEED2 =        0x0002;
    public static final int DEFENSE1 =              0x0004; //(4 Tiers)  4%,6%, 8%,10% of reduced damage
    public static final int DEFENSE2 =              0x0010;
    public static final int VITALITY1 =             0x0020; //(3 Tiers)  10%,20%,30%  of increased health
    public static final int VITALITY2 =             0x0040;
    public static final int VITALITY3 =             0x0080;
    public static final int ATTACKBOOST1 =          0x0100; //(4 Tiers)   2.5%,5%, 7.5%,10% increased damage
    public static final int ATTACKBOOST2 =          0x0200;
    public static final int ATTACKBOOST3 =          0x0400;
    public static final int ATTACKBOOST4 =          0x0800;
    public static final int NIGHTVISION =           0x1000; // Night Vision
    public static final int JUMPBOOST1 =            0x2000; //(3 Tiers)   1/2 a block, full block, 1 1/2 blocks of increase jump height
    public static final int JUMPBOOST2 =            0x4000;
    public static final int JUMPBOOST3 =            0x8000;
    public static final int EXT_MAG1 =             0x10000; //(2 tiers) 10%,20% Chance not to consume durablity
    public static final int EXT_MAG2 =             0x20000;
    public static final int REACH1 =               0x40000; //(2 Tiers) 1 block,2blocks poler arm/scythes increased reach
    public static final int REACH2 =               0x80000;
    public static final int PUNCTURE1 =           0x100000; //(2 Tiers) 2.5%,5% increased damage with rapiers (only)
    public static final int PUNCTURE2 =           0x200000;
    public static final int K01 =                 0x400000; //(3 Tier) 5%,10%,15% increase Daze
    public static final int K02 =                 0x800000;
    public static final int FOOTING1 =           0x1000000; //(2 tiers) 25%,50% reduced knock back
    public static final int FOOTING2 =           0x2000000;
    public static final int RUSH1 =              0x4000000;
    public static final int RUSH2 =              0x8000000; //(2 Tiers) 5%, 10% attack speed




    public ArmourBase(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String name, String morph, boolean playerModel, CreativeTabs creativetab,int armourperks) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setMaxDamage(2500);
        this.morph = morph;
        this.armourperks = armourperks;
        if(this.getEquipmentSlot() == EntityEquipmentSlot.HEAD){
            if(name.contains("summer")){
                this.damageReduce = 10;
                this.tough = 0;}else {
                this.damageReduce = 6;
                this.tough = 0;}
        }else if(this.getEquipmentSlot() == EntityEquipmentSlot.CHEST||this.getEquipmentSlot() == EntityEquipmentSlot.LEGS){
            if(name.contains("summer")){this.damageReduce = 14;
                this.tough = 5;}else {
                this.damageReduce = 10;
                this.tough = 5;}
        } else { this.damageReduce = 0; this.tough = 0;}

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

        if (name.contains("korekosmoufire")) fire = true;
        if (name.contains("korekosmouice")) ice = true;
        if (name.contains("korekosmouwind")) wind = true;
        this.setCreativeTab(creativetab);
        this.setRegistryName("rwbym", name);
        this.setUnlocalizedName(name);
        this.isPlayerModel = playerModel;
    }

    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        ModelBiped armorModel = _default;
        if (!itemStack.isEmpty()) {
        	if (this.isPlayerModel) {
        		boolean smallarms = false;
        		if (entityLiving instanceof AbstractClientPlayer) {
	        		AbstractClientPlayer player = (AbstractClientPlayer) entityLiving;
	        		smallarms = player.getSkinType().equals("slim");
        		}
        		armorModel = new ModelArmor(0.02F, smallarms, armorSlot);
        	}
        	else {
                armorModel = new ModelBiped(0.2F);
            }
        }

        return armorModel;
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
    	
    	String s1 = null;
    	
    	if (this.isPlayerModel) {
	        ItemArmor item = (ItemArmor)stack.getItem();
	        String texture = item.getArmorMaterial().getName();
	        String domain = "minecraft";
	        int idx = texture.indexOf(':');
	        if (idx != -1)
	        {
	            domain = texture.substring(0, idx);
	            texture = texture.substring(idx + 1);
	        }
	        s1 = String.format("%s:textures/models/armor/%s%s.png", domain, texture, entity instanceof AbstractClientPlayer ? "_" + ((AbstractClientPlayer)entity).getSkinType() : "_default");
    	}

        return s1;
    }

    @Override
    public void onUpdate(ItemStack is, World world, Entity entity, int slotIn, boolean inHand) {
        /*
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

        }*/
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        ItemStack kkfire = new ItemStack(RWBYItems.kkfire);
        ItemStack kkice = new ItemStack(RWBYItems.kkice);
        ItemStack kkwind = new ItemStack(RWBYItems.kkwind);
        Integer slot = player.inventory.currentItem;
        if (player.inventory.getCurrentItem().isEmpty() && player.isSneaking() && player.isSwingInProgress) {
            if (fire && !player.inventory.hasItemStack(kkfire)) {
                player.inventory.setInventorySlotContents(slot, kkfire);
                itemStack.damageItem(30, player);
            }
        }
        if (player.inventory.getCurrentItem().isEmpty() && player.isSneaking() && player.isSwingInProgress) {
            if (ice && !player.inventory.hasItemStack(kkfire)) {
                player.inventory.setInventorySlotContents(slot, kkice);
                itemStack.damageItem(30, player);
            }
        }
        if (player.inventory.getCurrentItem().isEmpty() && player.isSneaking() && player.isSwingInProgress) {
            if (wind && !player.inventory.hasItemStack(kkfire)) {
                player.inventory.setInventorySlotContents(slot, kkwind);
                itemStack.damageItem(30, player);
            }
        }
        super.onArmorTick(world, player, itemStack);
    }
@Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == this.armorType)
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

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
            return false;
    }

    @ParametersAreNonnullByDefault
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        ItemStack is = playerIn.getHeldItem(hand);
        if (!worldIn.isRemote && playerIn.isSneaking() && this.morph != null) {
            ItemStack morph1 = new ItemStack(Item.getByNameOrId(this.morph), is.getCount(), is.getMetadata());
            //noinspection ConstantConditions
            if (is.hasTagCompound()) {
                morph1.setTagCompound(is.getTagCompound());
            }
            if (hand == EnumHand.MAIN_HAND) {
                playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, morph1);
            }}
        return super.onItemRightClick(worldIn, playerIn, hand);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, net.minecraft.enchantment.Enchantment enchantment)
    {
        return enchantment.type.canEnchantItem(Items.DIAMOND_CHESTPLATE);
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return true;
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
