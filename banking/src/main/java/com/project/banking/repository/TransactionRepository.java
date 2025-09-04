package com.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.banking.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String>{

}
