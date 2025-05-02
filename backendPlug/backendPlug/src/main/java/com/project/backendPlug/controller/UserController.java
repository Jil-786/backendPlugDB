package com.project.backendPlug.controller;

import com.project.backendPlug.model.UserModel;
import com.project.backendPlug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public Map<String, String> signup(@RequestBody UserModel userEntity) {
        Map<String, String> response = new HashMap<>();
        if (userService.getEntityByEmail(userEntity.getEmail()) != null) {
            response.put("message", "Email already exists");
            return response;
        }
        userService.createUser(userEntity);
        response.put("message", "Signup successful");
        response.put("token", "mock-token-" + userEntity.getEmail()); // replace with real JWT later
        return response;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> loginData) {
        Map<String, String> response = new HashMap<>();
        String email = loginData.get("email");
        String password = loginData.get("password");

        if (userService.authenticate(email, password)) {
            response.put("message", "Login successful");
            response.put("token", "mock-token-" + email); // replace with real JWT later
        } else {
            response.put("message", "Invalid email or password");
        }
        return response;
    }
}
