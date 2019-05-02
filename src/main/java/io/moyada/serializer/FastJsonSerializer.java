package io.moyada.serializer;

import com.alibaba.fastjson.JSONObject;

/**
 * @author xueyikang
 * @since 1.0
 **/
public class FastJsonSerializer implements ByteArraySerializer {

    @Override
    public <T> byte[] serialize(T obj) {
        return JSONObject.toJSONBytes(obj);
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return JSONObject.parseObject(data, clazz);
    }
}
