package xyz.FactionsD.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import xyz.FactionsD.factions.FactionsHandler;
import xyz.FactionsD.menu.faction.FactionNoneMenu;
import xyz.FactionsD.menu.faction.members.FactionMemberMenu;

public class Faction implements CommandExecutor {

	public boolean onCommand(CommandSender cs, Command cmd, String lbl, String[] args) {

		if (cs instanceof Player) {

			Player p = (Player) cs;

			if (lbl.equalsIgnoreCase("faction")) {

				String FactionName = FactionsHandler.getPlayersFaction(p.getUniqueId());

				if (FactionName != null) {
					p.openInventory(FactionMemberMenu.factionMember(FactionName));
				} else {
					p.openInventory(FactionNoneMenu.noFaction());
				}
			}
		}
		return false;
	}
}