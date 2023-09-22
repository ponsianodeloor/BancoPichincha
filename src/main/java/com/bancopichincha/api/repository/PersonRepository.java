package com.bancopichincha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancopichincha.api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
