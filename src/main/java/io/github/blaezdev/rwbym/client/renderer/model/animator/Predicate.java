package io.github.blaezdev.rwbym.client.renderer.model.animator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class Predicate {

    private List<Transformation> transformations = new ArrayList<>();

    public Predicate(List<Transformation> transformations) {
        this.transformations = transformations;
    }

    public List<Transformation> getTransformations() {
        return transformations;
    }

    public static class Deserializer implements JsonDeserializer<Predicate> {

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
        public Predicate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            JsonArray predicateObject = json.getAsJsonArray();

            List<Transformation> transformations = new ArrayList<>();

            for (JsonElement transformationElement : predicateObject) {
                transformations.add(context.deserialize(transformationElement, Transformation.class));
            }

            return new Predicate(transformations);
        }

    }
}
