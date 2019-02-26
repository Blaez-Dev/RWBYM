package be.bluexin.rwbym.proxy;

import be.bluexin.rwbym.Init.Oregen;
import be.bluexin.rwbym.RWBYModels;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

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
}
