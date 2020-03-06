package parraypractical;

import java.util.Random;

public class RandomNumbers {
	private int[] ranNums;
	private Random rand = new Random();
	
	public RandomNumbers(int number) {
		ranNums = new int[number];
	}
	
	public void fillNums() {
		for (int i = 0; i < ranNums.length; i++) {
			ranNums[i] = rand.nextInt(101);
		}
	}
	
	public String toString() {
		String numbers = "";
		
		for (int number : ranNums) {
			numbers += number + "\n";
		}
		
		return numbers;
	}
}
