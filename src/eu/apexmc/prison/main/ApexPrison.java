package eu.apexmc.prison.main;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import eu.apexmc.prison.commands.Apex;
import eu.apexmc.prison.commands.Block;
import eu.apexmc.prison.commands.CC;
import eu.apexmc.prison.events.HungerEvent;
import eu.apexmc.prison.events.JoinEvent;
import eu.apexmc.prison.events.QuitEvent;
import eu.apexmc.prison.events.WeatherChangeEvent;
import eu.apexmc.prison.pvp.Soup;
import eu.apexmc.prison.utils.TPS;
import eu.apexmc.prison.variables.Variables;

public class ApexPrison extends JavaPlugin
{
	
	public Permission apexCommandPermission = new Permission("apex.apex");
	public Permission blockCommandPermission = new Permission("apex.block");
	public Permission ccCommandPermission = new Permission("apex.admin.cc");
	
	public void onEnable()
	{
		getLogger().info(Variables.pluginName + " v" + Variables.pluginVersion + " has been enabled!");
		
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new TPS(), 100L, 1L);
		
		getCommand("apex").setExecutor(new Apex(this));
		getCommand("block").setExecutor(new Block(this));
		getCommand("cc").setExecutor(new CC(this));
		
		new Apex(this);
		new Block(this);
		new CC(this);
		
		new HungerEvent(this);
		new JoinEvent(this);
		new QuitEvent(this);
		new WeatherChangeEvent(this);
		
		new Soup(this);
	}
	public void onDisable()
	{
		getLogger().info(Variables.pluginName + " v" + Variables.pluginVersion + " has been disabled!");
	}
}
