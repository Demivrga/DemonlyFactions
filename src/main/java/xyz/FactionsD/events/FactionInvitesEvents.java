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
import xyz.FactionsD.factions.FactionsManager;
import xyz.FactionsD.items.FactionItems;
import xyz.FactionsD.menu.FactionInvitesMenu;
import xyz.FactionsD.menu.faction.FactionNoneMenu;
import xyz.FactionsD.menu.faction.members.FactionMemberMenu;

public class FactionInvitesEvents implements Listener {

	@EventHandler
	public void MenuActions(InventoryClickEvent ev) {

		Player p = (Player) ev.getWhoClicked();

		if (ev.getCurrentItem() != null) {
			if (ev.getInventory().getTitle().contains(FactionInvitesMenu.Title)) {

				String[] s1 = ChatColor.stripColor(ev.getClickedInventory().getTitle()).split("#");
				String s2 = s1[1];

				if (FactionsHandler.getLoadedFactions() != null) {
					int i = FactionsHandler.intFactionInvites(p.getUniqueId());
					int j = (int) Math.ceil(i / 45.0);

					if (ev.getCurrentItem().equals(FactionItems.ArrowForward())) {
						if (Integer.parseInt(s2) + 1 <= j) {
							p.openInventory(FactionInvitesMenu.factionsInvites(p, Integer.parseInt(s2) + 1));
						}
					}

					if (ev.getCurrentItem().equals(FactionItems.ArrowBack())) {
						if (Integer.parseInt(s2) > 1) {
							p.openInventory(FactionInvitesMenu.factionsInvites(p, Integer.parseInt(s2) - 1));
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

				if (ev.getCurrentItem().getType().equals(Material.EYE_OF_ENDER)) {

					String Faction = ev.getCurrentItem().getItemMeta().getDisplayName();
					String Faction2 = ChatColor.stripColor(Faction);

					if (FactionsHandler.getFaction(Faction2) != null) {
						if (FactionsHandler.listFactionInvites(Faction2).contains(p.getUniqueId().toString())) {

							p.sendMessage("Joining the Faction: " + Faction2);

							for (FactionsManager invfm : FactionsHandler.getLoadedFactions()) {

								if (invfm.getFactionInvites().contains(p.getUniqueId().toString())) {
									invfm.getFactionInvites().remove(p.getUniqueId().toString());
								}
							}

							FactionsHandler.addFactionMember(p.getUniqueId(), Faction2);

							p.openInventory(FactionMemberMenu.factionMember(p));

						} else {
							p.openInventory(FactionInvitesMenu.factionsInvites(p, Integer.parseInt(s2)));
						}
					} else {
						p.openInventory(FactionInvitesMenu.factionsInvites(p, Integer.parseInt(s2)));
						p.sendMessage("This faction has already fallen!");
					}
				}
			}
		}
	}

	@EventHandler
	public void RemovePrevious(InventoryOpenEvent ev) {

		ItemStack air = new ItemStack(Material.AIR);

		if (ev.getInventory().getTitle().equals(FactionInvitesMenu.Title + "1")) {
			ev.getInventory().setItem(48, air);
		}
	}
}
