package com.aprender.userCRUD.service;

import com.aprender.userCRUD.model.User;
import com.aprender.userCRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public ResponseEntity<Object> getUser(String username){
        Optional<User> res = userRepository.findById(username);

        if (res.isEmpty()){
            return new ResponseEntity<>("Error en la búsqueda", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }



}
