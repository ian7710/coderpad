package DynamicProgramming;

public class ClimbStairs {

    // Function to find the number of ways to climb a staircase with n steps
    public static int climbStairs(int n) {
        // Base cases: If there are 0 or 1 steps, there is only 1 way to climb the staircase
        if (n == 0 || n == 1) {
            return 1;
        }

        // Array to store the number of ways to climb to each step
        int[] dp = new int[n + 1];

        // There is 1 way to reach step 0 (do nothing) and 1 way to reach step 1 (one step)
        dp[0] = 1;
        dp[1] = 1;

        // Fill the dp array for all steps from 2 to n
        for (int i = 2; i <= n; i++) {
            // The number of ways to reach step i is the sum of ways to reach step i-1 and step i-2
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return the number of ways to reach step n
        return dp[n];
    }

    public static void main(String[] args) {
        // Example usage
        int n = 5; // Number of steps

        // Find and print the number of ways to climb the staircase
        System.out.println("Number of ways to climb " + n + " steps: " + climbStairs(n));
    }
}

