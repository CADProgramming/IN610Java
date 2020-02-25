package pbankaccount;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankAccountTest {

	@Test
	void testGetBalance() {
		BankAccount acc = new BankAccount();
		assertEquals(0.00, acc.getBalance(), 0);
	}

	@Test
	void testDeposit() {
		BankAccount acc = new BankAccount();
		acc.deposit(50.00);
		assertEquals(50.00, acc.getBalance(), 0);
	}

	@Test
	void testWithdraw() {
		BankAccount acc = new BankAccount();
		acc.deposit(100.00);
		acc.withdraw(50.00);
		assertEquals(50.00, acc.getBalance(), 0);
	}
	
	@Test
	void testWithdrawWithPenalty() {
		BankAccount acc = new BankAccount();
		acc.deposit(100.00);
		acc.withdraw(150.00);
		assertEquals(-55.00, acc.getBalance(), 0);
	}
	
	@Test
	void testAddInterest() {
		BankAccount acc = new BankAccount();
		acc.deposit(1000);
		acc.addInterest();
		assertEquals(1033.50, acc.getBalance(), 0);
	}
}
