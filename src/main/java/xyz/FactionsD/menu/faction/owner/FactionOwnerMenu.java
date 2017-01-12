package xyz.FactionsD.menu.faction.owner;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import xyz.FactionsD.FactionsD;
import xyz.FactionsD.items.FactionItems;
import xyz.FactionsD.items.faction.FactionMemberItems;
import xyz.FactionsD.items.faction.FactionOwnerItems;
import xyz.FactionsD.util.MessageUtil;

public class FactionOwnerMenu {

	public static String Title = MessageUtil
			.translate(FactionsD.getMenuConfig().getString("Items.Menu.Faction_Owner.Title"));
	private static String menuSize = "Items.Menu.Faction_Owner.Menu_Size";
	private static String factionInformationSlot = "Items.Menu.Faction_Owner.Faction_Info.slot";
	private static String factionMembersSlot = "Items.Menu.Faction_Owner.Faction_Members.slot";
	private static String factionMemberInviteSlot = "Items.Menu.Faction_Owner.Faction_Member_Invite.slot";
	private static String factionMemberKickSlot = "Items.Menu.Faction_Owner.Faction_Member_Kick.slot";
	private static String factionSettingsSlot = "Items.Menu.Faction_Owner.Faction_Settings.slot";
	private static String factionDisbandSlot = "Items.Menu.Faction_Owner.Faction_Disband.slot";
	private static String factionListSlot = "Items.Menu.Faction_Owner.Faction_List.slot";

	public static Inventory factionOwnerMenu(Player p) {

		Inventory inv = Bukkit.createInventory(null, FactionsD.getMenuConfig().getInt(menuSize), Title);

		inv.setItem(FactionsD.getMenuConfig().getInt(factionInformationSlot), FactionMemberItems.factionInformation(p));
		inv.setItem(FactionsD.getMenuConfig().getInt(factionMembersSlot), FactionMemberItems.factionListMembers());
		inv.setItem(FactionsD.getMenuConfig().getInt(factionMemberInviteSlot), FactionMemberItems.factionListMembers());
		inv.setItem(FactionsD.getMenuConfig().getInt(factionMemberKickSlot), FactionMemberItems.factionListMembers());
		inv.setItem(FactionsD.getMenuConfig().getInt(factionDisbandSlot), FactionOwnerItems.factionDisband());
		inv.setItem(FactionsD.getMenuConfig().getInt(factionSettingsSlot), FactionOwnerItems.factionSettings());
		inv.setItem(FactionsD.getMenuConfig().getInt(factionListSlot), FactionItems.factionsView());

		return inv;
	}

}
