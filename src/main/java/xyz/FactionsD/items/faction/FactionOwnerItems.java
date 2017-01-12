package xyz.FactionsD.items.faction;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import xyz.FactionsD.FactionsD;
import xyz.FactionsD.util.MessageUtil;

public class FactionOwnerItems {

	private static String factionDisbandMaterial = "Items.Menu.Faction_Owner.Faction_Disband.material";
	private static String factionDisbandName = "Items.Menu.Faction_Owner.Faction_Disband.name";
	private static String factionDisbandLore = "Items.Menu.Faction_Owner.Faction_Disband.lore";
	
	private static String factionSettingsMaterial = "Items.Menu.Faction_Owner.Faction_Settings.material";
	private static String factionSettingsName = "Items.Menu.Faction_Owner.Faction_Settings.name";
	private static String factionSettingsLore = "Items.Menu.Faction_Owner.Faction_Settings.lore";

	public static ItemStack factionDisband() {
		ItemStack Test = new ItemStack(
				Material.getMaterial(FactionsD.getMenuConfig().getString(factionDisbandMaterial)));
		ItemMeta TestMeta = Test.getItemMeta();

		TestMeta.setDisplayName(MessageUtil.translate(FactionsD.getMenuConfig().getString(factionDisbandName)));

		TestMeta.setLore(MessageUtil.listTranslate(FactionsD.getMenuConfig().getStringList(factionDisbandLore)));

		Test.setItemMeta(TestMeta);

		return Test;
	}
	
	public static ItemStack factionSettings() {
		ItemStack Test = new ItemStack(
				Material.getMaterial(FactionsD.getMenuConfig().getString(factionSettingsMaterial)));
		ItemMeta TestMeta = Test.getItemMeta();

		TestMeta.setDisplayName(MessageUtil.translate(FactionsD.getMenuConfig().getString(factionSettingsName)));

		TestMeta.setLore(MessageUtil.listTranslate(FactionsD.getMenuConfig().getStringList(factionSettingsLore)));

		Test.setItemMeta(TestMeta);

		return Test;
	}

}
