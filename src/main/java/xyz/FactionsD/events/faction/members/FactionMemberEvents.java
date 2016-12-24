package xyz.FactionsD.events.faction.members;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import xyz.FactionsD.items.FactionItems;
import xyz.FactionsD.menu.FactionsListMenu;
import xyz.FactionsD.menu.faction.members.FactionMemberMenu;

public class FactionMemberEvents implements Listener {

	@EventHandler
	public void MenuActions(InventoryClickEvent ev) {

		Player p = (Player) ev.getWhoClicked();

		if (ev.getCurrentItem() != null) {
			if (ev.getInventory().getTitle().contains(FactionMemberMenu.Title)) {
				
				if (ev.getCurrentItem().equals(FactionItems.factionsView())) {
					p.openInventory(FactionsListMenu.factionsList(1));
				}
			}
		}
	}
}
