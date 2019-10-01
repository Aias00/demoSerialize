package com.aias.demo.json;

import com.alibaba.fastjson.JSON;
import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.caucho.hessian.io.HessianSerializerInput;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class JsonDemo {
    private static Person init() {
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(19);
        return person;
    }


    public static void main(String[] args) throws IOException {
        jacksonDemo();
        faseJsonDemo();
        protobufDemo();
        hessianDemo();
    }

    private static void hessianDemo() throws IOException {
        Person person = init();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(baos);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            ho.writeObject(person);
            if(i == 0){
                System.out.println(baos.toByteArray().length);
            }
        }
        System.out.println("hessian序列化：" + (System.currentTimeMillis() - start) + " ms，总大小：" + baos.toByteArray().length);

        HessianInput hi = new HessianInput(new ByteArrayInputStream(baos.toByteArray()));

        Person person1 = (Person) hi.readObject();

        System.out.println(person1);


    }

    private static void protobufDemo() throws IOException {
        Person person = init();
        Codec<Person> codec = ProtobufProxy.create(Person.class, false);
        long start = System.currentTimeMillis();

        byte[] writeBytes = null;
        for (int i = 0; i < 10000; i++) {
            writeBytes = codec.encode(person);
        }
        System.out.println("protobuf序列化：" + (System.currentTimeMillis() - start) + " ms，总大小：" + writeBytes.length);

        Person person1 = codec.decode(writeBytes);

        System.out.println(person1);


    }

    private static void faseJsonDemo() throws IOException {
        Person person = init();
        String text = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            text = JSON.toJSONString(person);
        }
        System.out.println("fastJson序列化：" + (System.currentTimeMillis() - start) + " ms，总大小：" + text.length());

        Person person1 = JSON.parseObject(text, Person.class);

        System.out.println(person1);


    }

    private static void jacksonDemo() throws IOException {
        Person person = init();
        ObjectMapper mapper = new ObjectMapper();

        byte[] writeBytes = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            writeBytes = mapper.writeValueAsBytes(person);
        }
        System.out.println("Jackson序列化：" + (System.currentTimeMillis() - start) + " ms，总大小：" + writeBytes.length);

        Person person1 = mapper.readValue(writeBytes, Person.class);

        System.out.println(person1);


    }

}
