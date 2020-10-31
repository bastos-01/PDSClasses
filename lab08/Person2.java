package LabEight;

public class Person2 {
	
	private String name;
	private BankAccount bankAccount;
	
	public Person2(String n) {
		name = n;
		bankAccount = new BankAccountImpl("PeDeMeia", 0);
	}
	
	public String getName() {
		return name;
	}
	
	public BankAccount getBankAccount() {
		return new Proxy(bankAccount);
	}

}
