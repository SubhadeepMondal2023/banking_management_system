package com.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.banking.entity.Card;

public interface CardRepository extends JpaRepository<Card, String>{

}
