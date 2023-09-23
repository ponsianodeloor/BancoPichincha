package com.bancopichincha.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	private int balance;
	
	private int amount;
	private int new_balance;
	private String description;
	
	public Transactions() {
		// TODO Auto-generated constructor stub
	}

	public Transactions(Account account, int balance, int amount, int new_balance, String description) {
		super();
		this.account = account;
		this.balance = balance;
		this.amount = amount;
		this.new_balance = new_balance;
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

	public void setAccountFrom(Account accountFrom) {
		this.account = accountFrom;
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

	public int getNew_balance() {
		return new_balance;
	}

	public void setNew_balance(int new_balance) {
		this.new_balance = new_balance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
