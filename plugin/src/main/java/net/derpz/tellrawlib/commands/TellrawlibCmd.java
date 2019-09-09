package net.derpz.tellrawlib.commands;

import net.derpz.tellrawlib.TellrawPlugin;
import net.derpz.tellrawlib.TellrawlibAPI;
import net.derpz.tellrawlib.core.components.MessageComponent;
import net.derpz.tellrawlib.core.enums.Color;
import net.derpz.tellrawlib.core.enums.Formatting;
import net.derpz.tellrawlib.core.events.ClickEvent;
import net.derpz.tellrawlib.core.util.ChatUtil;
import net.derpz.tellrawlib.exceptions.VersionUnsupportedException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TellrawlibCmd implements CommandExecutor {

    private TellrawPlugin plugin;

    public TellrawlibCmd(TellrawPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            MessageComponent messageComponent = new MessageComponent("&cPussy!");
            messageComponent.addFormatting(Formatting.UNDERLINE);
            messageComponent.addFormatting(Formatting.BOLD);
            messageComponent.setColor(Color.AQUA);
            messageComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help"));
            try {
                TellrawlibAPI.sendMessage((Player) commandSender, messageComponent);
            } catch (VersionUnsupportedException e) {
                e.printStackTrace();
            }
            return true;
        }

        return false;
    }
}
