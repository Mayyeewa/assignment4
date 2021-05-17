package com.meritamerica.assignment4;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;

public class CheckingAccount extends BankAccount {

	final static double INTEREST_RATE = 0.0001;
	private static double balance;
	private static Date date;

	CheckingAccount(double openingBalance) {
		super(openingBalance,INTEREST_RATE);
	}

	CheckingAccount() {
		super(MeritBank.getNextAccountNumber(), balance, INTEREST_RATE, date);
	}

	public CheckingAccount(long accountNumber, double balance, double interestRate) {
		super(accountNumber, balance, interestRate);
	}

	public CheckingAccount(double balance, double interestRate, java.util.Date accountOpenedOn) {
		super(balance, interestRate, accountOpenedOn);
	}
	public CheckingAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn) {
		super(accountNumber, balance, interestRate, accountOpenedOn);
	}

	public static CheckingAccount readFromString(String s) throws ParseException {
		double balance;
		double interest;
		long accountN;
		Date date;
		CheckingAccount account = new CheckingAccount();
		
		String[] tokens = s.split(",");
		try {
			accountN = Long.parseLong(tokens[0]);
			balance = Double.parseDouble(tokens[1]);
			interest = Double.parseDouble(tokens[2]);
			date = account.dateAccountOpened(tokens[3]);
		} catch (NumberFormatException e) {
			throw e;
		}
		CheckingAccount account1 = new CheckingAccount(accountN, balance, interest, date);
		return account1;
	}
	public double futureValue(int years) {
		double futureAmount = 0;
		futureAmount = this.getBalance() * Math.pow((1+INTEREST_RATE), years);
		return futureAmount;
	}
	}
