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


    public ResponseEntity<Object> postUser(User user) {
        Optional<User> res = userRepository.findById(user.getUsername());
        HashMap<String, Object> responseData = new HashMap<>();

        if (res.isPresent()){
            responseData.put("error", true);
            responseData.put("message", "El nombre de usuario ya está siendo utilizado");
            return new ResponseEntity<>(responseData, HttpStatus.CONFLICT);
        }
        else if (userRepository.findByEmail(user.getEmail()).isPresent()){
            responseData.put("error", true);
            responseData.put("message", "El email ya está siendo utilizado");
            return new ResponseEntity<>(responseData, HttpStatus.CONFLICT);
        }
        userRepository.save(user);
        responseData.put("message", "Usuario creado con éxito");
        responseData.put("data", user);
        return new ResponseEntity<>(responseData, HttpStatus.CREATED);

    }

    public ResponseEntity<Object> updateUser(String username, User user) {
        //Optional<User> res = userRepository.findById(username);
        HashMap<String, Object> responseData = new HashMap<>();

        if (!userRepository.existsById(username)){
            responseData.put("error", true);
            responseData.put("message", "No existe el usuario a actualizar");
            return new ResponseEntity<>(responseData, HttpStatus.CONFLICT);
        }
        userRepository.save(user);
        responseData.put("message", "Usuario actualizado con éxito");
        responseData.put("data", user);
        return new ResponseEntity<>(responseData, HttpStatus.ACCEPTED);
    }
}
