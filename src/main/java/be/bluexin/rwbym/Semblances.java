package be.bluexin.rwbym;

import be.bluexin.rwbym.client.particle.RosePetal;
import be.bluexin.rwbym.utility.network.MessageActivateSemblance;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;

public class Semblances {

	public static void Ruby(EntityPlayer player, int petals) {
		if (player.onGround){
			player.getEntityData().setBoolean("IsHidden", true);
			Vec3d look = player.getLookVec();
			player.motionX = look.x;
			player.motionZ = look.z;
			player.motionY = look.y * 2;
			player.lastTickPosZ = -look.x;
			player.lastTickPosX = -look.z;
			player.fallDistance = 0;
			for (int i = 0; i < petals; i++) {
				//RosePetal rose = new RosePetal(player.world, player.posX + look.x*i, player.posY + look.y*i, player.posZ + look.z*i, 0, 0, 0);
			}
		}
		else {
			player.getEntityData().setBoolean("IsHidden", false);
		}
	}
}
