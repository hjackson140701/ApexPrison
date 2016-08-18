package eu.apexmc.prison.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import eu.apexmc.prison.main.Main;
import net.md_5.bungee.api.ChatColor;

public class QuitEvent implements Listener
{
	public QuitEvent(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void PrisonQuitEvent(PlayerQuitEvent event)
	{
		String playerName = event.getPlayer().getName();
		event.setQuitMessage(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "-" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + playerName);
	}
}
