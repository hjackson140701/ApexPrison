package eu.apexmc.prison.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import eu.apexmc.prison.main.Main;

public class DeathEvent implements Listener
{
	public DeathEvent(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void PrisonDeathEvent(PlayerDeathEvent event)
	{
		World playerWorld = event.getEntity().getPlayer().getWorld();
		Location playerDeathLocation = event.getEntity().getPlayer().getLocation();
		playerWorld.strikeLightningEffect(playerDeathLocation);
	}
}