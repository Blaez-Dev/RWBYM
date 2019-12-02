package io.github.blaezdev.rwbym.commands;

import com.google.common.collect.Lists;
import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.capabilities.CapabilityHandler;
import io.github.blaezdev.rwbym.capabilities.ISemblance;
import net.minecraft.command.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import scala.actors.threadpool.Arrays;

import java.util.ArrayList;
import java.util.List;

public class CommandChangeSemblance extends CommandBase{
	
	private final List<String> aliases = Lists.newArrayList(RWBYModels.MODID, "setsemblance", "semblance");

	@Override
	public String getName() {
		return "setsemblance";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "command.semblance.usage";
	}
	
	@Override
	public List<String> getAliases() {
		return aliases;
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}
	
	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos targetPos) {
		if (args.length == 1 && args[0].isEmpty()) {
			return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
		}
		else if (args.length == 1) {
			try {
				return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames(), getSemblanceNames(getCommandSenderAsPlayer(sender)));
			} catch (PlayerNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (args.length == 2) {
			try {
				return getListOfStringsMatchingLastWord(args, getSemblanceNames(getCommandSenderAsPlayer(sender)));
			} catch (PlayerNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			return super.getTabCompletions(server, sender, args, targetPos);
		}
		return null;
	}
	
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer target = null;
		Capability semblance = null;
		int level = 0;
		
		if (args.length < 1) {
		}
		else if (args.length == 1 && sender instanceof EntityPlayer) {
			target = getCommandSenderAsPlayer(sender);
			semblance = CapabilityHandler.getCapabilityByName(target, args[0]).getCapability();
			level = 1;
		}
		else if (args.length == 2) {
			try {
				level = Integer.parseInt(args[1]);
				if (sender instanceof EntityPlayer) {
					target = getCommandSenderAsPlayer(sender);
				}
				semblance = CapabilityHandler.getCapabilityByName(target, args[0]).getCapability();
			}
			catch (NumberFormatException e) {
				target = getPlayer(server, sender, args[0]);
				semblance = CapabilityHandler.getCapabilityByName(target, args[1]).getCapability();
				level = 1;
			}
		}
		else if (args.length == 3) {
			target = getPlayer(server, sender, args[0]);
			semblance = CapabilityHandler.getCapabilityByName(target, args[1]).getCapability();
			try {
				level = Integer.parseInt(args[2]);
			}
			catch (NumberFormatException e) {
				
			}
		}
		if (target == null || semblance == null || level == 0) {
			throw new WrongUsageException("Incorrect Arguments");
		}
		else {
			CapabilityHandler.setSemblance(target, semblance, level);
		}
	}
	
	private String[] getSemblanceNames(EntityPlayer player) {
		
		List<String> names = new ArrayList<String>();
		for (ISemblance semblance : CapabilityHandler.getAllSemblances(player)) {
			names.add(semblance.toString());
		}
		
		return names.toArray(new String[0]);
	}
	
	private static List<String> getListOfStringsMatchingLastWord(String args[], String[] ... strings) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < strings.length; i++) {
			list.addAll(Arrays.asList(strings[i]));
		}
		
		RWBYModels.LOGGER.info(list);
		
		return getListOfStringsMatchingLastWord(args, list);
	}
}
