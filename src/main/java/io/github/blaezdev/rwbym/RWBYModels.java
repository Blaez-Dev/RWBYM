package io.github.blaezdev.rwbym;

import io.github.blaezdev.rwbym.Init.RWBYBiomes;
import io.github.blaezdev.rwbym.Init.RWBYCreativeTabs;
import io.github.blaezdev.rwbym.Init.RWBYFluids;
import io.github.blaezdev.rwbym.Init.RegUtil;
import io.github.blaezdev.rwbym.blocks.containers.CrusherContainer;
import io.github.blaezdev.rwbym.blocks.tileentities.TileEntityRWBYCrusher;
import io.github.blaezdev.rwbym.blocks.tileentities.TileEntityRWBYGrimmBait;
import io.github.blaezdev.rwbym.capabilities.CapabilityHandler;
import io.github.blaezdev.rwbym.commands.CommandAura;
import io.github.blaezdev.rwbym.commands.CommandChangeSemblance;
import io.github.blaezdev.rwbym.gui.GUICrusher;
import io.github.blaezdev.rwbym.gui.IRWBYGuiFactory;
import io.github.blaezdev.rwbym.gui.scroll.GuiScreenScrollTeam;
import io.github.blaezdev.rwbym.handler.ModEventHandler;
import io.github.blaezdev.rwbym.inventory.IRWBYContainerFactory;
import io.github.blaezdev.rwbym.proxy.CommonProxy;
import io.github.blaezdev.rwbym.utility.network.RWBYNetworkHandler;
import io.github.blaezdev.rwbym.weaponry.ICustomItem;
import io.github.blaezdev.rwbym.weaponry.RWBYContainerItem;
import io.github.blaezdev.rwbym.weaponry.RWBYGun;
import io.github.blaezdev.rwbym.weaponry.RWBYHood;
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    public static final String VERSION = "4.4.4";
    public static List<ICustomItem> items;

    public static final Logger LOGGER = LogManager.getLogger(MODID);
    
    
    // set these to Level.INFO to see the logs in the console
    // used to control the level of logs that would log every tick
    public static Level updtes = Level.DEBUG;
    // used to control the level of logs used for debugging
    public static Level debug = Level.DEBUG;

    @SidedProxy(clientSide = "io.github.blaezdev.rwbym.proxy.ClientProxy", serverSide = "io.github.blaezdev.rwbym.proxy.ServerProxy")
    public static CommonProxy proxy;
    public static Side side = FMLCommonHandler.instance().getSide();

    public static final int GuiCrusher = 1;

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
    
    //pre-preInit
    static {
    	FluidRegistry.enableUniversalBucket();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //LOGGER.log(Level.ALL, "all"); // does not log to console but can be found in the forge log file // should only be used to set logger level, which can't be done without copying and modifying forge files
    	//LOGGER.log(Level.TRACE, "trace"); // does not log to console but can be found in the forge log file
    	//LOGGER.log(Level.DEBUG, "debug"); // does not log to console but can be found in the forge log file
    	//LOGGER.log(Level.INFO, "info");
    	//LOGGER.log(Level.WARN, "warn");
    	//LOGGER.log(Level.ERROR, "error");
    	//LOGGER.log(Level.FATAL, "fatal");
    	//LOGGER.log(Level.OFF, "off"); // should only be used to set logger level, which can't be done without copying and modifying forge files

        MinecraftForge.EVENT_BUS.register(new ModEventHandler());

        if (event.getSide() == Side.CLIENT){
            KeybindRegistry.register();
            MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
            MinecraftForge.EVENT_BUS.register(new PlayerRenderHandler());
        }
        MinecraftForge.EVENT_BUS.register(new EntityUpdatesHandler());
		MinecraftForge.EVENT_BUS.register(new CapabilityHandler());

		CapabilityHandler.registerAll();
        RWBYNetworkHandler.init();
        RWBYCreativeTabs.init();
        RWBYBiomes.registerBiomes();
        RWBYEntities.instance = instance;
        GameRegistry.registerTileEntity(TileEntityRWBYCrusher.class, new ResourceLocation(this.MODID, "furnace"));
        GameRegistry.registerTileEntity(TileEntityRWBYGrimmBait.class, new ResourceLocation(this.MODID, "bait"));
        rwbym_1.preInit(event);
        RWBYFluids.register();
        RegUtil.registerAll(event);
        RegUtil.registerGamePotions();
        MinecraftForge.EVENT_BUS.register(this);
        if (items != null) items.forEach(ICustomItem::register);
        proxy.preInit(event);
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
        System.out.println("Blaez:RWBYM Relz" +" "+ this.VERSION);
        //if (items != null) items.forEach(ICustomItem::registerRecipes);
        if (event.getSide() == Side.CLIENT) {
            OBJLoader.INSTANCE.addDomain("rwbym");
        }
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        RegUtil.registerAllRecipes(event);
        proxy.registerRenderers(this);
        RWBYSoundHandler.init();
    }

    @Mod.EventHandler
    public void serverStart(FMLServerStartingEvent event) {
    	event.registerServerCommand(new CommandChangeSemblance());
    	event.registerServerCommand(new CommandAura());
    }

    public static class GuiHandler implements IGuiHandler {
    	
    	public enum GUI {
    		ITEM_CONTAINER_MAINHAND,
    		ITEM_CONTAINER_OFFHAND,
    		SCROLL,
    		GUI_Crusher
    	}
    	
        @Override
        public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {

        	switch (GUI.values()[id]) {
        		case ITEM_CONTAINER_MAINHAND:
        			ItemStack stack = player.getHeldItemMainhand();
        			return IRWBYContainerFactory.createInstance(((RWBYContainerItem)stack.getItem()).getContainerClass(), player.inventory, stack);
				case ITEM_CONTAINER_OFFHAND:
					stack = player.getHeldItemOffhand();
        			return IRWBYContainerFactory.createInstance(((RWBYContainerItem)stack.getItem()).getContainerClass(), player.inventory, stack);
				case SCROLL:
					return null;
                case GUI_Crusher:
                    return new CrusherContainer(player.inventory, (TileEntityRWBYCrusher) world.getTileEntity(new BlockPos(x,y,z)));
    			}

        	throw new IllegalArgumentException("No GUI with ID: " + id);

        }

        @Override
        public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {

        	switch (GUI.values()[id]) {
	    		case ITEM_CONTAINER_MAINHAND:
        			ItemStack stack = player.getHeldItemMainhand();
        			return IRWBYGuiFactory.createInstance(((RWBYContainerItem)stack.getItem()).getGuiClass(), player.inventory, stack);
	    		case ITEM_CONTAINER_OFFHAND:
	    			stack = player.getHeldItemOffhand();
        			return IRWBYGuiFactory.createInstance(((RWBYContainerItem)stack.getItem()).getGuiClass(), player.inventory, stack);
	    		case SCROLL:
	    			return new GuiScreenScrollTeam(player);
                case GUI_Crusher:
                    return new GUICrusher(player.inventory, (TileEntityRWBYCrusher) world.getTileEntity(new BlockPos(x,y,z)));
	    	}
	    	
	    	throw new IllegalArgumentException("No GUI with ID: " + id);
    	}
    }


    @SubscribeEvent
    public void onEntityAttacked(LivingAttackEvent event) {
        EntityLivingBase base = event.getEntityLiving();
        ItemStack stack = base.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
        if (stack != null && stack.getItem() instanceof RWBYHood) {
            RWBYHood Hood = (RWBYHood) stack.getItem();
            int damage = (int) event.getAmount();
            if(damage > 2){
            stack.damageItem(damage/2, base);}
        }
    }


    @SubscribeEvent
    public void damagegunshield(LivingAttackEvent e) { // Fuck hardcoded vanilla shit
        if (e.getEntityLiving().isEntityInvulnerable(e.getSource()) || !(e.getEntityLiving() instanceof EntityPlayer) || !canBlockDamageSource(e.getSource(), e.getEntityLiving()))
            return;

        EntityPlayer player = (EntityPlayer) e.getEntityLiving();
        if (player.getActiveItemStack().isEmpty()) return;
        float damage = e.getAmount();
        ItemStack activeItemStack = player.getActiveItemStack();



        if (damage > 0.0F && !activeItemStack.isEmpty() && activeItemStack.getItem() instanceof RWBYGun && ((RWBYGun) activeItemStack.getItem()).isShield) {
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
    public void damagegunblock(LivingAttackEvent e) { // Fuck hardcoded vanilla shit
        if (e.getEntityLiving().isEntityInvulnerable(e.getSource()) || !(e.getEntityLiving() instanceof EntityPlayer) || !canBlockDamageSource(e.getSource(), e.getEntityLiving()))
            return;

        EntityPlayer player = (EntityPlayer) e.getEntityLiving();
        if (player.getActiveItemStack().isEmpty()) return;
        float damage = e.getAmount();
        ItemStack activeItemStack = player.getActiveItemStack();

        if (damage > 0.0F && !activeItemStack.isEmpty() && activeItemStack.getItem() instanceof RWBYGun && ((RWBYGun) activeItemStack.getItem()).canBlock) {
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
    
    /**Helper function to get the sign of a number*/
    public static int sign(double x) {
    	return (int) (x / Math.abs(x));
    }
    
    /**Helper function to get the sign of a number*/
    public static int sign(float x) {
    	return sign((double) x);
    }
    
    /**Helper function to get the sign of a number*/
    public static int sign(int x) {
    	return sign((double) x);
    }
    
    /**Helper function to get the players true xp count*/
    public static int getXpTotal(EntityPlayer player) {
    	int exp = 0;
    	
    	for (int i = 0; i < player.experienceLevel; i++) {
    		exp += xpBarCap(i);
    	}
    	
    	exp += (int) (player.experience * player.xpBarCap() + 0.5f);
    	
    	return exp;
    	
    }
    
    /**Helper function to get the bar cap for the specified experience level*/
    public static int xpBarCap(int level)
    {
    	if (level < 0) {
    		return 0;
    	}
        if (level >= 30)
        {
            return 112 + (level - 30) * 9;
        }
        else
        {
            return level >= 15 ? 37 + (level - 15) * 5 : 7 + level * 2;
        }
    }
    
    /**Helper function to add/remove exp from player*/
    public static void addXp(int amount, EntityPlayer player) {
		int xpbaramt = (int) (player.experience * player.xpBarCap() + 0.5f);
		int exp = amount;
		while (-exp > xpbaramt && player.experienceLevel > 0) {
			player.experienceLevel -= 1;
			player.experience = 1;
			exp += xpbaramt;
			xpbaramt = player.xpBarCap();
		}
		if (exp > 0) {
			player.addExperience(exp);
		}
		else {
			player.experience += (float)exp / (float)player.xpBarCap();
		}
		player.experienceTotal = RWBYModels.getXpTotal(player);
    }
}


