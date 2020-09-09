package io.github.blaezdev.rwbym.client.particle.renderer.model.bbgunmodel;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.vecmath.Vector3f;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.JsonUtils;

public class ModelElement {
	
	public final String name;
	public final Vector3f start, end, rotation, origin;
	public final Map<EnumFacing, ElementFace> faces;
	public final UUID uuid;
	
	public ModelElement(String name, Vector3f start, Vector3f end, Vector3f rotation, Vector3f origin, Map<EnumFacing, ElementFace> faces, UUID uuid) {
		this.name = name;
		this.start = start;
		this.end = end;
		this.rotation = rotation;
		this.origin = origin;
		this.faces = faces;
		this.uuid = uuid;
	}
	
	public static class Deserializer implements JsonDeserializer<ModelElement> {
		
		public ModelElement deserialize(JsonElement baseElement, Type type, JsonDeserializationContext context) throws JsonParseException {
			
			JsonObject jsonObject = (JsonObject) baseElement;
			
			String name = JsonUtils.getString(jsonObject, "name", "");
			
			Vector3f start = this.getVector3f(jsonObject, "from", 0, 0, 0);
			
			Vector3f end = this.getVector3f(jsonObject, "to", 0, 0, 0);
			
			Vector3f rotation = this.getVector3f(jsonObject, "rotation", 0, 0, 0);
			
			Vector3f origin = this.getVector3f(jsonObject, "origin", 8f, 8f, 8f);
			
			start.scale(1f/16f);
			end.scale(1f/16f);
			origin.scale(1f/16f);
			
			rotation.y *= -1;
			rotation.z *= -1;
			
			JsonObject facesObject = jsonObject.getAsJsonObject("faces");
			
			Map<EnumFacing, ElementFace> faces = new HashMap<>();
			
			for (Entry<String, JsonElement> entry : facesObject.entrySet()) {
				EnumFacing facing = EnumFacing.byName(entry.getKey());
				ElementFace face = context.deserialize(entry.getValue(), ElementFace.class);
				if (face != null) {
					faces.put(facing, face);
				}
			}
			
			UUID uuid = this.getUUID(jsonObject, "uuid");
			
			return new ModelElement(name, start, end, rotation, origin, faces, uuid);
			
		}

		private Vector3f getVector3f(JsonObject jsonObject, String memberName, float... fallback) {
			
			float[] floats = fallback;
			
			if (jsonObject.has(memberName)) {

				JsonArray jsonArray = jsonObject.getAsJsonArray(memberName);
				
				for (int i = 0; i < 3; i++) {
					floats[i] = jsonArray.get(i).getAsFloat();
				}
				
			}
			
			return new Vector3f(floats);
		}
		
		private UUID getUUID(JsonObject jsonObject, String memberName) {
			
			String uuid = JsonUtils.getString(jsonObject, memberName, "");
			
			return UUID.fromString(uuid);
			
		}
		
	}
	
	
}