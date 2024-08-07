package com.aprender.userCRUD.controller;

import com.aprender.userCRUD.model.User;
import com.aprender.userCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public ResponseEntity<Object> getUser(@PathVariable String username){
        return userService.getUser(username);
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user){
        return userService.postUser(user);
    }

    @PutMapping("/{username}")
    public ResponseEntity<Object> updateUser(@PathVariable String username, @RequestBody User user){
        return userService.updateUser(username, user);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable String username){
        return userService.deleteUser(username);
    }

}
