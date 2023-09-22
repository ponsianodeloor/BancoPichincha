package com.bancopichincha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancopichincha.api.model.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {

}
