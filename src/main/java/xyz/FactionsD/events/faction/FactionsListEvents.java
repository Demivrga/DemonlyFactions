package xyz.FactionsD.events.faction;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

import xyz.FactionsD.factions.FactionsHandler;
import xyz.FactionsD.items.FactionItems;
import xyz.FactionsD.menu.FactionsListMenu;
import xyz.FactionsD.menu.faction.FactionNoneMenu;
import xyz.FactionsD.menu.faction.members.FactionMemberMenu;

public class FactionsListEvents implements Listener {

	@EventHandler
	public void MenuActions(InventoryClickEvent ev) {

		Player p = (Player) ev.getWhoClicked();

		if (ev.getCurrentItem() != null) {
			if (ev.getInventory().getTitle().contains(FactionsListMenu.Title)) {

				String[] s1 = ChatColor.stripColor(ev.getClickedInventory().getTitle()).split("#");
				String s2 = s1[1];

				if (FactionsHandler.getLoadedFactions() != null) {
					int i = FactionsHandler.getLoadedFactions().size();
					int j = (int) Math.ceil(i / 45.0);

					if (ev.getCurrentItem().equals(FactionItems.ArrowForward())) {
						if (Integer.parseInt(s2) + 1 <= j) {
							p.openInventory(FactionsListMenu.factionsList(Integer.parseInt(s2) + 1));
						}
					}

					if (ev.getCurrentItem().equals(FactionItems.ArrowBack())) {
						if (Integer.parseInt(s2) > 1) {
							p.openInventory(FactionsListMenu.factionsList(Integer.parseInt(s2) - 1));
						}
					}
				}

				if (ev.getCurrentItem().equals(FactionItems.Return())) {

					String FactionName = FactionsHandler.getPlayersFaction(p.getUniqueId());

					if (FactionName != null) {

						String rank = FactionsHandler.getPlayersFactionRank(p.getUniqueId(), FactionName);

						if (rank.equalsIgnoreCase("Member")) {
							p.openInventory(FactionMemberMenu.factionMember(FactionName));
						}

						if (rank.equalsIgnoreCase("Mod")) {
							p.openInventory(FactionMemberMenu.factionMember(FactionName));
						}

						if (rank.equalsIgnoreCase("Owner")) {
							p.openInventory(FactionMemberMenu.factionMember(FactionName));
						}

					} else {
						p.openInventory(FactionNoneMenu.noFaction());
					}
				}
			}
		}
	}

	@EventHandler
	public void RemovePrevious(InventoryOpenEvent ev) {

		ItemStack air = new ItemStack(Material.AIR);

		if (ev.getInventory().getTitle().equals(FactionsListMenu.Title + "1")) {
			ev.getInventory().setItem(48, air);
		}
	}
}
