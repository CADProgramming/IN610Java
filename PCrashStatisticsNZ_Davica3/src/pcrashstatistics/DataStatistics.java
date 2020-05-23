package pcrashstatistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class DataStatistics {

public static int getMax(ArrayList<VehicleCrash> crashData, String dataName) {
		
		int max = 0;
		
		for (VehicleCrash crash : crashData) {
			
			int crashValue = getValue(crash, dataName);
			if (crashValue > max) {
				max = crashValue;
			}
		}
		
		return max;
	}
	
	public static int getMin(ArrayList<VehicleCrash> crashData, String dataName) {
		
		int min = getValue(crashData.get(0), dataName);
		
		for (VehicleCrash crash : crashData) {
			
			int crashValue = getValue(crash, dataName);
			if (crashValue < min) {
				min = crashValue;
			}
		}
		
		return min;
	}
	
public static ArrayList<VehicleCrash> getTopTen(ArrayList<VehicleCrash> crashData, String dataName) {
		
		ArrayList<VehicleCrash> topTen = new ArrayList<VehicleCrash>();
		ArrayList<VehicleCrash> sortedData = new ArrayList<VehicleCrash>(crashData);

		DataSorter ds = new DataSorter();
		String dataString = dataName.toUpperCase().replace(" ", "_");
		DataSorter.setColumnNumber(ColumnData.valueOf(dataString));
		DataSorter.setIsAscending(false);
		Collections.sort(sortedData, ds);
		
		int itemCount = 10;
		if (sortedData.size() < 10) itemCount = sortedData.size();
		
		for (int i = 0; i < itemCount; i++) {
			topTen.add(sortedData.get(i));
		}
		
		return topTen;
	}
	
	public static ArrayList<VehicleCrash> getBottomTen(ArrayList<VehicleCrash> crashData, String dataName) {
		
		ArrayList<VehicleCrash> bottomTen = new ArrayList<VehicleCrash>();
		ArrayList<VehicleCrash> sortedData = new ArrayList<VehicleCrash>(crashData);

		DataSorter ds = new DataSorter();
		String dataString = dataName.toUpperCase().replace(" ", "_");
		DataSorter.setColumnNumber(ColumnData.valueOf(dataString));
		DataSorter.setIsAscending(true);
		Collections.sort(sortedData, ds);
		
		int itemCount = 10;
		if (sortedData.size() < 10) itemCount = sortedData.size();
		
		for (int i = 0; i < itemCount; i++) {
			bottomTen.add(sortedData.get(i));
		}
		
		return bottomTen;
	}
	
	public static String getTopTenString(ArrayList<VehicleCrash> crashData, String dataName) {
		
		String topTenString = "";
		String[] values = getDataValuesString(crashData, dataName);
		int[] bucket = getBucketString(crashData, dataName);
		
		int itemCount = 10;
		for (int i = 0; i < bucket.length - 1; i++) {
			
			for (int n = 0; n < bucket.length - 1; n++) {
				
				if (bucket[n] < bucket[n + 1]) {
					
					int temp = bucket[n];
					bucket[n] = bucket[n + 1];
					bucket[n + 1] = temp;
					
					String tempString = values[n];
					values[n] = values[n + 1];
					values[n + 1] = tempString;
				}
			}
		}
		
		if (values.length < itemCount) itemCount = values.length;
		
		for (int i = 0; i < itemCount; i++) {
			
			topTenString += "#" + (i + 1) + " - " + values[i] + ": " + bucket[i] + "\n";
		}
		
		return topTenString;
	}
	
	public static String getBottomTenString(ArrayList<VehicleCrash> crashData, String dataName) {
		
		String bottomTenString = "";
		String[] values = getDataValuesString(crashData, dataName);
		int[] bucket = getBucketString(crashData, dataName);
		
		int itemCount = 10;
		for (int i = 0; i < bucket.length - 1; i++) {
			
			for (int n = 0; n < bucket.length - 1; n++) {
				
				if (bucket[n] > bucket[n + 1]) {
					
					int temp = bucket[n];
					bucket[n] = bucket[n + 1];
					bucket[n + 1] = temp;
					
					String tempString = values[n];
					values[n] = values[n + 1];
					values[n + 1] = tempString;
				}
			}
		}
		
		if (values.length < itemCount) itemCount = values.length;
		
		for (int i = 0; i < itemCount; i++) {
			
			bottomTenString += "#" + (i + 1) + " - " + values[i] + ": " + bucket[i] + "\n";
		}
		
		return bottomTenString;
	}
	
	public static long getTotal(ArrayList<VehicleCrash> crashData, String dataName) {
		
		long total = 0;
		
		for (VehicleCrash crash : crashData) {
			
			long crashValue = getValue(crash, dataName);
			total += crashValue;
		}
		
		return total;
	}
	
	public static double getMean(ArrayList<VehicleCrash> crashData, String dataName) {
		
		double total = 0;
		
		for (VehicleCrash crash : crashData) {
			
			int crashValue = getValue(crash, dataName);
			total += crashValue;
		}
		
		double mean = total / (double)crashData.size();
		
		return mean;
	}
	
	public static double getMedian(ArrayList<VehicleCrash> crashData, String dataName) {
		
		double median = 0;
		int index = crashData.size() / 2;
		boolean indexIsWhole = crashData.size() % 2 == 0;
		
		if (indexIsWhole) {
			
			double total = 0;
			total += getValue(crashData.get(index), dataName);
			total += getValue(crashData.get(index - 1), dataName);
			median = total / 2.0;
		}
		else {
			
			median = (double)getValue(crashData.get(index - 1), dataName);
		}
		
		return median;
	}
	
	public static int getMode(ArrayList<VehicleCrash> crashData, String dataName) {
		
		int[] bucket = getBucket(crashData, dataName);
		
		int max = 0;
		int maxIndex = 0;
		
		for (int i = 0; i < bucket.length; i++) {
			
			if (bucket[i] > max) {
				max = bucket[i];
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
	
	public static int getModeString(ArrayList<VehicleCrash> crashData, String dataName) {
		
		int[] bucket = getBucketString(crashData, dataName);
		
		int max = 0;
		int maxIndex = 0;
		
		for (int i = 0; i < bucket.length; i++) {
			
			if (bucket[i] > max) {
				max = bucket[i];
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
	
	public static int[] getBucket(ArrayList<VehicleCrash> crashData, String dataName) {
		
		int bucketSize = getMax(crashData, dataName);
		if (dataName.equals("Crash Distance")) bucketSize /= 1000;
		int[] bucket = new int[bucketSize + 1];
		
		for (VehicleCrash crash : crashData) {
			
			int bucketIndex = 0;
			if (dataName.equals("Crash Distance")) {
				
				bucketIndex = getValue(crash, dataName) / 1000;
			}
			else {
				
				bucketIndex = getValue(crash, dataName);
			}
			bucket[bucketIndex]++;
		}
		
		return bucket;
	}

	public static int[] getBucketString(ArrayList<VehicleCrash> crashData, String dataName) {
		
		String[] valuesArray = getDataValuesString(crashData, dataName);
		int[] bucket = new int[valuesArray.length];
		
		for (VehicleCrash crash : crashData) {
			
			String crashValue = getValueString(crash, dataName);
			int index = -1;
			for (int i = 0; i < valuesArray.length; i++) {
				
				if (dataName.equals("Location")) {
					
					if ((crashValue.split(",")[0]).equals(valuesArray[i])) {
						
						index = i;
						break;
					}
				}
				else {
					
					if (crashValue.equals(valuesArray[i])) {
						
						index = i;
						break;
					}
				}
			}
			
			if (index != -1) {
				bucket[index]++;
			}
		}
		
		return bucket;
	}
	
	public static String[] getDataValuesString(ArrayList<VehicleCrash> crashData, String dataName) {
		
		TreeSet<String> values = new TreeSet<String>();
		
		for (VehicleCrash crash : crashData) {
			
			String value = getValueString(crash, dataName);
			
			if (dataName.equals("Location")) {
				
				values.add(value.split(",")[0]);
			}
			else {
				
				values.add(value);
			}
		}

		String[] valuesArray = new String[values.size()];
		int count = 0;
		
		for (String value : values) {
			
			valuesArray[count] = value;
			count++;
		}
		
		return valuesArray;
	}

	public static int[] getBucketCrashDistance(ArrayList<VehicleCrash> crashData, String dataName) {
		
		int bucketSize = getMax(crashData, dataName);
		int[] bucket = new int[(bucketSize / 1000) + 1];
		
		for (VehicleCrash crash : crashData) {
			
			int bucketIndex = getValue(crash, dataName) / 1000;
			bucket[bucketIndex]++;
		}
		
		return bucket;
	}
	
	public static double getStandardDeviation(ArrayList<VehicleCrash> crashData, String dataName) {
		
		double total = 0;
		
		for (VehicleCrash crash : crashData) {
			
			int crashValue = getValue(crash, dataName);
			total += crashValue;
		}
		
		double mean = total / (double)crashData.size();
		total = 0;
		
		for (VehicleCrash crash : crashData) {
			
			int crashValue = getValue(crash, dataName);
			total += Math.pow(crashValue - mean, 2);
		}
		
		double variance = total / (double)crashData.size();
		double standardDeviation = Math.sqrt(variance);
		
		return standardDeviation;
	}
	
	public static String getStandardDeviationLevel(int level, double standardDeviation, double mean, boolean isRounded) {
		
		double lower = 0;
		double upper = 0;
		
		if (isRounded) {
			
			lower = round(mean - (level * standardDeviation), 2);
			upper = round(mean + (level * standardDeviation), 2);
		}
		else {
			
			lower = mean - (level * standardDeviation);
			upper = mean + (level * standardDeviation);
		}
		
		return ((Double)lower).toString() + " - " + ((Double)upper).toString();
	}
	
	private static int getValue(VehicleCrash crash, String dataName) {
		int[] injuries = crash.getInjuries();
		int[] speedLimits = crash.getSpeedLimits();
		int[] crashObjects = crash.getCrashObjectsHit();
		
		String categoryString = dataName.toUpperCase().replace(" ", "_");
		ColumnData category = ColumnData.valueOf(categoryString);
		int value = 0;
		
		switch (category) {
		case ROW_ID:
			value = crash.getRowID();
			break;
		case YEAR:
			value = crash.getYear();
			break;
		case FATALITIES:
			value = injuries[InjuryType.FATAL.ordinal()];
			break;
		case SERIOUS_INJURIES:
			value = injuries[InjuryType.SERIOUS.ordinal()];
			break;
		case MINOR_INJURIES:
			value = injuries[InjuryType.MINOR.ordinal()];
			break;
		case CRASH_DISTANCE:
			value = crash.getCrashDistance();
			break;
		case SPEED_LIMIT:
			value = speedLimits[SpeedLimitType.ENFORCED.ordinal()];
			break;
		case ADVISED_LIMIT:
			value = speedLimits[SpeedLimitType.ADVISED.ordinal()];
			break;
		case TEMPORARY_LIMIT:
			value = speedLimits[SpeedLimitType.TEMPORARY.ordinal()];
			break;
		default:
			value = (Integer)crashObjects[category.ordinal() - ColumnData.ANIMALS_HIT.ordinal()];
			break;
		}
		
		return value;
	}
	
	private static String getValueString(VehicleCrash crash, String dataName) {
		
		String categoryString = dataName.toUpperCase().replace(" ", "_");
		ColumnData category = ColumnData.valueOf(categoryString);
		String value = "";
		
		switch (category) {
		case SEVERITY:
			value = crash.getSeverity();
			break;
		case VEHICLES_INVOLVED:
			value = crash.getVehiclesInvolved();
			break;
		case LOCATION:
			value = crash.getLocation();
			break;
		case AT_INTERSECTION:
			value = ((Boolean)crash.isIntersection()).toString();
			break;
		case JUNCTION_TYPE:
			value = crash.getJunctionType();
			break;
		case FROM_SIDE_ROAD:
			value = ((Boolean)crash.isFromSideRoad()).toString();
			break;
		case ON_STATE_HIGHWAY:
			value = ((Boolean)crash.isOnStateHighway()).toString();
			break;
		case TERRAIN_LEVEL:
			value = crash.getTerrainLevel();
			break;
		case ROAD_CHARACTER:
			value = crash.getRoadCharacter();
			break;
		case ROAD_CURVATURE:
			value = crash.getRoadCurvature();
			break;
		case ROAD_MARKINGS:
			value = crash.getRoadMarking();
			break;
		case ROAD_SURFACE:
			value = crash.getRoadSurface();
			break;
		case ROAD_IS_WET:
			value = ((Boolean)crash.isRoadIsWet()).toString();
			break;
		case TRAFFIC_CONTROL:
			value = crash.getTrafficControl();
			break;
		case LIGHT:
			value = crash.getLightConditions();
			break;
		case WEATHER_A:
			value = crash.getWeatherA();
			break;
		case WEATHER_B:
			value = crash.getWeatherB();
			break;
		default:
			break;
		}
		
		return value;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
