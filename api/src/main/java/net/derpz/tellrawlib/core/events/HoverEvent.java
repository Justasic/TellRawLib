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
         */
        SHOW_ACHIEVEMENT
    }

    /**
     * Constructs a new HoverEvent with an action and a value
     * @param action The action you would like to execute
     * @param value The value that you supply to have the action executed
     */
    public void construct(Action action, Object value);
}
