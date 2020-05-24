package pcrashstatistics;

import java.util.Comparator;

/**
 * A class to sort data based on set parameters
 * @author Clayton Davidson
 *
 */
public class DataSorter implements Comparator<VehicleCrash> {

	/**
	 * Sort parameters
	 */
	private static boolean isAscending;
	private static ColumnData columnData;
	
	/**
	 * Changes data sort direction (ascending or descending)
	 * @param isAscending Direction value
	 */
	public static void setIsAscending(boolean isAscending) {
		DataSorter.isAscending = isAscending;
	}
	
	/**
	 * Sets the data type to sort by
	 * @param index Column to use for sort
	 */
	public static void setColumnNumber(ColumnData index) {
		DataSorter.columnData = index;
	}
	
	/**
	 * Sort method compares the two objects values and returns the comparison value
	 */
	@Override
	public int compare(VehicleCrash v1, VehicleCrash v2) {
		
		int compareValue = 0;
		int[] injuriesV1 = v1.getInjuries();
		int[] injuriesV2 = v2.getInjuries();
		int[] speedLimitsV1 = v1.getSpeedLimits();
		int[] speedLimitsV2 = v2.getSpeedLimits();
		int[] crashObjectsV1 = v1.getCrashObjectsHit();
		int[] crashObjectsV2 = v2.getCrashObjectsHit();
		
		switch (columnData) {
		case ROW_ID:
			compareValue =  ((Integer)v1.getRowID()).compareTo(v2.getRowID());
			break;
		case YEAR:
			compareValue = ((Integer)v1.getYear()).compareTo(v2.getYear());
			break;
		case SEVERITY:
			compareValue = v1.getSeverity().compareTo(v2.getSeverity());
			break;
		case FATALITIES:
			compareValue = ((Integer)injuriesV1[InjuryType.FATAL.ordinal()]).compareTo(injuriesV2[InjuryType.FATAL.ordinal()]);
			break;
		case SERIOUS_INJURIES:
			compareValue = ((Integer)injuriesV1[InjuryType.SERIOUS.ordinal()]).compareTo(injuriesV2[InjuryType.SERIOUS.ordinal()]);
			break;
		case MINOR_INJURIES:
			compareValue = ((Integer)injuriesV1[InjuryType.MINOR.ordinal()]).compareTo(injuriesV2[InjuryType.MINOR.ordinal()]);
			break;
		case VEHICLES_INVOLVED:
			compareValue = v1.getVehiclesInvolved().compareTo(v2.getVehiclesInvolved());
			break;
		case LOCATION:
			compareValue = v1.getLocation().compareTo(v2.getLocation());
			break;
		case AT_INTERSECTION:
			compareValue = ((Boolean)v1.isIntersection()).compareTo(v2.isIntersection());
			break;
		case JUNCTION_TYPE:
			compareValue = v1.getJunctionType().compareTo(v2.getJunctionType());
			break;
		case FROM_SIDE_ROAD:
			compareValue = ((Boolean)v1.isFromSideRoad()).compareTo(v2.isFromSideRoad());
			break;
		case CRASH_DISTANCE:
			compareValue = ((Integer)v1.getCrashDistance()).compareTo(v2.getCrashDistance());
			break;
		case ON_STATE_HIGHWAY:
			compareValue = ((Boolean)v1.isOnStateHighway()).compareTo(v2.isOnStateHighway());
			break;
		case TERRAIN_LEVEL:
			compareValue = v1.getTerrainLevel().compareTo(v2.getTerrainLevel());
			break;
		case ROAD_CHARACTER:
			compareValue = v1.getRoadCharacter().compareTo(v2.getRoadCharacter());
			break;
		case ROAD_CURVATURE:
			compareValue = v1.getRoadCurvature().compareTo(v2.getRoadCurvature());
			break;
		case ROAD_MARKINGS:
			compareValue = v1.getRoadMarking().compareTo(v2.getRoadMarking());
			break;
		case ROAD_SURFACE:
			compareValue = v1.getRoadSurface().compareTo(v2.getRoadSurface());
			break;
		case ROAD_IS_WET:
			compareValue = ((Boolean)v1.isRoadIsWet()).compareTo(v2.isRoadIsWet());
			break;
		case TRAFFIC_CONTROL:
			compareValue = v1.getTrafficControl().compareTo(v2.getTrafficControl());
			break;
		case SPEED_LIMIT:
			compareValue = ((Integer)speedLimitsV1[SpeedLimitType.ENFORCED.ordinal()]).compareTo(speedLimitsV2[SpeedLimitType.ENFORCED.ordinal()]);
			break;
		case ADVISED_LIMIT:
			compareValue = ((Integer)speedLimitsV1[SpeedLimitType.ADVISED.ordinal()]).compareTo(speedLimitsV2[SpeedLimitType.ADVISED.ordinal()]);
			break;
		case TEMPORARY_LIMIT:
			compareValue = ((Integer)speedLimitsV1[SpeedLimitType.TEMPORARY.ordinal()]).compareTo(speedLimitsV2[SpeedLimitType.TEMPORARY.ordinal()]);
			break;
		case LIGHT:
			compareValue = v1.getLightConditions().compareTo(v2.getLightConditions());
			break;
		case WEATHER_A:
			compareValue = v1.getWeatherA().compareTo(v2.getWeatherA());
			break;
		case WEATHER_B:
			compareValue = v1.getWeatherB().compareTo(v2.getWeatherB());
			break;
		default:
			compareValue = ((Integer)crashObjectsV1[columnData.ordinal() - ColumnData.ANIMALS_HIT.ordinal()]).compareTo(crashObjectsV2[columnData.ordinal() - ColumnData.ANIMALS_HIT.ordinal()]);
			break;
		}
		
		//If descending invert compare value
		if (!isAscending && compareValue != 0) {
			
			compareValue *= -1;
		}
		
		return compareValue;
	}
}
