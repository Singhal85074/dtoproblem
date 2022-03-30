package com.example.demodtoonetomany.controller;

import com.example.demodtoonetomany.dto.UserDTO;
import com.example.demodtoonetomany.entity.User;
import com.example.demodtoonetomany.repository.UserRepository;
import com.example.demodtoonetomany.service.UserDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserLocationController {

    @Autowired
    UserDTOService userDTOService;

    @Autowired
    UserRepository repo;

    @GetMapping("/users")
    public List<UserDTO> getAllUsersLocation(){
        return userDTOService.getAllUsersLocation();
    }

    @GetMapping("/userdata")
    public List<User> getAUsersLocation(){
        return repo.findAll();
    }


}
