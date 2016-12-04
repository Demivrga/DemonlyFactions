package xyz.FactionsD.factions;

import java.util.List;
import java.util.UUID;

public class FactionsManager {
	
	private String factionName;
	private String factionOwner;
	private UUID factionOwnerUUID;
	private String factionSymbol;
	private int factionMoney;
	private List<String> factionMembersUUID;
	private List<String> factionMods;
	
	
	// These are our methods for getting faction information.
	public String getFactionName() {
		return this.factionName;
	}
	
	public String getFactionOwner() {
		return this.factionOwner;
	}
	
	public UUID getFactionOwnerUUID() {
		return this.factionOwnerUUID;
	}
	
	public String getFactionSymbol() {
		return this.factionSymbol;
	}
	
	public int getFactionMoney(){
		return this.factionMoney;
	}
	
	public List<String> getFactionMembersUUID() {
		return this.factionMembersUUID;
	}
	
	public List<String> getFactionModsUUID() {
		return this.factionMods;
	}
	
	
	// These are our methods for setting faction information.
	public void setFactionName(String name) {
		this.factionName = name;
	}
	
	public void setFactionOwner(UUID uuid) {
		this.factionOwnerUUID = uuid;
	}
	
	public void setFactionMoney(int money) {
		this.factionMoney = money;
	}
	
	public void setFactionMembersUUID(List<String> members) {
		this.factionMembersUUID = members;
	}
	
	public void setFactionModsUUID(List<String> mods) {
		this.factionMods = mods;
	}

}
