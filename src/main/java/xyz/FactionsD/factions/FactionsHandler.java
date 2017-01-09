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

	/*
	 * 
	 * Thanks to @ScruffyRules for code assistance! Thanks to @SpottedLeaf for
	 * code assistance!
	 * 
	 */

	private static HashMap<String, FactionsManager> factions = new HashMap<String, FactionsManager>();

	// Putting factions inside the FactionManager
	public static void addFaction(String FactionName, FactionsManager faction) {
		factions.put(FactionName, faction);
	}

	// Getting all the loaded Factions
	public static Collection<FactionsManager> getLoadedFactions() {
		if ((factions == null) || (factions.isEmpty())) {
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
			if (fm.getFactionMembersUUID() != null) {
				if (fm.getFactionMembersUUID().contains(uuid.toString())) {
					return fm.getFactionName();
				}
			}
			if (fm.getFactionModsUUID() != null) {
				if (fm.getFactionModsUUID().contains(uuid.toString())) {
					return fm.getFactionName();
				}
			}
			if (fm.getFactionOwnerUUID().equals(uuid)) {
				return fm.getFactionName();
			}
		}
		return null;
	}

	// Getting the Players Faction Rank
	public static String getPlayersFactionRank(UUID uuid, String FactionName) {
		String rank = "Member";
		FactionsManager f = getFaction(FactionName);

		if (f.getFactionModsUUID() != null) {
			if (f.getFactionModsUUID().contains(uuid.toString())) {
				rank = "Mod";
			}
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
		FactionsManager f = getFaction(FactionName);
		if (f.getFactionMembersUUID() != null) {
			if (f.getFactionMembersUUID().contains(uuid.toString())) {
				return false;
			}
		}

		List<String> members = f.getFactionMembersUUID();
		String suuid = uuid.toString();
		members.add(suuid);
		f.setFactionMembersUUID(members);

		return true;
	}

	// Removing a faction member
	public static boolean removeFactionMember(UUID uuid, String FactionName) {
		if ((factions == null) && (factions.isEmpty())) {
			return false;
		}
		if (getFaction(FactionName) == null) {
			return false;
		}
		FactionsManager f = getFaction(FactionName);
		if (f.getFactionModsUUID().contains(uuid.toString())) {
			List<String> mods = f.getFactionModsUUID();
			mods.remove(uuid);
			f.setFactionModsUUID(mods);
		}
		if (!f.getFactionMembersUUID().contains(uuid.toString())) {
			return false;
		}

		List<String> members = f.getFactionMembersUUID();
		members.remove(uuid.toString());
		f.setFactionMembersUUID(members);

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
		FactionsManager f = getFaction(FactionName);
		if (f.getFactionModsUUID() != null) {
			if (f.getFactionModsUUID().contains(uuid.toString())) {
				return false;
			}
		}

		List<String> mods = f.getFactionModsUUID();
		String suuid = uuid.toString();
		mods.add(suuid);
		f.setFactionModsUUID(mods);

		return true;
	}

	// Removing a faction moderator
	public static boolean removeFactionMod(UUID uuid, String FactionName) {
		if ((factions == null) && (factions.isEmpty())) {
			return false;
		}
		if (getFaction(FactionName) == null) {
			return false;
		}
		FactionsManager f = getFaction(FactionName);
		if (!f.getFactionModsUUID().contains(uuid.toString())) {
			return false;
		}

		List<String> mods = f.getFactionModsUUID();
		mods.remove(uuid.toString());
		f.setFactionModsUUID(mods);

		if (!f.getFactionMembersUUID().contains(uuid.toString())) {
			addFactionMember(uuid, FactionName);
		}

		return true;
	}

	// Adding a invite to the faction
	public static boolean addFactionInvite(UUID uuid, String FactionName) {
		if ((factions == null) && (factions.isEmpty())) {
			return false;
		}
		if (getFaction(FactionName) == null) {
			return false;
		}
		FactionsManager f = getFaction(FactionName);
		if (f.getFactionInvites() != null) {
			if (f.getFactionInvites().contains(uuid.toString())) {
				return false;
			}
		}

		List<String> invites = f.getFactionInvites();
		String suuid = uuid.toString();
		invites.add(suuid);
		f.setFactionInvites(invites);

		return true;
	}

	// Removing a faction invite
	public static boolean removeFactionInvite(UUID uuid, String FactionName) {
		if ((factions == null) && (factions.isEmpty())) {
			return false;
		}
		if (getFaction(FactionName) == null) {
			return false;
		}
		FactionsManager f = getFaction(FactionName);
		if (!f.getFactionInvites().contains(uuid.toString())) {
			return false;
		}

		List<String> invites = f.getFactionInvites();
		invites.remove(uuid.toString());
		f.setFactionMembersUUID(invites);

		return true;
	}
	
	// Listing out the Faction Owner
	public static UUID listFactionOwner(String name) {
		if ((factions == null) || (factions.isEmpty())) {
			return null;
		}
		for (FactionsManager fm : factions.values()) {
			if (fm.getFactionName().equalsIgnoreCase(name)) {
				return fm.getFactionOwnerUUID();
			}
		}
		return null;
	}
	
	// Listing out the Faction Owner
	public static List<String> listFactionMembers(String name) {
		if ((factions == null) || (factions.isEmpty())) {
			return null;
		}
		for (FactionsManager fm : factions.values()) {
			if (fm.getFactionName().equalsIgnoreCase(name)) {
				return fm.getFactionMembersUUID();
			}
		}
		return null;
	}
	
	// Listing out the Faction Owner
	public static int listFactionMoney(String name) {
		if ((factions == null) || (factions.isEmpty())) {
			return 0;
		}
		for (FactionsManager fm : factions.values()) {
			if (fm.getFactionName().equalsIgnoreCase(name)) {
				return fm.getFactionMoney();
			}
		}
		return 0;
	}
	
	// Listing out the Faction Owner
	public static List<String> listFactionMods(String name) {
		if ((factions == null) || (factions.isEmpty())) {
			return null;
		}
		for (FactionsManager fm : factions.values()) {
			if (fm.getFactionName().equalsIgnoreCase(name)) {
				return fm.getFactionModsUUID();
			}
		}
		return null;
	}
	
	// Listing out the Faction Owner
	public static List<String> listFactionInvites(String name) {
		if ((factions == null) || (factions.isEmpty())) {
			return null;
		}
		for (FactionsManager fm : factions.values()) {
			if (fm.getFactionName().equalsIgnoreCase(name)) {
				return fm.getFactionInvites();
			}
		}
		return null;
	}
	
	// Listing out the Faction Owner
	public static int intFactionInvites(UUID uuid) {
		if ((factions == null) || (factions.isEmpty())) {
			return 0;
		}
		for (FactionsManager fm : factions.values()) {
			int i = 0;
			if (fm.getFactionInvites().contains(uuid.toString())) {
				i++;
			}
			return i;
		}
		return 0;
	}

	// Deleting a Faction
	public static boolean deleteFaction(String FactionName) {

		if (getLoadedFactions() == null) {
			return false;
		}

		for (FactionsManager faction : getLoadedFactions()) {


			if (faction.getFactionName().equals(FactionName)) {
				
				File[] files = new File(FactionsD.pl().getDataFolder(), "Factions").listFiles();
				File[] arrayofFile1;
				int j = (arrayofFile1 = files).length;
				for (int i = 0; i < j; i++) {
					File file = arrayofFile1[i];
					if (file.getName().equalsIgnoreCase(FactionName + ".yml")) {
						file.delete();
					}
				}
				
				// removing the faction from the loaded factions.
				getLoadedFactions().remove(faction);
				return true;
			}
		}

		return false;
	}

	// Load Factions Method
	public static boolean loadFaction(String FactionName) {
		FactionsManager fm = new FactionsManager();
		UUID owneruuid = null;
		String name = null;
		String Moto = null;
		String Symbol = null;
		List<String> members = new ArrayList<String>();
		List<String> mods = new ArrayList<String>();
		List<String> invites = new ArrayList<String>();
		int money = 0;

		File[] files = new File(FactionsD.pl().getDataFolder(), "Factions").listFiles();
		File[] arrayofFile1;

		int j = (arrayofFile1 = files).length;
		for (int i = 0; i < j; i++) {
			File file = arrayofFile1[i];
			if (file.getName().equalsIgnoreCase(FactionName + ".yml")) {

				YamlConfiguration factionfile = YamlConfiguration.loadConfiguration(file);
				owneruuid = UUID.fromString(factionfile.getString("Faction.owner"));
				name = factionfile.getString("Faction.name");
				money = factionfile.getInt("Faction.money");

				if (factionfile.contains("Faction.members")) {
					members.addAll(factionfile.getStringList("Faction.members"));
				}
				if (factionfile.contains("Faction.invites")) {
					invites.addAll(factionfile.getStringList("Faction.invites"));
				}
				if (factionfile.contains("Faction.mods")) {
					mods.addAll(factionfile.getStringList("Faction.mods"));
				}
			}
		}

		fm.setFactionOwner(owneruuid);
		fm.setFactionName(name);
		fm.setFactionMoto(Moto);
		fm.setFactionSymbol(Symbol);
		fm.setFactionMembersUUID(members);
		fm.setFactionModsUUID(mods);
		fm.setFactionMoney(money);
		fm.setFactionInvites(invites);
		addFaction(FactionName, fm);

		return true;
	}
}
