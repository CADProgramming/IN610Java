package pbankaccount;

public class BankAccount {
	
	private final double INTEREST = 0.05;
	private final double TAX = 0.33;
	
	private double balance;
	
	public BankAccount() {
		balance = 0;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double i) {
		balance += i;
	}
	
	public void withdraw(double i) {
		balance -= i;
		
		if (balance < 0) {
			balance -= 5;
		}
	}
	
	public void addInterest() {
		if (balance > 0) {
			double interest = balance * INTEREST;
			interest -= interest * TAX;
			balance += interest;
		}
	}
}