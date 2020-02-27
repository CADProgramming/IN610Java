package ptempconv;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TempConvTest2 {

	@Test
	public void testGetCel2() {
		TempConv con = new TempConv(32);
		assertEquals(32, con.getCel(), 0.01);
	}

	@Test
	public void testGetFah2() {
		TempConv con = new TempConv(32);
		assertEquals((32 * 9.0 / 5) + 32, con.getFah(), 0.01);
	}

	@Test
	public void testGetKel2() {
		TempConv con = new TempConv(32);
		assertEquals((32 + 273.15), con.getKel(), 0.01);
	}

	@Test
	public void testSetCel2() {
		TempConv con = new TempConv(32);
		con.setCel(32);
		assertEquals(32, con.getCel(), 0.01);
	}

	@Test
	public void testSetFah2() {
		TempConv con = new TempConv(32);
		con.setFah(32);
		assertEquals(32, con.getFah(), 0.01);
	}

	@Test
	public void testSetKel2() {
		TempConv con = new TempConv(32);
		con.setKel(32);
		assertEquals(32, con.getKel(), 0.01);
	}

	@Test
	public void testToString2() {
		TempConv con = new TempConv(32);
		assertEquals("Celsius: 32.0 | Fahrenheit: 89.6 | Kelvin: 305.15", con.toString());
	}


}
