package com.devmountain.sleepTracker.entities;



import com.devmountain.sleepTracker.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public User(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    // create private members and use getters and setters to access them
    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @OneToMany(mappedBy = "user", fetch= FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Sleep> SleepSet = new HashSet<>();

    public User(UserDto userDto){
        if (userDto.getUsername() != null){
            this.username = userDto.getUsername();
        }
        if (userDto.getPassword() != null){
            this.password = userDto.getPassword();
        }
        if (userDto.getEmail() != null){
            this.email = userDto.getEmail();
        }

}}
