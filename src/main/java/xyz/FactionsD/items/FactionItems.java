package xyz.FactionsD.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

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

		ItemStack Test = new ItemStack(Material.ANVIL);
		ItemMeta TestMeta = Test.getItemMeta();

		// Set Lore/Name/Anything Else here
		TestMeta.setDisplayName(MessageUtil.translate("&4Create a Faction"));

		List<String> lore = new ArrayList<String>();
		lore.add(MessageUtil.translate("&7Create your own faction!"));
		TestMeta.setLore(lore);

		// Append the Meta to the Item
		Test.setItemMeta(TestMeta);

		// Return the Item
		return Test;
	}
	
	public static ItemStack factionPaperCreate() {

		ItemStack Test = new ItemStack(Material.PAPER);
		ItemMeta TestMeta = Test.getItemMeta();

		// Set Lore/Name/Anything Else here
		TestMeta.setDisplayName(MessageUtil.translate("&aType Faction Name"));

		List<String> lore = new ArrayList<String>();
		lore.add(MessageUtil.translate("&7Type in the main box to name your faction"));
		lore.add(MessageUtil.translate("&7Click the renamed item to finalize your faction name"));
		TestMeta.setLore(lore);

		// Append the Meta to the Item
		Test.setItemMeta(TestMeta);

		// Return the Item
		return Test;
	}

	public static ItemStack factionsView() {

		ItemStack Test = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta TestMeta = Test.getItemMeta();

		// Set Lore/Name/Anything Else here
		TestMeta.setDisplayName(MessageUtil.translate("&aView Factions"));

		List<String> lore = new ArrayList<String>();
		lore.add(MessageUtil.translate("&7View currently functioning Factions"));
		TestMeta.setLore(lore);

		// Append the Meta to the Item
		Test.setItemMeta(TestMeta);

		// Return the Item
		return Test;
	}
	
	public static ItemStack factionInvites() {

		ItemStack Test = new ItemStack(Material.VINE);
		ItemMeta TestMeta = Test.getItemMeta();

		// Set Lore/Name/Anything Else here
		TestMeta.setDisplayName(MessageUtil.translate("&bFaction Invites"));

		List<String> lore = new ArrayList<String>();
		lore.add(MessageUtil.translate("&7View which factions have invited you"));
		TestMeta.setLore(lore);
		
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
	
	public static ItemStack factionLeave() {

		// Create the ItemStack and get the ItemMeta
		ItemStack ArrowForward = new ItemStack(Material.NETHER_STAR);
		ItemMeta ArrowForwardMeta = ArrowForward.getItemMeta();

		// Set Lore/Name/Anything Else here
		ArrowForwardMeta.setDisplayName("Leave Faction");

		// Append the Meta to the Item
		ArrowForward.setItemMeta(ArrowForwardMeta);

		// Return the Item
		return ArrowForward;
	}
	
	public static ItemStack areYouSure() {

		// Create the ItemStack and get the ItemMeta
		ItemStack ArrowForward = new ItemStack(Material.BARRIER);
		ItemMeta ArrowForwardMeta = ArrowForward.getItemMeta();

		// Set Lore/Name/Anything Else here
		ArrowForwardMeta.setDisplayName("Are you sure?");

		// Append the Meta to the Item
		ArrowForward.setItemMeta(ArrowForwardMeta);

		// Return the Item
		return ArrowForward;
	}
	
	public static ItemStack factionMembers() {

		// Create the ItemStack and get the ItemMeta
		ItemStack Test = new ItemStack(Material.FIREBALL);
		ItemMeta TestMeta = Test.getItemMeta();

		// Set Lore/Name/Anything Else here
		TestMeta.setDisplayName(MessageUtil.translate("&8Faction Members"));
		
		List<String> lore = new ArrayList<String>();
		lore.add(MessageUtil.translate("&7View your factions members"));
		TestMeta.setLore(lore);

		// Append the Meta to the Item
		Test.setItemMeta(TestMeta);

		// Return the Item
		return Test;
	}
	
	public static ItemStack factionMember(OfflinePlayer p, String name) {

		// Create the ItemStack and get the ItemMeta
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta skullmeta = (SkullMeta) skull.getItemMeta();

		// Set Lore/Name/Anything Else here
		skullmeta.setOwner(p.getName());
		skullmeta.setDisplayName(name);

		// Lore
		List<String> lore = new ArrayList<String>();
		skullmeta.setLore(lore);
		
		// Append the Meta to the Item
		skull.setItemMeta(skullmeta);

		// Return the Item
		return skull;
	}
}
