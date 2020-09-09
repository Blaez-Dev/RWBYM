package io.github.blaezdev.rwbym.client.particle.renderer.model.bbgunmodel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.lwjgl.util.vector.Vector3f;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import net.minecraft.util.JsonUtils;

public class ModelGroup {
    public final String name;
    public final UUID uuid;
    public final Vector3f rotation;
    public final Vector3f origin;
    public final List<ModelGroup> subGroups;
    public final List<UUID> elements;

    ModelGroup(String name, UUID uuid, Vector3f rotation, Vector3f origin, List<ModelGroup> subGroups, List<UUID> elements) {
        this.name = name;
        this.uuid = uuid;
        this.rotation = rotation;
        this.origin = origin;
        this.subGroups = subGroups;
        this.elements = elements;
    }

    public static class Deserializer implements JsonDeserializer<ModelGroup> {

        /**
         * Gson invokes this call-back method during deserialization when it encounters a field of the
         * specified type.
         * <p>In the implementation of this call-back method, you should consider invoking
         * {@link JsonDeserializationContext#deserialize(JsonElement, Type)} method to create objects
         * for any non-trivial field of the returned object. However, you should never invoke it on the
         * the same type passing {@code json} since that will cause an infinite loop (Gson will call your
         * call-back method again).
         *
         * @param json    The Json data being deserialized
         * @param typeOfT The type of the Object to deserialize to
         * @param context
         * @return a deserialized object of the specified type typeOfT which is a subclass of {@code T}
         * @throws JsonParseException if json is not in the expected format of {@code typeofT}
         */
        @Override
        public ModelGroup deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            JsonObject jsonObject = json.getAsJsonObject();

            if (!JsonUtils.getBoolean(jsonObject, "visibility", true)) {
                return null;
            }

            String name = JsonUtils.getString(jsonObject, "name", "");

            UUID uuid = UUID.fromString(JsonUtils.getString(jsonObject, "uuid", ""));

            Vector3f rotation = getVector3f(jsonObject, "rotation", 0, 0, 0);

            Vector3f origin = getVector3f(jsonObject, "origin", 8, 8, 8);
            
            rotation.z *= -1;

            origin.scale(1f/16f);

            JsonArray childrenArray = jsonObject.getAsJsonArray("children");

            List<ModelGroup> groups = new ArrayList<>();
            List<UUID> elements = new ArrayList<>();

            for (JsonElement childElement : childrenArray) {
                if (childElement.isJsonObject()) {
                    ModelGroup group = context.deserialize(childElement, ModelGroup.class);
                    if (group != null) {
                        groups.add(group);
                    }
                }
                else if (childElement.isJsonPrimitive() && ((JsonPrimitive)childElement).isString()) {
                    elements.add(UUID.fromString(childElement.getAsString()));
                }
            }

            return new ModelGroup(name, uuid, rotation, origin, groups, elements);
        }

        private Vector3f getVector3f(JsonObject jsonObject, String memberName, float... fallback) {

            float[] floats = fallback;

            if (jsonObject.has(memberName)) {

                JsonArray jsonArray = jsonObject.getAsJsonArray(memberName);

                for (int i = 0; i < 3; i++) {
                    floats[i] = jsonArray.get(i).getAsFloat();
                }

            }

            return new Vector3f(floats[0], floats[1], floats[2]);
        }
    }
}
