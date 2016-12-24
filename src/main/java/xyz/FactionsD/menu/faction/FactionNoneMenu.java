package xyz.FactionsD.menu.faction;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import xyz.FactionsD.items.FactionItems;

public class FactionNoneMenu {
	
	public static String Title = "Factions - None";
	
	public static Inventory noFaction() {
		
		Inventory inv = Bukkit.createInventory(null, 54, Title);
		
		inv.setItem(21, FactionItems.factionCreate());
		inv.setItem(22, FactionItems.factionsView());
		inv.setItem(23, FactionItems.factionInvites());
		
		return inv;
	}
}
