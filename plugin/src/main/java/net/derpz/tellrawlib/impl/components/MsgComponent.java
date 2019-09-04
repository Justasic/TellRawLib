package net.derpz.tellrawlib.impl.components;

import com.google.gson.JsonObject;
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
        jsonObject.add("clickEvent", clickEvent);
    }

    @Override
    public void setHoverEvent(HoverEvent hoverEvent) {

    }
}
