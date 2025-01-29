package algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * QuickSort with Lumotos partitioning
 */
public class QuickSort {
    static ArrayList<Integer> quick_sort(ArrayList<Integer> arr) {
        helper(arr, 0, arr.size() - 1);
        return arr;
    }

    static void helper(ArrayList<Integer> arr, int startIdx, int endIdx) {
        // Base case: if the subarray has one or no elements, it's sorted
        if (startIdx >= endIdx) {
            return;
        }

        // Select a random pivot and swap it with the start index
        Random random = new Random();
        int randomIdx = random.nextInt(endIdx - startIdx + 1) + startIdx;
        Collections.swap(arr, startIdx, randomIdx);

        // Partitioning using Lomuto's algorithm
        int pivotValue = arr.get(startIdx);
        int smaller = startIdx;

        for (int bigger = startIdx + 1; bigger <= endIdx; bigger++) {
            if (arr.get(bigger) < pivotValue) {
                smaller++;
                Collections.swap(arr, smaller, bigger);
            }
        }

        // Place the pivot in its correct position
        Collections.swap(arr, startIdx, smaller);

        // Recursively sort the subarrays
        helper(arr, startIdx, smaller - 1); // Left subarray
        helper(arr, smaller + 1, endIdx);   // Right subarray
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(3);
        arr.add(8);
        arr.add(4);
        arr.add(2);
        arr.add(7);
        arr.add(1);

        System.out.println("Before sorting: " + arr);
        quick_sort(arr);
        System.out.println("After sorting: " + arr);
    }
}
