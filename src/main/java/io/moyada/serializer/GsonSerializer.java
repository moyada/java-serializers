package io.moyada.serializer;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Base64;

/**
 * @author xueyikang
 * @since 1.0
 **/
public class GsonSerializer implements StringSerializer {

    private final Gson gson;

    public GsonSerializer() {
        // Adapter to convert byte[] in a Java Object to a String in Json for UI to display image properly
        this.gson = new GsonBuilder()
            .registerTypeAdapter(byte[].class, new JsonSerializer<byte[]>() {
            public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
                    return new JsonPrimitive(Base64.getEncoder().encodeToString(src));
                }
            })
            .registerTypeAdapter(byte[].class, new JsonDeserializer<byte[]>() {
                @Override
                public byte[] deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                    return Base64.getDecoder().decode(jsonElement.getAsString());
                }
            }).create();
    }

    @Override
    public <T> String serialize(T obj) {
        return gson.toJson(obj, obj.getClass());
    }

    @Override
    public <T> T deserialize(String data, Class<T> clazz) {
        return gson.fromJson(data, clazz);
    }
}
