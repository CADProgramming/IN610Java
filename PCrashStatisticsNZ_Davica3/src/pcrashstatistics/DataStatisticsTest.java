package pcrashstatistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataStatisticsTest {

	ArrayList<VehicleCrash> crashData;
	String dataName;
	
	@BeforeEach
	void setUp() throws Exception {
		
		DataStatistics ds = new DataStatistics();
		crashData = new ArrayList<VehicleCrash>();
		
		int[] injuries = { 1, 3, 5 };
		int[] speedLimits = { 50, 0, 0 };
		int[] crashObjects = new int[37];
		
		for (int i = 0; i < crashObjects.length; i++) {
			
			crashObjects[i] = 0;
		}
		
		VehicleCrash crash = new VehicleCrash(0, 2003, "F", injuries, "SingleVehicle", "Dunedin, lolville", true, "T-Intersection", true, 400, false, "Hill", "Unknown", "Straight", "Single line", "Sealed", false, "Give way sign", speedLimits, "Light", "Fine", "Unknown", crashObjects);
		VehicleCrash crash2 = new VehicleCrash(1, 2015, "M", injuries, "SingleVehicle", "Dunedin, lolville", false, "Unknown", false, 1400, false, "Hill", "Unknown", "Gentle Curve", "No passing lines", "Sealed", false, "Give way sign", speedLimits, "Light", "Fine", "Unknown", crashObjects);
		VehicleCrash crash3 = new VehicleCrash(2, 2001, "S", injuries, "SingleVehicle", "Dunedin, lolville", true, "T-Intersection", true, 0, false, "Flat", "Unknown", "Straight", "No passing lines", "Sealed", false, "Give way sign", speedLimits, "Light", "Fine", "Unknown", crashObjects);
		VehicleCrash crash4 = new VehicleCrash(3, 2003, "N", injuries, "MultiVehicle", "Dunedin, lolville", false, "Unknown", false, 50, false, "Flat", "Unknown", "Straight", "Single line", "Sealed", false, "Give way sign", speedLimits, "Light", "Light Rain", "Strong Wind", crashObjects);

		crashData.add(crash);
		crashData.add(crash2);
		crashData.add(crash3);
		crashData.add(crash4);
		
		dataName = "Year";
	}

	@Test
	void testGetMax() {
		assertEquals(2015, DataStatistics.getMax(crashData, dataName));
	}

	@Test
	void testGetMin() {
		assertEquals(2001, DataStatistics.getMin(crashData, dataName));
	}

	@Test
	void testGetTopTen() {
		assertEquals(" Row ID: 1\n" + 
				" VehicleCrash Year: 2015\n" + 
				" Severity: M\n" + 
				" Injuries: [1, 3, 5]\n" + 
				" Vehicles Involved: SingleVehicle\n" + 
				" Location: Dunedin, lolville\n" + 
				" Is Intersection: false\n" + 
				" Junction Type: Unknown\n" + 
				" Is From Side Road: false\n" + 
				" Crash Distance: 1400\n" + 
				" On State Highway: false\n" + 
				" Terrain Level: Hill\n" + 
				" Road Character: Unknown\n" + 
				" Road Curvature: Gentle Curve\n" + 
				" Road Marking: No passing lines\n" + 
				" Road Surface: Sealed\n" + 
				" Road Is Wet: false\n" + 
				" Traffic Control: Give way sign\n" + 
				" Speed Limits: [50, 0, 0]\n" + 
				" Light Conditions: Light\n" + 
				" Weather A: Fine\n" + 
				" Weather B: Unknown\n" + 
				" Crash Object Struck Count: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]\n", 
				DataStatistics.getTopTen(crashData, dataName).get(0).toString());
	}

	@Test
	void testGetBottomTen() {
		assertEquals(" Row ID: 2\n" + 
				" VehicleCrash Year: 2001\n" + 
				" Severity: S\n" + 
				" Injuries: [1, 3, 5]\n" + 
				" Vehicles Involved: SingleVehicle\n" + 
				" Location: Dunedin, lolville\n" + 
				" Is Intersection: true\n" + 
				" Junction Type: T-Intersection\n" + 
				" Is From Side Road: true\n" + 
				" Crash Distance: 0\n" + 
				" On State Highway: false\n" + 
				" Terrain Level: Flat\n" + 
				" Road Character: Unknown\n" + 
				" Road Curvature: Straight\n" + 
				" Road Marking: No passing lines\n" + 
				" Road Surface: Sealed\n" + 
				" Road Is Wet: false\n" + 
				" Traffic Control: Give way sign\n" + 
				" Speed Limits: [50, 0, 0]\n" + 
				" Light Conditions: Light\n" + 
				" Weather A: Fine\n" + 
				" Weather B: Unknown\n" + 
				" Crash Object Struck Count: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]\n", 
				DataStatistics.getBottomTen(crashData, dataName).get(0).toString());
	}

	@Test
	void testGetTopTenString() {
		dataName = "Weather A";
		assertEquals("#1 - Fine: 3\n" + 
				"#2 - Light Rain: 1\n", 
				DataStatistics.getTopTenString(crashData, dataName));
		crashData.get(0).setWeatherA("Light Rain");
		crashData.get(1).setWeatherA("Light Rain");
		crashData.get(2).setWeatherA("Light Rain");
		crashData.get(3).setWeatherA("Fine");
		assertEquals("#1 - Light Rain: 3\n" + 
				"#2 - Fine: 1\n", 
				DataStatistics.getTopTenString(crashData, dataName));
		
	}

	@Test
	void testGetBottomTenString() {
		dataName = "Weather A";
		assertEquals("#1 - Light Rain: 1\n" + 
				"#2 - Fine: 3\n", 
				DataStatistics.getBottomTenString(crashData, dataName));
	}

	@Test
	void testGetTotal() {
		dataName = "Fatalities";
		assertEquals(4, DataStatistics.getTotal(crashData, dataName));
	}

	@Test
	void testGetMean() {
		dataName = "Row ID";
		assertEquals(1.5, DataStatistics.getMean(crashData, dataName));
	}

	@Test
	void testGetMedian() {
		dataName = "Row ID";
		assertEquals(1.5, DataStatistics.getMedian(crashData, dataName));
		crashData.remove(crashData.size() - 1);
		assertEquals(1, DataStatistics.getMedian(crashData, dataName));
	}

	@Test
	void testGetMode() {
		assertEquals(2003, DataStatistics.getMode(crashData, dataName));
	}

	@Test
	void testGetModeString() {
		dataName = "Vehicles Involved";
		assertEquals(1, DataStatistics.getModeString(crashData, dataName));
	}

	@Test
	void testGetBucket() {
		dataName = "Fatalities";
		assertEquals(4, DataStatistics.getBucket(crashData, dataName)[1]);
		dataName = "Crash Distance";
		assertEquals(1, DataStatistics.getBucket(crashData, dataName)[1]);
	}

	@Test
	void testGetBucketString() {
		assertEquals(3, DataStatistics.getBucketString(crashData, "Vehicles Involved")[1]);
		assertEquals(4, DataStatistics.getBucketString(crashData, "Location")[0]);
	}

	@Test
	void testGetDataValuesString() {
		assertEquals("MultiVehicle", DataStatistics.getDataValuesString(crashData, "Vehicles Involved")[0]);
	}

	@Test
	void testGetBucketCrashDistance() {
		assertEquals(3, DataStatistics.getBucketCrashDistance(crashData, "Crash Distance")[0]);
	}

	@Test
	void testGetStandardDeviation() {
		assertEquals(5.545268253204709, DataStatistics.getStandardDeviation(crashData, dataName));
	}

	@Test
	void testGetStandardDeviationLevel() {
		assertEquals("1999.95 - 2011.05", DataStatistics.getStandardDeviationLevel(1, DataStatistics.getStandardDeviation(crashData, dataName), DataStatistics.getMean(crashData, dataName), true));
		assertEquals("1999.9547317467952 - 2011.0452682532048", DataStatistics.getStandardDeviationLevel(1, DataStatistics.getStandardDeviation(crashData, dataName), DataStatistics.getMean(crashData, dataName), false));
	}

	@Test
	void testRound() {
		assertEquals(10.55, DataStatistics.round(10.5512379, 2));
	}
	
	@Test
	void getValue() {

		DataStatistics.getValue(crashData.get(0), "Serious Injuries");
		DataStatistics.getValue(crashData.get(0), "Minor Injuries");
		DataStatistics.getValue(crashData.get(0), "Speed Limit");
		DataStatistics.getValue(crashData.get(0), "Advised Limit");
		DataStatistics.getValue(crashData.get(0), "Temporary Limit");
		DataStatistics.getValue(crashData.get(0), "Animals Hit");
		
		DataStatistics.getValueString(crashData.get(0), "Severity");
		DataStatistics.getValueString(crashData.get(0), "At Intersection");
		DataStatistics.getValueString(crashData.get(0), "Junction Type");
		DataStatistics.getValueString(crashData.get(0), "From Side Road");
		DataStatistics.getValueString(crashData.get(0), "On State Highway");
		DataStatistics.getValueString(crashData.get(0), "Terrain Level");
		DataStatistics.getValueString(crashData.get(0), "Road Character");
		DataStatistics.getValueString(crashData.get(0), "Road Curvature");
		DataStatistics.getValueString(crashData.get(0), "Road Markings");
		DataStatistics.getValueString(crashData.get(0), "Road Surface");
		DataStatistics.getValueString(crashData.get(0), "Road Is Wet");
		DataStatistics.getValueString(crashData.get(0), "Traffic Control");
		DataStatistics.getValueString(crashData.get(0), "Light");
		DataStatistics.getValueString(crashData.get(0), "Weather B");
	}

}
