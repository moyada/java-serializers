package io.moyada.serializer.test;

import avro.shaded.com.google.common.collect.Lists;
import io.moyada.serializer.*;
import io.moyada.serializer.data.avro.User;
import io.moyada.serializer.data.proto.UserProto;
import io.moyada.serializer.data.thrift.SharedStruct;
import io.moyada.serializer.utils.ClassUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xueyikang
 * @since 1.0
 **/
public class SerializerTest {

    private Calendar calendar = Calendar.getInstance();

    public SerializerTest() {
        calendar.set(1991, Calendar.DECEMBER, 29, 12, 0);
    }

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
//        Timestamp.newBuilder().setSeconds(TimeUnit.MILLISECONDS.toSeconds(calendar.getTimeInMillis()));
        UserProto.User user = UserProto.User.newBuilder()
                .setId(14323532L)
                .setName("haah")
                .setAge(23)
                .setGender(true)
                .addAllIdentifies(Lists.newArrayList("moyada", "people", "person", "animal"))
                .putInfo("haha", "666")
                .putInfo("test", "111")
//                .setBirthDay(Timestamp.getDefaultInstance())
                .build();

        test(new ProtobufSerializer(), user);
    }

//    @Test
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
                .setGender(true)
                .setScope(33.23)
                .setIdentifies(Lists.newArrayList("moyada", "people", "person", "animal"))
                .setInfo(info)
                .build();

        test(new AvroSerializer(), user);
    }

    private <T> void test(Serializer<Object, T> serializer) {
        Map<String, String> info = new HashMap<>();
        info.put("haha", "666");
        info.put("test", "111");

        io.moyada.serializer.data.User user = new io.moyada.serializer.data.User();
        user.setId(34501231422L);
        user.setName("moyada");
        user.setAge(18);
        user.setGender(true);
        user.setIdentifies(Lists.newArrayList("moyada", "people", "person", "animal"));
        user.setInfo(info);

        test(serializer, user);
    }

    private <C, T> void test(Serializer<C, T> serializer, C value) {
        System.out.print(serializer.getClass().getSimpleName() + "  ");

        T data = serializer.serialize(value);

        if (data instanceof byte[]) {
            System.out.println(((byte[])data).length);
        } else {
            System.out.println(String.valueOf(data).getBytes().length);
        }

        C obj = serializer.deserialize(data, ClassUtil.getClass(value));

        System.out.println(value);
        Assertions.assertEquals(value, obj);
    }
}
