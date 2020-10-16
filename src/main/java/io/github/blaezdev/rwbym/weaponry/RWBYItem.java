package io.github.blaezdev.rwbym.weaponry;

import io.github.blaezdev.rwbym.Init.RWBYCreativeTabs;
import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.capabilities.Blake.BlakeProvider;
import io.github.blaezdev.rwbym.capabilities.CapabilityHandler;
import io.github.blaezdev.rwbym.capabilities.Clover.CloverProvider;
import io.github.blaezdev.rwbym.capabilities.Harriet.Harriet;
import io.github.blaezdev.rwbym.capabilities.Harriet.HarrietProvider;
import io.github.blaezdev.rwbym.capabilities.ISemblance;
import io.github.blaezdev.rwbym.capabilities.Jaune.JauneProvider;
import io.github.blaezdev.rwbym.capabilities.Lysette.LysetteProvider;
import io.github.blaezdev.rwbym.capabilities.Nora.NoraProvider;
import io.github.blaezdev.rwbym.capabilities.Pyrrha.PyrrhaProvider;
import io.github.blaezdev.rwbym.capabilities.Qrow.QrowProvider;
import io.github.blaezdev.rwbym.capabilities.Ragora.RagoraProvider;
import io.github.blaezdev.rwbym.capabilities.Ren.RenProvider;
import io.github.blaezdev.rwbym.capabilities.Ruby.RubyProvider;
import io.github.blaezdev.rwbym.capabilities.Valour.ValourProvider;
import io.github.blaezdev.rwbym.capabilities.Weiss.WeissProvider;
import io.github.blaezdev.rwbym.capabilities.Yang.YangProvider;
import io.github.blaezdev.rwbym.entity.EntityArmorgeist;
import io.github.blaezdev.rwbym.entity.EntityAtlasKnight;
import io.github.blaezdev.rwbym.entity.EntityZwei;
import net.minecraft.client.util.ITooltipFlag;
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

import javax.annotation.Nullable;
import java.util.List;

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
    public String coin;
    private boolean gravity;
    private boolean water;
    private boolean atlasknight;
    private boolean ageist;
    private boolean zwei;
    private boolean burn;
    private boolean scroll;
    private boolean hasContainerItem;
    private ContainerItemLambda containeritemlambda;

    public RWBYItem setCoin(String coin) {
       this.coin = coin;
        return this;
    }



    public RWBYItem(String name, boolean isMask,  CreativeTabs creativetab) {
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);
        this.ismask = isMask;
        if(this.ismask){
            maxStackSize = 1;
        }
        if(name.contains("crystal")) burn = true;
        this.setCreativeTab(creativetab);
        if(name.contains("gravitydustcrystal")) gravity = true;
        if(name.contains("waterdustcrystal")) water = true;
        if(name.contains("atlasknight")) atlasknight = true;
        if(name.contains("armagigas")) ageist = true;
        if(name.contains("zwei")) zwei = true;
        scroll = name.contains("scroll");
        coin = "notcoin";
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

        if(zwei){
            if(!worldIn.isRemote){
                BlockPos blockpos = (new BlockPos(playerIn));
                EntityZwei entityzwei = new EntityZwei(playerIn.world);
                entityzwei.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
                playerIn.world.spawnEntity(entityzwei);}
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


        if(coin.matches("ruby"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Ruby")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, RubyProvider.RUBY_CAP, 1);}
                itemstack.shrink(1);
            }
        }
        if(coin.matches("weiss"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Weiss")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, WeissProvider.WEISS_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.matches("blake"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Blake")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, BlakeProvider.BLAKE_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.matches("yang"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Yang")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, YangProvider.YANG_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.matches("ren"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Ren")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, RenProvider.Ren_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.matches("ragora"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Ragora")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, RagoraProvider.RAGORA_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.matches("jaune"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Jaune")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, JauneProvider.JAUNE_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.matches("nora"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Nora")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, NoraProvider.Nora_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.matches("qrow"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Qrow")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, QrowProvider.Qrow_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.matches("lysette"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Lysette")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, LysetteProvider.Lysette_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.matches("clover"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("Clover")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, CloverProvider.Clover_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.matches("harriet"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("harriet")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, HarrietProvider.Harriet_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.matches("pyrrha"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("pyrrha")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, PyrrhaProvider.Pyrrha_CAP, 1);}
                itemstack.shrink(1);
            }
        }

        if(coin.matches("valour"))
        {
            if(!worldIn.isRemote){
                ISemblance semblance = CapabilityHandler.getCurrentSemblance(playerIn);
                if (semblance.toString().equals("valour")) {
                    semblance.setLevel(semblance.getLevel() + 1);
                } else {CapabilityHandler.setSemblance(playerIn, ValourProvider.Valour_CAP, 1);}
                itemstack.shrink(1);
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


    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        if(zwei){tooltip.add("a Wild Zwei has Appeared use bones to tame him");}
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

/*            ArrayList<IRecipe> recipes = new ArrayList();
            for (IRecipe irecipe : net.minecraftforge.registries.GameData.getWrapper(IRecipe.class)) {
                recipes.add(irecipe);
            }
            player.unlockRecipes(recipes);*/
