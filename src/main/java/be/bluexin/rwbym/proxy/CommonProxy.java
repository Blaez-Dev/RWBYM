package be.bluexin.rwbym.proxy;

import be.bluexin.rwbym.Init.Oregen;
import be.bluexin.rwbym.entity.EntityRagora;
import be.bluexin.rwbym.RWBYModels;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.management.PlayerInteractionManager;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import java.io.File;
import java.util.UUID;

import com.mojang.authlib.GameProfile;

/**
 * Part of rwbym
 *
 * @author Bluexin
 */
public class CommonProxy {

    public void preInit() {
    }

    public void registerRenderers(RWBYModels ins) {
    }

    public void init() {
        GameRegistry.registerWorldGenerator(new Oregen(), 0 );
    }

    public void generateRosepetals(EntityPlayer playerIn) {}

    public void generateSummerpetals(EntityPlayer playerIn) {}

	public EntityPlayer getPlayer() {
		return null;
	}
	
	public World getWorld (int dimension) {
		return FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(dimension);
	}
	
	public void ragoraParticles(EntityRagora ragora) {}
	
	public EntityPlayer loadPlayer(NBTTagCompound teamnbt, String key, World world) {
		
		GameProfile profile = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerProfileCache().getProfileByUUID(UUID.fromString(teamnbt.getString(key)));
		EntityPlayerMP member = new EntityPlayerMP(FMLCommonHandler.instance().getMinecraftServerInstance(), (WorldServer) world, profile , new PlayerInteractionManager(world));
		FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().setPlayerManager(new WorldServer[] {(WorldServer) world});
		member.deserializeNBT(FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerNBT(member));
		member.mountEntityAndWakeUp();
		
		return member;

	}
}
