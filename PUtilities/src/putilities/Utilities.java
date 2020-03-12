package putilities;

import java.util.ArrayList;

public class Utilities {
	
	public static int findMax(int[] numberSet) {
		if (numberSet == null) {
			throw new NullPointerException("Array was null");
		}
		else {
			int highest = numberSet[0];
			
			for (int current : numberSet) {
				if (current > highest) {
					highest = current;
				}
			}
			
			return highest;
		}
	}
	
	public static int findMax(ArrayList<Integer> numberSet) {
		if (numberSet == null) {
			throw new NullPointerException("Array was null");
		}
		else {
			int highest = numberSet.get(0);
			
			for (int current : numberSet) {
				if (current > highest) {
					highest = current;
				}
			}
			
			return highest;
		}
	}
	
	public static int findMin(int[] numberSet) {
		if (numberSet == null) {
			throw new NullPointerException("Array was null");
		}
		else {
			int lowest = numberSet[0];
			
			for (int current : numberSet) {
				if (current < lowest) {
					lowest = current;
				}
			}
			
			return lowest;
		}
	}
	
	public static int findMin(ArrayList<Integer> numberSet) {
		if (numberSet == null) {
			throw new NullPointerException("Array was null");
		}
		else {
			int lowest = numberSet.get(0);
			
			for (int current : numberSet) {
				if (current < lowest) {
					lowest = current;
				}
			}
			
			return lowest;
		}
	}
	
	public static ArrayList<Integer> findIt(int[] numberSet, int value) {
		if (numberSet == null) {
			throw new NullPointerException("Array was null");
		}
		else {
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			
			for (int index = 0; index < numberSet.length; index++) {
				if (numberSet[index] == value) {
					indexes.add(index);
				}
			}
			
			return indexes;
		}
	}
	
	public static ArrayList<Integer> findIt(ArrayList<Integer> numberSet, int value) {
		if (numberSet == null) {
			throw new NullPointerException("Array was null");
		}
		else {
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			
			for (int index = 0; index < numberSet.size(); index++) {
				if (numberSet.get(index) == value) {
					indexes.add(index);
				}
			}
			
			return indexes;
		}
	}
}
