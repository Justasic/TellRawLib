package net.derpz.tellrawlib.core.events;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.derpz.tellrawlib.core.components.MessageComponentPrimitive;
import net.derpz.tellrawlib.core.util.ItemStackJsonNbtConverter;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

/**
 * Represents an action that will be executed when the user hovers over the JSON message
 * {@see <a href="https://wiki.vg/Chat#Shared_between_all_components">wiki.vg on Chat</a>}
 */
public class HoverEvent {

    /**
     * A list of actions that can be performed when the user hovers over the JSON message
     * @deprecated Left here for documentation.
     */
    public enum Action {
        /**
         * Shows a {@link net.derpz.tellrawlib.core.components.MessageComponentPrimitive}
         */
        SHOW_TEXT,
        /**
         * Shows an {@link org.bukkit.inventory.ItemStack}
         */
        SHOW_ITEM,
        /**
         * Shows an {@link org.bukkit.entity.Entity}
         */
        SHOW_ENTITY,
        /**
         * Shows an {@link org.bukkit.Achievement}
         * @deprecated In 1.12+, advancements are text
         */
        SHOW_ACHIEVEMENT
    }

    private JsonObject hoverEvt;

    /**
     * Directly constructs a HoverEvent that shows text
     * @param value The primitive message component that you would like to be shown
     */
    public HoverEvent(MessageComponentPrimitive value) {
        hoverEvt = new JsonObject();

        // processing
        JsonObject val = new JsonObject();
        JsonArray jsonArray = new JsonArray();

        jsonArray.add(new JsonParser().parse(value.getJsonString()).getAsJsonObject());

        val.addProperty("text", "");
        val.add("extra", jsonArray);

        hoverEvt.addProperty("action", "show_text");
        hoverEvt.add("value", val);
    }

    /**
     * Directly constructs a HoverEvent that shows an entity
     * @param value The Entity that you would like to be shown
     */
    public HoverEvent(Entity value) {
        hoverEvt = new JsonObject();

        // processing
        JsonObject val = new JsonObject();

        val.addProperty("id", ((Entity) value).getUniqueId().toString());
        val.addProperty("type", "minecraft:" + ((Entity) value).getType().toString().toLowerCase());
        val.addProperty("name", ((Entity) value).getCustomName());

        hoverEvt.addProperty("action", "show_entity");
        hoverEvt.addProperty("value", new Gson().toJson(val));
    }

    /**
     * Directly constructs a HoverEvent that shows an item (ItemStack)
     * @param value The ItemStack that you would like to be shown
     * @param plugin The plugin. Used to get the version of the server
     */
    public HoverEvent(ItemStack value, Plugin plugin) {
        hoverEvt = new JsonObject();

        hoverEvt.addProperty("action", "show_item");
        hoverEvt.addProperty("value", new ItemStackJsonNbtConverter(value, plugin).getNbtJson());
    }

    /**
     * Returns the JSON object as a string
     * @return The JSON string
     * @apiNote For internal use only
     */
    public String getJson() {
        return new Gson().toJson(hoverEvt);
    }
}
