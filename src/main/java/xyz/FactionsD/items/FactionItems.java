package xyz.FactionsD.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import xyz.FactionsD.FactionsD;
import xyz.FactionsD.util.MessageUtil;

public class FactionItems {

	// No-Faction Menu:
	private static String factionCreateMaterial = "Items.Menu.No_Faction_Menu.Faction_Create.material";
	private static String factionCreateName = "Items.Menu.No_Faction_Menu.Faction_Create.name";
	private static String factionCreateLore = "Items.Menu.No_Faction_Menu.Faction_Create.lore";
	private static String factionListMaterial = "Items.Menu.No_Faction_Menu.Faction_List.material";
	private static String factionListName = "Items.Menu.No_Faction_Menu.Faction_List.name";
	private static String factionListLore = "Items.Menu.No_Faction_Menu.Faction_List.lore";
	private static String factionInvitesMaterial = "Items.Menu.No_Faction_Menu.Faction_Invites.material";
	private static String factionInvitesName = "Items.Menu.No_Faction_Menu.Faction_Invites.name";
	private static String factionInvitesLore = "Items.Menu.No_Faction_Menu.Faction_Invites.lore";

	public static ItemStack factionCreate() {
		ItemStack Test = new ItemStack(
				Material.getMaterial(FactionsD.getMenuConfig().getString(factionCreateMaterial)));
		ItemMeta TestMeta = Test.getItemMeta();

		// Set Lore/Name/Anything Else here
		TestMeta.setDisplayName(MessageUtil.translate(FactionsD.getMenuConfig().getString(factionCreateName)));
		TestMeta.setLore(MessageUtil.listTranslate(FactionsD.getMenuConfig().getStringList(factionCreateLore)));

		// Append the Meta to the Item
		Test.setItemMeta(TestMeta);

		// Return the Item
		return Test;
	}

	public static ItemStack factionsView() {
		ItemStack Test = new ItemStack(Material.getMaterial(FactionsD.getMenuConfig().getString(factionListMaterial)));
		ItemMeta TestMeta = Test.getItemMeta();

		TestMeta.setDisplayName(MessageUtil.translate(FactionsD.getMenuConfig().getString(factionListName)));
		TestMeta.setLore(MessageUtil.listTranslate(FactionsD.getMenuConfig().getStringList(factionListLore)));

		Test.setItemMeta(TestMeta);

		return Test;
	}

	public static ItemStack factionInvites() {
		ItemStack Test = new ItemStack(
				Material.getMaterial(FactionsD.getMenuConfig().getString(factionInvitesMaterial)));
		ItemMeta TestMeta = Test.getItemMeta();

		TestMeta.setDisplayName(MessageUtil.translate(FactionsD.getMenuConfig().getString(factionInvitesName)));
		TestMeta.setLore(MessageUtil.listTranslate(FactionsD.getMenuConfig().getStringList(factionInvitesLore)));

		Test.setItemMeta(TestMeta);

		return Test;
	}

	// Faction Factory Item
	public static ItemStack factionPaperCreate() {
		ItemStack Test = new ItemStack(Material.PAPER);
		ItemMeta TestMeta = Test.getItemMeta();

		TestMeta.setDisplayName(MessageUtil.translate("&aType Faction Name"));

		List<String> lore = new ArrayList<String>();
		lore.add(MessageUtil.translate("&7Type in the main box to name your faction"));
		lore.add(MessageUtil.translate("&7Click the renamed item to finalize your faction name"));
		TestMeta.setLore(lore);

		Test.setItemMeta(TestMeta);

		return Test;
	}

	public static ItemStack factionList(String factionname, String owner) {
		ItemStack Test = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta TestMeta = Test.getItemMeta();

		TestMeta.setDisplayName(factionname);

		List<String> lore = new ArrayList<String>();
		TestMeta.setLore(lore);

		Test.setItemMeta(TestMeta);

		return Test;
	}

	// Utility Items
	public static ItemStack areYouSure() {
		ItemStack ArrowForward = new ItemStack(Material.BARRIER);
		ItemMeta ArrowForwardMeta = ArrowForward.getItemMeta();

		ArrowForwardMeta.setDisplayName("Are you sure?");

		ArrowForward.setItemMeta(ArrowForwardMeta);

		return ArrowForward;
	}

	public static ItemStack ArrowBack() {
		ItemStack ArrowBack = new ItemStack(Material.ARROW);
		ItemMeta ArrowBackMeta = ArrowBack.getItemMeta();

		ArrowBackMeta.setDisplayName("Previous");

		ArrowBack.setItemMeta(ArrowBackMeta);

		return ArrowBack;
	}

	public static ItemStack ArrowForward() {
		ItemStack ArrowForward = new ItemStack(Material.ARROW);
		ItemMeta ArrowForwardMeta = ArrowForward.getItemMeta();

		ArrowForwardMeta.setDisplayName("Forward");

		ArrowForward.setItemMeta(ArrowForwardMeta);

		return ArrowForward;
	}

	public static ItemStack Return() {
		ItemStack ArrowForward = new ItemStack(Material.BLAZE_POWDER);
		ItemMeta ArrowForwardMeta = ArrowForward.getItemMeta();

		ArrowForwardMeta.setDisplayName("Return");

		ArrowForward.setItemMeta(ArrowForwardMeta);

		return ArrowForward;
	}
}
