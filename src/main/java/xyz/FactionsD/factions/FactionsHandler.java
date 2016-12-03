package xyz.FactionsD.factions;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class FactionsHandler {

	private static HashMap<String, FactionsManager> factions = new HashMap<String, FactionsManager>();

	// Putting factions inside the FactionManager
	public void put(String FactionName, FactionsManager faction) {
		factions.put(FactionName, faction);
	}

	// Getting all the loaded Factions
	public Collection<FactionsManager> getLoadedFactions() {
		if ((factions.isEmpty()) || (factions == null)) {
			return null;
		}
		return factions.values();
	}

	// Getting the Faction
	public FactionsManager getFaction(String name) {
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
	public String getPlayersFaction(UUID uuid) {
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
	public String getRank(UUID uuid, String FactionName) {
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

}
