package pcrashstatistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
		
		int bucketSize = getMax(crashData, dataName);
		int[] bucket = new int[bucketSize + 1];
		
		for (VehicleCrash crash : crashData) {
			
			int bucketIndex = getValue(crash, dataName);
			bucket[bucketIndex]++;
		}
		
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
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
