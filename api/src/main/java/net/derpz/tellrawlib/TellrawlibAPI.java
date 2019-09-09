package net.derpz.tellrawlib;

import net.derpz.tellrawlib.core.components.MessageComponent;
import net.derpz.tellrawlib.core.components.MessageComponentPrimitive;
import net.derpz.tellrawlib.exceptions.VersionUnsupportedException;
import org.bukkit.entity.Player;

/**
 * Created by xiurobert on 03-Sep-19.
 */
public class TellrawlibAPI {

    public TellrawlibAPI() {

    }

    public static void sendMessage(Player p, MessageComponent m) throws VersionUnsupportedException {
        VersionSupportHandler.getNmsJsonPacketMsg().sendMsg(p, m.getJsonString());
    }

    public static void sendMessage(Player p, MessageComponentPrimitive m) throws VersionUnsupportedException {
        VersionSupportHandler.getNmsJsonPacketMsg().sendMsg(p, m.getJsonString());
    }

    public static void broadcast(MessageComponent m) throws VersionUnsupportedException {
        VersionSupportHandler.getNmsJsonPacketMsg().broadcast(m.getJsonString());
    }

    public static void broadcast(MessageComponentPrimitive m) throws VersionUnsupportedException {
        VersionSupportHandler.getNmsJsonPacketMsg().broadcast(m.getJsonString());
    }

}
