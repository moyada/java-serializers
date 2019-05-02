package io.moyada.serializer;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xueyikang
 * @since 1.0
 **/
public class ProtobufSerializer implements GenericByteArraySerializer<MessageLite> {

    private final Map<Class<?>, Parser<?>> parserMap;

    public ProtobufSerializer() {
        parserMap = new ConcurrentHashMap<>(32);
    }

    @SuppressWarnings("unchecked")
    private <T> Parser<T> getParser(Class<T> clazz) {
        Parser<?> parser = parserMap.get(clazz);
        if (null != parser) {
            return (Parser<T>) parser;
        }

        Object value;
        Method getParser;
        try {
            getParser = clazz.getDeclaredMethod("parser");
            getParser.setAccessible(true);
            value = getParser.invoke(null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }

        parser = (Parser<?>) value;
        parserMap.put(clazz, parser);
        return (Parser<T>) parser;
    }

    @Override
    public <T extends MessageLite> byte[] serialize(T obj) {
        return obj.toByteArray();
    }

    @Override
    public <T extends MessageLite> T deserialize(byte[] data, Class<T> clazz) {
        Parser<T> parser = getParser(clazz);
        if (null == parser) {
            return null;
        }

        try {
            return parser.parseFrom(data);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return null;
    }
}
