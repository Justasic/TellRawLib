package net.derpz.tellrawlib.nms;

import net.derpz.tellrawlib.NMSJsonPacketMsg;
import net.minecraft.server.v1_9_R2.IChatBaseComponent;
import net.minecraft.server.v1_9_R2.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Created by xiurobert on 07-Sep-19.
 */
public class JSONPacketMsgv1_9_R2 implements NMSJsonPacketMsg {
    @Override
    public void sendMsg(Player p, String m) {
        PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a(m));
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packetPlayOutChat);
    }
}
