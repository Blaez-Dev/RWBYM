package io.github.blaezdev.rwbym.weaponry;

import com.google.common.collect.Multimap;
import com.mojang.realmsclient.gui.ChatFormatting;
import io.github.blaezdev.rwbym.Init.RWBYItems;
import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.RWBYSoundHandler;
import io.github.blaezdev.rwbym.capabilities.Aura.AuraProvider;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEvokerFangs;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Random;
import java.util.UUID;


/**
 * Part of rwbym
 *
 * @author Blaez
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
    private boolean weaponuseglow = false;
    private int soundeffect;
    private int bulletCount;
    public int weapontype;
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
    public boolean thrown = false;

    private boolean gwen;

    protected static final UUID MOVEMENT_SPEED = UUID.fromString("86b77fe8-3674-4b95-a14f-680951daf5a1");

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



    /*
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
    public static final int AURAWEAP =     0x8000;
    public static final int TOOL =         0x10000;
    public static final int STAFF =        0x20000;
    public static final int ROCKET =       0x40000;
    public static final int UMBRELLA =     0x80000;
    public static final int AXE =          0x100000;
    public static final int PICKAXE =      0x200000;
    public static final int TOME =         0x400000;
    public static final int FIST =         0x800000;
    public static final int HAMMER =      0x1000000;
    public static final int THROWN =      0x2000000;
    public static final int WALLCLIMB =   0x4000000;
    public static final int FLIGHT =      0x8000000;
    public static final int BOOMERANG =  0x10000000;
	
	public static final int RCL_BACK =      1;
	public static final int RCL_BACK_WEAK = 2;
	public static final int RCL_FORWARD =   3;

    public boolean validperk(EntityLivingBase playerIn,long armorperk){
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
	


    public RWBYGun(String name, int durability, int weapondamage, int weapontype, String morph, String ammo, boolean noCharge, float projectileSpeed, boolean shield,boolean canBlock, int recoilType, int bulletCount, int enchantmentglow,int soundeffect, CreativeTabs creativetab) {
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(creativetab);
        if((weapontype & (BOW|ROCKET)) !=0){this.drawSpeed = 72;}else {this.drawSpeed = 72000;}
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

        if((weapontype & OFFHAND) !=0){this.weaponspeed = -2D;}
        else if((weapontype & SWORD) !=0){this.weaponspeed = -2.4D;}
        else if((weapontype & LION_HEART) !=0){this.weaponspeed = -2.4D;}
        else if((weapontype & AURAWEAP) !=0){this.weaponspeed = -2.4D;}
        else if((weapontype & RAPIER) !=0){this.weaponspeed = -1D;}
        else if((weapontype & SCARLET) !=0){this.weaponspeed = -1D;}
        else if((weapontype & WINTER) !=0){this.weaponspeed = -1D;}
        else if((weapontype & WHIP) !=0){this.weaponspeed = -1D;}
        else if((weapontype & SCYTHE) !=0){this.weaponspeed = -3D;}
        else if((weapontype & DAGGER) !=0){this.weaponspeed = 1D;}
        else if((weapontype & STAFF) !=0){this.weaponspeed = -3D;}
        else if((weapontype & ROCKET) !=0){this.weaponspeed = -3D;}
        else if((weapontype & AXE) !=0){this.weaponspeed = -3D;}
        else if((weapontype & PICKAXE) !=0){this.weaponspeed = -3D;}
        else {this.weaponspeed = -3;}

        if((weapontype & THROWN) !=0){this.thrown = true;}else this.thrown = false;

        this.soundeffect = soundeffect;
        if(name.contains("kkfire")) kkfire = true; if(name.contains("kkice")) kkice = true; if(name.contains("kkwind")) kkwind = true; if(name.contains("gwenknife")){gwen = true;}
        if((weapontype & (OFFHAND | WINTER)) !=0) { ohblade = true; this.damages = 14; }
        if((weapontype & WHIP) !=0) {this.damages = 14;}
        if(name.contains("gambol")|| name.contains("rvn")) { ohblade = true; this.damages = 14; }
        if(name.contains("weiss")||name.contains("oobleck")||name.contains("kyoshi")||name.contains("goodwitch")){mytre = true;}
        if(name.contains("stormflower")||name.contains("ember")||name.contains("tyrian")||name.contains("fox")||name.contains("emerald")||name.contains("mariascythe")||name.contains("sunnunchuck")||name.contains("reese")){dualwield = true;}
        if(enchantmentglow == 1){glow = true;}
        if(name.contains("grimm")){
            grimm = true;
        this.damages = 14;
        }

        
        if ((weapontype & UMBRELLA) !=0) this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter() {
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

        if ((weapontype & SCARLET) !=0) this.addPropertyOverride(new ResourceLocation("offhand1"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            @ParametersAreNonnullByDefault
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.getHeldItemOffhand() == stack ? 1.0F : 0.0F;
            }
        });

        if ((weapontype & EMBER_CELICA) !=0) this.addPropertyOverride(new ResourceLocation("mainhand"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            @ParametersAreNonnullByDefault
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.getHeldItemMainhand() == stack ? 1.0F : 0.0F;
            }
        });

        if ((weapontype & WINTER) !=0) this.addPropertyOverride(new ResourceLocation("mainhand1"), new IItemPropertyGetter() {
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
        boolean thrown = ((weapontype & THROWN) != 0);
        if(!thrown){
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
	            	tooltip.add(ChatFormatting.BLUE +"-" + I18n.format(item.getUnlocalizedName() + ".name"));
	            }
	        }
        }}
        if(weapontype > 0||dualwield|| recoil == 4){tooltip.add("Weapon Info:");}
        if((weapontype & OFFHAND) !=0|| ohblade){tooltip.add(ChatFormatting.BLUE +"-" +  "Offhand Blade");}
         if((weapontype & SWORD) !=0){tooltip.add(ChatFormatting.BLUE +"-" +  "Sword");}
         if((weapontype & LION_HEART) !=0){tooltip.add(ChatFormatting.BLUE +"-" +  "Lion Heart Shield");}
         if((weapontype & RAPIER) !=0){tooltip.add(ChatFormatting.BLUE +"-" +  "Rapier");}
         if((weapontype & SCARLET) !=0){tooltip.add(ChatFormatting.BLUE +"-" +  "Offhand Gun Only");}
         if((weapontype & WINTER) !=0){tooltip.add(ChatFormatting.BLUE +"-" +  "Rapier");}
         if((weapontype & WHIP) !=0){tooltip.add(ChatFormatting.BLUE +"-" +  "Whip");}
         if((weapontype & SCYTHE) !=0){tooltip.add(ChatFormatting.BLUE +"-" +  "Polearm");}
         if((weapontype & DAGGER) !=0){tooltip.add(ChatFormatting.BLUE +"-" +  "Dagger");}
         if((weapontype & INT_MAG) !=0){tooltip.add(ChatFormatting.BLUE +"-" +  "Internal Magazine");}
         if((weapontype & JUNIOR) !=0){tooltip.add(ChatFormatting.BLUE +"-" +  "Internal Magazine");}
        if((weapontype & ROCKET) !=0){tooltip.add(ChatFormatting.BLUE +"-" +  "Rocket Launcher");}
         if(dualwield){tooltip.add(ChatFormatting.BLUE + "-" + "Paired Guns");}
         if((weapontype & TOOL) !=0){tooltip.add(ChatFormatting.BLUE + "-" + "Multi-Tool");}
        if((weapontype & BOW) !=0){tooltip.add(ChatFormatting.BLUE + "-" + "Bow");}
        if((weapontype & STAFF) !=0){tooltip.add(ChatFormatting.BLUE + "-" + "Staff");}
        if((weapontype & UMBRELLA) !=0){tooltip.add(ChatFormatting.BLUE + "-" + "Glide Capable");}
        if((weapontype & AXE) !=0){tooltip.add(ChatFormatting.BLUE + "-" + "Axe");}
        if((weapontype & PICKAXE) !=0){tooltip.add(ChatFormatting.BLUE + "-" + "Pickaxe");}
        if((weapontype & TOME) !=0){tooltip.add(ChatFormatting.BLUE + "-" + "Tome");}
        if((weapontype & FIST) !=0){tooltip.add(ChatFormatting.BLUE + "-" + "Gaunlet");}
        if((weapontype & HAMMER) !=0){tooltip.add(ChatFormatting.BLUE + "-" + "Blunt Weapon");}
        if((weapontype & THROWN) !=0){tooltip.add(ChatFormatting.BLUE + "-" + "Throwable Weapon");}
        if(grimm){tooltip.add(ChatFormatting.BLUE + "-"+ "Grimm Weapon");}
         if((weapontype & (AURAWEAP|LETZT|SANREI)) !=0){tooltip.add(ChatFormatting.BLUE + "-" + "Aura Based Weapon");}
         if((weapontype & WALLCLIMB) !=0){tooltip.add(ChatFormatting.BLUE + "-"+ "Wall Climbing Capable");}
        if(recoil == 3){tooltip.add(ChatFormatting.BLUE + "-"+ "Dashes Forward When no ammo is present.");}
        if(recoil == 2){tooltip.add(ChatFormatting.BLUE + "-"+ "Weak Shot Recoil - Propelling Player Backwards");}
        if(recoil == 1){tooltip.add(ChatFormatting.BLUE + "-"+ "Large Shot Recoil - Propelling Player Backwards");}
        if(isShield||canBlock){
             if(isShield&&!canBlock){tooltip.add(ChatFormatting.BLUE + "-"+ "Blocks in Both Mainhand & Offhand");}
             if(!isShield&&canBlock){tooltip.add(ChatFormatting.BLUE + "-"+ "Blocks in Mainhand Only");}
             if(isShield&&canBlock){tooltip.add(ChatFormatting.BLUE + "-"+ "Blocks in Both Mainhand & Offhand");}
         }
         if(shotrecoil > 0){
            String shotrecoils = Integer.toString(shotrecoil);
            tooltip.add("Shot Recoil Amount:");
            tooltip.add(ChatFormatting.BLUE +"-" +  shotrecoils);
        }
        if(bulletCount > 1){
            String shotcounter = Integer.toString(bulletCount);
            tooltip.add("Number of Projectiles:");
            tooltip.add(ChatFormatting.BLUE + "-"+shotcounter);
        }
        if(stack.getItem() == RWBYItems.bangle){tooltip.add(" "); tooltip.add(ChatFormatting.BLUE+"-" +  "Hums with a Faint Energy");}
        if(stack.getItem() == RWBYItems.hbangle){tooltip.add(" "); tooltip.add(ChatFormatting.BLUE +"-" +  "Hums with a Faint Dark Energy");}
        if(stack.getItem() == RWBYItems.leafshield){tooltip.add(" "); tooltip.add(ChatFormatting.BLUE +  "Collection Skill + 1");}
        if(stack.getItem() == RWBYItems.leafshield){tooltip.add(" "); tooltip.add(ChatFormatting.WHITE +  "Vegetation Yields Double the Yield");}
        if(stack.getItem() == RWBYItems.pickaxeshield){tooltip.add(" "); tooltip.add(ChatFormatting.BLUE +  "Mining Skill + 1");}
        if(stack.getItem() == RWBYItems.pickaxeshield){tooltip.add(" "); tooltip.add(ChatFormatting.WHITE +  "Your Reflexes and Eyesight adjust to make mining easier.");}
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
        /*Block block = state.getBlock();
        Material material = block.getMaterial(state);
        System.out.println(weapontype + material.toString());
        if((weapontype & AXE) !=0){
            return state.getMaterial() == Material.WOOD && material != Material.PLANTS && material != Material.VINE;}
        if((weapontype & PICKAXE) !=0){
            return state.getMaterial() == Material.IRON && material != Material.ANVIL && material != Material.ROCK;}
        if(stack.getItem() == RWBYItems.leafshield){
            return state.getMaterial() == Material.PLANTS && material != Material.VINE;
        }
        else*/ return true;
    }


    /*
    public String getItemStackDisplayName(ItemStack stack) {
        return ChatFormatting.GOLD + super.getItemStackDisplayName(stack);
    }*/

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return true;
    }


    @Override
    public int getMaxItemUseDuration(ItemStack stack) {

        return ((weapontype & (SANREI | LETZT)) !=0) ? 72000 : this.drawSpeed;
    }

    @Override
    public boolean canDestroyBlockInCreative(World world, BlockPos pos, ItemStack stack, EntityPlayer player) {
        return false;
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

        if(!world.isRemote) {
            if (entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entity;
        if((weapontype & TOME) !=0){PotionEffect potioneffect1 = new PotionEffect(MobEffects.STRENGTH, 100, 5, false, false);
            PotionEffect potionEffect3 = new PotionEffect(MobEffects.FIRE_RESISTANCE, 100, 5, false, false);
            PotionEffect potioneffect4 = new PotionEffect(MobEffects.REGENERATION, 100, 3, false, false);
            PotionEffect potioneffect5 = new PotionEffect(MobEffects.HASTE, 100, 5, false, false);
            PotionEffect potionEffect6 = new PotionEffect(MobEffects.SPEED, 100, 5, false, false);
            PotionEffect potionEffect7 = new PotionEffect(MobEffects.SPEED, 200, 7, false, false);
            if(player.isSneaking() && player.getHeldItem(EnumHand.MAIN_HAND) == is){
                if(elementmelee == "fire")
                {
                    player.addPotionEffect(potioneffect1);
                    player.addPotionEffect(potionEffect3);
                    player.getCapability(AuraProvider.AURA_CAP, null).useAura(player, 0.15F, false);
                }
                if(elementmelee == "water"){
                    player.addPotionEffect(potioneffect4);
                    player.getCapability(AuraProvider.AURA_CAP, null).useAura(player, 0.15F, false);
                }
                if(elementmelee == "light"){
                    player.addPotionEffect(potioneffect5);
                    player.addPotionEffect(potionEffect6);
                    player.getCapability(AuraProvider.AURA_CAP, null).useAura(player, 0.15F, false);
                }
                if(elementmelee == "wind"){
                    player.addPotionEffect(potionEffect7);
                    player.getCapability(AuraProvider.AURA_CAP, null).useAura(player, 0.15F, false);
                }}
        }}}



        if((weapontype & (SANREI|LETZT|AURAWEAP)) !=0){
            EntityPlayer player = (EntityPlayer) entity;
            if((weapontype & (SANREI|AURAWEAP)) !=0){
            player.getCapability(AuraProvider.AURA_CAP, null).useAura(player, 0.15F, false);}
            if(is.getItem() == RWBYItems.leafshield){
                player.getCapability(AuraProvider.AURA_CAP, null).useAura(player, 0.05F,false);
            }
            if(is.getItem() == RWBYItems.pickaxeshield){
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.NIGHT_VISION, 20, 1, false, false);
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.HASTE, 20, 1, false, false);
                player.addPotionEffect(potioneffect1);
                player.addPotionEffect(potioneffect2);
            }
            if(is.getItem() == RWBYItems.rageshield){
                PotionEffect potioneffect = new PotionEffect(MobEffects.FIRE_RESISTANCE, 20, 1, false, false);
                player.getCapability(AuraProvider.AURA_CAP, null).useAura(player, 0.1F,false);
                player.addPotionEffect(potioneffect);
            }
            if((weapontype & LETZT) !=0){
                player.getCapability(AuraProvider.AURA_CAP, null).useAura(player, 0.3F, false);
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
        return enchantment.type.canEnchantItem(Items.DIAMOND_SWORD);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        Block block = state.getBlock();
        Material material = block.getMaterial(state);
        //System.out.println(weapontype + material.toString());
            if((weapontype & AXE) !=0){
            return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? -9999F : 5F;}
            //else if((weapontype & TOOL) !=0) {return 5F;}
            else if((weapontype & PICKAXE) !=0){
                return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK ? -9999F : 5F;}
            else if(stack.getItem() == RWBYItems.leafshield){
                return material != Material.PLANTS && material != Material.VINE ? -9999F : 5F;
            }else return 0F;


    }



    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        if (!worldIn.isRemote && (double)state.getBlockHardness(worldIn, pos) != 0.0D && (weapontype & TOOL) !=0)
        {
        stack.damageItem(20, entityLiving);
        }
        if (!worldIn.isRemote && (double)state.getBlockHardness(worldIn, pos) != 0.0D)
        {
            stack.damageItem(1, entityLiving);
        }

        return true;
    }

    @Override
    public void onUsingTick(ItemStack stack, EntityLivingBase player, int count) {
        super.onUsingTick(stack, player, count);
        EntityPlayer playerIn = (EntityPlayer) player;
        if(stack.getItem() == RWBYItems.elucidator || stack.getItem() == RWBYItems.darkrepulser){
            playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 60, 2));
        if(!weaponuseglow){weaponuseglow = true; }}
        if (!playerIn.onGround && playerIn.getItemInUseCount() > 1 && (weapontype & (FLIGHT)) !=0 && player.getCapability(AuraProvider.AURA_CAP, null).getPercentage() > 0.05)
        {
            Vec3d look = playerIn.getLookVec();
            playerIn.motionX = look.x/4;
            playerIn.motionZ = look.z/4;
            player.motionY = look.y/2;
            player.fallDistance = 0;
            player.velocityChanged = true;
            player.getCapability(AuraProvider.AURA_CAP, null).useAura(playerIn, 0.15F, false);
            player.getCapability(AuraProvider.AURA_CAP, null).delayRecharge(30);
        }
        if (!playerIn.onGround && playerIn.getItemInUseCount() > 1 && (weapontype & (UMBRELLA)) !=0)
        {
            Vec3d look = playerIn.getLookVec();
            playerIn.motionX = look.x/2;
            playerIn.motionZ = look.z/2;
            //playerIn.lastTickPosZ = -look.x;
            //playerIn.lastTickPosX = -look.z;
            player.motionY = -0.1;
            player.fallDistance = 0;
            player.velocityChanged = true;
        }
        }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if((weapontype & STAFF) !=0){PotionEffect potioneffect1 = new PotionEffect(MobEffects.STRENGTH, 100, 5, false, false);
        PotionEffect potioneffect2 = new PotionEffect(MobEffects.LEVITATION, 100, 5, false, false);
        PotionEffect potionEffect3 = new PotionEffect(MobEffects.FIRE_RESISTANCE, 100, 5, false, false);
        PotionEffect potioneffect4 = new PotionEffect(MobEffects.REGENERATION, 100, 3, false, false);
        PotionEffect potioneffect5 = new PotionEffect(MobEffects.HASTE, 100, 5, false, false);
        PotionEffect potionEffect6 = new PotionEffect(MobEffects.SPEED, 100, 5, false, false);
        PotionEffect potionEffect7 = new PotionEffect(MobEffects.SPEED, 200, 7, false, false);
        if(handIn == EnumHand.MAIN_HAND){
            if(elementmelee == "grav")
            {
                playerIn.addPotionEffect(potioneffect2);
            }
            if(elementmelee == "fire")
            {
                playerIn.addPotionEffect(potioneffect1);
                playerIn.addPotionEffect(potionEffect3);
            }
            if(elementmelee == "water"){
                playerIn.addPotionEffect(potioneffect4);
            }
            if(elementmelee == "light"){
                playerIn.addPotionEffect(potioneffect5);
                playerIn.addPotionEffect(potionEffect6);
            }
            if(elementmelee == "wind"){
                playerIn.addPotionEffect(potionEffect7);
            }}}


        ItemStack is = playerIn.getHeldItem(handIn);
        boolean flag = !this.findAmmo(playerIn, false).isEmpty();
        if (!flag) {if ((weapontype & WALLCLIMB) !=0)  { if (playerIn.collidedHorizontally){
            Vec3d look = playerIn.getLookVec();
            playerIn.motionX = look.x/2;
            playerIn.motionZ = look.z/2;
            playerIn.motionY = look.y/2;
            playerIn.lastTickPosZ = -look.x;
            playerIn.lastTickPosX = -look.z;
            compensate = true;
            playerIn.fallDistance = 0;
        }}}
        if (!worldIn.isRemote && playerIn.isSneaking() && this.morph != null) {
            ItemStack morph1 = new ItemStack(Item.getByNameOrId(this.morph), is.getCount(), is.getMetadata());
            //noinspection ConstantConditions
            if (is.hasTagCompound()) {
                morph1.setTagCompound(is.getTagCompound());
            }
            if (handIn == EnumHand.MAIN_HAND) {
                playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, morph1);
            }
        return new ActionResult<>(EnumActionResult.FAIL, is);
        } else if (this.isShield && handIn == EnumHand.OFF_HAND) {
            playerIn.setActiveHand(EnumHand.OFF_HAND);
            return new ActionResult<>(EnumActionResult.SUCCESS, is);}else if (canBlock && handIn == EnumHand.MAIN_HAND) {
            playerIn.setActiveHand(EnumHand.MAIN_HAND);
            return new ActionResult<>(EnumActionResult.SUCCESS, is);
        }else if ((weapontype & SCARLET) !=0 && handIn == EnumHand.MAIN_HAND) {
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
        if(stack.getItem() == RWBYItems.chatareusgun || (weapontype & (SANREI | LETZT)) !=0){
            return EnumAction.BOW;
        }else if(stack.getItem() == RWBYItems.cinderbow){
            return EnumAction.BOW;
        }else if(canBlock||isShield){return  EnumAction.BLOCK;}else return EnumAction.NONE;
    }

    @Nonnull
    private ItemStack findAmmo(EntityPlayer player, boolean force) {

        Item ammo1 = this.ammo == null ? Items.ARROW : Item.getByNameOrId(this.ammo);
        if (force || (ammo1 instanceof ItemArrow && ((ItemArrow) ammo1).isInfinite(null, player.getActiveItemStack(), player))
                || (ammo1 instanceof RWBYAmmoItem && ((RWBYAmmoItem) ammo1).isInfinite())) {
            return new ItemStack(ammo1);
        }

        // the rest is a copy from ItemBow#findAmmo(EntityPlayer)
       /* if (this.isArrow(player.getItemStackFromSlot(EntityEquipmentSlot.FEET))) {
            return player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
        }else*/
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
        if(entityLiving instanceof EntityPlayer){
            EntityPlayer playerIn = (EntityPlayer)entityLiving;
        if (!playerIn.world.isRemote && playerIn.isSneaking()&& this.element != null&& playerIn.getHeldItemMainhand() == stack) {
            ItemStack morph1 = new ItemStack(Item.getByNameOrId(this.element), stack.getCount(), stack.getMetadata());
            //noinspection ConstantConditions
            if (stack.hasTagCompound()) {
                morph1.setTagCompound(stack.getTagCompound());
            }
            if (playerIn.getHeldItemMainhand() == stack) {
                playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, morph1);}
        }}

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


            if(weaponuseglow){
                stack.damageItem(20, entityplayer);
                weaponuseglow = false;
            }

            ItemStack is = entityplayer.getActiveItemStack();
            if (is.getItem() == RWBYItems.pyrrharifle && entityplayer.getActiveHand() == EnumHand.OFF_HAND||is.getItem() == RWBYItems.pyrrhaspear && entityplayer.getActiveHand() == EnumHand.OFF_HAND)
            {
                flag2 = false;
            }

            if(entityplayer.getItemInUseCount() > stack.getMaxItemUseDuration() * 0.75F && (weapontype & (ROCKET|BOW)) !=0){
                flag2 = false;

            }

            if(flag2 && charges && !dualwield){entityplayer.getCooldownTracker().setCooldown(this, 5);}


            if(ohblade && entityplayer.getActiveHand() == EnumHand.OFF_HAND){
                flag2 = false;
            }

            if((weapontype & SANREI) !=0 && entityplayer.getCapability(AuraProvider.AURA_CAP, null).getAmount() < 10){flag2 = false;}

            if((weapontype & LETZT) !=0 && entityplayer.getCapability(AuraProvider.AURA_CAP, null).getAmount() < 20){flag2 = false;}

            if(ohblade && entityLiving instanceof EntityPlayer && entityLiving.getHeldItemOffhand() == stack) {
                Entity entity = this.findEntityOnPath(worldIn, entityLiving, entityLiving.getEntityAttribute(EntityPlayer.REACH_DISTANCE).getAttributeValue());
                if (entity instanceof EntityLivingBase) {
                    EntityLivingBase entitylivingbase = (EntityLivingBase) entity;
                    if (entitylivingbase != entityLiving && !entityLiving.isOnSameTeam(entitylivingbase)) {
                        entitylivingbase.knockBack(entityLiving, 0.4F, (double) MathHelper.sin(entityLiving.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(entityLiving.rotationYaw * 0.017453292F)));
                        entitylivingbase.attackEntityFrom(DamageSource.causePlayerDamage(entityplayer), damages + 4);
                        stack.damageItem(1, entityLiving);
                        entityLiving.world.playSound((EntityPlayer) null, entityLiving.posX, entityLiving.posY, entityLiving.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, entityLiving.getSoundCategory(), 1.0F, 1.0F);
                    }
                }
            }

            if((weapontype & WHIP) !=0 && entityLiving instanceof EntityPlayer && entityLiving.getHeldItemMainhand() == stack) {
                Entity entity = this.findEntityOnPath(worldIn, entityLiving, entityLiving.getEntityAttribute(EntityPlayer.REACH_DISTANCE).getAttributeValue()+4);
                if (entity instanceof EntityLivingBase) {
                    EntityLivingBase entitylivingbase = (EntityLivingBase) entity;
                    if (entitylivingbase != entityLiving && !entityLiving.isOnSameTeam(entitylivingbase)) {
                        entitylivingbase.knockBack(entityLiving, 0.4F, (double) MathHelper.sin(entityLiving.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(entityLiving.rotationYaw * 0.017453292F)));
                        entitylivingbase.attackEntityFrom(DamageSource.causePlayerDamage(entityplayer), damages);
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
                        entitylivingbase.attackEntityFrom(DamageSource.causePlayerDamage(entityplayer), damages);
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

            if(entityplayer.getItemInUseCount() < 60 && (weapontype & LION_HEART) !=0){
                flag2 = false;
            }

            if(entityplayer.getItemInUseCount() < 60 && (weapontype & FLIGHT) !=0){
                flag2 = false;
            }

            if (flag2 || flag) {


                float f = getArrowVelocity(72);
            if((weapontype & (SANREI | LETZT)) !=0){
                f = getArrowVelocity(i);
            }
                if ((double) f >= 0.1D) {

                    if (!worldIn.isRemote) {

                        int inaccuracy;
                   if(shotcount > 2){inaccuracy = 0;}else {inaccuracy = shotcount;}
                        for (int i2 = 0; i2 < finishshot; i2++) {
                            EntityArrow entityarrow = (itemstack.getItem() instanceof RWBYAmmoItem ? ((RWBYAmmoItem) itemstack.getItem()).createArrow(worldIn, itemstack, stack, entityplayer) : ((ItemArrow) Items.ARROW).createArrow(worldIn, itemstack, entityplayer));
                            entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F * (this.projectileSpeed == 0.0F ? 1.0F : this.projectileSpeed), inaccuracy*itemRand.nextInt(5));

                            //System.out.println(inaccuracy);
                            entityarrow.setIsCritical(true);

                            worldIn.spawnEntity(entityarrow);
                            //if (f >= 1.0F) entityarrow.setIsCritical(true);
                        }
                        if((weapontype & SANREI) !=0){
                            if (entityplayer.hasCapability(AuraProvider.AURA_CAP, null)) {
                                entityplayer.getCapability(AuraProvider.AURA_CAP, null).useAura(entityplayer, 10F, false);
                                entityplayer.getCapability(AuraProvider.AURA_CAP, null).delayRecharge(60);
                            }
                        }else if((weapontype & LETZT) !=0){
                            if (entityplayer.hasCapability(AuraProvider.AURA_CAP, null)) {
                                entityplayer.getCapability(AuraProvider.AURA_CAP, null).useAura(entityplayer, 20F, false);
                                entityplayer.getCapability(AuraProvider.AURA_CAP, null).delayRecharge(60);
                            }
                        }
                        else if ((weapontype & JUNIOR) !=0) {stack.damageItem(30,entityplayer);}
                        else if ((weapontype & INT_MAG) !=0) {stack.damageItem(4, entityplayer);}
                        else if ((weapontype & THROWN) !=0) {stack.shrink(1);}
                        if (!flag){
                            if ((weapontype & BOW) !=0 && !flagger) {
                                itemstack.shrink(1);
                            }
                        }



                        if (!flag){
                            if (mytre || (weapontype &(ROCKET|FLIGHT)) !=0) {
                                if(itemstack.getUnlocalizedName().contains("dustcrystal")){itemstack.damageItem(1, entityplayer);
                                stack.damageItem(1,entityplayer);
                                }else {
                                itemstack.shrink(1);stack.damageItem(1,entityplayer);}

                            }
                            else {
                                itemstack.damageItem(1, entityplayer);
                            }
                        }
                        else stack.damageItem(2, entityplayer);
                    }

                    if (soundeffect == 1) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Crescent_Rose_Shoot, SoundCategory.MASTER, RWBYConfig.general.gunvolume, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 2){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Ember_Celica_Shoot, SoundCategory.MASTER, RWBYConfig.general.gunvolume, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 3) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Gambol_Shroud_Shoot, SoundCategory.MASTER, RWBYConfig.general.gunvolume, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 4) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Mytrenaster_Shoot, SoundCategory.MASTER, RWBYConfig.general.gunvolume, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 5){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.StormFlower_Shoot, SoundCategory.MASTER, RWBYConfig.general.gunvolume, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 6) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Magnhild_Shoot, SoundCategory.MASTER, RWBYConfig.general.gunvolume, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 7) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Ember_Celica_Shoot, SoundCategory.MASTER, RWBYConfig.general.gunvolume, 0.2F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 8) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Port_Shoot, SoundCategory.MASTER, RWBYConfig.general.gunvolume, 0.8F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 9) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Gambol_Shroud_Shoot, SoundCategory.MASTER, RWBYConfig.general.gunvolume, 0.7F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 10) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Junior_Shoot, SoundCategory.MASTER, RWBYConfig.general.gunvolume, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 11) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Torchwick_Shoot, SoundCategory.MASTER, RWBYConfig.general.gunvolume, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 12) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Crescent_Rose_Shoot, SoundCategory.MASTER, RWBYConfig.general.gunvolume, 2F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 13) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Crescent_Rose_Shoot, SoundCategory.MASTER, RWBYConfig.general.gunvolume/2, 3F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 14){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.StormFlower_Shoot, SoundCategory.MASTER, RWBYConfig.general.gunvolume, 0.5F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if(soundeffect == 15){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, RWBYConfig.general.gunvolume, 0.5F/ (itemRand.nextFloat() * 0.4F + 1.0F) + f + 0.5F);
                    }

                    if(soundeffect == 16){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, RWBYConfig.general.gunvolume, 0.5F/ (itemRand.nextFloat() * 0.4F + 1.0F) + f + 0.5F);
                    }

                    if(soundeffect == 17){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ENDERPEARL_THROW, SoundCategory.MASTER, RWBYConfig.general.gunvolume, 0.5F/ (itemRand.nextFloat() * 0.4F + 1.0F) + f + 0.5F);
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
                    //if((weapontype & FLIGHT) !=0){stack.damageItem(5, entityplayer);}
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
    {
        EntityPlayer p=null;
        if(attacker instanceof EntityPlayer) p=(EntityPlayer)attacker;
        if((weapontype & (RAPIER | WINTER)) !=0){
        //Rapier
        boolean unarm = false;
        if(target.getTotalArmorValue() == 0){
            unarm = true; }

        if(!unarm && !ohblade){
            if(this.validperk(attacker,ArmourBase.PUNCTURE1)){if(p!=null){
                target.attackEntityFrom(DamageSource.causePlayerDamage(p), 38);}
            else target.attackEntityFrom(DamageSource.causeMobDamage(attacker), 38);}
            else if(this.validperk(attacker,ArmourBase.PUNCTURE2)){if(p!=null){
                target.attackEntityFrom(DamageSource.causePlayerDamage(p), 45);}
            else target.attackEntityFrom(DamageSource.causeMobDamage(attacker), 45);}
            else if(p!=null){
            target.attackEntityFrom(DamageSource.causePlayerDamage(p), 35);}
            else target.attackEntityFrom(DamageSource.causeMobDamage(attacker), 35);
        }}

        if((weapontype & (FIST|HAMMER)) !=0){
            int rand = new Random().nextInt(100);
            if ((weapontype & FIST) !=0){
                if(this.validperk(attacker,ArmourBase.K01)){
                if(rand <= 20){
                    PotionEffect effect = new PotionEffect(MobEffects.NAUSEA, 60, 1);
                    target.addPotionEffect(effect);
                }}else if ((weapontype & FIST) !=0) {
                    if (this.validperk(attacker, ArmourBase.K02)) {
                        if (rand <= 25) {
                            PotionEffect effect = new PotionEffect(MobEffects.NAUSEA, 60, 1);
                            target.addPotionEffect(effect);
                        }
                    } else {
                        if (rand <= 15) {
                            PotionEffect effect = new PotionEffect(MobEffects.NAUSEA, 60, 1);
                            target.addPotionEffect(effect);
                        }
                    }
                }
            }
            if ((weapontype & HAMMER) !=0){
                if(this.validperk(attacker,ArmourBase.K01)){
                if(rand <= 30){
                    PotionEffect effect = new PotionEffect(MobEffects.NAUSEA, 120, 1);
                    target.addPotionEffect(effect);
                }}else if(this.validperk(attacker,ArmourBase.K02)){
                    if(rand <= 35){
                        PotionEffect effect = new PotionEffect(MobEffects.NAUSEA, 120, 1);
                        target.addPotionEffect(effect);
                    }}else {  if(rand <= 25){
                    PotionEffect effect = new PotionEffect(MobEffects.NAUSEA, 120, 1);
                    target.addPotionEffect(effect);
                }}
            }
        }

        if((weapontype & (DAGGER)) !=0||gwen){
            if(this.validperk(attacker, ArmourBase.CRITICALSTRIKE1)){
            if (target.getHealth() >= 75.0F && (new Random()).nextInt(100) <= 30) {
            if (attacker instanceof EntityPlayer) {
                target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)attacker).setDamageBypassesArmor(), 100.0F);
            } else {
                target.attackEntityFrom(DamageSource.WITHER, 100.0F);
            }
        }}else if(this.validperk(attacker, ArmourBase.CRITICALSTRIKE2)){
                if (target.getHealth() >= 50.0F && (new Random()).nextInt(100) <= 30) {
                    if (attacker instanceof EntityPlayer) {
                        target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)attacker).setDamageBypassesArmor(), 100.0F);
                    } else {
                        target.attackEntityFrom(DamageSource.WITHER, 100.0F);
                    }
                }} else {
        if (target.getHealth() >= 100.0F && (new Random()).nextInt(100) <= 30) {
            if (attacker instanceof EntityPlayer) {
                target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)attacker).setDamageBypassesArmor(), 100.0F);
            } else {
                target.attackEntityFrom(DamageSource.WITHER, 100.0F);
            }
        }}}

        if(stack.getItem() == RWBYItems.rageshield && attacker.isSneaking()){
            EntityEvokerFangs entity = new EntityEvokerFangs(target.world);
            entity.setPosition(target.posX, target.posY, target.posZ);
            target.world.spawnEntity(entity);
            target.attackEntityFrom(DamageSource.DRAGON_BREATH, 50);
            PotionEffect potioneffect1 = new PotionEffect(MobEffects.WITHER, 200, 10, true, true);
            target.addPotionEffect(potioneffect1);

            if (attacker instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer) attacker;
            if (entityplayer.hasCapability(AuraProvider.AURA_CAP, null)) {
                entityplayer.getCapability(AuraProvider.AURA_CAP, null).useAura(entityplayer, 100F, false);
                entityplayer.getCapability(AuraProvider.AURA_CAP, null).delayRecharge(60);
            }}

        }

        if((weapontype & SCYTHE) !=0){
            //Scythe
            if(this.validperk(attacker,ArmourBase.REACH1)){
            for (EntityLivingBase entitylivingbase : attacker.world.getEntitiesWithinAABB(EntityLivingBase.class, target.getEntityBoundingBox().grow(4.0D, 0.25D, 4.0D))) {
                if (entitylivingbase != attacker && entitylivingbase != target && !attacker.isOnSameTeam(entitylivingbase) && attacker.getDistanceSq(entitylivingbase) < 9.0D) {
                    entitylivingbase.knockBack(attacker, 0.4F, (double) MathHelper.sin(attacker.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(attacker.rotationYaw * 0.017453292F)));
                    IAttributeInstance attackerdamages = new AttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
                    for (AttributeModifier modifier : attacker.getHeldItemMainhand().getAttributeModifiers(EntityEquipmentSlot.MAINHAND).get(SharedMonsterAttributes.ATTACK_DAMAGE.getName()))
                        attackerdamages.applyModifier(modifier);

                    double dm = attackerdamages.getAttributeValue();
                    int attackerdamage = (int)dm;
                    if(p!=null)
                    entitylivingbase.attackEntityFrom(DamageSource.causePlayerDamage(p), attackerdamage);
                    else entitylivingbase.attackEntityFrom(DamageSource.causeMobDamage(attacker), attackerdamage);
                }
            }}else if(this.validperk(attacker,ArmourBase.REACH2)){
                for (EntityLivingBase entitylivingbase : attacker.world.getEntitiesWithinAABB(EntityLivingBase.class, target.getEntityBoundingBox().grow(5.0D, 0.25D, 5.0D))) {
                    if (entitylivingbase != attacker && entitylivingbase != target && !attacker.isOnSameTeam(entitylivingbase) && attacker.getDistanceSq(entitylivingbase) < 9.0D) {
                        entitylivingbase.knockBack(attacker, 0.4F, (double) MathHelper.sin(attacker.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(attacker.rotationYaw * 0.017453292F)));
                        IAttributeInstance attackerdamages = new AttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
                        for (AttributeModifier modifier : attacker.getHeldItemMainhand().getAttributeModifiers(EntityEquipmentSlot.MAINHAND).get(SharedMonsterAttributes.ATTACK_DAMAGE.getName()))
                            attackerdamages.applyModifier(modifier);

                        double dm = attackerdamages.getAttributeValue();
                        int attackerdamage = (int)dm;
                        if(p!=null)
                            entitylivingbase.attackEntityFrom(DamageSource.causePlayerDamage(p), attackerdamage);
                        else entitylivingbase.attackEntityFrom(DamageSource.causeMobDamage(attacker), attackerdamage);
                    }
                }}else {
                for (EntityLivingBase entitylivingbase : attacker.world.getEntitiesWithinAABB(EntityLivingBase.class, target.getEntityBoundingBox().grow(3.0D, 0.25D, 3.0D))) {
                    if (entitylivingbase != attacker && entitylivingbase != target && !attacker.isOnSameTeam(entitylivingbase) && attacker.getDistanceSq(entitylivingbase) < 9.0D) {
                        entitylivingbase.knockBack(attacker, 0.4F, (double) MathHelper.sin(attacker.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(attacker.rotationYaw * 0.017453292F)));
                        IAttributeInstance attackerdamages = new AttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
                        for (AttributeModifier modifier : attacker.getHeldItemMainhand().getAttributeModifiers(EntityEquipmentSlot.MAINHAND).get(SharedMonsterAttributes.ATTACK_DAMAGE.getName()))
                            attackerdamages.applyModifier(modifier);

                        double dm = attackerdamages.getAttributeValue();
                        int attackerdamage = (int)dm;
                        if(p!=null)
                            entitylivingbase.attackEntityFrom(DamageSource.causePlayerDamage(p), attackerdamage);
                        else entitylivingbase.attackEntityFrom(DamageSource.causeMobDamage(attacker), attackerdamage);
                    }
                }}

            attacker.world.playSound((EntityPlayer) null, attacker.posX, attacker.posY, attacker.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, attacker.getSoundCategory(), 1.0F, 1.0F);
        }

        if((weapontype & SWORD) !=0){
            //Sword
            for (EntityLivingBase entitylivingbase : attacker.world.getEntitiesWithinAABB(EntityLivingBase.class, target.getEntityBoundingBox().grow(3.0D, 0.25D, 3.0D))) {
                if (entitylivingbase != attacker && entitylivingbase != target && !attacker.isOnSameTeam(entitylivingbase) && attacker.getDistanceSq(entitylivingbase) < 9.0D) {
                    if(this.validperk(attacker,ArmourBase.GLADIATOR1)){
                    entitylivingbase.knockBack(attacker, 0.6F, (double) MathHelper.sin(attacker.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(attacker.rotationYaw * 0.017453292F)));}
                    if(this.validperk(attacker,ArmourBase.GLADIATOR2)){
                        entitylivingbase.knockBack(attacker, 1.2F, (double) MathHelper.sin(attacker.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(attacker.rotationYaw * 0.017453292F)));}else
                    { entitylivingbase.knockBack(attacker, 0.4F, (double) MathHelper.sin(attacker.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(attacker.rotationYaw * 0.017453292F)));}
                    IAttributeInstance attackerdamages = new AttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
                    for (AttributeModifier modifier : attacker.getHeldItemMainhand().getAttributeModifiers(EntityEquipmentSlot.MAINHAND).get(SharedMonsterAttributes.ATTACK_DAMAGE.getName()))
                            attackerdamages.applyModifier(modifier);

                    double dm = attackerdamages.getAttributeValue();
                    int attackerdamage = (int)dm;
                    if(p!=null)
                    entitylivingbase.attackEntityFrom(DamageSource.causePlayerDamage(p), attackerdamage);
                    else entitylivingbase.attackEntityFrom(DamageSource.causeMobDamage(attacker), attackerdamage);
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

            if(elementmelee == "wind"){
            multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(MOVEMENT_SPEED, "Speed modifier", 0.2, 0));}
        }

        return multimap;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        if (kkice || kkfire || kkwind){return false;}
        else return repair.getItem() == RWBYItems.scrap || super.getIsRepairable(toRepair, repair);
    }
    
}




