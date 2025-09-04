package com.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.banking.entity.User;
/**
 * This interface represents a repository for managing User entities.
 * It extends Spring Data JPA's JpaRepository to provide basic CRUD operations.
 */
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * Retrieves a User entity by its username, ignoring case sensitivity.
     *
     * @param username The username to search for.
     * @return          The User entity with the given username, or null if not found.
     */
    User findByUsernameIgnoreCase(String username);
}