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
import com.bancopichincha.api.model.Transaction;
import com.bancopichincha.api.service.AccountService;
import com.bancopichincha.api.service.TransactionService;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/transaction")
public class TransactionRest {
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	AccountService accountService;
	
	@GetMapping
	private ResponseEntity<List<Transaction>> getAllTransactions(){
		return ResponseEntity.ok(transactionService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Transaction> saveTransaction (@RequestBody Transaction transaction){
		
		//obtener el balance de la cuenta bancaria del cliente 
		int balance = accountService.getReferenceById(transaction.getAccount().getId()).getBalance();
		int newBalance = 0;
		
		if (transaction.getTransactionType() == 1) {
			newBalance = balance + transaction.getAmount();
			transaction.setDescription("Deposito de " + transaction.getAmount());
		}
		
		if (transaction.getTransactionType() == 2 && balance > transaction.getAmount()) {
			newBalance = balance - transaction.getAmount();
			transaction.setDescription("Retiro de " + transaction.getAmount());
		}
		
		Account account = accountService.getReferenceById(transaction.getAccount().getId());
		account.setBalance(newBalance);
		
		accountService.save(account);
		
		
		transaction.setBalance(balance);
		transaction.setNewBalance(newBalance);
		transaction.setDateRegister(LocalDateTime.now());
		
		try {
			Transaction savedTransaction = transactionService.save(transaction);		
		return ResponseEntity.created(new URI("/account/"+savedTransaction.getId())).body(savedTransaction);
		} catch (Exception e) {
			System.out.println("Error " + e.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	

}
