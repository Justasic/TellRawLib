package net.derpz.tellrawlib.impl.components;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.derpz.tellrawlib.core.components.MessageComponent;
import net.derpz.tellrawlib.core.events.ClickEvent;
import net.derpz.tellrawlib.core.events.HoverEvent;

public class MsgComponent extends MsgComponentPrimitive implements MessageComponent {

    private JsonObject jsonObject;

    public MsgComponent() {
        jsonObject = new JsonObject();
    }

    @Override
    public void setClickEvent(ClickEvent clickEvent) {
        if (jsonObject.has("clickEvent")) {
            jsonObject.remove("clickEvent");
        }
        jsonObject.add("clickEvent", new JsonParser().parse(clickEvent.getJson()).getAsJsonObject());
    }

    @Override
    public void setHoverEvent(HoverEvent hoverEvent) {
        if (jsonObject.has("hoverEvent")) {
            jsonObject.remove("hoverEvent");
        }
        jsonObject.add("hoverEvent", new JsonParser().parse(hoverEvent.getJson()).getAsJsonObject());
    }
}
