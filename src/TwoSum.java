import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // Method to find the indices of two numbers that add up to the target
    public static int[] findTwoSum(int[] nums, int target) {
        // Create a HashMap to store the value and its corresponding index
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement of the current element
            int complement = target - nums[i];

            // Check if the complement is already in the map
            if (map.containsKey(complement)) {
                // If found, return the indices of the two numbers
                return new int[] { map.get(complement), i };
            }

            // If not found, add the current element and its index to the map
            map.put(nums[i], i);
        }

        // If no solution is found, return an empty array or throw an exception
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        // Example usage:
        int[] nums = {2, 7, 11, 15};  // Array of numbers
        int target = 9;               // Target sum

        // Find indices of the two numbers that add up to the target
        int[] result = findTwoSum(nums, target);

        // Print the result
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
