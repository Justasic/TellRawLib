package net.derpz.tellrawlib.impl.events;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.org.apache.bcel.internal.generic.FieldGenOrMethodGen;
import jdk.nashorn.internal.parser.JSONParser;
import net.derpz.tellrawlib.core.events.HoverEvent;
import net.derpz.tellrawlib.impl.components.MsgComponentPrimitive;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

/**
 * Created by xiurobert on 04-Sep-19.
 */
public class HoverEvt implements HoverEvent {

    private JsonObject hoverEvt;

    @Override
    public void construct(Action action, Object value) {
        hoverEvt = new JsonObject();
        hoverEvt.addProperty("action", action.toString().toLowerCase());
        if (action == Action.SHOW_TEXT && value instanceof MsgComponentPrimitive) {
            JsonObject val = new JsonObject();
            JsonArray jsonArray = new JsonArray();

            jsonArray.add(new JsonParser().parse(((MsgComponentPrimitive) value).getJsonString()).getAsJsonObject());
            val.addProperty("text", "");
            val.add("extra", jsonArray);

            hoverEvt.add("value", val);
        } else if (action == Action.SHOW_ENTITY && value instanceof Entity) {
            JsonObject val = new JsonObject();
            val.addProperty("id", ((Entity) value).getUniqueId().toString());
            val.addProperty("type", "minecraft:" + ((Entity) value).getType().toString().toLowerCase());
            val.addProperty("type", ((Entity) value).getCustomName());
        } else if (action == Action.SHOW_ITEM && value instanceof ItemStack) {
            // TODO: Reflection to get NBT into JSON
        } else {
            // TODO: Throw a ValueException
        }
    }

    @Override
    public String getJson() {
        return new Gson().toJson(hoverEvt);
    }
}
