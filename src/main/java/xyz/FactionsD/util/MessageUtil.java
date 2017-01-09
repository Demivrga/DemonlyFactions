package xyz.FactionsD.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class MessageUtil {
	
	public static String translate(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public static List<String> listTranslate(List<String> list) {

		List<String> converted = new ArrayList<String>();
		
		for (String string : list) {
			converted.add(ChatColor.translateAlternateColorCodes('&', string));
		}

		return converted;
	}

}
