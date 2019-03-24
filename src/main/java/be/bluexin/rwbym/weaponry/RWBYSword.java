package be.bluexin.rwbym.weaponry;

import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.RWBYModels;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
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

/**
 * Part of rwbym
 *
 * @author Bluexin
 */
@MethodsReturnNonnullByDefault
public class RWBYSword extends ItemSword implements ICustomItem {
    public final boolean isShield;
    public boolean neo = false;
    public final boolean canBlock;
    private final String data;
    //private final RecipeDTO[] recipes;
    private final String morph;
    private boolean fire;
    private boolean ice;
    private boolean velvet = false;
    private boolean crescentr = false;
    private boolean kkfire = false;
    private boolean kkice = false;
    private boolean kkwind = false;
    public boolean reese;
    public static boolean runhideevent = false;
    private int timer;
    private boolean magna = false;

    public RWBYSword(String name, int durability, float damage, int enchantability, String data, String morph, boolean shield, boolean canBlock, boolean fire, boolean ice, int enchantmentglow, CreativeTabs creativetab) {
        super(EnumHelper.addToolMaterial(RWBYModels.MODID + ":" + name, 0, durability, 1.0F, damage, enchantability));
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(creativetab);
        this.data = data;
        if(name.contains("nora")) magna = true;
        if(name.contains("kkfire")) kkfire = true;
        if(name.contains("kkice")) kkice = true;
        if(name.contains("kkwind")) kkwind = true;
        //this.recipes = from.getRecipes();
        if(name.contains("crescent")) crescentr = true;
        if(name.contains("neoumb_closed")) neo = true;
        if(name.contains("neoumb_closed_blade")) neo = true;
        if(name.contains("neoumb_handle_blade")) neo = true;
        if(name.contains("reese")) neo = true;
        if(name.contains("reese")) reese = true;

        this.morph = morph;
        this.fire = fire;
        this.ice = ice;
        this.canBlock = canBlock;
        this.isShield = shield;
        if(enchantmentglow == 1) this.velvet = true;

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
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        PotionEffect potioneffect = new PotionEffect(MobEffects.SLOWNESS, 200, 5, true, true);
       if (fire){target.setFire(10);}
       if (ice){
           target.addPotionEffect(potioneffect);
       }

        stack.damageItem(1, attacker);
        return true;
    }

    /*@Override
    public void registerRecipes() {
        if (this.recipes != null) for (RecipeDTO recipe : this.recipes) {
            recipe.register(this);
        }
    }*/


    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        if(velvet){return true;}
        else
            return false;
    }

    @SuppressWarnings("Duplicates")
    public void onUpdate(ItemStack is, World world, Entity entity, int slotIn, boolean inHand) {

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
        if(entity instanceof  EntityPlayer){
            EntityPlayer player = (EntityPlayer) entity;
            if(player.getHeldItemMainhand().getItem() == RWBYItems.reese && player.getHeldItemMainhand().getOrCreateSubCompound("RWBYM").getInteger("inactive") < 2){
            	
                if (world.isRemote) {
                
                	double r = player.rotationYaw * Math.PI / 180;
                
	                double x = player.motionX;
	                double y = player.motionY;
	                double z = player.motionZ;
	                BlockPos pos;
	                for (pos = new BlockPos(player); world.isAirBlock(pos) && pos.getY() > 0; pos = pos.add(0, -1, 0));
	                
	                double u = z*Math.cos(r) - x*Math.sin(r);
	                double v = -x*Math.cos(r) - z*Math.sin(r);
	                
	                double mu = 0;
	                double mv = 0;
	                double my = 2;
	                                                
	                if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown()) {
	                	mu += 1.5;
	                }
	                if (Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown()) {
	                	mu -= 0.2;
	                }
	                if (Minecraft.getMinecraft().gameSettings.keyBindLeft.isKeyDown()) {
	                	mv -= 1.5;
	                }
	                if (Minecraft.getMinecraft().gameSettings.keyBindRight.isKeyDown()) {
	                	mv += 1.5;
	                }
	                
	                if (player.isSprinting()) {
	                	mu *= 2;
	                	mv *= 2;
	                }
	                if (player.isSneaking()) {
	                	mu /= 2;
	                	mv /= 2;
	                	my /= 2;
	                }
	                                
	                double du = mu - u;
	                double dv = mv - v;
	                double dy = my - y;
	                
	                double a = mu != 0 ? Math.atan(mv/mu) / Math.PI * 180 : mv == 0 ? 0 : 90 * mv / Math.abs(mv);
	                	                
	                player.renderYawOffset = (float) (player.rotationYaw + a);
	                
	                dy = my - (player.posY - (pos.getY() + 1));
	                
	                double d = 0.3;
	                
	                if (dy < -1) {
	                	d /= -dy;
	                }
	                
	                if (dy < 0) {
	                	dy = 0;
	                }
	                                
	                u += du * 0.05;
	                v += dv * 0.05;
	                y += dy * 0.15 - d*y;
	                
	                x = -v*Math.cos(r) - u*Math.sin(r);
	                z = u*Math.cos(r) - v*Math.sin(r);
	                
	                player.motionX = x;
	                player.motionY = y;
	                player.motionZ = z;
                }
                
            	if (!world.isRemote) {
	                this.timer++;
	                if(timer > 20){
		                player.getActiveItemStack().damageItem(1, player);
		                this.timer = 0;
	                }
	            	
	                player.fallDistance = 0;
	
	                AxisAlignedBB axisalignedbb = player.getEntityBoundingBox().grow(1,0,1);
	
	                List<Entity> list1 = player.world.getEntitiesWithinAABBExcludingEntity(player, axisalignedbb);
	
	                if (!list1.isEmpty())
	                {
	                    double y1 = Math.pow(player.motionY, 2);
	                    double x1 = Math.pow(player.motionX, 2);
	                    double z1 = Math.pow(player.motionZ, 2);
	                    
	                    double d3 = Math.sqrt(x1+y1+z1);
	                    float f = (float)d3;
	                    RWBYModels.LOGGER.info(d3);
	
	                    for (Entity entity2 : list1)
	                    {
	                        if (entity2 instanceof EntityLivingBase) {
	                            EntityLivingBase entitylivingbase = (EntityLivingBase)entity2;
	                            entitylivingbase.attackEntityFrom(new EntityDamageSource("rose petal", player), f*10);
	                            player.getActiveItemStack().damageItem(1, player);
	                        }
	                    }
	                }
            	}
            }
            if (!player.isHandActive()) {
            	NBTTagCompound nbt = is.getOrCreateSubCompound("RWBYM");
            	nbt.setInteger("inactive", nbt.getInteger("inactive") + 1);
            	if (nbt.getInteger("inactive") < 2 && player.getHeldItemMainhand().getItem() == RWBYItems.reese) {
            		player.setActiveHand(EnumHand.MAIN_HAND);
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
    }



    @ParametersAreNonnullByDefault
    @Override
    public ActionResult<ItemStack> onItemRightClick( World worldIn, EntityPlayer playerIn, EnumHand hand) {
        ItemStack is = playerIn.getHeldItem(hand);
        

        
        if (!worldIn.isRemote && playerIn.isSneaking() && this.morph != null) {
            is = new ItemStack(Item.getByNameOrId(this.morph), is.getCount(), is.getMetadata());
            return new ActionResult<>(EnumActionResult.SUCCESS, is);
        } else if (this.isShield && hand == EnumHand.OFF_HAND) {
            playerIn.setActiveHand(EnumHand.OFF_HAND);
            return new ActionResult<>(EnumActionResult.SUCCESS, is);
        }else if ((canBlock || reese) && hand == EnumHand.MAIN_HAND) {
            playerIn.setActiveHand(EnumHand.MAIN_HAND);
            NBTTagCompound nbt = is.getOrCreateSubCompound("RWBYM");
            nbt.setInteger("inactive", 0);

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
    public int getMaxItemUseDuration(ItemStack stack) {
        return this.isShield ? 72000 : this.canBlock || this.reese ? 72000 : 0;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return this.isShield ? EnumAction.BLOCK : this.canBlock ? EnumAction.BLOCK : this.reese ? EnumAction.BOW : EnumAction.NONE;
    }


    @Override
    public String toString() {
        return "RWBYSword{" + this.getRegistryName() + "}";
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (kkfire || kkwind || kkice){
            ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
            chest.damageItem(1, player);
    }
        return super.onLeftClickEntity(stack, player, entity);
    }


    @Override
    public boolean isRepairable() {
        if (kkice || kkfire || kkwind){return false;}
        else return true;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        if (kkice || kkfire || kkwind){return false;}
        else return repair.getItem() == RWBYItems.scrap || super.getIsRepairable(toRepair, repair);
    }

}
