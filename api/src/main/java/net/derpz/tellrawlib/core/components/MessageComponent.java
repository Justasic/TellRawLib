package net.derpz.tellrawlib.core.components;

import com.google.gson.JsonParser;
import net.derpz.tellrawlib.core.events.ClickEvent;
import net.derpz.tellrawlib.core.events.HoverEvent;

/**
 * A component of a JSON Message that you wish to send to the player.
 * This version accepts a click event and a hover event.
 * @author xiurobert
 */
public class MessageComponent extends MessageComponentPrimitive{

    /**
     * Sets the click event that will be called when the message component is clicked on
     * @param clickEvent A ClickEvent which will provide action
     */
    public void setClickEvent(ClickEvent clickEvent) {
        removeClickEvent();
        jsonObject.add("clickEvent", new JsonParser().parse(clickEvent.getJson()).getAsJsonObject());
    }

    /**
     * Removes the click event
     */
    public void removeClickEvent() {
        if (jsonObject.has("clickEvent")) {
            jsonObject.remove("clickEvent");
        }
    }

    /**
     * Sets the hover event that will be called when the message component is hovered over
     * @param hoverEvent A HoverEvent which will provide action
     */
    public void setHoverEvent(HoverEvent hoverEvent) {
        removeHoverEvent();
        jsonObject.add("hoverEvent", new JsonParser().parse(hoverEvent.getJson()).getAsJsonObject());
    }

    /**
     * Removes the hover event
     */
    public void removeHoverEvent() {
        if (jsonObject.has("hoverEvent")) {
            jsonObject.remove("hoverEvent");
        }
    }
}
