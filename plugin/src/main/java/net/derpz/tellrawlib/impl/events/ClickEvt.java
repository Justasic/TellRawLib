package net.derpz.tellrawlib.impl.events;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.derpz.tellrawlib.core.events.ClickEvent;

public class ClickEvt implements ClickEvent {

    private JsonObject clckEvt;

    @Override
    public void construct(Action action, String event) {
        clckEvt = new JsonObject();
        clckEvt.addProperty("action", action.toString().toLowerCase());
        clckEvt.addProperty("value", event);
    }

    @Override
    public String getJson() {
        return new Gson().toJson(clckEvt);
    }

}
