package xyz.FactionsD.factions;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import xyz.FactionsD.FactionsD;

public class FactionsHandler {

	private static HashMap<String, FactionsManager> factions = new HashMap<String, FactionsManager>();

	// Putting factions inside the FactionManager
	public static void put(String FactionName, FactionsManager faction) {
		factions.put(FactionName, faction);
	}

	// Getting all the loaded Factions
	public static Collection<FactionsManager> getLoadedFactions() {
		if ((factions.isEmpty()) || (factions == null)) {
			return null;
		}
		return factions.values();
	}

	// Getting the Faction
	public static FactionsManager getFaction(String name) {
		if ((factions == null) || (factions.isEmpty())) {
			return null;
		}
		for (FactionsManager fm : factions.values()) {
			if (fm.getFactionName().equalsIgnoreCase(name)) {
				return fm;
			}
		}
		return null;
	}

	// Getting the Players Faction
	public static String getPlayersFaction(UUID uuid) {
		if ((factions == null) || (factions.isEmpty())) {
			return null;
		}
		for (FactionsManager fm : factions.values()) {
			if (fm.getFactionMembersUUID().contains(uuid)) {
				return fm.getFactionName();
			}
		}
		return null;
	}

	// Getting the Players Faction Rank
	public static String getPlayersFactionRank(UUID uuid, String FactionName) {
		String rank = "Member";
		FactionsManager f = getFaction(FactionName);

		if (f.getFactionModsUUID().contains(uuid)) {
			rank = "Mod";
		}
		if (f.getFactionOwnerUUID().equals(uuid)) {
			rank = "Owner";
		}
		return rank;
	}

	// Broadcasting a message across the entire Faction.
	public static void broadcastFactionMessage(String FactionName, String message) {
		FactionsManager f = getFaction(FactionName);
		if (f == null) {
			return;
		}
		for (String member : f.getFactionMembersUUID()) {
			Player target = Bukkit.getPlayer(member);

			if ((target != null) && (target.isOnline())) {
				target.sendMessage(message);
			}
		}
	}

	// Adding a member to the faction
	public static boolean addFactionMember(UUID uuid, String FactionName) {
		if ((factions == null) && (factions.isEmpty())) {
			return false;
		}
		if (getFaction(FactionName) == null) {
			return false;
		}
		FactionsManager main = getFaction(FactionName);
		if (main.getFactionMembersUUID().contains(uuid)) {
			return false;
		}
		List<String> members = main.getFactionMembersUUID();
		String suuid = uuid.toString();
		members.add(suuid);
		main.setFactionMembersUUID(members);

		return true;
	}

	// Adding a mod to the faction
	public static boolean addFactionMod(UUID uuid, String FactionName) {
		if ((factions == null) && (factions.isEmpty())) {
			return false;
		}
		if (getFaction(FactionName) == null) {
			return false;
		}
		FactionsManager main = getFaction(FactionName);
		if (main.getFactionModsUUID().contains(uuid)) {
			return false;
		}
		List<String> mods = main.getFactionModsUUID();
		String suuid = uuid.toString();
		mods.add(suuid);
		main.setFactionModsUUID(mods);

		return true;
	}

	public static boolean loadFaction(String FactionName) {
		FactionsManager fm = new FactionsManager();
		List<String> members = new ArrayList<String>();
		List<String> mods = new ArrayList<String>();
		UUID owneruuid = null;
		int money = 0;

		File[] files = new File(FactionsD.pl().getDataFolder(), "Factions").listFiles();
		File[] arrayofFile1;

		int j = (arrayofFile1 = files).length;
		for (int i = 0; i < j; i++) {
			File file = arrayofFile1[i];
			if (file.getName().equalsIgnoreCase(FactionName + ".yml")) {

				YamlConfiguration factionfile = YamlConfiguration.loadConfiguration(file);
				owneruuid = (UUID) factionfile.get("Faction.owner");
				money = factionfile.getInt("Faction.money");

				if (factionfile.contains("Faction.members")) {
					members.addAll(factionfile.getStringList("Faction.members"));
				}
				if (factionfile.contains("Faction.mods")) {
					mods.addAll(factionfile.getStringList("Faction.mods"));
				}
			}
		}

		fm.setFactionMembersUUID(members);
		fm.setFactionOwner(owneruuid);
		fm.setFactionMoney(money);
		put(FactionName, fm);

		return true;
	}

	public static void loadTESTFaction() {
		for (int i = 1; i < 100; i++) {
			FactionsManager fm = new FactionsManager();
			List<String> mods = new ArrayList<String>();
			fm.setFactionName("" + i);
			fm.setFactionOwner(UUID.randomUUID());
			fm.setFactionModsUUID(mods);
			fm.setFactionMembersUUID(mods);

			put("" + i, fm);
		}
	}
}
