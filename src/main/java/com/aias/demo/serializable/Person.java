package com.aias.demo.serializable;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 5659825564074602270L;
    transient private int age;

    private String name;

    public static int height = 3;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
