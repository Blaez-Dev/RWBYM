package be.bluexin.rwbym.utility.network;

import be.bluexin.rwbym.capabilities.team.ITeam;
import be.bluexin.rwbym.capabilities.team.TeamProvider;
import be.bluexin.rwbym.gui.scroll.GuiScreenScrollRequests;
import be.bluexin.rwbym.gui.scroll.GuiScreenScrollTeam;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageSendTeams extends MessageBase<MessageSendTeams> {
	
	private NBTTagCompound teams;
	
	public MessageSendTeams() {}
	
	public MessageSendTeams(ITeam team) {
		this.teams = team.serialize();
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.teams = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, this.teams);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void handleClientSide(MessageSendTeams message, EntityPlayer player) {
		World world = Minecraft.getMinecraft().world;
		if (world.hasCapability(TeamProvider.TEAM_CAP, null)) {
			world.getCapability(TeamProvider.TEAM_CAP, null).deserialize(message.teams);
		}
		GuiScreen gui = Minecraft.getMinecraft().currentScreen;
		if (gui instanceof GuiScreenScrollTeam) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiScreenScrollTeam(player));
		}
		else if (gui instanceof GuiScreenScrollRequests) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiScreenScrollRequests(player));
		}
	}

	@Override
	public void handleServerSide(MessageSendTeams message, EntityPlayer player) {

	}

}
