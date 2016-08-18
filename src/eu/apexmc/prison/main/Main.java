package eu.apexmc.prison.main;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import eu.apexmc.prison.commands.BlockCommand;
import eu.apexmc.prison.commands.ClearChatCommand;
import eu.apexmc.prison.commands.SmeltCommand;
import eu.apexmc.prison.events.DeathEvent;
import eu.apexmc.prison.events.HungerEvent;
import eu.apexmc.prison.events.JoinEvent;
import eu.apexmc.prison.events.QuitEvent;
import eu.apexmc.prison.events.WeatherEvent;
import eu.apexmc.prison.items.Infusion;
import eu.apexmc.prison.pvp.Soup;
import eu.apexmc.prison.variables.Variables;

public class Main extends JavaPlugin
{
	
	public Permission BlockCommand = new Permission("apexprison.commands.block");
	public Permission ClearChatCommand = new Permission("apexprison.commands.cc");
	public Permission SmeltCommand = new Permission("apexprison.commands.smelt");
	
	public void onEnable()
	{		
		getLogger().info(Variables.pluginName + " v" + Variables.pluginVersion + " has been enabled!");
				
		getCommand("block").setExecutor(new BlockCommand(this));
		getCommand("cc").setExecutor(new ClearChatCommand(this));
		getCommand("smelt").setExecutor(new SmeltCommand(this));
		
		new BlockCommand(this);
		new ClearChatCommand(this);
		new SmeltCommand(this);
		new DeathEvent(this);
		new HungerEvent(this);
		new JoinEvent(this);
		new QuitEvent(this);
		new WeatherEvent(this);
		new Soup(this);
		new Infusion(this);
	}
	public void onDisable()
	{
		getLogger().info(Variables.pluginName + " v" + Variables.pluginVersion + " has been disabled!");
	}
}
