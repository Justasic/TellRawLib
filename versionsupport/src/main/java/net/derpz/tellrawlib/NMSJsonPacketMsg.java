package net.derpz.tellrawlib;

import org.bukkit.entity.Player;

public interface NMSJsonPacketMsg {
    /**
     * Sends a JSON message
     * You should not be accessing this directly.
     * @param p Player to send the message to. Must be castable to CraftPlayer
     * @param m JSON string which will be used as the message
     */
    public void sendMsg(Player p, String m);
}
