package xyz.FactionsD.events.faction.members;

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
import xyz.FactionsD.menu.faction.FactionNoneMenu;
import xyz.FactionsD.menu.faction.members.FactionMemberMenu;
import xyz.FactionsD.menu.faction.members.FactionMembersMenu;

public class FactionMembersEvents implements Listener {

	@EventHandler
	public void MenuActions(InventoryClickEvent ev) {

		Player p = (Player) ev.getWhoClicked();

		if (ev.getCurrentItem() != null) {
			if (ev.getInventory().getTitle().contains(FactionMembersMenu.Title)) {

				String[] s1 = ChatColor.stripColor(ev.getClickedInventory().getTitle()).split("#");
				String s2 = s1[1];

				if (FactionsHandler.getLoadedFactions() != null) {
					int i = FactionsHandler.listFactionMembers(FactionsHandler.getPlayersFaction(p.getUniqueId())).size();
					int j = (int) Math.ceil(i / 45.0);

					if (ev.getCurrentItem().equals(FactionItems.ArrowForward())) {
						if (Integer.parseInt(s2) + 1 <= j) {
							p.openInventory(FactionMembersMenu.factionsList(Integer.parseInt(s2) + 1, FactionsHandler.getPlayersFaction(p.getUniqueId())));
						}
					}

					if (ev.getCurrentItem().equals(FactionItems.ArrowBack())) {
						if (Integer.parseInt(s2) > 1) {
							p.openInventory(FactionMembersMenu.factionsList(Integer.parseInt(s2) - 1, FactionsHandler.getPlayersFaction(p.getUniqueId())));

						}
					}
				}

				if (ev.getCurrentItem().equals(FactionItems.Return())) {

					String FactionName = FactionsHandler.getPlayersFaction(p.getUniqueId());

					if (FactionName != null) {

						String rank = FactionsHandler.getPlayersFactionRank(p.getUniqueId(), FactionName);

						if (rank.equalsIgnoreCase("Member")) {
							p.openInventory(FactionMemberMenu.factionMember(p));
						}

						if (rank.equalsIgnoreCase("Mod")) {
							p.openInventory(FactionMemberMenu.factionMember(p));
						}

						if (rank.equalsIgnoreCase("Owner")) {
							p.openInventory(FactionMemberMenu.factionMember(p));
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

		if (ev.getInventory().getTitle().equals(FactionMembersMenu.Title + "1")) {
			ev.getInventory().setItem(48, air);
		}
	}
}
