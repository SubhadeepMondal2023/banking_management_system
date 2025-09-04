package com.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.banking.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
    User findByUsernameIgnoreCase(String username);
}
