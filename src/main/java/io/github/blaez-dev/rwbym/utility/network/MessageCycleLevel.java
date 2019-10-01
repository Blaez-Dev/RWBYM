package io.github.blaez-dev.rwbym.utility.network;

import io.github.blaez-dev.rwbym.capabilities.CapabilityHandler;
import io.github.blaez-dev.rwbym.capabilities.ISemblance;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

public class MessageCycleLevel extends MessageBase<MessageCycleLevel> {
	
	@Override
	public void fromBytes(ByteBuf buf) {

	}

	@Override
	public void toBytes(ByteBuf buf) {

	}

	@Override
	public void handleClientSide(MessageCycleLevel message, EntityPlayer player) {

	}

	@Override
	public void handleServerSide(MessageCycleLevel message, EntityPlayer player) {
		ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);
		
		int currentSelectedLevel = semblance.getSelectedLevel();
		
		if (currentSelectedLevel != -1) {
			int level = semblance.getLevel();
			
			if (currentSelectedLevel == level) {
				semblance.setSelectedLevel(1);
			}
			else {
				semblance.setSelectedLevel(currentSelectedLevel + 1);
			}
			
			player.sendMessage(new TextComponentString("Level Set to: " + semblance.getSelectedLevel()));
		}
	}
}
