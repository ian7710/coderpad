import java.util.HashMap;

public class PairSum {

    // Function to find a pair of numbers in the array that add up to a given target
    public static int[] findPairWithSum(int[] arr, int target) {
        // Create a HashMap to store the numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Calculate the complement of the current element
            int complement = target - arr[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If found, return the indices of the two numbers
                return new int[]{map.get(complement), i};
            }

            // If not found, store the current number with its index in the map
            map.put(arr[i], i);
        }

        // If no pair is found, return an empty array or handle accordingly
        return new int[]{};
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        // Find the pair that adds up to the target
        int[] result = findPairWithSum(arr, target);

        // Print the result
        if (result.length > 0) {
            System.out.println("Pair found at indices: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No pair found that adds up to the target.");
        }
    }
}
