package xyz.FactionsD.menu.faction;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import xyz.FactionsD.FactionsD;
import xyz.FactionsD.items.FactionItems;
import xyz.FactionsD.util.MessageUtil;

public class FactionNoneMenu {

	public static String Title = MessageUtil
			.translate(FactionsD.getMenuConfig().getString("Items.Menu.No_Faction_Menu.Title"));
	private static String menuSize = "Items.Menu.No_Faction_Menu.Menu_Size";
	private static String factionCreateSlot = "Items.Menu.No_Faction_Menu.Faction_Create.slot";
	private static String factionListSlot = "Items.Menu.No_Faction_Menu.Faction_List.slot";
	private static String factionInvitesSlot = "Items.Menu.No_Faction_Menu.Faction_Invites.slot";

	public static Inventory noFaction() {

		Inventory inv = Bukkit.createInventory(null, FactionsD.getMenuConfig().getInt(menuSize), Title);

		inv.setItem(FactionsD.getMenuConfig().getInt(factionCreateSlot), FactionItems.factionCreate());
		inv.setItem(FactionsD.getMenuConfig().getInt(factionListSlot), FactionItems.factionsView());
		inv.setItem(FactionsD.getMenuConfig().getInt(factionInvitesSlot), FactionItems.factionInvites());

		return inv;
	}
}
