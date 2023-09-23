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

import com.bancopichincha.api.model.AccountType;
import com.bancopichincha.api.service.AccountTypeService;

@RestController
@RequestMapping("/account_type")
public class AccountTypeRest {
	
	@Autowired
	protected AccountTypeService accountTypeService;
	
	@GetMapping
	private ResponseEntity<List<AccountType>> getAllClients(){
		return ResponseEntity.ok(accountTypeService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<AccountType> saveClient (@RequestBody AccountType accountType){
		try {
			AccountType savedAccountType = accountTypeService.save(accountType);		
		return ResponseEntity.created(new URI("/account_type/"+savedAccountType.getId())).body(savedAccountType);
		} catch (Exception e) {
			System.out.println("Error " + e.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
