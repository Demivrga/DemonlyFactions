package xyz.FactionsD.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import xyz.FactionsD.menu.FactionsLess;
import xyz.FactionsD.menu.FactionsList;
import xyz.FactionsD.menu.items.FactionItems;

public class FactionsLessEvents implements Listener {

	@EventHandler
	public void MenuActions(InventoryClickEvent ev) {

		Player p = (Player) ev.getWhoClicked();

		if (ev.getCurrentItem() != null) {
			if (ev.getInventory().getTitle().contains(FactionsLess.Title)) {
				if (ev.getCurrentItem().equals(FactionItems.viewFactions())) {
					p.openInventory(FactionsList.factionsList(1));
				}
			}
		}
	}
}
