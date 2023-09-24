package com.bancopichincha.api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	private int transactionType;
	private int balance;
	private int amount;
	private int newBalance;
	private String description;
	private LocalDateTime  dateRegister;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(
			Account account, 
			int transactionType, 
			int balance, 
			int amount, 
			int newBalance, 
			String description, 
			LocalDateTime dateRegister
	){
		super();
		this.account = account;
		this.transactionType = transactionType;
		this.balance = balance;
		this.amount = amount;
		this.newBalance = newBalance;
		this.description = description;
		this.dateRegister = dateRegister;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}

	public int getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getNewBalance() {
		return newBalance;
	}

	public void setNewBalance(int newBalance) {
		this.newBalance = newBalance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(LocalDateTime dateRegister) {
		this.dateRegister = dateRegister;
	}
	
}
