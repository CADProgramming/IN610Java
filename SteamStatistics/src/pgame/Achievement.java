package pgame;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class Achievement {
	
	private String name;
	private String description;
	private double percent;
	private LocalDateTime dateAchieved;
	
	Achievement(String name, String description, double percent, long unixTime) {
		setName(name);
		setDescription(description);
		setPercent(percent);
		setDateAchieved(unixTime);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}
	
	public LocalDateTime getDateAchieved() {
		return dateAchieved;
	}
	
	public void setDateAchieved(long unixTime) {
		dateAchieved = convertToLocalDateTime(unixTime);
	}
	
	private LocalDateTime convertToLocalDateTime(long unixTime) {
		 return LocalDateTime.ofInstant(Instant.ofEpochSecond(unixTime), TimeZone.getDefault().toZoneId());
	}
	
	public String formatValues() {
		return getName() + getDescription() + getPercent() + getDateAchieved();
	}
}
