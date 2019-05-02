package io.moyada.serializer;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.SerializerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author xueyikang
 * @since 1.0
 **/
public class HessianSerializer implements ByteArraySerializer {

    private final SerializerFactory factory;

    public HessianSerializer() {
        this.factory = SerializerFactory.createDefault();
    }

    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        Hessian2Output output = new Hessian2Output(os);
        output.setSerializerFactory(factory);
        try {
            output.writeObject(obj);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return os.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        ByteArrayInputStream is = new ByteArrayInputStream(data);
        Hessian2Input input = new Hessian2Input(is);
        input.setSerializerFactory(factory);

        try {
            @SuppressWarnings("unchecked")
            T value = (T) input.readObject(clazz);
            return value;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
