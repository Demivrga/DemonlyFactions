package xyz.FactionsD.menu.faction.members;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import xyz.FactionsD.factions.FactionsHandler;
import xyz.FactionsD.factions.FactionsManager;
import xyz.FactionsD.items.FactionItems;
import xyz.FactionsD.util.MessageUtil;

public class FactionMembersMenu {

	public static String Title = MessageUtil.translate("&7&lFaction&f - Members " + "#");

	public static Inventory factionsList(int page, String factionname) {
		Inventory list = Bukkit.createInventory(null, 54, Title + page);

		// Because we only want to list 45 factions on any given page.
		// We're going to use an equation to get the start of what
		// faction needs to be on that page.

		// 45 *(1 - 1) + 1 = 1
		// 45 *(2 - 1) + 1 = 46
		// 45 *(3 - 1) + 1 = 91

		int first = 45 * (page - 1) + 1;
		int last = 45 * page;
		int i = 1;

		FactionsManager fm = FactionsHandler.getFaction(factionname);

		OfflinePlayer owner = Bukkit.getOfflinePlayer(fm.getFactionOwnerUUID());

		if ((1 >= first) && (1 <= last)) {
			if (owner.getName() != null) {
				list.addItem(new ItemStack[] { FactionItems.factionMember(owner, owner.getName()) });
				i++;
			} else {
				list.addItem(new ItemStack[] { FactionItems.factionMember(owner, owner.getUniqueId().toString()) });
				i++;
			}
		}

		for (String mods : fm.getFactionModsUUID()) {
			OfflinePlayer mod = Bukkit.getOfflinePlayer(UUID.fromString(mods));

			if ((i >= first) && (i <= last)) {
				if (mod.getName() != null) {
					list.addItem(new ItemStack[] { FactionItems.factionMember(mod, mod.getName()) });
				} else {
					list.addItem(new ItemStack[] { FactionItems.factionMember(mod, mod.getUniqueId().toString()) });
				}
			}
			i++;
		}

		for (String members : fm.getFactionMembersUUID()) {
			OfflinePlayer member = Bukkit.getOfflinePlayer(UUID.fromString(members));

			if ((i >= first) && (i <= last)) {
				if (member.getName() != null) {
					list.addItem(new ItemStack[] { FactionItems.factionMember(member, member.getName()) });

				} else {
					list.addItem(
							new ItemStack[] { FactionItems.factionMember(member, member.getUniqueId().toString()) });
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
