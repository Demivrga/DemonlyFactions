package xyz.FactionsD.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import xyz.FactionsD.util.MessageUtil;

public class FactionItems {
	
	public static ItemStack factionInfo(String name) {
		
		ItemStack factionInformation = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta factionMeta = factionInformation.getItemMeta();
		
		factionMeta.setDisplayName(MessageUtil.translate(name));
		
		factionInformation.setItemMeta(factionMeta);
		
		return factionInformation;
		
	}
	
	public static ItemStack factionCreate() {

		ItemStack Test = new ItemStack(Material.WORKBENCH);
		ItemMeta TestMeta = Test.getItemMeta();

		// Set Lore/Name/Anything Else here
		TestMeta.setDisplayName("Create | Faction");

		// Append the Meta to the Item
		Test.setItemMeta(TestMeta);

		// Return the Item
		return Test;
	}

	public static ItemStack factionsView() {

		ItemStack Test = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta TestMeta = Test.getItemMeta();

		// Set Lore/Name/Anything Else here
		TestMeta.setDisplayName("Factions List");

		// Append the Meta to the Item
		Test.setItemMeta(TestMeta);

		// Return the Item
		return Test;
	}
	
	public static ItemStack factionInvites() {

		ItemStack Test = new ItemStack(Material.BREWING_STAND_ITEM);
		ItemMeta TestMeta = Test.getItemMeta();

		// Set Lore/Name/Anything Else here
		TestMeta.setDisplayName("Join | Factions");

		// Append the Meta to the Item
		Test.setItemMeta(TestMeta);

		// Return the Item
		return Test;
	}

	public static ItemStack factionList(String factionname, String owner) {

		ItemStack Test = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta TestMeta = Test.getItemMeta();

		// Set Lore/Name/Anything Else here
		TestMeta.setDisplayName(factionname);
		
		List<String> lore = new ArrayList<String>();
		lore.add(MessageUtil.translate("&fFaction Leader: "+owner));
		lore.add(MessageUtil.translate("&fFaction Money: "));
		lore.add(MessageUtil.translate("&fFaction MOTD: "));
		TestMeta.setLore(lore);

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
	
	public static ItemStack Return() {

		// Create the ItemStack and get the ItemMeta
		ItemStack ArrowForward = new ItemStack(Material.BLAZE_POWDER);
		ItemMeta ArrowForwardMeta = ArrowForward.getItemMeta();

		// Set Lore/Name/Anything Else here
		ArrowForwardMeta.setDisplayName("Return");

		// Append the Meta to the Item
		ArrowForward.setItemMeta(ArrowForwardMeta);

		// Return the Item
		return ArrowForward;
	}
}
