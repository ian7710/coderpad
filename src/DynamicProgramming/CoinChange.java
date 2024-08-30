package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {

    // Function to find the minimum number of coins needed to make a given amount
    public static int coinChange(int[] coins, int amount) {
        // Create an array to store the minimum number of coins needed for each amount from 0 to amount
        int[] dp = new int[amount + 1];

        // Initialize the dp array with a large value (amount + 1), which is considered as infinite
        Arrays.fill(dp, amount + 1);

        // Base case: To make amount 0, we need 0 coins
        dp[0] = 0;

        // Iterate over all amounts from 1 to the given amount
        for (int i = 1; i <= amount; i++) {
            // For each coin, check if it can contribute to the current amount i
            for (int coin : coins) {
                if (coin <= i) {
                    // If the coin can contribute, update the dp array to reflect the minimum number of coins needed
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still the large value (amount + 1), it means it's not possible to make the amount
        // Otherwise, dp[amount] will hold the minimum number of coins needed
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        // Example usage
        int[] coins = {1, 2, 5}; // Available coin denominations
        int amount = 11; // Target amount

        // Find and print the minimum number of coins needed to make the given amount
        int result = coinChange(coins, amount);
        System.out.println("Minimum number of coins needed: " + result);
    }
}

