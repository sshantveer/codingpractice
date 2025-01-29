package problems;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    public static ArrayList<Integer> twoSum(ArrayList<Integer> sortedList, int targetSum) {
        ArrayList<Integer> resultIndices = new ArrayList<>();

        // Handle edge case: null or insufficient elements
        if (sortedList == null || sortedList.size() < 2) {
            resultIndices.add(-1);
            resultIndices.add(-1);
            return resultIndices;
        }

        // Initialize two pointers
        int leftPointer = 0;
        int rightPointer = sortedList.size() - 1;

        // Use the two-pointer approach
        while (leftPointer < rightPointer) {
            int currentSum = sortedList.get(leftPointer) + sortedList.get(rightPointer);

            if (currentSum == targetSum) {
                resultIndices.add(leftPointer);
                resultIndices.add(rightPointer);
                return resultIndices; // Return as soon as we find a pair
            } else if (currentSum > targetSum) {
                rightPointer--; // Move the right pointer left
            } else {
                leftPointer++; // Move the left pointer right
            }
        }

        // No pair found
        resultIndices.add(-1);
        resultIndices.add(-1);
        return resultIndices;
    }

    public static void main(String[] args) {
        ArrayList<Integer> sortedList = new ArrayList<>(List.of(1, 2, 3, 4, 6));
        int targetSum = 6;

        // Test the method
        System.out.println(twoSum(sortedList, targetSum)); // Output: [1, 3]
    }
}
