package eu.apexmc.prison.events;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import eu.apexmc.prison.main.Main;
import net.md_5.bungee.api.ChatColor;

public class JoinEvent implements Listener
{
	public JoinEvent(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void PrisonJoinEvent(PlayerJoinEvent event)
	{
			Player player = event.getPlayer();
			String playerName = event.getPlayer().getName();
			World playerWorld = event.getPlayer().getWorld();
			Location playerLocation = event.getPlayer().getLocation();
			int playersOnline = Bukkit.getServer().getOnlinePlayers().size();
			
			playerWorld.playEffect(playerLocation, Effect.MOBSPAWNER_FLAMES, 1);
			player.setGameMode(GameMode.SURVIVAL);
			player.sendTitle(ChatColor.RED + "Welcome to Apex Prison!", ChatColor.RED + "There are currently " + ChatColor.DARK_RED + playersOnline + ChatColor.RED + " players online!");
			
			event.setJoinMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + playerName);
	}
}
