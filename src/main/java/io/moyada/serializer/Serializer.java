package io.moyada.serializer;

/**
 * @author xueyikang
 * @since 1.0
 **/
public interface Serializer<D> {

    <T> D serialize(T obj);

    <T> T deserialize(D data, Class<T> clazz);
}
