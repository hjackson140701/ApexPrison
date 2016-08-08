package eu.apexmc.prison.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import eu.apexmc.prison.main.ApexPrison;

public class HungerEvent implements Listener
{
	public HungerEvent(ApexPrison plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void ApexHubHungerChangeEvent(FoodLevelChangeEvent event)
	{
		/*
		 * 		Cancelling the hunger changing event
		 */
		event.setCancelled(true);
	}
}