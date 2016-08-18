package eu.apexmc.prison.pvp;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import eu.apexmc.prison.main.Main;

public class Soup implements Listener
{
	public Soup(Main plugin)
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void PrisonSoup(PlayerInteractEvent event)
	{
	    Player player = event.getPlayer();
	    Damageable dplayer = (Damageable)player;
	    double health = dplayer.getHealth();
	        if(health == dplayer.getMaxHealth()){
	        }else{
	                Double soup = +7.0;
	                if((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() ==Action.RIGHT_CLICK_BLOCK) && player.getItemInHand().getType() == Material.MUSHROOM_SOUP){
	                        player.setHealth(dplayer.getHealth() + soup > dplayer.getMaxHealth() ? dplayer.getMaxHealth() : dplayer.getHealth() + soup);
	                        event.getPlayer().getItemInHand().setType(Material.BOWL);
	              player.playSound(player.getLocation(), Sound.DRINK, 1, 1);
	                }
	        }
	}
}