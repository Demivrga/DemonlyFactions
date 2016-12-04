package xyz.FactionsD;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import xyz.FactionsD.factions.FactionsHandler;

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
		
		// Loading our factions.
		this.loadFactions();
	}
	
	public void onDisable() {
		System.out.println("[DemonlyFactions] has been DISABLED!");
	}
	
	public void loadFactions() {
		 File[] files = new File(getDataFolder(), "Factions").listFiles();
		    File[] arrayOfFile1;
		    int j = (arrayOfFile1 = files).length;
		    for (int i = 0; i < j; i++)
		    {
		      File file = arrayOfFile1[i];
		      String name = file.getName().replaceAll(".yml", "");
		      FactionsHandler.loadFaction(name);
		    }
		    this.loaded = true;
	}
	
	public FactionsD() {
		pl = this;
	}

	public static FactionsD pl() {
		return pl;
	}
}
