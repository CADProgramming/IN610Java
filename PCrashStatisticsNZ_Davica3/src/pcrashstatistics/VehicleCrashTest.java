package pcrashstatistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehicleCrashTest {

	VehicleCrash crash;
	VehicleCrash crash2;
	
	@BeforeEach
	void setUp() throws Exception {
		int[] injuries = { 1, 3, 5 };
		int[] speedLimits = { 50, 0, 0 };
		int[] crashObjects = new int[37];
		
		for (int i = 0; i < crashObjects.length; i++) {
			
			crashObjects[i] = 0;
		}
		
		crash = new VehicleCrash(0, 2001, "F", injuries, "SingleVehicle", "Dunedin", true, "T-Intersection", true, 400, false, "Flat", "Unknown", "Straight", "Single line", "Sealed", false, "Give way sign", speedLimits, "Light", "Fine", "Unknown", crashObjects);
		crash2 = new VehicleCrash(1, 2005, "F", injuries, "SingleVehicle", "Dunedin", true, "T-Intersection", true, 400, false, "Flat", "Unknown", "Straight", "Single line", "Sealed", false, "Give way sign", speedLimits, "Light", "Fine", "Unknown", crashObjects);
	}

	@Test
	void testToString() {
		assertEquals(" Row ID: 0\n" + 
				" VehicleCrash Year: 2001\n" + 
				" Severity: F\n" + 
				" Injuries: [1, 3, 5]\n" + 
				" Vehicles Involved: SingleVehicle\n" + 
				" Location: Dunedin\n" + 
				" Is Intersection: true\n" + 
				" Junction Type: T-Intersection\n" + 
				" Is From Side Road: true\n" + 
				" Crash Distance: 400\n" + 
				" On State Highway: false\n" + 
				" Terrain Level: Flat\n" + 
				" Road Character: Unknown\n" + 
				" Road Curvature: Straight\n" + 
				" Road Marking: Single line\n" + 
				" Road Surface: Sealed\n" + 
				" Road Is Wet: false\n" + 
				" Traffic Control: Give way sign\n" + 
				" Speed Limits: [50, 0, 0]\n" + 
				" Light Conditions: Light\n" + 
				" Weather A: Fine\n" + 
				" Weather B: Unknown\n" + 
				" Crash Object Struck Count: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]\n", 
				crash.toString());
	}

	@Test
	void testSetRowID() {
		crash.setRowID(2);
		assertEquals(2, crash.getRowID());
	}

	@Test
	void testSetYear() {
		crash.setYear(2005);
		assertEquals(2005, crash.getYear());
	}

	@Test
	void testSetSeverity() {
		crash.setSeverity("N");
		assertEquals("N", crash.getSeverity());
	}

	@Test
	void testSetInjuries() {
		int[] injuries = { 0, 0, 0 };
		
		crash.setInjuries(injuries);
		assertEquals(0, crash.getInjuries()[0]);
	}

	@Test
	void testSetVehiclesInvolved() {
		crash.setVehiclesInvolved("Multi-Vehicle");
		assertEquals("Multi-Vehicle", crash.getVehiclesInvolved());
	}

	@Test
	void testSetLocation() {
		crash.setLocation("Auckland");
		assertEquals("Auckland", crash.getLocation());
	}

	@Test
	void testSetIntersection() {
		crash.setIntersection(false);
		assertEquals(false, crash.isIntersection());
	}

	@Test
	void testSetJunctionType() {
		crash.setJunctionType("Unknown");
		assertEquals("Unknown", crash.getJunctionType());
	}

	@Test
	void testSetFromSideRoad() {
		crash.setFromSideRoad(false);
		assertEquals(false, crash.isFromSideRoad());
	}

	@Test
	void testSetCrashDistance() {
		crash.setCrashDistance(1000);
		assertEquals(1000, crash.getCrashDistance());
	}

	@Test
	void testSetOnStateHighway() {
		crash.setOnStateHighway(true);
		assertEquals(true, crash.isOnStateHighway());
	}

	@Test
	void testSetTerrainLevel() {
		crash.setTerrainLevel("Hill");
		assertEquals("Hill", crash.getTerrainLevel());
	}

	@Test
	void testSetRoadCharacter() {
		crash.setRoadCharacter("Raised Island");
		assertEquals("Raised Island", crash.getRoadCharacter());
	}

	@Test
	void testSetRoadSurface() {
		crash.setRoadSurface("Unsealed");
		assertEquals("Unsealed", crash.getRoadSurface());
	}

	@Test
	void testSetRoadCurvature() {
		crash.setRoadCurvature("Easy Curve");
		assertEquals("Easy Curve", crash.getRoadCurvature());
	}

	@Test
	void testSetRoadMarking() {
		crash.setRoadMarking("None");
		assertEquals("None", crash.getRoadMarking());
	}

	@Test
	void testSetRoadIsWet() {
		crash.setRoadIsWet(true);
		assertEquals(true, crash.isRoadIsWet());
	}

	@Test
	void testSetTrafficControl() {
		crash.setTrafficControl("None");
		assertEquals("None", crash.getTrafficControl());
	}

	@Test
	void testSetSpeedLimits() {
		int[] speeds = { 100, 0, 0 };
		crash.setSpeedLimits(speeds);
		assertEquals(100, crash.getSpeedLimits()[0]);
	}

	@Test
	void testSetLightConditions() {
		crash.setLightConditions("Dark");
		assertEquals("Dark", crash.getLightConditions());
	}

	@Test
	void testSetWeatherA() {
		crash.setWeatherA("Light Rain");
		assertEquals("Light Rain", crash.getWeatherA());
	}

	@Test
	void testSetWeatherB() {
		crash.setWeatherB("Strong Wind");
		assertEquals("Strong Wind", crash.getWeatherB());
	}

	@Test
	void testSetCrashObjectsHit() {
		int[] crashObjects = new int[37];
		
		for (int i = 0; i < crashObjects.length; i++) {
			
			crashObjects[i] = 1;
		}
		
		crash.setCrashObjectsHit(crashObjects);
		assertEquals(1, crash.getCrashObjectsHit()[0]);
	}

	@Test
	void testCompareTo() {
		assertEquals(-1, crash.compareTo(crash2));
	}

}
