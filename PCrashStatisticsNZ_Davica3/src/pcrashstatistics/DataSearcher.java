package pcrashstatistics;

import java.util.ArrayList;

/**
 * A class to apply a list of search filters to a data set and return results
 * @author Clayton Davidson
 *
 */
public class DataSearcher {

	/**
	 * Uses a list of search filters to refine a data set to specific results
	 * @param crashData Data set to search through
	 * @param filters Search filter strings to be applied
	 * @return ArrayList of type VehicleCrash which meet the search requirements
	 */
	public static ArrayList<VehicleCrash> searchWithFilters(ArrayList<VehicleCrash> crashData, ArrayList<String> filters) {
		
		ArrayList<VehicleCrash> searchResults = new ArrayList<VehicleCrash>();
		
		//Loop through all data
		for (int d = 0; d < crashData.size(); d++) {

			boolean meetsCriteria = true;
			
			//Loop through filters
			for (int f = 0; f < filters.size(); f++) {
				
				//Break down filter into category, compare type, and user argument
				String[] filterValues = filters.get(f).split(",");
				String category = filterValues[0].toUpperCase().replace(" ", "_");
				String compareType = filterValues[1];
				String argument = filterValues[2];
				
				ColumnData dataIndex = ColumnData.valueOf(category);

				//Apply the filter to the data - check it meets requirements
				meetsCriteria = applyFilter(crashData.get(d), dataIndex, compareType, argument);
				if (!meetsCriteria) break; //If does not meet requirements stop checking
			}
			
			//If data meets criteria add to results list
			if (meetsCriteria) {
				
				searchResults.add(crashData.get(d));
			}
		}
		
		return searchResults;
	}
	
	/**
	 * Applies a filter to the data, checking that the data meets the constraints
	 * @param crash Specific object to check meets requirements
	 * @param dataIndex Category of data to check against
	 * @param compareType Comparison type
	 * @param argument User defined search argument to compare to
	 * @return Returns a boolean result to show if the data meets search filters
	 */
	private static boolean applyFilter(VehicleCrash crash, ColumnData dataIndex, String compareType, String argument) {
		
		boolean result = false;
		
		int[] injuries = crash.getInjuries();
		int[] speedLimits = crash.getSpeedLimits();
		int[] crashObjects = crash.getCrashObjectsHit();
		
		//Compare user argument to object data
		try
		{
			switch (dataIndex) {
			case ROW_ID:
				int rowID = crash.getRowID();
				result = compareValues(rowID, compareType, Integer.parseInt(argument));
				break;
			case YEAR:
				int year = crash.getYear();
				result = compareValues(year, compareType, Integer.parseInt(argument));
				break;
			case SEVERITY:
				String severity = crash.getSeverity().toLowerCase();
				result = compareValues(severity, compareType, argument);
				break;
			case FATALITIES:
				result = compareValues(injuries[InjuryType.FATAL.ordinal()], compareType, Integer.parseInt(argument));
				break;
			case SERIOUS_INJURIES:
				result = compareValues(injuries[InjuryType.SERIOUS.ordinal()], compareType, Integer.parseInt(argument));
				break;
			case MINOR_INJURIES:
				result = compareValues(injuries[InjuryType.MINOR.ordinal()], compareType, Integer.parseInt(argument));
				break;
			case VEHICLES_INVOLVED:
				String vehiclesInvolved = crash.getVehiclesInvolved().toLowerCase();
				result = compareValues(vehiclesInvolved, compareType, argument);
				break;
			case LOCATION:
				String location = crash.getLocation().toLowerCase();
				result = compareValues(location, compareType, argument);
				break;
			case AT_INTERSECTION:
				result = (((Boolean)crash.isIntersection()).toString().equals(argument));
				break;
			case JUNCTION_TYPE:
				String junctionType = crash.getJunctionType().toLowerCase();
				result = compareValues(junctionType, compareType, argument);
				break;
			case FROM_SIDE_ROAD:
				result = (((Boolean)crash.isFromSideRoad()).toString().equals(argument));
				break;
			case CRASH_DISTANCE:
				int crashDistance = crash.getCrashDistance();
				result = compareValues(crashDistance, compareType, Integer.parseInt(argument));
				break;
			case ON_STATE_HIGHWAY:
				result = (((Boolean)crash.isOnStateHighway()).toString().equals(argument));
				break;
			case TERRAIN_LEVEL:
				String terrainLevel = crash.getTerrainLevel().toLowerCase();
				result = compareValues(terrainLevel, compareType, argument);
				break;
			case ROAD_CHARACTER:
				String roadCharacter = crash.getRoadCharacter().toLowerCase();
				result = compareValues(roadCharacter, compareType, argument);
				break;
			case ROAD_CURVATURE:
				String roadCurvature = crash.getRoadCurvature().toLowerCase();
				result = compareValues(roadCurvature, compareType, argument);
				break;
			case ROAD_MARKINGS:
				String roadMarking = crash.getRoadMarking().toLowerCase();
				result = compareValues(roadMarking, compareType, argument);
				break;
			case ROAD_SURFACE:
				String roadSurface = crash.getRoadSurface().toLowerCase();
				result = compareValues(roadSurface, compareType, argument);
				break;
			case ROAD_IS_WET:
				result = (((Boolean)crash.isRoadIsWet()).toString().equals(argument));
				break;
			case TRAFFIC_CONTROL:
				String trafficControl = crash.getTrafficControl().toLowerCase();
				result = compareValues(trafficControl, compareType, argument);
				break;
			case SPEED_LIMIT:
				result = compareValues(speedLimits[SpeedLimitType.ENFORCED.ordinal()], compareType, Integer.parseInt(argument));
				break;
			case ADVISED_LIMIT:
				result = compareValues(speedLimits[SpeedLimitType.ADVISED.ordinal()], compareType, Integer.parseInt(argument));
				break;
			case TEMPORARY_LIMIT:
				result = compareValues(speedLimits[SpeedLimitType.TEMPORARY.ordinal()], compareType, Integer.parseInt(argument));
				break;
			case LIGHT:
				String light = crash.getLightConditions().toLowerCase();
				result = compareValues(light, compareType, argument);
				break;
			case WEATHER_A:
				String weatherA = crash.getWeatherA().toLowerCase();
				result = compareValues(weatherA, compareType, argument);
				break;
			case WEATHER_B:
				String weatherB = crash.getWeatherB().toLowerCase();
				result = compareValues(weatherB, compareType, argument);
				break;
			default:
				int compareValue = (Integer)crashObjects[dataIndex.ordinal() - ColumnData.ANIMALS_HIT.ordinal()];
				result = compareValues(compareValue, compareType, Integer.parseInt(argument));
				break;
			}
		}
		catch (NumberFormatException e) {}
		
		return result;
	}
	
	/**
	 * Compares a user defined value to an object value where both are integers
	 * @param crashValue Crash object value
	 * @param comparison Comparison type
	 * @param filterValue User selected value
	 * @return Boolean stating if the object value meets the filter requirement
	 */
	private static boolean compareValues(int crashValue, String comparison, int filterValue) {
		boolean result = false;
		
		//Switch based on comparison type
		switch (comparison) {
		case "==":
			result = (crashValue == filterValue);
			break;
		case ">":
			result = (crashValue > filterValue);
			break;
		case ">=":
			result = (crashValue >= filterValue);
			break;
		case "<":
			result = (crashValue < filterValue);
			break;
		case "<=":
			result = (crashValue <= filterValue);
			break;
		}
		
		return result;
	}
	
	/**
	 * Compares a user defined value to an object value where both are Strings
	 * @param crashValue Crash object value
	 * @param comparison Comparison type
	 * @param filterValue User selected value
	 * @return Boolean stating if the object value meets the filter requirement
	 */
	private static boolean compareValues(String crashValue, String comparison, String filterValue) {
		boolean result = false;
		
		//If comparison is exact match
		if (comparison.equals("==")) {
			
			result = crashValue.equals(filterValue);
		}
		//Comparison is partial match
		else {
			
			result = crashValue.contains(filterValue);
		}
		
		return result;
	}
}
