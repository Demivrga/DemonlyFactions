package xyz.FactionsD.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

import xyz.FactionsD.menu.FactionsListMenu;
import xyz.FactionsD.menu.faction.FactionNoneMenu;
import xyz.FactionsD.menu.faction.members.FactionMemberMenu;

public class FactionMenuMoveItems implements Listener {
	
	@EventHandler
	public void moveItems(InventoryClickEvent ev) {
		if (ev.getInventory().getTitle().contains(FactionNoneMenu.Title)) {
			ev.setCancelled(true);
		}
		if (ev.getInventory().getTitle().contains(FactionMemberMenu.Title)) {
			ev.setCancelled(true);
		}
		if (ev.getInventory().getTitle().equals("Factions - Mods")) {
			ev.setCancelled(true);
		}
		if (ev.getInventory().getTitle().equals("Factions - Owner")) {
			ev.setCancelled(true);
		}
		if (ev.getInventory().getTitle().contains(FactionsListMenu.Title)) {
			ev.setCancelled(true);
		}
	}
	
	@EventHandler
	public void dragItems(InventoryDragEvent ev) {
		if (ev.getInventory().getTitle().contains(FactionNoneMenu.Title)) {
			ev.setCancelled(true);
		}
		if (ev.getInventory().getTitle().contains(FactionMemberMenu.Title)) {
			ev.setCancelled(true);
		}
		if (ev.getInventory().getTitle().equals("Factions - Mods")) {
			ev.setCancelled(true);
		}
		if (ev.getInventory().getTitle().equals("Factions - Owner")) {
			ev.setCancelled(true);
		}
		if (ev.getInventory().getTitle().contains(FactionsListMenu.Title)) {
			ev.setCancelled(true);
		}
	}
}
