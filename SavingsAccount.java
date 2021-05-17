package com.meritamerica.assignment4;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SavingsAccount extends BankAccount {

	final static double INTEREST_RATE = 1.0 / 100;
	private static double openingBalance;
	private double interestRate;
	private double balance;
	private double futureValue;

	SavingsAccount(double openningBalance) {
		super(openingBalance, INTEREST_RATE);
	}

	SavingsAccount(long accountNumber, double balance, double interestRate) {

		super(accountNumber, balance, interestRate);
	}

	SavingsAccount(double balance, double interestRate, java.util.Date accountOpenedOn) {
		super(balance, interestRate, accountOpenedOn);
	}

	SavingsAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn) {
		super(accountNumber, balance, interestRate, accountOpenedOn);
	}

	public static SavingsAccount readFromString(String s) throws ParseException {
		String[] tokens = s.split(",");
		long accountNumber = Long.parseLong(tokens[0]);
		double b = Double.parseDouble(tokens[1]);
		double interest = Double.parseDouble(tokens[2]);
		SimpleDateFormat sdfmt1 = new SimpleDateFormat("dd/MM/yy");

		Date date = sdfmt1.parse(tokens[3]);

		SavingsAccount account = new SavingsAccount(accountNumber, b, interest, date);
		return account;
	}

	// checks for balance and withdraws
	public boolean withdraw(double amount) {
		if(this.balance >= amount) {
		this.balance = this.balance - amount;
		return super.withdraw(amount);
		} else {
		return false; 
		}
		}

	// checks amount and deposits
	public boolean deposit(double amount) {
		if(amount >0) {
			balance = balance+amount;
			return true;
		
		} else 
		{
					return false;
					} 
					}

	// calculates interest
	public double futureValue(int years) {
		this.futureValue = balance * Math.pow((1 + INTEREST_RATE), 3);
		return this.futureValue;
	}

	public String toString() {
					DecimalFormat numberFormat = new DecimalFormat("#.00");
					String fV = numberFormat.format(this.futureValue);
					String savingsAccount = "Balance: $" + this.balance +"\n" +
					"Interest Rate: " +this.interestRate+"\n"+
					"Balance in 3 years: " + fV ;;
					return savingsAccount;
					}


	}
		
	



