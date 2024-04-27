package com.example.SpringTest.repository;

import com.example.SpringTest.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepo extends CrudRepository<PersonEntity, Long> {
    PersonEntity findByUsername(String username);
    List<PersonEntity> findByIsKeeper(Boolean isKeeper);
}
