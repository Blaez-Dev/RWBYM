package be.bluexin.rwbym.commands;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.plexus.util.cli.CommandLineException;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.capabilities.Aura.AuraProvider;
import be.bluexin.rwbym.capabilities.Aura.IAura;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.EntityNotFoundException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.command.SyntaxErrorException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import scala.actors.threadpool.Arrays;

public class CommandAura extends CommandBase {

	@Override
	public String getName() {
		return "aura";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "command.aura.usage";
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}
	
	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
		if (args.length == 1) {
			if (args[0].isEmpty()) {
				return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
			}
			else {
				return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames(), new String[] {"Max", "Set", "Add", "Remove"});
			}
		}
		else if (args.length == 2) {
			try {
				getEntity(server, sender, args[0]);
				
				return getListOfStringsMatchingLastWord(args, "Max", "Set", "Add", "Remove");
			}
			catch (CommandException e) {
				if (args[0].toLowerCase().equals("max")) {
					return getListOfStringsMatchingLastWord(args, "Set", "Add", "Remove");
				}
			}
		}
		else if (args.length == 3) {
			if (args[1].toLowerCase().equals("max")) {
				return getListOfStringsMatchingLastWord(args, "Set", "Add", "Remove");
			}
		}
		return super.getTabCompletions(server, sender, args, targetPos);
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length == 0) {
			IAura aura = sender.getCommandSenderEntity().getCapability(AuraProvider.AURA_CAP, null);
			if (aura == null) {
				throw new CommandException("command.aura.noaura", sender.getName());
			}
			else {
				notifyCommandListener(sender, this, "command.aura.display", aura.getAmount(), aura.getMaxAura());
			}
		}
		else if (args.length == 1) {
			Entity entity = this.getEntity(server, sender, args[0]);
			IAura aura = entity.getCapability(AuraProvider.AURA_CAP, null);
			if (aura == null) {
				throw new CommandException("command.aura.noaura", entity.getName());
			}
			else {
				notifyCommandListener(sender, this, "command.aura.display.entity", entity.getName(), aura.getAmount(), aura.getMaxAura());
			}
		}
		else if (args.length == 2) {
			IAura aura = sender.getCommandSenderEntity().getCapability(AuraProvider.AURA_CAP, null);
			if (aura == null) {
				throw new CommandException("command.aura.noaura", sender.getName());
			}
			else {
				String usage = args[0];
				float amount;
				try {
					amount = Float.parseFloat(args[1]);
				}
				catch (Exception e1) {
					try {
						if (args[1].endsWith("%")) {
							float percent = Float.parseFloat(args[1].substring(0, args[1].length() - 1));
							amount = aura.getMaxAura() * percent / 100;
						}
						else if (args[1].toLowerCase().equals("max")) {
							amount = aura.getMaxAura();
						}
						else {
							throw new NumberInvalidException("commands.generic.num.invalid", args[1]);
						}
					}
					catch (Exception e2) {
						throw new NumberInvalidException("commands.generic.num.invalid", args[1]);
					}
				}
				if (usage.toLowerCase().equals("set")) {
					aura.setAmount(amount);
					notifyCommandListener(sender, this, "command.aura.set", sender.getName(), amount);
				}
				else if (usage.toLowerCase().equals("add")) {
					aura.addAmount(amount);
					notifyCommandListener(sender, this, "command.aura.add", amount, sender.getName(), aura.getAmount());
				}
				else if (usage.toLowerCase().equals("remove")) {
					aura.addAmount(-amount);
					notifyCommandListener(sender, this, "command.aura.remove", amount, sender.getName(), aura.getAmount());
				}
				else {
					throw new CommandException("command.aura.usage", new Object[0]);
				}
			}
		}
		else if (args.length == 3) {
			try {
				Entity entity = getEntity(server, sender, args[0]);
				IAura aura = entity.getCapability(AuraProvider.AURA_CAP, null);
				if (aura == null) {
					throw new CommandException("command.aura.noaura", entity.getName());
				}
				else {
					String usage = args[1];
					float amount;
					try {
						amount = Float.parseFloat(args[2]);
					}
					catch (Exception e1) {
						try {
							if (args[2].endsWith("%")) {
								float percent = Float.parseFloat(args[2].substring(0, args[2].length() - 1));
								amount = aura.getMaxAura() * percent / 100;
							}
							else if (args[2].toLowerCase().equals("max")) {
								amount = aura.getMaxAura();
							}
							else {
								throw new NumberInvalidException("commands.generic.num.invalid", args[2]);
							}
						}
						catch (Exception e2) {
							throw new NumberInvalidException("commands.generic.num.invalid", args[2]);
						}
					}
					if (usage.toLowerCase().equals("set")) {
						aura.setAmount(amount);
						notifyCommandListener(sender, this, "command.aura.set", entity.getName(), amount);
					}
					else if (usage.toLowerCase().equals("add")) {
						aura.addAmount(amount);
						notifyCommandListener(sender, this, "command.aura.add", amount, entity.getName(), aura.getAmount());
					}
					else if (usage.toLowerCase().equals("remove")) {
						aura.addAmount(-amount);
						notifyCommandListener(sender, this, "command.aura.remove", amount, entity.getName(), aura.getAmount());
					}
					else {
						throw new WrongUsageException(this.getUsage(sender));
					}
				}
			}
			catch (EntityNotFoundException e) {
				if (args[0].toLowerCase().equals("max")) {
					IAura aura = sender.getCommandSenderEntity().getCapability(AuraProvider.AURA_CAP, null);
					if (aura == null) {
						throw new CommandException("command.aura.noaura", sender.getName());
					}
					String usage = args[1];
					int amount;
					try {
						amount = Integer.parseInt(args[2]);
					}
					catch (Exception e1) {
						throw new NumberInvalidException("commands.generic.num.invalid", args[2]);
					}
					if (usage.toLowerCase().equals("set")) {
						aura.setMaxAura(amount);
						notifyCommandListener(sender, this, "command.aura.max.set", sender.getName(), amount);
					}
					else if (usage.toLowerCase().equals("add")) {
						aura.addToMax(amount);
						notifyCommandListener(sender, this, "command.aura.max.add", amount, sender.getName(), aura.getMaxAura());
					}
					else if (usage.toLowerCase().equals("remove")) {
						aura.addToMax(-amount);
						notifyCommandListener(sender, this, "command.aura.max.remove", amount, sender.getName(), aura.getMaxAura());
					}
					else {
						throw new WrongUsageException(this.getUsage(sender));
					}
				}
				else throw e;
			}
		}
		else if (args.length == 4) {
			Entity entity = getEntity(server, sender, args[0]);
			IAura aura = entity.getCapability(AuraProvider.AURA_CAP, null);
			if (aura == null) {
				throw new CommandException("command.aura.noaura", entity.getName());
			}
			if (!args[1].toLowerCase().equals("max")) {
				throw new WrongUsageException(this.getUsage(sender));
			}
			String usage = args[2];
			int amount;
			try {
				amount = Integer.parseInt(args[3]);
			}
			catch (Exception e) {
				throw new NumberInvalidException("commands.generic.num.invalid", args[3]);
			}
			if (usage.toLowerCase().equals("set")) {
				aura.setMaxAura(amount);
				notifyCommandListener(sender, this, "command.aura.max.set", entity.getName(), amount);
			}
			else if (usage.toLowerCase().equals("add")) {
				aura.addToMax(amount);
				notifyCommandListener(sender, this, "command.aura.max.add", amount, entity.getName(), aura.getMaxAura());
			}
			else if (usage.toLowerCase().equals("remove")) {
				aura.addToMax(-amount);
				notifyCommandListener(sender, this, "command.aura.max.remove", amount, entity.getName(), aura.getMaxAura());
			}
			else {
				throw new WrongUsageException(this.getUsage(sender));
			}
		}
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
