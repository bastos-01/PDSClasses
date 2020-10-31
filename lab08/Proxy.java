package LabEight;

public class Proxy implements BankAccount{
	
	private BankAccount bankAcc;
	
	public Proxy(BankAccount bankAcc){
        this.bankAcc = bankAcc;
    }

	@Override
	public void deposit(double amount) {
		bankAcc.deposit(amount);	
	}

	@Override
	public boolean withdraw(double amount) {
		if(Company.user == User.OWNER) {
			return bankAcc.withdraw(amount);
		}
		else {
			System.out.println("Operação de withdraw bloqueada");
			return false;
		}
		
	}

	@Override
	public double balance() {
		if((Company.user == User.OWNER)) {
			return bankAcc.balance();
		}
		else {
			System.out.println("Operação de balance bloqueada");
			return Double.NaN;
		}
		
	}

}
