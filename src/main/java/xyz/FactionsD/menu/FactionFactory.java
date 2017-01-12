package xyz.FactionsD.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import xyz.FactionsD.factions.FactionsHandler;
import xyz.FactionsD.factions.FactionsManager;
import xyz.FactionsD.items.FactionItems;
import xyz.FactionsD.menu.faction.FactionNoneMenu;
import xyz.FactionsD.util.anvil.AnvilGUI;
import xyz.FactionsD.util.anvil.AnvilGUI.AnvilClickEvent;

public class FactionFactory implements Listener {

	private static String chosenFactionName = null;

	// Faction Factory Method
	@EventHandler
	public void Factory(InventoryClickEvent ev) {

		final Player p = (Player) ev.getWhoClicked();

		String FactionName = FactionsHandler.getPlayersFaction(p.getUniqueId());
		final FactionsManager fm = new FactionsManager();

		if (ev.getCurrentItem() != null) {
			if (ev.getInventory().getTitle().contains(FactionNoneMenu.Title)) {

				if (ev.getCurrentItem().equals(FactionItems.factionCreate())) {
					if (FactionName != null) {

						p.sendMessage("You're Already in a faction!");

					} else {

						AnvilGUI factionNameGUI = new AnvilGUI(p, new AnvilGUI.AnvilClickEventHandler() {

							public void onAnvilClick(final AnvilClickEvent ev) {
								if (ev.getSlot() == AnvilGUI.AnvilSlot.OUTPUT) {

									if (!StringUtils.containsAny(ev.getName(), "!*()\"\\';:{}[]<>,.?/~` ")) {

										ev.setWillClose(true);
										ev.setWillDestroy(true);

										p.sendMessage("You've Chosen The Faction Name: " + ev.getName());
										chosenFactionName = ev.getName();

										createFaction(fm, chosenFactionName, p.getUniqueId(), 0);

									} else {
										p.sendMessage("ERROR: Faction can not contain any: !*()\"\\';:{}[]<>,.?/~`");
									}
								}
							}
						});

						factionNameGUI.setSlot(AnvilGUI.AnvilSlot.INPUT_LEFT, FactionItems.factionPaperCreate());

						try {
							factionNameGUI.open();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	private void createFaction(FactionsManager fm, String factionName, UUID factionOwner, int money) {
		// Creating our faction
		List<String> mods = new ArrayList<String>();
		List<String> invites = new ArrayList<String>();

		fm.setFactionName(factionName);
		fm.setFactionOwner(factionOwner);
		fm.setFactionInvites(invites);
		fm.setFactionMembersUUID(mods);
		fm.setFactionModsUUID(mods);
		fm.setFactionMoney(money);

		FactionsHandler.addFaction(fm.getFactionName(), fm);
	}
}
