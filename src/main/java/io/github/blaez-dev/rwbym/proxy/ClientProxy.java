package io.github.blaez-dev.rwbym.proxy;

import io.github.blaez-dev.rwbym.PlayerRenderHandler;
import io.github.blaez-dev.rwbym.RWBYModels;
import io.github.blaez-dev.rwbym.client.particle.RenderEvents;
import io.github.blaez-dev.rwbym.client.particle.RosePetal;
import io.github.blaez-dev.rwbym.client.particle.TextureStitcher;
import io.github.blaez-dev.rwbym.entity.*;
import io.github.blaez-dev.rwbym.entity.renderer.*;
import io.github.blaez-dev.rwbym.utility.RWBYConfig;
import io.github.blaez-dev.rwbym.utility.RWBYMath;
import io.github.blaez-dev.rwbym.weaponry.ICustomItem;
import io.github.blaez-dev.rwbym.weaponry.RWBYAmmoRender;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

//import com.sun.org.apache.regexp.internal.RE;

/**
 * Part of rwbym
 *
 * @author Bluexin
 */
public class ClientProxy extends CommonProxy {


    @Override
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
        RenderingRegistry.registerEntityRenderingHandler(EntityApathy.class, ApathyRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityNuckleeve.class, NuckleeveRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityStore.class, StoreRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityLancer.class, LancerRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityJuvenileDeathstalker.class, JuvenileDeathStalkerRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityQueenLancer.class, QueenLancerRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityWeaponStore.class, WeaponStoreRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityBlackStore.class, BlackStoreRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityCrowBar.class, CrowBarRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityRen.class, RenRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityRagora.class, RagoraRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityArmourStore.class, ArmourStoreRender.FACTORY);
        MinecraftForge.EVENT_BUS.register(new TextureStitcher());
    }

    @Override
    public void init() {
        super.init();
        Field skinMap = ReflectionHelper.findField(RenderManager.class, "skinMap", "field_178636_l");
        try {
			PlayerRenderHandler.replacePlayerRenderers((Map<String, RenderPlayer>) skinMap.get(Minecraft.getMinecraft().getRenderManager()));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (RWBYModels.items != null) RWBYModels.items.forEach(ICustomItem::registerModel);
        MinecraftForge.EVENT_BUS.register(new RenderEvents());
    }

    @Override
    public void generateRosepetals(EntityPlayer playerIn, boolean summer)
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
                motionZ,
                summer);
                
        Minecraft.getMinecraft().effectRenderer.addEffect(rosepetal);
    }
    
    @Override
	public EntityPlayer getPlayer() {
		return Minecraft.getMinecraft().player;
	}
	
	@Override
	public World getWorld(int dimension) {
		return Minecraft.getMinecraft().world;
	}
	
	@Override
	public void ragoraParticles(EntityRagora ragora) {
		
		World world = ragora.world;
		
		if (world.isRemote && RWBYConfig.ragoraparticles) {

			Random rand = ragora.getRNG();

			for (int i = 0; i < 10; i++) {

				double x = rand.nextGaussian() * ragora.width / 4;
				double y = rand.nextGaussian() * ragora.width / 4;
				double z = rand.nextGaussian() * ragora.width / 4;

				double dx = rand.nextGaussian() / 100;
				double dy = rand.nextGaussian() / 100;
				double dz = rand.nextGaussian() / 100;

				net.minecraft.client.particle.Particle effect = new net.minecraft.client.particle.ParticleDragonBreath(world, x, y, z, dx, dy, dz) {
					
					{
						float yaw = 180F - ragora.rotationYaw;
						this.posX = ragora.posX + RWBYMath.sind(yaw) * ragora.width + x;
						this.posY = ragora.posY + ragora.height / 2 + y;
						this.posZ = ragora.posZ + RWBYMath.cosd(yaw) * ragora.width + z;
				        this.prevPosX = this.posX;
				        this.prevPosY = this.posY;
				        this.prevPosZ = this.posZ;
			        }

					double offsetX = 0;
					double offsetY = 0;
					double offsetZ = 0;

					@Override
					public void onUpdate() {
						
				        this.prevPosX = this.posX;
				        this.prevPosY = this.posY;
				        this.prevPosZ = this.posZ;

				        if (this.particleAge++ >= this.particleMaxAge)
				        {
				            this.setExpired();
				        }
				        else
				        {
				            this.setParticleTextureIndex(3 * this.particleAge / this.particleMaxAge + 5);
							float yaw = 180F - ragora.rotationYaw;
							this.posX = offsetX + ragora.posX + RWBYMath.sind(yaw) * ragora.width + x;
							this.posY = offsetY + ragora.posY + ragora.height / 2 + y;
							this.posZ = offsetZ + ragora.posZ + RWBYMath.cosd(yaw) * ragora.width + z;
							offsetX += dx;
							offsetY += dy;
							offsetZ += dz;
				        }
					}
				};

				Minecraft.getMinecraft().effectRenderer.addEffect(effect);
				//world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, x + rand.nextGaussian() * this.width / 4, y + rand.nextGaussian() * this.width / 4, z + rand.nextGaussian() * this.width / 4, 0, 0, 0);
			}
		}
	}
	
	@Override
	public EntityPlayer loadPlayer(NBTTagCompound teamnbt, String key, World world) {
		EntityPlayer member;
		if (world.isRemote) {
			GameProfile profile = new GameProfile(UUID.fromString(teamnbt.getString(key)), teamnbt.getString(key + "name"));
			TileEntitySkull.updateGameprofile(profile);
			member = new EntityOtherPlayerMP(world, profile);
			member.deserializeNBT(teamnbt.getCompoundTag(key + "data"));
			member.setEntityId(teamnbt.getInteger(key + "id"));
		}
		else {
			member = super.loadPlayer(teamnbt, key, world);
		}
		
		return member;
	}



	@Override
	public EntityPlayer getClientPlayer() {
		return Minecraft.getMinecraft().player;
	}

	@Override
	public void showGuiScreen(Object clientGuiElement) {
		GuiScreen gui = (GuiScreen) clientGuiElement;
		Minecraft.getMinecraft().displayGuiScreen(gui);
	}

}
