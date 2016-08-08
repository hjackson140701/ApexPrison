package eu.apexmc.prison.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import eu.apexmc.prison.main.ApexPrison;

public class WeatherChangeEvent implements Listener
{
	public WeatherChangeEvent(ApexPrison plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void ApexHubWeatherChangeEvent(org.bukkit.event.weather.WeatherChangeEvent event)
	{
		/*
		 * 		Cancelling the weather changing event
		 */
		event.setCancelled(true);
	}
}