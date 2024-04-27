package com.example.SpringTest.entity;

import java.util.List;

public class PersonEntityWrapper {

    private List<PersonEntity> personEntities;

    public PersonEntityWrapper(List<PersonEntity> personEntities) {
        this.personEntities = personEntities;
    }

    public List<PersonEntity> getPersonEntities() {
        return personEntities;
    }

    public void setPersonEntities(List<PersonEntity> personEntities) {
        this.personEntities = personEntities;
    }
}
