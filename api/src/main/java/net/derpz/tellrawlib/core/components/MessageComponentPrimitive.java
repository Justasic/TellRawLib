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

    public MessageComponentPrimitive() {
        this.jsonObject = new JsonObject();
    }

    // TODO: Methods to remove the stuff
    /**
     * Sets the text portion of the message component. Accepts bukkit colour codes prefixed with an & sign
     * You can supply as many color or formatting codes as you want.
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
        if (jsonObject.has("color")) {
            jsonObject.remove("color");
        }
        jsonObject.addProperty("color", color.toString().toLowerCase());
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
     * Sets the insertion of the message component.
     * The text specified in the insertion will be inserted
     * into the player's chat when they shift-click on the text
     * @param insertion The text to be inserted in the target's chat
     */
    public void setInsertion(String insertion) {
        if (jsonObject.has("insertion")) {
            jsonObject.remove("insertion");
        }
        jsonObject.addProperty("insertion", insertion);
    }

    /**
     * Gets the JSON string from the creation of the MessageComponentPrimitive
     * @return A JSON string to be sent to the player
     */
    public String getJsonString() {
        return new Gson().toJson(jsonObject);
    }
}
