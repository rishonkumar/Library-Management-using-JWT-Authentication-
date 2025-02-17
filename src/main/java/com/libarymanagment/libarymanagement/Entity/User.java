package com.libarymanagment.libarymanagement.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    //this will create a new table in DB with column name id and roles and
    // EAGER because data will be laoded immediately when the user entity is feteched from the DB
    private Set<String> roles;
}
