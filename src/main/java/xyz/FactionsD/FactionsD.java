package xyz.FactionsD;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.FactionsD.commands.Faction;
import xyz.FactionsD.events.FactionMenuMoveItems;
import xyz.FactionsD.events.FactionsLessEvents;
import xyz.FactionsD.events.FactionsListEvents;
import xyz.FactionsD.factions.FactionsHandler;
import xyz.FactionsD.factions.FactionsManager;

public class FactionsD extends JavaPlugin {

	private static FactionsD pl;
	private PluginManager pm = Bukkit.getPluginManager();
	public boolean loaded = false;

	public void onEnable() {
		System.out.println("[DemonlyFactions] has been ENABLED!");

		// Registering all of our Events
		pm.registerEvents(new FactionMenuMoveItems(), this);
		pm.registerEvents(new FactionsListEvents(), this);
		pm.registerEvents(new FactionsLessEvents(), this);

		// Registering our commands
		this.getCommand("faction").setExecutor(new Faction());

		// Let's find/create our Factions Data Folder
		File folder = new File(getDataFolder(), "Factions");
		if (!folder.exists()) {
			folder.mkdirs();
		}

		// Loading our factions.
		this.loadFactions();
	}

	public void onDisable() {
		System.out.println("[DemonlyFactions] has been DISABLED!");
		saveFactions();
	}

	public FactionsD() {
		pl = this;
	}

	public static FactionsD pl() {
		return pl;
	}

	public void saveFactions() {

		for (FactionsManager f : FactionsHandler.getLoadedFactions()) {

			File file = new File(getDataFolder(), "Factions//" + f.getFactionName() + ".yml");

			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			YamlConfiguration factionfile = YamlConfiguration.loadConfiguration(file);
			if (f.getFactionName() != null) {
				factionfile.set("Faction.name", f.getFactionName());
			}

			if (f.getFactionOwnerUUID() != null) {
				factionfile.set("Faction.owner", f.getFactionOwnerUUID().toString());
			}

			if (f.getFactionModsUUID() != null) {
				factionfile.set("Faction.mods", f.getFactionModsUUID().toString());
			}

			if (f.getFactionMembersUUID() != null) {
				factionfile.set("Faction.members", f.getFactionMembersUUID().toString());
			}
			factionfile.set("Faction.money", f.getFactionMoney());

			try {
				factionfile.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void loadFactions() {
		File[] files = new File(getDataFolder(), "Factions").listFiles();
		File[] arrayOfFile1;
		int j = (arrayOfFile1 = files).length;
		for (int i = 0; i < j; i++) {
			File file = arrayOfFile1[i];
			String name = file.getName().replaceAll(".yml", "");
			FactionsHandler.loadFaction(name);
		}
		this.loaded = true;
	}
}
