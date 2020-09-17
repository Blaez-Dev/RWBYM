package io.github.blaezdev.rwbym.weaponry.specialweapons.guns;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import net.minecraft.item.EnumAction;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import org.apache.commons.lang3.tuple.Pair;

import io.github.blaezdev.rwbym.KeyInputHandler;
import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.Init.RWBYCreativeTabs;
import io.github.blaezdev.rwbym.capabilities.itemdata.IItemData;
import io.github.blaezdev.rwbym.capabilities.itemdata.ItemDataProvider;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import io.github.blaezdev.rwbym.utility.Util;
import io.github.blaezdev.rwbym.utility.network.MessageShoot;
import io.github.blaezdev.rwbym.utility.network.MessageUpdateNBT;
import io.github.blaezdev.rwbym.utility.network.RWBYNetworkHandler;
import io.github.blaezdev.rwbym.weaponry.specialweapons.ItemMag;
import io.github.blaezdev.rwbym.weaponry.specialweapons.ItemPropertyWrapper;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.AnimationControllerShoot;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.IAnimationController;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.AnimationControllerFireSelect.Modes;
import io.github.blaezdev.rwbym.weaponry.specialweapons.bullets.ItemBullet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public abstract class ItemGun extends Item {

    //private static final IItemPropertyGetter ADS_GETTER = new BooleanPropertyGetter("ADS");

    private static final IItemPropertyGetter BULLET_CHAMBERED_GETTER = new IItemPropertyGetter()
    {
        @Override
        public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
        {
            if (worldIn == null) {
                worldIn = Minecraft.getMinecraft().world;
            }

            IItemData iItemData = worldIn.getCapability(ItemDataProvider.ITEMDATA_CAP, null);

            if (worldIn == null || iItemData == null || !stack.hasTagCompound()) {
                return 0.0F;
            }
            NBTTagCompound nbt = iItemData.getData().getCompoundTag(stack.getTagCompound().getString("UUID"));
            float j = !nbt.getString("BulletChambered").isEmpty() ? 1.0F : 0.0F;
            return j;
        }
    };

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.NONE;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }

    //private static final IItemPropertyGetter FIRED_GETTER = new BooleanPropertyGetter("fired");

    protected double spreadY;
    protected double spreadX;
    protected double drift;
    protected float accuracy;
    protected List<IAnimationController> animationControllers = new ArrayList<>();
    public Supplier<ItemBullet> ammo;
    public Supplier<Item> casing;
    public Supplier<ItemMag> mag;

    public ItemGun() {
        super();
        this.setCreativeTab(RWBYCreativeTabs.tab_rwbyweapons);
        this.addPropertyOverride(new ResourceLocation("chambered"), BULLET_CHAMBERED_GETTER);
        getAnimationControllers();
        this.maxStackSize = 1;
        List<ItemPropertyWrapper> itemProperties = new ArrayList<>();
        animationControllers.forEach(controller -> itemProperties.addAll(controller.getProperties()));
        itemProperties.forEach(property -> addPropertyOverride(property.getName(), property.getOverride()));
    }

    //Client Only
    public List<Vec3d> getPredictorLines(EntityPlayer player, float partialTicks, float entityAccuracy, ItemGun gun, NBTTagCompound nbt) {
    	List<Vec3d> list = new ArrayList<>();
    	Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(nbt.getString("BulletChambered")));
    	if (item instanceof ItemBullet) {
    		list.add(((ItemBullet)item).getPredictorLine(0, player, partialTicks, entityAccuracy, gun.accuracy));
        	if (Modes.values()[nbt.getInteger("mode")] == Modes.AUTO) {
        		for (int i = 0; i < RWBYConfig.general.maxBulletLines - 1 && i < nbt.getTagList("bullets", 8).tagCount(); i++) {
        	    	item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(nbt.getTagList("bullets", 8).getStringTagAt(i)));
        			list.add(((ItemBullet)item).getPredictorLine(i + 1, player, partialTicks, entityAccuracy, gun.accuracy));
        		}
        	}
    	}
    	return list;
    }
    
    //Client Only
    public List<Vec3d> getPredictorLines(EntityPlayer player, ItemGun gun, NBTTagCompound nbt) {
    	List<Vec3d> list = new ArrayList<>();
    	Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(nbt.getString("BulletChambered")));
    	if (item instanceof ItemBullet) {
    		list.add(((ItemBullet)item).getPredictorLine(0, player, AnimationControllerShoot.getEntityAccuracy(player, nbt), gun.accuracy));
        	if (Modes.values()[nbt.getInteger("mode")] == Modes.AUTO) {
        		for (int i = 0; i < RWBYConfig.general.maxBulletLines - 1 && i < nbt.getTagList("bullets", 8).tagCount(); i++) {
        	    	item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(nbt.getTagList("bullets", 8).getStringTagAt(i)));
        			list.add(((ItemBullet)item).getPredictorLine(i + 1, player, AnimationControllerShoot.getEntityAccuracy(player, nbt), gun.accuracy));
        		}
        	}
    	}
    	return list;
    }
    
    abstract protected void getAnimationControllers();

    public boolean Shoot(NBTTagCompound nbt, EntityLivingBase entityLiving, double damage, float entityAccuracy, float gunAccuracy, int bullets) {
        return Shoot(nbt, entityLiving, damage, entityAccuracy, gunAccuracy, bullets, 1200);
    }

    public boolean Shoot(NBTTagCompound nbt, EntityLivingBase entityLiving, double damage, float entityAccuracy, float gunAccuracy, int bullets, int life) {

        if (entityLiving instanceof EntityPlayer) {

            EntityPlayer player = ((EntityPlayer)entityLiving);
            World world = player.world;
            boolean flag1 = player.isCreative();

            if (world.isRemote) {
                RWBYNetworkHandler.sendToServer(new MessageShoot(nbt, damage, entityAccuracy, gunAccuracy, life, bullets));
            }

            int i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(player.getHeldItemMainhand(), world, player, 20, (flag1 || !nbt.getString("BulletChambered").isEmpty()));

            if (i < 0) {
                return false;
            }

            if ((flag1 || !nbt.getString("BulletChambered").isEmpty())) {

                Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(nbt.getString("BulletChambered")));

                boolean flag = false;

                if (!(item instanceof ItemBullet) && player.isCreative())  {
                    item = this.ammo.get();
                    flag = true;
                }

                if (item instanceof ItemBullet) {
                    ItemBullet itemBullet = (ItemBullet) item;
                    if (!world.isRemote) {
                        itemBullet.fire(world, player, entityAccuracy, gunAccuracy, life);
                    }
                    if (flag) {
                        nbt.setString("BulletChambered", "");
                    }
                    else {
                        nbt.setString("BulletChambered", itemBullet.getCasing().getRegistryName().toString());
                    }
                }
//                else if (!world.isRemote) {
//
//                    EntityBullet bulletdummy = new EntityBullet(world, player);
//                    bulletdummy.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 23F, entityAccuracy);
//
//                    for (int j = 0; j < bullets; j++) {
//
//                        EntityBullet bullet = new EntityBullet(world, player, life);
//                        double x = bulletdummy.motionX;
//                        double y = bulletdummy.motionY;
//                        double z = bulletdummy.motionZ;
//                        bullet.shoot(x, y, z, MathHelper.sqrt(x * x + y * y + z * z), gunAccuracy);
//
//                        bullet.posY += 0.1D;
//                        bullet.setIsCritical(false);
//                        bullet.setDamage(damage);
//
//                        player.world.spawnEntity(bullet);
//
//                    }
//
//                    //System.out.println("Spawning Bullet");
//
//                    world.playSound(null, player.posX, player.posY, player.posZ, getShootSound(), SoundCategory.PLAYERS, 1, 1);
//
//                }

                player.rotationPitch += world.rand.nextGaussian() * this.spreadY - this.drift;
                player.rotationYaw += world.rand.nextGaussian() * this.spreadX;

                //nbt.setBoolean("BulletChambered", false);


                return true;
            }
        }
        return false;
    }

    //public abstract SoundEvent getShootSound();

    public float getZoomFactor(ItemStack stack) {
        //if (this.hasAccessory(stack, ItemAccessory.AccessoryType.SCOPE)) {
        //    return ((ItemScope) this.getAccessory(stack, ItemAccessory.AccessoryType.SCOPE)).getZoom();
        //}
        //else {
            return this.getDefaultZoomFactor(stack);
        //}
    }

    public abstract float getDefaultZoomFactor(ItemStack stack);

    public float getAccuracy() {
        return accuracy;
    }

//    public boolean hasAccessories(ItemStack stack) {
//        NBTTagCompound nbt = stack.getOrCreateSubCompound(RWBYModels.MODID);
//        NBTTagCompound accessoriesNBT = nbt.getCompoundTag("Accessories");
//        if (!nbt.hasKey("Accessories", 10)) {
//            nbt.setTag("Accessories", accessoriesNBT);
//        }
//        for (int i = 0; i < 9; i++) {
//            if (i == 4) continue;
//            if (accessoriesNBT.hasKey(Integer.toString(i), 8)) return true;
//        }
//        return false;
//    }
//
//    public boolean hasAccessory(ItemStack stack, ItemAccessory.AccessoryType type) {
//        return hasAccessory(stack, type.getSlot());
//    }
//
//    public boolean hasAccessory(ItemStack stack, int type) {
//        NBTTagCompound nbt = stack.getOrCreateChildTag(Reference.MOD_ID);
//        NBTTagCompound accessoriesNBT = nbt.getCompound("Accessories");
//        if (!nbt.contains("Accessories", 10)) {
//            nbt.put("Accessories", accessoriesNBT);
//        }
//        return accessoriesNBT.contains(Integer.toString(type), 8);
//    }
//
//    public boolean acceptsAccessory(ItemAccessory.AccessoryType type) {
//        return false;
//    }
//
//    public void setAccessory(ItemStack gun, ItemAccessory accessory) {
//        NBTTagCompound nbt = gun.getOrCreateChildTag(Reference.MOD_ID);
//        NBTTagCompound accessoriesNBT = nbt.getCompound("Accessories");
//        if (!nbt.contains("Accessories", 10)) {
//            nbt.put("Accessories", accessoriesNBT);
//        }
//        accessoriesNBT.putString(Integer.toString(accessory.getSlot()), accessory.getRegistryName().toString());
//    }
//
//    public ItemAccessory getAccessory(ItemStack gun, ItemAccessory.AccessoryType type) {
//        return getAccessory(gun, type.getSlot());
//    }
//
//    public ItemAccessory removeAccessory(ItemStack gun, ItemAccessory.AccessoryType type) {
//        return removeAccessory(gun, type.getSlot());
//    }
//
//    public ItemAccessory getAccessory(ItemStack gun, int slot) {
//        NBTTagCompound nbt = gun.getOrCreateChildTag(Reference.MOD_ID);
//        NBTTagCompound accessoriesNBT = nbt.getCompound("Accessories");
//        if (!nbt.contains("Accessories", 10)) {
//            nbt.put("Accessories", accessoriesNBT);
//        }
//        return (ItemAccessory) ForgeRegistries.ITEMS.getValue(new ResourceLocation(accessoriesNBT.getString(Integer.toString(slot))));
//    }
//
//    public ItemAccessory removeAccessory(ItemStack gun, int slot) {
//        NBTTagCompound nbt = gun.getOrCreateChildTag(Reference.MOD_ID);
//        NBTTagCompound accessoriesNBT = nbt.getCompound("Accessories");
//        if (!nbt.contains("Accessories", 10)) {
//            nbt.put("Accessories", accessoriesNBT);
//        }
//        ItemAccessory accessory = (ItemAccessory) ForgeRegistries.ITEMS.getValue(new ResourceLocation(accessoriesNBT.getString(Integer.toString(slot))));
//        accessoriesNBT.remove(Integer.toString(slot));
//        return accessory;
//    }
//
//    public List<ItemStack> getAccesories(ItemStack stack) {
//        NBTTagCompound nbt = stack.getOrCreateChildTag(Reference.MOD_ID);
//        List<ItemStack> list = new ArrayList<ItemStack>();
//        if (nbt.contains("Accessories", 10)) {
//            NBTTagCompound accessoriesNBT = nbt.getCompound("Accessories");
//            for (int i = 0; i < 9; i++) {
//                if (i == 4) continue;
//                ItemStack accessory = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(accessoriesNBT.getString(Integer.toString(i)))));
//                if (!accessory.isEmpty()) {
//                    accessory.getOrCreateTag().putBoolean("model", true);
//                    accessory.getOrCreateTag().putString("UUID", stack.getOrCreateTag().getString("UUID"));
//                    accessory.getOrCreateTag().putIntArray("transform", this.getAccessoryTransformInts(((ItemAccessory) accessory.getItem()).getType()));
//                    list.add(accessory);
//                }
//            }
//        }
//        return list;
//    }
//
//    private int [] getAccessoryTransformInts(ItemAccessory.AccessoryType type) {
//
//        int [] ints = new int[16];
//
//        Matrix4f m = this.getAccessoryTransform(type);
//
//        for (int i = 0; i < 16; i++) {
//            ints[i] = Float.floatToIntBits(m.getElement(i / 4, i % 4));
//        }
//
//        return ints;
//    }
//
//    public Matrix4f getAccessoryTransform(ItemAccessory.AccessoryType type) {
//        Matrix4f m = new Matrix4f();
//        m.setIdentity();
//        return m;
//    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (worldIn.isRemote) {

            if (entityIn instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entityIn;

//                if (player.getHeldItemMainhand().equals(stack)) {
//                    if (KeyInputHandler.isKeyDown(KeyInputHandler.KeyPresses.Shift)) {
//                        ClientEventHandler.cancleBob();
//                    }
//                }

                IItemData cap = worldIn.getCapability(ItemDataProvider.ITEMDATA_CAP, null);
                NBTTagCompound baseTag = cap.getData();

                NBTTagCompound nbt = baseTag.getCompoundTag(Util.getOrCreateTag(stack).getString("UUID"));

                NBTTagCompound oldnbt = nbt.copy();
                oldnbt.removeTag("prev");
                nbt.setTag("prev", oldnbt);

                animationControllers.forEach(controller -> controller.update(stack, worldIn, player, itemSlot, isSelected, nbt, (ItemGun) stack.getItem()));

                //System.out.println(stack + ", " + player.getName());
                
                RWBYNetworkHandler.sendToServer(new MessageUpdateNBT(stack, itemSlot, nbt, (AbstractClientPlayer) player));
                
                if (slowOnADS() && nbt.getBoolean("ads")) {
                	player.setActiveHand(EnumHand.MAIN_HAND);
                }
            }
        }
    }

    protected boolean slowOnADS() {
    	return false;
    }

	@Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {

        boolean flag = false;

        if (oldStack.getItem() instanceof ItemGun && newStack.getItem() instanceof ItemGun) {
            flag = Util.getOrCreateTag(oldStack).getString("UUID").equals(Util.getOrCreateTag(newStack).getString("UUID"));
        }

        return false;//slotChanged || !flag;
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("ID: " + Util.getOrCreateTag(stack).getString("UUID"));
    	if (worldIn != null) {
	        NBTTagCompound nbt = worldIn.getCapability(ItemDataProvider.ITEMDATA_CAP, null).getData().getCompoundTag(Util.getOrCreateTag(stack).getString("UUID"));
	        int bullets = nbt.getTagList("bullets", 8).tagCount();
	        int maxBullets = mag.get().getMaxAmmo();
	        tooltip.add("Ammo: " + bullets + "/" + maxBullets);
    	}
//        if (hasAccessories(stack)) {
//            tooltip.add(new StringTextComponent("Accessories:"));
//            for (int i = 0; i < 9; i++) {
//                if (this.hasAccessory(stack, i)) {
//                    tooltip.add(new StringTextComponent("    ").appendSibling(new TranslationTextComponent("tooltip."+ ItemAccessory.AccessoryType.getTypeBySlot(i).toString())).appendText(": ").appendSibling(new TranslationTextComponent(getAccessory(stack, i).getTranslationKey())));
//                }
//            }
//        }
    }
        
    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
    	return 72000;
    }

    public int findAmmo(EntityPlayer player) {
        for (int i = -1; i < player.inventory.getSizeInventory() - 1; ++i)
        {
            int k = i < 0 ? player.inventory.getSizeInventory() - 1 : i;

            ItemStack itemstack = player.inventory.getStackInSlot(k);

            if (this.isAmmo(itemstack))
            {
                return k;
            }
        }

        return -1;
    }

    public int findMag(EntityPlayer player) {
        for (int i = -1; i < player.inventory.getSizeInventory() - 1; ++i) {
            int k = i < 0 ? player.inventory.getSizeInventory() - 1 : i;

            ItemStack itemstack = player.inventory.getStackInSlot(k);

            if (this.isMag(itemstack)) {
                return k;
            }
        }

        return -1;
    }

    public int findFullestMag(EntityPlayer player, NBTTagCompound baseTag) {
        TreeMap<Integer, Pair<ItemStack, Integer>> mags = new TreeMap<Integer, Pair<ItemStack, Integer>>();
        {
            ItemStack itemstack = player.inventory.getStackInSlot(player.inventory.getSizeInventory() - 1);
            if (isMag(itemstack)) {
                return player.inventory.getSizeInventory() - 1;
            }
        }
        for (int i = 0; i < player.inventory.getSizeInventory() - 1; i++) {
            ItemStack itemstack = player.inventory.getStackInSlot(i);
            if (isMag(itemstack)) {
                mags.put(baseTag.getCompoundTag(itemstack.getTagCompound().getString("UUID")).getTagList("bullets", 8).tagCount(), Pair.of(itemstack, i));
            }
        }
        if (!mags.isEmpty()) {
            return mags.lastEntry().getValue().getValue();
        }
        return -1;
    }



    public boolean isMag(ItemStack stack) {
        return stack.getItem() == mag.get();
    }

    private boolean isAmmo(ItemStack stack) {
        return stack.getItem() == ammo.get();
    }

//    protected static class BooleanPropertyGetter implements IItemPropertyGetter {
//
//        private final String name;
//
//        public BooleanPropertyGetter(String name) {
//            this.name = name;
//        }
//
//        @Override
//        public float call(ItemStack stack, World worldIn, EntityLivingBase entityIn) {
//            if (worldIn == null) {
//                worldIn = Minecraft.getInstance().world;
//            }
//
//            if (worldIn == null || !worldIn.hasCapability(ItemDataProvider.ITEMDATA_CAP, null) || !stack.hasTagCompound()) {
//                return 0.0F;
//            }
//
//            NBTTagCompound nbt = worldIn.getCapability(ItemDataProvider.ITEMDATA_CAP, null).getItemData().getCompoundTag(stack.getTagCompound().getString("UUID"));
//            NBTTagCompound oldnbt = nbt.getCompoundTag("prev");
//
//            float pt = RenderPartialTickHandler.renderPartialTick;
//
//            float j = (oldnbt.getBoolean(name) ? 1.0F : 0.0F) * (1 - pt) + (nbt.getBoolean(name) ? 1.0F : 0.0F) * pt;
//
//            return j;
//        }
//
//    }
}
