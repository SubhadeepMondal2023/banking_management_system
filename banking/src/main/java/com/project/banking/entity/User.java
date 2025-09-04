package com.project.banking.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank_user")
public class User {

    /**
     * Unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uid;
    private String firstname;
    private String lastname;
    /**
     * Unique username for the user.
     */
    @Column(nullable = false, unique = true)
    private String username;
    /**
     * Date of birth of the user.
     */
    private Date dob;
    private long tel;
    private String tag;
    /**
     * Encrypted password for the user.
    Why it’s used for password
    Passwords (even encrypted/hashed) should never be exposed in API responses for security reasons.
    Without @JsonIgnore, returning a User object could leak sensitive data.
     */
    @JsonIgnore
    private String password;
    private String gender;
    /**
     * Timestamp of when the user was created.
     */
    @CreationTimestamp
    private LocalDateTime createdAt;
    /**
     * Timestamp of when the user was last updated.
     */
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    /**
     * List of roles assigned to the user.
     */
    private List<String> roles;
    /**
     * One-to-one relationship with the Card entity, representing the user's card.
     */
    @OneToOne(mappedBy = "owner")
    private Card card;
    /**
     * One-to-many relationship with the Transaction entity, representing the user's transactions.
     */
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Transaction> transactions;

    /**
     * One-to-many relationship with the Account entity, representing the user's accounts.
     */
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Account> accounts;

}
