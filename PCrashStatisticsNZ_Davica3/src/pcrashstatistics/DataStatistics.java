package pcrashstatistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * A class that calculates statistical values about the data set provided
 * @author Clayton Davidson
 *
 */
public class DataStatistics {

/**
 * Gets the maximum value of the specified data category
 * @param crashData Data set to examine
 * @param dataName Category to calculate for
 * @return Returns an integer representing the max value
 */
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
	
	/**
	 * Gets the minimum value of the specified data category
	 * @param crashData Data set to examine
	 * @param dataName Category to calculate for
	 * @return Returns an integer representing the min value
	 */
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
	
/**
 * Gets the top ten objects of a category
 * @param crashData Data set to use
 * @param dataName Category to get values from
 * @return Returns an ArrayList of object VehicleCrash
 */
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
	
	/**
	 * Gets the bottom ten objects of a category
	 * @param crashData Data set to use
	 * @param dataName Category to get values from
	 * @return Returns an ArrayList of object VehicleCrash
	 */
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
	
	/**
	 * Gets the top ten objects of a category where the category is a String
	 * @param crashData Data set to use
	 * @param dataName Category to get values from
	 * @return Returns an ArrayList of object VehicleCrash
	 */
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
	
	/**
	 * Gets the bottom ten objects of a category where the category is a String
	 * @param crashData Data set to use
	 * @param dataName Category to get values from
	 * @return Returns an ArrayList of object VehicleCrash
	 */
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
	
	/**
	 * Calculates a total of the specified category
	 * @param crashData Data set to use
	 * @param dataName Category to calculate the total for
	 * @return Returns a long representing the total value
	 */
	public static long getTotal(ArrayList<VehicleCrash> crashData, String dataName) {
		
		long total = 0;
		
		for (VehicleCrash crash : crashData) {
			
			long crashValue = getValue(crash, dataName);
			total += crashValue;
		}
		
		return total;
	}
	
	/**
	 * Calculates the mean of the data
	 * @param crashData Data set to use
	 * @param dataName Category to calculate the mean for
	 * @return Returns a integer representing the mean value
	 */
	public static double getMean(ArrayList<VehicleCrash> crashData, String dataName) {
		
		double total = 0;
		
		for (VehicleCrash crash : crashData) {
			
			int crashValue = getValue(crash, dataName);
			total += crashValue;
		}
		
		double mean = total / (double)crashData.size();
		
		return mean;
	}
	
	/**
	 * Calculates the median of the data
 	 * @param crashData Data set to use
	 * @param dataName Category to calculate the median for
	 * @return Returns a double representing the median value
	 */
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
			
			median = (double)getValue(crashData.get(index), dataName);
		}
		
		return median;
	}
	
	/**
	 * Calculates the mode of the data
	 * @param crashData Data set to use
	 * @param dataName Category to calculate the mode for
	 * @return Returns a integer representing the mode value
	 */
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
	
	/**
	 * Calculates the mode of the data where the category data type is String
	 * @param crashData Data set to use
	 * @param dataName Category to calculate the mode for
	 * @return Returns a integer representing the mode value
	 */
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
	
	/**
	 * Gets a frequency bucket for the specified category
	 * @param crashData Data set to use
	 * @param dataName Category to get frequency bucket for
	 * @return Returns an array of integers representing the frequency of the values
	 */
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

	/**
	 * Gets a frequency bucket for the specified category where the category is of type String
	 * @param crashData Data set to use
	 * @param dataName Category to get frequency bucket for
	 * @return Returns an array of integers representing the frequency of the values
	 */
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
	
	/**
	 * Gets the different possible String values for the specified category
	 * @param crashData Data set to use
	 * @param dataName Category to get String values for
	 * @return Returns an array of Strings that are the possible values for the category
	 */
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

	/**
	 * Gets the frequency bucket for the crash distance category
	 * @param crashData Data set to calculate with
	 * @param dataName "Crash Data"
	 * @return Returns an array of integers representing the frequency bucket
	 */
	public static int[] getBucketCrashDistance(ArrayList<VehicleCrash> crashData, String dataName) {
		
		int bucketSize = getMax(crashData, dataName);
		int[] bucket = new int[(bucketSize / 1000) + 1];
		
		for (VehicleCrash crash : crashData) {
			
			int bucketIndex = getValue(crash, dataName) / 1000;
			bucket[bucketIndex]++;
		}
		
		return bucket;
	}
	
	/**
	 * Calculates the standard deviation of a specific data category
	 * @param crashData Data to use for the calculation
	 * @param dataName Category to find standard deviation for
	 * @return Returns a double representing the standard deviation
	 */
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
	
	/**
	 * Gets a level of standard deviation from the mean
	 * @param level Level number
	 * @param standardDeviation Standard deviation
	 * @param mean Mean
	 * @param isRounded Value returned should be rounded
	 * @return Returns a rounded or not rounded string range of that level's standard deviation
	 */
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
	
	/**
	 * Gets a specific category value where the data type is integer
	 * @param crash Data object to get value from
	 * @param dataName Category to get the value of
	 * @return Returns the category data value as an integer
	 */
	public static int getValue(VehicleCrash crash, String dataName) {
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
	
	/**
	 * Gets a specific category value where the data type is String
	 * @param crash Data object to get value from
	 * @param dataName Category to get the value of
	 * @return Returns the category data value as an String
	 */
	public static String getValueString(VehicleCrash crash, String dataName) {
		
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
	
	/**
	 * Rounds the input value to specified decimal places
	 * @param value Value to round
	 * @param places Decimal places to round to 
	 * @return Return rounded double value
	 */
	public static double round(double value, int places) {
	   
	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
