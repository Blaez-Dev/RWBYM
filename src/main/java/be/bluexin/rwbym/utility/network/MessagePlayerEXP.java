package be.bluexin.rwbym.utility.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessagePlayerEXP extends MessageBase<MessagePlayerEXP> {
	
	private int exp;
	
	public MessagePlayerEXP() {}
	
	public MessagePlayerEXP(int exp) {
		this.exp = exp;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.exp = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.exp);
	}

	@Override
	public void handleClientSide(MessagePlayerEXP message, EntityPlayer player) {
		
	}

	@Override
	public void handleServerSide(MessagePlayerEXP message, EntityPlayer player) {
		int xpbaramt = (int) (player.experience * player.xpBarCap() + 0.5f);
		int exp = message.exp;
		while (-exp > xpbaramt) {
			player.addExperienceLevel(-1);
			player.experience = 1;
			player.experienceTotal -= xpbaramt;
			exp += xpbaramt;
			xpbaramt = player.xpBarCap();
		}
		if (exp > 0) {
			player.addExperience(exp);
		}
		else {
			player.experience += (float)exp / (float)player.xpBarCap();
			player.experienceTotal += exp;
		}
	}

}
