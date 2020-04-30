package putilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UtilitiesApp {

	public static void main(String[] args) {
//		int[] myArray;
//		int index;
//		BufferedReader in;
//		myArray = new int[1000];
//		String line;
//		index = 0;
//		try {
//			in = new BufferedReader(new FileReader("rand.txt"));
//			while (((line = in.readLine()) != null) && (index < 1000)) {
//				myArray[index] = Integer.parseInt(line);
//				index++;
//			}
//		}
//		catch (IOException e) {
//			System.out.println("There was a problem with the file");
//			e.printStackTrace();
//		}
//		catch (NumberFormatException ne) {
//			System.out.println("Not a number: the string did not convert to a number");
//			ne.printStackTrace();
//		}
		
		String[] myArray;
		int index;
		BufferedReader in;
		myArray = new String[1000];
		String line;
		index = 0;
		try {
			in = new BufferedReader(new FileReader("threebears.txt"));
			while (((line = in.readLine()) != null) && (index < 1000)) {
				myArray[index] = line;
				index++;
			}
		}
		catch (IOException e) {
			System.out.println("There was a problem with the file");
			e.printStackTrace();
		}
		catch (NumberFormatException ne) {
			System.out.println("Not a number: the string did not convert to a number");
			ne.printStackTrace();
		}
		
		Utilities.bubbleSort(myArray);
		System.out.println(Utilities.binarySearch(myArray, "fastened"));
		for (String word : myArray) {
			System.out.println(word);
		}
		
//		System.out.println(Utilities.findMax(myArray));
//		System.out.println(Utilities.findMin(myArray));
//		ArrayList<Integer> indexes = new ArrayList<Integer>();
//		indexes = Utilities.findIt(myArray, 150);
//		
//		for (int number : indexes) {
//			System.out.println(number);
//		}
	}
}
