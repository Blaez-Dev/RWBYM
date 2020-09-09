package io.github.blaezdev.rwbym.client.particle.renderer.model.animator;

import java.lang.reflect.Type;

import javax.vecmath.Vector3f;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.minecraft.util.JsonUtils;

public class Transformation {

    private final Value value;
    private final int order;
    private final Vector3f translation, scale, rotation, center;

    public Transformation(Value value, int order, Vector3f translation, Vector3f scale, Vector3f rotation, Vector3f center) {
        this.value = value;
        this.order = order;
        this.translation = translation;
        this.scale = scale;
        this.rotation = rotation;
        this.center = center;
    }

    public Value getValue() {
        return value;
    }

    public int getOrder() {
        return order;
    }

    public Vector3f getTranslation() {
        return translation == null ? null : new Vector3f(translation);
    }

    public Vector3f getScale() {
        return scale == null ? null : new Vector3f(scale);
    }

    public Vector3f getRotation() {
        return rotation == null ? null : new Vector3f(rotation);
    }

    public Vector3f getCenter() {
        return center == null ? null : new Vector3f(center);
    }

    public static class Deserializer implements JsonDeserializer<Transformation> {

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
        public Transformation deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            Value value;

            int order = -1;

            JsonObject jsonObject = (JsonObject) json;

            JsonElement valueElement = jsonObject.get("value");

            if (valueElement.isJsonPrimitive()) {
                if (valueElement.getAsJsonPrimitive().isString()) {
                    String valueString = valueElement.getAsString();
                    if (valueString.equals("default")) {
                        value = new Value();
                        order = 0;
                    }
                    else if (valueString.equals("variable")) {
                        value = new Value(true);
                    }
                    else {
                        throw new JsonParseException("Unknown Value String: " + valueString);
                    }
                }
                else if (valueElement.getAsJsonPrimitive().isNumber()) {
                    float valueFloat = valueElement.getAsFloat();
                    value = new Value(valueFloat);
                }
                else {
                    throw new JsonParseException("Unknown Value Primitive: " + valueElement.getAsJsonPrimitive());
                }
            }
            else if (valueElement.isJsonObject()) {
                JsonObject valueObject = valueElement.getAsJsonObject();
                float start, end;
                boolean scale, local;

                start = JsonUtils.getFloat(valueObject, "min", -Float.MAX_VALUE);
                end = JsonUtils.getFloat(valueObject, "max", Float.MAX_VALUE);
                scale = JsonUtils.getBoolean(valueObject, "scale", false);
                local = JsonUtils.getBoolean(valueObject, "local", false);

                value = new Value(start, end, scale, local);
            }
            else {
                throw new JsonParseException("Unknown Value Element: " + valueElement);
            }

            if (order == -1) {
                order = JsonUtils.getInt(jsonObject, "order", -1);
            }

            JsonObject transformationObject = jsonObject.getAsJsonObject("transformation");

            Vector3f translation = this.getVector3f(transformationObject, "translation", (float[]) null);
            Vector3f scale = this.getVector3f(transformationObject, "scale", (float[]) null);
            Vector3f rotation = this.getVector3f(transformationObject, "rotation", (float[]) null);
            Vector3f center = this.getVector3f(transformationObject, "center", (float[]) null);

            return new Transformation(value, order, translation, scale, rotation, center);
        }

        private Vector3f getVector3f(JsonObject jsonObject, String memberName, float... fallback) {

            float[] floats = new float[3];

            if (jsonObject.has(memberName)) {

                JsonArray jsonArray = jsonObject.getAsJsonArray(memberName);

                for (int i = 0; i < 3; i++) {
                    floats[i] = jsonArray.get(i).getAsFloat();
                }

            }
            else {
                floats = fallback;
            }

            return floats == null ? null : new Vector3f(floats);
        }

    }

    public static class Value {

        private float start, end;
        private boolean scale, local;

        public Value(float start, float end, boolean scale, boolean local) {
            this.start = start;
            this.end = end;
            this.scale = scale;
            this.local = local;
        }

        public Value(float start, float end) {
            this(start, end, false, false);
        }

        public Value(float value) {
            this(value - 0.001f, value + 0.001f);
        }

        public Value(boolean scale) {
            this(-Float.MAX_VALUE, Float.MAX_VALUE, scale, false);
        }

        public Value() {
            this(-Float.MAX_VALUE, Float.MAX_VALUE);
        }

        public float eval(float value) {
            if (value >= start && value <= end) {
                return scale ? local ? value - start : value : 1;
            }
            else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

}
