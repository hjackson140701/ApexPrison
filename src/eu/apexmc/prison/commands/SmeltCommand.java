package eu.apexmc.prison.commands;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import eu.apexmc.prison.main.Main;
import net.md_5.bungee.api.ChatColor;

public class SmeltCommand implements Listener, CommandExecutor
{
	public SmeltCommand(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if((cmd.getName().equalsIgnoreCase("smelt")))
		{
			Player player = (Player) sender;
			Location playerLocation = player.getLocation();
			PlayerInventory playerInventory = player.getInventory();
			
			if(!player.hasPermission("apexprison.commands.smelt"))
			{
				player.sendMessage(ChatColor.RED + "Insufficient permission(s)" + ChatColor.GRAY + ChatColor.ITALIC + " (apexprison.commands.smelt)");
				return true;
			}
			if(player.hasPermission("apexprison.commands.smelt"))
			{
				player.playEffect(playerLocation, Effect.MOBSPAWNER_FLAMES, 1);
				player.sendMessage(ChatColor.GREEN + "Smelt" + ChatColor.DARK_GREEN + " > " + ChatColor.GREEN + "All of your ores have been smelted into ingots!");
				
				ItemStack ironore = new ItemStack(Material.IRON_ORE);
				ItemStack ironingot = new ItemStack(Material.IRON_INGOT);
					while(playerInventory.containsAtLeast(ironore, 1))
					{
						playerInventory.removeItem(ironore);
						playerInventory.addItem(ironingot);
					}
				ItemStack goldore = new ItemStack(Material.GOLD_ORE);
				ItemStack goldingot = new ItemStack(Material.GOLD_INGOT);
					while(playerInventory.containsAtLeast(goldore, 1))
					{
						playerInventory.removeItem(goldore);
						playerInventory.addItem(goldingot);
					}
			}
		}
		return true;
	}
}
