package com.mariogrip.NoPlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import com.mariogrip.NoPlugin.Main;

public class EventPlayer implements Listener {
	
		Main plugin;
		 
		public EventPlayer(Main instance) {
		plugin = instance;
		}	

	  
	
  @EventHandler
  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
  {
    Player p = event.getPlayer();

    if (plugin.getConfig().getString("Block_Plugins").equals("true")){
    if ((event.getMessage().toLowerCase().startsWith("/plugins")) || 
      (event.getMessage().toLowerCase().startsWith("/pl ")) ||
      (event.getMessage().toLowerCase().equals("/plugins")) ||
      (event.getMessage().toLowerCase().equals("/pl")) ||
      (event.getMessage().toUpperCase().startsWith("/plugins")) || 
      (event.getMessage().toUpperCase().startsWith("/pl ")) ||
      (event.getMessage().toUpperCase().equals("/plugins")) ||
      (event.getMessage().toUpperCase().equals("/pl")))
    {
      if (!event.getPlayer().hasPermission("nop.plugins")) {
        event.setCancelled(true);
        p.sendMessage(plugin.getConfig().getString("Access_Denied").replaceAll("(&([a-f0-9]))", "�$2"));
      }
    }
    }
    if (plugin.getConfig().getString("Block_Help").equals("true")){
    if ((event.getMessage().toLowerCase().startsWith("/help")) || 
    		(event.getMessage().toLowerCase().equals("/help")) ||
    	      (event.getMessage().toLowerCase().startsWith("/? ")) || 
    	      (event.getMessage().toLowerCase().equals("/?")) ||
    	      (event.getMessage().toUpperCase().startsWith("/help")) || 
      		(event.getMessage().toUpperCase().equals("/help")) ||
  	      (event.getMessage().toUpperCase().startsWith("/? ")) || 
  	      (event.getMessage().toUpperCase().equals("/?")))
    	    {
    	      if (!event.getPlayer().hasPermission("nop.help")) {
    	        event.setCancelled(true);
    	        p.sendMessage(plugin.getConfig().getString("Access_Denied").replaceAll("(&([a-f0-9]))", "�$2")); 
    	      }
    	    }
    }

  
  if (plugin.getConfig().getString("Block_Version").equals("true")){
	    if ((event.getMessage().toLowerCase().startsWith("/version")) || 
	    		(event.getMessage().toLowerCase().equals("/version")) ||
	    	    (event.getMessage().toUpperCase().startsWith("/version")) || 
	      		(event.getMessage().toUpperCase().equals("/version")))
	    	    {
	    	      if (!event.getPlayer().hasPermission("nop.version")) {
	    	        event.setCancelled(true);
	    	        p.sendMessage(plugin.getConfig().getString("Access_Denied").replaceAll("(&([a-f0-9]))", "�$2")); 
	    	      }
	    	    }
	    }
	  }
} 