package com.project.backendPlug.service;

import com.project.backendPlug.entity.UserEntity;
import com.project.backendPlug.model.UserModel;
import com.project.backendPlug.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    // Convert Model 2 Entity
    private UserEntity convertToEntity(UserModel userModel) {
        return modelMapper.map(userModel, UserEntity.class);
    }

    public UserModel getUserByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) return null;
        return new UserModel(user.getEmail(), user.getRole());
    }

    public void createUser(UserModel userModel) {
        String hashedPassword = BCrypt.hashpw(userModel.getPasswordHash(), BCrypt.gensalt());
        UserEntity userEntity=convertToEntity(userModel);
        userEntity.setPasswordHash(hashedPassword);
        userEntity.setRole("FREE");
        userEntity.setIsVerified(true);
        userEntity.setTokensLeftToday(1);
        userEntity.setCreatedAt(java.time.LocalDateTime.now());
        userEntity.setUpdatedAt(java.time.LocalDateTime.now());
        userRepository.save(userEntity);
    }

    public boolean authenticate(String email, String plainPassword) {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) return false;
        return BCrypt.checkpw(plainPassword, user.getPasswordHash());
    }

    public UserEntity getEntityByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
