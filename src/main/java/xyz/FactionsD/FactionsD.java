package xyz.FactionsD;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class FactionsD extends JavaPlugin {
	
	private static FactionsD pl;
	public boolean loaded = false;
	
	public void onEnable() {
		System.out.println("[DemonlyFactions] has been ENABLED!");		
		
		// Let's find our Factions Data Folder
		File folder = new File(getDataFolder(), "Factions");
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}
	
	public void onDisable() {
		System.out.println("[DemonlyFactions] has been DISABLED!");
	}
	
	public FactionsD() {
		pl = this;
	}

	public static FactionsD pl() {
		return pl;
	}
}
