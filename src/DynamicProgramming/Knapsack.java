package DynamicProgramming;

public class Knapsack {

    // Function to solve the Knapsack problem using dynamic programming
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length; // Number of items

        // Create a 2D DP array where dp[i][w] represents the maximum value that can be obtained
        // using the first i items and a knapsack of capacity w
        int[][] dp = new int[n + 1][capacity + 1];

        // Fill the DP array
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                // If the weight of the current item is less than or equal to the current capacity w
                if (weights[i - 1] <= w) {
                    // Consider the maximum value by either including or excluding the current item
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    // If the current item's weight is greater than the current capacity, exclude it
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // The bottom-right corner of the DP array contains the maximum value that can be obtained
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        // Example usage
        int[] weights = {1, 3, 4, 5};  // Weights of the items
        int[] values = {1, 4, 5, 7};   // Values of the items
        int capacity = 7;              // Capacity of the knapsack

        // Find and print the maximum value that can be obtained
        System.out.println("Maximum value in knapsack = " + knapsack(weights, values, capacity));
    }
}

