package com.meritamerica.assignment4;


public class AccountHolder implements Comparable<AccountHolder> {

	private static final double MAX_BALANCE_AMOUNT = 250000;

	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;

	private CheckingAccount[] amountCheckingAccounts = new CheckingAccount[0];
	private CheckingAccount clientCheckingAccount;
	private double checkingBalance = 0;

	private SavingsAccount[] amountSavingsAccounts = new SavingsAccount[0];
	private SavingsAccount clientSavingsAccount;
	private double savingsBalance = 0;

	private CDOffering cdOffering = new CDOffering(0, 0);

	public CDAccount[] amountCDAccounts = new CDAccount[0];
	public CDAccount cdAccount = new CDAccount(cdOffering, 0);
	private double cdBalance = 0;
	private int counterC = 0;
	private int counterS = 0;
	private int counterCD = 0;
	private double totalB = 0;
	private double combinedBalance;

	// AccountHolder Constructor (String, String, String, String)

	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
	}

	public String getFirstName() {
		return this.firstName;
	}
	public String getMiddleName() {
		return this.middleName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getSSN() {
		return this.ssn;
	}
	public void setFirstName(String firstName) {
		this.firstName= firstName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public void setLastName (String lastName) {
		this.lastName = lastName;
	}
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}

//The following code creates a checking account and calls the addCheckingAccount(CheckingAccount) method
	public CheckingAccount addCheckingAccount(double openingBalance) {
		this.clientCheckingAccount = new CheckingAccount(openingBalance);
		addCheckingAccount(this.clientCheckingAccount);
		return this.clientCheckingAccount;
	}

//The following method receives a checkingAccount and stores it in an array of CheckingAccount[]
	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
		totalB = totalB + checkingAccount.getBalance();
		if (totalB < 250000) {
			if (counterC == this.amountCheckingAccounts.length) {
				CheckingAccount[] newCheckingAccounts = new CheckingAccount[counterC + 1];
				for (int i = 0; i < counterC; i++) {
					newCheckingAccounts[i] = this.amountCheckingAccounts[i];
				}
				this.amountCheckingAccounts = newCheckingAccounts;

			}
			this.amountCheckingAccounts[counterC] = checkingAccount;
			this.counterC++;
 return null;
		} else
			return null;
	}
	
	public CheckingAccount[] getCheckingAccounts() {
		return this.amountCheckingAccounts;
	}

//The following method returns the total amount of checkingAccounts
	public int getNumberOfCheckingAccounts() {
		return this.amountCheckingAccounts.length;
	}

	// Returns the combined Balance between all checkingAccounts
	public double getCheckingBalance() {
		double checkingBalance = 0;
		for (int i = 0; i < this.amountCheckingAccounts.length; i++) {
			checkingBalance = this.amountCheckingAccounts[i].getBalance() + checkingBalance;
		}
		this.checkingBalance = checkingBalance;
		return this.checkingBalance;
	}

	// Saving Account
	// Creates a SavingsAccount and calls addSavingsAccount(SavingsAccount) method
	public SavingsAccount addSavingsAccount(double openingBalance) {
		this.clientSavingsAccount = new SavingsAccount(openingBalance);
		addSavingsAccount(this.clientSavingsAccount);
		return this.clientSavingsAccount;
	}

	// It receives a SavingAccount and stores it into an array of SavingsAccount[]
	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		totalB = totalB + savingsAccount.getBalance();

		if (totalB < MAX_BALANCE_AMOUNT) {
			if (counterS == this.amountSavingsAccounts.length) {
				SavingsAccount[] newSavingsAccount = new SavingsAccount[counterS + 1];
				for (int i = 0; i < counterS; i++) {
					newSavingsAccount[i] = this.amountSavingsAccounts[i];

				}
				this.amountSavingsAccounts = newSavingsAccount;
			}
			this.amountSavingsAccounts[counterS] = savingsAccount;
			this.counterS++;
			return null;
		} else {
			return null;
		}

	}

	// The following method returns a SavingsAccount[]
	public SavingsAccount[] getSavingsAccounts() {
		return this.amountSavingsAccounts;
	}

	// The following method returns the total amount of savingsAccounts
	public int getNumberOfSavingsAccounts() {
		return this.amountSavingsAccounts.length;
	}

	// It returns the combined Balance between all SavingsAccounts
	// that are stored in a SavingsAccount[]
	public double getSavingsBalance() {
		double savingsBalance = 0;
		for (int i = 0; i < this.amountSavingsAccounts.length; i++) {
			savingsBalance = this.amountSavingsAccounts[i].getBalance() + savingsBalance;

		}
		this.savingsBalance = savingsBalance;
		return this.savingsBalance;
	}
	// The following method creates a CD Account

	public CDAccount addCDAccount(CDOffering offering, double openingBalance) {
		this.cdAccount = new CDAccount(offering, openingBalance);
		addCDAccount(this.cdAccount);
		return this.cdAccount;
	}
	// This method adds cdAccount into the array of CDAccounts[]

	public CDAccount addCDAccount(CDAccount cdAccount) {

		if (counterCD == this.amountCDAccounts.length) {
			CDAccount[] newCDAccount = new CDAccount[counterCD + 1];

			for (int i = 0; i < counterCD; i++) {
				newCDAccount[i] = this.amountCDAccounts[i];
			}
			this.amountCDAccounts = newCDAccount;
			this.amountCDAccounts[counterCD] = cdAccount;
			counterCD++;
		}
		return null;
	}

	// This returns a CDAccouunt[]
	public CDAccount[] getCDAccount() {
		return this.amountCDAccounts;
	}
	// This returns the amount of CDAccounts

	public int getNumberOfCDAccounts() {
		return this.amountCDAccounts.length;

	}
	// This returns a the combined Balance of all CD Accounts

	public double getCDBalance() {
		double cdB = 0;

		for (int i = 0; i < this.amountCDAccounts.length; i++) {
			cdB = this.amountCDAccounts[i].getBalance() + cdB;
		}

		this.cdBalance = cdB;
		return this.cdBalance;
	}
	// This adds Savings Balance, CHecking Balance and CD Balance

	public double getCombinedBalance() {
		this.combinedBalance = getCheckingBalance() + getSavingsBalance() + getCDBalance();
		return combinedBalance;
	}

	public String toString() {

		String client = "Name: " + this.firstName + "" + this.middleName + "" + this.lastName + "" + "SSN: " + this.ssn
				+ "\n" + "Checkings Balance: $" + getCheckingBalance() + "\n" + "Savings Balance: $"
				+ getSavingsBalance() + "\n" + "CD Accounts Balance: $" + getCDBalance() + "\n" + "Total Balance: $ "
				+ getCombinedBalance();
		return client;
	}

	@Override
	public int compareTo(AccountHolder o) {
		double combinedBalance = 0;
		if (combinedBalance > o.getCombinedBalance()) {
			return 1;
		} else {
			return -1;
		}

	}

	public static AccountHolder readFromString(String line) {
		String[] tokens = line.split(",", 4);
		String last = tokens[0];
		String middle = tokens[1];
		String first = tokens[2];
		String number = tokens[3];
		AccountHolder account = new AccountHolder(first, middle, last, number);
		return account;
	}
}