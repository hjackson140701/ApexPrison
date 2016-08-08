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
import eu.apexmc.prison.main.ApexPrison;
import eu.apexmc.prison.variables.Variables;

public class JoinEvent implements Listener
{
	public JoinEvent(ApexPrison plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void ApexPrisonJoinEvent(PlayerJoinEvent event)
	{
	/*
	 * 		Variables
	 */
	Player player = event.getPlayer();
	String playerName = event.getPlayer().getName();
	World playerWorld = event.getPlayer().getWorld();
	Location playerLocation = event.getPlayer().getLocation();
	/*
	 * 		Things that happen upon login
	 */
	playerWorld.playEffect(playerLocation, Effect.MOBSPAWNER_FLAMES, 1);
	player.setGameMode(GameMode.SURVIVAL);
	player.sendTitle(Variables.title, null);
	/*
	 * 		Changing the default minecraft join message
	 */
	event.setJoinMessage(Variables.joinMessage + playerName);
	/*
	 * 		Server TPS
	 */
	if(playerName.equalsIgnoreCase("4p3x"))
	{
		player.sendMessage(Variables.tps20);
		player.sendMessage(Variables.tpsPercentage);
	}
	if(playerName.equalsIgnoreCase("HeriPutr"))
	{
		player.sendMessage(Variables.tps20);
		player.sendMessage(Variables.tpsPercentage);
	}
	if(playerName.equalsIgnoreCase("miffster333"))
	{
		player.sendMessage(Variables.tps20);
		player.sendMessage(Variables.tpsPercentage);
		}
	}
}
