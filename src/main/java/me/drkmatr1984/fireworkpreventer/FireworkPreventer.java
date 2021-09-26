package me.drkmatr1984.fireworkpreventer;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class FireworkPreventer extends JavaPlugin
{
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new FireworkPreventerListener(), this);
	}
}