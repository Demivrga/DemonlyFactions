package xyz.FactionsD.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import xyz.FactionsD.factions.FactionsHandler;
import xyz.FactionsD.factions.FactionsManager;
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
			
			if (lbl.equalsIgnoreCase("create")) {
				if (!(args.length == 2)) {
					p.sendMessage("Wrong Format: /create FactionName");

				} else {
					String FactionName = FactionsHandler.getPlayersFaction(p.getUniqueId());

					if (FactionName != null) {
						p.sendMessage("You're already in a faction!");

					} else {
						if (FactionsHandler.getFaction(args[0]) != null) {
							p.sendMessage("That faction already exists! Try a new name!");

						} else {
							// Creating our faction
							FactionsManager fm = new FactionsManager();
							List<String> mods = new ArrayList<String>();
							fm.setFactionName(args[0]);
							fm.setFactionOwner(p.getUniqueId());
							fm.setFactionMembersUUID(mods);
							fm.setFactionModsUUID(mods);
							fm.setFactionMoney(Integer.parseInt(args[1]));

							FactionsHandler.addFaction(fm.getFactionName(), fm);
							p.sendMessage("Faction " + fm.getFactionName() + " has been created!");
						}
					}
				}
			}
		}
		return false;
	}
}