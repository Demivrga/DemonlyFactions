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
		this.getCommand("create").setExecutor(new Faction());

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

		if (FactionsHandler.getLoadedFactions() != null) {
			for (FactionsManager f : FactionsHandler.getLoadedFactions()) {
				File folder = new File(getDataFolder(), "Factions");
				File file = new File(getDataFolder(), "Factions//" + f.getFactionName() + ".yml");

				// Checking if the DataFolder even exists.
				if (!folder.exists()) {
					folder.mkdirs();
				}

				// Checking if the DatFile even exists.
				if (!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				// Our saving Method for saving each file.
				YamlConfiguration factionfile = YamlConfiguration.loadConfiguration(file);
				if (f.getFactionName() != null) {
					factionfile.set("Faction.name", f.getFactionName());
				}

				if (f.getFactionOwnerUUID() != null) {
					factionfile.set("Faction.owner", f.getFactionOwnerUUID().toString());
				}

				if (f.getFactionModsUUID() != null) {
					factionfile.set("Faction.mods", f.getFactionModsUUID());
				}

				if (f.getFactionMembersUUID() != null) {
					factionfile.set("Faction.members", f.getFactionMembersUUID());
				}
				if (f.getFactionInvites() != null) {
					factionfile.set("Faction.invites", f.getFactionInvites());
				}
				factionfile.set("Faction.money", f.getFactionMoney());

				// Let's save our file now with all the new healthy information.
				try {
					factionfile.save(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// Our method for loading the Factions.
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
