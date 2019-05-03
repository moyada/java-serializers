package io.moyada.serializer.jmh;

import avro.shaded.com.google.common.collect.Lists;
import io.moyada.serializer.*;
import io.moyada.serializer.data.User;
import io.moyada.serializer.data.proto.UserProto;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author xueyikang
 * @since 1.0
 **/
@Fork(value = 2, jvmArgs = {"-server", "-Xms2048m", "-Xmx2048m", "-XX:+UseTLAB", "-XX:+UseG1GC"})
@State(Scope.Benchmark)
@Threads(10)
@Measurement(time = 60, iterations = 5)
@Warmup(time = 40, iterations = 3)
//@CompilerControl(CompilerControl.Mode.INLINE)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode({Mode.AverageTime})
public class DeserAvgt extends AbstractBenchMark {

    @Param({"821223455207111"})
    private long id;

    @Param({"桂花srt-123"})
    private String name;

    @Param({"18"})
    private int age;

    @Param({"14232.4304"})
    private double scope;

    @Param({"true"})
    private boolean sex;

    private ByteArraySerializer fastJsonSerializer;
    private ProtobufSerializer protobufSerializer;
    private ByteArraySerializer protostuffSerializer;
    private ByteArraySerializer kryoSerializer;
    private ByteArraySerializer hessianSerializer;
    private ByteArraySerializer avroSerializer;
    private ByteArraySerializer jacksonSerializer;
    private StringSerializer gsonSerializer;

    private Map<String, byte[]> DATA = new HashMap<>();
    
    private String gjson;

    public static void main(String[] args) throws RunnerException {
        new Runner(getOptional(DeserAvgt.class.getSimpleName())).run();
    }

    @Setup
    public void setup() {
        fastJsonSerializer = new FastJsonSerializer();
        protobufSerializer = new ProtobufSerializer();
        protostuffSerializer = new ProtostuffSerializer();
        kryoSerializer = new KryoSerializer();
        hessianSerializer = new HessianSerializer();
        avroSerializer = new AvroSerializer();
        jacksonSerializer = new JacksonSerializer();
        gsonSerializer = new GsonSerializer();
        prepareData();
    }

    private void prepareData() {
        User user = getUser();
        
        gjson = gsonSerializer.serialize(user);
        
        DATA.put("fastJsonSerializer", fastJsonSerializer.serialize(user));
        DATA.put("protostuffSerializer", protostuffSerializer.serialize(user));
        DATA.put("kryoSerializer", kryoSerializer.serialize(user));
        DATA.put("hessianSerializer", hessianSerializer.serialize(user));
        DATA.put("jacksonSerializer", jacksonSerializer.serialize(user));

        Map<CharSequence, CharSequence> map = new HashMap<>();
        map.put("price", Double.toString(ThreadLocalRandom.current().nextDouble()));
        map.put("test", Double.toString(scope));
        map.put("rank", Integer.toString(ThreadLocalRandom.current().nextInt(100)));
        map.put("time", Long.toString(System.currentTimeMillis()));

        io.moyada.serializer.data.avro.User d1 = io.moyada.serializer.data.avro.User.newBuilder()
                .setId(id)
                .setName(name)
                .setAge(age)
                .setSex(true)
                .setScope(ThreadLocalRandom.current().nextDouble())
                .setIdentifies(Lists.newArrayList("豆腐干", "@moyada", "people", "person", "animal", "test-"))
                .setInfo(map)
                .build();
        DATA.put("avroSerializer", avroSerializer.serialize(d1));

        UserProto.User d2 = UserProto.User.newBuilder()
                .setId(id)
                .setName(name)
                .setAge(age)
                .setSex(true)
                .setScope(ThreadLocalRandom.current().nextDouble())
                .addAllIdentifies(Lists.newArrayList("豆腐干", "@moyada", "people", "person", "animal", "test-"))
                .putAllInfo(getInfo())
                .build();
        DATA.put("protobufSerializer", protobufSerializer.serialize(d2));
    }

    @Benchmark
    public void AvroDeserialize() {
        avroSerializer.deserialize(DATA.get("avroSerializer"), io.moyada.serializer.data.avro.User.class);
    }

    @Benchmark
    public void ProtobufDeserialize() {
        protobufSerializer.deserialize(DATA.get("protobufSerializer"), UserProto.User.class);
    }

    @Benchmark
    public void ProtostuffDeserialize() {
        protostuffSerializer.deserialize(DATA.get("protostuffSerializer"), User.class);
    }

    @Benchmark
    public void HessianDeserialize() {
        hessianSerializer.deserialize(DATA.get("hessianSerializer"), User.class);
    }

    @Benchmark
    public void KryoDeserialize() {
        kryoSerializer.deserialize(DATA.get("kryoSerializer"), User.class);
    }

    @Benchmark
    public void FastjsonDeerialize() {
        fastJsonSerializer.deserialize(DATA.get("fastJsonSerializer"), User.class);
    }

    @Benchmark
    public void JacksonDeserialize() {
        jacksonSerializer.deserialize(DATA.get("jacksonSerializer"), User.class);
    }

    @Benchmark
    public void GsonDeserialize() {
        gsonSerializer.deserialize(gjson, User.class);
    }

    private User getUser() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setSex(true);
        user.setScope(ThreadLocalRandom.current().nextDouble());
        user.setIdentifies(Lists.newArrayList( "豆腐干", "moyada", "people", "person", "animal", "test"));
        user.setInfo(getInfo());
        return user;
    }

    private Map<String, String> getInfo() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("price", Double.toString(ThreadLocalRandom.current().nextDouble()));
        map.put("test", Double.toString(scope));
        map.put("rank", Integer.toString(ThreadLocalRandom.current().nextInt(100)));
        map.put("time", Long.toString(System.currentTimeMillis()));
        return map;
    }
}
