package com.mariogrip.NoPlugin;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import com.mariogrip.NoPlugin.addon.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	 

	public void onEnable()
	  {
		 Bukkit.getServer().getConsoleSender().sendMessage("[NoPlugin] Loading Class!");
		Bukkit.getServer().getPluginManager().registerEvents(new EventPlayer(this), this);
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
			getLogger().info("Metrics Failed to Submit.... :(");
		}
	    Bukkit.getServer().getConsoleSender().sendMessage("[NoPlugin] Loading Config!");
	    loadConfiguration();
	    Bukkit.getServer().getConsoleSender().sendMessage("[NoPlugin] Loaded!");
	  }
	 
	  public void loadConfiguration() {
		    getConfig().options().copyDefaults(true);

		    saveConfig();
		   
		  }
	  
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
			if(cmd.getName().equalsIgnoreCase("noplugin") || cmd.getName().equalsIgnoreCase("nop")){
				
			    if (args.length == 1)
			    {
				if (args[0].equalsIgnoreCase("ping")){
					sender.sendMessage(ChatColor.BLUE + "Pong :P");
					return true; 
				}
				else if (args[0].equalsIgnoreCase("version")){
				    sender.sendMessage(ChatColor.BLUE + "[NoPlugin] version: 2.1 By Mariogrip");
			
					return true; 
				}
				else if (args[0].equalsIgnoreCase("reload")){
					if (sender.hasPermission("nop.reload")) {
				    reloadConfig();
					sender.sendMessage(ChatColor.BLUE + "[NoPlugin] Reload Complete");
					return true; 
				}else{
					sender.sendMessage(ChatColor.AQUA + "You don't have permission to do that");
					return true;
				}
					
				}
				else if (args[0].equalsIgnoreCase("info")){
				    reloadConfig();
				    sender.sendMessage(ChatColor.BLUE + "[NoPlugin] By mariogrip, My plugins http://dev.bukkit.org/profiles/mariogrip");
			
					return true; 
				}
			    }
				else{
					sender.sendMessage(ChatColor.AQUA + "[Noplugin] Commands:");
					sender.sendMessage(ChatColor.BLUE + "/noplugin version");
					sender.sendMessage(ChatColor.BLUE + "/noplugin info");
					sender.sendMessage(ChatColor.BLUE + "/noplugin reload");
				    return true; 
			} 
			}
			return false; 
		}
	}