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
    @Transient
    private Long employeeId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String patronymic;
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime registrationDate;
    @Column(nullable = false)
    private int maxExplorers;
    @Column(nullable = false)
    private String email;
    private String phoneNumber;
    private String skype;
    private String telegram;
    @Column(nullable = false)
    private Boolean isVisiblePrivateData;
    private Boolean isKeeper;

    public PersonEntity() {
    }
    public Long getEmployeeId() {
        return id;
    }
}
