package com.aprender.userCRUD.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"user\"")
public class User {

    //enum Roles {CLIENT, EMPLOYEE}

    @Id
    private String username;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String role;
    @Column(unique = true, nullable = false)
    private String email;

    public User(){

    }

    public User(String username, String name, String role, String email) {

        this.username = username;
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
