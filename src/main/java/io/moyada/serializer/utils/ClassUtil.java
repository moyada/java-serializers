package io.moyada.serializer.utils;

/**
 * @author xueyikang
 * @since 1.0
 **/
public class ClassUtil {

    public static <T> Class<T> getClass(T obj) {
        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) obj.getClass();
        return clazz;
    }

    public static boolean isSubClass(Class<?> subClass, Class<?> parenClass) {
        return parenClass.isAssignableFrom(subClass);
    }
}
