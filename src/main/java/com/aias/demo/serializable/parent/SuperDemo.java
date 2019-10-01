package com.aias.demo.serializable.parent;


import java.io.*;

public class SuperDemo {
    public static void main(String[] args) {
        serializablePerson();
        deSerializablePerson();

    }

    private static void serializablePerson() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("person")));
            User person = new User();
            person.setAge(12);
            oos.writeObject(person);
            System.out.println("序列化成功");
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deSerializablePerson() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("person")));

            User person = (User) ois.readObject();

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
