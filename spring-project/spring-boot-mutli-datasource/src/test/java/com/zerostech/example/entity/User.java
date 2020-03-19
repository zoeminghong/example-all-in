package com.zerostech.example.entity;

import java.io.Serializable;

/**
 * Created on 2020-03-18.
 *
 * @author 迹_Jason
 */
public class User implements Serializable {

    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }
}
