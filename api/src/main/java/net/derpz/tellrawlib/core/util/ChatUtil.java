package net.derpz.tellrawlib.core.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ChatUtil {

    private String prefix;

    public ChatUtil() {

    }

    /**
     * Constructs chatUtil with prefix
     * @param prefix The prefix of the plugin
     */
    public ChatUtil(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Translate alternate colour code "&amp;".
     * I wrote this because the bukkit function is way too long
     * @param input Input containing alternate colour codes
     * @return Translated output containing coloured strings
     */
    public static String colour(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

    /**
     * Inserts a prefix before a String.
     * Automatically translates alternate colour codes
     * Properly spaces the prefix.
     * Removes leading and trailing spaces from prefix, if any.
     * Resets the colour code after the prefix
     * @param input the input
     * @return Translated output with the prefixed
     */
    public String withPrefix(String input) {
        return colour(prefix.trim() + " &r" + input);
    }

    /**
     * Inserts a prefix before a String
     * @param prefix The prefix to be inserted
     * @param input The input text
     * @return Prefixed, ChatColor translated output
     */
    public static String withPrefix(String prefix, String input) {
        return colour(prefix.trim() + " &r" + input);
    }

    /**
     * Sends a message
     * Automatically translates colour codes
     * @param c The recipient
     * @param m The message
     */
    public static void sendMsg(CommandSender c, String m) {
        c.sendMessage(colour(m));
    }

    /**
     * Sends a prefixed message
     * Prepends with prefix, automatically translates colour codes
     * @param c The recipient
     * @param m The message to be prefixed
     */
    public void sendPrefixedMsg(CommandSender c, String m) {
        c.sendMessage(withPrefix(m));
    }

    /**
     * Sends a prefixed message
     * Prepends with prefix, automatically translates colour codes
     * @param c The recipient
     * @param prefix The prefix
     * @param m The message to be prefixed
     */
    public static void sendPrefixedMsg(CommandSender c, String prefix, String m) {
        c.sendMessage(withPrefix(prefix, m));
    }
}
