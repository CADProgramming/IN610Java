package pcrashstatistics;

import java.util.Arrays;

/**
 * Base class responsible for storing data related to a specific crash in New Zealand
 * @author Clayton Davidson
 *
 */
public class VehicleCrash implements Comparable<VehicleCrash> {
	private int rowID;
	private int year;
	private String severity;
	private int[] injuries;
	private String vehiclesInvolved;
	private String location;
	private boolean isIntersection;
	private String junctionType;
	private boolean isFromSideRoad;
	private int crashDistance;
	private boolean onStateHighway;
	private String terrainLevel;
	private String roadCharacter;
	private String roadCurvature;
	private String roadMarking;
	private String roadSurface;
	private boolean roadIsWet;
	private String trafficControl;
	private int[] speedLimits;
	private String lightConditions;
	private String weatherA;
	private String weatherB;
	private int[] crashObjectsHit;
	
	/**
	 * Creates a new VehicleCrash object
	 * @param rowID Unique ID
	 * @param year Year of crash
	 * @param severity Severity of crash
	 * @param injuries Injuries sustained by people involved
	 * @param vehiclesInvolved Vehicles involved in the crash
	 * @param location Location of the crash
	 * @param isIntersection Crash happened at an intersection
	 * @param junctionType Junction type of intersection
	 * @param isFromSideRoad Main car pulled out from side road
	 * @param crashDistance Total distance of the accident
	 * @param onStateHighway Accident occurred on state highway
	 * @param terrainLevel Terrain level (Flat/Hill)
	 * @param roadCharacter Terrain objects on the road
	 * @param roadCurvature Curvature of the road
	 * @param roadMarking Road lines on the road
	 * @param roadSurface Road surface type
	 * @param roadIsWet Road is wet during accident
	 * @param trafficControl Type of traffic controller at the intersection
	 * @param speedLimits Speed limits of the zone
	 * @param lightConditions Light conditions / visibility at time of crash
	 * @param weatherA Weather at the time of the accident
	 * @param weatherB Secondary weather conditions at the time of the crash
	 * @param crashObjectsHit Crash objects hit during the accident
	 */
	public VehicleCrash(int rowID, int year, String severity, int[] injuries, String vehiclesInvolved, String location, boolean isIntersection, String junctionType, boolean isFromSideRoad, int crashDistance, 
			boolean onStateHighway, String terrainLevel, String roadCharacter, String roadCurvature, String roadMarking, String roadSurface, boolean roadIsWet, String trafficControl, int[] speedLimits, 
			String lightConditions, String weatherA, String weatherB, int[] crashObjectsHit) {
		setRowID(rowID);
		setYear(year);
		setSeverity(severity);
		setInjuries(injuries);
		setVehiclesInvolved(vehiclesInvolved);
		setLocation(location);
		setIntersection(isIntersection);
		setJunctionType(junctionType);
		setFromSideRoad(isFromSideRoad);
		setCrashDistance(crashDistance);
		setOnStateHighway(onStateHighway);
		setTerrainLevel(terrainLevel);
		setRoadCharacter(roadCharacter);
		setRoadCurvature(roadCurvature);
		setRoadMarking(roadMarking);
		setRoadSurface(roadSurface);
		setRoadIsWet(roadIsWet);
		setTrafficControl(trafficControl);
		setSpeedLimits(speedLimits);
		setLightConditions(lightConditions);
		setWeatherA(weatherA);
		setWeatherB(weatherB);
		setCrashObjectsHit(crashObjectsHit);
	}

	/**
	 * Returns a String displaying all of the data relevant to this instance
	 */
	@Override
	public String toString() {
		return " Row ID: " + getRowID() + "\n VehicleCrash Year: " + getYear() + "\n Severity: " + getSeverity() + "\n Injuries: " + Arrays.toString(getInjuries())
				+ "\n Vehicles Involved: " + getVehiclesInvolved() + "\n Location: " + getLocation() + "\n Is Intersection: "
				+ isIntersection() + "\n Junction Type: " + getJunctionType() + "\n Is From Side Road: " + isFromSideRoad()
				+ "\n Crash Distance: " + getCrashDistance() + "\n On State Highway: " + isOnStateHighway() + "\n Terrain Level: "
				+ getTerrainLevel() + "\n Road Character: " + getRoadCharacter() + "\n Road Curvature: " + getRoadCurvature()
				+ "\n Road Marking: " + getRoadMarking() + "\n Road Surface: " + getRoadSurface() + "\n Road Is Wet: " + isRoadIsWet()
				+ "\n Traffic Control: " + getTrafficControl() + "\n Speed Limits: " + Arrays.toString(getSpeedLimits())
				+ "\n Light Conditions: " + getLightConditions() + "\n Weather A: " + getWeatherA() + "\n Weather B: " + getWeatherB()
				+ "\n Crash Object Struck Count: " + Arrays.toString(getCrashObjectsHit()) + "\n";
	}

	/**
	 * @return Returns row id
	 */
	public int getRowID() {
		return rowID;
	}

	/**
	 * @param rowID Sets the row id
	 */
	public void setRowID(int rowID) {
		this.rowID = rowID;
	}
	
	/**
	 * @return Returns year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year Sets the year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return Returns severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * @param severity Sets the severity
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * @return Returns injuries
	 */
	public int[] getInjuries() {
		return injuries;
	}

	/**
	 * @param injuries Sets the injuries
	 */
	public void setInjuries(int[] injuries) {
		this.injuries = injuries;
	}

	/**
	 * @return Returns vehicles involved
	 */
	public String getVehiclesInvolved() {
		return vehiclesInvolved;
	}

	/**
	 * @param vehiclesInvolved Sets the vehicles involved
	 */
	public void setVehiclesInvolved(String vehiclesInvolved) {
		this.vehiclesInvolved = vehiclesInvolved;
	}

	/**
	 * @return Returns location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location Sets the location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return Returns is intersection
	 */
	public boolean isIntersection() {
		return isIntersection;
	}

	/**
	 * @param isIntersection Sets the isIntersecion property
	 */
	public void setIntersection(boolean isIntersection) {
		this.isIntersection = isIntersection;
	}

	/**
	 * @return Returns junction type
	 */
	public String getJunctionType() {
		return junctionType;
	}

	/**
	 * @param junctionType Sets the junction type
	 */
	public void setJunctionType(String junctionType) {
		this.junctionType = junctionType;
	}

	/**
	 * @return Returns is from side road
	 */
	public boolean isFromSideRoad() {
		return isFromSideRoad;
	}

	/**
	 * @param isFromSideRoad Sets the isFromSideRoad property
	 */
	public void setFromSideRoad(boolean isFromSideRoad) {
		this.isFromSideRoad = isFromSideRoad;
	}

	/**
	 * @return Returns crash distance
	 */
	public int getCrashDistance() {
		return crashDistance;
	}

	/**
	 * @param crashDistance Sets the crash distance
	 */
	public void setCrashDistance(int crashDistance) {
		this.crashDistance = crashDistance;
	}

	/**
	 * @return Returns is on state highway
	 */
	public boolean isOnStateHighway() {
		return onStateHighway;
	}

	/**
	 * @param onStateHighway Sets the onStateHighway property
	 */
	public void setOnStateHighway(boolean onStateHighway) {
		this.onStateHighway = onStateHighway;
	}

	/**
	 * @return Returns terrain level
	 */
	public String getTerrainLevel() {
		return terrainLevel;
	}

	/**
	 * @param terrainLevel Sets the terrain level
	 */
	public void setTerrainLevel(String terrainLevel) {
		this.terrainLevel = terrainLevel;
	}

	/**
	 * @return Returns road character
	 */
	public String getRoadCharacter() {
		return roadCharacter;
	}
	
	/**
	 * @param roadCharacter Sets the road character
	 */
	public void setRoadCharacter(String roadCharacter) {
		this.roadCharacter = roadCharacter;
	}

	/**
	 * @return Returns road surface
	 */
	public String getRoadSurface() {
		return roadSurface;
	}
	
	/**
	 * @param roadSurface Sets the road surface
	 */
	public void setRoadSurface(String roadSurface) {
		this.roadSurface = roadSurface;
	}

	/**
	 * @return Returns road curvature
	 */
	public String getRoadCurvature() {
		return roadCurvature;
	}

	/**
	 * @param roadCurvature Sets the road curvature
	 */
	public void setRoadCurvature(String roadCurvature) {
		this.roadCurvature = roadCurvature;
	}

	/**
	 * @return Returns road marking
	 */
	public String getRoadMarking() {
		return roadMarking;
	}

	/**
	 * @param roadMarking Sets the road marking
	 */
	public void setRoadMarking(String roadMarking) {
		this.roadMarking = roadMarking;
	}

	/**
	 * @return Returns is road is wet
	 */
	public boolean isRoadIsWet() {
		return roadIsWet;
	}

	/**
	 * @param roadIsWet Sets the road is wet
	 */
	public void setRoadIsWet(boolean roadIsWet) {
		this.roadIsWet = roadIsWet;
	}

	/**
	 * @return Returns traffic control
	 */
	public String getTrafficControl() {
		return trafficControl;
	}

	/**
	 * @param trafficControl Sets the traffic control
	 */
	public void setTrafficControl(String trafficControl) {
		this.trafficControl = trafficControl;
	}

	/**
	 * @return Returns speed limits
	 */
	public int[] getSpeedLimits() {
		return speedLimits;
	}

	/**
	 * @param speedLimits Sets the speed limits
	 */
	public void setSpeedLimits(int[] speedLimits) {
		this.speedLimits = speedLimits;
	}

	/**
	 * @return Returns light conditions
	 */
	public String getLightConditions() {
		return lightConditions;
	}

	/**
	 * @param lightConditions Sets the light conditions
	 */
	public void setLightConditions(String lightConditions) {
		this.lightConditions = lightConditions;
	}

	/**
	 * @return Returns weather A
	 */
	public String getWeatherA() {
		return weatherA;
	}

	/**
	 * @param weatherA Sets the weather A property
	 */
	public void setWeatherA(String weatherA) {
		this.weatherA = weatherA;
	}

	/**
	 * @return Returns B
	 */
	public String getWeatherB() {
		return weatherB;
	}

	/**
	 * @param weatherB Sets the weather B property
	 */
	public void setWeatherB(String weatherB) {
		this.weatherB = weatherB;
	}

	/**
	 * @return Returns crash objects hit
	 */
	public int[] getCrashObjectsHit() {
		return crashObjectsHit;
	}

	/**
	 * @param crashObjectsHit Sets the crash objects hit during the collision
	 */
	public void setCrashObjectsHit(int[] crashObjectsHit) {
		this.crashObjectsHit = crashObjectsHit;
	}

	/**
	 * Natural sorting order for VehicleCrash
	 * Sorts by Row ID
	 */
	@Override
	public int compareTo(VehicleCrash o) {
		return ((Integer)rowID).compareTo(o.getRowID());
	}

}