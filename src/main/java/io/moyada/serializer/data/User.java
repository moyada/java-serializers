package io.moyada.serializer.data;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author xueyikang
 * @since 1.0
 **/
@ToString
@Data
public class User implements Serializable {

    private long id;
    private String name;
    private int age;
    private boolean sex;
    private double scope;
    private List<String> identifies;
    private Map<String, String> info;
}
