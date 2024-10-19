package Design;
/**
 * File: HoareQuickSort.java
 * Class: CSCI 4330
 * Author: Junior Meador
 * Created on: 01/28/2024
 * Last Modified: 02/05/2024
 * Description: Homework Assignment 1
 */

public class HoareQuickSort {
    // Counters for the # of KCs and Swaps
    private static int keyComparisons = 0;
    private static int swaps = 0;

    // Method to perform quicksort using Hoare's partition scheme
    public static void hoareQuickSort(int[] A, int p, int r) {
        if (p < r) {
            // Partition the array and recursively sort the partitions
            int q = hoarePartition(A, p, r);
            hoareQuickSort(A, p, q);
            hoareQuickSort(A, q + 1, r);
        }
    }

    // Hoare partitioning method
    private static int hoarePartition(int[] A, int p, int r) {
        int x = A[p]; // Pivot element, chosen as the first element of the partition
        int i = p - 1; // Left pointer
        int j = r + 1; // Right pointer

        while (true) {
            // Move right pointer left, skipping elements greater than pivot
            do {
                j--;
                keyComparisons++; // Increment comparison count
            } while (A[j] > x);

            // Move left pointer right, skipping elements less than pivot
            do {
                i++;
                keyComparisons++; // Increment comparison count
            } while (A[i] < x);

            // If pointers crossed, partitioning is finished
            if (i < j) {
                swap(A, i, j); // Swap elements at pointers
            } else {
                return j; // Return the new partition point
            }
        }
    }

    // Swaps two elements in the array
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
