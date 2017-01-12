package xyz.FactionsD.menu.faction.members;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import xyz.FactionsD.FactionsD;
import xyz.FactionsD.items.FactionItems;
import xyz.FactionsD.items.faction.FactionMemberItems;
import xyz.FactionsD.util.MessageUtil;

public class FactionMemberMenu {

	public static String Title = MessageUtil
			.translate(FactionsD.getMenuConfig().getString("Items.Menu.Faction_Member.Title"));
	private static String menuSize = "Items.Menu.Faction_Member.Menu_Size";
	private static String factionInformationSlot = "Items.Menu.Faction_Member.Faction_Info.slot";
	private static String factionListSlot = "Items.Menu.Faction_Member.Faction_List.slot";
	private static String factionQuitSlot = "Items.Menu.Faction_Member.Faction_Quit.slot";
	private static String factionMembersSlot = "Items.Menu.Faction_Member.Faction_Members.slot";

	public static Inventory factionMember(Player p) {

		Inventory inv = Bukkit.createInventory(null, FactionsD.getMenuConfig().getInt(menuSize), Title);

		inv.setItem(FactionsD.getMenuConfig().getInt(factionInformationSlot), FactionMemberItems.factionInformation(p));
		inv.setItem(FactionsD.getMenuConfig().getInt(factionMembersSlot), FactionMemberItems.factionListMembers());
		inv.setItem(FactionsD.getMenuConfig().getInt(factionQuitSlot), FactionMemberItems.factionMemberQuit());
		inv.setItem(FactionsD.getMenuConfig().getInt(factionListSlot), FactionItems.factionsView());

		return inv;
	}
}
