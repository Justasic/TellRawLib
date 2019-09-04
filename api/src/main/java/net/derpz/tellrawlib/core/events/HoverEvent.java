package net.derpz.tellrawlib.core.events;

/**
 * Represents an action that will be executed when the user hovers over the JSON message
 */
public interface HoverEvent {
    /**
     * A list of actions that can be performed when the user hovers over the JSON message
     */
    enum Action {
        /**
         * Shows a text component
         */
        SHOW_TEXT,
        SHOW_ITEM,
        SHOW_ENTITY,
        SHOW_ACHIEVEMENT
    }
}
