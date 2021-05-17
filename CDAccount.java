package com.meritamerica.assignment4;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CDAccount extends BankAccount {
	
	public static long accounts;
	private long account;
	private double balance;
	private  Date date;
	private CDOffering offering;
	private double interestRate;
	
	CDAccount(CDOffering offering, double balance) {
		super(balance,offering.getInterestRate());
		this.offering = offering;
		this.balance = balance;
	}
	CDAccount(CDOffering offering, double balance, long accountNumber, java.util.Date date) {
		super(accountNumber, balance, offering.getInterestRate(), date);
		this.offering = offering;
	}
	CDAccount(long accountNumber, double balance, double interest, Date date, int term) {
		
		super(accountNumber, balance, interest, date);
		this.balance = balance;
		offering = new CDOffering(term, interest);
		
	}
	public void setAccount() {
		this.account = account;
	}
	public double getBalance() {
		return this.balance;
	}

	public double getInterestRate() {
		return this.offering.getInterestRate();
	}
	public int getTerm() {
		return this.offering.getTerm();
	}
	public Date getStartDate() {
		return this.date;
	}
	public long getAccountNumber() {
		return super.getAccountNumber();
	}
	
	public boolean withdraw(double x) {

		return false;
		}
	public boolean deposit(double x) {
		
		return false;
		}
	public double futureValue(int years) {
	
		return MeritBank.futureValue(balance, years , interestRate);
	}
	
	public static CDAccount readFromString(String s) throws ParseException {
		String[] tokens = s.split(",");
		long accountNumber = Long.parseLong(tokens[0]);
		double b = Double.parseDouble(tokens[1]);
		double interest = Double.parseDouble(tokens[2]);
		SimpleDateFormat sdfmt1 = new SimpleDateFormat("dd/MM/yy");
		
		 	Date date = (Date)sdfmt1.parse(tokens[3]);
		int term = Integer.parseInt(tokens[4]);
		CDAccount account = new CDAccount(accountNumber, b, interest, date, term);
		return account;
	}

}
