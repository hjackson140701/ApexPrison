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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import eu.apexmc.prison.main.ApexPrison;
import eu.apexmc.prison.variables.Variables;

public class Block implements CommandExecutor, Listener
{
	public Block(ApexPrison plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@SuppressWarnings({ "deprecation" })
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if((cmd.getName().equalsIgnoreCase("block")))
		{
			/*
			 * 		Variables
			 */
		      Player player = (Player) sender;
			  Location playerLocation = player.getLocation(); 
		      Inventory playerInventory = player.getInventory();
		      ItemStack DIAMOND = new ItemStack(Material.DIAMOND);
		      ItemStack DIAMOND_9 = new ItemStack(Material.DIAMOND, 9);
		      ItemStack DIAMOND_BLOCK = new ItemStack(Material.DIAMOND_BLOCK);
		      ItemStack IRON = new ItemStack(Material.IRON_INGOT);
		      ItemStack IRON_9 = new ItemStack(Material.IRON_INGOT, 9);
		      ItemStack IRON_BLOCK = new ItemStack(Material.IRON_BLOCK);
		      ItemStack GOLD = new ItemStack(Material.GOLD_INGOT);
		      ItemStack GOLD_9 = new ItemStack(Material.GOLD_INGOT, 9);
		      ItemStack GOLD_BLOCK = new ItemStack(Material.GOLD_BLOCK);
		      ItemStack EMERALD = new ItemStack(Material.EMERALD);
		      ItemStack EMERALD_9 = new ItemStack(Material.EMERALD, 9);
		      ItemStack EMERALD_BLOCK = new ItemStack(Material.EMERALD_BLOCK);
		      ItemStack COAL = new ItemStack(Material.COAL);
		      ItemStack COAL_9 = new ItemStack(Material.COAL, 9);
		      ItemStack COAL_BLOCK = new ItemStack(Material.COAL_BLOCK);
		      ItemStack GLOWSTONE_DUST = new ItemStack(Material.GLOWSTONE_DUST);
		      ItemStack GLOWSTONE_DUST_4 = new ItemStack(Material.GLOWSTONE_DUST, 4);
		      ItemStack GLOWSTONE_BLOCK = new ItemStack(Material.GLOWSTONE);
		      ItemStack REDSTONE = new ItemStack(Material.REDSTONE);
		      ItemStack REDSTONE_9 = new ItemStack(Material.REDSTONE, 9);
		      ItemStack REDSTONE_BLOCK = new ItemStack(Material.REDSTONE_BLOCK);
			if(!player.hasPermission("apex.block"))
			{
				player.sendMessage(Variables.blockNoPermsMessage);
				player.sendMessage(Variables.blockDonatorMessage);
				return true;
			}
			if(player.hasPermission("apex.block"))
			{
				player.playEffect(playerLocation, Effect.MOBSPAWNER_FLAMES, 1);
				player.sendMessage(Variables.blockSuccessMessage);
				
				/*
				 * 		Diamond
				 */
				while(playerInventory.containsAtLeast(DIAMOND, 9))
				{
					playerInventory.removeItem(DIAMOND_9);
					playerInventory.addItem(DIAMOND_BLOCK);
				}
				/*
				 * 		Iron
				 */
				while(playerInventory.containsAtLeast(IRON, 9))
				{
					playerInventory.removeItem(IRON_9);
					playerInventory.addItem(IRON_BLOCK);
				}
				/*
				 * 		Gold
				 */
				while(playerInventory.containsAtLeast(GOLD, 9))
				{
					playerInventory.removeItem(GOLD_9);
					playerInventory.addItem(GOLD_BLOCK);
				}
				/*
				 * 		Emerald
				 */
				while(playerInventory.containsAtLeast(EMERALD, 9))
				{
					playerInventory.removeItem(EMERALD_9);
					playerInventory.addItem(EMERALD_BLOCK);
				}
				/*
				 * 		Coal
				 */
				while(playerInventory.containsAtLeast(COAL, 9))
				{
					playerInventory.removeItem(COAL_9);
					playerInventory.addItem(COAL_BLOCK);
				}
				/*
				 * 		Glowstone
				 */
				while(playerInventory.containsAtLeast(GLOWSTONE_DUST, 4))
				{
					playerInventory.removeItem(GLOWSTONE_DUST_4);
					playerInventory.addItem(GLOWSTONE_BLOCK);
				}
				/*
				 * 		Redstone
				 */
				while(playerInventory.containsAtLeast(REDSTONE, 9))
				{
					playerInventory.removeItem(REDSTONE_9);
					playerInventory.addItem(REDSTONE_BLOCK);
				}
			}
		}
		return true;
	}
}
