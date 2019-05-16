package be.bluexin.rwbym.weaponry;

        import be.bluexin.rwbym.Init.RWBYCreativeTabs;
        import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.entity.ModelArmor;
import be.bluexin.rwbym.RWBYModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
        import net.minecraft.client.model.ModelPlayer;
        import net.minecraft.creativetab.CreativeTabs;
        import net.minecraft.entity.Entity;
        import net.minecraft.entity.EntityLivingBase;
        import net.minecraft.entity.player.EntityPlayer;
        import net.minecraft.inventory.EntityEquipmentSlot;
        import net.minecraft.item.Item;
        import net.minecraft.item.ItemArmor;
        import net.minecraft.item.ItemStack;
        import net.minecraft.item.ItemArmor.ArmorMaterial;
        import net.minecraft.nbt.JsonToNBT;
        import net.minecraft.nbt.NBTException;
        import net.minecraft.nbt.NBTTagCompound;
        import net.minecraft.util.ActionResult;
        import net.minecraft.util.EnumActionResult;
        import net.minecraft.util.EnumHand;
        import net.minecraft.world.World;
        import net.minecraftforge.fml.relauncher.Side;
        import net.minecraftforge.fml.relauncher.SideOnly;
        import org.apache.logging.log4j.LogManager;
        import scala.Int;
        import scala.collection.generic.BitOperations;

        import javax.annotation.ParametersAreNonnullByDefault;

        import static be.bluexin.rwbym.weaponry.ICustomItem.KEY;

public class ArmourBase extends ItemArmor {
    private boolean fire = false;
    private boolean ice = false;
    private boolean wind = false;
    private boolean isPlayerModel;
    private final String morph;
    private final String data;

    public ArmourBase(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String name, String morph,String data, boolean playerModel, CreativeTabs creativetab) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.morph = morph;
        if (name.contains("korekosmoufire")) fire = true;
        if (name.contains("korekosmouice")) ice = true;
        if (name.contains("korekosmouwind")) wind = true;
        this.setCreativeTab(creativetab);
        this.setRegistryName("rwbym", name);
        this.setUnlocalizedName(name);
        this.data = data;
        this.isPlayerModel = playerModel;
    }

    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        ModelBiped armorModel = _default;
        if (!itemStack.isEmpty()) {
        	if (this.isPlayerModel && entityLiving instanceof AbstractClientPlayer) {
        		AbstractClientPlayer player = (AbstractClientPlayer) entityLiving;
        		boolean smallarms = player.getSkinType().equals("slim");
        		armorModel = new ModelArmor(0.0F, smallarms, armorSlot);
        	}
        	else {
                armorModel = new ModelBiped(0.2F);
            }
        }

        return armorModel;
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
    	
    	String s1 = null;
    	
    	if (this.isPlayerModel) {
	        ItemArmor item = (ItemArmor)stack.getItem();
	        String texture = item.getArmorMaterial().getName();
	        String domain = "minecraft";
	        int idx = texture.indexOf(':');
	        if (idx != -1)
	        {
	            domain = texture.substring(0, idx);
	            texture = texture.substring(idx + 1);
	        }
	        s1 = String.format("%s:textures/models/armor/%s%s.png", domain, texture, entity instanceof AbstractClientPlayer ? "_" + ((AbstractClientPlayer)entity).getSkinType() : "");
    	}

        return s1;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void onUpdate(ItemStack is, World world, Entity entity, int slotIn, boolean inHand) {
        if (!world.isRemote && this.data != null) {
            NBTTagCompound atag = is.getTagCompound();
            if (atag == null) atag = new NBTTagCompound();
            if (!atag.hasKey(KEY)) {
                atag.setBoolean(KEY, true);
                try {
                    is.setTagCompound(JsonToNBT.getTagFromJson(this.data));
                    is.getTagCompound().merge(atag);
                } catch (NBTException nbtexception) {
                    LogManager.getLogger(RWBYModels.MODID).error("Couldn't load data tag for " + this.getRegistryName());
                }
            }

        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        ItemStack kkfire = new ItemStack(RWBYItems.kkfire);
        ItemStack kkice = new ItemStack(RWBYItems.kkice);
        ItemStack kkwind = new ItemStack(RWBYItems.kkwind);
        Integer slot = player.inventory.currentItem;
        if (player.inventory.getCurrentItem().isEmpty() && player.isSneaking() && player.isSwingInProgress) {
            if (fire && !player.inventory.hasItemStack(kkfire)) {
                player.inventory.setInventorySlotContents(slot, kkfire);
                itemStack.damageItem(30, player);
            }
        }
        if (player.inventory.getCurrentItem().isEmpty() && player.isSneaking() && player.isSwingInProgress) {
            if (ice && !player.inventory.hasItemStack(kkfire)) {
                player.inventory.setInventorySlotContents(slot, kkice);
                itemStack.damageItem(30, player);
            }
        }
        if (player.inventory.getCurrentItem().isEmpty() && player.isSneaking() && player.isSwingInProgress) {
            if (wind && !player.inventory.hasItemStack(kkfire)) {
                player.inventory.setInventorySlotContents(slot, kkwind);
                itemStack.damageItem(30, player);
            }
        }
        super.onArmorTick(world, player, itemStack);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
            return false;
    }

    @ParametersAreNonnullByDefault
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        ItemStack is = playerIn.getHeldItem(hand);
        if (!worldIn.isRemote && playerIn.isSneaking() && this.morph != null) {
            ItemStack morph1 = new ItemStack(Item.getByNameOrId(this.morph), is.getCount(), is.getMetadata());
            //noinspection ConstantConditions
            if (is.hasTagCompound()) {
                morph1.setTagCompound(is.getTagCompound());
            }
            if (hand == EnumHand.MAIN_HAND) {
                playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, morph1);
            }}
        return super.onItemRightClick(worldIn, playerIn, hand);
    }

    @Override
    public boolean isRepairable() {
        return true;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == RWBYItems.scrap || super.getIsRepairable(toRepair, repair);
    }
}
