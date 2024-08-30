package BitManipulation;

public class SwapNumbers {

    // Function to swap two numbers without using a temporary variable
    public static void swapUsingAddition(int a, int b) {
        // Print the original values
        System.out.println("Before swap: a = " + a + ", b = " + b);

        // Step 1: Add both numbers and assign the result to 'a'
        a = a + b; // Now a contains the sum of both numbers

        // Step 2: Subtract the new value of 'a' by 'b' to get the original value of 'a'
        b = a - b; // Now b contains the original value of 'a'

        // Step 3: Subtract the new value of 'b' from 'a' to get the original value of 'b'
        a = a - b; // Now a contains the original value of 'b'

        // Print the swapped values
        System.out.println("After swap: a = " + a + ", b = " + b);
    }

    // Main method to demonstrate the swap
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        // Swap using addition and subtraction
        swapUsingAddition(a, b);
    }
}
