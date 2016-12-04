package xyz.FactionsD.menu;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import xyz.FactionsD.menu.items.Items;

public class FactionsLess {
	
	public static Inventory noFaction() {
		
		Inventory inv = Bukkit.createInventory(null, 54, "New Factions");
		
		inv.setItem(10, Items.viewFactions());
		
		return inv;
	}
}
