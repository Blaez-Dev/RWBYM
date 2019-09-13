package be.bluexin.rwbym.weaponry;

import be.bluexin.rwbym.Init.RWBYCreativeTabs;
import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.RWBYSoundHandler;
import be.bluexin.rwbym.capabilities.Aura.AuraProvider;
import be.bluexin.rwbym.entity.EntityLargeFireball;
import be.bluexin.rwbym.entity.EntityNeverMore;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.mojang.realmsclient.gui.ChatFormatting;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.*;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import scala.tools.nsc.doc.model.Public;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static net.minecraft.item.ItemBow.getArrowVelocity;

/**
 * Part of rwbym
 *
 * @author Bluexin
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class RWBYGun extends ItemBow implements ICustomItem{
	

    private String data;
    private final int drawSpeed;
    private final int weapondamage;
    private final double weaponspeed;
    private final String morph;
    private final String ammo;
    private final float projectileSpeed;
    private final boolean charges; // TODO: use this
    private int recoil;
    private boolean mytre = false;
    private boolean glow = false;
    private int soundeffect;
    private int bulletCount;
    private int weapontype;
    public final boolean isShield;
    public final boolean  canBlock;
    boolean compensate;
    float lastDamage;
    private boolean climbs = false;
    private boolean ohblade;
    private boolean dualwield = false;
    private boolean grimm = false;
    private float damages = 0;
    private int shotcount;
    private int finishshot;
    private int shotrecoil;
    private String element = null;
    private String elementmelee = null;
    private boolean kkfire = false;
    private boolean kkice = false;
    private boolean kkwind = false;
    public boolean neo = false;
    public String attributedata;

    private boolean gwen;

    public RWBYGun setElement(String element) {
        this.element = element;
        return this;
    }

    public RWBYGun setElementMelee(String elementmelee) {
        this.elementmelee = elementmelee;
        return this;
    }

    public RWBYGun setRecoil(int shotrecoil) {
        this.shotrecoil = shotrecoil;
        return this;
    }

    //wtf do you do this, just use public(private) static final int or an enum
    //Weapon Type Numbers//
    /* 1 Rapier
    *  2 Scythe
    *  3 Offhand Blades
    *  4 Scarlet Weapon Behaviour
    *  5 Junior Rocket Launcher
    *  6 Ember celica 2
    *  7 Winter's Sword
    *  8 Bows
    *  9 Internal Magazine
    * 10 Ilia Whip Range
    * 11 Leonhart's Shield
    * 12 Daggers Critical
    * 13 Sword
    *
    *
    *  99 Sanrei Shunto
    * 100 letzt stil
    *
    * recoiltype
    * 1 crescent rose shoots backwards
    * 2 ember celica shoots backwards slightly less
    * 3 mytrenaster shoots forward when no ammo is present
    * 4 emerald/stormflower climb walls
    *
    * */


    
    //now you can also combine properties together like "BOW | INT_MAG"
	public static final int RAPIER =       0x0001;
	public static final int SCYTHE =       0x0002;
	public static final int OFFHAND =      0x0004;
	public static final int SCARLET =      0x0008;
	public static final int JUNIOR =       0x0010;
	public static final int EMBER_CELICA = 0x0020;
	public static final int WINTER =       0x0040;
	public static final int BOW =          0x0080;
	public static final int INT_MAG =      0x0100;
	public static final int WHIP =         0x0200;
	public static final int LION_HEART =   0x0400;
	public static final int DAGGER =       0x0800;
	public static final int SWORD =        0x1000;
	
	public static final int SANREI =       0x2000;
	public static final int LETZT =        0x4000;
	
	public static final int RCL_BACK =      1;
	public static final int RCL_BACK_WEAK = 2;
	public static final int RCL_FORWARD =   3;
	public static final int RCL_CLIMB =     4;
	


    public RWBYGun(String name, int durability, int weapondamage, int weapontype, String data, String morph, String ammo, boolean noCharge, float projectileSpeed, boolean shield,boolean canBlock, int recoilType, int bulletCount, int enchantmentglow,int soundeffect, CreativeTabs creativetab) {
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(creativetab);
        if(weapontype == BOW){this.drawSpeed = 72;}else {this.drawSpeed = 72000;}
        if(weapondamage == 0){this.weapondamage = 1;}else {this.weapondamage = weapondamage;}
        this.morph = morph;
        this.ammo = ammo;
        this.projectileSpeed = projectileSpeed;
        this.charges = !noCharge;
        this.isShield = shield;
        this.bulletCount = bulletCount;
        this.recoil = recoilType;
        this.canBlock = canBlock;
        this.weapontype = weapontype;
        this.setMaxDamage(durability);
        this.shotcount = 1;

        if(weapontype == OFFHAND){this.weaponspeed = -2D;}
        else if(weapontype == SWORD){this.weaponspeed = -2.4D;}
        else if(weapontype == LION_HEART){this.weaponspeed = -2.4D;}
        else if(weapontype == RAPIER){this.weaponspeed = -1D;}
        else if(weapontype == SCARLET){this.weaponspeed = -1D;}
        else if(weapontype == WINTER){this.weaponspeed = -1D;}
        else if(weapontype == WHIP){this.weaponspeed = -1D;}
        else if(weapontype == SCYTHE){this.weaponspeed = -3D;}
        else if(weapontype == DAGGER){this.weaponspeed = 1D;}
        else {this.weaponspeed = -3;}
        /*
        if(elementmelee == "wind"){sb.append(",{AttributeName:\"generic.movementSpeed\",Name:\"generic.movementSpeed\",Amount:0.2,Operation:0,UUIDLeast:763623,UUIDMost:811709,Slot:\"mainhand\"}");
        if(elementmelee == "wind"){sb.append(",ench:[{id:19,lvl:2}]");}*/


        this.soundeffect = soundeffect;
        if(name.contains("kkfire")) kkfire = true; if(name.contains("kkice")) kkice = true; if(name.contains("kkwind")) kkwind = true; if(name.contains("gwenknife")){gwen = true;}
        if((weapontype) == (OFFHAND | WINTER)) { ohblade = true; this.damages = 14; }
        if((weapontype) == WHIP) {this.damages = 14;}
        if(name.contains("neoumb_closed")) neo = true; if(name.contains("neoumb_closed_blade")) neo = true; if(name.contains("neoumb_handle_blade")) neo = true;
        if(name.contains("gambol")|| name.contains("rvn")) { ohblade = true; this.damages = 14; }
        if(name.contains("weiss")||name.contains("oobleck")||name.contains("goodwitch")){mytre = true;}
        if(name.contains("stormflower")||name.contains("ember")||name.contains("tyrian")||name.contains("fox")||name.contains("emerald")||name.contains("maria")||name.contains("sunnunchuck")||name.contains("reese")){dualwield = true;}
        if(enchantmentglow == 1){glow = true;}
        if(name.contains("grimm")){
            grimm = true;
        this.damages = 14;
        }

        
        if (this.neo) this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });

        if (this.isShield) this.addPropertyOverride(new ResourceLocation("offhand"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            @ParametersAreNonnullByDefault
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.getHeldItemOffhand() == stack ? 1.0F : 0.0F;
            }
        });

        if (weapontype == SCARLET) this.addPropertyOverride(new ResourceLocation("offhand1"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            @ParametersAreNonnullByDefault
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.getHeldItemOffhand() == stack ? 1.0F : 0.0F;
            }
        });

        if (weapontype == EMBER_CELICA) this.addPropertyOverride(new ResourceLocation("mainhand"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            @ParametersAreNonnullByDefault
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.getHeldItemMainhand() == stack ? 1.0F : 0.0F;
            }
        });

        if (weapontype == WINTER) this.addPropertyOverride(new ResourceLocation("mainhand1"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            @ParametersAreNonnullByDefault
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                ItemStack winter = new ItemStack(RWBYItems.winterswd);
                return entityIn != null && entityIn.getHeldItemMainhand().getItem() == RWBYItems.winterswd && entityIn.getHeldItemOffhand().getItem() == RWBYItems.winterswd ? 1.0F : 0.0F;
            }
        });

        this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    return entityIn.getActiveItemStack().getItem() != RWBYItems.chatareusgun ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
                }
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });


        this.addPropertyOverride(new ResourceLocation("pull1"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    return entityIn.getActiveItemStack().getItem() != RWBYItems.cinderbow ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
                }
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling1"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });


        this.addPropertyOverride(new ResourceLocation("pull2"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    return entityIn.getActiveItemStack().getItem() != RWBYItems.nebulabow ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
                }
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling2"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });

        this.addPropertyOverride(new ResourceLocation("pull3"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    return entityIn.getActiveItemStack().getItem() != RWBYItems.sanrei ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
                }
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling3"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });

        this.addPropertyOverride(new ResourceLocation("pull4"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    return entityIn.getActiveItemStack().getItem() != RWBYItems.letztstil ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
                }
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling4"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });

        this.addPropertyOverride(new ResourceLocation("pull5"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    return entityIn.getActiveItemStack().getItem() != stack.getItem() ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
                }
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling5"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });

        if(bulletCount == 0){
            System.out.println(name + " has no projectiles registered and has temporarily been set to 1.");
            this.bulletCount = 1;
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        String recall = Integer.toString(weapontype);
        String ammmo = ammo;
        ammmo = ammmo.replace("rwbym:nuller", "");
        ammmo = ammmo.replace("rwbym:nullest", "");
        ammmo = ammmo.replace("rwbym:nulls", "");
        String[] itemIds = ammmo.split(",");
        if (itemIds.length > 0) {
            tooltip.add("Ammo Required:");
	        for (int i = 0; i < itemIds.length; i++) {
	            Item item = Item.getByNameOrId(itemIds[i]);
	            if (item != null) {
	            	tooltip.add(com.mojang.realmsclient.gui.ChatFormatting.BLUE +"• " + I18n.format(item.getUnlocalizedName() + ".name"));
	            }
	        }
        }
        tooltip.add("Weapon Type:");
        if(weapontype == OFFHAND){tooltip.add(ChatFormatting.BLUE + "Offhand Capable Blade");}
        else if(weapontype == SWORD){tooltip.add(ChatFormatting.BLUE + "Sword");}
        else if(weapontype == LION_HEART){tooltip.add(ChatFormatting.BLUE + "Lion Heart Shield");}
        else if(weapontype == RAPIER){tooltip.add(ChatFormatting.BLUE + "Rapier");}
        else if(weapontype == SCARLET){tooltip.add(ChatFormatting.BLUE + "Offhand Gun Only");}
        else if(weapontype == WINTER){tooltip.add(ChatFormatting.BLUE + "Rapier / Offhand Capable");}
        else if(weapontype == WHIP){tooltip.add(ChatFormatting.BLUE + "Whip");}
        else if(weapontype == SCYTHE){tooltip.add(ChatFormatting.BLUE + "Scythe");}
        else if(weapontype == DAGGER){tooltip.add(ChatFormatting.BLUE + "Dagger");}
        else{tooltip.add(ChatFormatting.BLUE + "None");}
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }


    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return true;
    }


    @Override
    public int getMaxItemUseDuration(ItemStack stack) {

        return (weapontype == (SANREI | LETZT)) ? 72000 : this.drawSpeed;
    }


    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (kkfire || kkwind || kkice){
            ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
            chest.damageItem(1, player);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        if(glow){return true;}
        else
            return false;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void onUpdate(ItemStack is, World world, Entity entity, int slotIn, boolean inHand) {
        if(!world.isRemote) {
            if (entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entity;
                {    if (climbs) {
                    if (player.fallDistance > 4 & compensate) {
                        lastDamage = player.fallDistance;
                        player.fallDistance = 0.3F;
                    } else if (!(player.fallDistance > 0)) {
                        if (compensate) {
                            compensate = false;
                        }
                    }
                }
                }

            }
        }


        if(entity instanceof EntityPlayer && neo){
            final EntityPlayer player = (EntityPlayer)entity;
            if (!player.onGround && player.getItemInUseCount() > 1)
            {
                player.motionY += 0.05;
                player.fallDistance = 0;
                player.velocityChanged = true;
            }
        }

        if(weapontype == (SANREI | LETZT)){
            EntityPlayer player = (EntityPlayer) entity;
            if(weapontype == SANREI){
            player.getCapability(AuraProvider.AURA_CAP, null).useAura(player, 0.1F, false);}
            else if(weapontype == LETZT){
                player.getCapability(AuraProvider.AURA_CAP, null).useAura(player, 0.2F, false);
            }
            if(player.getCapability(AuraProvider.AURA_CAP, null).getAmount() < 1F && player.getHeldItem(EnumHand.MAIN_HAND) == is ){
                is = new ItemStack(Item.getByNameOrId(this.morph), is.getCount(), is.getMetadata());
                player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, is);
            }



            if(player.getCapability(AuraProvider.AURA_CAP, null).getAmount() < 1F && player.getHeldItem(EnumHand.OFF_HAND) == is ){
                is = new ItemStack(Item.getByNameOrId(this.morph), is.getCount(), is.getMetadata());
                player.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, is);
            }
        }


        if(entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (kkfire){if(player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == RWBYItems.korekosmoufire){
                ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
                is.setItemDamage(chest.getItemDamage());
                chest.setItemDamage(is.getItemDamage());}
            else{is.damageItem(365, player);
            }}
        }
        if(entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (kkice){if(player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == RWBYItems.korekosmouwater){
                ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
                is.setItemDamage(chest.getItemDamage());
                chest.setItemDamage(is.getItemDamage());}
            else{is.damageItem(365, player);
            }}
        }
        if(entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (kkwind){if(player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == RWBYItems.korekosmouwind){
                ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
                is.setItemDamage(chest.getItemDamage());
                chest.setItemDamage(is.getItemDamage());}
            else{is.damageItem(365, player);
            }}
        }
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, net.minecraft.enchantment.Enchantment enchantment)
    {
        return enchantment.type.canEnchantItem(Items.DIAMOND_AXE);
    }



    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack is = playerIn.getHeldItem(handIn);
        boolean flag = !this.findAmmo(playerIn, false).isEmpty();
        if (!worldIn.isRemote && playerIn.isSneaking() && this.morph != null) {
            ItemStack morph1 = new ItemStack(Item.getByNameOrId(this.morph), is.getCount(), is.getMetadata());
            //noinspection ConstantConditions
            if (is.hasTagCompound()) {
                morph1.setTagCompound(is.getTagCompound());
            }
            if (handIn == EnumHand.MAIN_HAND) {
                playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, morph1);
            }} else if (this.isShield && handIn == EnumHand.OFF_HAND) {
            playerIn.setActiveHand(EnumHand.OFF_HAND);
            return new ActionResult<>(EnumActionResult.SUCCESS, is);}else if (canBlock && handIn == EnumHand.MAIN_HAND) {
            playerIn.setActiveHand(EnumHand.MAIN_HAND);
            return new ActionResult<>(EnumActionResult.SUCCESS, is);
        }else if (weapontype == SCARLET && handIn == EnumHand.MAIN_HAND) {
            return new ActionResult<>(EnumActionResult.FAIL, is);}
        if (!flag) if (playerIn.onGround){
            if (recoil == 3) {
                Vec3d look = playerIn.getLookVec();
                playerIn.motionX = look.x;
                playerIn.motionZ = look.z;
                playerIn.motionY = look.y /1;
                playerIn.lastTickPosZ = -look.x;
                playerIn.lastTickPosX = -look.z;
            }}
        if (!flag) {if (recoil == 4)  { if (playerIn.collidedHorizontally){
            //PotionEffect potioneffect = new PotionEffect(MobEffects.JUMP_BOOST, 60, 5, false, false);
            Vec3d look = playerIn.getLookVec();
            playerIn.motionX = look.x/2;
            playerIn.motionZ = look.z/2;
            playerIn.motionY = look.y/2;
            playerIn.lastTickPosZ = -look.x;
            playerIn.lastTickPosX = -look.z;
            compensate = true;
            //playerIn.addPotionEffect(potioneffect);
            playerIn.fallDistance = 0;
        }}}




        ItemStack itemstack = playerIn.getHeldItem(handIn);
        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
        if (ret != null) return ret;
        if (!flag) {
            return new ActionResult<>(EnumActionResult.FAIL, itemstack);
        } else {
            if (charges) {
                playerIn.setActiveHand(handIn);
                return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);

            } else {
                this.onPlayerStoppedUsing(is, worldIn, playerIn, 0);
                return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
            }}
    }



    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        if(stack.getItem() == RWBYItems.chatareusgun || weapontype == (SANREI | LETZT)){
            return EnumAction.BOW;
        }else if(stack.getItem() == RWBYItems.cinderbow){
            return EnumAction.BOW;
        }else if(canBlock){return  EnumAction.BLOCK;}else return EnumAction.NONE;
    }

    @Nonnull
    private ItemStack findAmmo(EntityPlayer player, boolean force) {

        Item ammo1 = this.ammo == null ? Items.ARROW : Item.getByNameOrId(this.ammo);
        if (force || (ammo1 instanceof ItemArrow && ((ItemArrow) ammo1).isInfinite(null, player.getActiveItemStack(), player))
                || (ammo1 instanceof RWBYAmmoItem && ((RWBYAmmoItem) ammo1).isInfinite())) {
            return new ItemStack(ammo1);
        }

        // the rest is a copy from ItemBow#findAmmo(EntityPlayer)
        if (this.isArrow(player.getHeldItem(EnumHand.OFF_HAND))) {
            return player.getHeldItem(EnumHand.OFF_HAND);
        } else if (this.isArrow(player.getHeldItem(EnumHand.MAIN_HAND))) {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        } else {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
                ItemStack itemstack = player.inventory.getStackInSlot(i);

                if (this.isArrow(itemstack)) {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }


    //Thanks Bright_Spark//
    protected boolean isArrow(@Nonnull ItemStack stack) {
        String[] itemIds = ammo.split(",");
        for (int i = 0; i < itemIds.length; i++) {
            String item = itemIds[i];
            if (stack.getItem().getRegistryName().toString().equals(item))
                return true;
        }
        return false;
    }

    public int getItemEnchantability()
    {
        return 1;
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack){
        EntityPlayer playerIn = (EntityPlayer)entityLiving;
        if (!playerIn.world.isRemote && playerIn.isSneaking()&& this.element != null&& playerIn.getHeldItemMainhand() == stack) {
            stack = new ItemStack(Item.getByNameOrId(this.element), stack.getCount(), stack.getMetadata());
            playerIn.setHeldItem(EnumHand.MAIN_HAND, stack);
        }
        return false;
    }


    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) { // Mostly copied from ItemBow, with slight edits
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer) entityLiving;
            boolean flagger = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            boolean flag = false;
            boolean flag2 = false;
            ItemStack itemstack = this.findAmmo(entityplayer, flag);

            if(!itemstack.isEmpty()){
                flag2 = true;
            }

            ItemStack is = entityplayer.getActiveItemStack();
            if (is.getItem() == RWBYItems.pyrrharifle && entityplayer.getActiveHand() == EnumHand.OFF_HAND)
            {
                flag2 = false;
            }


            if(ohblade && entityplayer.getActiveHand() == EnumHand.OFF_HAND){
                flag2 = false;
            }

            if(weapontype == SANREI && entityplayer.getCapability(AuraProvider.AURA_CAP, null).getAmount() < 10){flag2 = false;}

            if(weapontype == LETZT && entityplayer.getCapability(AuraProvider.AURA_CAP, null).getAmount() < 20){flag2 = false;}

            if(ohblade && entityLiving instanceof EntityPlayer && entityLiving.getHeldItemOffhand() == stack) {
                Entity entity = this.findEntityOnPath(worldIn, entityLiving, entityLiving.getEntityAttribute(EntityPlayer.REACH_DISTANCE).getAttributeValue());
                if (entity instanceof EntityLivingBase) {
                    EntityLivingBase entitylivingbase = (EntityLivingBase) entity;
                    if (entitylivingbase != entityLiving && !entityLiving.isOnSameTeam(entitylivingbase)) {
                        entitylivingbase.knockBack(entityLiving, 0.4F, (double) MathHelper.sin(entityLiving.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(entityLiving.rotationYaw * 0.017453292F)));
                        entitylivingbase.attackEntityFrom(DamageSource.GENERIC, damages + 4);
                        stack.damageItem(1, entityLiving);
                        entityLiving.world.playSound((EntityPlayer) null, entityLiving.posX, entityLiving.posY, entityLiving.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, entityLiving.getSoundCategory(), 1.0F, 1.0F);
                    }
                }
            }

            if(weapontype == WHIP && entityLiving instanceof EntityPlayer && entityLiving.getHeldItemMainhand() == stack) {
                Entity entity = this.findEntityOnPath(worldIn, entityLiving, entityLiving.getEntityAttribute(EntityPlayer.REACH_DISTANCE).getAttributeValue()+4);
                if (entity instanceof EntityLivingBase) {
                    EntityLivingBase entitylivingbase = (EntityLivingBase) entity;
                    if (entitylivingbase != entityLiving && !entityLiving.isOnSameTeam(entitylivingbase)) {
                        entitylivingbase.knockBack(entityLiving, 0.4F, (double) MathHelper.sin(entityLiving.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(entityLiving.rotationYaw * 0.017453292F)));
                        entitylivingbase.attackEntityFrom(DamageSource.GENERIC, damages);
                        PotionEffect potioneffect = new PotionEffect(MobEffects.SLOWNESS, 100, 5, false, false);
                        entitylivingbase.addPotionEffect(potioneffect);
                        stack.damageItem(5, entityLiving);
                        entityLiving.world.playSound((EntityPlayer) null, entityLiving.posX, entityLiving.posY, entityLiving.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, entityLiving.getSoundCategory(), 1.0F, 1.0F);
                    }
                }
            }

            if(grimm && entityLiving instanceof EntityPlayer && entityLiving.getHeldItemMainhand() == stack) {
                Entity entity = this.findEntityOnPath(worldIn, entityLiving, entityLiving.getEntityAttribute(EntityPlayer.REACH_DISTANCE).getAttributeValue()+4);
                if (entity instanceof EntityLivingBase) {
                    EntityLivingBase entitylivingbase = (EntityLivingBase) entity;
                    if (entitylivingbase != entityLiving && !entityLiving.isOnSameTeam(entitylivingbase)) {
                        entitylivingbase.knockBack(entityLiving, 0.4F, (double) MathHelper.sin(entityLiving.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(entityLiving.rotationYaw * 0.017453292F)));
                        entitylivingbase.attackEntityFrom(DamageSource.GENERIC, damages);
                        stack.damageItem(5, entityLiving);
                        entityLiving.world.playSound((EntityPlayer) null, entityLiving.posX, entityLiving.posY, entityLiving.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, entityLiving.getSoundCategory(), 1.0F, 1.0F);
                    }
                }
            }

            shotcount = 1;
            finishshot = 0;

            if(dualwield){
                ItemStack is1 = entityLiving.getHeldItemMainhand();
                ItemStack is2 = entityLiving.getHeldItemOffhand();
                if(ItemStack.areItemsEqual(is1, is2)){
                    shotcount = 2;
                }
            }

            finishshot = bulletCount*shotcount;

            int i = this.getMaxItemUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, (EntityPlayer) entityLiving, i, itemstack != null);
            if (i < 0) return;

            if(entityplayer.getItemInUseCount() < 60 && weapontype == LION_HEART){
                flag2 = false;
            }

            if (flag2 || flag) {


                float f = getArrowVelocity(72);
            if(weapontype == (SANREI | LETZT)){
                f = getArrowVelocity(i);
            }
                if ((double) f >= 0.1D) {

                    if (!worldIn.isRemote) {
                        for (int i2 = 0; i2 < finishshot; i2++) {
                            EntityArrow entityarrow = (itemstack.getItem() instanceof RWBYAmmoItem ? ((RWBYAmmoItem) itemstack.getItem()).createArrow(worldIn, itemstack, entityplayer) : ((ItemArrow) Items.ARROW).createArrow(worldIn, itemstack, entityplayer));
                            entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F * (this.projectileSpeed == 0.0F ? 1.0F : this.projectileSpeed), shotcount*3);

                            entityarrow.setIsCritical(true);

                            worldIn.spawnEntity(entityarrow);
                            //if (f >= 1.0F) entityarrow.setIsCritical(true);
                        }
                        if(weapontype == SANREI){
                            if (entityplayer.hasCapability(AuraProvider.AURA_CAP, null)) {
                                entityplayer.getCapability(AuraProvider.AURA_CAP, null).useAura(entityplayer, 10F, false);
                                entityplayer.getCapability(AuraProvider.AURA_CAP, null).delayRecharge(60);
                            }
                        }else if(weapontype == LETZT){
                            if (entityplayer.hasCapability(AuraProvider.AURA_CAP, null)) {
                                entityplayer.getCapability(AuraProvider.AURA_CAP, null).useAura(entityplayer, 20F, false);
                                entityplayer.getCapability(AuraProvider.AURA_CAP, null).delayRecharge(60);
                            }
                        }
                        else if (weapontype == JUNIOR) {stack.damageItem(30,entityplayer);}
                        else if (weapontype == INT_MAG) {stack.damageItem(4, entityplayer);}
                        else stack.damageItem(2, entityplayer);
                    }

                    if (soundeffect == 1) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Crescent_Rose_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 2){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Ember_Celica_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 3) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Gambol_Shroud_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 4) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Mytrenaster_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 5){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.StormFlower_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 6) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Magnhild_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 7) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Ember_Celica_Shoot, SoundCategory.MASTER, 1.0F, 0.2F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 8) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Port_Shoot, SoundCategory.MASTER, 1.0F, 0.8F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 9) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Gambol_Shroud_Shoot, SoundCategory.MASTER, 1.0F, 0.7F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 10) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Junior_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 11) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Torchwick_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 12) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Crescent_Rose_Shoot, SoundCategory.MASTER, 1.0F, 2F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 13) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Crescent_Rose_Shoot, SoundCategory.MASTER, 0.5F, 3F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 14){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.StormFlower_Shoot, SoundCategory.MASTER, 1.0F, 0.5F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if(soundeffect == 15){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1.0F, 0.5F/ (itemRand.nextFloat() * 0.4F + 1.0F) + f + 0.5F);
                    }

                    if(soundeffect == 16){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, 1.0F, 0.5F/ (itemRand.nextFloat() * 0.4F + 1.0F) + f + 0.5F);
                    }

                    if(soundeffect == 17){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ENDERPEARL_THROW, SoundCategory.MASTER, 1.0F, 0.5F/ (itemRand.nextFloat() * 0.4F + 1.0F) + f + 0.5F);
                    }

                        for (int timer = shotrecoil; timer>1; timer --){
                        entityplayer.rotationPitch -= 1.0F;
                        }



                    //shooting recoil
                    if (recoil == 1) {
                        Vec3d look = entityplayer.getLookVec();
                        entityplayer.motionX = -look.x ;
                        entityplayer.motionZ = -look.z ;
                        entityplayer.motionY = -look.y/2 ;
                        entityplayer.lastTickPosZ = -look.x;
                        entityplayer.lastTickPosX = -look.z;
                        entityplayer.fallDistance = 0;
                    }

                    if (recoil == 2) {
                        Vec3d look = entityplayer.getLookVec();
                        entityplayer.motionX = -look.x ;
                        entityplayer.motionZ = -look.z ;
                        entityplayer.motionY = -look.y/4 ;
                        entityplayer.lastTickPosZ = -look.x;
                        entityplayer.lastTickPosX = -look.z;
                    }
                    if (!flag){
                        if (weapontype == BOW && !flagger) {
                            itemstack.shrink(1);
                        }
                    }
                    if (!flag){
                        if (mytre) {
                            itemstack.damageItem(2, entityplayer);
                        }
                        else {
                            itemstack.damageItem(1, entityplayer);
                        }
                    }
                }
            }
        }
    }



    @Nullable
    protected Entity findEntityOnPath(World world, Entity entityIn, double range)
    {
        Entity entity = null;
        Vec3d start = entityIn.getPositionEyes(1);
        Vec3d look = entityIn.getLook(1);
        Vec3d end = start.addVector(look.x * range, look.y * range, look.z * range);
        RayTraceResult raytraceresult1 = world.rayTraceBlocks(start, end, false, true, false);

        if (raytraceresult1 != null)
        {
            end = new Vec3d(raytraceresult1.hitVec.x, raytraceresult1.hitVec.y, raytraceresult1.hitVec.z);
        }

        List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(entityIn, new AxisAlignedBB(start.x, start.y, start.z, end.x, end.y, end.z));
        double d0 = 0.0D;

        for (int i = 0; i < list.size(); ++i)
        {
            Entity entity1 = list.get(i);

            AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().grow(0.30000001192092896D);
            RayTraceResult raytraceresult2 = axisalignedbb.calculateIntercept(start, end);

            if (raytraceresult2 != null)
            {
                double d1 = start.squareDistanceTo(raytraceresult2.hitVec);

                if (d1 < d0 || d0 == 0.0D)
                {
                    entity = entity1;
                    d0 = d1;
                }
            }
        }

        return entity;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {  if(weapontype == (RAPIER | WINTER)){
        //Rapier
        boolean unarm = false;
        if(target.getTotalArmorValue() == 0){
            unarm = true; }

        if(!unarm && !ohblade){
            target.attackEntityFrom(DamageSource.GENERIC, 35);
        }}

        if(weapontype == DAGGER || gwen){
        if (target.getHealth() >= 100.0F && (new Random()).nextInt(100) <= 30) {
            if (attacker instanceof EntityPlayer) {
                target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)attacker), 100.0F);
            } else {
                target.attackEntityFrom(DamageSource.WITHER, 100.0F);
            }
        }}

        if(weapontype == SCYTHE){
            //Scythe
            for (EntityLivingBase entitylivingbase : attacker.world.getEntitiesWithinAABB(EntityLivingBase.class, target.getEntityBoundingBox().grow(3.0D, 0.25D, 3.0D))) {
                if (entitylivingbase != attacker && entitylivingbase != target && !attacker.isOnSameTeam(entitylivingbase) && attacker.getDistanceSq(entitylivingbase) < 9.0D) {
                    entitylivingbase.knockBack(attacker, 0.4F, (double) MathHelper.sin(attacker.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(attacker.rotationYaw * 0.017453292F)));
                    IAttributeInstance attackerdamages = new AttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
                    for (AttributeModifier modifier : attacker.getHeldItemMainhand().getAttributeModifiers(EntityEquipmentSlot.MAINHAND).get(SharedMonsterAttributes.ATTACK_DAMAGE.getName()))
                        attackerdamages.applyModifier(modifier);

                    double dm = attackerdamages.getAttributeValue();
                    int attackerdamage = (int)dm;
                    entitylivingbase.attackEntityFrom(DamageSource.GENERIC, attackerdamage);
                }
            }

            attacker.world.playSound((EntityPlayer) null, attacker.posX, attacker.posY, attacker.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, attacker.getSoundCategory(), 1.0F, 1.0F);
        }

        if(weapontype == SWORD){
            //Sword
            for (EntityLivingBase entitylivingbase : attacker.world.getEntitiesWithinAABB(EntityLivingBase.class, target.getEntityBoundingBox().grow(3.0D, 0.25D, 3.0D))) {
                if (entitylivingbase != attacker && entitylivingbase != target && !attacker.isOnSameTeam(entitylivingbase) && attacker.getDistanceSq(entitylivingbase) < 9.0D) {
                    entitylivingbase.knockBack(attacker, 0.4F, (double) MathHelper.sin(attacker.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(attacker.rotationYaw * 0.017453292F)));
                    IAttributeInstance attackerdamages = new AttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
                    for (AttributeModifier modifier : attacker.getHeldItemMainhand().getAttributeModifiers(EntityEquipmentSlot.MAINHAND).get(SharedMonsterAttributes.ATTACK_DAMAGE.getName()))
                            attackerdamages.applyModifier(modifier);

                    double dm = attackerdamages.getAttributeValue();
                    int attackerdamage = (int)dm;
                    entitylivingbase.attackEntityFrom(DamageSource.GENERIC, attackerdamage);
                }
            }

            attacker.world.playSound((EntityPlayer) null, attacker.posX, attacker.posY, attacker.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, attacker.getSoundCategory(), 1.0F, 1.0F);
        }

            PotionEffect potioneffect = new PotionEffect(MobEffects.SLOWNESS, 200, 5, true, true);
            PotionEffect potioneffect2 = new PotionEffect(MobEffects.LEVITATION, 200, 5, true, true);
            if (elementmelee == "fire"){target.setFire(10);}
            if (elementmelee == "ice"){
                target.addPotionEffect(potioneffect);
            }
            if (elementmelee == "grav"){
                target.addPotionEffect(potioneffect2);
            }
        stack.damageItem(1, attacker);
        return true;
    }

    @Override
    public String toString() {
        return "RWBYBow{" + this.getRegistryName() + "}";
    }

    @Override
    public boolean isRepairable() {
        if (kkice || kkfire || kkwind){return false;}else return true;
    }



    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot p_getItemAttributeModifiers_1_) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(p_getItemAttributeModifiers_1_);
        if (p_getItemAttributeModifiers_1_ == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.weapondamage-1, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.weaponspeed, 0));
        }

        return multimap;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        if (kkice || kkfire || kkwind){return false;}
        else return repair.getItem() == RWBYItems.scrap || super.getIsRepairable(toRepair, repair);
    }
    
}




