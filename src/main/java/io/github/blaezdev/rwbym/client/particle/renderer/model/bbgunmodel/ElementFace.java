package io.github.blaezdev.rwbym.client.particle.renderer.model.bbgunmodel;

import java.lang.reflect.Type;

import javax.vecmath.Vector4f;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.minecraft.util.JsonUtils;

public class ElementFace {
	
	public final Vector4f uv;
	public final String texture;
	
	public ElementFace(Vector4f uv, String texture) {
		this.uv = uv;
		this.texture = texture;
	}
	
	public static class Deserializer implements JsonDeserializer<ElementFace> {
		
		public ElementFace deserialize(JsonElement baseElement, Type type, JsonDeserializationContext context) throws JsonParseException {
			
			JsonObject jsonObject = (JsonObject) baseElement;

			if (jsonObject.get("texture") == null || jsonObject.get("texture").isJsonNull()) {
				return null;
			}
			
			Vector4f uv = this.getVector4f(jsonObject, "uv", 0, 0, 16, 16);

			String texture = JsonUtils.getString(jsonObject, "texture", "missingno");
			
			return new ElementFace(uv, texture);
			
		}
		
		private Vector4f getVector4f(JsonObject jsonObject, String memberName, float... fallback) {
			
			float[] floats = fallback;
			
			if (jsonObject.has(memberName)) {
				
				JsonArray jsonArray = jsonObject.getAsJsonArray(memberName);
			
				for (int i = 0; i < 4; i++) {
					floats[i] = jsonArray.get(i).getAsFloat();
				}
			
			}
			
			return new Vector4f(floats);
		}
		
	}

}
