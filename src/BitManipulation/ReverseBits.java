package BitManipulation;

public class ReverseBits {

    // Function to reverse the bits of a given 32-bit unsigned integer
    public static int reverseBits(int n) {
        int result = 0; // Initialize the result to 0

        // Iterate over all 32 bits of the integer
        for (int i = 0; i < 32; i++) {
            // Shift the result to the left to make room for the next bit
            result <<= 1;

            // Extract the least significant bit of n and add it to result
            result |= (n & 1);

            // Shift n to the right to process the next bit
            n >>= 1;
        }

        return result; // Return the reversed bit integer
    }

    public static void main(String[] args) {
        // Example usage
        int n = 43261596; // Example 32-bit unsigned integer (binary: 00000010100101000001111010011100)

        // Compute and print the reversed bits
        int reversed = reverseBits(n);
        System.out.println("Reversed bits: " + reversed);
    }
}

