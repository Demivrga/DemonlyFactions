package xyz.FactionsD.menu;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import xyz.FactionsD.menu.items.FactionItems;

public class FactionsLess {
	
	public static String Title = "Factions - None";
	
	public static Inventory noFaction() {
		
		Inventory inv = Bukkit.createInventory(null, 54, Title);
		
		inv.setItem(21, FactionItems.createFaction());
		inv.setItem(22, FactionItems.viewFactions());
		inv.setItem(23, FactionItems.joinFactions());
		
		return inv;
	}
}
