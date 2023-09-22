package com.bancopichincha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancopichincha.api.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
