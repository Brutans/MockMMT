package com.example.SpringTest.controller;

import com.example.SpringTest.entity.PersonEntity;
import com.example.SpringTest.exception.PersonAlredyExistException;
import com.example.SpringTest.exception.PersonNotFoundException;
import com.example.SpringTest.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    @Operation(summary = "Registration", tags = "auth")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Registration person",
                    content = {
                            @Content(
                                    mediaType = "application/json"
                            )
                    })
    })
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
    @Operation(summary = "Get", tags = "get")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Get person by id",
                    content = {
                            @Content(
                                    mediaType = "application/json"
                            )
                    })
    })
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
    @Operation(summary = "Get", tags = "get")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Get persons by isKeeper",
                    content = {
                            @Content(
                                    mediaType = "application/json"
                            )
                    })
    })
    public ResponseEntity getAllKeepers(@RequestParam Boolean value){
        try{
            return ResponseEntity.ok(personService.getAllByIsKeeper(value));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete", tags = "del")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Delete person by id",
                    content = {
                            @Content(
                                    mediaType = "application/json"
                            )
                    })
    })
    public ResponseEntity deleteUser(@PathVariable Long id){
        try{
            return ResponseEntity.ok(personService.delete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
