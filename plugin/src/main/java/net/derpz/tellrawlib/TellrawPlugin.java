package net.derpz.tellrawlib;

import net.derpz.tellrawlib.commands.TellrawlibCmd;
import net.derpz.tellrawlib.core.util.ChatUtil;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by xiurobert on 03-Sep-19.
 */
public class TellrawPlugin extends JavaPlugin {

    private String prefix;
    private ChatUtil chatUtil;

    public void onEnable() {
        saveDefaultConfig();
        this.chatUtil = new ChatUtil(getConfig().getString("prefix"));
        chatUtil.sendPrefixedMsg(getServer().getConsoleSender(), "&e<TellRawLib: Plugin>&a Starting up...");

        getCommand("tellrawlib").setExecutor(new TellrawlibCmd(this));
    }

    public void onDisable() {
        chatUtil.sendPrefixedMsg(getServer().getConsoleSender(), "&e<TellRawLib: Plugin>&c Shutting down...");
    }

    public ChatUtil getChatUtil() {
        return chatUtil;
    }

}
