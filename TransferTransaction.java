package com.meritamerica.assignment4;

public class TransferTransaction extends Transaction {
	public TransferTransaction() {
		
	}
	TransferTransaction(BankAccount sourceAccount, BankAccount targetAccount, double amount) {
		
		super();
	}
	@Override
	public void process()
					throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		
	}

}
