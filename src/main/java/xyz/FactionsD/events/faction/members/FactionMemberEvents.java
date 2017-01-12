package xyz.FactionsD.events.faction.members;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import xyz.FactionsD.FactionsD;
import xyz.FactionsD.factions.FactionsHandler;
import xyz.FactionsD.items.FactionItems;
import xyz.FactionsD.items.faction.FactionMemberItems;
import xyz.FactionsD.menu.FactionsListMenu;
import xyz.FactionsD.menu.faction.FactionNoneMenu;
import xyz.FactionsD.menu.faction.members.FactionMemberMenu;
import xyz.FactionsD.menu.faction.members.FactionMembersMenu;

public class FactionMemberEvents implements Listener {

	@EventHandler
	public void MenuActions(InventoryClickEvent ev) {

		Player p = (Player) ev.getWhoClicked();

		if (ev.getCurrentItem() != null) {
			if (ev.getInventory().getTitle().contains(FactionMemberMenu.Title)) {

				if (ev.getCurrentItem().equals(FactionItems.factionsView())) {
					p.openInventory(FactionsListMenu.factionsList(1));
				}
				
				if(ev.getCurrentItem().equals(FactionMemberItems.factionListMembers())) {
					p.openInventory(FactionMembersMenu.factionsList(1, FactionsHandler.getPlayersFaction(p.getUniqueId())));
				}

				if (ev.getCurrentItem().equals(FactionMemberItems.factionMemberQuit())) {
					
					// Let's update to the are you sure phase.
					ItemUpdate(ev.getInventory(), 53, FactionItems.areYouSure(), 5);
					
					// If not clicked after 5 seconds, revert back!
					ItemUpdate(ev.getInventory(), 53, FactionMemberItems.factionMemberQuit(), 50);
				}

				if (ev.getCurrentItem().equals(FactionItems.areYouSure())) {
					if (ev.getSlot() == 53) {

						FactionsHandler.removeFactionMember(p.getUniqueId(),
								FactionsHandler.getPlayersFaction(p.getUniqueId()));

						p.openInventory(FactionNoneMenu.noFaction());
					}
				}
			}
		}
	}

	public void ItemUpdate(final Inventory inv, final int slot, final ItemStack old, long time) {
		Bukkit.getScheduler().runTaskLater(FactionsD.pl(), new Runnable() {
			public void run() {

				if (inv != null) {
					inv.setItem(slot, old);

				}
			}
		}, time);
	}
}
