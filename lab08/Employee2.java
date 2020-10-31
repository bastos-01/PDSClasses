package LabEight;

public class Employee2{
	
	private double salary;
    private Person2 person;
	
    public Employee2(Person2 n, double s) {
        person = n;
        salary = s;
    }
	
	public double getSalary() {
		return salary;
	}
	
	public BankAccount getBankAccount() {
		return person.getBankAccount();
	}
	
}
