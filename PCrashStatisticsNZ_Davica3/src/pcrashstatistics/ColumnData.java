package pcrashstatistics;

/**
 * An Enumeration to keep track of the different columns of data
 * @author Clayton Davidson
 */
public enum ColumnData {
	/**
	 * The Unique row ID for the vehicle crash object
	 */
	ROW_ID,
	/**
	 * The Year of the crash
	 */
	YEAR,
	/**
	 * The Severity level of the crash (F - Fatal, S - Serious, M - Minor, N - Non-Injury)
	 */
	SEVERITY,
	/**
	 * The amount of fatalities that occurred in the crash
	 */
	FATALITIES,
	/**
	 * The amount of serious injuries that occurred in the crash
	 */
	SERIOUS_INJURIES,
	/**
	 * The amount of minor injuries that occurred in the crash
	 */
	MINOR_INJURIES,
	/**
	 * The type or amount of vehicles involved in the accident
	 */
	VEHICLES_INVOLVED,
	/**
	 * The location of the crash
	 */
	LOCATION,
	/**
	 * If the accident took place at an intersection
	 */
	AT_INTERSECTION,
	/**
	 * The type of junction at the accident if applicable
	 */
	JUNCTION_TYPE,
	/**
	 * If the main car involved in the accident pulled out from a side road
	 */
	FROM_SIDE_ROAD,
	/**
	 * The total distance of the crash
	 */
	CRASH_DISTANCE,
	/**
	 * If the crash took place on a state highway
	 */
	ON_STATE_HIGHWAY,
	/**
	 * The level of the terrain (Flat or Hill)
	 */
	TERRAIN_LEVEL,
	/**
	 * Specifics about the type of landscape objects on the road
	 */
	ROAD_CHARACTER,
	/**
	 * The level of curvature of the accident road
	 */
	ROAD_CURVATURE,
	/**
	 * The line markings on the road
	 */
	ROAD_MARKINGS,
	/**
	 * The surface of the road
	 */
	ROAD_SURFACE,
	/**
	 * If the road is wet
	 */
	ROAD_IS_WET,
	/**
	 * Type of traffic control whether it's lights, signs or not applicable
	 */
	TRAFFIC_CONTROL,
	/**
	 * The legal speed limit of the zone the crash occurred in
	 */
	SPEED_LIMIT,
	/**
	 * The suggested speed limit
	 */
	ADVISED_LIMIT,
	/**
	 * A temporary speed limit in place due to specific conditions
	 */
	TEMPORARY_LIMIT,
	/**
	 * The amount of light to indicate the level of visibility
	 */
	LIGHT,
	/**
	 * The weather of the time of the accident
	 */
	WEATHER_A,
	/**
	 * Extra weather effects at the time of the accident
	 */
	WEATHER_B,
	/**
	 * The number of animals hit
	 */
	ANIMALS_HIT,
	/**
	 * The number of bridges hit
	 */
	BRIDGES_HIT,
	/**
	 * The number of cliffs or banks hit
	 */
	CLIFFS_OR_BANKS_HIT,
	/**
	 * The number of debris hit
	 */
	DEBRIS_HIT,
	/**
	 * The number of ditches hit
	 */
	DITCHES_HIT,
	/**
	 * The number of fences hit
	 */
	FENCES_HIT,
	/**
	 * The number of guard rails hit
	 */
	GUARD_RAILS_HIT,
	/**
	 * The number of houses or buildings hit
	 */
	HOUSES_OR_BUILDINGS_HIT,
	/**
	 * The number of kerbs hit
	 */
	KERBS_HIT,
	/**
	 * The number of thrown or dropped objects hit
	 */
	THROWN_OR_DROPPED_OBJECTS_HIT,
	/**
	 * The number of others hit
	 */
	OTHERS_HIT,
	/**
	 * The number of over banks hit
	 */
	OVERBANKS_HIT,
	/**
	 * The number of parked vehicles hit - unattended
	 */
	PARKED_VEHICLES_HIT,
	/**
	 * The number of phone boxes or other small civil structure objects hit
	 */
	PHONE_BOXES_ETC_HIT,
	/**
	 * The number of posts or poles hit
	 */
	POSTS_OR_POLES_HIT,
	/**
	 * The number of road works hit
	 */
	ROADWORKS_HIT,
	/**
	 * The number of slips or floods hit
	 */
	SLIPS_OR_FLOODS_HIT,
	/**
	 * The number of stray animals hit
	 */
	STRAY_ANIMALS_HIT,
	/**
	 * The number of traffic islands hit
	 */
	TRAFFIC_ISLANDS_HIT,
	/**
	 * The number of traffic signs hit
	 */
	TRAFFIC_SIGNS_HIT,
	/**
	 * The number of trains hit
	 */
	TRAINS_HIT,
	/**
	 * The number of trees hit
	 */
	TREES_HIT,
	/**
	 * The number of vehicles hit - attended by person
	 */
	VEHICLES_HIT,
	/**
	 * The number of water or rivers hit
	 */
	WATER_OR_RIVERS_HIT,
	/**
	 * The number of bicycles involved
	 */
	BICYCLES_INVOLVED,
	/**
	 * The number of buses involved
	 */
	BUSES_INVOLVED,
	/**
	 * The number of cars or station wagons involved
	 */
	CAR_OR_STATION_WAGONS_INVOLVED,
	/**
	 * The number of mopeds involved
	 */
	MOPEDS_INVOLVED,
	/**
	 * The number of motorcycles involved
	 */
	MOTORCYCLES_INVOLVED,
	/**
	 * The number of other vehicles involved
	 */
	OTHER_VEHICLES_INVOLVED,
	/**
	 * The number of school buses involved
	 */
	SCHOOL_BUSES_INVOLVED,
	/**
	 * The number of SUVs involved
	 */
	SUVS_INVOLVED,
	/**
	 * The number of taxis involved
	 */
	TAXIS_INVOLVED,
	/**
	 * The number of trucks involved
	 */
	TRUCKS_INVOLVED,
	/**
	 * The number of unknown vehicles involved
	 */
	UNKNOWN_VEHICLE_INVOLVED,
	/**
	 * The number of vans or utes involved
	 */
	VANS_OR_UTES_INVOLVED,
	/**
	 * The number of pedestrians involved
	 */
	PEDESTRIANS_INVOLVED
}