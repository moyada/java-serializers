package io.moyada.serializer.test;

import avro.shaded.com.google.common.collect.Lists;
import io.moyada.serializer.*;
import io.moyada.serializer.data.avro.User;
import io.moyada.serializer.data.proto.UserProto;
import io.moyada.serializer.data.thrift.SharedStruct;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xueyikang
 * @since 1.0
 **/
public class SerializerTest {

    @Test
    public void JacksonTest() {
        test(new JacksonSerializer());
    }

    @Test
    public void GsonTest() {
        test(new GsonSerializer());
    }

    @Test
    public void FastJasonTest() {
        test(new FastJsonSerializer());
    }

    @Test
    public void HessianTest() {
        test(new HessianSerializer());
    }

    @Test
    public void KryoTest() {
        test(new KryoSerializer());
    }

    @Test
    public void ProtostuffTest() {
        test(new ProtostuffSerializer());
    }

    @Test
    public void ProtobuffTest() {
        UserProto.User user = UserProto.User.newBuilder()
                .setId(14323532L)
                .setName("haah")
                .setAge(23)
                .setSex(true)
                .addAllIdentifies(Lists.newArrayList("moyada", "people", "person", "animal"))
                .putInfo("haha", "666")
                .putInfo("test", "111")
                .build();

        test(new ProtobufSerializer(), user);
    }

    @Test
    public void ThriftTest() {
        SharedStruct test = new SharedStruct().setKey(23).setValue("test");
        test(new ThriftSerializer(), test);
    }

    @Test
    public void AvroTest() {
        Map<CharSequence, CharSequence> info = new HashMap<>();
        info.put("haha", "666");
        info.put("test", "111");

        User user = User.newBuilder()
                .setId(34501231422L)
                .setName("moyada")
                .setAge(18)
                .setSex(true)
                .setScope(33.23)
                .setIdentifies(Lists.newArrayList("moyada", "people", "person", "animal"))
                .setInfo(info)
                .build();

        test(new AvroSerializer(), user);
    }

    private <T> void test(Serializer<T> serializer) {
        Map<String, String> info = new HashMap<>();
        info.put("haha", "666");
        info.put("test", "111");

        io.moyada.serializer.data.User user = new io.moyada.serializer.data.User();
        user.setId(34501231422L);
        user.setName("moyada");
        user.setAge(18);
        user.setSex(true);
        user.setIdentifies(Lists.newArrayList("moyada", "people", "person", "animal"));
        user.setInfo(info);

        test(serializer, user);
    }

    private <T> void test(Serializer<T> serializer, Object value) {
        T data = serializer.serialize(value);

        if (data instanceof byte[]) {
            System.out.println(((byte[])data).length);
        } else {
            System.out.println(String.valueOf(data).getBytes().length);
        }

        Object obj = serializer.deserialize(data, value.getClass());
        System.out.println(obj);
    }
}
