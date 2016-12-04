package xyz.FactionsD.menu;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class FactionsMember {
	
	public static String Title = "Factions - Members";
	
	public static Inventory memberFaction(String factionname) {
		
		Inventory inv = Bukkit.createInventory(null, 54, Title + factionname);
		
		return inv;
	}

}
