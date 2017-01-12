package xyz.FactionsD.items.faction;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import xyz.FactionsD.FactionsD;
import xyz.FactionsD.factions.FactionsHandler;
import xyz.FactionsD.factions.FactionsManager;
import xyz.FactionsD.util.MessageUtil;

public class FactionMemberItems {

	private static String factionInfoMaterial = "Items.Menu.Faction_Member.Faction_Info.material";
	private static String factionInfoName = "Items.Menu.Faction_Member.Faction_Info.name";
	private static String factionInfoLore = "Items.Menu.Faction_Member.Faction_Info.lore";

	private static String factionMembersMaterial = "Items.Menu.Faction_Member.Faction_Members.material";
	private static String factionMembersName = "Items.Menu.Faction_Member.Faction_Members.name";
	private static String factionMembersLore = "Items.Menu.Faction_Member.Faction_Members.lore";

	private static String factionQuitMaterial = "Items.Menu.Faction_Member.Faction_Quit.material";
	private static String factionQuitName = "Items.Menu.Faction_Member.Faction_Quit.name";
	private static String factionQuitLore = "Items.Menu.Faction_Member.Faction_Quit.lore";

	public static ItemStack factionInformation(Player p) {
		ItemStack factionInformation = new ItemStack(
				Material.getMaterial(FactionsD.getMenuConfig().getString(factionInfoMaterial)));
		ItemMeta factionMeta = factionInformation.getItemMeta();

		String name = FactionsHandler.getPlayersFaction(p.getUniqueId());
		FactionsManager fm = FactionsHandler.getFaction(name);
		String converted = FactionsD.getMenuConfig().getString(factionInfoName).replaceAll("%faction%", name);
		converted.replaceAll("%Faction%", name);

		factionMeta.setDisplayName(MessageUtil.translate(converted));

		List<String> lore = FactionsD.getMenuConfig().getStringList(factionInfoLore);
		List<String> newLore = new ArrayList<String>();
		for (String x : lore) {

			OfflinePlayer owner = Bukkit.getOfflinePlayer(fm.getFactionOwnerUUID());
			newLore.add(x.replaceAll("%faction%", fm.getFactionName()).replaceAll("%moto%", fm.getFactionMoto())
					.replaceAll("%owner%", owner.getName()).replaceAll("%symbol%", fm.getFactionSymbol())
					.replaceAll("%rank%", FactionsHandler.getPlayersFactionRank(p.getUniqueId(), fm.getFactionName())));
		}

		factionMeta.setLore(MessageUtil.listTranslate(newLore));

		factionInformation.setItemMeta(factionMeta);

		return factionInformation;
	}

	public static ItemStack factionListMembers() {
		ItemStack Test = new ItemStack(
				Material.getMaterial(FactionsD.getMenuConfig().getString(factionMembersMaterial)));
		ItemMeta TestMeta = Test.getItemMeta();

		TestMeta.setDisplayName(MessageUtil.translate(FactionsD.getMenuConfig().getString(factionMembersName)));

		TestMeta.setLore(MessageUtil.listTranslate(FactionsD.getMenuConfig().getStringList(factionMembersLore)));

		Test.setItemMeta(TestMeta);

		return Test;
	}

	public static ItemStack factionMemberQuit() {
		ItemStack Test = new ItemStack(Material.getMaterial(FactionsD.getMenuConfig().getString(factionQuitMaterial)));
		ItemMeta TestMeta = Test.getItemMeta();

		TestMeta.setDisplayName(MessageUtil.translate(FactionsD.getMenuConfig().getString(factionQuitName)));

		TestMeta.setLore(MessageUtil.listTranslate(FactionsD.getMenuConfig().getStringList(factionQuitLore)));

		Test.setItemMeta(TestMeta);

		return Test;
	}

	public static ItemStack factionMember(OfflinePlayer p, String name) {
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta skullmeta = (SkullMeta) skull.getItemMeta();

		skullmeta.setOwner(p.getName());
		skullmeta.setDisplayName(name);

		List<String> lore = new ArrayList<String>();
		skullmeta.setLore(lore);

		skull.setItemMeta(skullmeta);

		return skull;
	}

}
