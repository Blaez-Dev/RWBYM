package be.bluexin.rwbym.weaponry;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityBullet;
import be.bluexin.rwbym.weaponry.ammohit.IAmmoHit;
import be.bluexin.rwbym.weaponry.ammohit.NullAmmoHit;
import com.mojang.realmsclient.gui.ChatFormatting;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

/**
 * Part of rwbym by Bluexin.
 *
 * @author Bluexin
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class RWBYAmmoItem extends Item implements ICustomItem {

	private Object render;
    private boolean canPickup;
    private String texture;
    private double baseDamage;
    private boolean gravity;
    private boolean infinite;
    private String nbt;
    private transient NBTTagCompound nbtTag;
    private IAmmoHit hitfun;
    private SurviveOnHit survives;

    public boolean pierce;

    private List<PotionEffect> potions;


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
     * @param nbt
     * @param potion
     * @param durability
     * @param baseDamage
     * @param creativetab
     * @param hitfun
     */
    public RWBYAmmoItem(String name, Object render, int ammoMax, boolean canPickup, SurviveOnHit canSurvive, String texture, boolean gravity, boolean infinite, String nbt, List<PotionEffect> potion, int durability, double baseDamage, CreativeTabs creativetab, IAmmoHit hitfun) {
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
    
    public EntityBullet createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) {
        return new EntityBullet(worldIn, shooter, this);
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
