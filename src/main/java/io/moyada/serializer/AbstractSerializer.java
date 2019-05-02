package io.moyada.serializer;

/**
 * @author xueyikang
 * @since 1.0
 **/
public abstract class AbstractSerializer<C,D> implements Serializer<C, D> {

    @Override
    public <T extends C> D serialize(T obj) {
        if (null == obj) {
            return null;
        }
        return doSerialize(obj);
    }

    abstract <T extends C> D doSerialize(T obj);

    @Override
    public <T extends C> T deserialize(D data, Class<T> clazz) {
        if (null == data) {
            return null;
        }
        return doDeserialize(data, clazz);
    }

    abstract <T extends C> T doDeserialize(D data, Class<T> clazz);
}
