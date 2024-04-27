package com.example.SpringTest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;// post
    private String password;// post
    private String firstname;
    private String lastname;
    private String patronymic;
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime registrationDate;
    @Column(nullable = false)
    private int maxExplorers;// post
    @Column(nullable = false)
    private String email;
    private String phoneNumber;
    private String skype;
    private String telegram;
    @Column(nullable = false)
    private Boolean isVisiblePrivateData; // post
    private Boolean isKeeper; //post

    public PersonEntity() {
    }
}
