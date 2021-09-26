package me.drkmatr1984.fireworkpreventer;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

public class FireworkPreventerListener implements Listener
{	
	public FireworkPreventerListener() {
	}
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerLaunchRocket(ProjectileLaunchEvent event) {
		if(event.getEntity().getShooter() instanceof Player) {
			Player player = (Player) event.getEntity().getShooter();
			ItemStack heldItem = player.getInventory().getItemInMainHand();
			if(heldItem.getType().equals(Material.FIREWORK_ROCKET)) {
				if(player.hasPermission("firework.prevent")) {
					event.setCancelled(true);
					return;
				}
				if(player.hasPermission("firework.preventunlessgliding"))
					if(!player.isGliding()) {
						event.setCancelled(true);
						return;
					}
			}
		}
	}	
}
