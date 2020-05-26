package me.Ravis96.rAntiGrief;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, (Plugin)this);
	    saveDefaultConfig();
	  }

	  @EventHandler(priority = EventPriority.HIGH)
	  public void placeBlock(BlockPlaceEvent e) {
	    Player p = e.getPlayer();
	    if (e.getBlock().getType() == Material.TNT)
	      if (!getConfig().getBoolean("TNT")) {
	        p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("TNTBlockMessage")));
	        e.setCancelled(true);
	      } 
	  }
	  
	  @EventHandler(priority = EventPriority.HIGH)
	  public void onTNTExplosion(EntityExplodeEvent e) {
		  if (!getConfig().getBoolean("TNT")) {
		        e.setCancelled(true);
		      } 
	  }
	  
	  @EventHandler(priority = EventPriority.HIGH)
	  public void explodeHeight(EntityExplodeEvent e) {
	    if (e.getEntityType() == EntityType.PRIMED_TNT)
	      if (!getConfig().getBoolean("TNT"))
	        e.setCancelled(true);  
	  }
	  
	  @EventHandler(priority = EventPriority.HIGH)
	  public void onCreeperExplosion(EntityExplodeEvent e) {
		  if (!getConfig().getBoolean("CREEPER")) {
		        e.setCancelled(true);
		      } 
	  }
	  
	  @EventHandler(priority = EventPriority.HIGH)
	  public void onPlayerBucketEmpty(PlayerBucketEmptyEvent e) {
	    Player p = e.getPlayer();
	    if (!getConfig().getBoolean("LAVA")) {
	    	if (e.getBucket() == Material.LAVA_BUCKET) {
	        p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("LavaBlockMessage")));
	        e.setCancelled(true);
	    	}
	      }  
	  }

	  @EventHandler(priority = EventPriority.HIGH)
	  public void onPlayerBucketFill(PlayerBucketFillEvent e) {
	    Player p = e.getPlayer();
	    if (!getConfig().getBoolean("LAVA")) {
	    	if (e.getBlockClicked().getType() == Material.LAVA) {
	        p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("LavaBlockMessage")));
	        e.setCancelled(true);
	    	}
	      }
	  }
}
