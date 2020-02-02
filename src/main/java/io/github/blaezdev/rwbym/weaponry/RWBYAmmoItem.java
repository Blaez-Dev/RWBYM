package io.github.blaezdev.rwbym.weaponry;

import com.google.common.collect.Multimap;
import com.mojang.realmsclient.gui.ChatFormatting;
import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityBullet;
import io.github.blaezdev.rwbym.weaponry.ammohit.IAmmoHit;
import io.github.blaezdev.rwbym.weaponry.ammohit.NullAmmoHit;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

/**
 * Part of rwbym by Bluexin.
 *
 * @author Bluexin
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class RWBYAmmoItem extends Item implements ICustomItem {
    private static final UUID MovementSpeed = UUID.fromString("c2dee5bc-441d-11ea-b77f-2e728ce88125");
    private static final UUID Defence = UUID.fromString("c2dee864-441d-11ea-b77f-2e728ce88125");
    private static  final UUID Vitality = UUID.fromString("c2dee9b8-441d-11ea-b77f-2e728ce88125");
    private static final  UUID Attackboost = UUID.fromString("c2deeaf8-441d-11ea-b77f-2e728ce88125");
    private static final UUID Knockback = UUID.fromString("c2deee9a-441d-11ea-b77f-2e728ce88125");
    private static final UUID Attackspeed = UUID.fromString("c2deefee-441d-11ea-b77f-2e728ce88125");
	private Object render;
    private boolean canPickup;
    private double baseDamage;
    private boolean gravity;
    private boolean infinite;
    private String nbt;
    private transient NBTTagCompound nbtTag;
    private IAmmoHit hitfun;
    private String texture;
    private SurviveOnHit survives;
    public boolean dustcrystal = false;
    public int element;

    private final float movementspeedmult;
    private final float armourbuff;
    private final float healthbuff;
    private final float attackboost;
    private final float knockbackresist;
    private final float attackspeed;

    public static final int HARDLIGHT =       0x0001;
    public static final int WATER =           0x0002;
    public static final int IMPURE =          0x0004;
    public static final int WIND =            0x0008;
    public static final int FIRE =            0x0010;
    public static final int GRAVITY =         0x0020;
    public static final int LIGHTNING =       0x0040;
    public static final int ICE =             0x0080;
    public static final int NONE =            0x0100;


    public boolean pierce;

    private List<PotionEffect> potions;


    public RWBYAmmoItem setDustCrystal(Boolean crystal){
        this.dustcrystal = crystal;
        return this;
    }

    public RWBYAmmoItem setPierce(Boolean pierce) {
        this.pierce = pierce;
        return this;
    }

    //public int getAmmoMax;

    /**
     * 
     * @param name
     * @param render
     * @param ammoMax
     * @param canPickup
     * @param canSurvive
     * @param texture
     * @param gravity
     * @param infinite
     //* @param nbt
     * @param potion
     * @param durability
     * @param baseDamage
     * @param creativetab
     * @param hitfun
     */
    public RWBYAmmoItem(String name, Object render, int ammoMax, boolean canPickup, SurviveOnHit canSurvive, String texture, boolean gravity, boolean infinite, int element, List<PotionEffect> potion, int durability, double baseDamage, CreativeTabs creativetab, IAmmoHit hitfun) {
        this.setCreativeTab(creativetab);
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setMaxStackSize(ammoMax);
        this.render = render;
        this.canPickup = canPickup;
        this.texture = texture;
        this.baseDamage = baseDamage;
        this.gravity = gravity;
        this.infinite = infinite;
        this.nbt = nbt;
        this.potions = potion;
        this.setMaxDamage(durability);
        this.hitfun = hitfun;
        this.survives = canSurvive;
        this.element = element;
        if (this.hitfun == null) {
        	this.hitfun = new NullAmmoHit();
        }

        if((element & WATER) != 0) {
            movementspeedmult = 0;
            armourbuff = 0;
            healthbuff = 0;
            attackboost = -0.25F;
            knockbackresist = 0;
            attackspeed = 0;
        }
        else if((element & IMPURE) != 0){
            movementspeedmult = 0;
            armourbuff = 0;
            healthbuff = -0.5F;
            attackboost = 0;
            knockbackresist = 0;
            attackspeed = 0;
        }
        else if ((element & WIND) != 0){
            movementspeedmult = 1.5F;
            armourbuff = 0;
            healthbuff = -0.5F;
            attackboost = 0;
            knockbackresist = 0;
            attackspeed = 0;
        }
        else if((element & FIRE) != 0){
            movementspeedmult = 0;
            armourbuff = 0;
            healthbuff = -0.5F;
            attackboost = 2.0F;
            knockbackresist = 0;
            attackspeed = 0;
        }
        else if((element & GRAVITY) != 0){
            movementspeedmult = 0;
            armourbuff = 0;
            healthbuff = -0.5F;
            attackboost = 0;
            knockbackresist = 0;
            attackspeed = 0;
        }
        else if((element & LIGHTNING) != 0){
            movementspeedmult = 1.20F;
            armourbuff = 0;
            healthbuff = -0.5F;
            attackboost = 0;
            knockbackresist = 0;
            attackspeed = 2.0F;
        }else if((element & ICE) != 0){
            movementspeedmult = -0.3F;
            armourbuff = 0;
            healthbuff = 0.5F;
            attackboost = 0;
            knockbackresist = 0;
            attackspeed = 0;
        }else if((element & HARDLIGHT) != 0){
            movementspeedmult = 0.2F;
            armourbuff = 0.2F;
            healthbuff = 0;
            attackboost = -0.2F;
            knockbackresist = 1F;
            attackspeed = 0;
        }else{
            movementspeedmult = 0;
            armourbuff = 0;
            healthbuff = 0;
            attackboost = 0F;
            knockbackresist = 0;
            attackspeed = 0;
        }

        if (nbt != null && !nbt.isEmpty()) try {
            this.nbtTag = JsonToNBT.getTagFromJson(nbt);
        } catch (NBTException e) {
            e.printStackTrace();
            System.err.println("Invalid NBT !");
        }
        //this.getAmmoMax = from.getAmmoMax();
    }
    
    public void doRender(EntityBullet entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (render == null) {
        	return;
        }
        else if (render instanceof Item) {
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)x, (float)y, (float)z);
            GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
    		Minecraft.getMinecraft().getRenderItem().renderItem(new ItemStack((Item)render), ItemCameraTransforms.TransformType.HEAD);
    		GlStateManager.popMatrix();
        }
        else if (render instanceof Entity) {
        	Entity renderEntity = (Entity)render;
        	renderEntity.copyLocationAndAnglesFrom(entity);
        	Minecraft.getMinecraft().getRenderManager().renderEntityStatic(renderEntity, partialTicks, true);
        }
    }


    //@SuppressWarnings("Duplicates")
    @Override
    public void onUpdate(ItemStack is, World world, Entity entity, int slotIn, boolean inHand) {
        if(entity instanceof EntityPlayer){
            final EntityPlayer player = (EntityPlayer)entity;
            player.setHealth(player.getHealth());
            if(player.getHeldItem(EnumHand.OFF_HAND) == is && (element & GRAVITY) != 0){
                if (!player.onGround)
                {
                    player.motionY += 0.05;
                    player.fallDistance = 0;
                    //player.velocityChanged = true;
                }
            }
            if(player.getHeldItem(EnumHand.OFF_HAND) == is && (element & WATER) != 0){
                //PotionEffect potioneffect = new PotionEffect(MobEffects.RESISTANCE, 60, 1, false, false);
                //player.addPotionEffect(potioneffect);
                player.heal(0.05F);
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Bullet Impact Damage:");
        tooltip.add(ChatFormatting.BLUE + "-"+baseDamage);
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    public ItemStack getRenderStack() {
    	return this.render instanceof Item ? new ItemStack((Item)render) : ItemStack.EMPTY; 
    }

    public boolean canPickup() {
        return canPickup;
    }

    public String getTexture() {
        return texture;
    }

    public double getBaseDamage() {
        return baseDamage;
    }

    public boolean obeysGravity() {
        return gravity;
    }

    public boolean isInfinite() {
        return infinite;
    }

    public List<PotionEffect> getPotions() {
        return potions;
    }
    
    public boolean canSurviveBlockHit() {
    	return survives == SurviveOnHit.BLOCK || survives == SurviveOnHit.ENTITY;
    }
    
    public boolean canSurviveEntityHit() {
    	return survives == SurviveOnHit.ENTITY;
    }

    public NBTTagCompound getNbt() {
        if (nbtTag == null && nbt != null) try {
            this.nbtTag = JsonToNBT.getTagFromJson(nbt);
        } catch (NBTException e) {
            e.printStackTrace();
            System.err.println("Invalid NBT !");
        }
        return nbtTag;
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.OFFHAND)
        {
            multimap.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(Defence, "Armor modifier", (double)this.armourbuff, 2));
            multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(MovementSpeed, "Movement Speed", (double)this.movementspeedmult, 2));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(Attackspeed, "Attack Speed", (double)this.attackspeed, 2));
            multimap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(Knockback, "Knockback", (double)this.knockbackresist, 2));
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(Attackboost, "Attack Boost", (double)this.attackboost, 2));
            multimap.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(Vitality, "Health", (double)this.healthbuff, 2));
        }

        return multimap;
    }

    public int getItemEnchantability()
    {
        return 0;
    }
    
    public void onBlockHit(EntityLivingBase shooter, BlockPos pos) {
    	this.hitfun.applyBlock(shooter, pos);
    }
    
    public void onEntityHit(EntityLivingBase living, EntityLivingBase shooter) {
    	this.hitfun.applyEntity(living, shooter);
    }

    @Override
    public boolean isRepairable() {
        return false;
    }
    
    public EntityBullet createArrow(World worldIn, ItemStack stack, ItemStack shootingStack, EntityLivingBase shooter) {
        return new EntityBullet(worldIn, shooter, stack, shootingStack);
    }

    @Override
    public String toString() {
        return "RWBYAmmoItem{" + this.getRegistryName() + "}";
    }
	
	public enum SurviveOnHit {
		NONE,
		BLOCK,
		ENTITY;
	}
}
