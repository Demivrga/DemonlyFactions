package xyz.FactionsD;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.FactionsD.commands.Developer;
import xyz.FactionsD.commands.Faction;
import xyz.FactionsD.events.FactionInvitesEvents;
import xyz.FactionsD.events.FactionMenuMoveItems;
import xyz.FactionsD.events.faction.FactionNoneEvents;
import xyz.FactionsD.events.faction.FactionsListEvents;
import xyz.FactionsD.events.faction.members.FactionMemberEvents;
import xyz.FactionsD.events.faction.members.FactionMembersEvents;
import xyz.FactionsD.factions.FactionsHandler;
import xyz.FactionsD.factions.FactionsManager;
import xyz.FactionsD.menu.FactionFactory;

public class FactionsD extends JavaPlugin {

	private static FactionsD pl;
	private PluginManager pm = Bukkit.getPluginManager();
	public boolean loaded = false;

	private File menuConfig;
	private File englishConfig;
	private FileConfiguration english;
	private FileConfiguration menu;

	public void onEnable() {
		System.out.println("[DemonlyFactions] has been ENABLED!");

		// Registering all of our Events
		pm.registerEvents(new FactionMenuMoveItems(), this);
		pm.registerEvents(new FactionsListEvents(), this);
		pm.registerEvents(new FactionNoneEvents(), this);
		pm.registerEvents(new FactionMemberEvents(), this);
		pm.registerEvents(new FactionMembersEvents(), this);
		pm.registerEvents(new FactionInvitesEvents(), this);
		pm.registerEvents(new FactionFactory(), this);

		// Registering our commands
		this.getCommand("faction").setExecutor(new Faction());
		this.getCommand("developer").setExecutor(new Developer());

		// Configuration Files
		createFiles();
		saveDefaultConfig();

		// Let's find/create our Factions Data Folder
		File folder = new File(getDataFolder(), "Factions");
		if (!folder.exists()) {
			folder.mkdirs();
		}

		// Loading our factions.
		this.loadFactions();

		// Hourly save factions data
		this.timedFactionSave();
	}

	public void onDisable() {
		System.out.println("[DemonlyFactions] has been DISABLED!");
		saveFactions();
	}

	public static FileConfiguration getMenuConfig() {
		return FactionsD.pl().menu;
	}

	public static FileConfiguration getEnglishConfig() {
		return FactionsD.pl().english;
	}

	private void createFiles() {

		menuConfig = new File(getDataFolder(), "menu.yml");
		englishConfig = new File(getDataFolder(), "english.yml");

		if (!menuConfig.exists()) {
			menuConfig.getParentFile().mkdirs();
			saveResource("menu.yml", false);
		}

		if (!englishConfig.exists()) {
			englishConfig.getParentFile().mkdirs();
			saveResource("english.yml", false);
		}

		menu = new YamlConfiguration();
		english = new YamlConfiguration();

		try {
			menu.load(menuConfig);
			english.load(englishConfig);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}

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

				if (f.getFactionMoto() != null) {
					factionfile.set("Faction.moto", f.getFactionMoto().toString());
				}

				if (f.getFactionSymbol() != null) {
					factionfile.set("Faction.symbol", f.getFactionSymbol().toString());
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
	
	public FactionsD() {
		pl = this;
	}

	public static FactionsD pl() {
		return pl;
	}

	public void timedFactionSave() {
		Thread t = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						int x = getConfig().getInt("DemonlyFactions.save_faction_rate");
						if (!(x == 0)) {
							Thread.sleep(1000 * 60 * x);
							saveFactions();
							System.out.println("[DemonlyFactions]: Saved our factions!");
						}
					} catch (InterruptedException ie) {
					}
				}
			}
		};
		t.start();
	}
}
