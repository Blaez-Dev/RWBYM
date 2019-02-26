package be.bluexin.rwbym.proxy;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.client.particle.RenderEvents;
import be.bluexin.rwbym.client.particle.RosePetal;
import be.bluexin.rwbym.client.particle.SummerPetal;
import be.bluexin.rwbym.client.particle.TextureStitcher;
import be.bluexin.rwbym.entity.*;
import be.bluexin.rwbym.entity.renderer.*;
import be.bluexin.rwbym.entity.utility.HideUtil;
import be.bluexin.rwbym.weaponry.ICustomItem;
import be.bluexin.rwbym.weaponry.RWBYAmmoEntity;
import be.bluexin.rwbym.weaponry.RWBYAmmoRender;
//import com.sun.org.apache.regexp.internal.RE;
import ibxm.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MouseHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogColors;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogDensity;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;

import javax.swing.text.Utilities;

/**
 * Part of rwbym
 *
 * @author Bluexin
 */
public class ClientProxy extends CommonProxy {


    public void preInit() {
        RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, RWBYAmmoRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityBeowolf.class, BeowolfRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityAtlasKnight.class, AtlasKnightRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityCreep.class, CreepRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityUrsa.class, UrsaRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityBoarbatusk.class, BoarbatuskRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntitySmallFireball.class, FireballRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityLargeFireball.class, LargeFireballRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGoliath.class, GoliathRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityDeathStalker.class, DeathStalkerRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityMutantDeathStalker.class, MutantDeathStalkerRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityNeverMore.class, NeverMoreRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGiantNeverMore.class, GiantNeverMoreRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityWinterBeowolf.class, WinterBeowolfRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityWinterUrsa.class, WinterUrsaRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityWinterBoarbatusk.class, WinterBoarbatuskRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityBlakeFire.class, BlakeFireRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityBlakeIce.class, BlakeIceRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityBlake.class, BlakeRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityArmorgeist.class, ArmorGeistRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityWinterArmorgeist.class, WinterArmorGeistRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGeist.class, GeistRender.FACTORY);
        MinecraftForge.EVENT_BUS.register(new TextureStitcher());
        MinecraftForge.EVENT_BUS.register(new HideUtil());
    }

    public void init() {
        super.init();
        if (RWBYModels.items != null) RWBYModels.items.forEach(ICustomItem::registerModel);
        MinecraftForge.EVENT_BUS.register(new RenderEvents());
    }

    public void generateRosepetals(EntityPlayer playerIn)
    {

        double motionX = playerIn.world.rand.nextGaussian() * 0.02D;
        double motionY = playerIn.world.rand.nextGaussian() * 0.02D;
        double motionZ = playerIn.world.rand.nextGaussian() * 0.02D;
        RosePetal rosepetal = new RosePetal(
        		playerIn.world,
        		playerIn.posX + playerIn.world.rand.nextFloat() * playerIn.width
                        * 2.0F - playerIn.width,
                playerIn.posY + 0.5D + playerIn.world.rand.nextFloat()
                        * playerIn.height,
                playerIn.posZ + playerIn.world.rand.nextFloat() * playerIn.width
                        * 2.0F - playerIn.width,
                motionX,
                motionY,
                motionZ);
                
        Minecraft.getMinecraft().effectRenderer.addEffect(rosepetal);
    }

    public void generateSummerpetals(EntityPlayer playerIn)
    {

        double motionX = playerIn.world.rand.nextGaussian() * 0.02D;
        double motionY = playerIn.world.rand.nextGaussian() * 0.02D;
        double motionZ = playerIn.world.rand.nextGaussian() * 0.02D;
        SummerPetal summerpetal = new SummerPetal(
                playerIn.world,
                playerIn.posX + playerIn.world.rand.nextFloat() * playerIn.width
                        * 2.0F - playerIn.width,
                playerIn.posY + 0.5D + playerIn.world.rand.nextFloat()
                        * playerIn.height,
                playerIn.posZ + playerIn.world.rand.nextFloat() * playerIn.width
                        * 2.0F - playerIn.width,
                motionX,
                motionY,
                motionZ);

        Minecraft.getMinecraft().effectRenderer.addEffect(summerpetal);
    }
    
	public EntityPlayer getPlayer() {
		return Minecraft.getMinecraft().player;
	}

}
