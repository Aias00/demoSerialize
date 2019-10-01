package com.aias.demo.serializable;

import java.io.*;

public class DemoSerializable {
    public static void main(String[] args) {
        // 序列化
        serializablePerson();

//        Person.height = 4;

        // 反序列化
//        deSerializablePerson();

    }

    private static void serializablePerson() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("person")));
            Person person = new Person();

            person.setAge(12);
            person.setName("zhangsan");
            oos.writeObject(person);
            oos.flush();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("person")));
            Person person1 = (Person) ois.readObject();
//            person.setName("lisi");
            oos.writeObject(person);
            oos.flush();
            System.out.println("序列化成功，" + new File("person").length());

            Person person2 = (Person) ois.readObject();
            System.out.println(person1 == person2);
            System.out.println(person1);
            System.out.println(person2);


            oos.close();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void deSerializablePerson() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("person")));

            Person person = (Person) ois.readObject();

            System.out.println("反序列化完成");

            System.out.println(person);
            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
