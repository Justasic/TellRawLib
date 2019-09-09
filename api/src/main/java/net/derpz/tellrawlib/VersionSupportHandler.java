package net.derpz.tellrawlib;

import net.derpz.tellrawlib.nms.*;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class VersionSupportHandler {

    private static String version;
    private static NMSJsonPacketMsg nmsJsonPacketMsg;
    private static List<String> supportedVersions = new ArrayList<String>(){{
        add("v1_8_R1");
        add("v1_8_R2");
        add("v1_8_R3");
        add("v1_9_R1");
        add("v1_9_R2");
        add("v1_10_R1");
        add("v_11_R1");
        add("v1_12_R1");
        add("v1_13_R1");
        add("v1_13_R2");
        add("v1_14_R1");
    }};


    public static List<String> getSupportedVersions() {
        return supportedVersions;
    }

    public static NMSJsonPacketMsg getNmsJsonPacketMsg() throws VersionUnsupportedException {
        try {
            version = Bukkit.getServer().getClass()
                    .getPackage().getName()
                    .replace(".", ",").split(",")[3];
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        if (!supportedVersions.contains(version)) {
            Bukkit.getServer().getLogger().severe("TellrawLib <API>: This version is not supported!");
            throw new VersionUnsupportedException("Current NMS version '" + version + "' is unsupported.");
        }

        switch(version) {
            case "v1_8_R1":
                return new JSONPacketMsgv1_8_R1();
            case "v1_8_R2":
                return new JSONPacketMsgv1_8_R2();
            case "v1_8_R3":
                return new JSONPacketMsgv1_8_R3();
            case "v1_9_R1":
                return new JSONPacketMsgv1_9_R1();
            case "v1_9_R2":
                return new JSONPacketMsgv1_9_R2();
            case "v1_10_R1":
                return new JSONPacketMsgv1_10_R1();
            case "v1_11_R1":
                return new JSONPacketMsgv1_11_R1();
            case "v1_12_R1":
                return new JSONPacketMsgv1_12_R1();
            default:
                // Should never be reached, but is a good safety net
                throw new VersionUnsupportedException("Current NMS version '" + version + "' is unsupported.");
        }
    }



}
