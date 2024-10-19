package Design;
/**
 * File: Main.java
 * Class: CSCI 4330
 * Author: Junior Meador
 * Created on: 01/28/2024
 * Last Modified: 02/05/2024
 * Description: Homework Assignment 1
 */

import java.util.Arrays;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		int[] sizes = { 100, 1000, 10_000 };

		// Hoare-Quicksort Analysis
		System.out.println("Hoare-Quicksort Analysis");
		printHorizontalBar();
		for (String scenario : new String[] { "Ascending", "Descending", "Same Number", "Random Numbers" }) {
			for (int size : sizes) {
				processScenario(size, scenario, "Hoare");
				if (size == 10_000) {
					printHorizontalBar();
				}
			}
		}

		// Lomuto-Quicksort Analysis
		System.out.println("\nLomuto-Quicksort Analysis");
		printHorizontalBar();
		for (String scenario : new String[] { "Ascending", "Descending", "Same Number", "Random Numbers" }) {
			for (int size : sizes) {
				processScenario(size, scenario, "Lomuto");
				if (size == 10_000) {
					printHorizontalBar();
				}
			}
		}
	} // End of main method

	// Processes a specific scenario based on array type and sorting algorithm
	private static void processScenario(int size, String scenario, String sortType) {
		int[] array;
		switch (scenario) {
		case "Ascending":
			array = generateAscending(size);
			break;
		case "Descending":
			array = generateDescending(size);
			break;
		case "Same Number":
			int randomNumber = (int)(Math.random() * 1001); // Create a new random number each time
			array = generateSameNumber(size, randomNumber); 
			break;
		case "Random Numbers":
			array = generateRandomNumbers(size);
			break;
		default:
			throw new IllegalArgumentException("Invalid scenario type");
		}
		sortAndDisplayMetrics(array, scenario + " - Size " + String.format("%,d", size), sortType);
	}

	// Generates an ascending ordered array from 1 to 'size' inclusively
	public static int[] generateAscending(int size) {
		return java.util.stream.IntStream.rangeClosed(1, size).toArray(); 
	}

	// Generates a descending ordered array starting from 'size', decrementing by 1, with 'size' number of elements
	public static int[] generateDescending(int size) {
		return java.util.stream.IntStream.iterate(size, i -> i - 1).limit(size).toArray();
	}

	// Generates an array filled with the same number
	public static int[] generateSameNumber(int size, int number) {
		int[] array = new int[size];
		Arrays.fill(array, number);
		return array;
	}

	// Generates an array of random numbers within a specific range
	public static int[] generateRandomNumbers(int size) {
		int[] array = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = 1 + random.nextInt(100_000);
		}
		return array;
	}

	// Helper method to print a horizontal bar for separation 
	private static void printHorizontalBar() {
		System.out.println(
				"----------------------------------------------------------------------------------------------------");
	}

	// Sorts the array with the specified sorting algorithm and displays sorting
	// metrics
	public static void sortAndDisplayMetrics(int[] array, String description, String sortType) {

		long comparisons, swaps;

		if ("Hoare".equals(sortType)) {
			int[] copyForHoare = Arrays.copyOf(array, array.length);
			HoareQuickSort.resetCounters(); // Reset Counters
			HoareQuickSort.hoareQuickSort(copyForHoare, 0, copyForHoare.length - 1);
			comparisons = HoareQuickSort.getKeyComparisons(); // Get # of KCs
			swaps = HoareQuickSort.getSwaps(); // Get # of Swaps
		} else if ("Lomuto".equals(sortType)) {
			int[] copyForLomuto = Arrays.copyOf(array, array.length);
			LomutoQuickSort.resetCounters(); // Reset Counters
			LomutoQuickSort.lomutoQuickSort(copyForLomuto, 0, copyForLomuto.length - 1);
			comparisons = LomutoQuickSort.getKeyComparisons(); // Get # of KCs
			swaps = LomutoQuickSort.getSwaps(); // Get # of Swaps
		} else {
			throw new IllegalArgumentException("Invalid sort type");
		}

		// Format the output with "|" as separators and ensure alignment for easier
		// readability
		System.out.printf("%-30s | %-10s | Comparisons: %-,15d | Swaps: %-,15d%n", description,
				sortType + " Quick Sort", comparisons, swaps);
	
	}
	
}