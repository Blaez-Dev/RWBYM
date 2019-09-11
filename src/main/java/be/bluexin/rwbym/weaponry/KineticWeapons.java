package be.bluexin.rwbym.weaponry;

import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.utility.ExtraInfo;
import be.bluexin.rwbym.utility.network.MessagePlayerMotionUpdate;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import be.bluexin.rwbym.PlayerRenderHandler;
import be.bluexin.rwbym.RWBYModels;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
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
public class KineticWeapons extends ItemSword implements ICustomItem {
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

    public KineticWeapons(String name, int durability, float damage, int enchantability, String data, String morph, boolean shield, boolean canBlock, CreativeTabs creativetab) {
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

        if (this.neo) this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.getHeldItemMainhand().getItem() == RWBYItems.reese && entityIn.getHeldItemMainhand().getOrCreateSubCompound("RWBYM").getInteger("inactive") < 2 ? 1.0F : 0.0F;
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


    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        if(velvet){return true;}
        else
            return false;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, net.minecraft.enchantment.Enchantment enchantment)
    {
        return enchantment.type.canEnchantItem(Items.DIAMOND_HOE);
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
                	
                	boolean flag = player.isElytraFlying();

                    double r = player.rotationYaw * Math.PI / 180;

                    double x = player.motionX / (flag ? 0.99 : 0.91);
                    double y = player.motionY / 0.98;
                    double z = player.motionZ / (flag ? 0.99 : 0.91);
                    BlockPos pos;
                    for (pos = new BlockPos(player); world.isAirBlock(pos) && pos.getY() > 0; pos = pos.add(0, -1, 0));
                    
                    double u = z*Math.cos(r) - x*Math.sin(r);
                    double v = -x*Math.cos(r) - z*Math.sin(r);

                    double mu = 0;
                    double mv = 0;
                    double my = 0;
                    if(player.isInWater() || player.isOnLadder()){
                    my = 0;}else my = 2;
                    
                    if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown()) {
                        mu += player.getAIMoveSpeed() * 5;
                    }
                    if (Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown()) {
                        mu -= player.getAIMoveSpeed() * 0.5;
                    }
                    if (Minecraft.getMinecraft().gameSettings.keyBindLeft.isKeyDown()) {
                        mv -= player.getAIMoveSpeed() * 5;
                    }
                    if (Minecraft.getMinecraft().gameSettings.keyBindRight.isKeyDown()) {
                        mv += player.getAIMoveSpeed() * 5;
                    }

                    if (Minecraft.getMinecraft().gameSettings.keyBindSprint.isKeyDown()) {
                        mu *= 2;
                        mv *= 2;
                        //my *= 2;
                        if (player.isSprinting()) {
                        	player.setSprinting(false);
                        }
                    }
                    if (Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown()) {
                        mu /= 2;
                        mv /= 2;
                        //my /= 2;
                        if (player.isSneaking()) {
                        	player.setSneaking(false);
                        }
                    }
                    
                    double m = Math.sqrt(mu*mu + mv*mv);
                                        
                    if (m != 0) {
	                    mu = mu / m * Math.abs(mu == 0 ? mv : mu);
	                    mv = mv / m * Math.abs(mu == 0 ? mv : mu);
                    }
                    
                    double a = mu != 0 ? Math.atan(mv/mu) / Math.PI * 180 : mv == 0 ? 0 : 90 * mv / Math.abs(mv);
                    
                    if (mu == 0) {
                    	a = 0;
                    }
                    
                    double dy = my - (player.posY - (pos.getY() + 1));
                    
                    double py = y;
                    
                    if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown() && dy > 0 && !player.isInWater()) {
                		y += 2;
                    }

                    double du = mu - u;
                    double dv = mv - v;
                    
                    double d = 0.3;

                    if (dy < -1) {
                        d /= -dy;
                    }

                    if (dy < 0) {
                        dy = 0;
                        d = d / 2 * (y < 0 ? -y*5 : 0);
                    }
                    
                    u += du * 0.05;
                    v += dv * 0.1 / (Math.abs(v)*Math.abs(v) < 1 ? 1 : Math.abs(v)*Math.abs(v));
                    y += dy * 0.15 - d*y;
                    
                    double r2 = player.renderYawOffset * Math.PI / 180;

                    double u1 = z*Math.cos(r2) - x*Math.sin(r2);
                    double v1 = -x*Math.cos(r2) - z*Math.sin(r2);

                    x = -v*Math.cos(r) - u*Math.sin(r);
                    z = u*Math.cos(r) - v*Math.sin(r);
                    
                    double drag = 1;
                    x *= drag;
                    y *= drag;
                    z *= drag;

                    double u2 = z*Math.cos(r2) - x*Math.sin(r2);
                    double v2 = -x*Math.cos(r2) - z*Math.sin(r2);
                    
                    ExtraInfo info = PlayerRenderHandler.playerInfo.get(player);
                    
                    if (info == null) {
                    	info = new ExtraInfo();
                    	PlayerRenderHandler.playerInfo.put((EntityPlayerSP) player, info);
                    }

                    info.prevMotionF = info.motionF;
                    info.prevMotionR = info.motionR;
                    info.prevMotionU = info.motionU;
                    info.motionF = u2;
                    info.motionR = v2;
                    info.motionU = y;
                    info.prevAccelF = info.accelF;
                    info.prevAccelR = info.accelR;
                    info.accelF = u2 - u1;
                    info.accelR = v2 - v1;
                    info.prevAngle = info.angle;
                    info.angle = a;

                    player.motionX = x;
                    player.motionY = y;
                    player.motionZ = z;
                    
                    RWBYNetworkHandler.sendToServer(new MessagePlayerMotionUpdate(player));
                }

                if (!world.isRemote) {
                	
                	this.timer++;

                    player.fallDistance = 0;
                    
                    double y1 = player.motionY;
                    double x1 = player.motionX;
                    double z1 = player.motionZ;
                    
                    double d3 = Math.sqrt(x1*x1+y1*y1+z1*z1);
                    
                    /*if (y1 > 1) {
                    	//RWBYModels.LOGGER.info("damaged 10");
                    	player.getHeldItem(EnumHand.MAIN_HAND).damageItem(10, player);
                    }
                    
                   /* if (timer > 5 / d3) {
                    	//RWBYModels.LOGGER.info("damaged 1");
                    	player.getHeldItem(EnumHand.MAIN_HAND).damageItem(1, player);
                    	timer = 0;
                    }*/

                    AxisAlignedBB axisalignedbb = player.getEntityBoundingBox().grow(1.5,0,1.5);

                    List<Entity> list1 = player.world.getEntitiesWithinAABBExcludingEntity(player, axisalignedbb);

                    if (!list1.isEmpty())
                    {

                        float f = (float)d3;

                        for (Entity entity2 : list1)
                        {
                            if (entity2 instanceof EntityLivingBase) {
                                EntityLivingBase entitylivingbase = (EntityLivingBase)entity2;
                                if (entitylivingbase.attackEntityFrom(new EntityDamageSource("rose petal", player), f*10)) {
                                	//RWBYModels.LOGGER.info("damaged 1e");
                                	player.getHeldItem(EnumHand.MAIN_HAND).damageItem(1, player);
                                }
                            }
                        }
                    }
                }
            }
            NBTTagCompound nbt = is.getOrCreateSubCompound("RWBYM");
            if (!player.isHandActive() && nbt.getInteger("inactive") < 2) {
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
        if(!world.isRemote && this.data == null){{NBTTagCompound btag = is.getTagCompound();
            if (btag == null) btag = new NBTTagCompound();
            if (!btag.hasKey(KEY)) {
                btag.setBoolean(KEY, true);
                try {
                    is.setTagCompound(JsonToNBT.getTagFromJson("{AttributeModifiers:[{AttributeName:\"generic.attackSpeed\",Name:\"generic.attackSpeed\",Slot:\"mainhand\",Amount:0,Operation:0,UUIDMost:60527,UUIDLeast:119972}]}"));
                    //is.getTagCompound().merge(atag);
                } catch (NBTException nbtexception) {
                    LogManager.getLogger(RWBYModels.MODID).error("Couldn't load data tag for " + this.getRegistryName());
                }
            }}}
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
