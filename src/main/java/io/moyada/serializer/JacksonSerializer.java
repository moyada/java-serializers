package io.moyada.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.moyada.serializer.data.User;

import java.io.IOException;

/**
 * @author xueyikang
 * @since 1.0
 **/
public class JacksonSerializer implements ByteArraySerializer {

    private final ObjectMapper mapper;

    public JacksonSerializer() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public <T> byte[] serialize(T obj) {
        try {
            return mapper.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        T value;
        try {
            value = mapper.readValue(data, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            value = null;
        }
        return value;
    }
}
