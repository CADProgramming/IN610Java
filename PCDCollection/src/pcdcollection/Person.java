package pcdcollection;

import java.util.Comparator;

public class Person implements Comparable<Person>{
   
	private String firstName; 
	private String lastName;
	private String room;
	private String title;
	private String phone;


	public Person(String lastName, String firstName, String room, String title, String phone) {
		
		this.lastName = lastName;
		this.firstName = firstName;
		this.room = room;
		this.title = title;
        this.phone = phone;
	}
	
	public void setFirstName(String firstName){ this.firstName= firstName;}
	public void setLastName(String lastName){ this.lastName= lastName;}
	public void setroom(String room) {this.room = room;}
	public void settitle(String title) {this.title = title;}
	public void setPhone(String phone){ this.phone = phone;}
	
	public String getFirstName(){ return firstName;}
	public String getLastName(){ return lastName;}
	public String getRoom() {return room;}
	public String gettitle() {return title;}
	public String getPhone(){ return phone;}
        
    public String toString(){
        return firstName +" "+ lastName +" "+ phone +" "+ room;
    }

	@Override
	public int compareTo(Person o) {
		if (lastName.compareTo(o.getLastName()) == 0) {
			return firstName.compareTo(o.getFirstName());
		}
		else {
			return lastName.compareTo(o.getLastName());
		}
	}
}

