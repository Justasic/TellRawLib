package net.derpz.tellrawlib.core.components;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.derpz.tellrawlib.core.enums.Color;
import net.derpz.tellrawlib.core.enums.Formatting;

import net.derpz.tellrawlib.util.ChatUtil;

public class MsgComponentPrimitive implements MessageComponentPrimitive {
    private JsonObject jsonObject;

    public MsgComponentPrimitive() {
        this.jsonObject = new JsonObject();
    }

    @Override
    public void setText(String text) {
        if (jsonObject.has("text")) {
            jsonObject.remove("text");
        }
        jsonObject.addProperty("text", ChatUtil.colour(text));
    }

    @Override
    public void setColor(Color color) {
        if (jsonObject.has("color")) {
            jsonObject.remove("color");
        }
        jsonObject.addProperty("color", color.toString().toLowerCase());
    }

    /**
     * Adds formatting
     * Ignored if you already have the formatting applied;
     * @param formatting A formatting code of your choice.
     */
    @Override
    public void addFormatting(Formatting formatting) {
        if (!jsonObject.has(formatting.toString().toLowerCase())) {
            jsonObject.addProperty(formatting.toString().toLowerCase(), true);
        }
    }

    @Override
    public void setInsertion(String insertion) {
        if (jsonObject.has("insertion")) {
            jsonObject.remove("insertion");
        }
        jsonObject.addProperty("insertion", insertion);
    }

    @Override
    public String getJsonString() {
        return new Gson().toJson(jsonObject);
    }
}
