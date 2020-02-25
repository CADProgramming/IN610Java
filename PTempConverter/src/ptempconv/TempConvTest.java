package ptempconv;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TempConvTest {

	@Test
	void testUpdateTempFromCel() {
		TempConv tempConv = new TempConv(0);
		tempConv.updateTempFromCel(22);
		assertEquals(71.6, tempConv.getFah());
		assertEquals(295.15, tempConv.getKel());
	}

	@Test
	void testUpdateTempFromFah() {
		TempConv tempConv = new TempConv(0);
		tempConv.updateTempFromFah(67);
		assertEquals(19.44, tempConv.getCel());
		assertEquals(292.59, tempConv.getKel());
	}

	@Test
	void testUpdateTempFromKel() {
		TempConv tempConv = new TempConv(0);
		tempConv.updateTempFromKel(290);
		assertEquals(16.85, tempConv.getCel());
		assertEquals(62.33, tempConv.getFah());
	}
	
	@Test
	void testUpdateTempFromCel2() {
		TempConv tempConv = new TempConv(0);
		tempConv.updateTempFromCel(0);
		assertEquals(32.00, tempConv.getFah());
		assertEquals(273.15, tempConv.getKel());
	}

	@Test
	void testUpdateTempFromFah2() {
		TempConv tempConv = new TempConv(0);
		tempConv.updateTempFromFah(0);
		assertEquals(-17.78, tempConv.getCel());
		assertEquals(255.37, tempConv.getKel());
	}

	@Test
	void testUpdateTempFromKel2() {
		TempConv tempConv = new TempConv(0);
		tempConv.updateTempFromKel(0);
		assertEquals(-273.15, tempConv.getCel());
		assertEquals(-459.67, tempConv.getFah());
	}
	
	@Test
	void testToString() {
		TempConv tempConv = new TempConv(0);
		tempConv.updateTempFromFah(67);
		assertEquals("Celcius: 19.44\nFahrenheit: 67.0\nKelvin: 292.59\n", tempConv.toString());
	}

}
