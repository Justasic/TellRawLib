package net.derpz.tellrawlib;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class VersionSupportHandler {

    private String version;
    private NMSJsonPacketMsg nmsJsonPacketMsg;
    private List<String> supportedVersions = new ArrayList<String>(){{
        add("v1_9_R1");
        add("v1_9_R2");
        add("v1_10_R1");
        add("v_11_R1");
        add("v1_12_R1");
        add("v1_13_R1");
        add("v1_13_R2");
        add("v1_14_R1");
    }};

    /*
     * Construct the support handler
     * @param server Server returned from getServer()
     */
    public VersionSupportHandler(Server server) {
        try {
            version = server.getClass()
                    .getPackage().getName()
                    .replace(".", ",").split(",")[3];
        } catch (ArrayIndexOutOfBoundsException ignored) {
            // impossible
        }
    }

    private boolean checkIfVersionSupported() {
        return supportedVersions.contains(version);
    }

    public List<String> getSupportedVersions() {
        return supportedVersions;
    }

    public NMSJsonPacketMsg getNmsJsonPacketMsg() {
        if (!checkIfVersionSupported()) {
            // Cannot support version
            return null;
        }

        switch(version) {
            // TODO: Add in version handling
        }
        return null;
    }

}
