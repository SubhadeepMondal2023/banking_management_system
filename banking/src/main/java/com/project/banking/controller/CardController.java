package com.project.banking.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.project.banking.entity.Card;
import com.project.banking.entity.Transaction;
import com.project.banking.entity.User;
import com.project.banking.service.CardService;

/**
 * This class is responsible for handling HTTP requests related to card operations.
 * It uses Spring MVC annotations to map requests to specific methods.
 */
@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    /**
     * Retrieves the card details of the authenticated user.
     *
     * @param authentication The current authentication object, which contains the authenticated user.
     * @return A ResponseEntity containing the card details if the operation is successful.
     */
    @GetMapping
    public ResponseEntity<Card> getCard(Authentication authentication){
        var user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(cardService.getCard(user));
    }

    /**
     * Creates a new card for the authenticated user with the specified initial amount.
     *
     * @param amount The initial amount to be credited to the new card.
     * @param authentication The current authentication object, which contains the authenticated user.
     * @return A ResponseEntity containing the newly created card if the operation is successful.
     * @throws Exception If any error occurs during the card creation process.
     */
    @PostMapping("/create")
    public ResponseEntity<Card> createCard(@RequestParam double amount, Authentication authentication) throws Exception {
        var user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(cardService.createCard(amount, user));
    }

    /**
     * Credits the authenticated user's card with the specified amount.
     *
     * @param amount The amount to be credited to the user's card.
     * @param authentication The current authentication object, which contains the authenticated user.
     * @return A ResponseEntity containing the transaction details if the operation is successful.
     */
    @PostMapping("/credit")
    public ResponseEntity<Transaction> creditCard(@RequestParam double amount, Authentication authentication){
        var user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(cardService.creditCard(amount, user));
    }

    /**
     * Debits the authenticated user's card with the specified amount.
     *
     * @param amount The amount to be debited from the user's card.
     * @param authentication The current authentication object, which contains the authenticated user.
     * @return A ResponseEntity containing the transaction details if the operation is successful.
     */
    @PostMapping("/debit")
    public ResponseEntity<Transaction> debitCard(@RequestParam double amount, Authentication authentication){
        var user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(cardService.debitCard(amount, user));
    }
}