package BitManipulation;

public class SingleNonRepeatedElement {

    // Function to find the single non-repeated element in the array
    public static int findSingleElement(int[] nums) {
        int result = 0; // Initialize result to 0

        // Traverse through all elements in the array
        for (int num : nums) {
            // Use XOR operation to find the unique element
            result = result ^ num;
        }

        return result; // The result will be the single non-repeated element
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = {2, 3, 5, 4, 5, 3, 4};

        // Find and print the single non-repeated element
        System.out.println("The single non-repeated element is: " + findSingleElement(nums));
    }
}

