package pfacebook;

import java.time.LocalDate;
import java.time.Period;

public class Friend {
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private Gender gender;
	private String homeTown;
	private String email;
	private Relationship relationshipStatus;
	private LocalDate dateEntered;
	
	Friend(String firstName, String lastName) {
		this.dateEntered = LocalDate.now();
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	Friend(String firstName, String lastName, int year, int month, int day) {
		this(firstName, lastName);
		setBirthDate(LocalDate.of(year, month, day));
	}
	
	Friend(String firstName, String lastName, int year, int month, int day,
			Gender gender, String homeTown, String email, Relationship relationshipStatus) {
		this(firstName, lastName, year, month, day);
		setGender(gender);
		setHomeTown(homeTown);
		setEmail(email);
		setRelationshipStatus(relationshipStatus);
	}

	public boolean isValidName() {
		boolean isValid = false;
		
		if (firstName.length() > 2 && lastName.length() > 2) {
			isValid = true;
		}
		
		return isValid;
	}
	
	public int calcAge() {
		if (birthDate != null) {
			Period age = Period.between(birthDate, LocalDate.now());
			return age.getYears();
		}
		else {
			return -1;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder returnString = new StringBuilder("");
		
		if (firstName != null) returnString.append("First Name: " + getFirstName() + "\n");
		if (lastName != null) returnString.append("Last Name: " + getLastName() + "\n");
		if (birthDate != null) returnString.append("Birth Date: " + getBirthDate().toString() + "\n");
		if (gender != null) returnString.append("Gender: " + getGender() + "\n");
		if (homeTown != null) returnString.append("Home Town: " + getHomeTown() + "\n");
		if (email != null) returnString.append("Email: " + getEmail() + "\n");
		if (relationshipStatus != null) returnString.append("Relationship Status: " + getRelationshipStatus() + "\n");
			
		return returnString.toString();
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getHomeTown() {
		return homeTown;
	}
	
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Relationship getRelationshipStatus() {
		return relationshipStatus;
	}
	
	public void setRelationshipStatus(Relationship relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}
	
	public LocalDate getDateEntered() {
		return dateEntered;
	}
}
