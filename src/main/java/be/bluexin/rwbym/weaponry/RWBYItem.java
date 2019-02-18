package be.bluexin.rwbym.weaponry;

import be.bluexin.rwbym.Init.RWBYCreativeTabs;
import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.capabilities.Blake.Blake;
import be.bluexin.rwbym.capabilities.Blake.BlakeProvider;
import be.bluexin.rwbym.capabilities.Ruby.RubyProvider;
import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ISemblance;
import be.bluexin.rwbym.capabilities.Weiss.WeissProvider;
import be.bluexin.rwbym.capabilities.Yang.YangProvider;
import be.bluexin.rwbym.entity.EntityAtlasKnight;
import be.bluexin.rwbym.entity.EntityBeowolf;
import be.bluexin.rwbym.utility.network.MessageSendPlayerData;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;

import static be.bluexin.rwbym.capabilities.CapabilityHandler.getCapabilityByName;

/**
 * Part of rwbym by Bluexin.
 *
 * @author Bluexin
 */
public class RWBYItem extends Item implements ICustomItem {

    private boolean ismask;
    private final String data;
    private boolean gravity;
    private boolean water;
    private boolean atlasknight;
    private boolean coinr;
    private boolean coinw;
    private boolean coinb;
    private boolean coiny;
    public RWBYItem(String name,String data, boolean isMask,  CreativeTabs creativetab) {
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);
        this.ismask = isMask;
        this.data = data;
        this.setCreativeTab(creativetab);
        if(name.contains("gravitydustcrystal")) gravity = true;
        if(name.contains("waterdustcrystal")) water = true;
        if(name.contains("atlasknight")) atlasknight = true;
        if(name.contains("coinr")) coinr = true;
        if(name.contains("coinw")) coinw = true;
        if(name.contains("coinb")) coinb = true;
        if(name.contains("coiny")) coiny = true;
    }

    /*@Override
    public void registerRecipes() {
        if (this.recipes != null) for (RecipeDTO recipe : this.recipes) {
            recipe.register(this);
        }
    }*/

    @Override
    public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
        if (ismask){if(armorType == EntityEquipmentSlot.HEAD) {
            return true;
        }else {
            return false;
        }}else {
        return false;}
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void onUpdate(ItemStack is, World world, Entity entity, int slotIn, boolean inHand) {
        if(entity instanceof EntityPlayerMP){
            final EntityPlayerMP player = (EntityPlayerMP)entity;
            if(player.getHeldItem(EnumHand.OFF_HAND) == is && gravity){
                if (!player.onGround)
                {
                    player.motionY *= 0.8;
                    player.fallDistance = 0;
                    player.velocityChanged = true;
                }
            }
            if(player.getHeldItem(EnumHand.OFF_HAND) == is && water){
                PotionEffect potioneffect = new PotionEffect(MobEffects.REGENERATION, 60, 2, false, false);
                player.addPotionEffect(potioneffect);
            }
        }
        if (!world.isRemote && this.data != null) {
            NBTTagCompound atag = is.getTagCompound();
            if (atag == null) atag = new NBTTagCompound();
            if (!atag.hasKey(KEY)) {
                atag.setBoolean(KEY, true);
                try {
                    is.setTagCompound(JsonToNBT.getTagFromJson(this.data));
                    //is.getTagCompound().merge(atag);
                } catch (NBTException nbtexception) {
                    LogManager.getLogger(RWBYModels.MODID).error("Couldn't load data tag for " + this.getRegistryName());
                }
            }

        }
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        EntityEquipmentSlot entityequipmentslot = EntityEquipmentSlot.HEAD;
        ItemStack itemstack1 = playerIn.getItemStackFromSlot(entityequipmentslot);

        if(atlasknight){
            if(!worldIn.isRemote){
            BlockPos blockpos = (new BlockPos(playerIn));
            EntityAtlasKnight entityAtlasKnight = new EntityAtlasKnight(playerIn.world);
            entityAtlasKnight.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
            playerIn.world.spawnEntity(entityAtlasKnight);}
            itemstack.shrink(1);
        }

        if(coinr)
	    {
	        {
	            ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
	            if (semblance.toString().equals("Ruby")) {
	                semblance.setLevel(semblance.getLevel() + 1);
	                if (!worldIn.isRemote) {
	                	playerIn.sendMessage(new TextComponentString("Set Level of Ruby to: " + semblance.getLevel()));
	                }
	            } else {
	            	CapabilityHandler.setSemblance(playerIn, RubyProvider.RUBY_CAP, semblance.getLevel());
	            	if (!worldIn.isRemote) {
	            		playerIn.sendMessage(new TextComponentString("Set Semblance to: Ruby"));
	            	}
            	}
	            itemstack.shrink(1);
	        }
	    }
        if(coinw)
        {
            {
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Weiss")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                    if (!worldIn.isRemote) {
                    	playerIn.sendMessage(new TextComponentString("Set Level of Weiss to: " + semblance.getLevel()));
                    }
                } else {
                	CapabilityHandler.setSemblance(playerIn, WeissProvider.WEISS_CAP, semblance.getLevel());
                	if (!worldIn.isRemote) {
                		playerIn.sendMessage(new TextComponentString("Set Semblance to: Weiss"));
                	}
                }
                itemstack.shrink(1);
            }
        }

        if(coinb)
        {
            {
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Blake")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                    if (!worldIn.isRemote) {
                    	playerIn.sendMessage(new TextComponentString("Set Level of Blake to: " + semblance.getLevel()));
                    }
                } else {
                	CapabilityHandler.setSemblance(playerIn, BlakeProvider.BLAKE_CAP, semblance.getLevel());
                	if (!worldIn.isRemote) {
                		playerIn.sendMessage(new TextComponentString("Set Semblance to: Blake"));
                	}
                }
                itemstack.shrink(1);
            }
        }

        if(coiny)
        {
            {
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Yang")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                    if (!worldIn.isRemote) {
                    	playerIn.sendMessage(new TextComponentString("Set Level of Yang to: " + semblance.getLevel()));
                    }
                } else {
                	CapabilityHandler.setSemblance(playerIn, YangProvider.YANG_CAP, semblance.getLevel());
                	if (!worldIn.isRemote) {
                		playerIn.sendMessage(new TextComponentString("Set Semblance to: Yang"));
                	}
                }
                itemstack.shrink(1);
            }
        }
        
        if (coinr || coinw || coinb || coiny) {
        	for (ISemblance semblance : CapabilityHandler.getAllSemblances(playerIn)) {
        		RWBYModels.LOGGER.info("Semblance: {}, Level: {}", semblance, semblance.getLevel());
        	}
        }

        if (itemstack1.isEmpty() && ismask)
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
