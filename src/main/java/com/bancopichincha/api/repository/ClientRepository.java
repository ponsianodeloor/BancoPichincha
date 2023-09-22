package com.bancopichincha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancopichincha.api.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
