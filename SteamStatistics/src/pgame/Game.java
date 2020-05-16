package pgame;

import java.util.ArrayList;

public class Game implements Comparable<Game> {
	
	private Long id;
	private String name;
	private String description;
	private String img;
	private String cost;
	private boolean isFree;
	private int requiredAge;
	private Long playerBase;
	private Long totalPlayTime;
	private ArrayList<Achievement> playerAchievements;
	
	public Game(Long id, String name, Long totalPlayTime){
		setId(id);
		setName(name);
		setTotalPlayTime(totalPlayTime);
		
		playerAchievements = new ArrayList<Achievement>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public boolean getIsFree() {
		return isFree;
	}

	public void setIsFree(boolean isFree) {
		this.isFree = isFree;
	}

	public int getRequiredAge() {
		return requiredAge;
	}

	public void setRequiredAge(int requiredAge) {
		this.requiredAge = requiredAge;
	}

	public Long getPlayerBase() {
		return playerBase;
	}

	public void setPlayerBase(Long playerBase) {
		this.playerBase = playerBase;
	}

	public Long getTotalPlayTime() {
		return totalPlayTime;
	}

	public void setTotalPlayTime(Long totalPlayTime) {
		this.totalPlayTime = totalPlayTime;
	}

	public ArrayList<Achievement> getPlayerAchievements() {
		return playerAchievements;
	}

	public void setPlayerAchievements(ArrayList<Achievement> playerAchievements) {
		this.playerAchievements = playerAchievements;
	}
	
	@Override
	public String toString() {
		return 
				"App ID: " + getId() + 
				"\nName: " + getName() + 
				"\nDescription: " + getDescription() + 
				"\nImage URL: " + getImg() + 
				"\nCost: " + getCost() + 
				"\nIs Free Game: " + getIsFree() + 
				"\nAge Restriction: " + getRequiredAge() + 
				"\nCurrent Player Count: " + getPlayerBase() +
				"\nTotal Play Time: " + getTotalPlayTime();
	}

	@Override
	public int compareTo(Game gameToCompare) {
		return name.compareTo(gameToCompare.getName());
	}
}
