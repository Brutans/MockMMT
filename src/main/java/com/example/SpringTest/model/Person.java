package com.example.SpringTest.model;

import com.example.SpringTest.entity.PersonEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private Long id;
    private String username;


    public static Person toModel(PersonEntity entity){
        Person model = new Person();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        return model;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
