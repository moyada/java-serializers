package io.moyada.serializer;

/**
 * @author xueyikang
 * @since 1.0
 **/
public interface Serializer<C, D> {

    <T extends C> D serialize(T obj);

    <T extends C> T deserialize(D data, Class<T> clazz);
}
