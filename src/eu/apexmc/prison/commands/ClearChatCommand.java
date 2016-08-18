package eu.apexmc.prison.commands;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import eu.apexmc.prison.main.Main;
import net.md_5.bungee.api.ChatColor;

public class ClearChatCommand implements CommandExecutor, Listener
{
	public ClearChatCommand(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if((cmd.getName().equalsIgnoreCase("cc")))
		{
			Player player = (Player) sender;
			Location playerLocation = player.getLocation();
			if(!player.hasPermission("apexprison.commands.cc"))
			{
				   player.sendMessage(ChatColor.RED + "Insufficient permission(s)" + ChatColor.GRAY + ChatColor.ITALIC + " (apexprison.commands.cc)");
				   return true;
			}
			if(player.hasPermission("apexprison.commands.cc"))
			{
				player.playEffect(playerLocation, Effect.MOBSPAWNER_FLAMES, 1);
				player.sendMessage(ChatColor.DARK_AQUA + "Chat has been cleared.");
				
				for (int x = 0; x < 150; x++)
				{
					Bukkit.broadcastMessage("");
				}
				Bukkit.broadcastMessage(ChatColor.RED + "Chat" + ChatColor.DARK_RED + " > " + ChatColor.RED + "Chat has been cleared by " + ChatColor.DARK_RED + player.getName());
			}
		}
		return true;
	}
}
