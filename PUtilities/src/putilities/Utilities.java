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
	
	public static void bubbleSort(int[] myArray) {
        int temp;
        for (int i = 0; i < myArray.length - 1; i++)
        {
            for (int j = 0; j < myArray.length - 1; j++)
            {
                if (myArray[j] > myArray[j + 1])
                {
                    temp = myArray[j + 1];
                    myArray[j + 1] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }

    }
	
	public static void bubbleSort(String[] myArray) {
        String temp;
        for (int i = 0; i < myArray.length - 1; i++)
        {
            for (int j = 0; j < myArray.length - 1; j++)
            {
                if (myArray[j].compareTo(myArray[j + 1]) > 0)
                {
                    temp = myArray[j + 1];
                    myArray[j + 1] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }

    }
	
	public static int binarySearch(int[] numbers, int target) {
		int leftIndex = 0;
		int rightIndex = numbers.length - 1;
		int middleIndex = 0;
		
		while (leftIndex <= rightIndex) {
			middleIndex = (rightIndex + leftIndex) / 2;
			if (numbers[middleIndex] == target) {
				return middleIndex;
			}
			else if (target < numbers[middleIndex]) {
				rightIndex = middleIndex - 1;
			}
			else if (target > numbers[middleIndex]) {
				leftIndex = middleIndex + 1;
			}
			
		}
		
		return -1;
	}
	
	public static int binarySearch(String[] words, String target) {
		int leftIndex = 0;
		int rightIndex = words.length - 1;
		int middleIndex = 0;
		
		while (leftIndex <= rightIndex) {
			middleIndex = (rightIndex + leftIndex) / 2;
			if (words[middleIndex].equals(target)) {
				return middleIndex;
			}
			else if (target.compareTo(words[middleIndex]) < 0) {
				rightIndex = middleIndex - 1;
			}
			else if (target.compareTo(words[middleIndex]) > 0) {
				leftIndex = middleIndex + 1;
			}
			
		}
		
		return -1;
	}
}
