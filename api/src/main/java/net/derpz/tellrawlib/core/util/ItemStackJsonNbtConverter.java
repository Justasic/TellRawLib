package net.derpz.tellrawlib.core.util;

import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Uses reflection on NMS and craftbukkit to obtain the ItemStack information
 */
public class ItemStackJsonNbtConverter {

    private String nmsString = "net.minecraft.server.";
    private String obString = "org.bukkit.craftbukkit.";

    private String nbtJson;

    private Server server;
    private Class<?> nbtTagCompound;
    private Method asNMSCopy;
    private Method saveNmsItemStack;

    /**
     * Uses black magic wizardry to generate a NBT JSON representation of an item
     * @param itemStack The ItemStack you wish to be converted
     * @param server The server
     * @throws ClassNotFoundException Mojang probably removed/renamed it.
     * @throws NoSuchMethodException Mojang probably removed/renamed it.
     * @throws IllegalAccessException definitely my fault
     * @throws InstantiationException my fault too
     * @throws InvocationTargetException my fault
     */
    public ItemStackJsonNbtConverter(ItemStack itemStack, Server server) throws IllegalAccessException,
            InstantiationException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
        this.server = server;

        obtainClassesAndMethods();

        Object nbtTagCompoundObj;
        Object itemStackObj;
        Object itemsAsJsonObject;

        nbtTagCompoundObj = nbtTagCompound.newInstance();
        itemStackObj = asNMSCopy.invoke(null, itemStack);
        itemsAsJsonObject = saveNmsItemStack.invoke(itemStackObj, nbtTagCompoundObj);

        this.nbtJson = itemsAsJsonObject.toString();
    }

    private void obtainClassesAndMethods() throws ClassNotFoundException, NoSuchMethodException {
        String version  = server.getClass()
                .getPackage().getName()
                .replace(".", ",").split(",")[3];

        this.asNMSCopy = Class
                .forName(obString + version + ".inventory.CraftItemStack")
                .getMethod("asNMSCopy", ItemStack.class);
        this.nbtTagCompound = Class
                .forName(nmsString + version + ".NBTTagCompound");
        this.saveNmsItemStack = Class
                .forName(nmsString + version + ".ItemStack")
                .getMethod("save", nbtTagCompound);
    }


    public String getNbtJson() {
        return nbtJson;
    }
}
