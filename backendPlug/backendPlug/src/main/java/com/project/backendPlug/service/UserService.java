package com.project.backendPlug.service;

import com.project.backendPlug.entity.UserEntity;
import com.project.backendPlug.model.UserModel;
import com.project.backendPlug.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Convert Entity to Model
    private UserModel convertToModel(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserModel.class);
    }

    // Get a User by ID
    public UserModel getUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity==null) {
            return null;
        }
        return convertToModel(userEntity);
    }

    // Create or Update User
    public UserModel createUser(UserEntity userEntity) {
    	
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return convertToModel(savedUserEntity);
    }

    // Other methods like updating user, deleting user, etc.
}
