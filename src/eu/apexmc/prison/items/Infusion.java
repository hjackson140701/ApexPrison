package eu.apexmc.prison.items;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import eu.apexmc.prison.main.Main;
import net.md_5.bungee.api.ChatColor;

public class Infusion implements Listener
{
	public Infusion(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void PrisonInfusion(BlockBreakEvent event)
	{
		Player player = event.getPlayer();
		Location playerLocation = event.getPlayer().getLocation();
		
		if(!event.isCancelled())
		{
			if((player.getItemInHand().getType() == Material.DIAMOND_PICKAXE) &&
				(player.getItemInHand().hasItemMeta()) &&
				(player.getItemInHand().getItemMeta().getLore().contains(ChatColor.WHITE + "Infusion Pickaxe")))
			{
				Location loc = event.getBlock().getLocation().add(-1.0D, -1.0D, -1.0D);
				for(int x = 0; x < 3; x++)
				{
					for(int y = 0; y < 3; y++)
					{
						for(int z = 0; z < 3; z++)
						{
							Location blockLoc = new Location(loc.getWorld(),loc.getX() + x, loc.getY() + y, loc.getZ() + z);
							Block currentBlock = blockLoc.getBlock();
							if((currentBlock.getType() == Material.MOB_SPAWNER) ||
									(currentBlock.getType() == Material.GLOWSTONE) ||
									(currentBlock.getType() == Material.BEDROCK))
							{
								return;
							}
							for(ItemStack drop : currentBlock.getDrops())
							{
								blockLoc.getWorld().dropItem(blockLoc, drop);
							}
							currentBlock.setType(Material.AIR);
							player.playEffect(playerLocation, Effect.PORTAL, 1);
						}
					}
				}
			}
		}
	}
}