package net.derpz.tellrawlib.core.events;

/**
 * Represents an action that will be executed when the user clicks on the JSON message
 */
public interface ClickEvent {
    /**
     * A list of actions that can be performed when the user clicks on the message
     */
    enum Action {
        /**
         * Runs a command as the user
         */
        RUN_COMMAND,
        /**
         * Suggests a command i.e. Inserts the command into the user's chat box.
         * Does not actually run the command.
         */
        SUGGEST_COMMAND,
        /**
         * Opens a URL. Will display a dialog to the user asking if they would like to open it
         */
        OPEN_URL,
        /**
         * Change the page of the book, in a written book
         */
        BOOK_CHANGE_PAGE
    }

    /**
     * Constructs a new ClickEvent with a hover action
     * @param action An action of your choice.
     */
    public void construct(Action action, Object event);

}
