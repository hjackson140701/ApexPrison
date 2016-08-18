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

public class BlockCommand implements Listener, CommandExecutor
{
	public BlockCommand(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if((cmd.getName().equalsIgnoreCase("block")))
		{
			Player player = (Player) sender;
			Location playerLocation = player.getLocation();
			PlayerInventory playerInventory = player.getInventory();
			
			if(!player.hasPermission("apexprison.commands.block"))
			{
				player.sendMessage(ChatColor.RED + "Insufficient permission(s)" + ChatColor.GRAY + ChatColor.ITALIC + " (apexprison.commands.block)");
				return true;
			}
			if(player.hasPermission("apexprison.commands.block"))
			{
				player.playEffect(playerLocation, Effect.MOBSPAWNER_FLAMES, 1);
				player.sendMessage(ChatColor.GREEN + "Block" + ChatColor.DARK_GREEN + " > " + ChatColor.GREEN + "All of your ingots have been converted into blocks!");
				
				ItemStack diamond = new ItemStack(Material.DIAMOND);
				ItemStack diamond9 = new ItemStack(Material.DIAMOND, 9);
				ItemStack diamondblock = new ItemStack(Material.DIAMOND_BLOCK);
					while(playerInventory.containsAtLeast(diamond, 1))
							{
						playerInventory.removeItem(diamond9);
						playerInventory.addItem(diamondblock);
							}
				ItemStack emerald = new ItemStack(Material.EMERALD);
				ItemStack emerald9 = new ItemStack(Material.EMERALD, 9);
				ItemStack emeraldblock = new ItemStack(Material.EMERALD_BLOCK);
					while(playerInventory.containsAtLeast(emerald, 1))
							{
						playerInventory.removeItem(emerald9);
						playerInventory.addItem(emeraldblock);
							}
				ItemStack iron = new ItemStack(Material.IRON_INGOT);
				ItemStack iron9 = new ItemStack(Material.IRON_INGOT, 9);
				ItemStack ironblock = new ItemStack(Material.IRON_BLOCK);
					while(playerInventory.containsAtLeast(iron, 1))
					{
						playerInventory.removeItem(iron9);
						playerInventory.addItem(ironblock);
					}
				ItemStack gold = new ItemStack(Material.GOLD_INGOT);
				ItemStack gold9 = new ItemStack(Material.GOLD_INGOT, 9);
				ItemStack goldblock = new ItemStack(Material.GOLD_BLOCK);
					while(playerInventory.containsAtLeast(gold, 1))
					{
						playerInventory.removeItem(gold9);
						playerInventory.addItem(goldblock);
					}
				ItemStack coal = new ItemStack(Material.COAL);
				ItemStack coal9 = new ItemStack(Material.COAL, 9);
				ItemStack coalblock = new ItemStack(Material.COAL_BLOCK);
					while(playerInventory.containsAtLeast(coal, 1))
					{
						playerInventory.removeItem(coal9);
						playerInventory.addItem(coalblock);
					}
				ItemStack redstone = new ItemStack(Material.REDSTONE);
				ItemStack redstone9 = new ItemStack(Material.REDSTONE, 9);
				ItemStack redstoneblock = new ItemStack(Material.REDSTONE_BLOCK);
					while(playerInventory.containsAtLeast(redstone, 1))
					{
						playerInventory.removeItem(redstone9);
						playerInventory.addItem(redstoneblock);
					}
				ItemStack glowstone = new ItemStack(Material.GLOWSTONE_DUST);
				ItemStack glowstone4 = new ItemStack(Material.GLOWSTONE_DUST, 4);
				ItemStack glowstoneblock = new ItemStack(Material.GLOWSTONE);
					while(playerInventory.containsAtLeast(glowstone, 1))
					{
						playerInventory.removeItem(glowstone4);
						playerInventory.addItem(glowstoneblock);
					}
			}
		}
		return true;
	}
}
