package com.meritamerica.assignment4;

public class CDOffering {
	
	private int term;
	private double interestRate;
	
	CDOffering() {
		
	}

	CDOffering(int term, double interestRate) {
		this.term = term;
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public int getTerm() {
		
		return this.term;
	}
   public static CDOffering readFromString(String line) {
	   String[] tokens = line.split(",",2);
	   int term = Integer.parseInt(tokens[0]);
	   double interestRate = Double.parseDouble(tokens[1]);
	   CDOffering offer = new CDOffering(term, interestRate);
	   return offer;
   }
}
