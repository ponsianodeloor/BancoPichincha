package com.bancopichincha.api.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancopichincha.api.model.Person;
import com.bancopichincha.api.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonRest {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping ResponseEntity<List<Person>> getAllPersons(){
		return ResponseEntity.ok(personService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Person> savePerson (@RequestBody Person person){
		try {
			Person savedPerson = personService.save(person);		
		return ResponseEntity.created(new URI("/person/"+savedPerson.getId())).body(savedPerson);
		} catch (Exception e) {
			System.out.println("Error " + e.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
