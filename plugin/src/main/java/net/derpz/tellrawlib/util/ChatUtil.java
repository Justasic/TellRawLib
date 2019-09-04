package net.derpz.tellrawlib.util;

import org.bukkit.ChatColor;

public final class ChatUtil {

    /**
     * Translate alternate colour code "&".
     * I wrote this because the bukkit function is way too long
     * @param input Input containing alternate colour codes
     * @return Translated output containing coloured strings
     */
    public static String colour(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
}
