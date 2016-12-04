package xyz.FactionsD.menu.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FactionItems {
	
	public static ItemStack createFaction() {

		ItemStack Test = new ItemStack(Material.WORKBENCH);
		ItemMeta TestMeta = Test.getItemMeta();

		// Set Lore/Name/Anything Else here
		TestMeta.setDisplayName("Create | Gang");

		// Append the Meta to the Item
		Test.setItemMeta(TestMeta);

		// Return the Item
		return Test;
	}

	public static ItemStack viewFactions() {

		ItemStack Test = new ItemStack(Material.BLAZE_ROD);
		ItemMeta TestMeta = Test.getItemMeta();

		// Set Lore/Name/Anything Else here
		TestMeta.setDisplayName("View | Factions");

		// Append the Meta to the Item
		Test.setItemMeta(TestMeta);

		// Return the Item
		return Test;
	}
	
	public static ItemStack joinFactions() {

		ItemStack Test = new ItemStack(Material.BREWING_STAND_ITEM);
		ItemMeta TestMeta = Test.getItemMeta();

		// Set Lore/Name/Anything Else here
		TestMeta.setDisplayName("Join | Factions");

		// Append the Meta to the Item
		Test.setItemMeta(TestMeta);

		// Return the Item
		return Test;
	}

	public static ItemStack factionItem(String factionname) {

		ItemStack Test = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta TestMeta = Test.getItemMeta();

		// Set Lore/Name/Anything Else here
		TestMeta.setDisplayName(factionname);

		// Append the Meta to the Item
		Test.setItemMeta(TestMeta);

		// Return the Item
		return Test;
	}
	
	public static ItemStack ArrowBack() {

		// Create the ItemStack and get the ItemMeta
		ItemStack ArrowBack = new ItemStack(Material.ARROW);
		ItemMeta ArrowBackMeta = ArrowBack.getItemMeta();

		// Set Lore/Name/Anything Else here
		ArrowBackMeta.setDisplayName("Previous");

		// Append the Meta to the Item
		ArrowBack.setItemMeta(ArrowBackMeta);

		// Return the Item
		return ArrowBack;
	}

	public static ItemStack ArrowForward() {

		// Create the ItemStack and get the ItemMeta
		ItemStack ArrowForward = new ItemStack(Material.ARROW);
		ItemMeta ArrowForwardMeta = ArrowForward.getItemMeta();

		// Set Lore/Name/Anything Else here
		ArrowForwardMeta.setDisplayName("Forward");

		// Append the Meta to the Item
		ArrowForward.setItemMeta(ArrowForwardMeta);

		// Return the Item
		return ArrowForward;
	}
}
