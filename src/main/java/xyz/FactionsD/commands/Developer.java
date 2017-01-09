package xyz.FactionsD.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import xyz.FactionsD.factions.FactionsHandler;
import xyz.FactionsD.factions.FactionsManager;

public class Developer implements CommandExecutor {

	public boolean onCommand(CommandSender cs, Command cmd, String lbl, String[] args) {

		if (cs instanceof Player) {

			Player p = (Player) cs;

			if (lbl.equalsIgnoreCase("developer")) {

				String FactionName = FactionsHandler.getPlayersFaction(p.getUniqueId());
				FactionsManager fm = new FactionsManager();

				if (args.length == 0) {
					p.sendMessage("Format: /developer <option>");

				}

				// cmd arg0 arg1 arg2 arg3
				// cmd length1 length2 length3
				// <><><><><><><><><><><><><><><><><>< //
				if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("create")) {

						if (!(args.length == 2)) {
							p.sendMessage("Format: /developer create <name>");

						} else {

							if (FactionName != null) {
								p.sendMessage("You're already in a faction!");
							} else {

								if (FactionsHandler.getFaction(args[1]) != null) {
									p.sendMessage("That faction already exists! Try a new name!");

								} else {
									List<String> mods = new ArrayList<String>();
									List<String> invites = new ArrayList<String>();

									// Creating our faction
									fm.setFactionName(args[1]);
									fm.setFactionOwner(p.getUniqueId());
									fm.setFactionInvites(invites);
									fm.setFactionMembersUUID(mods);
									fm.setFactionModsUUID(mods);
									fm.setFactionMoney(300);

									FactionsHandler.addFaction(fm.getFactionName(), fm);
									p.sendMessage("Faction " + fm.getFactionName() + " has been created!");
								}
							}
						}
					}
				}

				// <><><><><><><><><><><><><><><><><>< //
				if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("invite")) {
						if (!(args.length == 2)) {

							p.sendMessage("Format: /developer invite <name>");

						} else {
							if (FactionName != null) {

								String rank = FactionsHandler.getPlayersFactionRank(p.getUniqueId(), FactionName);
								Player invitee = Bukkit.getPlayer(args[1]);

								if (invitee != null) {
									if (FactionsHandler.getPlayersFaction(invitee.getUniqueId()) != null) {

										p.sendMessage("They already have a faction!");

									} else {
										if (FactionsHandler.listFactionInvites(FactionName) != null) {
											if (!FactionsHandler.listFactionInvites(FactionName)
													.contains(invitee.getUniqueId().toString())) {

												if (rank.equalsIgnoreCase("Mod")) {
													FactionsHandler.addFactionInvite(invitee.getUniqueId(),
															FactionName);
												}
												if (rank.equalsIgnoreCase("Owner")) {
													FactionsHandler.addFactionInvite(invitee.getUniqueId(),
															FactionName);
												}

											} else {
												p.sendMessage("They've already been invited!");
											}
										}
									}
								}
							}
						}
					}
				}

				// <><><><><><><><><><><><><><><><><>< //
				if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("join")) {
						if (!(args.length == 2)) {

							p.sendMessage("Format: /developer join <name>");

						} else {
							if (FactionName != null) {
								p.sendMessage("You're already in a faction!");
							} else {

								String joining = args[1];

								if (FactionsHandler.getFaction(joining).getFactionInvites()
										.contains(p.getUniqueId().toString())) {

									FactionsHandler.addFactionMember(p.getUniqueId(), joining);

									for (FactionsManager invfm : FactionsHandler.getLoadedFactions()) {

										if (invfm.getFactionInvites().contains(p.getUniqueId().toString())) {
											invfm.getFactionInvites().remove(p.getUniqueId().toString());
										}
									}
								}
							}
						}
					}
				}

				// <><><><><><><><><><><><><><><><><>< //
				if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("invites")) {
						if (FactionName == null) {

							List<String> invites = new ArrayList<String>();

							if (FactionsHandler.getLoadedFactions() != null) {
								for (FactionsManager fminv : FactionsHandler.getLoadedFactions()) {
									if (fminv.getFactionInvites() != null) {
										if (fminv.getFactionInvites().contains(p.getUniqueId().toString())) {
											invites.add(fminv.getFactionName());
										}
									}
								}
							}

							p.sendMessage(" ");
							p.sendMessage("=-=-=-=-=-=-=-=-=] Invites [-=-=-=-=-=-=-=-=-=");
							p.sendMessage(" ");
							p.sendMessage(invites.toString());
						} else {
							p.sendMessage("You're already in a faction! Stop trying to get invited!");
						}
					}
				}

				// <><><><><><><><><><><><><><><><><>< //
				if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("disband")) {
						if (FactionName != null) {

							String rank = FactionsHandler.getPlayersFactionRank(p.getUniqueId(), FactionName);

							if (rank.equalsIgnoreCase("Owner")) {
								p.sendMessage("You've disbaned your Faction!");
								FactionsHandler.deleteFaction(FactionName);
							}
						}
					}
				}

				// <><><><><><><><><><><><><><><><><>< //
				if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("leave")) {
						if (FactionName != null) {

							String rank = FactionsHandler.getPlayersFactionRank(p.getUniqueId(), FactionName);

							if (rank.equalsIgnoreCase("Owner")) {
								p.sendMessage("You must disband, you can't leave!");
							}
							if (rank.equalsIgnoreCase("Mod")) {
								FactionsHandler.removeFactionMod(p.getUniqueId(), FactionName);
							}
							if (rank.equalsIgnoreCase("Member")) {
								FactionsHandler.removeFactionMember(p.getUniqueId(), FactionName);
							}
						}
					}
				}

				// <><><><><><><><><><><><><><><><><>< //
				if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("info")) {
						if (FactionName != null) {

							OfflinePlayer target = Bukkit.getOfflinePlayer(FactionsHandler.listFactionOwner(FactionName));

							p.sendMessage(" ");
							p.sendMessage("=-=-=-=-=-=-=-=-=-] " + FactionName + " [-=-=-=-=-=-=-=-=-=");
							p.sendMessage(" ");
							p.sendMessage("Owner: " + target.getName());
							p.sendMessage("Members: " + FactionsHandler.listFactionMembers(FactionName));
							p.sendMessage("Invites: " + FactionsHandler.listFactionInvites(FactionName));

						} else {
							p.sendMessage("You're not in a faction!");
						}
					}
				}
			}
		}
		return false;
	}
}