package xyz.FactionsD.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import xyz.FactionsD.factions.FactionsHandler;
import xyz.FactionsD.menu.FactionsLess;
import xyz.FactionsD.menu.FactionsMember;

public class Faction implements CommandExecutor {

	public boolean onCommand(CommandSender cs, Command cmd, String lbl, String[] args) {

		if (cs instanceof Player) {

			Player p = (Player) cs;

			if (lbl.equalsIgnoreCase("faction")) {

				String FactionName = FactionsHandler.getPlayersFaction(p.getUniqueId());

				if (FactionName != null) {
					p.openInventory(FactionsMember.memberFaction(" " + FactionName));
				} else {
					p.openInventory(FactionsLess.noFaction());
				}
			}
		}
		return false;
	}
}