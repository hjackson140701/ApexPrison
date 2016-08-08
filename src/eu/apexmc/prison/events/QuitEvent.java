package eu.apexmc.prison.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import eu.apexmc.prison.main.ApexPrison;
import eu.apexmc.prison.variables.Variables;

public class QuitEvent implements Listener
{
	public QuitEvent(ApexPrison plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void ApexHubQuitEvent(PlayerQuitEvent event)
	{
		/*
		 * 		Variables
		 */
		String playerName = event.getPlayer().getName();
		/*
		 * 		Changing the default minecraft join message
		 */
		event.setQuitMessage(Variables.quitMessage + playerName);
	}
}
