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

import com.bancopichincha.api.model.Account;
import com.bancopichincha.api.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountRest {

	@Autowired
	protected AccountService accountService;
	
	@GetMapping
	private ResponseEntity<List<Account>> getAllClients(){
		return ResponseEntity.ok(accountService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Account> saveClient (@RequestBody Account account){
		try {
			Account savedAccount = accountService.save(account);		
		return ResponseEntity.created(new URI("/account/"+savedAccount.getId())).body(savedAccount);
		} catch (Exception e) {
			System.out.println("Error " + e.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
