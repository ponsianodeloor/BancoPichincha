package com.bancopichincha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancopichincha.api.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
