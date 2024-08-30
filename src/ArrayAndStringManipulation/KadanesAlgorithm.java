package ArrayAndStringManipulation;

public class KadanesAlgorithm {

    // Function to find the largest sum contiguous subarray
    public static int findMaxSubarraySum(int[] arr) {
        // Initialize variables to store the maximum sum and the current sum
        int maxSoFar = arr[0];  // This will store the maximum sum found so far
        int maxEndingHere = arr[0];  // This will store the maximum sum ending at the current position

        // Traverse the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Update the maximum sum ending at the current position
            // maxEndingHere is either the current element itself or the current element plus the previous maxEndingHere
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);

            // Update the maximum sum found so far if maxEndingHere is greater
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        // Return the maximum sum found
        return maxSoFar;
    }

    public static void main(String[] args) {
        // Example usage

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // Find and print the largest sum contiguous subarray
        int maxSum = findMaxSubarraySum(arr);
        System.out.println("The largest sum contiguous subarray is: " + maxSum);
    }
}
