package pcrashstatistics;

public class VehicleCrash {
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
	private int[] crashObjectStruckCount;
	
	public VehicleCrash(int year, String severity, int[] injuries, String vehiclesInvolved, String location, boolean isIntersection, String junctionType, boolean isFromSideRoad, int crashDistance, 
			boolean onStateHighway, String terrainLevel, String roadCharacter, String roadCurvature, String roadMarking, String roadSurface, boolean roadIsWet, String trafficControl, int[] speedLimits, 
			String lightConditions, String weatherA, String weatherB, int[] crashObjectStruckCount) {
		setYear(year);
		setSeverity(severity);
		setInjuries(injuries);
		setVehiclesInvolved(vehiclesInvolved);
		setLocation(location);
		setIntersection(isIntersection);
		setJunctionType(junctionType);
		setFromSideRoad(isFromSideRoad);
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
		setCrashObjectStruckCount(crashObjectStruckCount);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public int[] getInjuries() {
		return injuries;
	}

	public void setInjuries(int[] injuries) {
		this.injuries = injuries;
	}

	public String getVehiclesInvolved() {
		return vehiclesInvolved;
	}

	public void setVehiclesInvolved(String vehiclesInvolved) {
		this.vehiclesInvolved = vehiclesInvolved;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isIntersection() {
		return isIntersection;
	}

	public void setIntersection(boolean isIntersection) {
		this.isIntersection = isIntersection;
	}

	public String getJunctionType() {
		return junctionType;
	}

	public void setJunctionType(String junctionType) {
		this.junctionType = junctionType;
	}

	public boolean isFromSideRoad() {
		return isFromSideRoad;
	}

	public void setFromSideRoad(boolean isFromSideRoad) {
		this.isFromSideRoad = isFromSideRoad;
	}

	public int getCrashDistance() {
		return crashDistance;
	}

	public void setCrashDistance(int crashDistance) {
		this.crashDistance = crashDistance;
	}

	public boolean isOnStateHighway() {
		return onStateHighway;
	}

	public void setOnStateHighway(boolean onStateHighway) {
		this.onStateHighway = onStateHighway;
	}

	public String getTerrainLevel() {
		return terrainLevel;
	}

	public void setTerrainLevel(String terrainLevel) {
		this.terrainLevel = terrainLevel;
	}

	public String getRoadCharacter() {
		return roadCharacter;
	}
	
	public void setRoadCharacter(String roadCharacter) {
		this.roadCharacter = roadCharacter;
	}

	public String getRoadSurface() {
		return roadSurface;
	}
	
	public void setRoadSurface(String roadSurface) {
		this.roadSurface = roadSurface;
	}

	public String getRoadCurvature() {
		return roadCurvature;
	}

	public void setRoadCurvature(String roadCurvature) {
		this.roadCurvature = roadCurvature;
	}

	public String getRoadMarking() {
		return roadMarking;
	}

	public void setRoadMarking(String roadMarking) {
		this.roadMarking = roadMarking;
	}

	public boolean isRoadIsWet() {
		return roadIsWet;
	}

	public void setRoadIsWet(boolean roadIsWet) {
		this.roadIsWet = roadIsWet;
	}

	public String getTrafficControl() {
		return trafficControl;
	}

	public void setTrafficControl(String trafficControl) {
		this.trafficControl = trafficControl;
	}

	public int[] getSpeedLimits() {
		return speedLimits;
	}

	public void setSpeedLimits(int[] speedLimits) {
		this.speedLimits = speedLimits;
	}

	public String getLightConditions() {
		return lightConditions;
	}

	public void setLightConditions(String lightConditions) {
		this.lightConditions = lightConditions;
	}

	public String getWeatherA() {
		return weatherA;
	}

	public void setWeatherA(String weatherA) {
		this.weatherA = weatherA;
	}

	public String getWeatherB() {
		return weatherB;
	}

	public void setWeatherB(String weatherB) {
		this.weatherB = weatherB;
	}

	public int[] getCrashObjectStruckCount() {
		return crashObjectStruckCount;
	}

	public void setCrashObjectStruckCount(int[] crashObjectStruckCount) {
		this.crashObjectStruckCount = crashObjectStruckCount;
	}

}