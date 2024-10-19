package Design;
/**
 * File: LomutoQuickSort.java
 * Class: CSCI 4330
 * Author: Junior Meador
 * Created on: 01/28/2024
 * Last Modified: 02/05/2024
 * Description: Homework Assignment 1
 */

public class LomutoQuickSort {
	// Counters for the # of KCs and Swaps
	private static int keyComparisons = 0;
	private static int swaps = 0;

	// Method to perform quicksort using Lomuto's partition scheme
	public static void lomutoQuickSort(int[] A, int p, int r) {
		if (p < r) {
			// Partition the array and recursively sort the partitions
			int q = lomutoPartition(A, p, r);
			lomutoQuickSort(A, p, q - 1);
			lomutoQuickSort(A, q + 1, r);
		}
	}

	// Partitions the array using Lomuto's algorithm
	private static int lomutoPartition(int[] A, int p, int r) {
		int x = A[r]; // Pivot element
		int i = p - 1; // Index of the smaller element

		for (int j = p; j <= r - 1; j++) {
			keyComparisons++; // Increment comparison count
			if (A[j] <= x) { // If current element is less than or equal to pivot
				i++; // Move the boundary of smaller elements
				swap(A, i, j); // Swap elements
			}
		}

		swap(A, i + 1, r); // Swap pivot to its correct position
		return i + 1; // Return the partitioning index
	}

	// Swaps two elements in an array
	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
		swaps++; // Increment swap count
	}

	 // Resets the counters for KCs and Swaps
	public static void resetCounters() {
		keyComparisons = 0;
		swaps = 0;
	}

	// Returns the total # of KCs
	public static int getKeyComparisons() {
		return keyComparisons;
	}

	// Returns the total # of Swaps
	public static int getSwaps() {
		return swaps;
	}
}
