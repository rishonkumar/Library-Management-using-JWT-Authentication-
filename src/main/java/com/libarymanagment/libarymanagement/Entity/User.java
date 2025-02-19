package com.libarymanagment.libarymanagement.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User implements UserDetails {

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //For admin we are giving 2 roles ROLE_USER and ROLE_ADMIN so we need to wrap both the
        //roles in SimpleGrantedAuthority
        return roles.stream().map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public String getUsername() {
        return "";
    }
}
