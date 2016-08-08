package eu.apexmc.prison.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import eu.apexmc.prison.main.ApexPrison;
import eu.apexmc.prison.variables.Variables;

public class Apex implements CommandExecutor, Listener
{
	public Apex(ApexPrison plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if((cmd.getName().equalsIgnoreCase("apex")))
		{
			Player player = (Player) sender;
			if(!player.hasPermission("apex.apex"))
			{
				player.sendMessage(Variables.apexNoPermsMessage);
				return true;
			}
			if(player.hasPermission("apex.apex"))
			{
				if(args.length == 0)
				{
					player.sendMessage(Variables.apexNoArgsMessage);
					return true;
				}
				else if(args[0].equalsIgnoreCase("version"))
				{
					player.sendMessage(Variables.apexVersionMessage);
					return true;
				}
				else
				{
					player.sendMessage(Variables.apexInvalidSubcommand);
					return true;
				}
			}
		}
		return false;
	}
}
