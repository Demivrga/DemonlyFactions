package xyz.FactionsD.menu;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import xyz.FactionsD.factions.FactionsHandler;
import xyz.FactionsD.factions.FactionsManager;
import xyz.FactionsD.items.FactionItems;
import xyz.FactionsD.util.MessageUtil;

public class FactionsListMenu {

	public static String Title = MessageUtil.translate("&7&lFactions&f - List " + "#");

	public static Inventory factionsList(int page) {
		Inventory list = Bukkit.createInventory(null, 54, Title + page);

		int first = 45 * (page - 1) + 1;
		int last = 45 * page;
		int i = 1;

		if (FactionsHandler.getLoadedFactions() != null) {
			for (FactionsManager fm : FactionsHandler.getLoadedFactions()) {

				if ((i >= first) && (i <= last)) {
					list.addItem(new ItemStack[] { FactionItems.factionList(fm.getFactionName(), "") });
				}
				i++;
			}
		}

		list.setItem(50, FactionItems.ArrowForward());
		list.setItem(49, FactionItems.Return());
		list.setItem(48, FactionItems.ArrowBack());

		return list;
	}
}
