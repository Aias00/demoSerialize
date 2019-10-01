package com.aias.demo.serializable.clone;

import java.io.*;

public class Teacher implements Serializable {
    private static final long serialVersionUID = 1157094378529811726L;


    private int age;

    private String name;


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
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
