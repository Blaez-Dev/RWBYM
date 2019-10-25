package io.github.blaezdev.rwbym.proxy;

import io.github.blaezdev.rwbym.Init.Oregen;
import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.entity.EntityRagora;
import com.mojang.authlib.GameProfile;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.management.PlayerInteractionManager;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.UUID;

/**
 * Part of rwbym
 *
 * @author Bluexin
 */
public abstract class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
    }

    public void registerRenderers(RWBYModels ins) {
    }

    public void init() {
        GameRegistry.registerWorldGenerator(new Oregen(), 0 );
    }

    public void generateRosepetals(EntityPlayer playerIn, boolean summer) {}

	public EntityPlayer getPlayer() {
		return null;
	}
	
	public World getWorld (int dimension) {
		return FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(dimension);
	}
	
	public void ragoraParticles(EntityRagora ragora) {}
	
	public EntityPlayer loadPlayer(NBTTagCompound teamnbt, String key, World world) {
		
		GameProfile profile = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerProfileCache().getProfileByUUID(UUID.fromString(teamnbt.getString(key)));
		EntityPlayerMP member = new EntityPlayerMP(FMLCommonHandler.instance().getMinecraftServerInstance(), (WorldServer) world, profile, new PlayerInteractionManager(world));
		FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().setPlayerManager(new WorldServer[] {(WorldServer) world});
		member.deserializeNBT(FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerNBT(member));
		member.mountEntityAndWakeUp();
		
		return member;

	}

	public abstract EntityPlayer getClientPlayer();

	public abstract void showGuiScreen(Object clientGuiElement);

	private static void registerBlocksmodel(FMLPreInitializationEvent event, Block...blocks){}

	public static void registerall(FMLPreInitializationEvent event){

	}


}
