package net.derpz.tellrawlib.core.events;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.derpz.tellrawlib.core.ValueException;
import net.derpz.tellrawlib.core.components.MessageComponentPrimitive;
import net.derpz.tellrawlib.core.util.ItemStackJsonNbtConverter;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.InvocationTargetException;

/**
 * Represents an action that will be executed when the user hovers over the JSON message
 */
public class HoverEvent {

    /**
     * A list of actions that can be performed when the user hovers over the JSON message
     */
    enum Action {
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
         * or an {@link org.bukkit.advancement.Advancement}
         * @deprecated In 1.12+, advancements are text
         */
        SHOW_ACHIEVEMENT
    }

    private JsonObject hoverEvt;

    /**
     * Constructs a new HoverEvent with an action and a value
     * @param action The action you would like to execute
     * @param value The value that you supply to have the action executed
     * @throws ValueException If your value does not correspond with your action
     */
    
    public HoverEvent(Action action, Object value) throws ValueException {
        hoverEvt = new JsonObject();

        hoverEvt.addProperty("action", action.toString().toLowerCase());
        if (action == Action.SHOW_TEXT && value instanceof MessageComponentPrimitive) {
            JsonObject val = new JsonObject();
            JsonArray jsonArray = new JsonArray();

            jsonArray.add(new JsonParser().parse(((MessageComponentPrimitive) value).getJsonString()).getAsJsonObject());
            val.addProperty("text", "");
            val.add("extra", jsonArray);

            hoverEvt.add("value", val);
        } else if (action == Action.SHOW_ENTITY && value instanceof Entity) {
            JsonObject val = new JsonObject();
            val.addProperty("id", ((Entity) value).getUniqueId().toString());
            val.addProperty("type", "minecraft:" + ((Entity) value).getType().toString().toLowerCase());
            val.addProperty("name", ((Entity) value).getCustomName());

            hoverEvt.addProperty("value", new Gson().toJson(val));
        } else if (action == Action.SHOW_ITEM && value instanceof ItemStack) {
            // TODO: Figure out a way to call this when you're actually in the server
            //hoverEvt.addProperty("value");
        } else {
            throw new ValueException("Value is invalid for the type of action you wish to perform");
        }
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
