package io.github.blaezdev.rwbym.weaponry;

import com.google.common.collect.Multimap;
import io.github.blaezdev.rwbym.Init.RWBYItems;
import io.github.blaezdev.rwbym.Init.RWBYPotions;
import io.github.blaezdev.rwbym.Init.RegUtil;
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
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.annotation.ParametersAreNonnullByDefault;

import java.util.UUID;

import static io.github.blaezdev.rwbym.weaponry.ICustomItem.KEY;

public class ArmourBase extends ItemArmor {
    private static final UUID[] ARMOR_MODIFIERS = new UUID[]{UUID.fromString("5126b112-6d41-4d7b-ad51-c05dd896fd6f"), UUID.fromString("bbef3b34-c734-467e-9c58-c06bb3b4d368"), UUID.fromString("6120e91c-73bd-4f1f-bbae-942c1f6f8a1c"), UUID.fromString("a837ba0a-4ade-4a59-859c-46af08af0f87"),UUID.fromString("6cd3a363-55b2-4e9f-880d-3d8464b5c86a")};
    private static final UUID[] MovementSpeed = new UUID[]{UUID.fromString("eb75c2c3-fb31-486e-8e2f-b2a8a5f7b5d7"), UUID.fromString("b97e2987-d88c-4979-8459-c27226e51793"), UUID.fromString("2c78c491-1d9f-44a5-ba84-6985a068cb68"), UUID.fromString("d28d60ac-4648-4f97-b9ef-4d82b353cad8"),UUID.fromString("60ce8bd8-827e-4038-8586-40ac0297231c")};
    private static final UUID[] Defence = new UUID[]{UUID.fromString("272b20ef-7a26-4349-a8a9-8968dfa5b471"),UUID.fromString("c575a9b5-6a04-4c50-9d9c-4407717bd8db"),UUID.fromString("89450e4b-da13-4e55-8859-b42fee5bb598"),UUID.fromString("fe07bfa4-2bc0-41d4-88f7-08a47faf22c4"),UUID.fromString("d04d09ab-7f33-46c5-8a45-d6274744079d")};
    private static  final UUID[] Vitality = new UUID[]{UUID.fromString("af57ee3c-4972-4d6d-adad-14a394fd04f8"),UUID.fromString("0305bc40-d3a3-4fa1-b644-185e12e2808e"),UUID.fromString("b746a3a7-efd0-4252-9883-9f35321c197a"),UUID.fromString("b2d349e2-8195-4b44-bce1-e466eec11ade"),UUID.fromString("98f47166-f301-4c37-8621-898123a9f7f8")};
    private static final  UUID[] Attackboost = new UUID[]{UUID.fromString("c8e42b1c-af7f-4cf6-864f-7918a9f3bd0e"),UUID.fromString("0f5b7e9c-1dc7-4723-8b89-73ecc43f3fa5"),UUID.fromString("f9dbf33e-8e1d-445b-9cd8-dec1e88fde16"),UUID.fromString("d5568696-0623-4b86-807a-a72980a6ea56"),UUID.fromString("f2ee6660-151c-492e-8537-256b2ec3fad7")};
    private static final UUID[] Knockback = new UUID[]{UUID.fromString("bd8dd442-4e0c-4201-8a55-cf3e89a8e5d5"),UUID.fromString("38fa9005-f5a5-4e0e-b87c-f34df448f3ca"),UUID.fromString("601ec609-819d-4063-ab32-1d7b38bf696d"),UUID.fromString("e8abcc6a-eac5-49a3-b3f3-a4526bce8581"),UUID.fromString("44e33024-7121-470e-9aeb-eebc67789c9c")};
    private static final UUID[] Attackspeed = new UUID[]{UUID.fromString("854cdff1-1c4f-4a21-aecc-2630cec7c461"),UUID.fromString("ebe83521-9738-4fb1-9a97-d31a07017ffd"),UUID.fromString("d6e87574-13f3-4c78-9a24-ff86aed0d6b3"),UUID.fromString("4858f7c8-d499-47db-b23c-83d78f0d8f42"),UUID.fromString("abe24347-9e3d-41df-a5d8-581cd16502a2")};
    private boolean fire = false;
    private boolean ice = false;
    private boolean wind = false;
    private boolean isPlayerModel;
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
    public static final int CRITICALSTRIKE1 =      0x10000;
    public static final int CRITICALSTRIKE2 =      0x20000;
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
    public static final int AURAREGEN =         0x10000000;
    public static final int GLADIATOR1 =        0x20000000;
    public static final int GLADIATOR2 =        0x40000000;
    public static final int FIRESTARTER =       0x80000000;


    public boolean validperk(EntityLivingBase playerIn,int armorperk){
        for (ItemStack stack:playerIn.getArmorInventoryList()){
            if(stack.getItem() instanceof ArmourBase){
                if((((ArmourBase) stack.getItem()).armourperks & armorperk) !=0){
                    //System.out.println("armor works");
                    return true;
                }}
            if(stack.getItem() instanceof RWBYHood){
                if((((RWBYHood) stack.getItem()).armourperks & armorperk) !=0) {
                    //System.out.println("hood works");
                    return true;
                }}
        }
        return false;
    }


    public ArmourBase(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String name, String morph, boolean playerModel, CreativeTabs creativetab,int armourperks) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setMaxDamage(2500);
        this.morph = morph;
        this.armourperks = armourperks;
        if(this.getEquipmentSlot() == EntityEquipmentSlot.HEAD){
            if(name.contains("summer")){
                this.damageReduce = 7;
                this.tough = 0;}else {
                this.damageReduce = 6;
                this.tough = 0;}
        }else if(this.getEquipmentSlot() == EntityEquipmentSlot.CHEST||this.getEquipmentSlot() == EntityEquipmentSlot.LEGS){
            if(name.contains("summer")){this.damageReduce = 12;
                this.tough = 5;}else if(name.contains("beacon")) {
                this.damageReduce = 7;
                this.tough = 2;}else{
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

        if (!world.isRemote && entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if(this.validperk(player, AURAREGEN)){
                PotionEffect potioneffect = new PotionEffect(RegUtil.AURA_REGEN, 60, 1, false, false);
                player.addPotionEffect(potioneffect);

            }
            if(this.validperk(player, NIGHTVISION)){
                PotionEffect potioneffect = new PotionEffect(MobEffects.NIGHT_VISION, 60, 0, false, false);
                player.addPotionEffect(potioneffect);
            }
            if(this.validperk(player, JUMPBOOST1)){
                PotionEffect potioneffect = new PotionEffect(MobEffects.JUMP_BOOST, 60, 0, false, false);
                player.addPotionEffect(potioneffect);
            }
            if(this.validperk(player, JUMPBOOST2)){
                PotionEffect potioneffect = new PotionEffect(MobEffects.JUMP_BOOST, 60, 1, false, false);
                player.addPotionEffect(potioneffect);

            }
            if(this.validperk(player, JUMPBOOST3)){
                PotionEffect potioneffect = new PotionEffect(MobEffects.JUMP_BOOST, 60, 2, false, false);
                player.addPotionEffect(potioneffect);
            }
            if(this.validperk(player, FIRESTARTER)){
                PotionEffect potioneffect = new PotionEffect(MobEffects.FIRE_RESISTANCE, 60, 1, false, false);
                player.addPotionEffect(potioneffect);
            }
            }
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
            multimap.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getSlotIndex()], "Armor modifier", (double)this.damageReduce, 0));
            multimap.put(SharedMonsterAttributes.ARMOR_TOUGHNESS.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getSlotIndex()], "Armor toughness", (double)this.tough, 0));
            multimap.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(Defence[equipmentSlot.getSlotIndex()], "Armor modifier", (double)this.armourbuff, 2));
            multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(MovementSpeed[equipmentSlot.getSlotIndex()], "Movement Speed", (double)movementspeedmult, 2));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(Attackspeed[equipmentSlot.getSlotIndex()], "Attack Speed", (double)attackspeed, 2));
            multimap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(Knockback[equipmentSlot.getSlotIndex()], "Knockback", (double)knockbackresist, 2));
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(Attackboost[equipmentSlot.getSlotIndex()], "Attack Boost", (double)attackboost, 2));
            multimap.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(Vitality[equipmentSlot.getSlotIndex()], "Health", (double)healthbuff, 2));
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
