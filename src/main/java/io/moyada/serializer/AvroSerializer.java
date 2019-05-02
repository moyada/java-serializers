package io.moyada.serializer;

import io.moyada.serializer.utils.ClassUtil;
import org.apache.avro.AvroRuntimeException;
import org.apache.avro.io.*;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author xueyikang
 * @since 1.0
 **/
public class AvroSerializer implements ByteArraySerializer {

//    private final Map<Class<?>, Schema> schemaMap;
//
//    public AvroSerializer() {
//        schemaMap = new ConcurrentHashMap<>(32);
//    }
//
//    private Schema getSchema(Class<?> clazz) {
//        Schema schema = schemaMap.get(clazz);
//        if (null != schema) {
//            return schema;
//        }
//
//        Object value;
//        Method getClassSchema;
//        try {
//            getClassSchema = clazz.getDeclaredMethod("getClassSchema");
//            getClassSchema.setAccessible(true);
//            value = getClassSchema.invoke(null);
//        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//        schema = (Schema) value;
//        schemaMap.put(clazz, schema);
//        return schema;
//    }

    @Override
    public <T> byte[] serialize(T obj) {
        Class<T> clazz = ClassUtil.getClass(obj);

        DatumWriter<T> writer;
        try {
            writer = new SpecificDatumWriter<>(clazz);
        } catch (AvroRuntimeException e) {
            e.printStackTrace();
            return null;
        }

        byte[] data = null;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        Encoder encoder;
        try {
            encoder = EncoderFactory.get().binaryEncoder(stream, null);
            writer.write(obj, encoder);
            encoder.flush();
            data = stream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                // pass
            }
        }

        return data;
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        DatumReader<T> reader;
        try {
            reader = new SpecificDatumReader<>(clazz);
        } catch (AvroRuntimeException e) {
            e.printStackTrace();
            return null;
        }

        Decoder decoder;
        try {
            decoder = DecoderFactory.get().binaryDecoder(data, null);
            return reader.read(null, decoder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
