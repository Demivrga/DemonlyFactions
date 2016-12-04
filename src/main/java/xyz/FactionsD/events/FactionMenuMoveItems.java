package xyz.FactionsD.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

import xyz.FactionsD.menu.FactionsLess;
import xyz.FactionsD.menu.FactionsList;

public class FactionMenuMoveItems implements Listener {
	
	@EventHandler
	public void moveItems(InventoryClickEvent ev) {
		if (ev.getInventory().getTitle().contains(FactionsLess.Title)) {
			ev.setCancelled(true);
		}
		if (ev.getInventory().getTitle().equals("Factions - Members")) {
			ev.setCancelled(true);
		}
		if (ev.getInventory().getTitle().equals("Factions - Mods")) {
			ev.setCancelled(true);
		}
		if (ev.getInventory().getTitle().equals("Factions - Owner")) {
			ev.setCancelled(true);
		}
		if (ev.getInventory().getTitle().contains(FactionsList.Title)) {
			ev.setCancelled(true);
		}
	}
	
	@EventHandler
	public void dragItems(InventoryDragEvent ev) {
		if (ev.getInventory().getTitle().contains(FactionsLess.Title)) {
			ev.setCancelled(true);
		}
		if (ev.getInventory().getTitle().equals("Factions - Members")) {
			ev.setCancelled(true);
		}
		if (ev.getInventory().getTitle().equals("Factions - Mods")) {
			ev.setCancelled(true);
		}
		if (ev.getInventory().getTitle().equals("Factions - Owner")) {
			ev.setCancelled(true);
		}
		if (ev.getInventory().getTitle().contains(FactionsList.Title)) {
			ev.setCancelled(true);
		}
	}
}
