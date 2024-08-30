package BitManipulation;

public class PowerOfTwo {

    // Function to check if a number is a power of two
    public static boolean isPowerOfTwo(int n) {
        // A power of two must be greater than zero
        if (n <= 0) {
            return false;
        }

        // A number n is a power of two if there is only one bit set in its binary representation
        // We can check this by using the bitwise AND operation: n & (n - 1) should be 0
        // Example: 8 is 1000 in binary, 7 is 0111 in binary, 8 & 7 = 0000
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        // Example usage
        int[] testNumbers = {1, 2, 3, 4, 5, 16, 18, 32, 64};

        // Check and print if each number is a power of two
        for (int n : testNumbers) {
            System.out.println("Is " + n + " a power of two? " + isPowerOfTwo(n));
        }
    }
}

