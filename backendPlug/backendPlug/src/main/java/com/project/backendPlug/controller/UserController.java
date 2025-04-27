package com.project.backendPlug.controller;

import com.project.backendPlug.entity.UserEntity;
import com.project.backendPlug.model.UserModel;
import com.project.backendPlug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get User by ID
    @GetMapping("/{email}")
    public UserModel getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    // Create a new User
    @PostMapping("/")
    public String createUser(@RequestBody UserEntity userEntity) {
    	UserModel check=getUserByEmail(userEntity.getEmail());
    	if(check!=null) {
    		return "Email already Exists";
    	}
         userService.createUser(userEntity);
         return "data added";
    }

    
}
