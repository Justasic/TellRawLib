package net.derpz.tellrawlib.core.components;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.derpz.tellrawlib.core.util.ChatUtil;
import net.derpz.tellrawlib.core.enums.Color;
import net.derpz.tellrawlib.core.enums.Formatting;

/**
 * A primitive message component. This is for use in HoverEvent.
 * It cannot take in a ClickEvent or a HoverEvent
 */
public class MessageComponentPrimitive {
    JsonObject jsonObject;

    /**
     * Constructs a blank primitive message component
     */
    public MessageComponentPrimitive() {
        this.jsonObject = new JsonObject();
    }

    /**
     * Constructs a new primitive message component with a text portion.
     * Accepts bukkit colour codes prefixed with an & sign
     * @param text The text portion of the message component
     */
    public MessageComponentPrimitive(String text) {
        this.jsonObject = new JsonObject();
        jsonObject.addProperty("text", ChatUtil.colour(text));
    }

    /**
     * Sets the text portion of the message component.
     * Accepts bukkit colour codes prefixed with an & sign
     * @param text The text portion of the message component
     */
    public void setText(String text) {
        if (jsonObject.has("text")) {
            jsonObject.remove("text");
        }
        jsonObject.addProperty("text", ChatUtil.colour(text));
    }


    /**
     * Sets the colour of the text portion of the message component.
     * For chat colors, see {@link net.derpz.tellrawlib.core.enums.Color}
     * <b>Note that you can always set the color with bukkit color codes in {@link #setText(String)}</b>
     * <b>You may only choose one color code for the whole MessageComponent.</b>
     * <p>If you wish to use more color codes, please use {@link #setText(String)} instead</p>
     * @param color A color of your choice
     */
    public void setColor(Color color) {
        removeColor();
        jsonObject.addProperty("color", color.toString().toLowerCase());
    }

    /**
     * Removes the color of the component
     */
    public void removeColor() {
        if (jsonObject.has("color")) {
            jsonObject.remove("color");
        }
    }

    /**
     * Adds formatting to the text portion of the message component
     * For formatting codes, see {@link net.derpz.tellrawlib.core.enums.Formatting}
     * <b>Note that you can always set the color with bukkit color codes in {@link #setText(String)}</b>
     * @param formatting A formatting code of your choice.
     */
    public void addFormatting(Formatting formatting) {
        if (!jsonObject.has(formatting.toString().toLowerCase())) {
            jsonObject.addProperty(formatting.toString().toLowerCase(), true);
        }
    }
    /**
     * Removes formatting
     * @param formatting The formatting to remove
     */
    public void removeFormatting(Formatting formatting) {
        if (jsonObject.has(formatting.toString().toLowerCase())) {
            jsonObject.remove(formatting.toString().toLowerCase());
        }
    }

    /**
     * Sets the insertion of the message component.
     * The text specified in the insertion will be inserted
     * into the player's chat when they shift-click on the text
     * @param insertion The text to be inserted in the target's chat
     */
    public void setInsertion(String insertion) {
        removeInsertion();
        jsonObject.addProperty("insertion", insertion);
    }

    /**
     * Removes the insertion
     */
    public void removeInsertion() {
        if (jsonObject.has("insertion")) {
            jsonObject.remove("insertion");
        }
    }

    /**
     * Gets the JSON string from the creation of the MessageComponentPrimitive
     * @return A JSON string to be sent to the player
     */
    public String getJsonString() {
        return new Gson().toJson(jsonObject);
    }
}
