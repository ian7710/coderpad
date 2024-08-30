package BitManipulation;

public class CountBits {

    // Function to count the number of 1s in the binary representation of an integer
    public static int countOnes(int n) {
        int count = 0; // Initialize the count of 1s to 0

        // Loop until n becomes 0
        while (n != 0) {
            // Perform a bitwise AND between n and (n-1)
            // This operation removes the rightmost 1 in the binary representation of n
            n = n & (n - 1);

            // Increment the count since a 1 was removed
            count++;
        }

        return count; // Return the total count of 1s
    }

    public static void main(String[] args) {
        // Example usage
        int n = 29; // Example integer (binary representation: 11101)

        // Compute and print the number of 1s in the binary representation of n
        System.out.println("Number of 1s in the binary representation of " + n + " is: " + countOnes(n));
    }
}
