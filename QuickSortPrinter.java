package Design;

import java.util.Arrays;
import java.util.Random;

public class QuickSortPrinter {

    // Helper method to print an array
    private static void printArray(int[] array, String message) {
        System.out.println(message + ": " + Arrays.toString(array));
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

    // Main method to execute the sorting and printing for size 100
    public static void main(String[] args) {
        int size = 100; // Size of the array to sort

        // Generate the array in different scenarios
        int[] ascendingArray = generateAscending(size);
        int[] descendingArray = generateDescending(size);
        int[] sameNumberArray = generateSameNumber(size, 50); // Using 50 as an example same number
        int[] randomNumbersArray = generateRandomNumbers(size);

//        // Ascending
//        printArray(ascendingArray, "Before Ascending QuickSort");
//        HoareQuickSort.hoareQuickSort(ascendingArray, 0, ascendingArray.length - 1); // Replace with the sorting method you're using
//        printArray(ascendingArray, "After Ascending QuickSort");
//
//        // Descending
//        printArray(descendingArray, "Before Descending QuickSort");
//        HoareQuickSort.hoareQuickSort(descendingArray, 0, descendingArray.length - 1); // Replace with the sorting method you're using
//        printArray(descendingArray, "After Descending QuickSort");
//
//        // Same Number
//        printArray(sameNumberArray, "Before Same Number QuickSort");
//        HoareQuickSort.hoareQuickSort(sameNumberArray, 0, sameNumberArray.length - 1); // Replace with the sorting method you're using
//        printArray(sameNumberArray, "After Same Number QuickSort");
//
//        // Random Numbers
//        printArray(randomNumbersArray, "Before Random Numbers QuickSort");
//        HoareQuickSort.hoareQuickSort(randomNumbersArray, 0, randomNumbersArray.length - 1); // Replace with the sorting method you're using
//        printArray(randomNumbersArray, "After Random Numbers QuickSort");
//        
//        System.out.println();
//        System.out.println();
        
        // Ascending
        printArray(ascendingArray, "Before Ascending QuickSort");
        LomutoQuickSort.lomutoQuickSort(ascendingArray, 0, ascendingArray.length - 1); // Replace with the sorting method you're using
        printArray(ascendingArray, "After Ascending QuickSort");

        // Descending
        printArray(descendingArray, "Before Descending QuickSort");
        LomutoQuickSort.lomutoQuickSort(descendingArray, 0, descendingArray.length - 1); // Replace with the sorting method you're using
        printArray(descendingArray, "After Descending QuickSort");

        // Same Number
        printArray(sameNumberArray, "Before Same Number QuickSort");
        LomutoQuickSort.lomutoQuickSort(sameNumberArray, 0, sameNumberArray.length - 1); // Replace with the sorting method you're using
        printArray(sameNumberArray, "After Same Number QuickSort");

        // Random Numbers
        printArray(randomNumbersArray, "Before Random Numbers QuickSort");
        LomutoQuickSort.lomutoQuickSort(randomNumbersArray, 0, randomNumbersArray.length - 1); // Replace with the sorting method you're using
        printArray(randomNumbersArray, "After Random Numbers QuickSort");
    }
}
