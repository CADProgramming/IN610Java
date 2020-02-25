package psalary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SalaryTest {

	@Test
	void testSetGetGross() {
		Salary slry = new Salary(10000);
		assertEquals(10000, slry.getGross());
	}
	
	@Test
	void getTaxHigh() {
		Salary slry = new Salary(78000);
		assertEquals(16660, slry.getTax());
	}
	
	@Test
	void getTaxMid() {
		Salary slry = new Salary(34000);
		assertEquals(4970, slry.getTax());
	}
	
	@Test
	void getTaxSmall() {
		Salary slry = new Salary(8000);
		assertEquals(840, slry.getTax());
	}
	
	@Test
	void testGetTaxZero() {
		Salary slry = new Salary(0);
		assertEquals(0, slry.getTax());
	}
	
	@Test
	void testGetTaxNegative() {
		Salary slry = new Salary(-8000);
		assertEquals(0, slry.getTax());
	}
	
	@Test
	void testGetNet() {
		Salary slry = new Salary(53000);
		assertEquals(44080, slry.getNet());
	}
	
	@Test
    public void dalesTestSuiteForTax()
    {
	//the instructor's test suite for tax
	Salary money = new Salary(120000.50);
	assertEquals(30520.17, money.getTax(),0.01);
	money.setGross(52112);
	assertEquals(8653.6, money.getTax(),0.01);
	money.setGross(44567);
	assertEquals(6819.23, money.getTax(),0.01);
	money.setGross(7623);
	assertEquals(800.42, money.getTax(),0.01);
	//a couple more tests
	//these would normally be in separate methods
	//test the net
	assertEquals(6822.59, money.getNet(),0.01);
	//test a negative
	money.setGross(-50);
	assertEquals(0, money.getTax(),0.01);
    }
}
