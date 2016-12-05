package xyz.FactionsD.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

import xyz.FactionsD.factions.FactionsHandler;
import xyz.FactionsD.menu.FactionsList;
import xyz.FactionsD.menu.items.FactionItems;

public class FactionsListEvents implements Listener {

	@EventHandler
	public void MenuActions(InventoryClickEvent ev) {

		Player p = (Player) ev.getWhoClicked();

		if (FactionsHandler.getLoadedFactions() != null) {
			int i = FactionsHandler.getLoadedFactions().size();
			int j = (int) Math.ceil(i / 45.0);

			if (ev.getCurrentItem() != null) {
				if (ev.getInventory().getTitle().contains(FactionsList.Title)) {

					String[] s1 = ChatColor.stripColor(ev.getClickedInventory().getTitle()).split("#");
					String s2 = s1[1];

					if (ev.getCurrentItem().equals(FactionItems.ArrowForward())) {
						if (Integer.parseInt(s2) + 1 <= j) {
							p.openInventory(FactionsList.factionsList(Integer.parseInt(s2) + 1));
						}
					}

					if (ev.getCurrentItem().equals(FactionItems.ArrowBack())) {
						if (Integer.parseInt(s2) > 1) {
							p.openInventory(FactionsList.factionsList(Integer.parseInt(s2) - 1));
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void RemovePrevious(InventoryOpenEvent ev) {

		ItemStack air = new ItemStack(Material.AIR);

		if (ev.getInventory().getTitle().equals(FactionsList.Title + "1")) {
			ev.getInventory().setItem(48, air);
		}
	}
}
