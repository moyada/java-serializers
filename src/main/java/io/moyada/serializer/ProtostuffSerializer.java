package io.moyada.serializer;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

/**
 * @author xueyikang
 * @since 1.0
 **/
public class ProtostuffSerializer implements ByteArraySerializer {

    private final Objenesis objenesis;

    public ProtostuffSerializer() {
        objenesis = new ObjenesisStd();
    }

    @Override
    public <T> byte[] serialize(T obj) {
        @SuppressWarnings("unchecked")
        Class<T> cls = (Class<T>) obj.getClass();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        Schema<T> schema = RuntimeSchema.getSchema(cls);

        try {
            return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            buffer.clear();
        }
        return null;
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        try {
            T message = objenesis.newInstance(clazz);
            Schema<T> schema = RuntimeSchema.getSchema(clazz);
            ProtostuffIOUtil.mergeFrom(data, message, schema);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
