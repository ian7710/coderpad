public class MaxSubArraySum {

    // method to find the maximum sum of a contiguous subarray using Kadane's algorithm
    public static int maxSubArray(int nums[]) {
        /* initialize maxSoFar to the first element of the array.
        This will store the maximum sum found so far.
         */
        int maxSoFar = nums[0];

        /* Initialize maxEndingHere to the first element. This will store the maximum sum of the
        * subarray ending at the current position */
        int maxEndingHere = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            /* Update maxEndingHere to be the maximum of the current element alone or
            * the current element added to maxEndingHere */
            // This step decides whether to start the subarray at the current element or to continue the existng subarray
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);

            // Update maxSoFar to be the maximum value between maxSoFar and maxEndingHere.
            // This ensures maxSoFar always holds the maximum sum found so far.
            maxSoFar = Math.max(maxSoFar, maxEndingHere);

        }

        // Return the maximum sum found, which is stored in maxSoFar.
        return maxSoFar;
    }

    public static void main(String[] args) {
        // Test array with both  negative and positive numbers
        int[] nums = {-2, 1, -3,  4, -1, 2, 1, -5, 4};

        // Print the result of the maxSubArray function applied to the test array
        System.out.println(maxSubArray(nums));


    }
}
