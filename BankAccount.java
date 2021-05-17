package com.meritamerica.assignment4;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankAccount {

	private double balance;
	private double interestRate;
	long accountNumber;
	double futureValue;
	double accountTotal;
	private MeritBank m = new MeritBank();
	java.util.Date accountOpenedOn;
	private Date date;

	// TODO Auto-generated constructor stub

	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
		accountOpenedOn = accountOpenedOn();
		accountNumber = getAccountNumber();
	}

	public BankAccount(long accountNumber, double balance, double interestRate) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		accountOpenedOn = accountOpenedOn();
	}

	BankAccount(double balance, double interestRate, java.util.Date accountOpenedOn) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;
		accountNumber = getAccountNumber();
	}

	BankAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;
		this.accountNumber = accountNumber;
	}

	public java.util.Date accountOpenedOn() {
		java.util.Date date = new java.util.Date();
		return date;
	}

	public java.util.Date getOpenedOn() {
		return accountOpenedOn;
	}

	public long getAccountNumber() {
		System.out.println("AccountNumber");
		return accountNumber;
	}

	public double getBalance() {
		return this.balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public boolean withdraw(double amount) {

		if ((balance - amount) >= 0) {
			balance = balance - amount;
			return true;
		} else
			return false;
	}

	public boolean deposit(double amount) {
		if (amount < 0) {
			return false;
		} else if ((this.balance + amount) <= 250000) {
			System.out.println("Deposit bank: " + amount);
			this.balance = this.balance + amount;
			return true;
		} else
			System.out.println("more than 250000");
		    return false;

	}

	public double recursiveFutureValue(int years, double balance, double interest) {
		if (years == 0) {
			balance = this.balance;
			return balance;
		}
		else if (years ==1) {
			balance += balance*interest;
		}
		else {
			return (recursiveFutureValue(years-1, interest,balance)) + recursiveFutureValue(years-1,interest, balance)-( recursiveFutureValue(years-2, interest,balance));
		}
		return balance;
	}

	public String toString() {
		return "";
	}

	public Date dateAccountOpened(String string) {
		try {

			DateFormat startDate = new SimpleDateFormat("dd/MM/yyyy");
			Date date = (Date)startDate.parse(string);
			this.date = date;
			return this.date;
		} catch (ParseException e) 
		{
			System.out.println();
		}
		return this.date;

	}
}