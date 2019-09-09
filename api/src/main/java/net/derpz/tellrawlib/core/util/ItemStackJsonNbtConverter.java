package net.derpz.tellrawlib.core.util;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Uses reflection on NMS and craftbukkit to obtain the ItemStack information
 */
public class ItemStackJsonNbtConverter {

    private String nmsString = "net.minecraft.server.";
    private String obString = "org.bukkit.craftbukkit.";

    private String nbtJson;

    private Plugin plugin;
    private Class<?> nbtTagCompound;
    private Method asNMSCopy;
    private Method saveNmsItemStack;

    /**
     * Uses black magic wizardry to generate a NBT JSON representation of an item
     * @param itemStack The ItemStack you wish to be converted
     * @param plugin The plugin
     */
    public ItemStackJsonNbtConverter(ItemStack itemStack, Plugin plugin){
        this.plugin = plugin;

        obtainClassesAndMethods();

        Object nbtTagCompoundObj;
        Object itemStackObj;
        Object itemsAsJsonObject;

        try {
            nbtTagCompoundObj = nbtTagCompound.newInstance();
            itemStackObj = asNMSCopy.invoke(null, itemStack);
            itemsAsJsonObject = saveNmsItemStack.invoke(itemStackObj, nbtTagCompoundObj);
            this.nbtJson = itemsAsJsonObject.toString();
        } catch (Exception e) {
            plugin.getLogger().severe("[ItemStackJsonNbtConverter] Could not call methods to convert " +
                    "NBT compound to JSON. Please report this to the plugin developer.");
            plugin.getLogger().severe(Arrays.toString(e.getStackTrace()));
        }

    }

    private void obtainClassesAndMethods() {
        String version  = plugin.getServer().getClass()
                .getPackage().getName()
                .replace(".", ",").split(",")[3];

        try {
            this.asNMSCopy = Class
                    .forName(obString + version + ".inventory.CraftItemStack")
                    .getMethod("asNMSCopy", ItemStack.class);
            this.nbtTagCompound = Class
                    .forName(nmsString + version + ".NBTTagCompound");
            this.saveNmsItemStack = Class
                    .forName(nmsString + version + ".ItemStack")
                    .getMethod("save", nbtTagCompound);
        } catch (Exception e) {
            this.plugin.getLogger()
                    .severe("[ItemStackJsonNbtConverter] Could not " +
                            "instantiate reflection helper for the current version. " +
                            "Showing an item in a JSON message will not work.");
        }

    }


    public String getNbtJson() {
        return nbtJson;
    }
}
