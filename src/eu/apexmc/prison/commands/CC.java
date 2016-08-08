package eu.apexmc.prison.commands;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import eu.apexmc.prison.main.ApexPrison;
import eu.apexmc.prison.variables.Variables;

public class CC implements CommandExecutor, Listener
{
	public CC(ApexPrison plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@SuppressWarnings({ "deprecation" })
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if((cmd.getName().equalsIgnoreCase("cc")))
		{
			/*
			 * 		Variables
			 */
		      Player player = (Player) sender;
			  Location playerLocation = player.getLocation(); 
		      if(!player.hasPermission("apex.admin.cc"))
			{
				player.sendMessage(Variables.ccNoPermsMessage);
				return true;
			}
			if(player.hasPermission("apex.admin.cc"))
			{
				player.playEffect(playerLocation, Effect.MOBSPAWNER_FLAMES, 1);
				player.sendMessage(Variables.ccMessage);
				for (int x = 0; x < 150; x++)
				{
			          Bukkit.broadcastMessage("");
				}
				Bukkit.broadcastMessage(Variables.ccBroadcast + player.getName());
				}
			}
		return true;
	}
}
