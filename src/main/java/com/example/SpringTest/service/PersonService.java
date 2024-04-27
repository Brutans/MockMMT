package com.example.SpringTest.service;

import com.example.SpringTest.entity.PersonEntity;
import com.example.SpringTest.exception.PersonAlredyExistException;
import com.example.SpringTest.exception.PersonNotFoundException;
import com.example.SpringTest.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.GenerateUser;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;
    public PersonEntity registration(PersonEntity person) throws PersonAlredyExistException {
        if (personRepo.findByUsername(person.getUsername()) != null) {
            throw new PersonAlredyExistException("Пользователь с таким именем уже существует");
        }
        GenerateUser.generateRandomUser(person);
        return personRepo.save(person);
    }

    public PersonEntity getOne(Long id) throws PersonNotFoundException {
        PersonEntity user = personRepo.findById(id).get();
        if(user == null){
            throw new PersonNotFoundException("Пользователь не найден");
        }
        //return Person.toModel(user);
        return user;
    }

    public List<PersonEntity> getAllByIsKeeper(Boolean value) {
        return personRepo.findByIsKeeper(value);
    }


    public Long delete(Long id){
        personRepo.deleteById(id);
        return id;
    }
}
