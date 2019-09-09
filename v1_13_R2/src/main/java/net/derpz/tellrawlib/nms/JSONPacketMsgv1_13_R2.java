package net.derpz.tellrawlib.nms;

import net.derpz.tellrawlib.NMSJsonPacketMsg;
import net.minecraft.server.v1_13_R2.IChatBaseComponent;
import net.minecraft.server.v1_13_R2.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class JSONPacketMsgv1_13_R2 implements NMSJsonPacketMsg {
    @Override
    public void sendMsg(Player p, String m) {
        PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a(m));
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packetPlayOutChat);
    }

    @Override
    public void broadcast(String m) {
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            sendMsg(p, m);
        }
    }
}
