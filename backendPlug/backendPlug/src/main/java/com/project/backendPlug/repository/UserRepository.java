package com.project.backendPlug.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.backendPlug.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
   
    UserEntity findByEmail(String email);
}
