package net.derpz.tellrawlib.core.components;

import net.derpz.tellrawlib.core.events.ClickEvent;
import net.derpz.tellrawlib.core.events.HoverEvent;

/**
 * A component of a JSON Message that you wish to send to the player.
 * This version accepts a click event and a hover event.
 * @author xiurobert
 */
public interface MessageComponent extends MessageComponentPrimitive {

    /**
     * Sets the click event that will be called when the message component is clicked on
     * @param clickEvent A ClickEvent which will provide action
     */
    public void setClickEvent(ClickEvent clickEvent);

    /**
     * Sets the hover event that will be called when the message component is hovered over
     * @param hoverEvent A HoverEvent which will provide action
     */
    public void setHoverEvent(HoverEvent hoverEvent);

}
