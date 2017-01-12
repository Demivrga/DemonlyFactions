package xyz.FactionsD.menu.faction.members;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import xyz.FactionsD.factions.FactionsHandler;
import xyz.FactionsD.factions.FactionsManager;
import xyz.FactionsD.items.FactionItems;
import xyz.FactionsD.items.faction.FactionMemberItems;
import xyz.FactionsD.util.MessageUtil;

public class FactionMembersMenu {

	public static String Title = MessageUtil.translate("&7&lFaction&f - Members " + "#");

	public static Inventory factionsList(int page, String factionname) {
		Inventory list = Bukkit.createInventory(null, 54, Title + page);

		int first = 45 * (page - 1) + 1;
		int last = 45 * page;
		int i = 1;

		FactionsManager fm = FactionsHandler.getFaction(factionname);

		OfflinePlayer owner = Bukkit.getOfflinePlayer(fm.getFactionOwnerUUID());

		if ((1 >= first) && (1 <= last)) {
			if (owner.getName() != null) {
				list.addItem(new ItemStack[] { FactionMemberItems.factionMember(owner, owner.getName()) });
				i++;
			} else {
				list.addItem(
						new ItemStack[] { FactionMemberItems.factionMember(owner, owner.getUniqueId().toString()) });
				i++;
			}
		}

		for (String mods : fm.getFactionModsUUID()) {
			OfflinePlayer mod = Bukkit.getOfflinePlayer(UUID.fromString(mods));

			if ((i >= first) && (i <= last)) {
				if (mod.getName() != null) {
					list.addItem(new ItemStack[] { FactionMemberItems.factionMember(mod, mod.getName()) });
				} else {
					list.addItem(
							new ItemStack[] { FactionMemberItems.factionMember(mod, mod.getUniqueId().toString()) });
				}
			}
			i++;
		}

		for (String members : fm.getFactionMembersUUID()) {
			OfflinePlayer member = Bukkit.getOfflinePlayer(UUID.fromString(members));

			if ((i >= first) && (i <= last)) {
				if (member.getName() != null) {
					list.addItem(new ItemStack[] { FactionMemberItems.factionMember(member, member.getName()) });

				} else {
					list.addItem(new ItemStack[] {
							FactionMemberItems.factionMember(member, member.getUniqueId().toString()) });
				}
			}
			i++;
		}

		list.setItem(50, FactionItems.ArrowForward());
		list.setItem(49, FactionItems.Return());
		list.setItem(48, FactionItems.ArrowBack());

		return list;
	}

}
