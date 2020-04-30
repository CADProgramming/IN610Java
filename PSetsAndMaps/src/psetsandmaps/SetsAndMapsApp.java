package psetsandmaps;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class SetsAndMapsApp {

	public static void main(String[] args) {
		ArrayList<String> myCollection = new ArrayList<String>();

		myCollection.add("i");
		myCollection.add("came");
		myCollection.add("i");
		myCollection.add("saw");
		myCollection.add("i");
		myCollection.add("conquered");
		
		HashSet<String> myHashSet = new HashSet<String>(); //You can also pass through here
		myHashSet.addAll(myCollection);
		
		System.out.println(myHashSet);
		
		LinkedHashSet<String> myHashSet2 = new LinkedHashSet<String>(myCollection);
		System.out.println(myHashSet2);
		
		TreeSet<String> myTreeSet = new TreeSet<String>(myCollection);
		System.out.println(myTreeSet);
		
		ArrayList<String> myCollection2 = new ArrayList<String>();

		myCollection2.add("i");
		myCollection2.add("came");
		myCollection2.add("i");
		myCollection2.add("saw");
		myCollection2.add("i");
		myCollection2.add("ran");
		myCollection2.add("away");
		
		TreeSet<String> myTreeSet2 = new TreeSet<String>(myCollection2);
		System.out.println(myTreeSet2);
		
		System.out.println(myCollection.containsAll(myCollection2));
		Set<String> intersection = new TreeSet<String>(myCollection);
		intersection.retainAll(myCollection2);
		System.out.println(intersection);
		
		Set<String> union = new TreeSet<String>(myCollection);
		union.addAll(myCollection2);
		System.out.println(union);
		
		Set<String> difference = new TreeSet<String>(myCollection);
		difference.removeAll(myCollection2);
		System.out.println(difference);
		
		Map<String, Integer> vehicles = new TreeMap<String, Integer>();
		vehicles.put("Datsun", 2);
		vehicles.put("Holden", 3);
		vehicles.put("Toyota", 4);
		vehicles.put("Suzuki", 1);
		
		System.out.println(vehicles);
		System.out.println("List of all vehicle types");
		
		for (String key : vehicles.keySet()) {
			System.out.println(key);
		}
		
		int count = 0;
		
		for (int value : vehicles.values()) {
			count += value;
		}
		
		System.out.println("There are " + count + " vehicles");
		
		String carName = JOptionPane.showInputDialog("Info for vehicle type: ");
		
		if (vehicles.containsKey(carName)) {
			System.out.println("Info for car type " + carName + ": " + vehicles.get(carName));
		}
		else {
			System.out.println(carName + " does not exist");
		}
		
		//Bonus Task
		Map<String, Integer> wordFreq = new TreeMap<String, Integer>();
		String word = "";
		
		try {
			Scanner scannerReader = new Scanner(new File("threebears.txt"));
			
			while (scannerReader.hasNextLine()) {
				
				word = scannerReader.nextLine();
				
				if (wordFreq.containsKey(word)) {
					int currentCount = wordFreq.get(word);
					wordFreq.put(word, currentCount + 1);
				}
				else {
					wordFreq.put(word, 1);
				}
				
			}
		} catch(IOException e) {
			System.out.println("IO Exception has occured");
		}
		
		for (String key : wordFreq.keySet()) {
			System.out.println(key + ": " + wordFreq.get(key));
		}
	}

}
