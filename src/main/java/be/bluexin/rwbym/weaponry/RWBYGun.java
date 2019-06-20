package be.bluexin.rwbym.weaponry;

import be.bluexin.rwbym.Init.RWBYCreativeTabs;
import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.RWBYSoundHandler;
import be.bluexin.rwbym.entity.EntityLargeFireball;
import be.bluexin.rwbym.entity.EntityNeverMore;
import com.google.common.collect.Sets;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import scala.tools.nsc.doc.model.Public;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import java.util.List;
import java.util.Set;

import static net.minecraft.item.ItemBow.getArrowVelocity;

/**
 * Part of rwbym
 *
 * @author Bluexin
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class RWBYGun extends ItemBow implements ICustomItem{

    private final String data;
    private final int drawSpeed;
    private final String morph;
    private final String ammo;
    private final float projectileSpeed;
    private final boolean charges; // TODO: use this
    private int recoil;
    private boolean mytre = false;
    private boolean port = false;
    private boolean glow = false;
    private boolean cinder = false;
    private int soundeffect;
    private int bulletCount;
    private int weapontype;
    public final boolean isShield;
    private boolean  canBlock = false;
    boolean compensate;
    float lastDamage;
    private boolean climbs = false;
    private boolean ohblade = true;
    private float damages = 0;
    //Weapon Type Numbers//
    /* 1 Rapier
    *  2 Scythe
    *  3 Offhand Blades
    *  4 Scarlet Weapon Behaviour
    *  5 Junior Rocket Launcher
    *  6 Ember celica 2
    *
    *
    * recoiltype
    *
    * */

    public RWBYGun(String name, int durability, int drawSpeed, int weapoontype, String data, String morph, String ammo, boolean noCharge, float projectileSpeed, boolean shield,boolean canBlock, int recoilType, int bulletCount, int enchantmentglow,int soundeffect, CreativeTabs creativetab) {
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(creativetab);
        this.drawSpeed = drawSpeed;
        this.data = data;
        this.morph = morph;
        this.ammo = ammo;
        this.projectileSpeed = projectileSpeed;
        this.charges = !noCharge;
        this.isShield = shield;
        this.bulletCount = bulletCount;
        this.recoil = recoilType;
        this.canBlock = canBlock;
        this.weapontype = weapoontype;
        this.setMaxDamage(durability);


        this.soundeffect = soundeffect;
        if(weapoontype == 3) { ohblade = true; this.damages = 14; }
        if(name.contains("weiss")||name.contains("oobleck")||name.contains("goodwitch")){mytre = true;}
        if(enchantmentglow > 1){glow = true;}


        if (this.isShield) this.addPropertyOverride(new ResourceLocation("offhand"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            @ParametersAreNonnullByDefault
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.getHeldItemOffhand() == stack ? 1.0F : 0.0F;
            }
        });

        if (weapontype == 4) this.addPropertyOverride(new ResourceLocation("offhand1"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            @ParametersAreNonnullByDefault
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.getHeldItemOffhand() == stack ? 1.0F : 0.0F;
            }
        });


        this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    return entityIn.getActiveItemStack().getItem() != RWBYItems.chatareusgun ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
                }
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });


        this.addPropertyOverride(new ResourceLocation("pull1"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    return entityIn.getActiveItemStack().getItem() != RWBYItems.cinderbow ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
                }
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling1"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });


        if (weapoontype == 6) this.addPropertyOverride(new ResourceLocation("offhand"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            @ParametersAreNonnullByDefault
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.getHeldItemOffhand() == stack ? 1.0F : 0.0F;
            }
        });


        if(bulletCount == 0){
            System.out.println(name + " has no projectiles registered and has temporarily been set to 1.");
            this.bulletCount = 1;
        }
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }


    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return this.drawSpeed;
    }


    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        if(glow){return true;}
        else
            return false;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void onUpdate(ItemStack is, World world, Entity entity, int slotIn, boolean inHand) {
        if(!world.isRemote) {
            if (entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entity;
                {    if (climbs) {
                    if (player.fallDistance > 4 & compensate) {
                        lastDamage = player.fallDistance;
                        player.fallDistance = 0.3F;
                    } else if (!(player.fallDistance > 0)) {
                        if (compensate) {
                            compensate = false;
                        }
                    }
                }
                }}
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



    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack is = playerIn.getHeldItem(handIn);
        boolean flag = !this.findAmmo(playerIn, false).isEmpty();
        if (!worldIn.isRemote && playerIn.isSneaking() && this.morph != null&& playerIn.getHeldItemMainhand() == is) {
            is = new ItemStack(Item.getByNameOrId(this.morph), is.getCount(), is.getMetadata());
            return new ActionResult<>(EnumActionResult.SUCCESS, is);
        } else if (weapontype == 4 && handIn == EnumHand.MAIN_HAND) {
            return new ActionResult<>(EnumActionResult.FAIL, is);}
        else if (this.isShield && handIn == EnumHand.OFF_HAND) {
            playerIn.setActiveHand(EnumHand.OFF_HAND);
            return new ActionResult<>(EnumActionResult.SUCCESS, is);}else if (canBlock && handIn == EnumHand.MAIN_HAND) {
            playerIn.setActiveHand(EnumHand.MAIN_HAND);
            return new ActionResult<>(EnumActionResult.SUCCESS, is);
        }
        if (!flag) if (playerIn.onGround){
            if (recoil == 3) {
                Vec3d look = playerIn.getLookVec();
                playerIn.motionX = look.x;
                playerIn.motionZ = look.z;
                playerIn.motionY = look.y /1;
                playerIn.lastTickPosZ = -look.x;
                playerIn.lastTickPosX = -look.z;
            }}
        if (!flag) {if (recoil == 4)  { if (playerIn.collidedHorizontally){
            //PotionEffect potioneffect = new PotionEffect(MobEffects.JUMP_BOOST, 60, 5, false, false);
            Vec3d look = playerIn.getLookVec();
            playerIn.motionX = look.x/2;
            playerIn.motionZ = look.z/2;
            playerIn.motionY = look.y/2;
            playerIn.lastTickPosZ = -look.x;
            playerIn.lastTickPosX = -look.z;
            compensate = true;
            //playerIn.addPotionEffect(potioneffect);
            playerIn.fallDistance = 0;
        }}}

        ItemStack itemstack = playerIn.getHeldItem(handIn);
        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
        if (ret != null) return ret;
        if (!flag) {
            return new ActionResult<>(EnumActionResult.FAIL, itemstack);
        } else {
            if (charges) {
                playerIn.setActiveHand(handIn);
                return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);

            } else {
                this.onPlayerStoppedUsing(is, worldIn, playerIn, 0);
                return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
            }}
    }



    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        if(stack.getItem() == RWBYItems.chatareusgun){
            return EnumAction.BOW;
        }else if(stack.getItem() == RWBYItems.cinderbow){
            return EnumAction.BOW;
        }else if(canBlock){return  EnumAction.BLOCK;}else return EnumAction.BLOCK;
    }

    @Nonnull
    private ItemStack findAmmo(EntityPlayer player, boolean force) {

        Item ammo1 = this.ammo == null ? Items.ARROW : Item.getByNameOrId(this.ammo);
        if (force || (ammo1 instanceof ItemArrow && ((ItemArrow) ammo1).isInfinite(null, player.getActiveItemStack(), player))
                || (ammo1 instanceof RWBYAmmoItem && ((RWBYAmmoItem) ammo1).isInfinite())) {
            return new ItemStack(ammo1);
        }

        // the rest is a copy from ItemBow#findAmmo(EntityPlayer)
        if (this.isArrow(player.getHeldItem(EnumHand.OFF_HAND))) {
            return player.getHeldItem(EnumHand.OFF_HAND);
        } else if (this.isArrow(player.getHeldItem(EnumHand.MAIN_HAND))) {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        } else {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
                ItemStack itemstack = player.inventory.getStackInSlot(i);

                if (this.isArrow(itemstack)) {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }


    //Thanks Bright_Spark//
    protected boolean isArrow(@Nonnull ItemStack stack) {
        String[] itemIds = ammo.split(",");
        for (int i = 0; i < itemIds.length; i++) {
            String item = itemIds[i];
            if (stack.getItem().getRegistryName().toString().equals(item))
                return true;
        }
        return false;
    }

    public int getItemEnchantability()
    {
        return 0;
    }


    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) { // Mostly copied from ItemBow, with slight edits
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer) entityLiving;
            boolean flagger = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            boolean flag = false;
            boolean flag2 = false;
            ItemStack itemstack = this.findAmmo(entityplayer, flag);

            if(!itemstack.isEmpty()){
                flag2 = true;
            }

            ItemStack is = entityplayer.getActiveItemStack();
            if (is.getItem() == RWBYItems.pyrrharifle && entityplayer.getActiveHand() == EnumHand.OFF_HAND)
            {
                flag2 = false;
            }


            if(ohblade && entityLiving instanceof EntityPlayer && entityLiving.getHeldItemOffhand() == stack) {
                Entity entity = this.findEntityOnPath(worldIn, entityLiving, entityLiving.getEntityAttribute(EntityPlayer.REACH_DISTANCE).getAttributeValue());
                if (entity instanceof EntityLivingBase) {
                    EntityLivingBase entitylivingbase = (EntityLivingBase) entity;
                    if (entitylivingbase != entityLiving && !entityLiving.isOnSameTeam(entitylivingbase)) {
                        entitylivingbase.knockBack(entityLiving, 0.4F, (double) MathHelper.sin(entityLiving.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(entityLiving.rotationYaw * 0.017453292F)));
                        entitylivingbase.attackEntityFrom(DamageSource.GENERIC, damages + 4);
                        stack.damageItem(1, entityLiving);
                        entityLiving.world.playSound((EntityPlayer) null, entityLiving.posX, entityLiving.posY, entityLiving.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, entityLiving.getSoundCategory(), 1.0F, 1.0F);
                    }
                }
            }


            int i = this.getMaxItemUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, (EntityPlayer) entityLiving, i, itemstack != null);
            if (i < 0) return;

            if (flag2 || flag) {

                float f = getArrowVelocity(72);

                if ((double) f >= 0.1D) {

                    if (!worldIn.isRemote) {
                        for (int i2 = 0; i2 < bulletCount; i2++) {
                            EntityArrow entityarrow = (itemstack.getItem() instanceof RWBYAmmoItem ? ((RWBYAmmoItem) itemstack.getItem()).createArrow(worldIn, itemstack, entityplayer) : ((ItemArrow) Items.ARROW).createArrow(worldIn, itemstack, entityplayer));
                            entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F * (this.projectileSpeed == 0.0F ? 1.0F : this.projectileSpeed), 5.0F);

                            entityarrow.setIsCritical(true);

                            worldIn.spawnEntity(entityarrow);
                            //if (f >= 1.0F) entityarrow.setIsCritical(true);
                        }
                        if (weapontype == 5) {stack.damageItem(30,entityplayer);}
                        else stack.damageItem(1, entityplayer);
                    }

                    if (soundeffect == 1) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Crescent_Rose_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 2){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Ember_Celica_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 3) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Gambol_Shroud_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 4) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Mytrenaster_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 5){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.StormFlower_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 6) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Magnhild_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 7) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Ember_Celica_Shoot, SoundCategory.MASTER, 1.0F, 0.2F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 8) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Port_Shoot, SoundCategory.MASTER, 1.0F, 0.8F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 9) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Gambol_Shroud_Shoot, SoundCategory.MASTER, 1.0F, 0.7F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 10) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Junior_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 11) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Torchwick_Shoot, SoundCategory.MASTER, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 12) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Crescent_Rose_Shoot, SoundCategory.MASTER, 1.0F, 2F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if (soundeffect == 13) {
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.Crescent_Rose_Shoot, SoundCategory.MASTER, 0.5F, 3F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }
                    if (soundeffect == 14){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, RWBYSoundHandler.StormFlower_Shoot, SoundCategory.MASTER, 1.0F, 0.5F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    }

                    if(soundeffect == 15){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1.0F, 0.5F/ (itemRand.nextFloat() * 0.4F + 1.0F) + f + 0.5F);
                    }

                    if(soundeffect == 16){
                        worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, 1.0F, 0.5F/ (itemRand.nextFloat() * 0.4F + 1.0F) + f + 0.5F);
                    }



                    //shooting recoil
                    if (recoil == 1) {
                        Vec3d look = entityplayer.getLookVec();
                        entityplayer.motionX = -look.x ;
                        entityplayer.motionZ = -look.z ;
                        entityplayer.motionY = -look.y/2 ;
                        entityplayer.lastTickPosZ = -look.x;
                        entityplayer.lastTickPosX = -look.z;
                        entityplayer.fallDistance = 0;
                    }

                    if (recoil == 2) {
                        Vec3d look = entityplayer.getLookVec();
                        entityplayer.motionX = -look.x ;
                        entityplayer.motionZ = -look.z ;
                        entityplayer.motionY = -look.y/4 ;
                        entityplayer.lastTickPosZ = -look.x;
                        entityplayer.lastTickPosX = -look.z;
                    }
                    if (!flag){
                        if (cinder & !flagger) {
                            itemstack.shrink(1);
                        }
                    }
                    if (!flag){
                        if (mytre) {
                            itemstack.damageItem(2, entityplayer);
                        }
                        else {
                            itemstack.damageItem(1, entityplayer);
                        }
                    }
                }
            }
        }
    }

    @Nullable
    protected Entity findEntityOnPath(World world, Entity entityIn, double range)
    {
        Entity entity = null;
        Vec3d start = entityIn.getPositionEyes(1);
        Vec3d look = entityIn.getLook(1);
        Vec3d end = start.addVector(look.x * range, look.y * range, look.z * range);
        RayTraceResult raytraceresult1 = world.rayTraceBlocks(start, end, false, true, false);

        if (raytraceresult1 != null)
        {
            end = new Vec3d(raytraceresult1.hitVec.x, raytraceresult1.hitVec.y, raytraceresult1.hitVec.z);
        }

        List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(entityIn, new AxisAlignedBB(start.x, start.y, start.z, end.x, end.y, end.z));
        double d0 = 0.0D;

        for (int i = 0; i < list.size(); ++i)
        {
            Entity entity1 = list.get(i);

            AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().grow(0.30000001192092896D);
            RayTraceResult raytraceresult2 = axisalignedbb.calculateIntercept(start, end);

            if (raytraceresult2 != null)
            {
                double d1 = start.squareDistanceTo(raytraceresult2.hitVec);

                if (d1 < d0 || d0 == 0.0D)
                {
                    entity = entity1;
                    d0 = d1;
                }
            }
        }

        return entity;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {  if(weapontype == 1){
        //Rapier
        boolean unarm = false;
        if(target.getTotalArmorValue() == 0){
            unarm = true; }

        if(!unarm && !ohblade){
            target.attackEntityFrom(DamageSource.GENERIC, 35);
        }}

        if(weapontype == 2){
            //Scythe
            for (EntityLivingBase entitylivingbase : attacker.world.getEntitiesWithinAABB(EntityLivingBase.class, target.getEntityBoundingBox().grow(3.0D, 0.25D, 3.0D))) {
                if (entitylivingbase != attacker && entitylivingbase != target && !attacker.isOnSameTeam(entitylivingbase) && attacker.getDistanceSq(entitylivingbase) < 9.0D) {
                    entitylivingbase.knockBack(attacker, 0.4F, (double) MathHelper.sin(attacker.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(attacker.rotationYaw * 0.017453292F)));
                    entitylivingbase.attackEntityFrom(DamageSource.GENERIC, 16);
                }
            }

            attacker.world.playSound((EntityPlayer) null, attacker.posX, attacker.posY, attacker.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, attacker.getSoundCategory(), 1.0F, 1.0F);
        }

        stack.damageItem(1, attacker);
        return true;
    }

    @Override
    public String toString() {
        return "RWBYBow{" + this.getRegistryName() + "}";
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