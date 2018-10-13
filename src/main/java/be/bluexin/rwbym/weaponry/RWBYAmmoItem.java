package be.bluexin.rwbym.weaponry;

import be.bluexin.rwbym.Init.RWBYCreativeTabs;
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Part of rwbym by Bluexin.
 *
 * @author Bluexin
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class RWBYAmmoItem extends Item implements ICustomItem {

    public static boolean canPickup;
    private static String texture;
    public static double baseDamage;
    public static boolean gravity;
    public static boolean infinite;
    public static String nbt;
    public transient NBTTagCompound nbtTag;
    public float damages;

    public String potion;




    //public int getAmmoMax;

    public RWBYAmmoItem(String name, int ammoMax, boolean canPickup, String texture, float damages, boolean gravity, boolean infinite, String nbt, String potion, int durability, double baseDamage, CreativeTabs creativetab) {
        this.setCreativeTab(creativetab);
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setMaxStackSize(ammoMax);
        this.damages = damages;
        this.canPickup = canPickup;
        this.texture = texture;
        this.baseDamage = baseDamage;
        this.gravity = gravity;
        this.infinite = infinite;
        this.nbt = nbt;
        this.potion = potion;
        this.setMaxDamage(durability);

        if (nbt != null) try {
            this.nbtTag = JsonToNBT.getTagFromJson(nbt);
        } catch (NBTException e) {
            e.printStackTrace();
            System.err.println("Invalid NBT !");
        }
        //this.getAmmoMax = from.getAmmoMax();
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

    public String getPotion() {
        return potion;
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

    @Override
    public boolean isRepairable() {
        return false;
    }
    
    public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) {
        return new RWBYAmmoEntity(worldIn, shooter, this);
    }

    public boolean isInfinite(@Nullable ItemStack stack, @Nullable ItemStack bow, @Nullable EntityPlayer player) {
        if (isInfinite()){return true;}else {return false;}
    }

    @Override
    public String toString() {
        return "RWBYAmmoItem{" + this.getRegistryName() + "}";
    }
}
