package pphonebook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PhoneBookApp {

	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<Person>();
		String firstName;
		String lastName;
		String room;
		String title;
		String phone;
		String line;
		
		try {
			Scanner scannerReader = new Scanner(new File("Phone.csv"));
			while (scannerReader.hasNextLine()) {
				line = scannerReader.nextLine();
				String[] fields = line.split(",");
				lastName = fields[0];
				firstName = fields[1];
				room = fields[2];
				title = fields[3];
				phone = fields[4];
				people.add(new Person(lastName, firstName, room, title, phone));
			}
		} catch(IOException e) {
			System.out.println("IO Exception has occured");
		}
		
		Collections.sort(people);
		
		for (Person person : people) {
			System.out.println(person.toString());
		}
	}

}
