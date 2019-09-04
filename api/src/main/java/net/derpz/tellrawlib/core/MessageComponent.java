package net.derpz.tellrawlib.core;

import net.derpz.tellrawlib.core.enums.Color;
import net.derpz.tellrawlib.core.enums.Formatting;
import net.derpz.tellrawlib.core.events.ClickEvent;
import net.derpz.tellrawlib.core.events.HoverEvent;

/**
 * A component of a JSONmessage that you wish to send to the player
 * @author xiurobert
 */
public interface MessageComponent {
    /**
     * Sets the text portion of the message component. Accepts bukkit colour codes prefixed with an & sign
     * You can supply as many color or formatting codes as you want.
     * @param text The text portion of the message component
     */
    public void setText(String text);

    /**
     * Sets the colour of the text portion of the message component.
     * For chat colors, see {@link net.derpz.tellrawlib.core.enums.Color}
     * <b>Note that you can always set the color with bukkit color codes in {@link #setText(String)}</b>
     * <b>You may only choose one color code for the whole MessageComponent.</b>
     * <p>If you wish to use more color codes, please use {@link #setText(String)} instead</p>
     * @param color A color of your choice
     */
    public void setColor(Color color);

    /**
     * Adds formatting to the text portion of the message component
     * For formatting codes, see {@link net.derpz.tellrawlib.core.enums.Formatting}
     * <b>Note that you can always set the color with bukkit color codes in {@link #setText(String)}</b>
     * @param formatting A formatting code of your choice.
     */
    public void addFormatting(Formatting formatting);

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
