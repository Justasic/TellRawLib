package net.derpz.tellrawlib.impl.events;

import com.google.gson.JsonObject;
import net.derpz.tellrawlib.core.events.ClickEvent;

public class ClickEvt implements ClickEvent {

    private JsonObject clckEvt;

    @Override
    public void construct(Action action, String event) {
        clckEvt.addProperty("action", action.toString().toLowerCase());
        clckEvt.addProperty("value", event);
    }

}
