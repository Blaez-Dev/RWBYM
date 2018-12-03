package be.bluexin.rwbym;

import be.bluexin.rwbym.Init.RWBYBiomes;
import be.bluexin.rwbym.Init.RWBYCreativeTabs;
import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.capabilities.ruby.IRuby;
import be.bluexin.rwbym.capabilities.ruby.Ruby;
import be.bluexin.rwbym.capabilities.ruby.RubyStorage;
import be.bluexin.rwbym.proxy.CommonProxy;
import be.bluexin.rwbym.utility.RegUtil;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import be.bluexin.rwbym.weaponry.ICustomItem;
import be.bluexin.rwbym.weaponry.RWBYSword;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

import java.util.List;

/**
 * Part of rwbym
 *
 * @author Bluexin & Blaez
 */
@Mod(modid = RWBYModels.MODID, name = RWBYModels.MODNAME, version = RWBYModels.VERSION)
public class RWBYModels {
    public static final String MODID = "rwbym";
    public static final String MODNAME = "RWBY-M";
    public static final String VERSION = "2.0";

    public static List<ICustomItem> items;



    @SidedProxy(clientSide = "be.bluexin.rwbym.proxy.ClientProxy", serverSide = "be.bluexin.rwbym.proxy.CommonProxy")
    public static CommonProxy proxy;
    public static Side side = FMLCommonHandler.instance().getSide();
    /*
     * Basically a copy from EntityLivingBase#canBlockDamageSource(DamageSource) cuz fkin private and this is easier/faster then AT/reflection
     */
    private static boolean canBlockDamageSource(DamageSource damageSourceIn, EntityLivingBase entity) {
        if (!damageSourceIn.isUnblockable() && entity.isActiveItemStackBlocking()) {
            Vec3d vec3d = damageSourceIn.getDamageLocation();

            if (vec3d != null) {
                Vec3d vec3d1 = entity.getLook(1.0F);
                Vec3d vec3d2 = vec3d.subtractReverse(new Vec3d(entity.posX, entity.posY, entity.posZ)).normalize();
                vec3d2 = new Vec3d(vec3d2.x, 0.0D, vec3d2.z);

                if (vec3d2.dotProduct(vec3d1) < 0.0D) {
                    return true;
                }
            }
        }

        return false;
    }



    @Mod.Instance(MODID)
    public static RWBYModels instance;
    public RWBYEntities rwbym_1 = new RWBYEntities();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        if (event.getSide() == Side.CLIENT){
            KeybindRegistry.register();
            MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
            MinecraftForge.EVENT_BUS.register(new PlayerRenderHandler());
        }
        MinecraftForge.EVENT_BUS.register(new EntityUpdatesHandler());
		MinecraftForge.EVENT_BUS.register(new CapabilityHandler());

        CapabilityManager.INSTANCE.register(IRuby.class, new RubyStorage(), Ruby.class);

        RWBYNetworkHandler.init();
        RWBYCreativeTabs.init();
        RWBYBiomes.registerBiomes();
        RWBYEntities.instance = instance;
        rwbym_1.preInit(event);
        RegUtil.registerAll(event);
        MinecraftForge.EVENT_BUS.register(this);
        if (items != null) items.forEach(ICustomItem::register);
        proxy.preInit();
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
        System.out.println("Blaez:RWBYM Relz 2.4");
        //if (items != null) items.forEach(ICustomItem::registerRecipes);
        if (event.getSide() == Side.CLIENT) {
            OBJLoader.INSTANCE.addDomain("rwbym");
        }
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        proxy.registerRenderers(this);
        RWBYSoundHandler.init();
        //RWBYItems.init();
    }



    public static class GuiHandler implements IGuiHandler {
        @Override
        public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
            return null;
        }

        @Override
        public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
            return null;
        }
    }


    @SubscribeEvent
    public void damageShield(LivingAttackEvent e) { // Fuck hardcoded vanilla shit
        if (e.getEntityLiving().isEntityInvulnerable(e.getSource()) || !(e.getEntityLiving() instanceof EntityPlayer) || !canBlockDamageSource(e.getSource(), e.getEntityLiving()))
            return;

        EntityPlayer player = (EntityPlayer) e.getEntityLiving();
        if (player.getActiveItemStack().isEmpty()) return;
        float damage = e.getAmount();
        ItemStack activeItemStack = player.getActiveItemStack();

        if (damage > 0.0F && !activeItemStack.isEmpty() && activeItemStack.getItem() instanceof RWBYSword && ((RWBYSword) activeItemStack.getItem()).isShield) {
            activeItemStack.damageItem(1 + MathHelper.floor(damage), player);

            if (activeItemStack.getCount() <= 0) {
                EnumHand enumhand = player.getActiveHand();
                net.minecraftforge.event.ForgeEventFactory.onPlayerDestroyItem(player, activeItemStack, enumhand);

                if (enumhand == EnumHand.MAIN_HAND) {
                    player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, null);
                } else {
                    player.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, null);
                }

                player.setActiveHand(enumhand);
                if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
                    player.playSound(SoundEvents.ITEM_SHIELD_BREAK, 0.8F, 0.8F + player.world.rand.nextFloat() * 0.4F);
                }
            }

            if (!player.world.isRemote && e.getSource().getTrueSource() instanceof EntityLivingBase) {
                EntityLivingBase el = (EntityLivingBase) e.getSource().getTrueSource();
                ItemStack is = el.getHeldItemMainhand();
                if (!is.isEmpty() && is.getItem() instanceof ItemAxe) {
                    float f3 = 0.25F + (float) EnchantmentHelper.getEfficiencyModifier(el) * 0.05F;

                    if (el instanceof EntityPlayer) {
                        float f2 = ((EntityPlayer) el).getCooledAttackStrength(0.5F);

                        if (el.isSprinting() && f2 > 0.9F) {
                            el.world.playSound(null, el.posX, el.posY, el.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK, el.getSoundCategory(), 1.0F, 1.0F);
                            f3 += 0.75F;
                        }
                    }

                    if (Math.random() /* yeah not using the entity's rand... private */ < f3) {
                        player.getCooldownTracker().setCooldown(Items.SHIELD, 100);
                        player.world.setEntityState(player, (byte) 30);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void damageSwords(LivingAttackEvent e) { // Fuck hardcoded vanilla shit
        if (e.getEntityLiving().isEntityInvulnerable(e.getSource()) || !(e.getEntityLiving() instanceof EntityPlayer) || !canBlockDamageSource(e.getSource(), e.getEntityLiving()))
            return;

        EntityPlayer player = (EntityPlayer) e.getEntityLiving();
        if (player.getActiveItemStack().isEmpty()) return;
        float damage = e.getAmount();
        ItemStack activeItemStack = player.getActiveItemStack();

        if (damage > 0.0F && !activeItemStack.isEmpty() && activeItemStack.getItem() instanceof RWBYSword && ((RWBYSword) activeItemStack.getItem()).canBlock) {
            activeItemStack.damageItem(1 + MathHelper.floor(damage), player);

            if (activeItemStack.getCount() <= 0) {
                EnumHand enumhand = player.getActiveHand();
                net.minecraftforge.event.ForgeEventFactory.onPlayerDestroyItem(player, activeItemStack, enumhand);

                if (enumhand == EnumHand.MAIN_HAND) {
                    player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, null);
                } else {
                    player.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, null);
                }

                player.setActiveHand(enumhand);
                if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
                    player.playSound(SoundEvents.ITEM_SHIELD_BREAK, 0.8F, 0.8F + player.world.rand.nextFloat() * 0.4F);
                }
            }

            if (!player.world.isRemote && e.getSource().getTrueSource() instanceof EntityLivingBase) {
                EntityLivingBase el = (EntityLivingBase) e.getSource().getTrueSource();
                ItemStack is = el.getHeldItemMainhand();
                if (!is.isEmpty() && is.getItem() instanceof ItemAxe) {
                    float f3 = 0.25F + (float) EnchantmentHelper.getEfficiencyModifier(el) * 0.05F;

                    if (el instanceof EntityPlayer) {
                        float f2 = ((EntityPlayer) el).getCooledAttackStrength(0.5F);

                        if (el.isSprinting() && f2 > 0.9F) {
                            el.world.playSound(null, el.posX, el.posY, el.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK, el.getSoundCategory(), 1.0F, 1.0F);
                            f3 += 0.75F;
                        }
                    }

                    if (Math.random() /* yeah not using the entity's rand... private */ < f3) {
                        player.getCooldownTracker().setCooldown(Items.SHIELD, 100);
                        player.world.setEntityState(player, (byte) 30);
                    }
                }
            }
        }
    }
}

/*
De note of stooff
O -Read From Json-
O -Specify Model/Texture of Item
O -Specify Weapon Type Bow|Sword|Ammo and Required Ammo?
O -Custom Crafting
O -Support for Attribute Data? *things like max health/movement speed.

     Maybe??
O -add tag to convert to a shield while in off-hand slot and convert back to weapon while in mainhand maybe?
O -add tag to enable shift right click to swap a weapon to a bow/model change and back maybe?
0 add support for custom ammo
0 add support for generic items
- gun recoil setting + no "charging" (maybe CD)

///give @p potion 1 16398 {CustomPotionEffects: [{Id: 25,Amplifier: 20,Duration: 10}],display: {Name:"Potion of Levitation"}}


{AttributeModifiers:[
{AttributeName:"generic.maxHealth",Name:"generic.maxHealth",Amount:200,Operation:0,UUIDMost:11369,UUIDLeast:108625},
{AttributeName:"generic.movementSpeed",Name:"generic.movementSpeed",Amount:200,Operation:0,UUIDMost:37055,UUIDLeast:183337},
{AttributeName:"generic.attackDamage",Name:"generic.attackDamage",Amount:200,Operation:0,UUIDMost:29896,UUIDLeast:154919}]}
 */
