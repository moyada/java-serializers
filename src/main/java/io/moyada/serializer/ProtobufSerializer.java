package io.moyada.serializer;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author xueyikang
 * @since 1.0
 **/
public class ProtobufSerializer implements ByteArraySerializer {

    private final Set<Class<?>> protos;

    private final Map<Class<?>, Parser<?>> parserMap;

    @Override
    public int hashCode() {
        return Objects.hash(protos, parserMap);
    }

    public ProtobufSerializer() {
        protos = new ConcurrentSkipListSet<>((c1, c2) -> {
            if (c1 == c2) {
                return 0;
            }
            return Objects.hash(c1, c2);
        });
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
    public <T> byte[] serialize(T obj) {
        Class<?> clazz = obj.getClass();
        if (protos.contains(clazz)) {
            return ((MessageLite) obj).toByteArray();
        }
        if (!(obj instanceof MessageLite)) {
            return null;
        }
//        if (!ClassUtil.isSubClass(clazz, MessageLite.class)) {
//            return null;
//        }
        protos.add(clazz);
        return ((MessageLite) obj).toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
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
