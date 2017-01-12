package xyz.FactionsD.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import xyz.FactionsD.factions.FactionsHandler;
import xyz.FactionsD.menu.faction.FactionNoneMenu;
import xyz.FactionsD.menu.faction.members.FactionMemberMenu;
import xyz.FactionsD.menu.faction.owner.FactionOwnerMenu;

public class Faction implements CommandExecutor {

	public boolean onCommand(CommandSender cs, Command cmd, String lbl, String[] args) {

		if (cs instanceof Player) {

			Player p = (Player) cs;

			if (lbl.equalsIgnoreCase("faction")) {

				String factionName = FactionsHandler.getPlayersFaction(p.getUniqueId());

				if (factionName != null) {

					String factionRank = FactionsHandler.getPlayersFactionRank(p.getUniqueId(), factionName);

					if (factionRank.equals("Member")) {
						p.openInventory(FactionMemberMenu.factionMember(p));
					}

					if (factionRank.equals("Mod")) {
						p.openInventory(FactionMemberMenu.factionMember(p));
					}

					if (factionRank.equals("Owner")) {
						p.openInventory(FactionOwnerMenu.factionOwnerMenu(p));
					}
				} else {
					p.openInventory(FactionNoneMenu.noFaction());
				}
			}
		}
		return false;
	}
}