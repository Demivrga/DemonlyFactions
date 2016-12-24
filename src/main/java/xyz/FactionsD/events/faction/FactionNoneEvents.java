package xyz.FactionsD.events.faction;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import xyz.FactionsD.items.FactionItems;
import xyz.FactionsD.menu.FactionInvitesMenu;
import xyz.FactionsD.menu.FactionsListMenu;
import xyz.FactionsD.menu.faction.FactionNoneMenu;

public class FactionNoneEvents implements Listener {

	@EventHandler
	public void MenuActions(InventoryClickEvent ev) {

		Player p = (Player) ev.getWhoClicked();

		if (ev.getCurrentItem() != null) {
			if (ev.getInventory().getTitle().contains(FactionNoneMenu.Title)) {
				
				// Here's our individual item actions
				
				if (ev.getCurrentItem().equals(FactionItems.factionsView())) {
					p.openInventory(FactionsListMenu.factionsList(1));
				}
				
				if (ev.getCurrentItem().equals(FactionItems.factionInvites())) {
					p.openInventory(FactionInvitesMenu.factionsInvites(p, 1));
				}
			}
		}
	}
}
