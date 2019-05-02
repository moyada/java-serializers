package io.moyada.serializer;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

/**
 * @author xueyikang
 * @since 1.0
 **/
public class ThriftSerializer implements ByteArraySerializer {

    private TProtocol tProtocol;

    public ThriftSerializer() {
        tProtocol = new TBinaryProtocol(null);
    }

    @Override
    public <T> byte[] serialize(T obj) {
        return new byte[0];
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return null;
    }
}
