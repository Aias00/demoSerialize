package com.aias.demo.serializable.parent;

import java.io.Serializable;

public class User extends SuperUser implements Serializable {
    private static final long serialVersionUID = -2080509601287631215L;


    @Override
    public String toString() {
        return "User{}" + super.toString();
    }
}
