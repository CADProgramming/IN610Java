package pcrashstatistics;

import java.util.ArrayList;

public class DataSearcher {

	public static ArrayList<VehicleCrash> searchWithFilters(ArrayList<VehicleCrash> crashData, ArrayList<String> filters) {
		
		ArrayList<VehicleCrash> searchResults = new ArrayList<VehicleCrash>();
		
		for (int d = 0; d < crashData.size(); d++) {

			boolean meetsCriteria = true;
			
			for (int f = 0; f < filters.size(); f++) {
				
				String[] filterValues = filters.get(f).split(",");
				String category = filterValues[0].toUpperCase().replace(" ", "_");
				String compareType = filterValues[1];
				String argument = filterValues[2];
				
				ColumnData dataIndex = ColumnData.valueOf(category);

				meetsCriteria = applyFilter(crashData.get(d), dataIndex, compareType, argument);
				if (!meetsCriteria) break;
			}
			
			if (meetsCriteria) {
				
				searchResults.add(crashData.get(d));
			}
		}
		
		return searchResults;
	}
	
	private static boolean applyFilter(VehicleCrash crash, ColumnData dataIndex, String compareType, String argument) {
		
		boolean result = false;
		
		int[] injuries = crash.getInjuries();
		int[] speedLimits = crash.getSpeedLimits();
		int[] crashObjects = crash.getCrashObjectsHit();
		
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
				String severity = crash.getSeverity();
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
				String vehiclesInvolved = crash.getVehiclesInvolved();
				result = compareValues(vehiclesInvolved, compareType, argument);
				break;
			case LOCATION:
				String location = crash.getLocation();
				result = compareValues(location, compareType, argument);
				break;
			case AT_INTERSECTION:
				result = (((Boolean)crash.isIntersection()).toString().equals(argument));
				break;
			case JUNCTION_TYPE:
				String junctionType = crash.getJunctionType();
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
				String terrainLevel = crash.getTerrainLevel();
				result = compareValues(terrainLevel, compareType, argument);
				break;
			case ROAD_CHARACTER:
				String roadCharacter = crash.getRoadCharacter();
				result = compareValues(roadCharacter, compareType, argument);
				break;
			case ROAD_CURVATURE:
				String roadCurvature = crash.getRoadCurvature();
				result = compareValues(roadCurvature, compareType, argument);
				break;
			case ROAD_MARKINGS:
				String roadMarking = crash.getRoadMarking();
				result = compareValues(roadMarking, compareType, argument);
				break;
			case ROAD_SURFACE:
				String roadSurface = crash.getRoadSurface();
				result = compareValues(roadSurface, compareType, argument);
				break;
			case ROAD_IS_WET:
				result = (((Boolean)crash.isRoadIsWet()).toString().equals(argument));
				break;
			case TRAFFIC_CONTROL:
				String trafficControl = crash.getTrafficControl();
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
				String light = crash.getLightConditions();
				result = compareValues(light, compareType, argument);
				break;
			case WEATHER_A:
				String weatherA = crash.getWeatherA();
				result = compareValues(weatherA, compareType, argument);
				break;
			case WEATHER_B:
				String weatherB = crash.getWeatherB();
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
	
	private static boolean compareValues(int crashValue, String comparison, int filterValue) {
		boolean result = false;
		
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
	
	private static boolean compareValues(String crashValue, String comparison, String filterValue) {
		boolean result = false;
		
		if (comparison.equals("==")) {
			
			result = crashValue.equals(filterValue);
		}
		else {
			
			result = crashValue.contains(filterValue);
		}
		
		return result;
	}
}
