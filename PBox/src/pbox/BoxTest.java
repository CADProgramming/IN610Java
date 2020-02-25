package pbox;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoxTest {

	@Test
	void testCalcVolumeN1() {
		Box box = new Box(10, 10, 10);
		assertEquals(1000, box.calcVolume());
	}

	@Test
	void testCalcSurfaceAreaN1() {
		Box box = new Box(10, 10, 10);
		assertEquals(600, box.calcSurfaceArea());
	}

	@Test
	void testCalcVolumeN2() {
		Box box = new Box(8, 5);
		assertEquals(320, box.calcVolume());
	}

	@Test
	void testCalcSurfaceAreaN2() {
		Box box = new Box(8, 5);
		assertEquals(288, box.calcSurfaceArea());
	}

	@Test
	void testCalcVolumeN3() {
		Box box = new Box(12, 7, 9);
		assertEquals(756, box.calcVolume());
	}

	@Test
	void testCalcSurfaceAreaN3() {
		Box box = new Box(12, 7, 9);
		assertEquals(510, box.calcSurfaceArea());
	}
	
	@Test
	void testCalcVolumeU1() {
		Box box = new Box(-12, 5, 17);
		assertEquals(1020, box.calcVolume());
	}

	@Test
	void testCalcSurfaceAreaU1() {
		Box box = new Box(-12, 5, 17);
		assertEquals(698, box.calcSurfaceArea());
	}
	
	@Test
	void testCalcVolumeU2() {
		Box box = new Box(0, 0, 0);
		assertEquals(0, box.calcVolume());
	}

	@Test
	void testCalcSurfaceAreaU2() {
		Box box = new Box(0, 0, 0);
		assertEquals(0, box.calcSurfaceArea());
	}
	
	@Test
	void testCalcVolumeU3() {
		Box box = new Box(0.789, 1.532, 1.351);
		assertEquals(1.633, box.calcVolume());
	}

	@Test
	void testCalcSurfaceAreaU3() {
		Box box = new Box(0.789, 1.532, 1.351);
		assertEquals(8.688, box.calcSurfaceArea());
	}
}
