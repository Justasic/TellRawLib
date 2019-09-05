package net.derpz.tellrawlib.core.events;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ClickEvent {

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
         * @deprecated You really shouldn't be using this. It is a message plugin
         */
        CHANGE_PAGE
    }

    private JsonObject clckEvt;

    /**
     * Constructs a new ClickEvent with a hover action
     * @param action An action of your choice.
     * @param event A string specifying what the ClickEvent will do
     */

    public ClickEvent(Action action, String event) {
        clckEvt = new JsonObject();
        clckEvt.addProperty("action", action.toString().toLowerCase());
        clckEvt.addProperty("value", event);
    }

    /**
     * Returns the ClickEvent as a JSON string
     * @return A JSON string containing the click event
     */
    public String getJson() {
        return new Gson().toJson(clckEvt);
    }

}
