package com.epam.gymappHibernate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean isActive;

    @OneToOne

    private  Trainee trainee;

    public User(String firstName, String lastName, String userName, String password, Long id, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.id = id;
        this.isActive = isActive;
    }


}
