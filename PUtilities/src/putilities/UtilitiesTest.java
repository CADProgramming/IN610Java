package putilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UtilitiesTest {
	
	int[] numberSet = { 2, 0, 5, 2, 6, 11, 12, -5, 2 };
	ArrayList<Integer> numberSetList;
	Utilities _100PercentCoverageBabyyyyyyyyyyy = new Utilities();
	
	@Test
	void testFindMaxIntArray() {
		assertEquals(12, Utilities.findMax(numberSet));
	}

	@Test
	void testFindMaxArrayListOfInteger() {
		numberSetList = new ArrayList<Integer>();
		numberSetList.add(2);
		numberSetList.add(0);
		numberSetList.add(5);
		numberSetList.add(2);
		numberSetList.add(6);
		numberSetList.add(11);
		numberSetList.add(12);
		numberSetList.add(-5);
		numberSetList.add(2);
		assertEquals(12, Utilities.findMax(numberSetList));
	}

	@Test
	void testFindMinIntArray() {
		assertEquals(-5, Utilities.findMin(numberSet));
	}

	@Test
	void testFindMinArrayListOfInteger() {
		numberSetList = new ArrayList<Integer>();
		numberSetList.add(2);
		numberSetList.add(0);
		numberSetList.add(5);
		numberSetList.add(2);
		numberSetList.add(6);
		numberSetList.add(11);
		numberSetList.add(12);
		numberSetList.add(-5);
		numberSetList.add(2);
		assertEquals(-5, Utilities.findMin(numberSetList));
	}

	@Test
	void testFindItIntArrayInt() {
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		indexes.add(0);
		indexes.add(3);
		indexes.add(8);
		
		assertIterableEquals(indexes, Utilities.findIt(numberSet, 2));
	}

	@Test
	void testFindItArrayListOfIntegerInt() {
		numberSetList = new ArrayList<Integer>();
		numberSetList.add(2);
		numberSetList.add(0);
		numberSetList.add(5);
		numberSetList.add(2);
		numberSetList.add(6);
		numberSetList.add(11);
		numberSetList.add(12);
		numberSetList.add(-5);
		numberSetList.add(2);
		
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		indexes.add(0);
		indexes.add(3);
		indexes.add(8);
		
		assertIterableEquals(indexes, Utilities.findIt(numberSetList, 2));
	}
	
	@Test
	void testNull() {
		assertThrows(NullPointerException.class, 
				()->
				{
					int[] numbers = null;
					Utilities.findMax(numbers);
				});
		assertThrows(NullPointerException.class, 
				()->
				{
					ArrayList<Integer> numbers = null;
					Utilities.findMax(numbers);
				});
		assertThrows(NullPointerException.class, 
				()->
				{
					int[] numbers = null;
					Utilities.findMin(numbers);
				});
		assertThrows(NullPointerException.class, 
				()->
				{
					ArrayList<Integer> numbers = null;
					Utilities.findMin(numbers);
				});
		assertThrows(NullPointerException.class, 
				()->
				{
					int[] numbers = null;
					Utilities.findIt(numbers, 0);
				});
		assertThrows(NullPointerException.class, 
				()->
				{
					ArrayList<Integer> numbers = null;
					Utilities.findIt(numbers, 0);
				});
	}
	
	@Test
	void testBinarySearchInt() {
		int[] numbers = { 3, 65, 1, 2, 25, 11, 13 };
		Utilities.bubbleSort(numbers);
		assertEquals(5, Utilities.binarySearch(numbers, 25));
		assertEquals(2, Utilities.binarySearch(numbers, 3));
		assertEquals(-1, Utilities.binarySearch(numbers, 132));
	}
	
	@Test
	void testBinarySearchString() {
		String[] words = { "dog", "cat", "bird", "pie", "pizza", "corona virus", "help" };
		Utilities.bubbleSort(words);
		assertEquals(0, Utilities.binarySearch(words, "bird"));
		assertEquals(5, Utilities.binarySearch(words, "pie"));
		assertEquals(-1, Utilities.binarySearch(words, "blake"));
	}
}
