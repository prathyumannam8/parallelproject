package com.cg.bankwallet.beans;

import java.time.LocalDateTime;

public class Account {
	//Getters and Setters
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	//Constructor
	public Account(String mobileNo, String name, String email, double balance,
			LocalDateTime date) {
		super();
		this.mobileNo = mobileNo;
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.date = date;
	}
	private String mobileNo; 
	private String name;
    private String email;
    private double balance;
    LocalDateTime date;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

}
