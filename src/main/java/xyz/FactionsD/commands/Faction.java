package xyz.FactionsD.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import xyz.FactionsD.menu.FactionsLess;

public class Faction implements CommandExecutor {

	public boolean onCommand(CommandSender cs, Command cmd, String lbl, String[] args) {

		if (cs instanceof Player) {
			if (!lbl.equalsIgnoreCase("faction")) {
				((Player) cs).openInventory(FactionsLess.noFaction());
			} else {
				((Player) cs).openInventory(FactionsLess.noFaction());
			}
		}
		return false;
	}
}