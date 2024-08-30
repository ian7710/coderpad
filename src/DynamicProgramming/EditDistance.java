package DynamicProgramming;

public class EditDistance {

    // Function to compute the edit distance between two strings
    public static int computeEditDistance(String word1, String word2) {
        int m = word1.length(); // Length of the first string
        int n = word2.length(); // Length of the second string

        // Create a 2D DP array to store the minimum edit distance for each substring
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the DP array
        // dp[i][0] represents the edit distance between the first i characters of word1 and an empty word2
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // If word2 is empty, we need i deletions to convert word1 to word2
        }

        // dp[0][j] represents the edit distance between an empty word1 and the first j characters of word2
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // If word1 is empty, we need j insertions to convert word1 to word2
        }

        // Fill the DP array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the current characters are the same, no operation is needed, so we take the diagonal value
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If the current characters are different, we consider the minimum cost of the three possible operations:
                    // 1. Insert (dp[i][j-1] + 1)
                    // 2. Delete (dp[i-1][j] + 1)
                    // 3. Replace (dp[i-1][j-1] + 1)
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, // Replace
                            Math.min(dp[i][j - 1] + 1, // Insert
                                    dp[i - 1][j] + 1)); // Delete
                }
            }
        }

        // The value in dp[m][n] is the edit distance between word1 and word2
        return dp[m][n];
    }

    public static void main(String[] args) {
        // Example usage
        String word1 = "kitten";
        String word2 = "sitting";

        // Compute and print the edit distance between the two words
        System.out.println("The edit distance between \"" + word1 + "\" and \"" + word2 + "\" is: " + computeEditDistance(word1, word2));
    }
}
