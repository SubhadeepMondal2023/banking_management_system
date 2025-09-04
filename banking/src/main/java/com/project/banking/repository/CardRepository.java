package com.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.banking.entity.Card;

import java.util.List;
import java.util.Optional;

/**
 * This interface represents a repository for managing {@link Card} entities.
 * It extends Spring Data JPA's {@link JpaRepository} to provide basic CRUD operations.
 */
public interface CardRepository extends JpaRepository<Card, String> {

    /**
     * Checks if a card with the given card number exists in the database.
     *
     * @param cardNumber the card number to check
     * @return {@code true} if a card with the given card number exists, {@code false} otherwise
     */
    boolean existsByCardNumber(double cardNumber);

    /**
     * Finds a {@link Card} entity by its owner's unique identifier (UID).
     *
     * @param uid the owner's UID
     * @return an {@link Optional} containing the {@link Card} entity if found, or an empty {@link Optional} if not found
     */
    Optional<Card> findByOwnerUid(String uid);
}