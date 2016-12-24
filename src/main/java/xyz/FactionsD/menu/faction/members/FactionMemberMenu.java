package xyz.FactionsD.menu.faction.members;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import xyz.FactionsD.items.FactionItems;

public class FactionMemberMenu {
	
	public static String Title = "Factions - Members";
	
	public static Inventory factionMember(String factionname) {
		
		Inventory inv = Bukkit.createInventory(null, 54, Title);
		
		inv.setItem(13, FactionItems.factionInfo("&5&l"+factionname));
		inv.setItem(49, FactionItems.factionsView());
		
		return inv;
	}

}
