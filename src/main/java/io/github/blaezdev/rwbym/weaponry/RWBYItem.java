package io.github.blaezdev.rwbym.weaponry;

import io.github.blaezdev.rwbym.Init.RWBYCreativeTabs;
import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.capabilities.Blake.BlakeProvider;
import io.github.blaezdev.rwbym.capabilities.CapabilityHandler;
import io.github.blaezdev.rwbym.capabilities.Clover.CloverProvider;
import io.github.blaezdev.rwbym.capabilities.ISemblance;
import io.github.blaezdev.rwbym.capabilities.Jaune.JauneProvider;
import io.github.blaezdev.rwbym.capabilities.Lysette.LysetteProvider;
import io.github.blaezdev.rwbym.capabilities.Nora.NoraProvider;
import io.github.blaezdev.rwbym.capabilities.Qrow.QrowProvider;
import io.github.blaezdev.rwbym.capabilities.Ragora.RagoraProvider;
import io.github.blaezdev.rwbym.capabilities.Ren.RenProvider;
import io.github.blaezdev.rwbym.capabilities.Ruby.RubyProvider;
import io.github.blaezdev.rwbym.capabilities.Weiss.WeissProvider;
import io.github.blaezdev.rwbym.capabilities.Yang.YangProvider;
import io.github.blaezdev.rwbym.entity.EntityArmorgeist;
import io.github.blaezdev.rwbym.entity.EntityAtlasKnight;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;

/**
 * Part of rwbym by Bluexin.
 *
 * @author Bluexin
 */
public class RWBYItem extends Item implements ICustomItem {

    public interface ContainerItemLambda {
        public ItemStack apply(ItemStack stack);
    }

    private boolean ismask;
    private final String data;
    private String coin;
    private boolean gravity;
    private boolean water;
    private boolean atlasknight;
    private boolean ageist;
    private boolean burn;
    private boolean scroll;
    private boolean hasContainerItem;
    private ContainerItemLambda containeritemlambda;

    public RWBYItem setCoin(String coin) {
        this.coin = coin;
        return this;
    }

    public RWBYItem(String name,String data, boolean isMask,  CreativeTabs creativetab) {
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);
        this.ismask = isMask;
        this.data = data;
        if(this.ismask){
            maxStackSize = 1;
        }
        if(name.contains("crystal")) burn = true;
        this.setCreativeTab(creativetab);
        if(name.contains("gravitydustcrystal")) gravity = true;
        if(name.contains("waterdustcrystal")) water = true;
        if(name.contains("atlasknight")) atlasknight = true;
        if(name.contains("armagigas")) ageist = true;
        scroll = name.contains("scroll");
    }


    public RWBYItem setContainerItemLambda(ContainerItemLambda lambda) {
        this.containeritemlambda = lambda;
        return this;
    }

    public RWBYItem setHasContainerItem(boolean istool) {
        this.hasContainerItem = istool;
        return this;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return this.hasContainerItem;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        if (containeritemlambda != null) {
            return containeritemlambda.apply(itemStack);
        }
        return super.getContainerItem(itemStack);
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

    //@SuppressWarnings("Duplicates")
    @Override
    public void onUpdate(ItemStack is, World world, Entity entity, int slotIn, boolean inHand) {
        if(entity instanceof EntityPlayer){
            final EntityPlayer player = (EntityPlayer)entity;
            player.setHealth(player.getHealth());
            if(player.getHeldItem(EnumHand.OFF_HAND) == is && gravity){
                if (!player.onGround)
                {
                    player.motionY += 0.05;
                    player.fallDistance = 0;
                    //player.velocityChanged = true;
                }
            }
            if(player.getHeldItem(EnumHand.OFF_HAND) == is && water){
                //PotionEffect potioneffect = new PotionEffect(MobEffects.RESISTANCE, 60, 1, false, false);
                //player.addPotionEffect(potioneffect);
                player.heal(0.05F);
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

        if(ageist){
            if(!worldIn.isRemote){
                BlockPos blockpos = (new BlockPos(playerIn));
                EntityArmorgeist entityAtlasKnight = new EntityArmorgeist(playerIn.world);
                entityAtlasKnight.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
                entityAtlasKnight.ignite();
                playerIn.world.spawnEntity(entityAtlasKnight);}
            itemstack.shrink(1);
        }

        if (scroll) {
            playerIn.openGui(RWBYModels.instance, RWBYModels.GuiHandler.GUI.SCROLL.ordinal(), worldIn, 0, 0, 0);
        }

        if(!scroll){
        if(coin.contains("ruby"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Ruby")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, RubyProvider.RUBY_CAP, 1);}
                itemstack.shrink(1);
            }
        }
        if(coin.contains("weiss"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Weiss")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, WeissProvider.WEISS_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.contains("blake"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Blake")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, BlakeProvider.BLAKE_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.contains("yang"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Yang")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, YangProvider.YANG_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.contains("ren"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Ren")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, RenProvider.Ren_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.contains("ragora"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Ragora")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, RagoraProvider.RAGORA_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.contains("jaune"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Jaune")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, JauneProvider.JAUNE_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.contains("nora"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Nora")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, NoraProvider.Nora_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.contains("qrow"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Qrow")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, QrowProvider.Qrow_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.contains("lysette"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Lysette")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, LysetteProvider.Lysette_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.contains("clover"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Clover")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, CloverProvider.Clover_CAP, 1);}
                itemstack.shrink(1);
            }
        }}

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


    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    public int getItemEnchantability()
    {
        return 0;
    }

    @Override
    public int getItemBurnTime(ItemStack itemStack) {
        if(burn){
            return 2400;}else return 0;
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

