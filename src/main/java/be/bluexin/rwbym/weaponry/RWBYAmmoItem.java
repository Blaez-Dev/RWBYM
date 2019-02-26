package be.bluexin.rwbym.weaponry;

import be.bluexin.rwbym.Init.RWBYCreativeTabs;
import be.bluexin.rwbym.entity.EntityBullet;
import be.bluexin.rwbym.weaponry.ammohit.IAmmoHit;
import be.bluexin.rwbym.weaponry.ammohit.NullAmmoHit;
import be.bluexin.rwbym.RWBYModels;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import com.google.common.collect.ImmutableList;

/**
 * Part of rwbym by Bluexin.
 *
 * @author Bluexin
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class RWBYAmmoItem extends Item implements ICustomItem {

	private ItemStack renderStack;
    private boolean canPickup;
    private String texture;
    private double baseDamage;
    private boolean gravity;
    private boolean infinite;
    private String nbt;
    private transient NBTTagCompound nbtTag;
    private IAmmoHit hitfun;

    private List<PotionEffect> potions;




    //public int getAmmoMax;

    public RWBYAmmoItem(String name, Item render, int ammoMax, boolean canPickup, String texture, boolean gravity, boolean infinite, String nbt, List<PotionEffect> potion, int durability, double baseDamage, CreativeTabs creativetab, IAmmoHit hitfun) {
        this.setCreativeTab(creativetab);
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setMaxStackSize(ammoMax);
        if (render == null) {
        	this.renderStack = ItemStack.EMPTY;
        }
        else {
        	this.renderStack = new ItemStack(render);
        }
        this.canPickup = canPickup;
        this.texture = texture;
        this.baseDamage = baseDamage;
        this.gravity = gravity;
        this.infinite = infinite;
        this.nbt = nbt;
        this.potions = potion;
        this.setMaxDamage(durability);
        this.hitfun = hitfun;
        if (this.hitfun == null) {
        	this.hitfun = new NullAmmoHit();
        }

        if (nbt != null && !nbt.isEmpty()) try {
            this.nbtTag = JsonToNBT.getTagFromJson(nbt);
        } catch (NBTException e) {
            e.printStackTrace();
            System.err.println("Invalid NBT !");
        }
        //this.getAmmoMax = from.getAmmoMax();
    }
    
    public ItemStack getRenderStack() {
    	return this.renderStack;
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

    public NBTTagCompound getNbt() {
        if (nbtTag == null && nbt != null) try {
            this.nbtTag = JsonToNBT.getTagFromJson(nbt);
        } catch (NBTException e) {
            e.printStackTrace();
            System.err.println("Invalid NBT !");
        }
        return nbtTag;
    }

    public int getItemEnchantability()
    {
        return 0;
    }
    
    public void onBlockHit(World world, BlockPos pos) {
    	this.hitfun.applyBlock(world, pos);
    }
    
    public void onEntityHit(EntityLivingBase living) {
    	this.hitfun.applyEntity(living);
    }

    @Override
    public boolean isRepairable() {
        return false;
    }
    
    public EntityBullet createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) {
        return new EntityBullet(worldIn, shooter, this);
    }

    @Override
    public String toString() {
        return "RWBYAmmoItem{" + this.getRegistryName() + "}";
    }
}
