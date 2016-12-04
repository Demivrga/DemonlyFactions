package xyz.FactionsD.menu.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {
	
	public static ItemStack viewFactions() {

			ItemStack Test = new ItemStack(Material.BARRIER);
			ItemMeta TestMeta = Test.getItemMeta();

			// Set Lore/Name/Anything Else here
			TestMeta.setDisplayName("Test");

			// Append the Meta to the Item
			Test.setItemMeta(TestMeta);

			// Return the Item
			return Test;
	}
}
