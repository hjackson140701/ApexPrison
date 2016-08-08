package eu.apexmc.prison.variables;

import eu.apexmc.prison.utils.TPS;
import net.md_5.bungee.api.ChatColor;

public class Variables
{
	/*
	 * 		Plugin name and version
	 */
	public static String pluginName = "ApexPrison";
	public static double pluginVersion = 1.0;
	/*
	 * 		JoinEvent titles
	 */
	public static String title = (ChatColor.RED + "Welcome to Apex Prison!");
	/*
	 * 		Server join message
	 */
	public static String joinMessage = (ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY);
	/*
	 * 		Server quit message
	 */
	public static String quitMessage = (ChatColor.DARK_GRAY + "[" + ChatColor.RED + "-" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY);
	/*
	 * 		TPS return message
	 */
	  static double tps = TPS.getTPS();
	  static double lag = Math.round((1.0D - tps / 20.0D) * 100.0D);
	
	public static String tps20 = (ChatColor.RED + "Lag" + ChatColor.DARK_RED + " > " + ChatColor.RED + "The server is currently running at " + ChatColor.UNDERLINE + TPS.getTPS() + ChatColor.RED + " TPS");
	public static String tpsPercentage = (ChatColor.RED + "Lag" + ChatColor.DARK_RED + " > " + ChatColor.RED + "The server is experiencing " + ChatColor.UNDERLINE + lag + "% " + ChatColor.RED + "lag.");
	/*
	 * 		Apex command
	 */
	public static String apexNoPermsMessage = (ChatColor.RED + "Insufficient permission(s) " + ChatColor.GRAY + ChatColor.ITALIC + "(apex.apex)");
	public static String apexNoArgsMessage = (ChatColor.RED + pluginName + " v" + pluginVersion + " by HeriPutr");
	public static String apexVersionMessage = (ChatColor.RED + pluginName + ChatColor.DARK_RED + " > " + ChatColor.RED + "Current version is v" + pluginVersion + ".");
	public static String apexInvalidSubcommand = (ChatColor.RED + "Invalid subcommand.");
	/*
	 * 		Block command
	 */
	public static String blockNoPermsMessage = (ChatColor.RED + "Insufficient permission(s) " + ChatColor.GRAY + ChatColor.ITALIC + "(apex.block)");
	public static String blockDonatorMessage = (ChatColor.RED + "All of our donators have access to this command, donate at buy.apexmc.eu.");
	public static String blockSuccessMessage = (ChatColor.GREEN + "All of your ingots have been converted into blocks.");
	/*
	 * 		CC command
	 */
	public static String ccNoPermsMessage = (ChatColor.RED + "Insufficient permission(s) " + ChatColor.GRAY + ChatColor.ITALIC + "(apex.admin.cc)");
	public static String ccMessage = (ChatColor.DARK_AQUA + "Chat has been cleared.");
	public static String ccBroadcast = (ChatColor.RED + "Chat" + ChatColor.DARK_RED + " > " + ChatColor.RED + "Chat has been cleared by " + ChatColor.DARK_RED + ChatColor.UNDERLINE + ChatColor.ITALIC);
}
