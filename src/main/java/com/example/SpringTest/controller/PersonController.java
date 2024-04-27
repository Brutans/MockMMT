package com.example.SpringTest.controller;

import com.example.SpringTest.entity.PersonEntity;
import com.example.SpringTest.entity.PersonEntityWrapper;
import com.example.SpringTest.exception.PersonAlredyExistException;
import com.example.SpringTest.exception.PersonNotFoundException;
import com.example.SpringTest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public  ResponseEntity registration(@RequestBody PersonEntity person){
        try{
            personService.registration(person);
            return ResponseEntity.ok("Пользователь был успешно сохранён");
        }catch (PersonAlredyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try{
            return ResponseEntity.ok(personService.getOne(id));
        } catch (PersonNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping("/{isKeeper}")
    public ResponseEntity getAllKeepers(@RequestParam Boolean value){
        try{
            return ResponseEntity.ok(new PersonEntityWrapper(personService.getAllByIsKeeper(value)));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try{
            return ResponseEntity.ok(personService.delete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
