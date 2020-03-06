package parraypractical;

import java.util.ArrayList;

public class ArrayListApp {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("Blake");
		names.add("Fizzle");
		names.add("Clayto");
		names.add("Dale Wilson");
		
		System.out.println(names);
		
		names.remove(0);
		
		for (String name : names) {
			System.out.println(name);
		}
		
		System.out.println(names.indexOf("Fizzle"));
		System.out.println(names.get(2));
		
		ArrayList<Balloon> balloons = new ArrayList<Balloon>();
		
		for (int b = 0; b < 10; b++) {
			balloons.add(new Balloon());
		}
		
		for (Balloon balloon : balloons) {
			System.out.println(balloon.writeColour());
		}
		
		RandomNumbers set = new RandomNumbers(40);
		set.fillNums();
		System.out.println(set.toString());
	}

}
