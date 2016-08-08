package eu.apexmc.prison.pvp;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import eu.apexmc.prison.main.ApexPrison;

public class Soup implements Listener
{
	public Soup(ApexPrison plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void soupEatEvent(PlayerInteractEvent event)
	{
		/*
		 * 		Variables
		 */
		Player player = event.getPlayer();
		if(player.getHealth() == 20)
		{
			
		}
		else
		{
			int soup = +7;
			if((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && player.getItemInHand().getType() == Material.MUSHROOM_SOUP)
			{
				player.setHealth(player.getHealth() + soup > player.getMaxHealth() ? player.getMaxHealth() : player.getHealth() + soup);
				event.getPlayer().getItemInHand().setType(Material.BOWL);
			}
		}
	}
}
