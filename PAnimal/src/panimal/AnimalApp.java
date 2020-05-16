package panimal;

import java.util.ArrayList;

public class AnimalApp {

	public static void main(String[] args) {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		
		animals.add(new Dog("Don"));
		animals.add(new SeaLion("Sean"));
		animals.add(new Tarzier("Tammy"));
		animals.add(new Horse("Horatio"));
		
		for (Animal animal : animals) {
			System.out.println("Speak: " + animal.speak());
			if (animal instanceof Domesticated) {
				System.out.println("Work: " + ((Domesticated) animal).work());
				System.out.println("Reward: " + ((Domesticated) animal).reward());
			}
			else
			{
				System.out.println("Does nothing useful - Sad Face :(");
			}
			System.out.println();
		}
	}

}
