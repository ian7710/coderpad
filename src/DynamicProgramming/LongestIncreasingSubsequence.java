package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    // Function to find the length of the longest increasing subsequence
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // If the array is empty, the LIS length is 0
        }

        int n = nums.length;
        int[] dp = new int[n]; // dp array to store the length of LIS ending at each index
        Arrays.fill(dp, 1); // Initialize all dp values to 1, since the minimum LIS is 1 (each element by itself)

        int maxLength = 1; // Variable to track the maximum LIS found

        // Iterate through the array to fill dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // If nums[i] is greater than nums[j], it can extend the subsequence ending at j
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // Update the maximum length found so far
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength; // Return the maximum LIS length
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        // Find and print the length of the longest increasing subsequence
        System.out.println("The length of the longest increasing subsequence is: " + lengthOfLIS(nums));
    }
}

